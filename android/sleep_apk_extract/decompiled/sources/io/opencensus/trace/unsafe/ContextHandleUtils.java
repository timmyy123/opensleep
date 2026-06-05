package io.opencensus.trace.unsafe;

import io.opencensus.internal.Provider;
import io.opencensus.trace.ContextHandle;
import io.opencensus.trace.ContextManager;
import io.opencensus.trace.Span;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ContextHandleUtils {
    private static final Logger LOGGER = Logger.getLogger(ContextHandleUtils.class.getName());
    private static final ContextManager CONTEXT_MANAGER = loadContextManager(ContextManager.class.getClassLoader());

    public static ContextHandle currentContext() {
        return CONTEXT_MANAGER.currentContext();
    }

    public static Span getValue(ContextHandle contextHandle) {
        return CONTEXT_MANAGER.getValue(contextHandle);
    }

    private static ContextManager loadContextManager(@Nullable ClassLoader classLoader) {
        try {
            return (ContextManager) Provider.createInstance(Class.forName("io.opentelemetry.opencensusshim.OpenTelemetryContextManager", true, classLoader), ContextManager.class);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.FINE, "Couldn't load full implementation for OpenTelemetry context manager, now loading original implementation.", (Throwable) e);
            return new ContextManagerImpl();
        }
    }

    public static ContextHandle withValue(ContextHandle contextHandle, @Nullable Span span) {
        return CONTEXT_MANAGER.withValue(contextHandle, span);
    }
}
