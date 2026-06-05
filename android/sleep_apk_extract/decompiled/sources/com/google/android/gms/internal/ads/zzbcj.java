package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbcj extends zzbdf {
    private final long zzh;

    public zzbcj(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, long j, int i, int i2) {
        super(zzbbsVar, "y0L1OSEMWW8/imV1M3pvQITWJfkGk5GAMqJuL5aNLdq8sTbK6BFpI8/D5pLc65zr", "dBSRUGPKY8JzIPoAEV0GB9RkRHGvAJPAM3BhqN1QQjE=", zzaxmVar, i, 25);
        this.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza() {
        long jLongValue = ((Long) this.zze.invoke(null, null)).longValue();
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            try {
                zzaxmVar.zzac(jLongValue);
                long j = this.zzh;
                if (j != 0) {
                    zzaxmVar.zzk(jLongValue - j);
                    zzaxmVar.zzn(j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
