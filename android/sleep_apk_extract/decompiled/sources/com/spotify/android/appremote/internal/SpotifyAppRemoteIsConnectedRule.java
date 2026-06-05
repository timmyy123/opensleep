package com.spotify.android.appremote.internal;

import com.spotify.android.appremote.api.AppRemote;
import com.spotify.android.appremote.api.error.SpotifyDisconnectedException;
import com.spotify.android.appremote.internal.StrictRemoteClient;

/* JADX INFO: loaded from: classes4.dex */
public class SpotifyAppRemoteIsConnectedRule implements StrictRemoteClient.Rule {
    private final AppRemote mSpotifyAppRemote;

    public SpotifyAppRemoteIsConnectedRule(AppRemote appRemote) {
        this.mSpotifyAppRemote = appRemote;
    }

    @Override // com.spotify.android.appremote.internal.StrictRemoteClient.Rule
    public Throwable getError() {
        return new SpotifyDisconnectedException();
    }

    @Override // com.spotify.android.appremote.internal.StrictRemoteClient.Rule
    public boolean isSatisfied() {
        return this.mSpotifyAppRemote.isConnected();
    }
}
