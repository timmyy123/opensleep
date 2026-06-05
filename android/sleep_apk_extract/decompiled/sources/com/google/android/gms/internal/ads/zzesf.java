package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzesf implements zzetr {
    final /* synthetic */ zzesg zza;

    public zzesf(zzesg zzesgVar) {
        Objects.requireNonNull(zzesgVar);
        this.zza = zzesgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final void zza() {
        zzesg zzesgVar = this.zza;
        synchronized (zzesgVar) {
            zzesgVar.zzN(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzesg zzesgVar = this.zza;
        zzcvl zzcvlVar = (zzcvl) obj;
        synchronized (zzesgVar) {
            try {
                if (zzesgVar.zzM() != null) {
                    if (zzcvlVar.zzo() != null && zzesgVar.zzM().zzo() != null) {
                        zzcvlVar.zzo().zzb(zzesgVar.zzM().zzo().zza());
                    }
                    zzesgVar.zzM().zzd();
                }
                zzesgVar.zzN(zzcvlVar);
                zzesgVar.zzM().zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
