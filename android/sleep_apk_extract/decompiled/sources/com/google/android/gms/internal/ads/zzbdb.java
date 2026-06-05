package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbdb extends zzbdf {
    public zzbdb(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i, int i2) {
        super(zzbbsVar, "GkIdfnRezKvEfAeB5157D8Ci3lpp/e7Oge9xr/GzO3KjC7JXvYHgpg7VRCtGuOw4", "kXUmyuEurXcq5mqFokC5oFFCqidwlGAMD9JpJXYa0Mk=", zzaxmVar, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza() {
        zzaxm zzaxmVar = this.zzd;
        zzaxmVar.zzae(3);
        boolean zBooleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
        synchronized (zzaxmVar) {
            try {
                if (zBooleanValue) {
                    zzaxmVar.zzae(2);
                } else {
                    zzaxmVar.zzae(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
