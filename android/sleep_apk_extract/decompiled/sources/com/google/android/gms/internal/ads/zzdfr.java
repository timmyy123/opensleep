package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
final class zzdfr implements Runnable {
    private final WeakReference zza;

    @Override // java.lang.Runnable
    public final void run() {
        zzdfs zzdfsVar = (zzdfs) this.zza.get();
        if (zzdfsVar != null) {
            zzdfsVar.zzs(zzdfo.zza);
        }
    }
}
