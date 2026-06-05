package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbcm extends zzbdf {
    private final zzbbt zzh;

    public zzbcm(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i, int i2, zzbbt zzbbtVar) {
        super(zzbbsVar, "4UiqdD16WGcqj9vsERkA6tbA4c/2yE/sXnYMi3TR5nPXoyMXncc0iB8g5zhndeqU", "5yR6P4d4j2VnbvLNLQtiv9yBd7AWiKZJ6Mp0Kq9QPto=", zzaxmVar, i, 85);
        this.zzh = zzbbtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza() {
        Method method = this.zze;
        zzbbt zzbbtVar = this.zzh;
        long[] jArr = (long[]) method.invoke(null, Long.valueOf(zzbbtVar.zzf()), Long.valueOf(zzbbtVar.zzg()), Long.valueOf(zzbbtVar.zzi()), Long.valueOf(zzbbtVar.zzh()));
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            zzaxmVar.zzY(jArr[0]);
            zzaxmVar.zzZ(jArr[1]);
        }
    }
}
