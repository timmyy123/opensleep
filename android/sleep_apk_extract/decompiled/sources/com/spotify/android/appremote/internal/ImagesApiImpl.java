package com.spotify.android.appremote.internal;

import com.spotify.android.appremote.api.ImagesApi;
import com.spotify.protocol.client.Coding;
import com.spotify.protocol.client.RemoteClient;

/* JADX INFO: loaded from: classes4.dex */
public class ImagesApiImpl implements ImagesApi {
    private final RemoteClient mRemoteClient;

    public ImagesApiImpl(RemoteClient remoteClient) {
        this.mRemoteClient = (RemoteClient) Coding.checkNotNull(remoteClient);
    }
}
