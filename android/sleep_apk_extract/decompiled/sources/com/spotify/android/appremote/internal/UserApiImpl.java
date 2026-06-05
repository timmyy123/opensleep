package com.spotify.android.appremote.internal;

import com.spotify.android.appremote.api.UserApi;
import com.spotify.protocol.client.RemoteClient;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.UserStatus;

/* JADX INFO: loaded from: classes4.dex */
public class UserApiImpl implements UserApi {
    private final RemoteClient mRemoteClient;

    public UserApiImpl(RemoteClient remoteClient) {
        this.mRemoteClient = remoteClient;
    }

    @Override // com.spotify.android.appremote.api.UserApi
    public Subscription<UserStatus> subscribeToUserStatus() {
        return this.mRemoteClient.subscribe("com.spotify.status", UserStatus.class);
    }
}
