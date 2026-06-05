package com.spotify.protocol.client;

import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PendingResultBase<T> implements PendingResult<T> {
    protected volatile ErrorCallback mErrorCallback;
    protected volatile boolean mIsCanceled;
    protected volatile Result<T> mRecentResult;
    private final CountDownLatch mResultLatch = new CountDownLatch(1);

    @Override // com.spotify.protocol.client.PendingResult
    public Result<T> await(long j, TimeUnit timeUnit) {
        try {
            if (!this.mResultLatch.await(j, timeUnit)) {
                this.mRecentResult = ResultUtils.createErrorResult(new Exception("Result was not delivered on time."));
            }
        } catch (InterruptedException e) {
            this.mRecentResult = ResultUtils.createErrorResult(e);
        }
        return this.mRecentResult;
    }

    public void cancel() {
        this.mIsCanceled = true;
    }

    public void deliverError(Throwable th) {
        this.mRecentResult = ResultUtils.createErrorResult(th);
        this.mResultLatch.countDown();
        if (isCanceled() || this.mErrorCallback == null) {
            return;
        }
        ((LoginFragment$$ExternalSyntheticLambda0) this.mErrorCallback).onError(this.mRecentResult.getError());
    }

    public void deliverResult(Result<T> result) {
        this.mRecentResult = (Result) Coding.checkNotNull(result);
        this.mResultLatch.countDown();
        onResultDelivered();
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public abstract void onResultDelivered();

    public PendingResult<T> setErrorCallback(ErrorCallback errorCallback) {
        this.mErrorCallback = errorCallback;
        if (!isCanceled() && this.mErrorCallback != null && this.mRecentResult != null && this.mRecentResult.getError() != null) {
            ((LoginFragment$$ExternalSyntheticLambda0) this.mErrorCallback).onError(this.mRecentResult.getError());
        }
        return this;
    }
}
