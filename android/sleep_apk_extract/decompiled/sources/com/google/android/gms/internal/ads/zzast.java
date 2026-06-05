package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zzast implements Executor {
    final /* synthetic */ Handler zza;

    public zzast(zzasv zzasvVar, Handler handler) {
        this.zza = handler;
        Objects.requireNonNull(zzasvVar);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
