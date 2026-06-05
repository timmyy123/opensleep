package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class TrackToRemoveWithPosition implements Parcelable {
    public static final Parcelable.Creator<TrackToRemoveWithPosition> CREATOR = new Parcelable.Creator<TrackToRemoveWithPosition>() { // from class: kaaes.spotify.webapi.android.models.TrackToRemoveWithPosition.1
        @Override // android.os.Parcelable.Creator
        public TrackToRemoveWithPosition createFromParcel(Parcel parcel) {
            return new TrackToRemoveWithPosition(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TrackToRemoveWithPosition[] newArray(int i) {
            return new TrackToRemoveWithPosition[i];
        }
    };
    public List<Integer> positions;
    public String uri;

    public TrackToRemoveWithPosition(Parcel parcel) {
        this.uri = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.positions = arrayList;
        parcel.readList(arrayList, List.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uri);
        parcel.writeList(this.positions);
    }

    public TrackToRemoveWithPosition() {
    }
}
