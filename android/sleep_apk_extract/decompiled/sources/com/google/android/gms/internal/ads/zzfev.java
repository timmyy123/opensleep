package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfev implements zzimu {
    private final zzfep zza;

    private zzfev(zzfep zzfepVar) {
        this.zza = zzfepVar;
    }

    public static zzfev zzc(zzfep zzfepVar) {
        return new zzfev(zzfepVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Integer zzb() {
        return Integer.valueOf(this.zza.zzi());
    }
}
