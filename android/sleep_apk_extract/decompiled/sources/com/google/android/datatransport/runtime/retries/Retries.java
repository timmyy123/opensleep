package com.google.android.datatransport.runtime.retries;

import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Retries {
    public static <TInput, TResult, TException extends Throwable> TResult retry(int i, TInput tinput, Function<TInput, TResult, TException> function, RetryStrategy<TInput, TResult> retryStrategy) {
        TResult tresult;
        if (i < 1) {
            return (TResult) ((CctTransportBackend$$ExternalSyntheticLambda0) function).apply(tinput);
        }
        do {
            tresult = (TResult) ((CctTransportBackend$$ExternalSyntheticLambda0) function).apply(tinput);
            tinput = (TInput) ((CctTransportBackend$$ExternalSyntheticLambda1) retryStrategy).shouldRetry(tinput, tresult);
            if (tinput == null) {
                break;
            }
            i--;
        } while (i >= 1);
        return tresult;
    }
}
