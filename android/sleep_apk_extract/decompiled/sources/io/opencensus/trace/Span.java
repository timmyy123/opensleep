package io.opencensus.trace;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import io.opencensus.internal.Utils;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Span {
    private final SpanContext context;
    private final Set<Options> options;
    private static final Map<String, AttributeValue> EMPTY_ATTRIBUTES = Collections.EMPTY_MAP;
    private static final Set<Options> DEFAULT_OPTIONS = Collections.unmodifiableSet(EnumSet.noneOf(Options.class));

    public enum Options {
        RECORD_EVENTS
    }

    public Span(SpanContext spanContext, @Nullable EnumSet<Options> enumSet) {
        this.context = (SpanContext) Utils.checkNotNull(spanContext, IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME);
        Set<Options> setUnmodifiableSet = enumSet == null ? DEFAULT_OPTIONS : Collections.unmodifiableSet(EnumSet.copyOf((EnumSet) enumSet));
        this.options = setUnmodifiableSet;
        Utils.checkArgument(!spanContext.getTraceOptions().isSampled() || setUnmodifiableSet.contains(Options.RECORD_EVENTS), "Span is sampled, but does not have RECORD_EVENTS set.");
    }

    public final void addAnnotation(String str) {
        Utils.checkNotNull(str, "description");
        addAnnotation(str, EMPTY_ATTRIBUTES);
    }

    public abstract void addAnnotation(String str, Map<String, AttributeValue> map);

    public abstract void addMessageEvent(MessageEvent messageEvent);

    public final void end() {
        end(EndSpanOptions.DEFAULT);
    }

    public abstract void end(EndSpanOptions endSpanOptions);

    public final SpanContext getContext() {
        return this.context;
    }

    public abstract void putAttribute(String str, AttributeValue attributeValue);
}
