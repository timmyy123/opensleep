package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class PlaybackPosition implements Item {

    @SerializedName("position_ms")
    @JsonProperty("position_ms")
    public final long position;

    private PlaybackPosition() {
        this(0L);
    }

    public PlaybackPosition(long j) {
        this.position = j;
    }
}
