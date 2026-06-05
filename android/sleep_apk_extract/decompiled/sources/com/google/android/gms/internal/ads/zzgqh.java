package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgqh {
    private final zzgfh zza;
    private final zzgcn zzb;

    public zzgqh(zzgcn zzgcnVar, zzgfh zzgfhVar) {
        this.zza = zzgfhVar;
        this.zzb = zzgcnVar;
    }

    public final zzgqf zza(int i) {
        return new zzgqf(i, this.zzb, this.zza);
    }

    public final void zzb(int i) {
        this.zza.zzb(i - 1, -1L, null, null);
    }

    public final void zzc(int i, String str) {
        this.zza.zzb(i - 1, -1L, null, str);
    }

    public final void zzd(int i, Throwable th) {
        this.zza.zzb(i - 1, -1L, th, null);
    }

    public final ListenableFuture zze(int i, ListenableFuture listenableFuture) {
        zzgqf zzgqfVarZza = zza(i);
        zzgqfVarZza.zza();
        zzhbw.zzr(listenableFuture, new zzgqg(this, zzgqfVarZza), zzhcn.zza());
        return listenableFuture;
    }

    public final void zzf(int i, Runnable runnable) {
        try {
            zza(i).zza();
            runnable.run();
        } finally {
        }
    }
}
