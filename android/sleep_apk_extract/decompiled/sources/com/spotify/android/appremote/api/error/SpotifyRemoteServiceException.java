package com.spotify.android.appremote.api.error;

import com.spotify.protocol.error.SpotifyAppRemoteException;

/* JADX INFO: loaded from: classes4.dex */
public class SpotifyRemoteServiceException extends SpotifyAppRemoteException {
    private static final long serialVersionUID = 6920878202102405464L;

    public SpotifyRemoteServiceException(String str, Throwable th) {
        super(str, th);
    }
}
