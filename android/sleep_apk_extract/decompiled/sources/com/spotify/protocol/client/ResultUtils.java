package com.spotify.protocol.client;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ResultUtils {

    public static class ErrorResult<T> implements Result<T> {
        private final Throwable mError;

        public ErrorResult(Throwable th) {
            this.mError = th;
        }

        @Override // com.spotify.protocol.client.Result
        @Nullable
        public T getData() {
            return null;
        }

        @Override // com.spotify.protocol.client.Result
        public Throwable getError() {
            return this.mError;
        }

        @Override // com.spotify.protocol.client.Result
        public boolean isSuccessful() {
            return false;
        }
    }

    public static class SuccessfulResult<T> implements Result<T> {
        private final T mPayload;

        public SuccessfulResult(T t) {
            this.mPayload = t;
        }

        @Override // com.spotify.protocol.client.Result
        public T getData() {
            return this.mPayload;
        }

        @Override // com.spotify.protocol.client.Result
        @Nullable
        public Throwable getError() {
            return null;
        }

        @Override // com.spotify.protocol.client.Result
        public boolean isSuccessful() {
            return true;
        }
    }

    public static <T> Result<T> createErrorResult(Throwable th) {
        return new ErrorResult(th);
    }

    public static <T> Result<T> createSuccessfulResult(T t) {
        return new SuccessfulResult(t);
    }
}
