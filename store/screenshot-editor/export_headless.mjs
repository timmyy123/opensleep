// Run the editor's own "Export bundle" for each device in headless Chrome (no background-tab throttling).
// Usage: node export_headless.mjs <outDir> <device> [<device> ...]
//   e.g. node export_headless.mjs ../exports iphone ipad duo-outer android android-7 android-10
// Requires the dev server on http://localhost:3210. Sets project "device" before each export.
import { spawn } from "node:child_process";
import fs from "node:fs";
import os from "node:os";
import path from "node:path";

const CHROME = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
const EDITOR_URL = "http://localhost:3210/";
const PROJECT = path.resolve(path.dirname(new URL(import.meta.url).pathname), "app-store-screenshots.json");
const [outDir, ...devices] = process.argv.slice(2);
const PORT = 9333;
const sleep = (ms) => new Promise((r) => setTimeout(r, ms));

fs.mkdirSync(outDir, { recursive: true });
const profile = fs.mkdtempSync(path.join(os.tmpdir(), "ass-chrome-"));
const chrome = spawn(CHROME, ["--headless=new", `--remote-debugging-port=${PORT}`, `--user-data-dir=${profile}`,
  "--window-size=1680,1050", "--disable-background-timer-throttling", "--disable-renderer-backgrounding", "about:blank"],
  { stdio: "ignore" });

async function target() {
  for (let i = 0; i < 50; i++) {
    try {
      const list = await (await fetch(`http://127.0.0.1:${PORT}/json/list`)).json();
      const page = list.find((t) => t.type === "page");
      if (page) return page.webSocketDebuggerUrl;
    } catch {}
    await sleep(200);
  }
  throw new Error("Chrome did not start");
}

const ws = new WebSocket(await target());
await new Promise((r) => ws.addEventListener("open", r, { once: true }));
let id = 0;
const pending = new Map();
const listeners = [];
ws.addEventListener("message", (ev) => {
  const msg = JSON.parse(ev.data);
  if (msg.id && pending.has(msg.id)) { pending.get(msg.id)(msg); pending.delete(msg.id); }
  else listeners.forEach((fn) => fn(msg));
});
const send = (method, params = {}) => new Promise((r) => { const i = ++id; pending.set(i, r); ws.send(JSON.stringify({ id: i, method, params })); });
const evaluate = async (expr) => (await send("Runtime.evaluate", { expression: expr, awaitPromise: true, returnByValue: true })).result?.result?.value;

await send("Page.enable");
await send("Runtime.enable");
await send("Browser.setDownloadBehavior", { behavior: "allowAndName", downloadPath: path.resolve(outDir), eventsEnabled: true });

for (const device of devices) {
  const state = JSON.parse(fs.readFileSync(PROJECT, "utf8"));
  state.device = device;
  fs.writeFileSync(PROJECT, JSON.stringify(state, null, 2) + "\n");
  // Drop the localStorage mirror so the editor loads the file we just wrote.
  await send("Page.navigate", { url: EDITOR_URL });
  await sleep(4000);
  await evaluate("localStorage.clear()");
  await send("Page.reload", { ignoreCache: true });
  await sleep(8000);

  const done = new Promise((resolve) => {
    const fn = (msg) => {
      if (msg.method === "Browser.downloadProgress" && ["completed", "canceled"].includes(msg.params.state)) {
        listeners.splice(listeners.indexOf(fn), 1);
        resolve(msg.params);
      }
    };
    listeners.push(fn);
  });
  let suggested = "";
  listeners.push((msg) => { if (msg.method === "Browser.downloadWillBegin") suggested = msg.params.suggestedFilename; });

  const clicked = await evaluate(`(() => { const b = [...document.querySelectorAll('button')].find(b => /Export bundle/i.test(b.textContent)); if (!b) return false; b.click(); return true; })()`);
  if (!clicked) { console.log(`${device}: Export button not found`); continue; }
  const t0 = Date.now();
  const progress = setInterval(async () => {
    const label = await evaluate(`[...document.querySelectorAll('button')].map(b => b.textContent).find(t => /Exporting/.test(t)) || ''`);
    if (label) process.stdout.write(`\r${device}: ${label}   `);
  }, 5000);
  const res = await done;
  clearInterval(progress);
  const files = fs.readdirSync(outDir).map((f) => path.join(outDir, f)).sort((a, b) => fs.statSync(b).mtimeMs - fs.statSync(a).mtimeMs);
  const target = path.join(outDir, `${device}.zip`);
  if (res.state === "completed" && files[0]) fs.renameSync(files[0], target);
  console.log(`\n${device}: ${res.state} in ${Math.round((Date.now() - t0) / 1000)}s -> ${target} (${suggested})`);
}

ws.close();
chrome.kill();
fs.rmSync(profile, { recursive: true, force: true });
