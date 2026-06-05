package com.spotify.protocol.client;

/* JADX INFO: loaded from: classes4.dex */
public interface RemoteClientConnector {

    public interface ConnectionCallback {
        void onConnected(RemoteClient remoteClient);

        void onConnectionFailed(Throwable th);
    }

    void disconnect();
}
