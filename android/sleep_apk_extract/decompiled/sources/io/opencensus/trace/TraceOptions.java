package io.opencensus.trace;

import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class TraceOptions {
    public static final TraceOptions DEFAULT = fromByte((byte) 0);
    private final byte options;

    public static final class Builder {
        private byte options;

        private Builder(byte b) {
            this.options = b;
        }

        public TraceOptions build() {
            return TraceOptions.fromByte(this.options);
        }

        public Builder setIsSampled(boolean z) {
            byte b = this.options;
            if (z) {
                this.options = (byte) (b | 1);
                return this;
            }
            this.options = (byte) (b & (-2));
            return this;
        }
    }

    private TraceOptions(byte b) {
        this.options = b;
    }

    public static Builder builder() {
        return new Builder((byte) 0);
    }

    public static TraceOptions fromByte(byte b) {
        return new TraceOptions(b);
    }

    private boolean hasOption(int i) {
        return (this.options & i) != 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof TraceOptions) && this.options == ((TraceOptions) obj).options;
    }

    public int hashCode() {
        return Arrays.hashCode(new byte[]{this.options});
    }

    public boolean isSampled() {
        return hasOption(1);
    }

    public String toString() {
        return "TraceOptions{sampled=" + isSampled() + "}";
    }
}
