package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class Roles implements Item {

    @SerializedName("broker")
    @JsonProperty("broker")
    public final Empty broker;

    @SerializedName("caller")
    @JsonProperty("caller")
    public final Empty caller;

    @SerializedName("dealer")
    @JsonProperty("dealer")
    public final Empty dealer;

    @SerializedName("subscriber")
    @JsonProperty("subscriber")
    public final Empty subscriber;

    public Roles(Empty empty, Empty empty2, Empty empty3, Empty empty4) {
        this.dealer = empty;
        this.broker = empty2;
        this.subscriber = empty3;
        this.caller = empty4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Roles)) {
            return false;
        }
        Roles roles = (Roles) obj;
        Empty empty = this.dealer;
        Empty empty2 = roles.dealer;
        if (empty == null ? empty2 != null : !empty.equals(empty2)) {
            return false;
        }
        Empty empty3 = this.broker;
        Empty empty4 = roles.broker;
        if (empty3 == null ? empty4 != null : !empty3.equals(empty4)) {
            return false;
        }
        Empty empty5 = this.subscriber;
        Empty empty6 = roles.subscriber;
        if (empty5 == null ? empty6 != null : !empty5.equals(empty6)) {
            return false;
        }
        Empty empty7 = this.caller;
        Empty empty8 = roles.caller;
        return empty7 != null ? empty7.equals(empty8) : empty8 == null;
    }

    public int hashCode() {
        Empty empty = this.dealer;
        int iHashCode = (empty != null ? empty.hashCode() : 0) * 31;
        Empty empty2 = this.broker;
        int iHashCode2 = (iHashCode + (empty2 != null ? empty2.hashCode() : 0)) * 31;
        Empty empty3 = this.subscriber;
        int iHashCode3 = (iHashCode2 + (empty3 != null ? empty3.hashCode() : 0)) * 31;
        Empty empty4 = this.caller;
        return iHashCode3 + (empty4 != null ? empty4.hashCode() : 0);
    }

    public String toString() {
        return "Roles{dealer=" + this.dealer + ", broker=" + this.broker + ", subscriber=" + this.subscriber + ", caller=" + this.caller + '}';
    }

    public Roles() {
        this(null, null, null, null);
    }
}
