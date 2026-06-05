package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class ArtistsPager implements Parcelable {
    public static final Parcelable.Creator<ArtistsPager> CREATOR = new Parcelable.Creator<ArtistsPager>() { // from class: kaaes.spotify.webapi.android.models.ArtistsPager.1
        @Override // android.os.Parcelable.Creator
        public ArtistsPager createFromParcel(Parcel parcel) {
            return new ArtistsPager(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ArtistsPager[] newArray(int i) {
            return new ArtistsPager[i];
        }
    };
    public Pager<Artist> artists;

    public ArtistsPager(Parcel parcel) {
        this.artists = (Pager) parcel.readParcelable(Pager.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.artists, 0);
    }

    public ArtistsPager() {
    }
}
