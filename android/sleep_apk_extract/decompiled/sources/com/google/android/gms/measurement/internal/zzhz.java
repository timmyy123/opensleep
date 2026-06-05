package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzhz extends zzjf {
    private static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
    private zzhy zza;
    private zzhy zzb;
    private final PriorityBlockingQueue zzc;
    private final BlockingQueue zzd;
    private final Thread.UncaughtExceptionHandler zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Object zzg;
    private final Semaphore zzh;

    public zzhz(zzic zzicVar) {
        super(zzicVar);
        this.zzg = new Object();
        this.zzh = new Semaphore(2);
        this.zzc = new PriorityBlockingQueue();
        this.zzd = new LinkedBlockingQueue();
        this.zze = new zzhw(this, "Thread death: Uncaught exception on worker thread");
        this.zzf = new zzhw(this, "Thread death: Uncaught exception on network thread");
    }

    private final void zzz(zzhx zzhxVar) {
        synchronized (this.zzg) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.zzc;
                priorityBlockingQueue.add(zzhxVar);
                zzhy zzhyVar = this.zza;
                if (zzhyVar == null) {
                    zzhy zzhyVar2 = new zzhy(this, "Measurement Worker", priorityBlockingQueue);
                    this.zza = zzhyVar2;
                    zzhyVar2.setUncaughtExceptionHandler(this.zze);
                    this.zza.start();
                } else {
                    zzhyVar.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    public final void zzaY() {
        if (Thread.currentThread() == this.zzb) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Call expected from network thread");
    }

    public final void zzd() {
        if (Thread.currentThread() != this.zza) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Call not expected from worker thread");
    }

    public final boolean zze() {
        return Thread.currentThread() == this.zza;
    }

    public final boolean zzf() {
        return Thread.currentThread() == this.zzb;
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    public final void zzg() {
        if (Thread.currentThread() == this.zza) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Call expected from worker thread");
    }

    public final Future zzh(Callable callable) {
        zzw();
        Preconditions.checkNotNull(callable);
        zzhx zzhxVar = new zzhx(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() != this.zza) {
            zzz(zzhxVar);
            return zzhxVar;
        }
        if (!this.zzc.isEmpty()) {
            this.zzu.zzaW().zze().zza("Callable skipped the worker queue.");
        }
        zzhxVar.run();
        return zzhxVar;
    }

    public final Future zzi(Callable callable) {
        zzw();
        Preconditions.checkNotNull(callable);
        zzhx zzhxVar = new zzhx(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            zzhxVar.run();
            return zzhxVar;
        }
        zzz(zzhxVar);
        return zzhxVar;
    }

    public final void zzj(Runnable runnable) {
        zzw();
        Preconditions.checkNotNull(runnable);
        zzz(new zzhx(this, runnable, false, "Task exception on worker thread"));
    }

    public final Object zzk(AtomicReference atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.zzu.zzaX().zzj(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzgs zzgsVarZze = this.zzu.zzaW().zze();
                StringBuilder sb = new StringBuilder(str.length() + 24);
                sb.append("Interrupted waiting for ");
                sb.append(str);
                zzgsVarZze.zza(sb.toString());
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            this.zzu.zzaW().zze().zza("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final void zzl(Runnable runnable) {
        zzw();
        Preconditions.checkNotNull(runnable);
        zzz(new zzhx(this, runnable, true, "Task exception on worker thread"));
    }

    public final void zzm(Runnable runnable) {
        zzw();
        Preconditions.checkNotNull(runnable);
        zzhx zzhxVar = new zzhx(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzg) {
            try {
                BlockingQueue blockingQueue = this.zzd;
                blockingQueue.add(zzhxVar);
                zzhy zzhyVar = this.zzb;
                if (zzhyVar == null) {
                    zzhy zzhyVar2 = new zzhy(this, "Measurement Network", blockingQueue);
                    this.zzb = zzhyVar2;
                    zzhyVar2.setUncaughtExceptionHandler(this.zzf);
                    this.zzb.start();
                } else {
                    zzhyVar.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ zzhy zzn() {
        return this.zza;
    }

    public final /* synthetic */ void zzo(zzhy zzhyVar) {
        this.zza = null;
    }

    public final /* synthetic */ zzhy zzp() {
        return this.zzb;
    }

    public final /* synthetic */ void zzq(zzhy zzhyVar) {
        this.zzb = null;
    }

    public final /* synthetic */ Object zzr() {
        return this.zzg;
    }

    public final /* synthetic */ Semaphore zzs() {
        return this.zzh;
    }

    public final /* synthetic */ boolean zzt() {
        return false;
    }
}
