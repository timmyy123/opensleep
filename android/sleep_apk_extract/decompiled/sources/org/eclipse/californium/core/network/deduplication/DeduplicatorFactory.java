package org.eclipse.californium.core.network.deduplication;

import org.eclipse.californium.core.network.config.NetworkConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class DeduplicatorFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) DeduplicatorFactory.class);
    private static DeduplicatorFactory factory;

    public static synchronized DeduplicatorFactory getDeduplicatorFactory() {
        try {
            if (factory == null) {
                factory = new DeduplicatorFactory();
            }
        } catch (Throwable th) {
            throw th;
        }
        return factory;
    }

    public Deduplicator createDeduplicator(NetworkConfig networkConfig) {
        String string = networkConfig.getString("DEDUPLICATOR", "NO_DEDUPLICATOR");
        string.getClass();
        switch (string) {
            case "NO_DEDUPLICATOR":
                return new NoDeduplicator();
            case "DEDUPLICATOR_MARK_AND_SWEEP":
                return new SweepDeduplicator(networkConfig);
            case "DEDUPLICATOR_CROP_ROTATION":
                return new CropRotation(networkConfig);
            case "DEDUPLICATOR_PEERS_MARK_AND_SWEEP":
                return new SweepPerPeerDeduplicator(networkConfig);
            default:
                LOGGER.warn("configuration contains unsupported deduplicator type, duplicate detection will be turned off");
                return new NoDeduplicator();
        }
    }
}
