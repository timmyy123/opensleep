package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbrl implements Runnable {
    final /* synthetic */ zzbro zza;

    public zzbrl(zzbro zzbroVar) {
        Objects.requireNonNull(zzbroVar);
        this.zza = zzbroVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb();
    }
}
