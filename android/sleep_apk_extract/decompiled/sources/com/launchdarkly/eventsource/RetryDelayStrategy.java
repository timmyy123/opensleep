package com.launchdarkly.eventsource;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RetryDelayStrategy {

    public static class Result {
        private final long delayMillis;
        private final RetryDelayStrategy next;

        public Result(long j, RetryDelayStrategy retryDelayStrategy) {
            this.delayMillis = j;
            this.next = retryDelayStrategy;
        }

        public long getDelayMillis() {
            return this.delayMillis;
        }

        public RetryDelayStrategy getNext() {
            return this.next;
        }
    }

    public static DefaultRetryDelayStrategy defaultStrategy() {
        return DefaultRetryDelayStrategy.INSTANCE;
    }

    public abstract Result apply(long j);
}
