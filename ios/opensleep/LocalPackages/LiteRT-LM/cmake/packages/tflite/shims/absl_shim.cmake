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


if(NOT TARGET LiteRTLM::absl::absl)
    add_library(LiteRTLM::absl::absl INTERFACE IMPORTED GLOBAL)
    set_target_properties(LiteRTLM::absl::absl PROPERTIES
        INTERFACE_LINK_LIBRARIES "${LITERTLM_ABSL_LIBRARIES}"
        INTERFACE_INCLUDE_DIRECTORIES "${LITERTLM_ABSL_INCLUDE_DIRS}"
    )

    set(absl_DIR "${LITERTLM_ABSL_CONFIG_DIR}" CACHE INTERNAL "")
    set(Abseil_FOUND TRUE CACHE INTERNAL "")
endif()