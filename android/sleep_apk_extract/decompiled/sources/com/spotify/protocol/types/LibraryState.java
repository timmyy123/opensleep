package com.spotify.protocol.types;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class LibraryState implements Item {

    @SerializedName("can_save")
    @JsonProperty("can_save")
    public final boolean canAdd;

    @SerializedName("saved")
    @JsonProperty("saved")
    public final boolean isAdded;

    @SerializedName(ShareConstants.MEDIA_URI)
    @JsonProperty(ShareConstants.MEDIA_URI)
    public final String uri;

    public LibraryState(String str, boolean z, boolean z2) {
        this.uri = str;
        this.isAdded = z;
        this.canAdd = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LibraryState)) {
            return false;
        }
        LibraryState libraryState = (LibraryState) obj;
        if (this.isAdded != libraryState.isAdded || this.canAdd != libraryState.canAdd) {
            return false;
        }
        String str = this.uri;
        String str2 = libraryState.uri;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.uri;
        return ((((str != null ? str.hashCode() : 0) * 31) + (this.isAdded ? 1 : 0)) * 31) + (this.canAdd ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LibraryState{uri='");
        sb.append(this.uri);
        sb.append("', isAdded=");
        sb.append(this.isAdded);
        sb.append(", canAdd=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.canAdd, '}');
    }

    private LibraryState() {
        this(null, false, false);
    }
}
