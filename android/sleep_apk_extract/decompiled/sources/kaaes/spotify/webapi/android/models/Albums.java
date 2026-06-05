package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Albums implements Parcelable {
    public static final Parcelable.Creator<Albums> CREATOR = new Parcelable.Creator<Albums>() { // from class: kaaes.spotify.webapi.android.models.Albums.1
        @Override // android.os.Parcelable.Creator
        public Albums createFromParcel(Parcel parcel) {
            return new Albums(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Albums[] newArray(int i) {
            return new Albums[i];
        }
    };
    public List<Album> albums;

    public Albums(Parcel parcel) {
        this.albums = parcel.createTypedArrayList(Album.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.albums);
    }

    public Albums() {
    }
}
