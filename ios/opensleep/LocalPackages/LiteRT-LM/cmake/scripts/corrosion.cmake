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



include(FetchContent)

set(LITERTLM_RUST_FILES "" CACHE INTERNAL "Rust files to include in the cxx bridge")

set(LITERTLM_CARGO_TOML "" CACHE INTERNAL "Path to LiteRT-LM's Cargo.toml")

FetchContent_Declare(
    Corrosion
    GIT_REPOSITORY https://github.com/corrosion-rs/corrosion.git
    GIT_TAG v0.6.1
)

FetchContent_MakeAvailable(Corrosion)

corrosion_import_crate(MANIFEST_PATH "${LITERTLM_CARGO_TOML}")

corrosion_add_cxx_bridge(
    litertlm_cxx_bridge
    FILES "${LITERTLM_RUST_FILES}"
)