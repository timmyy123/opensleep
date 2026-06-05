package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzciq implements Runnable {
    final /* synthetic */ zzcis zza;

    public zzciq(zzcis zzcisVar) {
        Objects.requireNonNull(zzcisVar);
        this.zza = zzcisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzt.zzB().zzd(this.zza);
    }
}
