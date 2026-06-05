package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class Cursor implements Parcelable {
    public static final Parcelable.Creator<Cursor> CREATOR = new Parcelable.Creator<Cursor>() { // from class: kaaes.spotify.webapi.android.models.Cursor.1
        @Override // android.os.Parcelable.Creator
        public Cursor createFromParcel(Parcel parcel) {
            return new Cursor(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Cursor[] newArray(int i) {
            return new Cursor[i];
        }
    };
    public String after;

    public Cursor(Parcel parcel) {
        this.after = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.after);
    }

    public Cursor() {
    }
}
