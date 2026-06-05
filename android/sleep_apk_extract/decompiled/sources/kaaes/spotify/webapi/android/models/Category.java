package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Category implements Parcelable {
    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() { // from class: kaaes.spotify.webapi.android.models.Category.1
        @Override // android.os.Parcelable.Creator
        public Category createFromParcel(Parcel parcel) {
            return new Category(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Category[] newArray(int i) {
            return new Category[i];
        }
    };
    public String href;
    public List<Image> icons;
    public String id;
    public String name;

    public Category(Parcel parcel) {
        this.href = parcel.readString();
        this.icons = parcel.createTypedArrayList(Image.CREATOR);
        this.id = parcel.readString();
        this.name = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
        parcel.writeTypedList(this.icons);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
    }

    public Category() {
    }
}
