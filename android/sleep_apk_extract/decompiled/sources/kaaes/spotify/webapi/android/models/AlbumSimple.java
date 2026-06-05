package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class AlbumSimple implements Parcelable {
    public static final Parcelable.Creator<AlbumSimple> CREATOR = new Parcelable.Creator<AlbumSimple>() { // from class: kaaes.spotify.webapi.android.models.AlbumSimple.1
        @Override // android.os.Parcelable.Creator
        public AlbumSimple createFromParcel(Parcel parcel) {
            return new AlbumSimple(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AlbumSimple[] newArray(int i) {
            return new AlbumSimple[i];
        }
    };
    public String album_type;
    public List<String> available_markets;
    public Map<String, String> external_urls;
    public String href;
    public String id;
    public List<Image> images;
    public String name;
    public String type;
    public String uri;

    public AlbumSimple(Parcel parcel) {
        this.album_type = parcel.readString();
        this.available_markets = parcel.createStringArrayList();
        this.external_urls = parcel.readHashMap(ClassLoader.getSystemClassLoader());
        this.href = parcel.readString();
        this.id = parcel.readString();
        this.images = parcel.createTypedArrayList(Image.CREATOR);
        this.name = parcel.readString();
        this.type = parcel.readString();
        this.uri = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.album_type);
        parcel.writeStringList(this.available_markets);
        parcel.writeMap(this.external_urls);
        parcel.writeString(this.href);
        parcel.writeString(this.id);
        parcel.writeTypedList(this.images);
        parcel.writeString(this.name);
        parcel.writeString(this.type);
        parcel.writeString(this.uri);
    }

    public AlbumSimple() {
    }
}
