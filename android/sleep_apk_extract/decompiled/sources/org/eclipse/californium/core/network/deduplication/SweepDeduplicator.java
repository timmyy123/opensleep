package org.eclipse.californium.core.network.deduplication;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.KeyMID;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.elements.util.ClockUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class SweepDeduplicator implements Deduplicator {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) SweepDeduplicator.class);
    Runnable algorithm;
    final long exchangeLifetime;
    private ScheduledExecutorService executor;
    final ConcurrentMap<KeyMID, DedupExchange> incomingMessages = new ConcurrentHashMap();
    private volatile ScheduledFuture<?> jobStatus;
    final boolean replace;
    private final long sweepInterval;

    public static class DedupExchange {
        public final Exchange exchange;
        public final long nanoTimestamp = ClockUtil.nanoRealtime();

        public DedupExchange(Exchange exchange) {
            this.exchange = exchange;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return this.exchange.equals(((DedupExchange) obj).exchange);
            }
            return false;
        }

        public int hashCode() {
            return this.exchange.hashCode();
        }
    }

    public class SweepAlgorithm implements Runnable {
        private SweepAlgorithm() {
        }

        private void sweep() {
            if (SweepDeduplicator.this.incomingMessages.isEmpty()) {
                return;
            }
            long jNanoRealtime = ClockUtil.nanoRealtime();
            long nanos = jNanoRealtime - TimeUnit.MILLISECONDS.toNanos(SweepDeduplicator.this.exchangeLifetime);
            for (Map.Entry<KeyMID, DedupExchange> entry : SweepDeduplicator.this.incomingMessages.entrySet()) {
                if (entry.getValue().nanoTimestamp - nanos < 0) {
                    SweepDeduplicator.LOGGER.trace("Mark-And-Sweep removes {}", entry.getKey());
                    SweepDeduplicator.this.incomingMessages.remove(entry.getKey());
                }
            }
            SweepDeduplicator.LOGGER.debug("Sweep run took {}ms", Long.valueOf((ClockUtil.nanoRealtime() - jNanoRealtime) / 1000000));
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SweepDeduplicator.LOGGER.trace("Start Mark-And-Sweep with {} entries", Integer.valueOf(SweepDeduplicator.this.incomingMessages.size()));
                sweep();
            } catch (Throwable th) {
                SweepDeduplicator.LOGGER.warn("Exception in Mark-and-Sweep algorithm", th);
            }
        }
    }

    public SweepDeduplicator(NetworkConfig networkConfig) {
        this.sweepInterval = networkConfig.getLong("MARK_AND_SWEEP_INTERVAL");
        this.exchangeLifetime = networkConfig.getLong("EXCHANGE_LIFETIME");
        this.replace = networkConfig.getBoolean("DEDUPLICATOR_AUTO_REPLACE");
    }

    public void clear() {
        this.incomingMessages.clear();
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public Exchange find(KeyMID keyMID) {
        DedupExchange dedupExchange = this.incomingMessages.get(keyMID);
        if (dedupExchange == null) {
            return null;
        }
        return dedupExchange.exchange;
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public Exchange findPrevious(KeyMID keyMID, Exchange exchange) {
        DedupExchange dedupExchange = new DedupExchange(exchange);
        DedupExchange dedupExchangePutIfAbsent = this.incomingMessages.putIfAbsent(keyMID, dedupExchange);
        boolean z = false;
        if (this.replace && dedupExchangePutIfAbsent != null && dedupExchangePutIfAbsent.exchange.getOrigin() != exchange.getOrigin()) {
            if (this.incomingMessages.replace(keyMID, dedupExchangePutIfAbsent, dedupExchange)) {
                LOGGER.debug("replace exchange for {}", keyMID);
                z = true;
                dedupExchangePutIfAbsent = null;
            } else {
                dedupExchangePutIfAbsent = this.incomingMessages.putIfAbsent(keyMID, dedupExchange);
            }
        }
        if (dedupExchangePutIfAbsent != null) {
            LOGGER.debug("found exchange for {}", keyMID);
            return dedupExchangePutIfAbsent.exchange;
        }
        LOGGER.debug("add exchange for {}", keyMID);
        onAdd(keyMID, z);
        return null;
    }

    public void onAdd(KeyMID keyMID, boolean z) {
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public boolean replacePrevious(KeyMID keyMID, Exchange exchange, Exchange exchange2) {
        boolean z;
        DedupExchange dedupExchange = new DedupExchange(exchange);
        DedupExchange dedupExchange2 = new DedupExchange(exchange2);
        boolean zReplace = this.incomingMessages.replace(keyMID, dedupExchange, dedupExchange2);
        boolean z2 = true;
        if (zReplace) {
            z = true;
        } else {
            z = false;
            if (this.incomingMessages.putIfAbsent(keyMID, dedupExchange2) != null) {
                z2 = false;
            }
        }
        if (z2) {
            onAdd(keyMID, z);
        }
        return z2;
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public synchronized void setExecutor(ScheduledExecutorService scheduledExecutorService) {
        if (this.jobStatus != null) {
            throw new IllegalStateException("executor service can not be set on running Deduplicator");
        }
        this.executor = scheduledExecutorService;
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public int size() {
        return this.incomingMessages.size();
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public synchronized void start() {
        try {
            if (this.algorithm == null) {
                this.algorithm = new SweepAlgorithm();
            }
            if (this.jobStatus == null) {
                ScheduledExecutorService scheduledExecutorService = this.executor;
                Runnable runnable = this.algorithm;
                long j = this.sweepInterval;
                this.jobStatus = scheduledExecutorService.scheduleAtFixedRate(runnable, j, j, TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public synchronized void stop() {
        if (this.jobStatus != null) {
            this.jobStatus.cancel(false);
            this.jobStatus = null;
            clear();
        }
    }
}
