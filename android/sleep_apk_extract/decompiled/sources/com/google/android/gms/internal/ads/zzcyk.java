package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcyk implements zzimu {
    private final zzcyj zza;

    private zzcyk(zzcyj zzcyjVar) {
        this.zza = zzcyjVar;
    }

    public static zzcyk zzc(zzcyj zzcyjVar) {
        return new zzcyk(zzcyjVar);
    }

    public static zzfkf zzd(zzcyj zzcyjVar) {
        zzfkf zzfkfVarZzb = zzcyjVar.zzb();
        zzinc.zzb(zzfkfVarZzb);
        return zzfkfVarZzb;
    }

    public final zzfkf zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
