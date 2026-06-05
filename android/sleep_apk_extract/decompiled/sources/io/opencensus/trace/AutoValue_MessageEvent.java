package io.opencensus.trace;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.opencensus.trace.MessageEvent;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
final class AutoValue_MessageEvent extends MessageEvent {
    private final long compressedMessageSize;
    private final long messageId;
    private final MessageEvent.Type type;
    private final long uncompressedMessageSize;

    public static final class Builder extends MessageEvent.Builder {
        private Long compressedMessageSize;
        private Long messageId;
        private MessageEvent.Type type;
        private Long uncompressedMessageSize;

        @Override // io.opencensus.trace.MessageEvent.Builder
        public MessageEvent build() {
            String strConcat = this.type == null ? " type" : "";
            if (this.messageId == null) {
                strConcat = strConcat.concat(" messageId");
            }
            if (this.uncompressedMessageSize == null) {
                strConcat = strConcat.concat(" uncompressedMessageSize");
            }
            if (this.compressedMessageSize == null) {
                strConcat = strConcat.concat(" compressedMessageSize");
            }
            if (strConcat.isEmpty()) {
                return new AutoValue_MessageEvent(this.type, this.messageId.longValue(), this.uncompressedMessageSize.longValue(), this.compressedMessageSize.longValue());
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("Missing required properties:".concat(strConcat));
            return null;
        }

        @Override // io.opencensus.trace.MessageEvent.Builder
        public MessageEvent.Builder setCompressedMessageSize(long j) {
            this.compressedMessageSize = Long.valueOf(j);
            return this;
        }

        @Override // io.opencensus.trace.MessageEvent.Builder
        public MessageEvent.Builder setMessageId(long j) {
            this.messageId = Long.valueOf(j);
            return this;
        }

        public MessageEvent.Builder setType(MessageEvent.Type type) {
            if (type != null) {
                this.type = type;
                return this;
            }
            Types$$ExternalSyntheticBUOutline0.m$1("Null type");
            return null;
        }

        @Override // io.opencensus.trace.MessageEvent.Builder
        public MessageEvent.Builder setUncompressedMessageSize(long j) {
            this.uncompressedMessageSize = Long.valueOf(j);
            return this;
        }
    }

    private AutoValue_MessageEvent(MessageEvent.Type type, long j, long j2, long j3) {
        this.type = type;
        this.messageId = j;
        this.uncompressedMessageSize = j2;
        this.compressedMessageSize = j3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) obj;
            if (this.type.equals(messageEvent.getType()) && this.messageId == messageEvent.getMessageId() && this.uncompressedMessageSize == messageEvent.getUncompressedMessageSize() && this.compressedMessageSize == messageEvent.getCompressedMessageSize()) {
                return true;
            }
        }
        return false;
    }

    @Override // io.opencensus.trace.MessageEvent
    public long getCompressedMessageSize() {
        return this.compressedMessageSize;
    }

    @Override // io.opencensus.trace.MessageEvent
    public long getMessageId() {
        return this.messageId;
    }

    @Override // io.opencensus.trace.MessageEvent
    public MessageEvent.Type getType() {
        return this.type;
    }

    @Override // io.opencensus.trace.MessageEvent
    public long getUncompressedMessageSize() {
        return this.uncompressedMessageSize;
    }

    public int hashCode() {
        long jHashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        long j = this.messageId;
        long j2 = ((int) (jHashCode ^ (j ^ (j >>> 32)))) * 1000003;
        long j3 = this.uncompressedMessageSize;
        long j4 = this.compressedMessageSize;
        return (int) (((long) (((int) (j2 ^ (j3 ^ (j3 >>> 32)))) * 1000003)) ^ (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MessageEvent{type=");
        sb.append(this.type);
        sb.append(", messageId=");
        sb.append(this.messageId);
        sb.append(", uncompressedMessageSize=");
        sb.append(this.uncompressedMessageSize);
        sb.append(", compressedMessageSize=");
        return FileInsert$$ExternalSyntheticOutline0.m(this.compressedMessageSize, "}", sb);
    }
}
