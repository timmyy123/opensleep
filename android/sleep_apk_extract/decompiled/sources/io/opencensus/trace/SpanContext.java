package io.opencensus.trace;

import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SpanContext {
    public static final SpanContext INVALID;
    private static final Tracestate TRACESTATE_DEFAULT;
    private final SpanId spanId;
    private final TraceId traceId;
    private final TraceOptions traceOptions;
    private final Tracestate tracestate;

    static {
        Tracestate tracestateBuild = Tracestate.builder().build();
        TRACESTATE_DEFAULT = tracestateBuild;
        INVALID = new SpanContext(TraceId.INVALID, SpanId.INVALID, TraceOptions.DEFAULT, tracestateBuild);
    }

    private SpanContext(TraceId traceId, SpanId spanId, TraceOptions traceOptions, Tracestate tracestate) {
        this.traceId = traceId;
        this.spanId = spanId;
        this.traceOptions = traceOptions;
        this.tracestate = tracestate;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpanContext)) {
            return false;
        }
        SpanContext spanContext = (SpanContext) obj;
        return this.traceId.equals(spanContext.traceId) && this.spanId.equals(spanContext.spanId) && this.traceOptions.equals(spanContext.traceOptions);
    }

    public SpanId getSpanId() {
        return this.spanId;
    }

    public TraceId getTraceId() {
        return this.traceId;
    }

    public TraceOptions getTraceOptions() {
        return this.traceOptions;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.traceId, this.spanId, this.traceOptions});
    }

    public String toString() {
        return "SpanContext{traceId=" + this.traceId + ", spanId=" + this.spanId + ", traceOptions=" + this.traceOptions + "}";
    }
}
