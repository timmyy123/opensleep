package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ArtistSimple implements Parcelable {
    public static final Parcelable.Creator<ArtistSimple> CREATOR = new Parcelable.Creator<ArtistSimple>() { // from class: kaaes.spotify.webapi.android.models.ArtistSimple.1
        @Override // android.os.Parcelable.Creator
        public ArtistSimple createFromParcel(Parcel parcel) {
            return new ArtistSimple(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ArtistSimple[] newArray(int i) {
            return new ArtistSimple[i];
        }
    };
    public Map<String, String> external_urls;
    public String href;
    public String id;
    public String name;
    public String type;
    public String uri;

    public ArtistSimple(Parcel parcel) {
        this.external_urls = parcel.readHashMap(Map.class.getClassLoader());
        this.href = parcel.readString();
        this.id = parcel.readString();
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
        parcel.writeMap(this.external_urls);
        parcel.writeString(this.href);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.type);
        parcel.writeString(this.uri);
    }

    public ArtistSimple() {
    }
}
