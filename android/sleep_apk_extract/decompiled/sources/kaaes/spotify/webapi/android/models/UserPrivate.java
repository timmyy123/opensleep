package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class UserPrivate extends UserPublic {
    public static final Parcelable.Creator<UserPrivate> CREATOR = new Parcelable.Creator<UserPrivate>() { // from class: kaaes.spotify.webapi.android.models.UserPrivate.1
        @Override // android.os.Parcelable.Creator
        public UserPrivate createFromParcel(Parcel parcel) {
            return new UserPrivate(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UserPrivate[] newArray(int i) {
            return new UserPrivate[i];
        }
    };
    public String birthdate;
    public String country;
    public String email;
    public String product;

    public UserPrivate(Parcel parcel) {
        super(parcel);
        this.birthdate = parcel.readString();
        this.country = parcel.readString();
        this.email = parcel.readString();
        this.product = parcel.readString();
    }

    @Override // kaaes.spotify.webapi.android.models.UserPublic, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // kaaes.spotify.webapi.android.models.UserPublic, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.birthdate);
        parcel.writeString(this.country);
        parcel.writeString(this.email);
        parcel.writeString(this.product);
    }

    public UserPrivate() {
    }
}
