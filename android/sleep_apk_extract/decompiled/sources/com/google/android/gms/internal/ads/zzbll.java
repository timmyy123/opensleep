package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbll extends zzbee implements IInterface {
    public zzbll(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzcae zzcaeVar) {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, zzcaeVar);
        zzda(1, parcelZza);
    }
}
