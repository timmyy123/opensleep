package com.google.android.gms.internal.serialization;

import android.accounts.Account;
import android.content.IntentSender;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcs extends zza implements zzcu {
    public zzcs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.home.permissions.internal.IPermissionsService");
    }

    @Override // com.google.android.gms.internal.serialization.zzcu
    public final void zze(zzcr zzcrVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzcrVar);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.serialization.zzcu
    public final IntentSender zzf() {
        Parcel parcelZzb = zzb(5, zza());
        IntentSender intentSender = (IntentSender) zzc.zza(parcelZzb, IntentSender.CREATOR);
        parcelZzb.recycle();
        return intentSender;
    }

    @Override // com.google.android.gms.internal.serialization.zzcu
    public final IntentSender zzg(Account account) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, account);
        Parcel parcelZzb = zzb(6, parcelZza);
        IntentSender intentSender = (IntentSender) zzc.zza(parcelZzb, IntentSender.CREATOR);
        parcelZzb.recycle();
        return intentSender;
    }
}
