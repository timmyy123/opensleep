package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbcy extends zzbdf {
    public zzbcy(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i, int i2) {
        super(zzbbsVar, "Qz9CKMoDCHphOXPELo049qp61nrfn738aUeATKOiX7hq+kw0ujtW3xI/vlQKBh37", "bze+wYBAHEMh8JSXqo0+D4B3Aq+R4fX2jHr7eo7ufbY=", zzaxmVar, i, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza() {
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            zzbbn zzbbnVar = new zzbbn((String) this.zze.invoke(null, null));
            zzaxmVar.zzF(zzbbnVar.zza.longValue());
            zzaxmVar.zzG(zzbbnVar.zzb.longValue());
        }
    }
}
