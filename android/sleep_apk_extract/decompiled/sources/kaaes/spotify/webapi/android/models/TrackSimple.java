package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class TrackSimple implements Parcelable {
    public static final Parcelable.Creator<TrackSimple> CREATOR = new Parcelable.Creator<TrackSimple>() { // from class: kaaes.spotify.webapi.android.models.TrackSimple.1
        @Override // android.os.Parcelable.Creator
        public TrackSimple createFromParcel(Parcel parcel) {
            return new TrackSimple(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TrackSimple[] newArray(int i) {
            return new TrackSimple[i];
        }
    };
    public List<ArtistSimple> artists;
    public List<String> available_markets;
    public int disc_number;
    public long duration_ms;
    public Boolean explicit;
    public Map<String, String> external_urls;
    public String href;
    public String id;
    public Boolean is_playable;
    public LinkedTrack linked_from;
    public String name;
    public String preview_url;
    public int track_number;
    public String type;
    public String uri;

    public TrackSimple(Parcel parcel) {
        this.artists = parcel.createTypedArrayList(ArtistSimple.CREATOR);
        this.available_markets = parcel.createStringArrayList();
        this.is_playable = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.linked_from = (LinkedTrack) parcel.readParcelable(LinkedTrack.class.getClassLoader());
        this.disc_number = parcel.readInt();
        this.duration_ms = parcel.readLong();
        this.explicit = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.external_urls = parcel.readHashMap(Map.class.getClassLoader());
        this.href = parcel.readString();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.preview_url = parcel.readString();
        this.track_number = parcel.readInt();
        this.type = parcel.readString();
        this.uri = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.artists);
        parcel.writeStringList(this.available_markets);
        parcel.writeValue(this.is_playable);
        parcel.writeParcelable(this.linked_from, 0);
        parcel.writeInt(this.disc_number);
        parcel.writeLong(this.duration_ms);
        parcel.writeValue(this.explicit);
        parcel.writeMap(this.external_urls);
        parcel.writeString(this.href);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.preview_url);
        parcel.writeInt(this.track_number);
        parcel.writeString(this.type);
        parcel.writeString(this.uri);
    }

    public TrackSimple() {
    }
}
