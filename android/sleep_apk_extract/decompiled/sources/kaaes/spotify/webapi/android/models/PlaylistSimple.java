package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class PlaylistSimple extends PlaylistBase {
    public static final Parcelable.Creator<PlaylistSimple> CREATOR = new Parcelable.Creator<PlaylistSimple>() { // from class: kaaes.spotify.webapi.android.models.PlaylistSimple.1
        @Override // android.os.Parcelable.Creator
        public PlaylistSimple createFromParcel(Parcel parcel) {
            return new PlaylistSimple(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PlaylistSimple[] newArray(int i) {
            return new PlaylistSimple[i];
        }
    };
    public PlaylistTracksInformation tracks;

    public PlaylistSimple(Parcel parcel) {
        super(parcel);
        this.tracks = (PlaylistTracksInformation) parcel.readParcelable(PlaylistTracksInformation.class.getClassLoader());
    }

    @Override // kaaes.spotify.webapi.android.models.PlaylistBase, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // kaaes.spotify.webapi.android.models.PlaylistBase, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.tracks, i);
    }

    public PlaylistSimple() {
    }
}
