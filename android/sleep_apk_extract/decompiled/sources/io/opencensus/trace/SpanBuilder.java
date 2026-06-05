package io.opencensus.trace;

import io.opencensus.internal.Utils;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SpanBuilder {

    public static final class NoopSpanBuilder extends SpanBuilder {
        private NoopSpanBuilder(String str) {
            Utils.checkNotNull(str, "name");
        }

        public static NoopSpanBuilder createWithParent(String str, @Nullable Span span) {
            return new NoopSpanBuilder(str);
        }

        @Override // io.opencensus.trace.SpanBuilder
        public SpanBuilder setRecordEvents(boolean z) {
            return this;
        }

        @Override // io.opencensus.trace.SpanBuilder
        public Span startSpan() {
            return BlankSpan.INSTANCE;
        }
    }

    public abstract SpanBuilder setRecordEvents(boolean z);

    public abstract Span startSpan();
}
