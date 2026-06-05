package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfeq implements zzimu {
    private final zzfep zza;

    private zzfeq(zzfep zzfepVar) {
        this.zza = zzfepVar;
    }

    public static zzfeq zzc(zzfep zzfepVar) {
        return new zzfeq(zzfepVar);
    }

    public static String zzd(zzfep zzfepVar) {
        String strZza = zzfepVar.zza();
        zzinc.zzb(strZza);
        return strZza;
    }

    public final String zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
