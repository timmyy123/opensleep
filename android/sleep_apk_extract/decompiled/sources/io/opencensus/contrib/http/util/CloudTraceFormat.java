package io.opencensus.contrib.http.util;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedLongs;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.TraceOptions;
import io.opencensus.trace.Tracestate;
import io.opencensus.trace.propagation.TextFormat;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class CloudTraceFormat extends TextFormat {
    static final List<String> FIELDS = Collections.singletonList("X-Cloud-Trace-Context");
    static final TraceOptions OPTIONS_SAMPLED = TraceOptions.builder().setIsSampled(true).build();
    static final TraceOptions OPTIONS_NOT_SAMPLED = TraceOptions.DEFAULT;
    static final int TRACE_OPTION_DELIMITER_SIZE = 3;
    private static final Tracestate TRACESTATE_DEFAULT = Tracestate.builder().build();

    private static long spanIdToLong(SpanId spanId) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.put(spanId.getBytes());
        return byteBufferAllocate.getLong(0);
    }

    @Override // io.opencensus.trace.propagation.TextFormat
    public <C> void inject(SpanContext spanContext, C c, TextFormat.Setter<C> setter) {
        Preconditions.checkNotNull(spanContext, "spanContext");
        Preconditions.checkNotNull(setter, "setter");
        Preconditions.checkNotNull(c, "carrier");
        StringBuilder sb = new StringBuilder();
        sb.append(spanContext.getTraceId().toLowerBase16());
        sb.append('/');
        sb.append(UnsignedLongs.toString(spanIdToLong(spanContext.getSpanId())));
        sb.append(";o=");
        sb.append(spanContext.getTraceOptions().isSampled() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        setter.put(c, "X-Cloud-Trace-Context", sb.toString());
    }
}
