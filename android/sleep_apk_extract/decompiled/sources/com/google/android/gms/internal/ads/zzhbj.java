package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzhbj extends zzhcd {
    private final Executor zza;
    final /* synthetic */ zzhbk zzb;

    public zzhbj(zzhbk zzhbkVar, Executor executor) {
        Objects.requireNonNull(zzhbkVar);
        this.zzb = zzhbkVar;
        executor.getClass();
        this.zza = executor;
    }

    public abstract void zzb(Object obj);

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final boolean zzd() {
        return this.zzb.isDone();
    }

    public final void zze() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final void zzf(Object obj) {
        this.zzb.zzD(null);
        zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final void zzg(Throwable th) {
        zzhbk zzhbkVar = this.zzb;
        zzhbkVar.zzD(null);
        if (th instanceof ExecutionException) {
            zzhbkVar.zzb(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            zzhbkVar.cancel(false);
        } else {
            zzhbkVar.zzb(th);
        }
    }
}
