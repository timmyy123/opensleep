package com.spotify.protocol.client;

/* JADX INFO: loaded from: classes4.dex */
public interface Result<T> {
    T getData();

    Throwable getError();

    boolean isSuccessful();
}
