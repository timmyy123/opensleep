package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class ArtistsCursorPager implements Parcelable {
    public static final Parcelable.Creator<ArtistsCursorPager> CREATOR = new Parcelable.Creator<ArtistsCursorPager>() { // from class: kaaes.spotify.webapi.android.models.ArtistsCursorPager.1
        @Override // android.os.Parcelable.Creator
        public ArtistsCursorPager createFromParcel(Parcel parcel) {
            return new ArtistsCursorPager(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ArtistsCursorPager[] newArray(int i) {
            return new ArtistsCursorPager[i];
        }
    };
    public CursorPager<Artist> artists;

    public ArtistsCursorPager(Parcel parcel) {
        this.artists = (CursorPager) parcel.readParcelable(Pager.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.artists, 0);
    }

    public ArtistsCursorPager() {
    }
}
