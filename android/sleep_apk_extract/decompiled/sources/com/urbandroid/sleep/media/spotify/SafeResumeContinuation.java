package com.urbandroid.sleep.media.spotify;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0080\u0004¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u00020\u000eX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/SafeResumeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "resumed", "", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class SafeResumeContinuation<T> implements Continuation<T> {
    private final Continuation<T> continuation;
    private boolean resumed;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeResumeContinuation(Continuation<? super T> continuation) {
        continuation.getClass();
        this.continuation = continuation;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        if (!this.resumed) {
            this.resumed = true;
            this.continuation.resumeWith(result);
        } else {
            Logger.logWarning("already resumed - " + Result.m2364toStringimpl(result), null);
        }
    }
}
