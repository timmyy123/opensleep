package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Pager<T> implements Parcelable {
    public static final Parcelable.Creator<Pager> CREATOR = new Parcelable.Creator<Pager>() { // from class: kaaes.spotify.webapi.android.models.Pager.1
        @Override // android.os.Parcelable.Creator
        public Pager createFromParcel(Parcel parcel) {
            return new Pager(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Pager[] newArray(int i) {
            return new Pager[i];
        }
    };
    public String href;
    public List<T> items;
    public int limit;
    public String next;
    public int offset;
    public String previous;
    public int total;

    public Pager(Parcel parcel) {
        this.href = parcel.readString();
        this.items = parcel.readArrayList(ArrayList.class.getClassLoader());
        this.limit = parcel.readInt();
        this.next = parcel.readString();
        this.offset = parcel.readInt();
        this.previous = parcel.readString();
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
        parcel.writeInt(this.offset);
        parcel.writeString(this.previous);
        parcel.writeInt(this.total);
    }

    public Pager() {
    }
}
