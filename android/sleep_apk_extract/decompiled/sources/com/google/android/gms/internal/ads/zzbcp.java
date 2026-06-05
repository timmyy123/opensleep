package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbcp extends zzbdf {
    private final zzbbk zzh;

    public zzbcp(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i, int i2, zzbbk zzbbkVar) {
        super(zzbbsVar, "/BhgxpXYgahRBmZkS3xjCzPdid3mZtzdZmJFkhACyEa2oS6asfWgI5KysEGcSPE9", "ngST2QkCVNtF272EQbVjeXMfCtACYPfIcakPMgsny7g=", zzaxmVar, i, 94);
        this.zzh = zzbbkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza() {
        int iIntValue = ((Integer) this.zze.invoke(null, this.zzh.zzb())).intValue();
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            zzaxmVar.zzaj(zzaya.zza(iIntValue));
        }
    }
}
