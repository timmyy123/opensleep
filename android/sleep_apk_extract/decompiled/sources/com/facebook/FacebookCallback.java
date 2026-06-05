package com.facebook;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/facebook/FacebookCallback;", "RESULT", "", "onCancel", "", "onError", "error", "Lcom/facebook/FacebookException;", "onSuccess", "result", "(Ljava/lang/Object;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FacebookCallback<RESULT> {
    void onCancel();

    void onError(FacebookException error);

    void onSuccess(RESULT result);
}
