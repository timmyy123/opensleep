package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class LinkedTrack implements Parcelable {
    public static final Parcelable.Creator<LinkedTrack> CREATOR = new Parcelable.Creator<LinkedTrack>() { // from class: kaaes.spotify.webapi.android.models.LinkedTrack.1
        @Override // android.os.Parcelable.Creator
        public LinkedTrack createFromParcel(Parcel parcel) {
            return new LinkedTrack(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LinkedTrack[] newArray(int i) {
            return new LinkedTrack[i];
        }
    };
    public Map<String, String> external_urls;
    public String href;
    public String id;
    public String type;
    public String uri;

    public LinkedTrack(Parcel parcel) {
        this.external_urls = parcel.readHashMap(ClassLoader.getSystemClassLoader());
        this.href = parcel.readString();
        this.id = parcel.readString();
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
        parcel.writeString(this.type);
        parcel.writeString(this.uri);
    }

    public LinkedTrack() {
    }
}
