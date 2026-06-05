package com.samsung.android.sdk.internal.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthData;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdateRequestImpl implements Parcelable {
    public static final Parcelable.Creator<UpdateRequestImpl> CREATOR = new Parcelable.Creator<UpdateRequestImpl>() { // from class: com.samsung.android.sdk.internal.healthdata.UpdateRequestImpl.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UpdateRequestImpl createFromParcel(Parcel parcel) {
            return new UpdateRequestImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UpdateRequestImpl[] newArray(int i) {
            return new UpdateRequestImpl[i];
        }
    };
    private final String a;
    private final HealthData b;
    private final HealthDataResolver.Filter c;
    private List<String> d;

    public UpdateRequestImpl(Parcel parcel) {
        this.d = null;
        this.a = parcel.readString();
        this.b = (HealthData) parcel.readParcelable(HealthData.class.getClassLoader());
        this.c = (HealthDataResolver.Filter) parcel.readParcelable(HealthDataResolver.Filter.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        parcel.readStringList(arrayList);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.c, 0);
        parcel.writeStringList(this.d);
    }
}
