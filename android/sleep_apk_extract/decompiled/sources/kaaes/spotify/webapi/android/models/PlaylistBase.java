package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PlaylistBase implements Parcelable {
    public Boolean collaborative;
    public Map<String, String> external_urls;
    public String href;
    public String id;
    public List<Image> images;

    @SerializedName("public")
    public Boolean is_public;
    public String name;
    public UserPublic owner;
    public String snapshot_id;
    public String type;
    public String uri;

    public PlaylistBase(Parcel parcel) {
        this.collaborative = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.external_urls = parcel.readHashMap(Map.class.getClassLoader());
        this.href = (String) parcel.readValue(String.class.getClassLoader());
        this.id = (String) parcel.readValue(String.class.getClassLoader());
        this.images = parcel.createTypedArrayList(Image.CREATOR);
        this.name = (String) parcel.readValue(String.class.getClassLoader());
        this.owner = (UserPublic) parcel.readParcelable(UserPublic.class.getClassLoader());
        this.is_public = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.snapshot_id = (String) parcel.readValue(String.class.getClassLoader());
        this.type = (String) parcel.readValue(String.class.getClassLoader());
        this.uri = (String) parcel.readValue(String.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.collaborative);
        parcel.writeMap(this.external_urls);
        parcel.writeValue(this.href);
        parcel.writeValue(this.id);
        parcel.writeTypedList(this.images);
        parcel.writeValue(this.name);
        parcel.writeParcelable(this.owner, i);
        parcel.writeValue(this.is_public);
        parcel.writeValue(this.snapshot_id);
        parcel.writeValue(this.type);
        parcel.writeValue(this.uri);
    }

    public PlaylistBase() {
    }
}
