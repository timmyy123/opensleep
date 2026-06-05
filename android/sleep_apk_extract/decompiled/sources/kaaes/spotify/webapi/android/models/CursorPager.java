package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class CursorPager<T> implements Parcelable {
    public static final Parcelable.Creator<CursorPager> CREATOR = new Parcelable.Creator<CursorPager>() { // from class: kaaes.spotify.webapi.android.models.CursorPager.1
        @Override // android.os.Parcelable.Creator
        public CursorPager createFromParcel(Parcel parcel) {
            return new CursorPager(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CursorPager[] newArray(int i) {
            return new CursorPager[i];
        }
    };
    public Cursor cursors;
    public String href;
    public List<T> items;
    public int limit;
    public String next;
    public int total;

    public CursorPager(Parcel parcel) {
        this.href = parcel.readString();
        this.items = parcel.readArrayList(ArrayList.class.getClassLoader());
        this.limit = parcel.readInt();
        this.next = parcel.readString();
        this.cursors = (Cursor) parcel.readParcelable(Cursor.class.getClassLoader());
        this.total = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
        parcel.writeList(this.items);
        parcel.writeInt(this.limit);
        parcel.writeString(this.next);
        parcel.writeParcelable(this.cursors, i);
        parcel.writeInt(this.total);
    }

    public CursorPager() {
    }
}
