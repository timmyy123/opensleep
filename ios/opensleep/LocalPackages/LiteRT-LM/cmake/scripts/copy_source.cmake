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



set(JSON_CONFIG_FILE "" CACHE INTERNAL "JSON file defining the source and destination file paths")


if(NOT EXISTS ${JSON_CONFIG_FILE})
    message(FATAL_ERROR "[LiteRTLM] Patch config not found: ${JSON_CONFIG_FILE}")
endif()

file(READ "${JSON_CONFIG_FILE}" JSON_CONTENT)

string(JSON FILE_COUNT LENGTH "${JSON_CONTENT}" "files")
math(EXPR STOP_IDX "${FILE_COUNT} - 1")

foreach(IDX RANGE ${STOP_IDX})
    string(JSON SRC_RAW GET "${JSON_CONTENT}" "files" ${IDX} "src_path")
    string(JSON DEST_RAW GET "${JSON_CONTENT}" "files" ${IDX} "dest_path")

    string(CONFIGURE "${SRC_RAW}" SRC_PATH)
    string(CONFIGURE "${DEST_RAW}" DEST_PATH)

    if(NOT EXISTS "${SRC_PATH}")
        message(FATAL_ERROR "[LiteRTLM] Source file missing: ${SRC_PATH}")
    endif()

    message(STATUS "Copying: ${SRC_PATH} -> ${DEST_PATH}")

    file(READ "${SRC_PATH}" FILE_CONTENT)

    string(REPLACE
        "litert/cc/internal/scoped_file.h"
        "runtime/util/scoped_file.h"
        FILE_CONTENT "${FILE_CONTENT}"
    )

    file(WRITE "${DEST_PATH}" "${FILE_CONTENT}")

    message(STATUS "[LiteRTLM] Line-patched and Copied: ${DEST_PATH}")

endforeach()