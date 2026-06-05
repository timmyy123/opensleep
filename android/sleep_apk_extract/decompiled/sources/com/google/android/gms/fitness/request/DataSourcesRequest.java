package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DataSourcesRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new zzm();
    private final List zza;
    private final List zzb;
    private final com.google.android.gms.internal.fitness.zzaz zzc;

    public DataSourcesRequest(List list, List list2, IBinder iBinder) {
        this.zza = list;
        this.zzb = list2;
        this.zzc = iBinder == null ? null : com.google.android.gms.internal.fitness.zzay.zzc(iBinder);
    }

    public List<DataType> getDataTypes() {
        return this.zza;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataTypes", this.zza).add("sourceTypes", this.zzb).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataTypes(), false);
        SafeParcelWriter.writeIntegerList(parcel, 2, this.zzb, false);
        com.google.android.gms.internal.fitness.zzaz zzazVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 4, zzazVar == null ? null : zzazVar.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
