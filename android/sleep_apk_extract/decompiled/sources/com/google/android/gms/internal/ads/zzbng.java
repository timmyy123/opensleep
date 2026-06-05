package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbng extends zzbee implements zzbni {
    public zzbng(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final void zze(zzbmv zzbmvVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzbmvVar);
        zzda(1, parcelZza);
    }
}
