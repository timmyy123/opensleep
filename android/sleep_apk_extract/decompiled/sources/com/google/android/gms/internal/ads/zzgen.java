package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgen implements zzgel {
    private final Executor zza;
    private final Queue zzb = new PriorityQueue();

    public zzgen(Executor executor, zzgcn zzgcnVar) {
        this.zza = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzgel
    public final void zza(Runnable runnable, long j) {
        if (j <= 0) {
            this.zza.execute(runnable);
            return;
        }
        zzgep zzgepVar = new zzgep(runnable, System.currentTimeMillis() + j);
        Queue queue = this.zzb;
        synchronized (queue) {
            queue.add(zzgepVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgel
    public final void zzb() {
        Queue queue = this.zzb;
        synchronized (queue) {
            try {
                if (queue.isEmpty()) {
                    return;
                }
                PriorityQueue priorityQueue = new PriorityQueue();
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (zzgep zzgepVar = (zzgep) queue.peek(); zzgepVar != null && zzgepVar.zzb <= jCurrentTimeMillis; zzgepVar = (zzgep) queue.peek()) {
                    priorityQueue.add(zzgepVar);
                }
                Iterator it = priorityQueue.iterator();
                while (it.hasNext()) {
                    try {
                        this.zza.execute(((zzgep) it.next()).zza);
                    } catch (RuntimeException unused) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
