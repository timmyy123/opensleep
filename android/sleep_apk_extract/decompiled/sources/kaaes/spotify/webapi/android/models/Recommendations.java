package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Recommendations implements Parcelable {
    public static final Parcelable.Creator<Recommendations> CREATOR = new Parcelable.Creator<Recommendations>() { // from class: kaaes.spotify.webapi.android.models.Recommendations.1
        @Override // android.os.Parcelable.Creator
        public Recommendations createFromParcel(Parcel parcel) {
            return new Recommendations(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Recommendations[] newArray(int i) {
            return new Recommendations[i];
        }
    };
    public List<Seed> seeds;
    public List<Track> tracks;

    public Recommendations(Parcel parcel) {
        this.seeds = parcel.createTypedArrayList(Seed.CREATOR);
        this.tracks = parcel.createTypedArrayList(Track.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.seeds);
        parcel.writeTypedList(this.tracks);
    }

    public Recommendations() {
    }
}
