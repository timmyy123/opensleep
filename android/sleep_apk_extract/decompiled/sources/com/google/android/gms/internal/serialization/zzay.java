package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzay extends zza implements zzba {
    public zzay(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.home.interaction.internal.IInteractionService");
    }

    @Override // com.google.android.gms.internal.serialization.zzba
    public final void zze(zzn zznVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zznVar);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.serialization.zzba
    public final void zzg(zzv zzvVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzvVar);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.serialization.zzba
    public final void zzh(zzao zzaoVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzaoVar);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.serialization.zzba
    public final void zzi(zzs zzsVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzsVar);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.serialization.zzba
    public final void zzj(zzal zzalVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzalVar);
        zzc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.serialization.zzba
    public final void zzk(zzab zzabVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzabVar);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.serialization.zzba
    public final void zzl(zzy zzyVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzyVar);
        zzc(10, parcelZza);
    }
}
