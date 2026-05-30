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


include_guard(GLOBAL)

# --- Generated Source Setup ---
set(GEN_C_DIR "${GENERATED_SRC_DIR}/c")
set(GEN_SCHEMA_DIR "${GENERATED_SRC_DIR}/schema")
set(GEN_RUNTIME_DIR "${GENERATED_SRC_DIR}/runtime")

set(ALL_SOURCE_FILES "")
set(ALL_HEADER_FILES "")

file(GLOB_RECURSE C_SRC_FILES "c/*.cc")
file(GLOB_RECURSE C_HDR_FILES "c/*.h")

file(GLOB_RECURSE RUNTIME_SRC_FILES "runtime/*.cc")
file(GLOB_RECURSE RUNTIME_HDR_FILES "runtime/*.h")

file(GLOB_RECURSE SCHEMA_SRC_FILES "schema/*.cc")
file(GLOB_RECURSE SCHEMA_HDR_FILES "schema/*.h")

list(APPEND ALL_SOURCE_FILES ${C_SRC_FILES} ${RUNTIME_SRC_FILES} ${SCHEMA_SRC_FILES})
list(APPEND ALL_HEADER_FILES ${C_HDR_FILES} ${RUNTIME_HDR_FILES} ${SCHEMA_HDR_FILES})