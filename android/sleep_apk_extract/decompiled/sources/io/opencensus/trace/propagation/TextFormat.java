package io.opencensus.trace.propagation;

import io.opencensus.internal.Utils;
import io.opencensus.trace.SpanContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TextFormat {
    private static final NoopTextFormat NOOP_TEXT_FORMAT = new NoopTextFormat();

    public static abstract class Setter<C> {
        public abstract void put(C c, String str, String str2);
    }

    public abstract <C> void inject(SpanContext spanContext, C c, Setter<C> setter);

    public static final class NoopTextFormat extends TextFormat {
        @Override // io.opencensus.trace.propagation.TextFormat
        public <C> void inject(SpanContext spanContext, C c, Setter<C> setter) {
            Utils.checkNotNull(spanContext, "spanContext");
            Utils.checkNotNull(c, "carrier");
            Utils.checkNotNull(setter, "setter");
        }

        private NoopTextFormat() {
        }
    }
}
