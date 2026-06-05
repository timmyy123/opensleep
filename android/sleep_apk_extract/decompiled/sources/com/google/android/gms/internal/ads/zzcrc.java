package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcrc implements zzimu {
    private final zzind zza;

    private zzcrc(zzcqt zzcqtVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcrc zzc(zzcqt zzcqtVar, zzind zzindVar) {
        return new zzcrc(zzcqtVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzflu zzb() {
        zzflu zzfluVarZza = zzflu.zza(((zzcns) this.zza).zza());
        zzinc.zzb(zzfluVarZza);
        return zzfluVarZza;
    }
}
