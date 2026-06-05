package com.spotify.protocol.types;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class PlayerRestrictions implements Item {
    public static final PlayerRestrictions DEFAULT = new PlayerRestrictions();

    @SerializedName("can_repeat_context")
    @JsonProperty("can_repeat_context")
    public final boolean canRepeatContext;

    @SerializedName("can_repeat_track")
    @JsonProperty("can_repeat_track")
    public final boolean canRepeatTrack;

    @SerializedName("can_seek")
    @JsonProperty("can_seek")
    public final boolean canSeek;

    @SerializedName("can_skip_next")
    @JsonProperty("can_skip_next")
    public final boolean canSkipNext;

    @SerializedName("can_skip_prev")
    @JsonProperty("can_skip_prev")
    public final boolean canSkipPrev;

    @SerializedName("can_toggle_shuffle")
    @JsonProperty("can_toggle_shuffle")
    public final boolean canToggleShuffle;

    public PlayerRestrictions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.canSkipNext = z;
        this.canSkipPrev = z2;
        this.canRepeatTrack = z3;
        this.canRepeatContext = z4;
        this.canToggleShuffle = z5;
        this.canSeek = z6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerRestrictions)) {
            return false;
        }
        PlayerRestrictions playerRestrictions = (PlayerRestrictions) obj;
        return this.canSkipNext == playerRestrictions.canSkipNext && this.canSkipPrev == playerRestrictions.canSkipPrev && this.canRepeatTrack == playerRestrictions.canRepeatTrack && this.canRepeatContext == playerRestrictions.canRepeatContext && this.canToggleShuffle == playerRestrictions.canToggleShuffle;
    }

    public int hashCode() {
        return ((((((((this.canSkipNext ? 1 : 0) * 31) + (this.canSkipPrev ? 1 : 0)) * 31) + (this.canRepeatTrack ? 1 : 0)) * 31) + (this.canRepeatContext ? 1 : 0)) * 31) + (this.canToggleShuffle ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlayerRestrictions{canSkipNext=");
        sb.append(this.canSkipNext);
        sb.append(", canSkipPrev=");
        sb.append(this.canSkipPrev);
        sb.append(", canRepeatTrack=");
        sb.append(this.canRepeatTrack);
        sb.append(", canRepeatContext=");
        sb.append(this.canRepeatContext);
        sb.append(", canToggleShuffle=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.canToggleShuffle, '}');
    }

    private PlayerRestrictions() {
        this(false, false, false, false, false, false);
    }
}
