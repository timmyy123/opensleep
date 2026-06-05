package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class UserStatus implements Item {
    public static final int STATUS_CODE_NOT_LOGGED_IN = 1;
    public static final int STATUS_CODE_OK = 0;

    @SerializedName("code")
    @JsonProperty("code")
    public final int code;

    @SerializedName("long_text")
    @JsonProperty("long_text")
    public final String longMessage;

    @SerializedName("short_text")
    @JsonProperty("short_text")
    public final String shortMessage;

    public UserStatus(int i, String str, String str2) {
        this.code = i;
        this.shortMessage = str;
        this.longMessage = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserStatus)) {
            return false;
        }
        UserStatus userStatus = (UserStatus) obj;
        if (this.code != userStatus.code) {
            return false;
        }
        String str = this.shortMessage;
        String str2 = userStatus.shortMessage;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.longMessage;
        String str4 = userStatus.longMessage;
        return str3 != null ? str3.equals(str4) : str4 == null;
    }

    public int hashCode() {
        int i = this.code * 31;
        String str = this.shortMessage;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.longMessage;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @JsonIgnore
    public boolean isLoggedIn() {
        return this.code == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserStatus{code=");
        sb.append(this.code);
        sb.append(", shortMessage='");
        sb.append(this.shortMessage);
        sb.append("', longMessage='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.longMessage, "'}");
    }

    private UserStatus() {
        this(1, null, null);
    }
}
