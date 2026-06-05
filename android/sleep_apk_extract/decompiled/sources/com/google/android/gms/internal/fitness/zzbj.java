package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.zzj;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbj extends zza implements IInterface {
    public zzbj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
    }

    public final void zzd(DataReadRequest dataReadRequest) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, dataReadRequest);
        zzk(1, parcelZza);
    }

    public final void zze(zzj zzjVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzjVar);
        zzk(2, parcelZza);
    }

    public final void zzf(DataDeleteRequest dataDeleteRequest) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, dataDeleteRequest);
        zzk(3, parcelZza);
    }
}
