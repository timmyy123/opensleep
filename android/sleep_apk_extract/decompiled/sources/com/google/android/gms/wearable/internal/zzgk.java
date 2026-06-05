package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes4.dex */
public final class zzgk extends com.google.android.gms.internal.wearable.zza implements IInterface {
    public zzgk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IServiceResponseCallback");
    }

    public final void zzd(zzkg zzkgVar, zzgp zzgpVar) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.wearable.zzc.zzb(parcelZza, zzkgVar);
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, zzgpVar);
        zzT(1, parcelZza);
    }
}
