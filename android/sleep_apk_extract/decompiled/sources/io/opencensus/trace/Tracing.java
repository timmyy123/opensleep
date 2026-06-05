package io.opencensus.trace;

import io.opencensus.internal.Provider;
import io.opencensus.trace.export.ExportComponent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Tracing {
    private static final Logger logger = Logger.getLogger(Tracing.class.getName());
    private static final TraceComponent traceComponent = loadTraceComponent(TraceComponent.class.getClassLoader());

    public static ExportComponent getExportComponent() {
        return traceComponent.getExportComponent();
    }

    public static Tracer getTracer() {
        return traceComponent.getTracer();
    }

    public static TraceComponent loadTraceComponent(@Nullable ClassLoader classLoader) {
        try {
            return (TraceComponent) Provider.createInstance(Class.forName("io.opentelemetry.opencensusshim.OpenTelemetryTraceComponentImpl", true, classLoader), TraceComponent.class);
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Couldn't load full implementation for OpenTelemetry TraceComponent, now trying to load original implementation.", (Throwable) e);
            try {
                return (TraceComponent) Provider.createInstance(Class.forName("io.opencensus.impl.trace.TraceComponentImpl", true, classLoader), TraceComponent.class);
            } catch (ClassNotFoundException e2) {
                logger.log(Level.FINE, "Couldn't load full implementation for TraceComponent, now trying to load lite implementation.", (Throwable) e2);
                try {
                    return (TraceComponent) Provider.createInstance(Class.forName("io.opencensus.impllite.trace.TraceComponentImplLite", true, classLoader), TraceComponent.class);
                } catch (ClassNotFoundException e3) {
                    logger.log(Level.FINE, "Couldn't load lite implementation for TraceComponent, now using default implementation for TraceComponent.", (Throwable) e3);
                    return TraceComponent.newNoopTraceComponent();
                }
            }
        }
    }
}
