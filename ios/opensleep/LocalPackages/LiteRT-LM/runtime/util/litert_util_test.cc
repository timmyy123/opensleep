// Copyright 2026 The ODML Authors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

#include "runtime/util/litert_util.h"

#include <cstddef>
#include <filesystem>  // NOLINT
#include <functional>
#include <memory>
#include <optional>
#include <string>
#include <utility>

#include <gmock/gmock.h>
#include <gtest/gtest.h>
#include "absl/status/status.h"  // from @com_google_absl
#include "absl/status/statusor.h"  // from @com_google_absl
#include "absl/strings/string_view.h"  // from @com_google_absl
#include "litert/cc/litert_environment.h"  // from @litert
#include "litert/cc/litert_environment_options.h"  // from @litert
#include "litert/cc/litert_model.h"  // from @litert
#include "runtime/components/model_resources.h"
#include "runtime/components/tokenizer.h"
#include "runtime/engine/engine_settings.h"
#include "runtime/executor/executor_settings_base.h"
#include "runtime/util/scoped_file.h"
#include "runtime/util/test_utils.h"  // IWYU pragma: keep

namespace litert::lm {
namespace {

class FakeModelResources : public ModelResources {
 public:
  FakeModelResources() = default;
  ~FakeModelResources() override = default;

  absl::StatusOr<const litert::Model*> GetTFLiteModel(
      ModelType model_type) override {
    return nullptr;
  }

  absl::StatusOr<absl::string_view> GetTFLiteModelBuffer(
      ModelType model_type) override {
    return absl::UnimplementedError("Unimplemented");
  }

  absl::StatusOr<std::reference_wrapper<ScopedFile>> GetScopedFile() override {
    return absl::UnimplementedError("Unimplemented");
  }

  absl::StatusOr<std::pair<size_t, size_t>> GetWeightsSectionOffset(
      ModelType model_type) override {
    return absl::UnimplementedError("Unimplemented");
  }

  std::optional<std::string> GetTFLiteModelBackendConstraint(
      ModelType model_type) override {
    return std::nullopt;
  }

  std::optional<std::string> GetTFLiteModelPreferActivationType(
      ModelType model_type) override {
    return std::nullopt;
  }

  absl::StatusOr<std::unique_ptr<Tokenizer>> GetTokenizer() override {
    return absl::UnimplementedError("Unimplemented");
  }

  absl::StatusOr<const proto::LlmMetadata*> GetLlmMetadata() override {
    return absl::UnimplementedError("Unimplemented");
  }
};

TEST(LiteRtUtilTest, GetEnvironment_CPUGPUFirst_IncludesNPUOptions) {
  auto task_path = std::filesystem::path(::testing::SrcDir()) /
                   "google3/runtime/testdata/"
                   "test_lm_new_metadata.task";
  auto model_assets = ModelAssets::Create(task_path.string());
  ASSERT_OK(model_assets);

  auto cpu_settings =
      EngineSettings::CreateDefault(*model_assets, Backend::CPU);
  ASSERT_OK(cpu_settings);
  cpu_settings->GetMutableMainExecutorSettings().SetLitertDispatchLibDir("");

  FakeModelResources fake_resources;
  auto env_status = GetEnvironment(*cpu_settings, &fake_resources);
  ASSERT_OK(env_status);
  auto& env = *env_status;

  auto options_status = env.GetOptions();
  ASSERT_TRUE(options_status.HasValue());
  const auto& options = *options_status;

  auto dispatch_lib_status =
      options.GetOption(EnvironmentOptions::Tag::kDispatchLibraryDir);
#if defined(__ANDROID__) || defined(__EMSCRIPTEN__)
  ASSERT_TRUE(dispatch_lib_status.HasValue())
      << "kDispatchLibraryDir was not initialized on the Environment singleton "
         "when CPU was used first.";

  auto dispatch_lib_dir = std::get<const char*>(*dispatch_lib_status);
  std::filesystem::path expected_path(task_path.parent_path());
  EXPECT_EQ(std::string(dispatch_lib_dir), expected_path.string());
#else
  ASSERT_FALSE(dispatch_lib_status.HasValue());
#endif
}

TEST(LiteRtUtilTest, GetEnvironment_NPUFirst_IncludesNPUOptions) {
  auto task_path = std::filesystem::path(::testing::SrcDir()) /
                   "google3/runtime/testdata/"
                   "test_lm_new_metadata.task";
  auto model_assets = ModelAssets::Create(task_path.string());
  ASSERT_OK(model_assets);

  auto npu_settings =
      EngineSettings::CreateDefault(*model_assets, Backend::NPU);
  ASSERT_OK(npu_settings);
  npu_settings->GetMutableMainExecutorSettings().SetLitertDispatchLibDir("");

  auto env_status = GetEnvironment(*npu_settings, nullptr);
  ASSERT_OK(env_status);
  auto& env = *env_status;

  auto options_status = env.GetOptions();
  ASSERT_TRUE(options_status.HasValue());
  const auto& options = *options_status;

  auto dispatch_lib_status =
      options.GetOption(EnvironmentOptions::Tag::kDispatchLibraryDir);
#if defined(__ANDROID__) || defined(__EMSCRIPTEN__)
  ASSERT_TRUE(dispatch_lib_status.HasValue())
      << "kDispatchLibraryDir was not initialized when NPU was used first.";

  auto dispatch_lib_dir = std::get<const char*>(*dispatch_lib_status);
  std::filesystem::path expected_path(task_path.parent_path());
  EXPECT_EQ(std::string(dispatch_lib_dir), expected_path.string());
#else
  ASSERT_FALSE(dispatch_lib_status.HasValue());
#endif
}

}  // namespace
}  // namespace litert::lm
