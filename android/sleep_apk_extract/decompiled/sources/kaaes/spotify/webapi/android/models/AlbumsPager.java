package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class AlbumsPager implements Parcelable {
    public static final Parcelable.Creator<AlbumsPager> CREATOR = new Parcelable.Creator<AlbumsPager>() { // from class: kaaes.spotify.webapi.android.models.AlbumsPager.1
        @Override // android.os.Parcelable.Creator
        public AlbumsPager createFromParcel(Parcel parcel) {
            return new AlbumsPager(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AlbumsPager[] newArray(int i) {
            return new AlbumsPager[i];
        }
    };
    public Pager<AlbumSimple> albums;

    public AlbumsPager(Parcel parcel) {
        this.albums = (Pager) parcel.readParcelable(Pager.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.albums, 0);
    }

    public AlbumsPager() {
    }
}
