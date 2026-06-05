package com.spotify.protocol.types;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class Capabilities implements Item {

    @SerializedName("can_play_on_demand")
    @JsonProperty("can_play_on_demand")
    public final boolean canPlayOnDemand;

    public Capabilities(boolean z) {
        this.canPlayOnDemand = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Capabilities) && this.canPlayOnDemand == ((Capabilities) obj).canPlayOnDemand;
    }

    public int hashCode() {
        return this.canPlayOnDemand ? 1 : 0;
    }

    public String toString() {
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder("Capabilities{canPlayOnDemand="), this.canPlayOnDemand, '}');
    }

    private Capabilities() {
        this(false);
    }
}
