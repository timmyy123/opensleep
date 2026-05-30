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

"""Shared core utilities for managing LiteRT-LM serving lifecycles."""

from __future__ import annotations

import http.server
import io

import click

import litert_lm
from litert_lm_builder import litertlm_peek
from litert_lm_cli import model


class LiteRTLMServer(http.server.HTTPServer):
  """Custom HTTP server tracking persistent LiteRT-LM engine lifecycles."""

  def __init__(
      self,
      server_address: tuple[str, int],
      RequestHandlerClass: type[http.server.BaseHTTPRequestHandler],
  ):
    super().__init__(server_address, RequestHandlerClass)
    self.litert_lm_engine: litert_lm.Engine | None = None
    self.model_id: str | None = None


def _select_backend(model_path: str) -> litert_lm.Backend:
  """Inspects the .litertlm file metadata to select the appropriate execution backend.

  Args:
    model_path: The absolute filesystem path to the .litertlm model bundle.

  Returns:
    Backend.GPU() if the model metadata specifies 'gpu_artisan' as the backend
    constraint, otherwise Backend.CPU().
  """
  try:
    dummy_out = io.StringIO()
    metadata = litertlm_peek.read_litertlm_header(model_path, dummy_out)
    section_metadata = metadata.SectionMetadata()
    if not section_metadata:
      return litert_lm.Backend.CPU()
    for i in range(section_metadata.ObjectsLength()):
      section = section_metadata.Objects(i)
      if not section or section.ItemsLength() == 0:
        continue
      for j in range(section.ItemsLength()):
        item_dict = litertlm_peek.kvp_to_dict(section.Items(j))
        if item_dict.get("key") != "backend_constraint":
          continue
        val = item_dict.get("value")
        if isinstance(val, str) and val.lower() == "gpu_artisan":
          return litert_lm.Backend.GPU()
  except Exception as e:  # pylint: disable=broad-exception-caught
    click.echo(
        click.style(f"Failed to inspect model metadata: {e!r}", fg="yellow")
    )
  return litert_lm.Backend.CPU()


def get_or_initialize_server_engine(
    server: LiteRTLMServer, model_id: str
) -> litert_lm.Engine:
  """Retrieves the persistent server engine or initializes it on first request.

  Lifetime Management:
  The LiteRT-LM Engine is a globally scoped persistent resource attached
  directly to explicit runtime properties on the custom server context object.
  - Initialization: Invokes `__enter__` dynamically upon the arrival of the
    first incoming inference request.
  - Termination: The running server's parent execution process is responsible
    for explicitly invoking `__exit__` on `server.litert_lm_engine` during outer
    context teardown loops (e.g., in `run_server` finally blocks).

  Args:
    server: The active custom LiteRTLMServer instance object.
    model_id: The requested model identifier string.

  Returns:
    The shared LiteRT-LM Engine context object.

  Raises:
    FileNotFoundError: If the model package path does not exist.
    RuntimeError: If a different model ID is requested after initialization.
  """
  if server.litert_lm_engine is not None:
    # TODO: b/513076049 - support multiple engines.
    if server.model_id != model_id:
      raise RuntimeError(
          f"Server already initialized with model {server.model_id!r}. "
          f"Switching to {model_id!r} is not supported."
      )
    return server.litert_lm_engine

  m = model.Model.from_model_id(model_id)
  if not m.exists():
    raise FileNotFoundError(f"Model {model_id} not found")

  click.echo(
      click.style(f"Initializing engine for model: {m.model_path}", fg="cyan")
  )
  backend = _select_backend(m.model_path)
  engine = litert_lm.Engine(m.model_path, backend=backend)
  engine.__enter__()
  server.litert_lm_engine = engine
  server.model_id = model_id
  return engine
