package com.spotify.protocol.client.error;

import com.spotify.protocol.error.SpotifyAppRemoteException;

/* JADX INFO: loaded from: classes4.dex */
public class RemoteClientException extends SpotifyAppRemoteException {
    private static final long serialVersionUID = -2168285044517789333L;
    private final String mReasonUri;

    public RemoteClientException(String str, String str2) {
        super(str);
        this.mReasonUri = str2;
    }

    public String getReasonUri() {
        return this.mReasonUri;
    }
}
