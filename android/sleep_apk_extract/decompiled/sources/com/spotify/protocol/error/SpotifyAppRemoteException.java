package com.spotify.protocol.error;

/* JADX INFO: loaded from: classes4.dex */
public class SpotifyAppRemoteException extends Exception {
    private static final long serialVersionUID = -5068949837311972143L;

    public SpotifyAppRemoteException() {
    }

    public SpotifyAppRemoteException(String str) {
        super(str);
    }

    public SpotifyAppRemoteException(Throwable th) {
        super(th);
    }

    public SpotifyAppRemoteException(String str, Throwable th) {
        super(str, th);
    }
}
