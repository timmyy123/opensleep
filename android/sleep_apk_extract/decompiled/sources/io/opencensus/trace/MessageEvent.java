package io.opencensus.trace;

import io.opencensus.internal.Utils;
import io.opencensus.trace.AutoValue_MessageEvent;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MessageEvent extends BaseMessageEvent {

    public static abstract class Builder {
        public abstract MessageEvent build();

        public abstract Builder setCompressedMessageSize(long j);

        public abstract Builder setMessageId(long j);

        public abstract Builder setUncompressedMessageSize(long j);
    }

    public enum Type {
        SENT,
        RECEIVED
    }

    public static Builder builder(Type type, long j) {
        return new AutoValue_MessageEvent.Builder().setType((Type) Utils.checkNotNull(type, "type")).setMessageId(j).setUncompressedMessageSize(0L).setCompressedMessageSize(0L);
    }

    public abstract long getCompressedMessageSize();

    public abstract long getMessageId();

    public abstract Type getType();

    public abstract long getUncompressedMessageSize();
}
