package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhd extends zzbee implements IInterface {
    public zzbhd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzbgy zze(zzbhb zzbhbVar) {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzbhbVar);
        Parcel parcelZzcZ = zzcZ(1, parcelZza);
        zzbgy zzbgyVar = (zzbgy) zzbeg.zzb(parcelZzcZ, zzbgy.CREATOR);
        parcelZzcZ.recycle();
        return zzbgyVar;
    }

    public final zzbgy zzf(zzbhb zzbhbVar) {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzbhbVar);
        Parcel parcelZzcZ = zzcZ(2, parcelZza);
        zzbgy zzbgyVar = (zzbgy) zzbeg.zzb(parcelZzcZ, zzbgy.CREATOR);
        parcelZzcZ.recycle();
        return zzbgyVar;
    }

    public final long zzg(zzbhb zzbhbVar) {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzbhbVar);
        Parcel parcelZzcZ = zzcZ(3, parcelZza);
        long j = parcelZzcZ.readLong();
        parcelZzcZ.recycle();
        return j;
    }
}
