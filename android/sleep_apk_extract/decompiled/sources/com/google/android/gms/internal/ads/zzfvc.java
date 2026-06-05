package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzfvc implements Runnable {
    final /* synthetic */ float zza;
    final /* synthetic */ zzfvd zzb;

    public zzfvc(zzfvd zzfvdVar, float f) {
        this.zza = f;
        Objects.requireNonNull(zzfvdVar);
        this.zzb = zzfvdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzg().zzf(this.zza);
    }
}
