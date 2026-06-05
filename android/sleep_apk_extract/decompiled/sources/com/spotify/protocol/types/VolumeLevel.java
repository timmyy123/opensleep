package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Nullable;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class VolumeLevel implements Item {

    @SerializedName("volume")
    @JsonProperty("volume")
    public final float mVolume;

    public VolumeLevel(float f) {
        this.mVolume = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VolumeLevel) && Float.compare(((VolumeLevel) obj).mVolume, this.mVolume) == 0;
    }

    public int hashCode() {
        float f = this.mVolume;
        if (f != 0.0f) {
            return Float.floatToIntBits(f);
        }
        return 0;
    }
}
