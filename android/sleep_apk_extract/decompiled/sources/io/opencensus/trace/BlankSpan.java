package io.opencensus.trace;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.opencensus.internal.Utils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class BlankSpan extends Span {
    public static final BlankSpan INSTANCE = new BlankSpan();

    private BlankSpan() {
        super(SpanContext.INVALID, null);
    }

    @Override // io.opencensus.trace.Span
    public void addAnnotation(String str, Map<String, AttributeValue> map) {
        Utils.checkNotNull(str, "description");
        Utils.checkNotNull(map, "attributes");
    }

    @Override // io.opencensus.trace.Span
    public void addMessageEvent(MessageEvent messageEvent) {
        Utils.checkNotNull(messageEvent, "messageEvent");
    }

    @Override // io.opencensus.trace.Span
    public void end(EndSpanOptions endSpanOptions) {
        Utils.checkNotNull(endSpanOptions, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
    }

    @Override // io.opencensus.trace.Span
    public void putAttribute(String str, AttributeValue attributeValue) {
        Utils.checkNotNull(str, SDKConstants.PARAM_KEY);
        Utils.checkNotNull(attributeValue, SDKConstants.PARAM_VALUE);
    }

    public String toString() {
        return "BlankSpan";
    }
}
