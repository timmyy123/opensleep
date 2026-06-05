package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzia implements Runnable {
    final /* synthetic */ zzjs zza;
    final /* synthetic */ zzic zzb;

    public zzia(zzic zzicVar, zzjs zzjsVar) {
        this.zza = zzjsVar;
        Objects.requireNonNull(zzicVar);
        this.zzb = zzicVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzic zzicVar = this.zzb;
        zzjs zzjsVar = this.zza;
        zzicVar.zzK(zzjsVar);
        zzicVar.zza(zzjsVar.zzd);
    }
}
