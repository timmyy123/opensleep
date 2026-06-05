package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzasp implements Runnable {
    final /* synthetic */ zzate zza;
    final /* synthetic */ zzasq zzb;

    public zzasp(zzasq zzasqVar, zzate zzateVar) {
        this.zza = zzateVar;
        Objects.requireNonNull(zzasqVar);
        this.zzb = zzasqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzb().put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
