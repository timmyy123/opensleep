package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: loaded from: classes3.dex */
final class zzabn {
    private final Handler zza;
    private final zzabp zzb;
    private boolean zzc;

    public zzabn(Handler handler, zzabp zzabpVar) {
        this.zza = handler;
        this.zzb = zzabpVar;
    }

    public final void zza() {
        this.zzc = true;
    }

    public final /* synthetic */ Handler zzb() {
        return this.zza;
    }

    public final /* synthetic */ zzabp zzc() {
        return this.zzb;
    }

    public final /* synthetic */ boolean zzd() {
        return this.zzc;
    }
}
