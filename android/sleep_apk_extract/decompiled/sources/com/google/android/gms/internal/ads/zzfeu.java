package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfeu implements zzimu {
    private final zzfep zza;

    private zzfeu(zzfep zzfepVar) {
        this.zza = zzfepVar;
    }

    public static zzfeu zzc(zzfep zzfepVar) {
        return new zzfeu(zzfepVar);
    }

    public static String zzd(zzfep zzfepVar) {
        String strZze = zzfepVar.zze();
        zzinc.zzb(strZze);
        return strZze;
    }

    public final String zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
