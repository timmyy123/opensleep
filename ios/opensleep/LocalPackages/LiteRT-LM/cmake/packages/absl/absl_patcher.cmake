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


message(STATUS "[LiteRTLM] Injecting shim into Abseil-cpp root...")

set(SRC_LIST "${ABSL_SRC_DIR}/absl/CMakeLists.txt")
if(EXISTS "${SRC_LIST}")
    file(READ "${SRC_LIST}" SRC_CONTENT)

    string(PREPEND SRC_CONTENT "include(${ABSL_PACKAGE_DIR}/absl_src_shim.cmake)\n")

    file(WRITE "${SRC_LIST}" "${SRC_CONTENT}")
    message(STATUS "[LiteRTLM] Injection successful.")
else()
    message(FATAL_ERROR "Could not find Abseil-cpp CMakeLists.txt at ${SRC_LIST}")
endif()