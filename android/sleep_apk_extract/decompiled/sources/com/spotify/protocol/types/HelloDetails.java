package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class HelloDetails implements Item {

    @SerializedName("authid")
    @JsonProperty("authid")
    public final String authid;

    @SerializedName("authmethods")
    @JsonProperty("authmethods")
    public final String[] authmethods;

    @SerializedName("extras")
    @JsonProperty("extras")
    public final Map<String, String> extras;

    @SerializedName("info")
    @JsonProperty("info")
    public final Info info;

    @SerializedName("roles")
    @JsonProperty("roles")
    public final Roles roles;

    public HelloDetails(Roles roles, Info info, String[] strArr, String str, Map<String, String> map) {
        this.roles = roles;
        this.info = info;
        this.authmethods = strArr;
        this.authid = str;
        this.extras = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelloDetails)) {
            return false;
        }
        HelloDetails helloDetails = (HelloDetails) obj;
        Roles roles = this.roles;
        Roles roles2 = helloDetails.roles;
        if (roles == null ? roles2 != null : !roles.equals(roles2)) {
            return false;
        }
        Info info = this.info;
        Info info2 = helloDetails.info;
        if (info == null ? info2 != null : !info.equals(info2)) {
            return false;
        }
        if (!Arrays.equals(this.authmethods, helloDetails.authmethods)) {
            return false;
        }
        String str = this.authid;
        String str2 = helloDetails.authid;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        Map<String, String> map = this.extras;
        Map<String, String> map2 = helloDetails.extras;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        Roles roles = this.roles;
        int iHashCode = (roles != null ? roles.hashCode() : 0) * 31;
        Info info = this.info;
        int iHashCode2 = (((iHashCode + (info != null ? info.hashCode() : 0)) * 31) + Arrays.hashCode(this.authmethods)) * 31;
        String str = this.authid;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Map<String, String> map = this.extras;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "HelloDetails{roles=" + this.roles + ", info=" + this.info + ", authmethods=" + Arrays.toString(this.authmethods) + ", authid='" + this.authid + "', extras=" + this.extras + '}';
    }

    private HelloDetails() {
        this(null, null, null, null, null);
    }
}
