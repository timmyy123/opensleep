package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class PlayerState implements Item {

    @SerializedName("is_paused")
    @JsonProperty("is_paused")
    public final boolean isPaused;

    @SerializedName("playback_options")
    @JsonProperty("playback_options")
    public final PlayerOptions playbackOptions;

    @SerializedName("playback_position")
    @JsonProperty("playback_position")
    public final long playbackPosition;

    @SerializedName("playback_restrictions")
    @JsonProperty("playback_restrictions")
    public final PlayerRestrictions playbackRestrictions;

    @SerializedName("playback_speed")
    @JsonProperty("playback_speed")
    public final float playbackSpeed;

    @SerializedName("track")
    @JsonProperty("track")
    public final Track track;

    public PlayerState(Track track, boolean z, float f, long j, PlayerOptions playerOptions, PlayerRestrictions playerRestrictions) {
        this.track = track;
        this.isPaused = z;
        this.playbackSpeed = f;
        this.playbackPosition = j;
        this.playbackOptions = playerOptions == null ? PlayerOptions.DEFAULT : playerOptions;
        this.playbackRestrictions = playerRestrictions == null ? PlayerRestrictions.DEFAULT : playerRestrictions;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerState)) {
            return false;
        }
        PlayerState playerState = (PlayerState) obj;
        if (this.isPaused != playerState.isPaused || Float.compare(playerState.playbackSpeed, this.playbackSpeed) != 0 || this.playbackPosition != playerState.playbackPosition) {
            return false;
        }
        Track track = this.track;
        Track track2 = playerState.track;
        if (track == null ? track2 != null : !track.equals(track2)) {
            return false;
        }
        PlayerOptions playerOptions = this.playbackOptions;
        PlayerOptions playerOptions2 = playerState.playbackOptions;
        if (playerOptions == null ? playerOptions2 != null : !playerOptions.equals(playerOptions2)) {
            return false;
        }
        PlayerRestrictions playerRestrictions = this.playbackRestrictions;
        PlayerRestrictions playerRestrictions2 = playerState.playbackRestrictions;
        return playerRestrictions != null ? playerRestrictions.equals(playerRestrictions2) : playerRestrictions2 == null;
    }

    public int hashCode() {
        Track track = this.track;
        int iHashCode = (((track != null ? track.hashCode() : 0) * 31) + (this.isPaused ? 1 : 0)) * 31;
        float f = this.playbackSpeed;
        int iFloatToIntBits = (iHashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        long j = this.playbackPosition;
        int i = (iFloatToIntBits + ((int) (j ^ (j >>> 32)))) * 31;
        PlayerOptions playerOptions = this.playbackOptions;
        int iHashCode2 = (i + (playerOptions != null ? playerOptions.hashCode() : 0)) * 31;
        PlayerRestrictions playerRestrictions = this.playbackRestrictions;
        return iHashCode2 + (playerRestrictions != null ? playerRestrictions.hashCode() : 0);
    }

    public String toString() {
        return "PlayerState{track=" + this.track + ", isPaused=" + this.isPaused + ", playbackSpeed=" + this.playbackSpeed + ", playbackPosition=" + this.playbackPosition + ", playbackOptions=" + this.playbackOptions + ", playbackRestrictions=" + this.playbackRestrictions + '}';
    }

    private PlayerState() {
        this(null, false, 0.0f, 0L, null, null);
    }
}
