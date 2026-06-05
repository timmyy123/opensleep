package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class zzath {
    private final AtomicInteger zza;
    private final Set zzb;
    private final PriorityBlockingQueue zzc;
    private final PriorityBlockingQueue zzd;
    private final zzaso zze;
    private final zzasx zzf;
    private final zzasy[] zzg;
    private zzasq zzh;
    private final List zzi;
    private final List zzj;
    private final zzasv zzk;

    public zzath(zzaso zzasoVar, zzasx zzasxVar, int i) {
        zzasv zzasvVar = new zzasv(new Handler(Looper.getMainLooper()));
        this.zza = new AtomicInteger();
        this.zzb = new HashSet();
        this.zzc = new PriorityBlockingQueue();
        this.zzd = new PriorityBlockingQueue();
        this.zzi = new ArrayList();
        this.zzj = new ArrayList();
        this.zze = zzasoVar;
        this.zzf = zzasxVar;
        this.zzg = new zzasy[4];
        this.zzk = zzasvVar;
    }

    public final void zza() {
        zzasq zzasqVar = this.zzh;
        if (zzasqVar != null) {
            zzasqVar.zza();
        }
        zzasy[] zzasyVarArr = this.zzg;
        for (int i = 0; i < 4; i++) {
            zzasy zzasyVar = zzasyVarArr[i];
            if (zzasyVar != null) {
                zzasyVar.zza();
            }
        }
        PriorityBlockingQueue priorityBlockingQueue = this.zzc;
        PriorityBlockingQueue priorityBlockingQueue2 = this.zzd;
        zzaso zzasoVar = this.zze;
        zzasv zzasvVar = this.zzk;
        zzasq zzasqVar2 = new zzasq(priorityBlockingQueue, priorityBlockingQueue2, zzasoVar, zzasvVar);
        this.zzh = zzasqVar2;
        zzasqVar2.start();
        for (int i2 = 0; i2 < 4; i2++) {
            zzasy zzasyVar2 = new zzasy(priorityBlockingQueue2, this.zzf, zzasoVar, zzasvVar);
            zzasyVarArr[i2] = zzasyVar2;
            zzasyVar2.start();
        }
    }

    public final zzate zzb(zzate zzateVar) {
        zzateVar.zzf(this);
        Set set = this.zzb;
        synchronized (set) {
            set.add(zzateVar);
        }
        zzateVar.zzg(this.zza.incrementAndGet());
        zzateVar.zzc("add-to-queue");
        zzd(zzateVar, 0);
        this.zzc.add(zzateVar);
        return zzateVar;
    }

    public final void zzc(zzate zzateVar) {
        Set set = this.zzb;
        synchronized (set) {
            set.remove(zzateVar);
        }
        List list = this.zzi;
        synchronized (list) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                throw null;
            }
        }
        zzd(zzateVar, 5);
    }

    public final void zzd(zzate zzateVar, int i) {
        List list = this.zzj;
        synchronized (list) {
            try {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
