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

set(PKG_ROOT ${CMAKE_CURRENT_SOURCE_DIR})
set(RE2_EXT_PREFIX ${EXTERNAL_PROJECT_BINARY_DIR}/re2 CACHE INTERNAL "")
set(RE2_INSTALL_PREFIX ${RE2_EXT_PREFIX}/install CACHE INTERNAL "")
set(RE2_LIB_DIR ${RE2_INSTALL_PREFIX}/lib CACHE INTERNAL "")
set(RE2_INCLUDE_DIR ${RE2_INSTALL_PREFIX}/include CACHE INTERNAL "")
set(RE2_CONFIG_CMAKE_FILE "${RE2_LIB_DIR}/cmake/re2/re2Config.cmake" CACHE INTERNAL "")


set(absl_DIR "${ABSL_INSTALL_PREFIX}/lib/cmake/absl" CACHE PATH "Path to absl config")
set(ABSL_DIR "${ABSL_INSTALL_PREFIX}/lib/cmake/absl" CACHE PATH "Path to absl config")
set(absl_ROOT "${ABSL_INSTALL_PREFIX}" CACHE PATH "absl root dir")
set(ABSL_ROOT "${ABSL_INSTALL_PREFIX}" CACHE PATH "absl root dir")

list(APPEND CMAKE_PREFIX_PATH "${ABSL_INSTALL_PREFIX}")
list(APPEND CMAKE_SYSTEM_PREFIX_PATH "${ABSL_INSTALL_PREFIX}")

set(ABSL_INCLUDE_DIR "${ABSL_INSTALL_PREFIX}/include" CACHE PATH "absl include dir")
set(ABSL_INCLUDE_DIRS "${ABSL_INSTALL_PREFIX}/include" CACHE PATH "absl include dirs")
set(absl_INCLUDE_DIR "${ABSL_INSTALL_PREFIX}/include" CACHE PATH "absl include dir")
set(absl_INCLUDE_DIRS "${ABSL_INSTALL_PREFIX}/include" CACHE PATH "absl include dirs")
set(ABSL_LIBRARY_DIR "${ABSL_INSTALL_PREFIX}/lib" CACHE PATH "absl lib dir")
set(ABSL_LIB_DIR "${ABSL_INSTALL_PREFIX}/lib" CACHE PATH "absl lib dir")
set(absl_LIBRARY_DIR "${ABSL_INSTALL_PREFIX}/lib" CACHE PATH "absl lib dir")


setup_external_install_structure("${RE2_INSTALL_PREFIX}")

if(NOT EXISTS "${RE2_CONFIG_CMAKE_FILE}")
  message(STATUS "RE2 not found. Configuring external build...")
  ExternalProject_Add(
    re2_external
    DEPENDS
      absl_external
    GIT_REPOSITORY
      https://github.com/google/re2/
    GIT_TAG
      main
    PREFIX
      ${RE2_EXT_PREFIX}
    CMAKE_ARGS
      ${LITERTLM_TOOLCHAIN_FILE}
      ${LITERTLM_TOOLCHAIN_ARGS}
      -DCMAKE_PREFIX_PATH=${ABSL_INSTALL_PREFIX}
      -DCMAKE_INSTALL_PREFIX=${RE2_INSTALL_PREFIX}
      -DCMAKE_INSTALL_LIBDIR=lib
      -Dabsl_DIR=${absl_DIR}
      -DABSL_DIR=${ABSL_DIR}
      -Dabsl_ROOT=${absl_ROOT}
      -DABSL_ROOT=${ABSL_ROOT}
      -DABSL_INCLUDE_DIR=${ABSL_INCLUDE_DIR}
      -DABSL_INCLUDE_DIRS=${ABSL_INCLUDE_DIRS}
      -Dabsl_INCLUDE_DIR=${absl_INCLUDE_DIR}
      -Dabsl_INCLUDE_DIRS=${absl_INCLUDE_DIRS}
      -DABSL_LIBRARY_DIR=${ABSL_LIBRARY_DIR}
      -DABSL_LIB_DIR=${ABSL_LIB_DIR}
      -Dabsl_LIBRARY_DIR=${absl_LIBRARY_DIR}
  )

else()
  message(STATUS "RE2 already installed at: ${RE2_INSTALL_PREFIX}")
  if(NOT TARGET re2_external)
    add_custom_target(re2_external)
  endif()
endif()

include(${RE2_PACKAGE_DIR}/re2_aggregate.cmake)
generate_re2_aggregate()