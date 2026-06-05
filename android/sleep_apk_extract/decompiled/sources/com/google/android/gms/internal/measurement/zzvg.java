package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncCallable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zzvg implements Runnable {
    private AsyncCallable zza;
    private Executor zzb;

    public zzvg(AsyncCallable asyncCallable, Executor executor) {
        this.zza = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        this.zzb = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza = null;
        this.zzb = null;
    }

    public final /* synthetic */ AsyncCallable zza() {
        return this.zza;
    }

    public final /* synthetic */ Executor zzb() {
        return this.zzb;
    }
}
