package com.spotify.android.appremote.api;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public interface Connector {

    public interface ConnectionListener {
        void onConnected(SpotifyAppRemote spotifyAppRemote);

        void onFailure(Throwable th);
    }

    void connect(Context context, ConnectionParams connectionParams, ConnectionListener connectionListener);

    void disconnect(SpotifyAppRemote spotifyAppRemote);
}
