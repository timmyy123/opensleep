package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzetj implements zzetr {
    final /* synthetic */ zzetk zza;

    public zzetj(zzetk zzetkVar) {
        Objects.requireNonNull(zzetkVar);
        this.zza = zzetkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final void zza() {
        zzetk zzetkVar = this.zza;
        synchronized (zzetkVar) {
            zzetkVar.zzN(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzetk zzetkVar = this.zza;
        zzdlz zzdlzVar = (zzdlz) obj;
        synchronized (zzetkVar) {
            zzetkVar.zzN(zzdlzVar);
            zzetkVar.zzM().zzj();
        }
    }
}
