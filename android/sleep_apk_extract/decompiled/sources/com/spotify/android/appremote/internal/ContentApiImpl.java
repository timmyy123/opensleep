package com.spotify.android.appremote.internal;

import com.spotify.android.appremote.api.ContentApi;
import com.spotify.protocol.client.RemoteClient;

/* JADX INFO: loaded from: classes4.dex */
public class ContentApiImpl implements ContentApi {
    private final RemoteClient mRemoteClient;

    public ContentApiImpl(RemoteClient remoteClient) {
        this.mRemoteClient = remoteClient;
    }
}
