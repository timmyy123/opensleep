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


include(ExternalProject)

set(OPENCL_EXT_PREFIX ${EXTERNAL_PROJECT_BINARY_DIR}/opencl_headers)
set(OPENCL_SRC_DIR ${OPENCL_EXT_PREFIX}/src/opencl_headers_external)
set(OPENCL_INCLUDE_DIR ${OPENCL_SRC_DIR} CACHE INTERNAL "" FORCE)

ExternalProject_Add(
  opencl_headers_external
  GIT_REPOSITORY https://github.com/KhronosGroup/OpenCL-Headers.git
  GIT_TAG        v2024.05.08
  PREFIX         ${OPENCL_EXT_PREFIX}
  CONFIGURE_COMMAND ""
  BUILD_COMMAND     ""
  INSTALL_COMMAND   ""
  GIT_SHALLOW       TRUE
)

add_library(opencl_headers_lib INTERFACE)
add_dependencies(opencl_headers_lib opencl_headers_external)
target_include_directories(opencl_headers_lib SYSTEM INTERFACE ${OPENCL_INCLUDE_DIR})