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
// +build !ignore_autogenerated

// This file was autogenerated by deepcopy-gen. Do not edit it manually!

package v1

import (
	runtime "k8s.io/apimachinery/pkg/runtime"
)

// DeepCopyInto is an autogenerated deepcopy function, copying the receiver, writing into out. in must be non-nil.
func (in *ProjectLimitBySelector) DeepCopyInto(out *ProjectLimitBySelector) {
	*out = *in
	if in.Selector != nil {
		in, out := &in.Selector, &out.Selector
		*out = make(map[string]string, len(*in))
		for key, val := range *in {
			(*out)[key] = val
		}
	}
	if in.MaxProjects != nil {
		in, out := &in.MaxProjects, &out.MaxProjects
		if *in == nil {
			*out = nil
		} else {
			*out = new(int)
			**out = **in
		}
	}
	return
}

// DeepCopy is an autogenerated deepcopy function, copying the receiver, creating a new ProjectLimitBySelector.
func (in *ProjectLimitBySelector) DeepCopy() *ProjectLimitBySelector {
	if in == nil {
		return nil
	}
	out := new(ProjectLimitBySelector)
	in.DeepCopyInto(out)
	return out
}

// DeepCopyInto is an autogenerated deepcopy function, copying the receiver, writing into out. in must be non-nil.
func (in *ProjectRequestLimitConfig) DeepCopyInto(out *ProjectRequestLimitConfig) {
	*out = *in
	out.TypeMeta = in.TypeMeta
	if in.Limits != nil {
		in, out := &in.Limits, &out.Limits
		*out = make([]ProjectLimitBySelector, len(*in))
		for i := range *in {
			(*in)[i].DeepCopyInto(&(*out)[i])
		}
	}
	if in.MaxProjectsForSystemUsers != nil {
		in, out := &in.MaxProjectsForSystemUsers, &out.MaxProjectsForSystemUsers
		if *in == nil {
			*out = nil
		} else {
			*out = new(int)
			**out = **in
		}
	}
	if in.MaxProjectsForServiceAccounts != nil {
		in, out := &in.MaxProjectsForServiceAccounts, &out.MaxProjectsForServiceAccounts
		if *in == nil {
			*out = nil
		} else {
			*out = new(int)
			**out = **in
		}
	}
	return
}

// DeepCopy is an autogenerated deepcopy function, copying the receiver, creating a new ProjectRequestLimitConfig.
func (in *ProjectRequestLimitConfig) DeepCopy() *ProjectRequestLimitConfig {
	if in == nil {
		return nil
	}
	out := new(ProjectRequestLimitConfig)
	in.DeepCopyInto(out)
	return out
}

// DeepCopyObject is an autogenerated deepcopy function, copying the receiver, creating a new runtime.Object.
func (in *ProjectRequestLimitConfig) DeepCopyObject() runtime.Object {
	if c := in.DeepCopy(); c != nil {
		return c
	} else {
		return nil
	}
}
