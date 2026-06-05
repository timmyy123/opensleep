package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfpp implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzfpp(zzfpo zzfpoVar, zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzfpp zza(zzfpo zzfpoVar, zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzfpp(zzfpoVar, zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbui zzbuiVarZzb = new zzbtz().zzb(((zzcns) this.zza).zza(), ((zzcoi) this.zzb).zza(), (zzfqj) this.zzc.zzb());
        zzinc.zzb(zzbuiVarZzb);
        return zzbuiVarZzb;
    }
}
