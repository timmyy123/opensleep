package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class Album extends AlbumSimple implements Parcelable {
    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() { // from class: kaaes.spotify.webapi.android.models.Album.1
        @Override // android.os.Parcelable.Creator
        public Album createFromParcel(Parcel parcel) {
            return new Album(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Album[] newArray(int i) {
            return new Album[i];
        }
    };
    public List<ArtistSimple> artists;
    public List<Copyright> copyrights;
    public Map<String, String> external_ids;
    public List<String> genres;
    public Integer popularity;
    public String release_date;
    public String release_date_precision;
    public Pager<TrackSimple> tracks;

    public Album(Parcel parcel) {
        super(parcel);
        this.artists = parcel.createTypedArrayList(ArtistSimple.CREATOR);
        this.copyrights = parcel.createTypedArrayList(Copyright.CREATOR);
        this.external_ids = parcel.readHashMap(ClassLoader.getSystemClassLoader());
        this.genres = parcel.createStringArrayList();
        this.popularity = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.release_date = parcel.readString();
        this.release_date_precision = parcel.readString();
        this.tracks = (Pager) parcel.readParcelable(Pager.class.getClassLoader());
    }

    @Override // kaaes.spotify.webapi.android.models.AlbumSimple, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // kaaes.spotify.webapi.android.models.AlbumSimple, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.artists);
        parcel.writeTypedList(this.copyrights);
        parcel.writeMap(this.external_ids);
        parcel.writeStringList(this.genres);
        parcel.writeValue(this.popularity);
        parcel.writeString(this.release_date);
        parcel.writeString(this.release_date_precision);
        parcel.writeParcelable(this.tracks, i);
    }

    public Album() {
    }
}
