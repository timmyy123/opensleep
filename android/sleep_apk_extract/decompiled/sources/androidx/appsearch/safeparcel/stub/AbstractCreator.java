package androidx.appsearch.safeparcel.stub;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractCreator<T> implements Parcelable.Creator<T> {
    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel parcel) {
        throw new UnsupportedOperationException("createFromParcel is not implemented and should not be used.");
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i) {
        throw new UnsupportedOperationException("newArray is not implemented and should not be used.");
    }
}
