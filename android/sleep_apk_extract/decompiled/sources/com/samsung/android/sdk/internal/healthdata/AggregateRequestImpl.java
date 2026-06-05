package com.samsung.android.sdk.internal.healthdata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class AggregateRequestImpl implements Parcelable, HealthDataResolver.AggregateRequest {
    public static final Parcelable.Creator<AggregateRequestImpl> CREATOR = new Parcelable.Creator<AggregateRequestImpl>() { // from class: com.samsung.android.sdk.internal.healthdata.AggregateRequestImpl.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AggregateRequestImpl createFromParcel(Parcel parcel) {
            return new AggregateRequestImpl(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AggregateRequestImpl[] newArray(int i) {
            return new AggregateRequestImpl[i];
        }
    };
    private final String a;
    private final String b;
    private final List<AggregatePair> c;
    private final List<Group> d;
    private final TimeGroup e;
    private final HealthDataResolver.Filter f;
    private final List<String> g;
    private final String h;
    private final long i;
    private final long j;

    /* JADX INFO: renamed from: com.samsung.android.sdk.internal.healthdata.AggregateRequestImpl$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[HealthDataResolver.AggregateRequest.TimeGroupUnit.values().length];
            a = iArr;
            try {
                iArr[HealthDataResolver.AggregateRequest.TimeGroupUnit.MINUTELY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[HealthDataResolver.AggregateRequest.TimeGroupUnit.HOURLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[HealthDataResolver.AggregateRequest.TimeGroupUnit.DAILY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[HealthDataResolver.AggregateRequest.TimeGroupUnit.WEEKLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[HealthDataResolver.AggregateRequest.TimeGroupUnit.MONTHLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class Group implements Parcelable {
        public static final Parcelable.Creator<Group> CREATOR = new Parcelable.Creator<Group>() { // from class: com.samsung.android.sdk.internal.healthdata.AggregateRequestImpl.Group.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Group createFromParcel(Parcel parcel) {
                return new Group(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Group[] newArray(int i) {
                return new Group[i];
            }
        };
        private String a;
        private String b;

        public Group(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
        }
    }

    private AggregateRequestImpl(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.createTypedArrayList(AggregatePair.CREATOR);
        this.d = parcel.createTypedArrayList(Group.CREATOR);
        this.e = (TimeGroup) parcel.readParcelable(TimeGroup.class.getClassLoader());
        this.f = (HealthDataResolver.Filter) parcel.readParcelable(HealthDataResolver.Filter.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        parcel.readStringList(arrayList);
        this.h = parcel.readString();
        this.i = parcel.readLong();
        this.j = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeTypedList(this.c);
        parcel.writeTypedList(this.d);
        parcel.writeParcelable(this.e, 0);
        parcel.writeParcelable(this.f, 0);
        parcel.writeStringList(this.g);
        parcel.writeString(this.h);
        parcel.writeLong(this.i);
        parcel.writeLong(this.j);
    }

    public static class AggregatePair implements Parcelable {
        public static final Parcelable.Creator<AggregatePair> CREATOR = new Parcelable.Creator<AggregatePair>() { // from class: com.samsung.android.sdk.internal.healthdata.AggregateRequestImpl.AggregatePair.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AggregatePair createFromParcel(Parcel parcel) {
                return new AggregatePair(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AggregatePair[] newArray(int i) {
                return new AggregatePair[i];
            }
        };
        private int a;
        private String b;
        private String c;

        public AggregatePair(HealthDataResolver.AggregateRequest.AggregateFunction aggregateFunction, String str, String str2) {
            if (aggregateFunction == null || str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Insufficient arguments for aggregate function");
                throw null;
            }
            this.a = aggregateFunction.getValue();
            this.b = str;
            this.c = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(HealthDataResolver.AggregateRequest.AggregateFunction.from(this.a).toSqlLiteral());
            sb.append('(');
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.b, ')');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
        }

        public AggregatePair(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readString();
            this.c = parcel.readString();
        }
    }

    public AggregateRequestImpl(String str, String str2, List<AggregatePair> list, List<Group> list2, TimeGroup timeGroup, HealthDataResolver.Filter filter, List<String> list3, String str3, long j, long j2) {
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = list2;
        this.e = timeGroup;
        this.f = filter;
        this.g = list3;
        this.h = str3;
        this.i = j;
        this.j = j2;
    }

    public /* synthetic */ AggregateRequestImpl(Parcel parcel, byte b) {
        this(parcel);
    }

    public static class TimeGroup implements Parcelable {
        public static final Parcelable.Creator<TimeGroup> CREATOR = new Parcelable.Creator<TimeGroup>() { // from class: com.samsung.android.sdk.internal.healthdata.AggregateRequestImpl.TimeGroup.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TimeGroup createFromParcel(Parcel parcel) {
                return new TimeGroup(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ TimeGroup[] newArray(int i) {
                return new TimeGroup[i];
            }
        };
        private int a;
        private int b;
        private String c;
        private String d;
        private String e;

        public TimeGroup(HealthDataResolver.AggregateRequest.TimeGroupUnit timeGroupUnit, int i, String str, String str2, String str3) {
            if (timeGroupUnit == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid timeUnit");
                throw null;
            }
            if (i == 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid amount");
                throw null;
            }
            int i2 = AnonymousClass2.a[timeGroupUnit.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3 || i2 == 4) {
                        if (i != 1) {
                            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid amount");
                            throw null;
                        }
                    } else {
                        if (i2 != 5) {
                            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid timeUnit");
                            throw null;
                        }
                        if (i != 1 && i != 3 && i != 6) {
                            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid amount");
                            throw null;
                        }
                    }
                } else if (24 % i != 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid amount");
                    throw null;
                }
            } else if (60 % i != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid amount");
                throw null;
            }
            if (str == null || str.isEmpty() || str3 == null || str3.isEmpty()) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Insufficient arguments for time group");
                throw null;
            }
            this.a = timeGroupUnit.getValue();
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return HealthDataResolver.AggregateRequest.TimeGroupUnit.from(this.a).toSqlLiteral(this.c, this.d, this.b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
        }

        public TimeGroup(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
        }
    }
}
