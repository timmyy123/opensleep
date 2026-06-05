package io.opencensus.trace;

import io.opencensus.trace.export.ExportComponent;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TraceComponent {

    public static final class NoopTraceComponent extends TraceComponent {
        private final ExportComponent noopExportComponent;

        private NoopTraceComponent() {
            this.noopExportComponent = ExportComponent.newNoopExportComponent();
        }

        @Override // io.opencensus.trace.TraceComponent
        public ExportComponent getExportComponent() {
            return this.noopExportComponent;
        }

        @Override // io.opencensus.trace.TraceComponent
        public Tracer getTracer() {
            return Tracer.getNoopTracer();
        }
    }

    public static TraceComponent newNoopTraceComponent() {
        return new NoopTraceComponent();
    }

    public abstract ExportComponent getExportComponent();

    public abstract Tracer getTracer();
}
