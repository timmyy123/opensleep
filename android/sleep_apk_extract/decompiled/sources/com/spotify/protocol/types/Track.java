package com.spotify.protocol.types;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = MqttConnectOptions.CLEAN_SESSION_DEFAULT)
public class Track implements Item {

    @SerializedName("album")
    @JsonProperty("album")
    public final Album album;

    @SerializedName("artist")
    @JsonProperty("artist")
    public final Artist artist;

    @SerializedName("artists")
    @JsonProperty("artists")
    public final List<Artist> artists;

    @SerializedName("duration_ms")
    @JsonProperty("duration_ms")
    public final long duration;

    @SerializedName("image_id")
    @JsonProperty("image_id")
    public final ImageUri imageUri;

    @SerializedName("is_episode")
    @JsonProperty("is_episode")
    public final boolean isEpisode;

    @SerializedName("is_podcast")
    @JsonProperty("is_podcast")
    public final boolean isPodcast;

    @SerializedName("name")
    @JsonProperty("name")
    public final String name;

    @SerializedName(ShareConstants.MEDIA_URI)
    @JsonProperty(ShareConstants.MEDIA_URI)
    public final String uri;

    public Track(Artist artist, List<Artist> list, Album album, long j, String str, String str2, ImageUri imageUri, boolean z, boolean z2) {
        this.artist = artist;
        this.artists = list;
        this.album = album;
        this.duration = j;
        this.name = str;
        this.uri = str2;
        this.imageUri = imageUri;
        this.isEpisode = z;
        this.isPodcast = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        Track track = (Track) obj;
        if (this.duration != track.duration) {
            return false;
        }
        Artist artist = this.artist;
        Artist artist2 = track.artist;
        if (artist == null ? artist2 != null : !artist.equals(artist2)) {
            return false;
        }
        List<Artist> list = this.artists;
        List<Artist> list2 = track.artists;
        if (list == null ? list2 != null : !list.equals(list2)) {
            return false;
        }
        Album album = this.album;
        Album album2 = track.album;
        if (album == null ? album2 != null : !album.equals(album2)) {
            return false;
        }
        String str = this.name;
        String str2 = track.name;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.uri;
        String str4 = track.uri;
        if (str3 == null ? str4 != null : !str3.equals(str4)) {
            return false;
        }
        ImageUri imageUri = this.imageUri;
        ImageUri imageUri2 = track.imageUri;
        if (imageUri == null ? imageUri2 == null : imageUri.equals(imageUri2)) {
            return this.isEpisode == track.isEpisode && this.isPodcast == track.isPodcast;
        }
        return false;
    }

    public int hashCode() {
        Artist artist = this.artist;
        int iHashCode = (artist != null ? artist.hashCode() : 0) * 31;
        List<Artist> list = this.artists;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Album album = this.album;
        int iHashCode3 = (iHashCode2 + (album != null ? album.hashCode() : 0)) * 31;
        long j = this.duration;
        int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.name;
        int iHashCode4 = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.uri;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ImageUri imageUri = this.imageUri;
        return ((((iHashCode5 + (imageUri != null ? imageUri.hashCode() : 0)) * 31) + (this.isEpisode ? 1 : 0)) * 31) + (this.isPodcast ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Track{artist=");
        sb.append(this.artist);
        sb.append(", artists=");
        sb.append(this.artists);
        sb.append(", album=");
        sb.append(this.album);
        sb.append(", duration=");
        sb.append(this.duration);
        sb.append(", name='");
        sb.append(this.name);
        sb.append("', uri='");
        sb.append(this.uri);
        sb.append("', imageId='");
        sb.append(this.imageUri);
        sb.append("', isEpisode=");
        sb.append(this.isEpisode);
        sb.append(", isPodcast=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.isPodcast, '}');
    }

    private Track() {
        this(null, null, null, 0L, null, null, null, false, false);
    }
}
