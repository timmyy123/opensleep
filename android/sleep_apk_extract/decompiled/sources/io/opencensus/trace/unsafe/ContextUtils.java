package io.opencensus.trace.unsafe;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import io.grpc.Context;
import io.opencensus.internal.Utils;
import io.opencensus.trace.BlankSpan;
import io.opencensus.trace.Span;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class ContextUtils {
    private static final Context.Key<Span> CONTEXT_SPAN_KEY = Context.key("opencensus-trace-span-key");

    public static Span getValue(Context context) {
        Span span = CONTEXT_SPAN_KEY.get((Context) Utils.checkNotNull(context, IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME));
        return span == null ? BlankSpan.INSTANCE : span;
    }

    public static Context withValue(Context context, @Nullable Span span) {
        return ((Context) Utils.checkNotNull(context, IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME)).withValue(CONTEXT_SPAN_KEY, span);
    }
}
