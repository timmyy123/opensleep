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


include(${LITERTLM_MODULES_DIR}/utils.cmake)
include(${LITERTLM_MODULES_DIR}/generators/generate_protobuf.cmake)

set(_tflite_shims_dir "${LITERTLM_PACKAGES_DIR}/tflite/shims")
include("${_tflite_shims_dir}/build_tree_shim.cmake")
include(${ABSL_PACKAGE_DIR}/absl_aggregate.cmake)
generate_absl_aggregate()

# --- Protobuf ---
include(${PROTOBUF_PACKAGE_DIR}/protobuf_aggregate.cmake)
generate_protobuf_aggregate()
if(NOT TARGET protobuf::libprotobuf)
    add_library(protobuf::libprotobuf ALIAS LiteRTLM::protobuf::libprotobuf)
endif()
if(NOT TARGET protobuf::protobuf)
    add_library(protobuf::protobuf ALIAS LiteRTLM::protobuf::libprotobuf)
endif()

set(Protobuf_INCLUDE_DIR "${LITERTLM_PROTO_INCLUDE_DIRS}" CACHE INTERNAL "")
set(Protobuf_LIBRARIES LiteRTLM::protobuf::libprotobuf CACHE INTERNAL "")
set(Protobuf_PROTOC_EXECUTABLE "${LITERTLM_PROTOC_EXECUTABLE}" CACHE INTERNAL "")
set(Protobuf_FOUND TRUE CACHE INTERNAL "")
set(PROTOBUF_FOUND TRUE CACHE INTERNAL "")

if(NOT TARGET protobuf::protoc)
    add_executable(protobuf::protoc IMPORTED GLOBAL)
    set_target_properties(protobuf::protoc PROPERTIES
        IMPORTED_LOCATION "${PROTO_PROTOC_EXECUTABLE}"
    )
endif()

# --- Flatbuffers ---
include(${FLATBUFFERS_PACKAGE_DIR}/flatbuffers_aggregate.cmake)
generate_flatbuffers_aggregate()
set(FIXED_FLATC "${FLATC_EXECUTABLE}" CACHE INTERNAL "Forced" FORCE)
set(FLATC_TARGET                 "${FIXED_FLATC}" CACHE INTERNAL "Forced" FORCE)
set(FLATC_BIN                    "${FIXED_FLATC}" CACHE INTERNAL "Forced" FORCE)
set(FLATBUFFERS_FLATC_EXECUTABLE "${FIXED_FLATC}" CACHE INTERNAL "Forced" FORCE)
set(flatbuffers_FLATC_EXECUTABLE "${FIXED_FLATC}" CACHE INTERNAL "Forced" FORCE)
set(TFLITE_HOST_TOOLS_DIR        "${FIXED_FLATC}" CACHE PATH     "Forced" FORCE)
set(FLATC_PATHS                  "${FIXED_FLATC}" CACHE STRING   "Forced" FORCE)
set(flatbuffers_FOUND            TRUE             CACHE INTERNAL "Forced" FORCE)
set(FlatBuffers_FOUND            TRUE             CACHE INTERNAL "Forced" FORCE)

if(NOT TARGET flatbuffers::flatbuffers)
    add_library(flatbuffers::flatbuffers INTERFACE IMPORTED GLOBAL)
    set_target_properties(flatbuffers::flatbuffers PROPERTIES
        INTERFACE_INCLUDE_DIRECTORIES "${FLATBUFFERS_INCLUDE_DIR}"
    )
endif()

if(NOT TARGET flatc)
    add_executable(flatc IMPORTED GLOBAL)
    set_target_properties(flatc PROPERTIES 
        IMPORTED_LOCATION "${FLATC_EXECUTABLE}"
    )
endif()

include_directories(
    ${ABSL_INCLUDE_DIR}
    ${PROTO_INCLUDE_DIR}
    "${PROTO_INSTALL_DIR}/include"
    ${FLATBUFFERS_INCLUDE_DIR}
)

message(STATUS "[LiteRTLM] Injecting missing CMakeLists into profiling/...")

file(GLOB PROFILING_SRCS "${CMAKE_CURRENT_SOURCE_DIR}/profiling/*.cc")
list(FILTER PROFILING_SRCS EXCLUDE REGEX "_test\\.cc$")

set(STATS_CALC_SRC 
    "${TENSORFLOW_SOURCE_DIR}/third_party/xla/xla/tsl/util/stats_calculator.cc")

if(EXISTS "${STATS_CALC_SRC}")
    message(STATUS "[LiteRTLM] Found stats_calculator at: ${STATS_CALC_SRC}")
    list(APPEND PROFILING_SRCS "${STATS_CALC_SRC}")
else()
    set(STATS_CALC_FALLBACK 
        "${TENSORFLOW_SOURCE_DIR}/tensorflow/core/util/stats_calculator.cc")
    if(EXISTS "${STATS_CALC_FALLBACK}")
         list(APPEND PROFILING_SRCS "${STATS_CALC_FALLBACK}")
    else()
         message(FATAL_ERROR "[LiteRT-LM] CRITICAL: Could not find stats_calculator.cc in XLA or Core paths.\nChecked:\n  ${STATS_CALC_SRC}\n  ${STATS_CALC_FALLBACK}")
    endif()
endif()

set(LITERTLM_PROTO_FILES
    "${TFLITE_SRC_DIR}/profiling/proto/profiling_info.proto"
    "${TFLITE_SRC_DIR}/profiling/proto/model_runtime_info.proto"
)

add_library(tflite_profiling STATIC ${PROFILING_SRCS})
generate_protobuf(tflite_profiling ${TENSORFLOW_SOURCE_DIR})

target_link_libraries(tflite_profiling PRIVATE
    LiteRTLM::absl::absl
    LiteRTLM::protobuf::libprotobuf
)

target_include_directories(tflite_profiling PUBLIC
    ${CMAKE_BINARY_DIR}
    ${TENSORFLOW_SOURCE_DIR}
    ${ABSL_INCLUDE_DIR}
    ${PROTOBUF_INCLUDE_DIR}
)

install(TARGETS tflite_profiling
    ARCHIVE DESTINATION lib
)