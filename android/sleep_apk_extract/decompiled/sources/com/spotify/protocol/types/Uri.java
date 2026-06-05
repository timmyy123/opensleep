package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class Uri implements Item {

    @SerializedName(ShareConstants.MEDIA_URI)
    @JsonProperty(ShareConstants.MEDIA_URI)
    public final String uri;

    public Uri(String str) {
        this.uri = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uri)) {
            return false;
        }
        String str = this.uri;
        String str2 = ((Uri) obj).uri;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.uri;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Uri{uri='"), this.uri, "'}");
    }

    private Uri() {
        this(null);
    }
}
