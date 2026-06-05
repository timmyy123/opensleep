package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzwt implements zzze {
    private final zzze zza;
    private final zzgwm zzb;

    public zzwt(zzze zzzeVar, List list) {
        this.zza = zzzeVar;
        this.zzb = zzgwm.zzq(list);
    }

    public final zzgwm zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final void zzg(long j) {
        this.zza.zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        return this.zza.zzm(zzmaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        return this.zza.zzn();
    }
}
