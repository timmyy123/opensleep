package com.spotify.protocol.client;

/* JADX INFO: loaded from: classes4.dex */
public interface RemoteClient {
    <T> CallResult<T> call(String str, Object obj, Class<T> cls);

    void goodbye();

    <T> Subscription<T> subscribe(String str, Class<T> cls);

    <T> void unsubscribe(Subscription<T> subscription);
}
