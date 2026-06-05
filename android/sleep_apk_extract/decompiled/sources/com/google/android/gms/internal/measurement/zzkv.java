package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class zzkv extends BroadcastReceiver {
    final /* synthetic */ AtomicBoolean zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ SettableFuture zzc;
    final /* synthetic */ AsyncCallable zzd;
    final /* synthetic */ Executor zze;

    public zzkv(AtomicBoolean atomicBoolean, Context context, SettableFuture settableFuture, AsyncCallable asyncCallable, Executor executor) {
        this.zza = atomicBoolean;
        this.zzb = context;
        this.zzc = settableFuture;
        this.zzd = asyncCallable;
        this.zze = executor;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zza.compareAndSet(false, true)) {
            zzky.zzh(this.zzb, this);
            this.zzc.setFuture(Futures.submitAsync(this.zzd, this.zze));
        }
    }
}
