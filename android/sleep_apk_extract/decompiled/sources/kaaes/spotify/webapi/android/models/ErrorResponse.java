package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class ErrorResponse implements Parcelable {
    public static final Parcelable.Creator<ErrorResponse> CREATOR = new Parcelable.Creator<ErrorResponse>() { // from class: kaaes.spotify.webapi.android.models.ErrorResponse.1
        @Override // android.os.Parcelable.Creator
        public ErrorResponse createFromParcel(Parcel parcel) {
            return new ErrorResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ErrorResponse[] newArray(int i) {
            return new ErrorResponse[i];
        }
    };
    public ErrorDetails error;

    public ErrorResponse(Parcel parcel) {
        this.error = (ErrorDetails) parcel.readParcelable(ErrorDetails.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.error, 0);
    }

    public ErrorResponse() {
    }
}
