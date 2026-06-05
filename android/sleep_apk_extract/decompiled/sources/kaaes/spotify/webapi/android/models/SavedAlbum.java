package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class SavedAlbum implements Parcelable {
    public static final Parcelable.Creator<SavedAlbum> CREATOR = new Parcelable.Creator<SavedAlbum>() { // from class: kaaes.spotify.webapi.android.models.SavedAlbum.1
        @Override // android.os.Parcelable.Creator
        public SavedAlbum createFromParcel(Parcel parcel) {
            return new SavedAlbum(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SavedAlbum[] newArray(int i) {
            return new SavedAlbum[i];
        }
    };
    public String added_at;
    public Album album;

    public SavedAlbum(Parcel parcel) {
        this.added_at = parcel.readString();
        this.album = (Album) parcel.readParcelable(Album.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.added_at);
        parcel.writeParcelable(this.album, 0);
    }

    public SavedAlbum() {
    }
}
