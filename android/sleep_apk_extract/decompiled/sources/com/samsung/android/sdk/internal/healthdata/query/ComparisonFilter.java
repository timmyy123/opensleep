package com.samsung.android.sdk.internal.healthdata.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthDataResolver;

/* JADX INFO: loaded from: classes4.dex */
public class ComparisonFilter extends HealthDataResolver.Filter {
    private Operator a;
    private String b;
    private Number c;

    public ComparisonFilter(Operator operator, String str, Number number) {
        this.mType = HealthDataResolver.Filter.ParcelType.COMPARABLE;
        this.a = operator;
        this.b = str;
        this.c = number;
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.a = (Operator) parcel.readParcelable(Operator.class.getClassLoader());
        this.b = parcel.readString();
        this.c = (Number) parcel.readSerializable();
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.a, 0);
        parcel.writeString(this.b);
        parcel.writeSerializable(this.c);
    }

    public enum Operator implements Parcelable {
        GREATER_THAN_EQUALS { // from class: com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator.1
        },
        GREATER_THAN { // from class: com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator.2
        },
        LESS_THAN_EQUALS { // from class: com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator.3
        },
        LESS_THAN { // from class: com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator.4
        },
        EQ { // from class: com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator.5
        };

        public static final Parcelable.Creator<Operator> CREATOR = new Parcelable.Creator<Operator>() { // from class: com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator.6
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Operator createFromParcel(Parcel parcel) {
                return Operator.values()[parcel.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Operator[] newArray(int i) {
                return new Operator[i];
            }
        };

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(ordinal());
        }

        /* synthetic */ Operator(byte b) {
            this();
        }
    }

    public ComparisonFilter(Parcel parcel) {
        readFromParcel(parcel);
    }
}
