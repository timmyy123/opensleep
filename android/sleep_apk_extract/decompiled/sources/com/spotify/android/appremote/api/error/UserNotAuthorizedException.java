package com.spotify.android.appremote.api.error;

import com.spotify.protocol.error.SpotifyAppRemoteException;

/* JADX INFO: loaded from: classes4.dex */
public class UserNotAuthorizedException extends SpotifyAppRemoteException {
    private static final long serialVersionUID = -2168285044517789333L;

    public UserNotAuthorizedException(String str, Throwable th) {
        super(str, th);
    }
}
