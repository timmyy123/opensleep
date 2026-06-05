package com.samsung.android.sdk.healthdata;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public final class HealthData implements Parcelable {
    public static final Parcelable.Creator<HealthData> CREATOR = new Parcelable.Creator<HealthData>() { // from class: com.samsung.android.sdk.healthdata.HealthData.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ HealthData createFromParcel(Parcel parcel) {
            return new HealthData(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ HealthData[] newArray(int i) {
            return new HealthData[i];
        }
    };
    private String a;
    private String b;
    private final ContentValues c;
    private Map<String, byte[]> d;

    private HealthData(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (ContentValues) ContentValues.CREATOR.createFromParcel(parcel);
    }

    private void a() {
        this.a = UUID.randomUUID().toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Object get(String str) {
        return this.c.get(str);
    }

    public final byte[] getBlob(String str) {
        byte[] bArr = this.d.get(str);
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public final Set<String> getBlobKeySet() {
        return this.d.keySet();
    }

    public final String getSourceDevice() {
        return this.b;
    }

    public final String getUuid() {
        return this.a;
    }

    public final void putInt(String str, int i) {
        this.c.put(str, Integer.valueOf(i));
    }

    public final void putLong(String str, long j) {
        this.c.put(str, Long.valueOf(j));
    }

    public final void putString(String str, String str2) {
        this.c.put(str, str2);
        this.d.remove(str);
    }

    public final void setSourceDevice(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        this.c.writeToParcel(parcel, 0);
    }

    public HealthData() {
        this.c = new ContentValues();
        this.d = new HashMap();
        a();
    }

    public /* synthetic */ HealthData(Parcel parcel, byte b) {
        this(parcel);
    }
}
