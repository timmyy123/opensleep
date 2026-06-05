package com.spotify.protocol.types;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kaaes.spotify.webapi.android.SpotifyService;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class ListItems implements Item {

    @SerializedName("items")
    @JsonProperty("items")
    public final ListItem[] items;

    @SerializedName(SpotifyService.LIMIT)
    @JsonProperty(SpotifyService.LIMIT)
    public final int limit;

    @SerializedName(SpotifyService.OFFSET)
    @JsonProperty(SpotifyService.OFFSET)
    public final int offset;

    @SerializedName("total")
    @JsonProperty("total")
    public final int total;

    public ListItems(int i, int i2, int i3, ListItem[] listItemArr) {
        this.limit = i;
        this.offset = i2;
        this.total = i3;
        this.items = listItemArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListItems)) {
            return false;
        }
        ListItems listItems = (ListItems) obj;
        if (this.limit == listItems.limit && this.offset == listItems.offset && this.total == listItems.total) {
            return Arrays.equals(this.items, listItems.items);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.limit * 31) + this.offset) * 31) + this.total) * 31) + Arrays.hashCode(this.items);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListItems{limit=");
        sb.append(this.limit);
        sb.append(", offset=");
        sb.append(this.offset);
        sb.append(", total=");
        sb.append(this.total);
        sb.append(", items=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, Arrays.toString(this.items), '}');
    }

    private ListItems() {
        this(0, 0, 0, null);
    }
}
