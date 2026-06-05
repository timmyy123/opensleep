package com.spotify.android.appremote.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.PlayerState;

/* JADX INFO: loaded from: classes.dex */
public interface PlayerApi {

    /* JADX INFO: loaded from: classes4.dex */
    public enum StreamType {
        ALARM("alarm");


        @SerializedName("type")
        @JsonProperty("type")
        public final String name;

        StreamType(String str) {
            this.name = str;
        }
    }

    CallResult<Empty> pause();

    CallResult<Empty> play(String str);

    CallResult<Empty> play(String str, StreamType streamType);

    CallResult<Empty> resume();

    Subscription<PlayerState> subscribeToPlayerState();
}
