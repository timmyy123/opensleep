package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class Seed implements Parcelable {
    public static final Parcelable.Creator<Seed> CREATOR = new Parcelable.Creator<Seed>() { // from class: kaaes.spotify.webapi.android.models.Seed.1
        @Override // android.os.Parcelable.Creator
        public Seed createFromParcel(Parcel parcel) {
            return new Seed(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Seed[] newArray(int i) {
            return new Seed[i];
        }
    };
    public int afterFilteringSize;
    public int afterRelinkingSize;
    public String href;
    public String id;
    public int initialPoolSize;
    public String type;

    public Seed(Parcel parcel) {
        this.afterFilteringSize = parcel.readInt();
        this.afterRelinkingSize = parcel.readInt();
        this.href = parcel.readString();
        this.id = parcel.readString();
        this.initialPoolSize = parcel.readInt();
        this.type = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.afterFilteringSize);
        parcel.writeInt(this.afterRelinkingSize);
        parcel.writeString(this.href);
        parcel.writeString(this.id);
        parcel.writeInt(this.initialPoolSize);
        parcel.writeString(this.type);
    }

    public Seed() {
    }
}
