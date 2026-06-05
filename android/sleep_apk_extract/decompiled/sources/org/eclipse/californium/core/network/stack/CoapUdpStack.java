package org.eclipse.californium.core.network.stack;

import org.eclipse.californium.core.network.Outbox;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class CoapUdpStack extends BaseCoapStack {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CoapStack.class);

    public CoapUdpStack(NetworkConfig networkConfig, Outbox outbox) {
        super(outbox);
        setLayers(new Layer[]{createExchangeCleanupLayer(networkConfig), createObserveLayer(networkConfig), createBlockwiseLayer(networkConfig), createReliabilityLayer(networkConfig)});
    }

    public Layer createBlockwiseLayer(NetworkConfig networkConfig) {
        return new BlockwiseLayer(networkConfig);
    }

    public Layer createExchangeCleanupLayer(NetworkConfig networkConfig) {
        return new ExchangeCleanupLayer(networkConfig);
    }

    public Layer createObserveLayer(NetworkConfig networkConfig) {
        return new ObserveLayer(networkConfig);
    }

    public Layer createReliabilityLayer(NetworkConfig networkConfig) {
        if (!networkConfig.getBoolean("USE_CONGESTION_CONTROL")) {
            return new ReliabilityLayer(networkConfig);
        }
        CongestionControlLayer congestionControlLayerNewImplementation = CongestionControlLayer.newImplementation(networkConfig);
        LOGGER.info("Enabling congestion control: {}", congestionControlLayerNewImplementation.getClass().getSimpleName());
        return congestionControlLayerNewImplementation;
    }
}
