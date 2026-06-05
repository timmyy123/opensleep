package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Uris implements Item {

    @JsonProperty("uris")
    public final String[] uris;

    public Uris(String[] strArr) {
        this.uris = strArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Uris) {
            return Arrays.equals(this.uris, ((Uris) obj).uris);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.uris);
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Uris{uris="), Arrays.toString(this.uris), '}');
    }

    public Uris() {
        this(null);
    }
}
