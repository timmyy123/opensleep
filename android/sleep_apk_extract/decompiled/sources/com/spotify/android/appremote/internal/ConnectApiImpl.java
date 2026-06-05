package com.spotify.android.appremote.internal;

import com.spotify.android.appremote.api.ConnectApi;
import com.spotify.protocol.client.RemoteClient;

/* JADX INFO: loaded from: classes4.dex */
public class ConnectApiImpl implements ConnectApi {
    private final RemoteClient mClient;

    public ConnectApiImpl(RemoteClient remoteClient) {
        this.mClient = remoteClient;
    }
}
