package org.eclipse.californium.core.network.deduplication;

import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.KeyMID;

/* JADX INFO: loaded from: classes5.dex */
public interface Deduplicator {
    Exchange find(KeyMID keyMID);

    Exchange findPrevious(KeyMID keyMID, Exchange exchange);

    boolean replacePrevious(KeyMID keyMID, Exchange exchange, Exchange exchange2);

    void setExecutor(ScheduledExecutorService scheduledExecutorService);

    int size();

    void start();

    void stop();
}
