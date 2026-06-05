package com.spotify.protocol.types;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class ListItem implements Item {

    @SerializedName("has_children")
    @JsonProperty("has_children")
    public final boolean hasChildren;

    @SerializedName("id")
    @JsonProperty("id")
    public final String id;

    @SerializedName("image_id")
    @JsonProperty("image_id")
    public final ImageUri imageUri;

    @SerializedName("playable")
    @JsonProperty("playable")
    public final boolean playable;

    @SerializedName("subtitle")
    @JsonProperty("subtitle")
    public final String subtitle;

    @SerializedName("title")
    @JsonProperty("title")
    public final String title;

    @SerializedName(ShareConstants.MEDIA_URI)
    @JsonProperty(ShareConstants.MEDIA_URI)
    public final String uri;

    public ListItem(String str, String str2, ImageUri imageUri, String str3, String str4, boolean z, boolean z2) {
        this.id = str;
        this.uri = str2;
        this.imageUri = imageUri;
        this.title = str3;
        this.subtitle = str4;
        this.playable = z;
        this.hasChildren = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListItem)) {
            return false;
        }
        ListItem listItem = (ListItem) obj;
        if (this.playable != listItem.playable || this.hasChildren != listItem.hasChildren) {
            return false;
        }
        String str = this.id;
        String str2 = listItem.id;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.uri;
        String str4 = listItem.uri;
        if (str3 == null ? str4 != null : !str3.equals(str4)) {
            return false;
        }
        ImageUri imageUri = this.imageUri;
        ImageUri imageUri2 = listItem.imageUri;
        if (imageUri == null ? imageUri2 != null : !imageUri.equals(imageUri2)) {
            return false;
        }
        String str5 = this.title;
        String str6 = listItem.title;
        if (str5 == null ? str6 != null : !str5.equals(str6)) {
            return false;
        }
        String str7 = this.subtitle;
        String str8 = listItem.subtitle;
        return str7 != null ? str7.equals(str8) : str8 == null;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.uri;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ImageUri imageUri = this.imageUri;
        int iHashCode3 = (iHashCode2 + (imageUri != null ? imageUri.hashCode() : 0)) * 31;
        String str3 = this.title;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.subtitle;
        return ((((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + (this.playable ? 1 : 0)) * 31) + (this.hasChildren ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListItem{id='");
        sb.append(this.id);
        sb.append("', uri='");
        sb.append(this.uri);
        sb.append("', imageId='");
        sb.append(this.imageUri);
        sb.append("', title='");
        sb.append(this.title);
        sb.append("', subtitle='");
        sb.append(this.subtitle);
        sb.append("', playable=");
        sb.append(this.playable);
        sb.append(", hasChildren=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.hasChildren, '}');
    }

    private ListItem() {
        this(null, null, null, null, null, false, false);
    }
}
