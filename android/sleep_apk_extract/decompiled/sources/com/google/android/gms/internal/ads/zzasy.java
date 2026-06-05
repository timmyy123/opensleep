package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class zzasy extends Thread {
    private final BlockingQueue zza;
    private final zzasx zzb;
    private final zzaso zzc;
    private volatile boolean zzd = false;
    private final zzasv zze;

    public zzasy(BlockingQueue blockingQueue, zzasx zzasxVar, zzaso zzasoVar, zzasv zzasvVar) {
        this.zza = blockingQueue;
        this.zzb = zzasxVar;
        this.zzc = zzasoVar;
        this.zze = zzasvVar;
    }

    private void zzb() {
        zzate zzateVar = (zzate) this.zza.take();
        SystemClock.elapsedRealtime();
        zzateVar.zze(3);
        try {
            try {
                zzateVar.zzc("network-queue-take");
                zzateVar.zzl();
                TrafficStats.setThreadStatsTag(zzateVar.zzb());
                zzata zzataVarZza = this.zzb.zza(zzateVar);
                zzateVar.zzc("network-http-complete");
                if (zzataVarZza.zze && zzateVar.zzq()) {
                    zzateVar.zzd("not-modified");
                    zzateVar.zzw();
                } else {
                    zzatk zzatkVarZzr = zzateVar.zzr(zzataVarZza);
                    zzateVar.zzc("network-parse-complete");
                    zzasn zzasnVar = zzatkVarZzr.zzb;
                    if (zzasnVar != null) {
                        this.zzc.zzb(zzateVar.zzi(), zzasnVar);
                        zzateVar.zzc("network-cache-written");
                    }
                    zzateVar.zzp();
                    this.zze.zza(zzateVar, zzatkVarZzr, null);
                    zzateVar.zzv(zzatkVarZzr);
                }
            } catch (zzatn e) {
                SystemClock.elapsedRealtime();
                this.zze.zzb(zzateVar, e);
                zzateVar.zzw();
            } catch (Exception e2) {
                zzatq.zzd(e2, "Unhandled exception %s", e2.toString());
                zzatn zzatnVar = new zzatn(e2);
                SystemClock.elapsedRealtime();
                this.zze.zzb(zzateVar, zzatnVar);
                zzateVar.zzw();
            }
            zzateVar.zze(4);
        } catch (Throwable th) {
            zzateVar.zze(4);
            throw th;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzatq.zzc("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
