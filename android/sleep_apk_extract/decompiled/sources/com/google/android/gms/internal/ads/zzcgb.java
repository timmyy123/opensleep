package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcgb implements zzhbt {
    final /* synthetic */ zzcgd zza;

    public zzcgb(zzcgd zzcgdVar) {
        Objects.requireNonNull(zzcgdVar);
        this.zza = zzcgdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        this.zza.zzj().set(-1);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        this.zza.zzj().set(1);
    }
}
