package org.eclipse.californium.core.network.deduplication;

import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.KeyMID;

/* JADX INFO: loaded from: classes5.dex */
public class NoDeduplicator implements Deduplicator {
    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public Exchange find(KeyMID keyMID) {
        return null;
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public Exchange findPrevious(KeyMID keyMID, Exchange exchange) {
        return null;
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public boolean replacePrevious(KeyMID keyMID, Exchange exchange, Exchange exchange2) {
        return true;
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public void setExecutor(ScheduledExecutorService scheduledExecutorService) {
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public int size() {
        return 0;
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public void start() {
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public void stop() {
    }
}
