# Copyright 2026 Google LLC.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.


add_library(litert_cc_options STATIC
    ${CMAKE_CURRENT_SOURCE_DIR}/litert_compiler_options.cc
    ${CMAKE_CURRENT_SOURCE_DIR}/litert_compiler_options.h
)

target_include_directories(litert_cc_options
    PUBLIC
        $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/../..>
        $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/../../..>
        $<BUILD_INTERFACE:${TENSORFLOW_SOURCE_DIR}>
)

target_link_libraries(litert_cc_options
    PUBLIC
        litert_cc_api
        litert_c_options
        LiteRTLM::absl::shim
)
