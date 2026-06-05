package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class PlaylistTracksInformation implements Parcelable {
    public static final Parcelable.Creator<PlaylistTracksInformation> CREATOR = new Parcelable.Creator<PlaylistTracksInformation>() { // from class: kaaes.spotify.webapi.android.models.PlaylistTracksInformation.1
        @Override // android.os.Parcelable.Creator
        public PlaylistTracksInformation createFromParcel(Parcel parcel) {
            return new PlaylistTracksInformation(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PlaylistTracksInformation[] newArray(int i) {
            return new PlaylistTracksInformation[i];
        }
    };
    public String href;
    public int total;

    public PlaylistTracksInformation(Parcel parcel) {
        this.href = parcel.readString();
        this.total = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
        parcel.writeInt(this.total);
    }

    public PlaylistTracksInformation() {
    }
}
