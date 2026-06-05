package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzs;
import com.google.android.gms.fitness.data.zzt;

/* JADX INFO: loaded from: classes3.dex */
public class FitnessSensorServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new zzb();
    private final DataSource zza;
    private final zzt zzb;
    private final long zzc;
    private final long zzd;

    public FitnessSensorServiceRequest(DataSource dataSource, IBinder iBinder, long j, long j2) {
        this.zza = dataSource;
        this.zzb = zzs.zzb(iBinder);
        this.zzc = j;
        this.zzd = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessSensorServiceRequest)) {
            return false;
        }
        FitnessSensorServiceRequest fitnessSensorServiceRequest = (FitnessSensorServiceRequest) obj;
        return Objects.equal(this.zza, fitnessSensorServiceRequest.zza) && this.zzc == fitnessSensorServiceRequest.zzc && this.zzd == fitnessSensorServiceRequest.zzd;
    }

    public DataSource getDataSource() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzc), Long.valueOf(this.zzd));
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", this.zza);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
