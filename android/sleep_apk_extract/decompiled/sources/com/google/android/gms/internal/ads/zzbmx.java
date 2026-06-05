package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbmx extends zzbee implements zzbmz {
    public zzbmx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbmz
    public final void zze(zzbmq zzbmqVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbmqVar);
        zzda(1, parcelZza);
    }
}
