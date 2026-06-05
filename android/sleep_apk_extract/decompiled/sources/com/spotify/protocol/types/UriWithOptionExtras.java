package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class UriWithOptionExtras implements Item {

    @SerializedName(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS)
    @JsonProperty(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS)
    public final String[] options;

    @SerializedName(ShareConstants.MEDIA_URI)
    @JsonProperty(ShareConstants.MEDIA_URI)
    public final String uri;

    public UriWithOptionExtras(String str, String[] strArr) {
        this.uri = str;
        this.options = strArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UriWithOptionExtras)) {
            return false;
        }
        UriWithOptionExtras uriWithOptionExtras = (UriWithOptionExtras) obj;
        return this.uri.equals(uriWithOptionExtras.uri) && Arrays.equals(this.options, uriWithOptionExtras.options);
    }

    public int hashCode() {
        return (this.uri.hashCode() * 31) + Arrays.hashCode(this.options);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UriWithOptionExtras{uri='");
        sb.append(this.uri);
        sb.append("', options=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, Arrays.toString(this.options), '}');
    }

    public UriWithOptionExtras() {
        this(null, null);
    }
}
