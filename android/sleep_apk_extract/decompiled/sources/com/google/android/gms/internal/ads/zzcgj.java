package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcgj implements Runnable {
    final /* synthetic */ zzcgr zza;

    public zzcgj(zzcgr zzcgrVar) {
        Objects.requireNonNull(zzcgrVar);
        this.zza = zzcgrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcgr zzcgrVar = this.zza;
        if (zzcgrVar.zzt() != null) {
            zzcgrVar.zzt().zze();
        }
    }
}
