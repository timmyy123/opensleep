package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class PlaylistsPager implements Parcelable {
    public static final Parcelable.Creator<PlaylistsPager> CREATOR = new Parcelable.Creator<PlaylistsPager>() { // from class: kaaes.spotify.webapi.android.models.PlaylistsPager.1
        @Override // android.os.Parcelable.Creator
        public PlaylistsPager createFromParcel(Parcel parcel) {
            return new PlaylistsPager(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PlaylistsPager[] newArray(int i) {
            return new PlaylistsPager[i];
        }
    };
    public Pager<PlaylistSimple> playlists;

    public PlaylistsPager(Parcel parcel) {
        this.playlists = (Pager) parcel.readParcelable(Pager.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.playlists, 0);
    }

    public PlaylistsPager() {
    }
}
