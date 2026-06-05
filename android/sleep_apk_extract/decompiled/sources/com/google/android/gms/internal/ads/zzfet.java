package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfet implements zzimu {
    private final zzfep zza;

    private zzfet(zzfep zzfepVar) {
        this.zza = zzfepVar;
    }

    public static zzfet zzc(zzfep zzfepVar) {
        return new zzfet(zzfepVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Boolean zzb() {
        return Boolean.valueOf(this.zza.zzg());
    }
}
