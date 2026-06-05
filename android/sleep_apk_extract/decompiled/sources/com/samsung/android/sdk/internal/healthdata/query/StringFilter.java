package com.samsung.android.sdk.internal.healthdata.query;

import android.os.Parcel;
import com.samsung.android.sdk.healthdata.HealthDataResolver;

/* JADX INFO: loaded from: classes4.dex */
public class StringFilter extends HealthDataResolver.Filter {
    private String a;
    private String b;

    public StringFilter(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
