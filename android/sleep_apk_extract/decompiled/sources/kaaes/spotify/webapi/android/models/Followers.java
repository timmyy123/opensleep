package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class Followers implements Parcelable {
    public static final Parcelable.Creator<Followers> CREATOR = new Parcelable.Creator<Followers>() { // from class: kaaes.spotify.webapi.android.models.Followers.1
        @Override // android.os.Parcelable.Creator
        public Followers createFromParcel(Parcel parcel) {
            return new Followers(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Followers[] newArray(int i) {
            return new Followers[i];
        }
    };
    public String href;
    public Integer total;

    public Followers(Parcel parcel) {
        this.href = parcel.readString();
        this.total = Integer.valueOf(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
        parcel.writeInt(this.total.intValue());
    }

    public Followers() {
    }
}
