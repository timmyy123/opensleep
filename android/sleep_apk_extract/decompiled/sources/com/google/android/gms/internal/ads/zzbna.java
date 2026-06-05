package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbna extends zzbee implements zzbnc {
    public zzbna(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbnc
    public final void zze(zzbms zzbmsVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbmsVar);
        zzda(1, parcelZza);
    }
}
