package io.github.zeroone3010.yahueapi.discovery;

import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes5.dex */
interface HueBridgeDiscoverer {
    CompletableFuture<Void> discoverBridges();
}
