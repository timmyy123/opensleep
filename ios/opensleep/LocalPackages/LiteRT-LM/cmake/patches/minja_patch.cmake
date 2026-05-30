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


file(READ ${TARGET_FILE} FILE_CONTENT)

string(REPLACE 
    "find_program(CLANG_TIDY_EXE NAMES \"clang-tidy\")" 
    "" 
    FILE_CONTENT 
    "${FILE_CONTENT}"
)

string(REPLACE 
    "if (CLANG_TIDY_EXE)" 
    "if (FALSE)" 
    FILE_CONTENT 
    "${FILE_CONTENT}"
)

file(WRITE ${TARGET_FILE} "${FILE_CONTENT}")