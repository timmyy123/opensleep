package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.facebook.ads.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfm extends zza implements IInterface {
    public zzfm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
    }

    public final void zzd(zzar zzarVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzarVar);
        zzr(AdError.INTERNAL_ERROR_2006, parcelZza);
    }

    public final void zzf(zzax zzaxVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzaxVar);
        zzr(2011, parcelZza);
    }

    public final void zzh(zzhp zzhpVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzhpVar);
        zzr(2007, parcelZza);
    }

    public final void zzi(zzht zzhtVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzhtVar);
        zzr(2005, parcelZza);
    }

    public final void zzj(zzhx zzhxVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzhxVar);
        zzr(AdError.REMOTE_ADS_SERVICE_ERROR, parcelZza);
    }

    public final void zzk(zzib zzibVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzibVar);
        zzr(2001, parcelZza);
    }

    public final void zzl(zzif zzifVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzifVar);
        zzr(AdError.INTERNAL_ERROR_2003, parcelZza);
    }

    public final void zzm(zzih zzihVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzihVar);
        zzr(AdError.CACHE_ERROR_CODE, parcelZza);
    }

    public final void zzn(zzij zzijVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzijVar);
        zzr(2010, parcelZza);
    }

    public final void zzo(zzil zzilVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzilVar);
        zzr(AdError.INTERNAL_ERROR_2004, parcelZza);
    }
}
