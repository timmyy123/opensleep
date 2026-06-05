package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class PlayerContext implements Item {

    @SerializedName("subtitle")
    @JsonProperty("subtitle")
    public final String subtitle;

    @SerializedName("title")
    @JsonProperty("title")
    public final String title;

    @SerializedName("type")
    @JsonProperty("type")
    public final String type;

    @SerializedName(ShareConstants.MEDIA_URI)
    @JsonProperty(ShareConstants.MEDIA_URI)
    public final String uri;

    public PlayerContext(String str, String str2, String str3, String str4) {
        this.uri = str;
        this.title = str2;
        this.subtitle = str3;
        this.type = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerContext)) {
            return false;
        }
        PlayerContext playerContext = (PlayerContext) obj;
        String str = this.uri;
        String str2 = playerContext.uri;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.title;
        String str4 = playerContext.title;
        if (str3 == null ? str4 != null : !str3.equals(str4)) {
            return false;
        }
        String str5 = this.subtitle;
        String str6 = playerContext.subtitle;
        if (str5 == null ? str6 != null : !str5.equals(str6)) {
            return false;
        }
        String str7 = this.type;
        String str8 = playerContext.type;
        return str7 != null ? !str7.equals(str8) : str8 != null;
    }

    public int hashCode() {
        String str = this.uri;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subtitle;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.type;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlayerContext{, uri=");
        sb.append(this.uri);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", subtitle=");
        sb.append(this.subtitle);
        sb.append(", type=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.type, '}');
    }

    public PlayerContext() {
        this(null, null, null, null);
    }
}
