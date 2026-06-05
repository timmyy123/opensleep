package com.google.android.gms.internal.measurement;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzvm {
    private final zzvg zza;
    private final AtomicLong zzb = new AtomicLong(zzi(Integer.MIN_VALUE, Integer.MIN_VALUE));
    private final AtomicReference zzc = new AtomicReference(null);
    private final AtomicReference zzd = new AtomicReference(null);
    private final Executor zze = MoreExecutors.newSequentialExecutor(MoreExecutors.directExecutor());
    private final SettableFuture zzf;

    public zzvm(AsyncCallable asyncCallable, Executor executor) {
        SettableFuture settableFutureCreate = SettableFuture.create();
        this.zzf = settableFutureCreate;
        zzvg zzvgVar = new zzvg(asyncCallable, executor);
        this.zza = zzvgVar;
        settableFutureCreate.addListener(zzvgVar, MoreExecutors.directExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final ListenableFuture zzd(int i) {
        Executor executorZzb;
        AtomicLong atomicLong = this.zzb;
        if (((int) (atomicLong.get() >>> 32)) > i) {
            return Futures.immediateCancelledFuture();
        }
        zzvl zzvlVar = new zzvl(i);
        while (true) {
            AtomicReference atomicReference = this.zzc;
            zzvl zzvlVar2 = (zzvl) atomicReference.get();
            if (zzvlVar2 != null && zzvlVar2.zza() > i) {
                return Futures.immediateCancelledFuture();
            }
            while (!atomicReference.compareAndSet(zzvlVar2, zzvlVar)) {
                if (atomicReference.get() != zzvlVar2) {
                    break;
                }
            }
            if (((int) (atomicLong.get() >>> 32)) > i) {
                zzvlVar.cancel(true);
                while (!atomicReference.compareAndSet(zzvlVar, null)) {
                    if (atomicReference.get() != zzvlVar) {
                        return zzvlVar;
                    }
                }
                return zzvlVar;
            }
            zzvg zzvgVar = this.zza;
            AsyncCallable asyncCallableZza = zzvgVar.zza();
            if (asyncCallableZza == null || (executorZzb = zzvgVar.zzb()) == null) {
                zzvlVar.setFuture(this.zzf);
                return zzvlVar;
            }
            zzvlVar.setFuture(Futures.submitAsync(zzxa.zzb(asyncCallableZza), executorZzb));
            return zzvlVar;
        }
    }

    private static long zzi(int i, int i2) {
        return (((long) i2) & 4294967295L) | (i << 32);
    }

    public final ListenableFuture zza() {
        AtomicLong atomicLong;
        long j;
        final int i;
        SettableFuture settableFuture = this.zzf;
        if (settableFuture.isDone()) {
            return settableFuture;
        }
        do {
            atomicLong = this.zzb;
            j = atomicLong.get();
            i = (int) (j >>> 32);
        } while (!atomicLong.compareAndSet(j, zzi(i, ((int) j) + 1)));
        AtomicReference atomicReference = this.zzd;
        final SettableFuture settableFutureCreate = SettableFuture.create();
        ListenableFuture listenableFuture = (ListenableFuture) atomicReference.getAndSet(settableFutureCreate);
        settableFutureCreate.setFuture(listenableFuture == null ? Futures.submitAsync(zzxa.zzb(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzvi
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final /* synthetic */ ListenableFuture call() {
                return this.zza.zzd(i);
            }
        }), MoreExecutors.directExecutor()) : Futures.catchingAsync(listenableFuture, Throwable.class, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzvh
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.zza.zzc(i, (Throwable) obj);
            }
        }), this.zze));
        final zzvk zzvkVar = new zzvk(this, i, null);
        settableFutureCreate.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzvj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzb(settableFutureCreate, zzvkVar);
            }
        }, MoreExecutors.directExecutor());
        return zzvkVar;
    }

    public final /* synthetic */ void zzb(SettableFuture settableFuture, zzvk zzvkVar) {
        try {
            Object done = Futures.getDone(settableFuture);
            SettableFuture settableFuture2 = this.zzf;
            settableFuture2.set(done);
            zzvkVar.setFuture(settableFuture2);
        } catch (Throwable unused) {
            zzvkVar.setFuture(settableFuture);
        }
    }

    public final /* synthetic */ ListenableFuture zzc(int i, Throwable th) {
        return zzd(i);
    }

    public final /* synthetic */ boolean zze() {
        AtomicLong atomicLong;
        long j;
        int i;
        int i2;
        boolean z;
        do {
            atomicLong = this.zzb;
            j = atomicLong.get();
            i = (int) j;
            long j2 = j >>> 32;
            if (i == Integer.MIN_VALUE) {
                Utf8$$ExternalSyntheticBUOutline0.m$1((Object) zzba$$ExternalSyntheticOutline0.m(j, "Refcount is: ", new StringBuilder(String.valueOf(j).length() + 13)));
                return false;
            }
            i2 = (int) j2;
            z = i == -2147483647;
            if (z) {
                i2++;
            }
        } while (!atomicLong.compareAndSet(j, zzi(i2, i - 1)));
        return z;
    }

    public final /* synthetic */ zzvg zzf() {
        return this.zza;
    }

    public final /* synthetic */ AtomicReference zzg() {
        return this.zzc;
    }
}
