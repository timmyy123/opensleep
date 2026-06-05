package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbfm implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzbfq zzb;

    public zzbfm(zzbfq zzbfqVar, View view) {
        this.zza = view;
        Objects.requireNonNull(zzbfqVar);
        this.zzb = zzbfqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
