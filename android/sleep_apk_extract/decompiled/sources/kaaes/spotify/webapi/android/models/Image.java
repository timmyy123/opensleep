package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class Image implements Parcelable {
    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() { // from class: kaaes.spotify.webapi.android.models.Image.1
        @Override // android.os.Parcelable.Creator
        public Image createFromParcel(Parcel parcel) {
            return new Image(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Image[] newArray(int i) {
            return new Image[i];
        }
    };
    public Integer height;
    public String url;
    public Integer width;

    public Image(Parcel parcel) {
        this.width = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.height = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.url = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.width);
        parcel.writeValue(this.height);
        parcel.writeString(this.url);
    }

    public Image() {
    }
}
