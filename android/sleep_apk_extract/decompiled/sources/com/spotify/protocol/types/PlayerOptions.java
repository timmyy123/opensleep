package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class PlayerOptions implements Item {
    public static final PlayerOptions DEFAULT = new PlayerOptions();

    @SerializedName("shuffle")
    @JsonProperty("shuffle")
    public final boolean isShuffling;

    @SerializedName("repeat")
    @JsonProperty("repeat")
    public final int repeatMode;

    public PlayerOptions(boolean z, int i) {
        this.isShuffling = z;
        this.repeatMode = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerOptions)) {
            return false;
        }
        PlayerOptions playerOptions = (PlayerOptions) obj;
        return this.isShuffling == playerOptions.isShuffling && this.repeatMode == playerOptions.repeatMode;
    }

    public int hashCode() {
        return ((this.isShuffling ? 1 : 0) * 31) + this.repeatMode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlayerOptions{isShuffling=");
        sb.append(this.isShuffling);
        sb.append(", repeatMode=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.repeatMode, '}');
    }

    private PlayerOptions() {
        this(false, 0);
    }
}
