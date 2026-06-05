package io.opencensus.trace;

import io.opencensus.common.Scope;
import io.opencensus.trace.unsafe.ContextHandleUtils;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
abstract class CurrentSpanUtils {

    public static final class ScopeInSpan implements Scope {
        private final boolean endSpan;
        private final ContextHandle origContext;
        private final Span span;

        private ScopeInSpan(Span span, boolean z) {
            this.span = span;
            this.endSpan = z;
            this.origContext = ContextHandleUtils.withValue(ContextHandleUtils.currentContext(), span).attach();
        }

        @Override // io.opencensus.common.Scope, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            ContextHandleUtils.currentContext().detach(this.origContext);
            if (this.endSpan) {
                this.span.end();
            }
        }
    }

    @Nullable
    public static Span getCurrentSpan() {
        return ContextHandleUtils.getValue(ContextHandleUtils.currentContext());
    }

    public static Scope withSpan(Span span, boolean z) {
        return new ScopeInSpan(span, z);
    }
}
