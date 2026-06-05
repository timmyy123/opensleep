package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class UserPublic implements Parcelable {
    public static final Parcelable.Creator<UserPublic> CREATOR = new Parcelable.Creator<UserPublic>() { // from class: kaaes.spotify.webapi.android.models.UserPublic.1
        @Override // android.os.Parcelable.Creator
        public UserPublic createFromParcel(Parcel parcel) {
            return new UserPublic(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UserPublic[] newArray(int i) {
            return new UserPublic[i];
        }
    };
    public String display_name;
    public Map<String, String> external_urls;
    public Followers followers;
    public String href;
    public String id;
    public List<Image> images;
    public String type;
    public String uri;

    public UserPublic(Parcel parcel) {
        this.display_name = parcel.readString();
        this.external_urls = parcel.readHashMap(Map.class.getClassLoader());
        this.followers = (Followers) parcel.readParcelable(Followers.class.getClassLoader());
        this.href = parcel.readString();
        this.id = parcel.readString();
        this.images = parcel.createTypedArrayList(Image.CREATOR);
        this.type = parcel.readString();
        this.uri = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.display_name);
        parcel.writeMap(this.external_urls);
        parcel.writeParcelable(this.followers, 0);
        parcel.writeString(this.href);
        parcel.writeString(this.id);
        parcel.writeTypedList(this.images);
        parcel.writeString(this.type);
        parcel.writeString(this.uri);
    }

    public UserPublic() {
    }
}
