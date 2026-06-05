package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class TracksToRemove implements Parcelable {
    public static final Parcelable.Creator<TracksToRemove> CREATOR = new Parcelable.Creator<TracksToRemove>() { // from class: kaaes.spotify.webapi.android.models.TracksToRemove.1
        @Override // android.os.Parcelable.Creator
        public TracksToRemove createFromParcel(Parcel parcel) {
            return new TracksToRemove(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TracksToRemove[] newArray(int i) {
            return new TracksToRemove[i];
        }
    };
    public List<TrackToRemove> tracks;

    public TracksToRemove(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.tracks = arrayList;
        parcel.readList(arrayList, List.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.tracks);
    }

    public TracksToRemove() {
    }
}
