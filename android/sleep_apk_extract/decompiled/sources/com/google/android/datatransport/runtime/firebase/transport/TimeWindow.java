package com.google.android.datatransport.runtime.firebase.transport;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeWindow {
    private static final TimeWindow DEFAULT_INSTANCE = new Builder().build();
    private final long end_ms_;
    private final long start_ms_;

    public static final class Builder {
        private long start_ms_ = 0;
        private long end_ms_ = 0;

        public TimeWindow build() {
            return new TimeWindow(this.start_ms_, this.end_ms_);
        }

        public Builder setEndMs(long j) {
            this.end_ms_ = j;
            return this;
        }

        public Builder setStartMs(long j) {
            this.start_ms_ = j;
            return this;
        }
    }

    public TimeWindow(long j, long j2) {
        this.start_ms_ = j;
        this.end_ms_ = j2;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public long getEndMs() {
        return this.end_ms_;
    }

    public long getStartMs() {
        return this.start_ms_;
    }
}
