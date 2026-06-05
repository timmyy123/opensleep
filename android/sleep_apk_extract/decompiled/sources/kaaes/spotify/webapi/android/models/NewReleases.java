package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class NewReleases implements Parcelable {
    public static final Parcelable.Creator<NewReleases> CREATOR = new Parcelable.Creator<NewReleases>() { // from class: kaaes.spotify.webapi.android.models.NewReleases.1
        @Override // android.os.Parcelable.Creator
        public NewReleases createFromParcel(Parcel parcel) {
            return new NewReleases(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NewReleases[] newArray(int i) {
            return new NewReleases[i];
        }
    };
    public Pager<AlbumSimple> albums;

    public NewReleases(Parcel parcel) {
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

    public NewReleases() {
    }
}
