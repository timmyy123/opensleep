package com.spotify.android.appremote.internal;

import com.spotify.android.appremote.api.PlayerApi;
import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.RemoteClient;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.PlaybackSpeed;
import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Uri;
import com.spotify.protocol.types.UriWithOptionExtras;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class PlayerApiImpl implements PlayerApi {
    private final RemoteClient mClient;

    public PlayerApiImpl(RemoteClient remoteClient) {
        this.mClient = remoteClient;
    }

    @Nonnull
    private static String ensureNonNull(@Nullable String str) {
        return str != null ? str : "";
    }

    private CallResult<Empty> setPlaybackSpeed(PlaybackSpeed playbackSpeed) {
        return this.mClient.call("com.spotify.set_playback_speed", playbackSpeed, Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> pause() {
        return setPlaybackSpeed(new PlaybackSpeed(0));
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> play(@Nullable String str, PlayerApi.StreamType streamType) {
        Validate.checkNotNull(streamType);
        return this.mClient.call("com.spotify.play_spotify_uri_option_extras", new UriWithOptionExtras(ensureNonNull(str), new String[]{streamType.name}), Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> resume() {
        return setPlaybackSpeed(new PlaybackSpeed(1));
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public Subscription<PlayerState> subscribeToPlayerState() {
        return this.mClient.subscribe("com.spotify.player_state", PlayerState.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> play(@Nullable String str) {
        return this.mClient.call("com.spotify.play_spotify_uri", new Uri(ensureNonNull(str)), Empty.class);
    }
}
