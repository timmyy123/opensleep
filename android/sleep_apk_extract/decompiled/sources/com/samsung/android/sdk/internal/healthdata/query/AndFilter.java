package com.samsung.android.sdk.internal.healthdata.query;

import android.os.Parcel;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class AndFilter extends HealthDataResolver.Filter {
    public AndFilter(HealthDataResolver.Filter filter, HealthDataResolver.Filter... filterArr) {
        HealthDataResolver.Filter.checkFilter(filter);
        for (HealthDataResolver.Filter filter2 : filterArr) {
            HealthDataResolver.Filter.checkFilter(filter2);
        }
        this.mType = HealthDataResolver.Filter.ParcelType.AND;
        this.mFilters.add(filter);
        this.mFilters.addAll(Arrays.asList(filterArr));
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mFilters = parcel.createTypedArrayList(HealthDataResolver.Filter.CREATOR);
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.mFilters);
    }

    public AndFilter(Parcel parcel) {
        readFromParcel(parcel);
    }
}
