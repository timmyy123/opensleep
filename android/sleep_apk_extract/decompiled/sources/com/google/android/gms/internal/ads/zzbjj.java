package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbjj extends zzbee implements zzbjl {
    public zzbjj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbjl
    public final void zze(zzbji zzbjiVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbjiVar);
        zzda(1, parcelZza);
    }
}
