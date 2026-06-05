package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzby;
import com.google.android.gms.internal.fitness.zzbz;

/* JADX INFO: loaded from: classes3.dex */
public class DataUpdateRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataUpdateRequest> CREATOR = new zzt();
    private final long zza;
    private final long zzb;
    private final DataSet zzc;
    private final zzbz zzd;

    public DataUpdateRequest(long j, long j2, DataSet dataSet, IBinder iBinder) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = dataSet;
        this.zzd = iBinder == null ? null : zzby.zzc(iBinder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataUpdateRequest)) {
            return false;
        }
        DataUpdateRequest dataUpdateRequest = (DataUpdateRequest) obj;
        return this.zza == dataUpdateRequest.zza && this.zzb == dataUpdateRequest.zzb && Objects.equal(this.zzc, dataUpdateRequest.zzc);
    }

    public DataSet getDataSet() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("startTimeMillis", Long.valueOf(this.zza)).add("endTimeMillis", Long.valueOf(this.zzb)).add("dataSet", this.zzc).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, getDataSet(), i, false);
        zzbz zzbzVar = this.zzd;
        SafeParcelWriter.writeIBinder(parcel, 4, zzbzVar == null ? null : zzbzVar.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
