package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Tracks implements Parcelable {
    public static final Parcelable.Creator<Tracks> CREATOR = new Parcelable.Creator<Tracks>() { // from class: kaaes.spotify.webapi.android.models.Tracks.1
        @Override // android.os.Parcelable.Creator
        public Tracks createFromParcel(Parcel parcel) {
            return new Tracks(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Tracks[] newArray(int i) {
            return new Tracks[i];
        }
    };
    public List<Track> tracks;

    public Tracks(Parcel parcel) {
        this.tracks = parcel.createTypedArrayList(Track.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.tracks);
    }

    public Tracks() {
    }
}
