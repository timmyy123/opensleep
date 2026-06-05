package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class TracksToRemoveWithPosition implements Parcelable {
    public static final Parcelable.Creator<TracksToRemoveWithPosition> CREATOR = new Parcelable.Creator<TracksToRemoveWithPosition>() { // from class: kaaes.spotify.webapi.android.models.TracksToRemoveWithPosition.1
        @Override // android.os.Parcelable.Creator
        public TracksToRemoveWithPosition createFromParcel(Parcel parcel) {
            return new TracksToRemoveWithPosition(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TracksToRemoveWithPosition[] newArray(int i) {
            return new TracksToRemoveWithPosition[i];
        }
    };
    public List<TrackToRemoveWithPosition> tracks;

    public TracksToRemoveWithPosition(Parcel parcel) {
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

    public TracksToRemoveWithPosition() {
    }
}
