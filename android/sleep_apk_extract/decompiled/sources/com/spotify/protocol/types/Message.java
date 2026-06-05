package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class Message implements Item {

    @SerializedName("message")
    @JsonProperty("message")
    public final String message;

    public Message(String str) {
        this.message = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        String str = this.message;
        String str2 = ((Message) obj).message;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.message;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Message{message='"), this.message, "'}");
    }

    private Message() {
        this(null);
    }
}
