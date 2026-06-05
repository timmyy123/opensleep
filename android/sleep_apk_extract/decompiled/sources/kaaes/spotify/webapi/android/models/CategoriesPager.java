package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class CategoriesPager implements Parcelable {
    public static final Parcelable.Creator<CategoriesPager> CREATOR = new Parcelable.Creator<CategoriesPager>() { // from class: kaaes.spotify.webapi.android.models.CategoriesPager.1
        @Override // android.os.Parcelable.Creator
        public CategoriesPager createFromParcel(Parcel parcel) {
            return new CategoriesPager(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CategoriesPager[] newArray(int i) {
            return new CategoriesPager[i];
        }
    };
    public Pager<Category> categories;

    public CategoriesPager(Parcel parcel) {
        this.categories = (Pager) parcel.readParcelable(Pager.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.categories, 0);
    }

    public CategoriesPager() {
    }
}
