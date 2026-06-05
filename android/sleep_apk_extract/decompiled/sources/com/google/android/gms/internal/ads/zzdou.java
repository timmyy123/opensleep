package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdou implements zzimu {
    private final zzdop zza;

    private zzdou(zzdop zzdopVar) {
        this.zza = zzdopVar;
    }

    public static zzdou zzc(zzdop zzdopVar) {
        return new zzdou(zzdopVar);
    }

    public static zzdux zzd(zzdop zzdopVar) {
        zzdux zzduxVarZzd = zzdopVar.zzd();
        zzinc.zzb(zzduxVarZzd);
        return zzduxVarZzd;
    }

    public final zzdux zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
