package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbnn extends zzbee implements zzbnp {
    public zzbnn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbnp
    public final void zze(zzbnv zzbnvVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbnvVar);
        zzda(1, parcelZza);
    }
}
