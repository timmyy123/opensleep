package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcek extends zzbee implements zzcem {
    public zzcek(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zze(IObjectWrapper iObjectWrapper, zzceq zzceqVar, zzcej zzcejVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzceqVar);
        zzbeg.zze(parcelZza, zzcejVar);
        zzda(1, parcelZza);
    }
}
