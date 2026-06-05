package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SeedsGenres implements Parcelable {
    public static final Parcelable.Creator<SeedsGenres> CREATOR = new Parcelable.Creator<SeedsGenres>() { // from class: kaaes.spotify.webapi.android.models.SeedsGenres.1
        @Override // android.os.Parcelable.Creator
        public SeedsGenres createFromParcel(Parcel parcel) {
            return new SeedsGenres(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SeedsGenres[] newArray(int i) {
            return new SeedsGenres[i];
        }
    };
    public List<String> genres;

    public SeedsGenres(Parcel parcel) {
        this.genres = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.genres);
    }

    public SeedsGenres() {
    }
}
