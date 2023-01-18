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
// Copyright 2013 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package ipv6

func (f *icmpv6Filter) accept(typ ICMPType) {
	f.Data[typ>>5] &^= 1 << (uint32(typ) & 31)
}

func (f *icmpv6Filter) block(typ ICMPType) {
	f.Data[typ>>5] |= 1 << (uint32(typ) & 31)
}

func (f *icmpv6Filter) setAll(block bool) {
	for i := range f.Data {
		if block {
			f.Data[i] = 1<<32 - 1
		} else {
			f.Data[i] = 0
		}
	}
}

func (f *icmpv6Filter) willBlock(typ ICMPType) bool {
	return f.Data[typ>>5]&(1<<(uint32(typ)&31)) != 0
}
