package com.samsung.android.sdk.internal.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class ReadRequestImpl implements Parcelable, HealthDataResolver.ReadRequest {
    public static final Parcelable.Creator<ReadRequestImpl> CREATOR = new Parcelable.Creator<ReadRequestImpl>() { // from class: com.samsung.android.sdk.internal.healthdata.ReadRequestImpl.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ReadRequestImpl createFromParcel(Parcel parcel) {
            return new ReadRequestImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ReadRequestImpl[] newArray(int i) {
            return new ReadRequestImpl[i];
        }
    };
    private final String a;
    private String b;
    private String c;
    private long d;
    private long e;
    private int f;
    private int g;
    private HealthDataResolver.Filter h;
    private List<Projection> i;
    private List<String> j;
    private byte k;
    private long l;

    public ReadRequestImpl(Parcel parcel) {
        this.i = null;
        this.j = null;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = (HealthDataResolver.Filter) parcel.readParcelable(HealthDataResolver.Filter.class.getClassLoader());
        this.i = parcel.createTypedArrayList(Projection.CREATOR);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        parcel.readStringList(arrayList);
        this.k = parcel.readByte();
        this.l = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeParcelable(this.h, 0);
        parcel.writeTypedList(this.i);
        parcel.writeStringList(this.j);
        parcel.writeByte(this.k);
        parcel.writeLong(this.l);
    }

    public static class Projection implements Parcelable {
        public static final Parcelable.Creator<Projection> CREATOR = new Parcelable.Creator<Projection>() { // from class: com.samsung.android.sdk.internal.healthdata.ReadRequestImpl.Projection.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Projection createFromParcel(Parcel parcel) {
                return new Projection(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Projection[] newArray(int i) {
                return new Projection[i];
            }
        };
        private String a;
        private String b;

        public Projection(String str, String str2) {
            if (str == null || str.isEmpty()) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Null or empty property for read request is not allowed");
                throw null;
            }
            this.a = str;
            this.b = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAlias() {
            return this.b;
        }

        public String getProperty() {
            return this.a;
        }

        public String toString() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
        }

        public Projection(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readString();
        }
    }

    public ReadRequestImpl(String str, String str2, HealthDataResolver.Filter filter, List<Projection> list, List<String> list2, byte b, String str3, long j, long j2, int i, int i2, long j3) {
        this.a = str;
        this.c = str2;
        this.b = str3;
        this.d = j;
        this.e = j2;
        this.f = i;
        this.g = i2;
        this.h = filter;
        this.i = list;
        this.j = list2;
        this.k = b;
        this.l = j3;
    }
}
