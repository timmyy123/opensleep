package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbdd implements Runnable {
    final /* synthetic */ zzbde zza;

    public zzbdd(zzbde zzbdeVar) {
        Objects.requireNonNull(zzbdeVar);
        this.zza = zzbdeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb();
    }
}
