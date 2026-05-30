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

set(LITERTLM_GENERATORS_DIR "${LITERTLM_MODULES_DIR}/generators" CACHE INTERNAL "")
include("${LITERTLM_GENERATORS_DIR}/generate_protobuf.cmake")
include("${LITERTLM_GENERATORS_DIR}/generate_cxxbridge.cmake")

function(generate_src_files OUTPUT_CLEAN_PATHS)
    set(RAW_FILES ${ARGN})
    set(CLEANED_PATHS_OUT "")

    foreach(RAW_FILE IN ITEMS ${RAW_FILES})
        get_filename_component(FILE_NAME ${RAW_FILE} NAME)
        get_filename_component(FILE_DIR ${RAW_FILE} DIRECTORY)

        file(RELATIVE_PATH REL_PATH "${LITERTLM_PROJECT_ROOT}" "${FILE_DIR}")

        set(GEN_DIR "${GENERATED_SRC_DIR}/${REL_PATH}")
        file(MAKE_DIRECTORY "${GEN_DIR}")

        set(CLEAN_FILE "${GEN_DIR}/${FILE_NAME}")

        if(NOT EXISTS "${RAW_FILE}")
            message(FATAL_ERROR "[LiteRTLM] Source file not found: ${RAW_FILE}")
        endif()
        file(READ "${RAW_FILE}" FILE_CONTENT)

        string(REPLACE "odml/litert_lm/" "" FILE_CONTENT "${FILE_CONTENT}")
        string(REPLACE "odml/litert/" "" FILE_CONTENT "${FILE_CONTENT}")

        file(WRITE "${CLEAN_FILE}" "${FILE_CONTENT}")

        list(APPEND CLEANED_PATHS_OUT "${CLEAN_FILE}")
    endforeach()

    set(${OUTPUT_CLEAN_PATHS} "${CLEANED_PATHS_OUT}" PARENT_SCOPE)
endfunction()


add_litertlm_library(litertlm_generated_protobuf STATIC)
add_dependencies(litertlm_generated_protobuf protobuf_external)

target_include_directories(litertlm_generated_protobuf
  PUBLIC
    ${CMAKE_CURRENT_BINARY_DIR}
    ${LITERTLM_PROJECT_ROOT}
    ${PROTO_SRC_DIR}
    ${PROTO_INCLUDE_DIR}
    ${ABSL_INCLUDE_DIR}
)

target_link_libraries(litertlm_generated_protobuf
  PUBLIC
    protobuf::libprotobuf
    LiteRTLM::absl::absl
)

if(NOT TARGET protobuf::protoc)
    add_executable(protobuf::protoc IMPORTED GLOBAL)
    set_target_properties(protobuf::protoc PROPERTIES
        IMPORTED_LOCATION "${PROTO_PROTOC_EXECUTABLE}"
    )
endif()

generate_protobuf(litertlm_generated_protobuf ${LITERTLM_PROJECT_ROOT})

set(GEN_C_DIR "${GENERATED_SRC_DIR}/c")
set(GEN_SCHEMA_DIR "${GENERATED_SRC_DIR}/schema")
set(GEN_RUNTIME_DIR "${GENERATED_SRC_DIR}/runtime")

set(ALL_SOURCE_FILES "")
set(ALL_HEADER_FILES "")
set(ALL_SCHEMA_FILES "")
set(ALL_RUST_FILES "")

file(GLOB_RECURSE C_SRC_FILES "${LITERTLM_PROJECT_ROOT}/c/*.cc")
file(GLOB_RECURSE C_HDR_FILES "${LITERTLM_PROJECT_ROOT}/c/*.h")

file(GLOB_RECURSE RUNTIME_SRC_FILES "${LITERTLM_PROJECT_ROOT}/runtime/*.cc")
file(GLOB_RECURSE RUNTIME_HDR_FILES "${LITERTLM_PROJECT_ROOT}/runtime/*.h")

file(GLOB_RECURSE SCHEMA_SRC_FILES "${LITERTLM_PROJECT_ROOT}/schema/*.cc")
file(GLOB_RECURSE SCHEMA_HDR_FILES "${LITERTLM_PROJECT_ROOT}/schema/*.h")
file(GLOB_RECURSE SCHEMA_FBS_FILES "${LITERTLM_PROJECT_ROOT}/schema/*.fbs")

file(GLOB_RECURSE RUST_SRC_FILES "${LITERTLM_PROJECT_ROOT}/src/*.rs")
file(GLOB_RECURSE RUST_RUNTIME_SRC_FILES "${LITERTLM_PROJECT_ROOT}/runtime/*.rs")
file(GLOB_RECURSE RUST_TOML_FILES "${LITERTLM_PROJECT_ROOT}/cmake/rust/*.toml")

list(APPEND ALL_SOURCE_FILES ${C_SRC_FILES} ${RUNTIME_SRC_FILES} ${SCHEMA_SRC_FILES})
list(APPEND ALL_HEADER_FILES ${C_HDR_FILES} ${RUNTIME_HDR_FILES} ${SCHEMA_HDR_FILES})
list(APPEND ALL_SCHEMA_FILES ${SCHEMA_FBS_FILES})
list(APPEND ALL_RUST_FILES 
    ${RUST_SRC_FILES} 
    ${RUST_RUNTIME_SRC_FILES} 
    ${RUST_TOML_FILES}
)

set(ALL_GENERATED_OUTPUTS 
    ${C_SRC_FILES}
    ${RUNTIME_SRC_FILES}
    ${SCHEMA_SRC_FILES}
    ${RUST_SRC_FILES})
