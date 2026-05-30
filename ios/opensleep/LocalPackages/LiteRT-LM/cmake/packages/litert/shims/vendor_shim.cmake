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


if(VENDOR STREQUAL "MediaTek")
    message(STATUS "[LiteRTLM] MediaTek Shim: Generating Schemas with Global Toolchain...")

    set(FLATC_EXECUTABLE flatc)

    set(_mtk_gen_dir "${CMAKE_CURRENT_BINARY_DIR}/generated/include/litert/vendors/mediatek/schema")
    set(_mtk_schema "${CMAKE_CURRENT_SOURCE_DIR}/mediatek/schema/neuron_schema.fbs")
    set(_mtk_gen_hdr "${_mtk_gen_dir}/neuron_schema_generated.h")

    file(MAKE_DIRECTORY "${_mtk_gen_dir}")

    add_custom_command(
        OUTPUT "${_mtk_gen_hdr}"
        COMMAND flatc --cpp -o "${_mtk_gen_dir}" "${_mtk_schema}"
        DEPENDS "${_mtk_schema}"
        COMMENT "[LiteRTLM] Generating MediaTek schema: ${_mtk_gen_hdr}"
        VERBATIM
    )

    add_custom_target(mediatek_schema_gen DEPENDS "${_mtk_gen_hdr}")
    list(APPEND DISPATCH_SRCS "${CMAKE_CURRENT_SOURCE_DIR}/mediatek/neuron_adapter_api.cc")
endif()