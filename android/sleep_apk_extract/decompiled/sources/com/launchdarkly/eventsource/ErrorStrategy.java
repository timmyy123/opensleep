package com.launchdarkly.eventsource;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ErrorStrategy {

    public enum Action {
        THROW,
        CONTINUE
    }

    public static class Result {
        private final Action action;
        private final ErrorStrategy next;

        public Result(Action action, ErrorStrategy errorStrategy) {
            this.action = action;
            this.next = errorStrategy;
        }

        public Action getAction() {
            return this.action;
        }

        public ErrorStrategy getNext() {
            return this.next;
        }
    }

    public static ErrorStrategy alwaysThrow() {
        return new ErrorStrategy() { // from class: com.launchdarkly.eventsource.ErrorStrategy.1
            @Override // com.launchdarkly.eventsource.ErrorStrategy
            public Result apply(StreamException streamException) {
                return new Result(Action.THROW, null);
            }
        };
    }

    public abstract Result apply(StreamException streamException);
}
