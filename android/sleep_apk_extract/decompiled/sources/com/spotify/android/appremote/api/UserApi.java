package com.spotify.android.appremote.api;

import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.UserStatus;

/* JADX INFO: loaded from: classes4.dex */
public interface UserApi {
    Subscription<UserStatus> subscribeToUserStatus();
}
