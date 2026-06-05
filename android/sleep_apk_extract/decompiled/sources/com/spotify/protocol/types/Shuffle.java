package com.spotify.protocol.types;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class Shuffle implements Item {

    @SerializedName("shuffle")
    @JsonProperty("shuffle")
    public final boolean shuffle;

    public Shuffle(boolean z) {
        this.shuffle = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Shuffle) && this.shuffle == ((Shuffle) obj).shuffle;
    }

    public int hashCode() {
        return this.shuffle ? 1 : 0;
    }

    public String toString() {
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder("Shuffle{shuffle="), this.shuffle, '}');
    }

    private Shuffle() {
        this(false);
    }
}
