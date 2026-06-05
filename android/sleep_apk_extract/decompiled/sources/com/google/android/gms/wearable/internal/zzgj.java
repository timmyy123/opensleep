package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes4.dex */
public final class zzgj extends com.google.android.gms.internal.wearable.zza implements IInterface {
    public zzgj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IRpcResponseCallback");
    }

    public final void zzd(boolean z, byte[] bArr) {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.$r8$clinit;
        parcelZza.writeInt(z ? 1 : 0);
        parcelZza.writeByteArray(bArr);
        zzU(1, parcelZza);
    }
}
