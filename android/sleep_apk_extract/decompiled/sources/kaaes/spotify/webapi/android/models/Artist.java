package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Artist extends ArtistSimple {
    public static final Parcelable.Creator<Artist> CREATOR = new Parcelable.Creator<Artist>() { // from class: kaaes.spotify.webapi.android.models.Artist.1
        @Override // android.os.Parcelable.Creator
        public Artist createFromParcel(Parcel parcel) {
            return new Artist(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Artist[] newArray(int i) {
            return new Artist[i];
        }
    };
    public Followers followers;
    public List<String> genres;
    public List<Image> images;
    public Integer popularity;

    public Artist(Parcel parcel) {
        super(parcel);
        this.followers = (Followers) parcel.readParcelable(Followers.class.getClassLoader());
        this.genres = parcel.createStringArrayList();
        this.images = parcel.createTypedArrayList(Image.CREATOR);
        this.popularity = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }

    @Override // kaaes.spotify.webapi.android.models.ArtistSimple, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // kaaes.spotify.webapi.android.models.ArtistSimple, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.followers, i);
        parcel.writeStringList(this.genres);
        parcel.writeTypedList(this.images);
        parcel.writeValue(this.popularity);
    }

    public Artist() {
    }
}
