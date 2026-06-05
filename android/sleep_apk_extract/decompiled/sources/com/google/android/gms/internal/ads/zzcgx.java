package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcgx implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzchb zzb;

    public zzcgx(zzchb zzchbVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzchbVar);
        this.zzb = zzchbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzI("windowVisibilityChanged", new String[]{"isVisible", String.valueOf(this.zza)});
    }
}
