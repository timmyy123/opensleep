package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Task<TResult> {
    public abstract Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener);

    public abstract Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener);

    public abstract Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener);

    public abstract Task<TResult> addOnFailureListener(OnFailureListener onFailureListener);

    public abstract Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener);

    public abstract Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener);

    public abstract Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener);

    public abstract <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation);

    public abstract <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation);

    public abstract <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation);

    public abstract Exception getException();

    public abstract TResult getResult();

    public abstract boolean isCanceled();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();
}
