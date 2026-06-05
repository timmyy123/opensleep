package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbri extends zzbee implements IInterface {
    public zzbri(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzbrc zzbrcVar, zzbrh zzbrhVar) {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzbrcVar);
        zzbeg.zze(parcelZza, zzbrhVar);
        zzdb(2, parcelZza);
    }
}
