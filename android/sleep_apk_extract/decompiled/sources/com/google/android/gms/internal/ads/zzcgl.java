package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcgl implements Runnable {
    final /* synthetic */ zzcgr zza;

    public zzcgl(zzcgr zzcgrVar) {
        Objects.requireNonNull(zzcgrVar);
        this.zza = zzcgrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcgr zzcgrVar = this.zza;
        if (zzcgrVar.zzt() != null) {
            zzcgrVar.zzt().zza();
        }
    }
}
