/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dockerfile

import (
	"fmt"
	"io"
	"strings"

	"github.com/docker/docker/builder/dockerfile/command"
	"github.com/docker/docker/builder/dockerfile/parser"
)

// Parse parses the provided stream as a canonical Dockerfile
func Parse(r io.Reader) (*parser.Node, error) {
	d := &parser.Directive{}
	if err := parser.SetEscapeToken(parser.DefaultEscapeToken, d); err != nil {
		return nil, err
	}
	return parser.Parse(r, d)
}

// ParseTreeToDockerfile takes a Dockerfile AST node, as generated by
// parser.Parse, and returns a new, equivalent, Dockerfile.
func ParseTreeToDockerfile(node *parser.Node) []byte {
	if node == nil {
		return nil
	}
	buf := []byte(node.Original)
	for _, child := range node.Children {
		buf = append(buf, ParseTreeToDockerfile(child)...)
	}
	// Append a line break when needed.
	if len(buf) > 0 && buf[len(buf)-1] != '\n' {
		buf = append(buf, '\n')
	}
	return buf
}

// FindAll returns the indices of all children of node such that
// node.Children[i].Value == cmd. Valid values for cmd are defined in the
// package github.com/docker/docker/builder/dockerfile/command.
func FindAll(node *parser.Node, cmd string) []int {
	if node == nil {
		return nil
	}
	var indices []int
	for i, child := range node.Children {
		if child != nil && child.Value == cmd {
			indices = append(indices, i)
		}
	}
	return indices
}

// InsertInstructions inserts instructions starting from the pos-th child of
// node, moving other children as necessary. The instructions should be valid
// Dockerfile instructions. InsertInstructions mutates node in-place, and the
// final state of node is equivalent to what parser.Parse would return if the
// original Dockerfile represented by node contained the instructions at the
// specified position pos. If the returned error is non-nil, node is guaranteed
// to be unchanged.
func InsertInstructions(node *parser.Node, pos int, instructions string) error {
	if node == nil {
		return fmt.Errorf("cannot insert instructions in a nil node")
	}
	if pos < 0 || pos > len(node.Children) {
		return fmt.Errorf("pos %d out of range [0, %d]", pos, len(node.Children)-1)
	}
	newChild, err := Parse(strings.NewReader(instructions))
	if err != nil {
		return err
	}
	// InsertVector pattern (https://github.com/golang/go/wiki/SliceTricks)
	node.Children = append(node.Children[:pos], append(newChild.Children, node.Children[pos:]...)...)
	return nil
}

// baseImages takes a Dockerfile root node and returns a list of all base images
// declared in the Dockerfile. Each base image is the argument of a FROM
// instruction.
func baseImages(node *parser.Node) []string {
	var images []string
	for _, pos := range FindAll(node, command.From) {
		images = append(images, nextValues(node.Children[pos])...)
	}
	return images
}

// exposedPorts takes a Dockerfile root node and returns a list of all ports
// exposed in the Dockerfile, grouped by images that this Dockerfile produces.
// The number of port lists returned is the number of images produced by this
// Dockerfile, which is the same as the number of FROM instructions.
func exposedPorts(node *parser.Node) [][]string {
	var allPorts [][]string
	var ports []string
	froms := FindAll(node, command.From)
	exposes := FindAll(node, command.Expose)
	for i, j := len(froms)-1, len(exposes)-1; i >= 0; i-- {
		for ; j >= 0 && exposes[j] > froms[i]; j-- {
			ports = append(nextValues(node.Children[exposes[j]]), ports...)
		}
		allPorts = append([][]string{ports}, allPorts...)
		ports = nil
	}
	return allPorts
}

// nextValues returns a slice of values from the next nodes following node. This
// roughly translates to the arguments to the Docker builder instruction
// represented by node.
func nextValues(node *parser.Node) []string {
	if node == nil {
		return nil
	}
	var values []string
	for next := node.Next; next != nil; next = next.Next {
		values = append(values, next.Value)
	}
	return values
}
