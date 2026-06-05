package com.spotify.android.appremote.api;

import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.LocalConnector;
import com.spotify.protocol.client.OnConnectionTerminatedListener;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.UserStatus;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LocalConnector$1$$ExternalSyntheticLambda0 implements OnConnectionTerminatedListener, Subscription.EventCallback {
    public final /* synthetic */ SpotifyAppRemote f$0;
    public final /* synthetic */ Connector.ConnectionListener f$1;

    public /* synthetic */ LocalConnector$1$$ExternalSyntheticLambda0(Connector.ConnectionListener connectionListener, SpotifyAppRemote spotifyAppRemote) {
        this.f$1 = connectionListener;
        this.f$0 = spotifyAppRemote;
    }

    public void onConnectionTerminated() {
        LocalConnector.AnonymousClass1.lambda$onConnected$0(this.f$0, this.f$1);
    }

    @Override // com.spotify.protocol.client.Subscription.EventCallback
    public void onEvent(Object obj) {
        LocalConnector.AnonymousClass1.lambda$onConnected$1(this.f$1, this.f$0, (UserStatus) obj);
    }

    public /* synthetic */ LocalConnector$1$$ExternalSyntheticLambda0(SpotifyAppRemote spotifyAppRemote, Connector.ConnectionListener connectionListener) {
        this.f$0 = spotifyAppRemote;
        this.f$1 = connectionListener;
    }
}
