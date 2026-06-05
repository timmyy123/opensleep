package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class ErrorDetails implements Parcelable {
    public static final Parcelable.Creator<ErrorDetails> CREATOR = new Parcelable.Creator<ErrorDetails>() { // from class: kaaes.spotify.webapi.android.models.ErrorDetails.1
        @Override // android.os.Parcelable.Creator
        public ErrorDetails createFromParcel(Parcel parcel) {
            return new ErrorDetails(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ErrorDetails[] newArray(int i) {
            return new ErrorDetails[i];
        }
    };
    public String message;
    public int status;

    public ErrorDetails(Parcel parcel) {
        this.status = parcel.readInt();
        this.message = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.status);
        parcel.writeString(this.message);
    }

    public ErrorDetails() {
    }
}
