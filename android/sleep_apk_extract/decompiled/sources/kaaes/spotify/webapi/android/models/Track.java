package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class Track extends TrackSimple {
    public static final Parcelable.Creator<Track> CREATOR = new Parcelable.Creator<Track>() { // from class: kaaes.spotify.webapi.android.models.Track.1
        @Override // android.os.Parcelable.Creator
        public Track createFromParcel(Parcel parcel) {
            return new Track(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Track[] newArray(int i) {
            return new Track[i];
        }
    };
    public AlbumSimple album;
    public Map<String, String> external_ids;
    public Integer popularity;

    public Track(Parcel parcel) {
        super(parcel);
        this.album = (AlbumSimple) parcel.readParcelable(AlbumSimple.class.getClassLoader());
        this.external_ids = parcel.readHashMap(Map.class.getClassLoader());
        this.popularity = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }

    @Override // kaaes.spotify.webapi.android.models.TrackSimple, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // kaaes.spotify.webapi.android.models.TrackSimple, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.album, 0);
        parcel.writeMap(this.external_ids);
        parcel.writeValue(this.popularity);
    }

    public Track() {
    }
}
