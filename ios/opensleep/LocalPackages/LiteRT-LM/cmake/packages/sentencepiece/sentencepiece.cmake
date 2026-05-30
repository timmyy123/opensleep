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

set(SENTENCE_EXT_PREFIX ${EXTERNAL_PROJECT_BINARY_DIR}/sentencepiece CACHE INTERNAL "")
set(SENTENCE_INSTALL_PREFIX ${SENTENCE_EXT_PREFIX}/install CACHE INTERNAL "")
set(SENTENCE_SRC_DIR ${SENTENCE_EXT_PREFIX}/src/sentencepiece_external CACHE INTERNAL "")
set(SENTENCE_INCLUDE_DIR ${SENTENCE_INSTALL_PREFIX}/include CACHE INTERNAL "")
set(SENTENCE_BUILD_DIR "${SENTENCE_EXT_PREFIX}/src/sentencepiece_external-build" CACHE INTERNAL "")
set(SENTENCE_INCLUDE_PATHS
  ${SENTENCE_INCLUDE_DIR}
  "${SENTENCE_BUILD_DIR}/src"
  CACHE INTERNAL ""
)

if(EXISTS "${SENTENCE_INSTALL_PREFIX}/lib64")
  set(SENTENCE_LIB_DIR "${SENTENCE_INSTALL_PREFIX}/lib64")
else()
  set(SENTENCE_LIB_DIR "${SENTENCE_INSTALL_PREFIX}/lib")
endif()

set(SENTENCE_LIBRARY_STATIC "${SENTENCE_LIB_DIR}/libsentencepiece.a" CACHE INTERNAL "")
set(SENTENCE_LIBRARY_TRAIN  "${SENTENCE_LIB_DIR}/libsentencepiece_train.a" CACHE INTERNAL "")

setup_external_install_structure("${SENTENCE_INSTALL_PREFIX}")

if(NOT EXISTS "${SENTENCE_LIBRARY_STATIC}")
  message(STATUS "SentencePiece not found. Configuring external build...")

  ExternalProject_Add(
    sentencepiece_external
    DEPENDS
      absl_external
      protobuf_external
    GIT_REPOSITORY https://github.com/google/sentencepiece.git
    GIT_TAG        f2219b53e24ff5deee4cacdc2d0ca3074e529a07
    PREFIX         ${SENTENCE_EXT_PREFIX}

    PATCH_COMMAND
      git checkout -- . && git clean -df
      COMMAND ${CMAKE_COMMAND}
        -DSENTENCE_SRC_DIR=${SENTENCE_SRC_DIR}
        -DSENTENCE_ROOT_SHIM_PATH="${SENTENCEPIECE_PACKAGE_DIR}/sentencepiece_root_shim.cmake"
        -DSENTENCE_SRC_SHIM_PATH="${SENTENCEPIECE_PACKAGE_DIR}/sentencepiece_src_shim.cmake"
        -DABSL_INCLUDE_DIR=${ABSL_INCLUDE_DIR}
        -DPROTO_INCLUDE_DIR=${PROTO_INCLUDE_DIR}
        -DPROTO_PROTOC_EXECUTABLE=${PROTO_PROTOC_EXECUTABLE}
        -P "${SENTENCEPIECE_PACKAGE_DIR}/sentencepiece_patcher.cmake"

    CMAKE_ARGS
      ${LITERTLM_TOOLCHAIN_FILE}
      ${LITERTLM_TOOLCHAIN_ARGS}
      -DCMAKE_INSTALL_PREFIX=${SENTENCE_INSTALL_PREFIX}
      -DCMAKE_INSTALL_LIBDIR=lib
      -DCMAKE_BUILD_TYPE=${CMAKE_BUILD_TYPE}
      -DCMAKE_POLICY_VERSION_MINIMUM=3.5
      -DCMAKE_CXX_STANDARD=${CMAKE_CXX_STANDARD}
      -DCMAKE_CXX_STANDARD_REQUIRED=ON
      -DCMAKE_POSITION_INDEPENDENT_CODE=ON
      -DCMAKE_PREFIX_PATH="${ABSL_INSTALL_PREFIX};${PROTO_INSTALL_PREFIX}"

      -DSPM_ABSL_PROVIDER=package
      -DSPM_PROTOBUF_PROVIDER=package
      -DSPM_ENABLE_SHARED=OFF
      -DSPM_ENABLE_TCMALLOC=OFF

      -Dabsl_DIR=${ABSL_INSTALL_PREFIX}/lib/cmake/absl
      -DABSL_INCLUDE_DIRS=${ABSL_INCLUDE_DIR}
      -DABSL_INCLUDE_DIR=${ABSL_INCLUDE_DIR}
      -DABSL_SRC_DIR=${ABSL_SRC_DIR}
      -DABSL_LIB_DIR=${ABSL_LIB_DIR}
      -DABSL_PACKAGE_DIR=${ABSL_PACKAGE_DIR}

      -DProtobuf_DIR=${PROTO_INSTALL_PREFIX}/lib/cmake/protobuf
      -DProtobuf_LIBRARIES=${PROTO_LIB_DIR}
      -DProtobuf_INCLUDE_DIR=${PROTO_INCLUDE_DIR}
      -DProtobuf_PROTOC_EXECUTABLE=${PROTO_PROTOC_EXECUTABLE}
      -DProtobuf_LITE_LIBRARY=${PROTO_LIB_DIR}/libprotobuf.a
      -DProtobuf_PROTOC_LIBRARY_DEBUG=${PROTO_LIB_DIR}/libprotoc.a
      -DProtobuf_PROTOC_LIBRARY_RELEASE=${PROTO_LIB_DIR}/libprotoc.a
      -DPROTO_PROTOC_EXECUTABLE=${PROTO_PROTOC_EXECUTABLE}
      -DPROTO_INCLUDE_DIR=${PROTO_INCLUDE_DIR}
      -DPROTOBUF_PACKAGE_DIR=${PROTOBUF_PACKAGE_DIR}
      -DPROTO_LIB_DIR=${PROTO_LIB_DIR}
      -DPROTO_SRC_DIR=${PROTO_SRC_DIR}

      -DLITERTLM_MODULES_DIR=${LITERTLM_MODULES_DIR}

    STEP_TARGETS install
  )
else()
  if(NOT TARGET sentencepiece_external)
    add_custom_target(sentencepiece_external)
  endif()
endif()

include(${SENTENCEPIECE_PACKAGE_DIR}/sentencepiece_aggregate.cmake)
generate_sentencepiece_aggregate()
