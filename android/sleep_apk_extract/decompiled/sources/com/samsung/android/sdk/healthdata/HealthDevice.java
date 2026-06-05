package com.samsung.android.sdk.healthdata;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public final class HealthDevice implements Parcelable {
    public static final Parcelable.Creator<HealthDevice> CREATOR = new Parcelable.Creator<HealthDevice>() { // from class: com.samsung.android.sdk.healthdata.HealthDevice.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ HealthDevice createFromParcel(Parcel parcel) {
            return new HealthDevice(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ HealthDevice[] newArray(int i) {
            return new HealthDevice[i];
        }
    };
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final String f;

    private HealthDevice(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HealthDevice)) {
            return false;
        }
        HealthDevice healthDevice = (HealthDevice) obj;
        String str2 = this.f;
        if (str2 == null || (str = healthDevice.f) == null) {
            return false;
        }
        return str2.equals(str);
    }

    public final String getUuid() {
        return this.a;
    }

    public final int hashCode() {
        String str = this.f;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
    }

    public /* synthetic */ HealthDevice(Parcel parcel, byte b) {
        this(parcel);
    }
}
