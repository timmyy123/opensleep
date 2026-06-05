package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class TrackToRemove implements Parcelable {
    public static final Parcelable.Creator<TrackToRemove> CREATOR = new Parcelable.Creator<TrackToRemove>() { // from class: kaaes.spotify.webapi.android.models.TrackToRemove.1
        @Override // android.os.Parcelable.Creator
        public TrackToRemove createFromParcel(Parcel parcel) {
            return new TrackToRemove(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TrackToRemove[] newArray(int i) {
            return new TrackToRemove[i];
        }
    };
    public String uri;

    public TrackToRemove(Parcel parcel) {
        this.uri = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uri);
    }

    public TrackToRemove() {
    }
}
