package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzebh extends zzcco {
    final /* synthetic */ zzebj zza;

    public zzebh(zzebj zzebjVar) {
        Objects.requireNonNull(zzebjVar);
        this.zza = zzebjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zze() {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzk(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzf(int i) {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzl(zzebjVar.zzd(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzl(zzebjVar.zzd(), zzeVar.zza);
    }
}
