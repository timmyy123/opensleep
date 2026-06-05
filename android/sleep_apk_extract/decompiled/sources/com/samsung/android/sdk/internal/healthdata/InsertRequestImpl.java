package com.samsung.android.sdk.internal.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthData;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class InsertRequestImpl implements Parcelable, HealthDataResolver.InsertRequest {
    public static final Parcelable.Creator<InsertRequestImpl> CREATOR = new Parcelable.Creator<InsertRequestImpl>() { // from class: com.samsung.android.sdk.internal.healthdata.InsertRequestImpl.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ InsertRequestImpl createFromParcel(Parcel parcel) {
            return new InsertRequestImpl(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ InsertRequestImpl[] newArray(int i) {
            return new InsertRequestImpl[i];
        }
    };
    private final String a;
    private final List<HealthData> b;

    private InsertRequestImpl(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.createTypedArrayList(HealthData.CREATOR);
    }

    private static void a(HealthData healthData) {
        if (healthData == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("data is null");
        } else {
            if (healthData.getSourceDevice() != null) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("source device is not set");
        }
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.InsertRequest
    public final void addHealthData(HealthData healthData) {
        a(healthData);
        this.b.add(healthData);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final List<HealthData> getItems() {
        return this.b;
    }

    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeTypedList(this.b);
    }

    public InsertRequestImpl(String str) {
        this.a = str;
        this.b = new ArrayList();
    }

    public /* synthetic */ InsertRequestImpl(Parcel parcel, byte b) {
        this(parcel);
    }
}
