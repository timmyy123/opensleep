package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class SavedTrack implements Parcelable {
    public static final Parcelable.Creator<SavedTrack> CREATOR = new Parcelable.Creator<SavedTrack>() { // from class: kaaes.spotify.webapi.android.models.SavedTrack.1
        @Override // android.os.Parcelable.Creator
        public SavedTrack createFromParcel(Parcel parcel) {
            return new SavedTrack(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SavedTrack[] newArray(int i) {
            return new SavedTrack[i];
        }
    };
    public String added_at;
    public Track track;

    public SavedTrack(Parcel parcel) {
        this.added_at = parcel.readString();
        this.track = (Track) parcel.readParcelable(Track.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.added_at);
        parcel.writeParcelable(this.track, 0);
    }

    public SavedTrack() {
    }
}
