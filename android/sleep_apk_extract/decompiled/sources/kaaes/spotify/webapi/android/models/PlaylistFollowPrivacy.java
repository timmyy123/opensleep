package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class PlaylistFollowPrivacy implements Parcelable {
    public static final Parcelable.Creator<PlaylistFollowPrivacy> CREATOR = new Parcelable.Creator<PlaylistFollowPrivacy>() { // from class: kaaes.spotify.webapi.android.models.PlaylistFollowPrivacy.1
        @Override // android.os.Parcelable.Creator
        public PlaylistFollowPrivacy createFromParcel(Parcel parcel) {
            return new PlaylistFollowPrivacy(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PlaylistFollowPrivacy[] newArray(int i) {
            return new PlaylistFollowPrivacy[i];
        }
    };

    @SerializedName("public")
    public Boolean is_public;

    public PlaylistFollowPrivacy(Parcel parcel) {
        this.is_public = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.is_public);
    }

    public PlaylistFollowPrivacy() {
    }
}
