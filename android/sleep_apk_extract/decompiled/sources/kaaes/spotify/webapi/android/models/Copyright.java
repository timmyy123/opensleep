package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class Copyright implements Parcelable {
    public static final Parcelable.Creator<Copyright> CREATOR = new Parcelable.Creator<Copyright>() { // from class: kaaes.spotify.webapi.android.models.Copyright.1
        @Override // android.os.Parcelable.Creator
        public Copyright createFromParcel(Parcel parcel) {
            return new Copyright(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Copyright[] newArray(int i) {
            return new Copyright[i];
        }
    };
    public String text;
    public String type;

    public Copyright(Parcel parcel) {
        this.text = parcel.readString();
        this.type = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
        parcel.writeString(this.type);
    }

    public Copyright() {
    }
}
