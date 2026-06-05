package io.opencensus.trace;

import io.opencensus.trace.AutoValue_EndSpanOptions;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EndSpanOptions {
    public static final EndSpanOptions DEFAULT = builder().build();

    public static abstract class Builder {
        public abstract EndSpanOptions build();

        public abstract Builder setStatus(Status status);
    }

    public static Builder builder() {
        return new AutoValue_EndSpanOptions.Builder().setSampleToLocalSpanStore(false);
    }

    public abstract boolean getSampleToLocalSpanStore();

    @Nullable
    public abstract Status getStatus();
}
