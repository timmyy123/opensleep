package org.eclipse.californium.core.network.deduplication;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.KeyMID;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class CropRotation implements Deduplicator {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CropRotation.class);
    private ScheduledExecutorService executor;
    private volatile ScheduledFuture<?> jobStatus;
    private final ExchangeMap[] maps;
    private final long period;
    private final boolean replace;
    private final Rotation rotation;
    private volatile int first = 0;
    private volatile int second = 1;

    public static class ExchangeMap extends ConcurrentHashMap<KeyMID, Exchange> {
        private static final long serialVersionUID = 1504940670839294042L;

        private ExchangeMap() {
        }
    }

    public class Rotation implements Runnable {
        private Rotation() {
        }

        private void rotation() {
            synchronized (CropRotation.this.maps) {
                int i = CropRotation.this.first;
                CropRotation cropRotation = CropRotation.this;
                cropRotation.first = cropRotation.second;
                CropRotation cropRotation2 = CropRotation.this;
                cropRotation2.second = (cropRotation2.second + 1) % 3;
                CropRotation.this.maps[i].clear();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                rotation();
            } catch (Throwable th) {
                CropRotation.LOGGER.warn("Exception in Crop-Rotation algorithm", th);
            }
        }
    }

    public CropRotation(NetworkConfig networkConfig) {
        this.rotation = new Rotation();
        this.maps = new ExchangeMap[]{new ExchangeMap(), new ExchangeMap(), new ExchangeMap()};
        this.period = networkConfig.getLong("CROP_ROTATION_PERIOD");
        this.replace = networkConfig.getBoolean("DEDUPLICATOR_AUTO_REPLACE");
    }

    public void clear() {
        synchronized (this.maps) {
            this.maps[0].clear();
            this.maps[1].clear();
            this.maps[2].clear();
        }
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public Exchange find(KeyMID keyMID) {
        int i = this.first;
        int i2 = this.second;
        Exchange exchange = this.maps[i2].get(keyMID);
        return (exchange != null || i == i2) ? exchange : this.maps[i].get(keyMID);
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public Exchange findPrevious(KeyMID keyMID, Exchange exchange) {
        int i = this.first;
        int i2 = this.second;
        Exchange exchangePutIfAbsent = this.maps[i].putIfAbsent(keyMID, exchange);
        if (exchangePutIfAbsent != null || i == i2) {
            return exchangePutIfAbsent;
        }
        Exchange exchangePutIfAbsent2 = this.maps[i2].putIfAbsent(keyMID, exchange);
        if (!this.replace || exchangePutIfAbsent2 == null || exchangePutIfAbsent2.getOrigin() == exchange.getOrigin()) {
            return exchangePutIfAbsent2;
        }
        LOGGER.debug("replace exchange for {}", keyMID);
        if (this.maps[i2].replace(keyMID, exchangePutIfAbsent2, exchange)) {
            return null;
        }
        return this.maps[i2].putIfAbsent(keyMID, exchange);
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public boolean replacePrevious(KeyMID keyMID, Exchange exchange, Exchange exchange2) {
        int i = this.second;
        return this.maps[i].replace(keyMID, exchange, exchange2) || this.maps[i].putIfAbsent(keyMID, exchange2) == null;
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
        int size;
        synchronized (this.maps) {
            size = this.maps[0].size() + this.maps[1].size() + this.maps[2].size();
        }
        return size;
    }

    @Override // org.eclipse.californium.core.network.deduplication.Deduplicator
    public synchronized void start() {
        if (this.jobStatus == null) {
            ScheduledExecutorService scheduledExecutorService = this.executor;
            Rotation rotation = this.rotation;
            long j = this.period;
            this.jobStatus = scheduledExecutorService.scheduleAtFixedRate(rotation, j, j, TimeUnit.MILLISECONDS);
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
