package org.eclipse.californium.core.network.stack;

import org.eclipse.californium.core.network.config.NetworkConfig;

/* JADX INFO: loaded from: classes5.dex */
public class ReliabilityLayerParameters {
    private final float ackRandomFactor;
    private final int ackTimeout;
    private final float ackTimeoutScale;
    private final int maxRetransmit;
    private final int nstart;

    public ReliabilityLayerParameters(int i, float f, float f2, int i2, int i3) {
        this.ackTimeout = i;
        this.ackRandomFactor = f;
        this.ackTimeoutScale = f2;
        this.maxRetransmit = i2;
        this.nstart = i3;
    }

    public static Builder builder() {
        return new Builder();
    }

    public float getAckRandomFactor() {
        return this.ackRandomFactor;
    }

    public int getAckTimeout() {
        return this.ackTimeout;
    }

    public float getAckTimeoutScale() {
        return this.ackTimeoutScale;
    }

    public int getMaxRetransmit() {
        return this.maxRetransmit;
    }

    public int getNstart() {
        return this.nstart;
    }

    public static final class Builder {
        private float ackRandomFactor;
        private int ackTimeout;
        private float ackTimeoutScale;
        private int maxRetransmit;
        private int nstart;

        public Builder applyConfig(NetworkConfig networkConfig) {
            this.ackTimeout = networkConfig.getInt("ACK_TIMEOUT");
            this.ackRandomFactor = networkConfig.getFloat("ACK_RANDOM_FACTOR");
            this.ackTimeoutScale = networkConfig.getFloat("ACK_TIMEOUT_SCALE");
            this.maxRetransmit = networkConfig.getInt("MAX_RETRANSMIT");
            this.nstart = networkConfig.getInt("NSTART");
            return this;
        }

        public ReliabilityLayerParameters build() {
            return new ReliabilityLayerParameters(this.ackTimeout, this.ackRandomFactor, this.ackTimeoutScale, this.maxRetransmit, this.nstart);
        }

        private Builder() {
        }
    }
}
