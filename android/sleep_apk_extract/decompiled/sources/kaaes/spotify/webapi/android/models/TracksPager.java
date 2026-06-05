package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class TracksPager implements Parcelable {
    public static final Parcelable.Creator<TracksPager> CREATOR = new Parcelable.Creator<TracksPager>() { // from class: kaaes.spotify.webapi.android.models.TracksPager.1
        @Override // android.os.Parcelable.Creator
        public TracksPager createFromParcel(Parcel parcel) {
            return new TracksPager(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TracksPager[] newArray(int i) {
            return new TracksPager[i];
        }
    };
    public Pager<Track> tracks;

    public TracksPager(Parcel parcel) {
        this.tracks = (Pager) parcel.readParcelable(Pager.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.tracks, 0);
    }

    public TracksPager() {
    }
}
