package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class FeaturedPlaylists implements Parcelable {
    public static final Parcelable.Creator<FeaturedPlaylists> CREATOR = new Parcelable.Creator<FeaturedPlaylists>() { // from class: kaaes.spotify.webapi.android.models.FeaturedPlaylists.1
        @Override // android.os.Parcelable.Creator
        public FeaturedPlaylists createFromParcel(Parcel parcel) {
            return new FeaturedPlaylists(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FeaturedPlaylists[] newArray(int i) {
            return new FeaturedPlaylists[i];
        }
    };
    public String message;
    public Pager<PlaylistSimple> playlists;

    public FeaturedPlaylists(Parcel parcel) {
        this.message = parcel.readString();
        this.playlists = (Pager) parcel.readParcelable(Pager.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.message);
        parcel.writeParcelable(this.playlists, 0);
    }

    public FeaturedPlaylists() {
    }
}
