package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import kaaes.spotify.webapi.android.SpotifyService;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class ChildrenPageRequest implements Item {

    @SerializedName(SpotifyService.LIMIT)
    @JsonProperty(SpotifyService.LIMIT)
    public final int limit;

    @SerializedName(SpotifyService.OFFSET)
    @JsonProperty(SpotifyService.OFFSET)
    public final int offset;

    @SerializedName("parent_id")
    @JsonProperty("parent_id")
    public final String parentId;

    public ChildrenPageRequest(String str, int i, int i2) {
        this.parentId = str;
        this.limit = i;
        this.offset = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChildrenPageRequest)) {
            return false;
        }
        ChildrenPageRequest childrenPageRequest = (ChildrenPageRequest) obj;
        if (this.limit != childrenPageRequest.limit || this.offset != childrenPageRequest.offset) {
            return false;
        }
        String str = this.parentId;
        String str2 = childrenPageRequest.parentId;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.parentId;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.limit) * 31) + this.offset;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChildrenPageRequest{parentId='");
        sb.append(this.parentId);
        sb.append("', limit=");
        sb.append(this.limit);
        sb.append(", offset=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.offset, '}');
    }

    private ChildrenPageRequest() {
        this(null, 0, 0);
    }
}
