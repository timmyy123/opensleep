package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes4.dex */
public final class zzs extends com.google.android.gms.internal.nearby.zza implements IInterface {
    public zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
    }

    public final void zze(zzj zzjVar) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zzc(parcelZza, zzjVar);
        zzs(9, parcelZza);
    }
}
