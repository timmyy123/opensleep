package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class Playlist extends PlaylistBase {
    public static final Parcelable.Creator<Playlist> CREATOR = new Parcelable.Creator<Playlist>() { // from class: kaaes.spotify.webapi.android.models.Playlist.1
        @Override // android.os.Parcelable.Creator
        public Playlist createFromParcel(Parcel parcel) {
            return new Playlist(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Playlist[] newArray(int i) {
            return new Playlist[i];
        }
    };
    public String description;
    public Followers followers;
    public Pager<PlaylistTrack> tracks;

    public Playlist(Parcel parcel) {
        super(parcel);
        this.description = parcel.readString();
        this.followers = (Followers) parcel.readParcelable(Followers.class.getClassLoader());
        this.tracks = (Pager) parcel.readParcelable(Pager.class.getClassLoader());
    }

    @Override // kaaes.spotify.webapi.android.models.PlaylistBase, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // kaaes.spotify.webapi.android.models.PlaylistBase, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.followers, 0);
        parcel.writeParcelable(this.tracks, 0);
    }

    public Playlist() {
    }
}
