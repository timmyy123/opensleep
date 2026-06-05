package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzebi extends zzcck {
    final /* synthetic */ zzebj zza;

    public zzebi(zzebj zzebjVar) {
        Objects.requireNonNull(zzebjVar);
        this.zza = zzebjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zze() {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzm(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzf() {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzo(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzg(zzccf zzccfVar) {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzp(zzebjVar.zzd(), zzccfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzh(int i) {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzn(zzebjVar.zzd(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzn(zzebjVar.zzd(), zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzj() {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzq(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzk() {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzr(zzebjVar.zzd());
    }
}
