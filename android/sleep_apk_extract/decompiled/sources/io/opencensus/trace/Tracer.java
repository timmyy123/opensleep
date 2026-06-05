package io.opencensus.trace;

import io.opencensus.common.Scope;
import io.opencensus.internal.Utils;
import io.opencensus.trace.SpanBuilder;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Tracer {
    private static final NoopTracer noopTracer = new NoopTracer();

    public static Tracer getNoopTracer() {
        return noopTracer;
    }

    public final SpanBuilder spanBuilder(String str) {
        return spanBuilderWithExplicitParent(str, CurrentSpanUtils.getCurrentSpan());
    }

    public abstract SpanBuilder spanBuilderWithExplicitParent(String str, @Nullable Span span);

    public final Scope withSpan(Span span) {
        return CurrentSpanUtils.withSpan((Span) Utils.checkNotNull(span, "span"), false);
    }

    public static final class NoopTracer extends Tracer {
        @Override // io.opencensus.trace.Tracer
        public SpanBuilder spanBuilderWithExplicitParent(String str, @Nullable Span span) {
            return SpanBuilder.NoopSpanBuilder.createWithParent(str, span);
        }

        private NoopTracer() {
        }
    }
}
