package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class PlaylistTrack implements Parcelable {
    public static final Parcelable.Creator<PlaylistTrack> CREATOR = new Parcelable.Creator<PlaylistTrack>() { // from class: kaaes.spotify.webapi.android.models.PlaylistTrack.1
        @Override // android.os.Parcelable.Creator
        public PlaylistTrack createFromParcel(Parcel parcel) {
            return new PlaylistTrack(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PlaylistTrack[] newArray(int i) {
            return new PlaylistTrack[i];
        }
    };
    public String added_at;
    public UserPublic added_by;
    public Boolean is_local;
    public Track track;

    public PlaylistTrack(Parcel parcel) {
        this.added_at = parcel.readString();
        this.added_by = (UserPublic) parcel.readParcelable(UserPublic.class.getClassLoader());
        this.track = (Track) parcel.readParcelable(Track.class.getClassLoader());
        this.is_local = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.added_at);
        parcel.writeParcelable(this.added_by, i);
        parcel.writeParcelable(this.track, 0);
        parcel.writeValue(this.is_local);
    }

    public PlaylistTrack() {
    }
}
