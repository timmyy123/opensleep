package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbvj extends zzbee implements zzbvl {
    public zzbvj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbvl
    public final IObjectWrapper zze() {
        return zzba$$ExternalSyntheticOutline0.m(zzcZ(1, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbvl
    public final boolean zzf() {
        Parcel parcelZzcZ = zzcZ(2, zza());
        boolean zZza = zzbeg.zza(parcelZzcZ);
        parcelZzcZ.recycle();
        return zZza;
    }
}
