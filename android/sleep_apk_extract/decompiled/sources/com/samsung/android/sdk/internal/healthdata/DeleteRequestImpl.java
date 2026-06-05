package com.samsung.android.sdk.internal.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class DeleteRequestImpl implements Parcelable, HealthDataResolver.DeleteRequest {
    public static final Parcelable.Creator<DeleteRequestImpl> CREATOR = new Parcelable.Creator<DeleteRequestImpl>() { // from class: com.samsung.android.sdk.internal.healthdata.DeleteRequestImpl.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DeleteRequestImpl createFromParcel(Parcel parcel) {
            return new DeleteRequestImpl(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DeleteRequestImpl[] newArray(int i) {
            return new DeleteRequestImpl[i];
        }
    };
    private final String a;
    private final HealthDataResolver.Filter b;
    private List<String> c;

    private DeleteRequestImpl(Parcel parcel) {
        this.c = null;
        this.a = parcel.readString();
        this.b = (HealthDataResolver.Filter) parcel.readParcelable(HealthDataResolver.Filter.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
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
        parcel.writeStringList(this.c);
    }

    public DeleteRequestImpl(String str, HealthDataResolver.Filter filter, List<String> list) {
        this.a = str;
        this.b = filter;
        this.c = list;
    }

    public /* synthetic */ DeleteRequestImpl(Parcel parcel, byte b) {
        this(parcel);
    }
}
