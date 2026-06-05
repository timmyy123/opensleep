package com.urbandroid.sleep.share;

/* JADX INFO: loaded from: classes5.dex */
public interface IHandler {
    void onError(Exception exc);

    void onFinished();

    void onNotAuthenticated();

    void onSuccess();
}
