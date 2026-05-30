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

"""Import subcommand for LiteRT-LM CLI."""

import os
import shutil

import click

from litert_lm_cli import common
from litert_lm_cli import help_formatter
from litert_lm_cli import model


@click.command(
    cls=help_formatter.ColorCommand,
    name="import",
    help="""Imports a model from a local path or HuggingFace hub.

  MODEL_FILE: The local path to the model file, or the path in the HuggingFace
  repo if --from-huggingface-repo is set.
  MODEL_REF: The ID to store the model as. Defaults to the filename of
  MODEL_FILE.
  \b
  Examples:
    # Import from a local path
    litert-lm import ./model.litertlm my-model

    # Import from a HuggingFace repository
    litert-lm import --from-huggingface-repo org/repo model.litertlm my-model

    # Import and use the default model ID
    litert-lm import ./model.litertlm""",
)
@common.huggingface_options
@click.argument("model_file")
@click.argument("model_ref", required=False)
def import_model(
    from_huggingface_repo, huggingface_token, model_file, model_ref
):
  """Imports a model from a local path or HuggingFace hub.

  Args:
    from_huggingface_repo: The HuggingFace repository ID.
    huggingface_token: HuggingFace API token.
    model_file: The path in the repo (if from-huggingface-repo is set) or local
      path.
    model_ref: The reference ID to store the model as. Defaults to the filename
      of MODEL_FILE.
  """
  effective_model_ref = model_ref or os.path.basename(model_file)

  if from_huggingface_repo:
    source = common.download_from_huggingface(
        from_huggingface_repo, model_file, huggingface_token
    )
    if not source:
      return
  else:
    source = model_file
    if not os.path.exists(source):
      click.echo(click.style(f"Source file not found: {source}", fg="red"))
      return

  model_obj = model.Model.from_model_id(effective_model_ref)
  model_path = model_obj.model_path
  model_dir = os.path.dirname(model_path)

  os.makedirs(model_dir, exist_ok=True)

  shutil.copy(source, model_path)
  click.echo(
      click.style(f"Successfully imported model to {model_path}", fg="green")
  )
  click.echo(
      click.style(
          "You can now run the model with 'litert-lm run"
          f" {effective_model_ref}'",
          fg="green",
      )
  )


def register(cli: click.Group) -> None:
  """Registers the import command."""
  cli.add_command(import_model)
