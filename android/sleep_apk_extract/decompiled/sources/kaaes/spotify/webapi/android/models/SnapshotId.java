package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class SnapshotId implements Parcelable {
    public static final Parcelable.Creator<SnapshotId> CREATOR = new Parcelable.Creator<SnapshotId>() { // from class: kaaes.spotify.webapi.android.models.SnapshotId.1
        @Override // android.os.Parcelable.Creator
        public SnapshotId createFromParcel(Parcel parcel) {
            return new SnapshotId(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SnapshotId[] newArray(int i) {
            return new SnapshotId[i];
        }
    };
    public String snapshot_id;

    public SnapshotId(Parcel parcel) {
        this.snapshot_id = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.snapshot_id);
    }

    public SnapshotId() {
    }
}
