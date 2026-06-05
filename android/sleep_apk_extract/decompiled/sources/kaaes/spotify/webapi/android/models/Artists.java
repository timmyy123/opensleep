package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Artists implements Parcelable {
    public static final Parcelable.Creator<Artists> CREATOR = new Parcelable.Creator<Artists>() { // from class: kaaes.spotify.webapi.android.models.Artists.1
        @Override // android.os.Parcelable.Creator
        public Artists createFromParcel(Parcel parcel) {
            return new Artists(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Artists[] newArray(int i) {
            return new Artists[i];
        }
    };
    public List<Artist> artists;

    public Artists(Parcel parcel) {
        this.artists = parcel.createTypedArrayList(Artist.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.artists);
    }

    public Artists() {
    }
}
