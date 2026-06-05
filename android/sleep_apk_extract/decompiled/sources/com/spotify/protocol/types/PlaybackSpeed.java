package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class PlaybackSpeed implements Item {

    @SerializedName("playback_speed")
    @JsonProperty("playback_speed")
    public final int playbackSpeed;

    public PlaybackSpeed(int i) {
        this.playbackSpeed = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlaybackSpeed) && this.playbackSpeed == ((PlaybackSpeed) obj).playbackSpeed;
    }

    public int hashCode() {
        return this.playbackSpeed;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("PlaybackSpeed{playbackSpeed="), this.playbackSpeed, '}');
    }

    public PlaybackSpeed() {
        this(0);
    }
}
