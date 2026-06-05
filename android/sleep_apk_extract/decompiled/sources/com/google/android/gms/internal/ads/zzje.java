package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzje implements zzabl {
    final /* synthetic */ zzjg zza;
    private final HashMap zzb;
    private final zzqf zzc;

    public zzje(zzjg zzjgVar, zzqf zzqfVar) {
        Objects.requireNonNull(zzjgVar);
        this.zza = zzjgVar;
        this.zzb = new HashMap();
        this.zzc = zzqfVar;
    }

    private final void zze(zzabj zzabjVar) {
        zzqf zzqfVar = (zzqf) this.zzb.remove(zzabjVar);
        zzqfVar.getClass();
        zzjf zzjfVar = (zzjf) this.zza.zzl().get(zzqfVar);
        if (zzjfVar != null) {
            zzjfVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized zzabj zza() {
        zzabj zzabjVarZza;
        zzjg zzjgVar = this.zza;
        zzabr zzabrVarZzk = zzjgVar.zzk();
        HashMap map = this.zzb;
        zzabjVarZza = zzabrVarZzk.zza();
        zzqf zzqfVar = this.zzc;
        map.put(zzabjVarZza, zzqfVar);
        zzjf zzjfVar = (zzjf) zzjgVar.zzl().get(zzqfVar);
        if (zzjfVar != null) {
            zzjfVar.zza();
        }
        return zzabjVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized void zzb(zzabj zzabjVar) {
        this.zza.zzk().zzb(zzabjVar);
        zze(zzabjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized void zzc(zzabk zzabkVar) {
        this.zza.zzk().zzc(zzabkVar);
        while (zzabkVar != null) {
            zze(zzabkVar.zzd());
            zzabkVar = zzabkVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized void zzd() {
        this.zza.zzk().zzd();
    }
}
