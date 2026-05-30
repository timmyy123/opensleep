# Copyright 2026 The ODML Authors.
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

import json
import pathlib
import threading
from unittest import mock
import urllib.request

from absl.testing import absltest

from litert_lm_cli import model
from litert_lm_cli.commands import openai_handler
from litert_lm_cli.commands import serve_util


class ServeOpenAIIntegrationTest(absltest.TestCase):

  def setUp(self):
    super().setUp()
    # Start the server on a free ephemeral port
    self.server = serve_util.LiteRTLMServer(
        ("localhost", 0), openai_handler.OpenAIHandler
    )
    self.port = self.server.server_port

    self.server_thread = threading.Thread(
        target=self.server.serve_forever, daemon=True
    )
    self.server_thread.start()

    # The real model path provided via 'data' in BUILD
    self.model_path = (
        pathlib.Path(absltest.get_default_test_srcdir())
        / "google3/runtime/e2e_tests/data/gemma3-1b-it-int4.litertlm"
    )

  def tearDown(self):
    self.server.shutdown()
    self.server.server_close()
    self.server_thread.join()
    super().tearDown()

  def test_openai_responses(self):
    self.assertTrue(
        self.model_path.exists(), f"Model not found at {self.model_path}"
    )

    mock_from_id = self.enter_context(
        mock.patch.object(model.Model, "from_model_id", autospec=True)
    )
    mock_from_id.return_value = model.Model(
        model_id="gemma3", model_path=str(self.model_path)
    )

    data = json.dumps({"model": "gemma3", "input": "Say hi"}).encode("utf-8")

    req = urllib.request.Request(
        f"http://localhost:{self.port}/v1/responses",
        data=data,
        headers={"Content-Type": "application/json"},
    )

    with urllib.request.urlopen(req) as response:
      self.assertEqual(response.getcode(), 200)
      res_body = json.loads(response.read().decode("utf-8"))

      resp_id = res_body.get("id", "")
      self.assertStartsWith(resp_id, "resp_")

      output_list = res_body.get("output", [])
      self.assertLen(output_list, 1)
      msg_id = output_list[0].get("id", "")
      text_content = output_list[0].get("content", [{}])[0].get("text", "")
      self.assertNotEmpty(text_content)

      expected_body = {
          "id": resp_id,
          "output": [{
              "id": msg_id,
              "type": "message",
              "role": "assistant",
              "status": "completed",
              "content": [{
                  "type": "output_text",
                  "text": text_content,
                  "annotations": [],
              }],
          }],
      }
      self.assertDictEqual(res_body, expected_body)


if __name__ == "__main__":
  absltest.main()
