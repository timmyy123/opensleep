package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes4.dex */
public final class zzgq extends com.google.android.gms.internal.wearable.zza implements IInterface {
    public zzgq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IWearableService");
    }

    public final void zzi(zzgm zzgmVar, String str, String str2, byte[] bArr) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, zzgmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeByteArray(bArr);
        zzT(12, parcelZza);
    }

    public final void zzm(zzgm zzgmVar) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, zzgmVar);
        zzT(15, parcelZza);
    }

    public final void zzt(zzgm zzgmVar, zzf zzfVar) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, zzgmVar);
        com.google.android.gms.internal.wearable.zzc.zzb(parcelZza, zzfVar);
        zzT(16, parcelZza);
    }

    public final void zzu(zzgm zzgmVar, zzin zzinVar) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, zzgmVar);
        com.google.android.gms.internal.wearable.zzc.zzb(parcelZza, zzinVar);
        zzT(17, parcelZza);
    }
}
