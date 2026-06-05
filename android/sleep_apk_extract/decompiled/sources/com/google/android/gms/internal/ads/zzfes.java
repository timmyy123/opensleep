package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfes implements zzimu {
    private final zzfep zza;

    private zzfes(zzfep zzfepVar) {
        this.zza = zzfepVar;
    }

    public static zzfes zzc(zzfep zzfepVar) {
        return new zzfes(zzfepVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Boolean zzb() {
        return Boolean.valueOf(this.zza.zzh());
    }
}
