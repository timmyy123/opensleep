package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbh extends zza implements IInterface {
    public zzbh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
    }

    public final void zzf(com.google.android.gms.fitness.request.zzu zzuVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzuVar);
        zzk(22, parcelZza);
    }
}
