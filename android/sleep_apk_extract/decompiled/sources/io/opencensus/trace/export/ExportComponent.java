package io.opencensus.trace.export;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExportComponent {

    public static final class NoopExportComponent extends ExportComponent {
        private final SampledSpanStore noopSampledSpanStore;

        private NoopExportComponent() {
            this.noopSampledSpanStore = SampledSpanStore.newNoopSampledSpanStore();
        }

        @Override // io.opencensus.trace.export.ExportComponent
        public SampledSpanStore getSampledSpanStore() {
            return this.noopSampledSpanStore;
        }
    }

    public static ExportComponent newNoopExportComponent() {
        return new NoopExportComponent();
    }

    public abstract SampledSpanStore getSampledSpanStore();
}
