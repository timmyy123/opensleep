package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class zzef {
    private final Thread zza;
    private final zzdz zzb;
    private final zzeb zzc;
    private final CopyOnWriteArraySet zzd;
    private final ArrayDeque zze;
    private final ArrayDeque zzf;
    private final Object zzg;
    private boolean zzh;
    private boolean zzi;

    private zzef(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, Thread thread, zzdo zzdoVar, zzeb zzebVar, boolean z) {
        this.zza = thread;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzebVar;
        this.zzg = new Object();
        this.zze = new ArrayDeque();
        this.zzf = new ArrayDeque();
        this.zzb = (looper == null || zzdoVar == null || zzebVar == null) ? null : zzdoVar.zzd(looper, new Handler.Callback() { // from class: com.google.android.gms.internal.ads.zzee
            @Override // android.os.Handler.Callback
            public final /* synthetic */ boolean handleMessage(Message message) {
                this.zza.zzh(message);
                return true;
            }
        });
        this.zzi = z;
    }

    private final void zzi() {
        if (this.zzi) {
            zzgtj.zzi(zzb());
        }
    }

    public final zzef zza(Looper looper, zzdo zzdoVar, zzeb zzebVar) {
        return new zzef(this.zzd, looper, looper.getThread(), zzdoVar, zzebVar, this.zzi);
    }

    public final boolean zzb() {
        return Thread.currentThread() == this.zza;
    }

    public final void zzc(Object obj) {
        obj.getClass();
        synchronized (this.zzg) {
            try {
                if (this.zzh) {
                    return;
                }
                this.zzd.add(new zzec(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd(Object obj) {
        zzi();
        CopyOnWriteArraySet<zzec> copyOnWriteArraySet = this.zzd;
        for (zzec zzecVar : copyOnWriteArraySet) {
            if (zzecVar.zza.equals(obj)) {
                zzecVar.zzc(this.zzc);
                copyOnWriteArraySet.remove(zzecVar);
            }
        }
    }

    public final void zze(final int i, final zzea zzeaVar) {
        zzi();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.zzd);
        this.zzf.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzed
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    zzea zzeaVar2 = zzeaVar;
                    ((zzec) it.next()).zza(i, zzeaVar2);
                }
            }
        });
    }

    public final void zzf() {
        zzi();
        ArrayDeque arrayDeque = this.zzf;
        if (arrayDeque.isEmpty()) {
            return;
        }
        if (this.zzc != null) {
            zzdz zzdzVar = this.zzb;
            zzdzVar.getClass();
            if (!zzdzVar.zzb(1)) {
                zzdzVar.zzg(zzdzVar.zzc(1));
            }
        }
        ArrayDeque arrayDeque2 = this.zze;
        boolean zIsEmpty = arrayDeque2.isEmpty();
        arrayDeque2.addAll(arrayDeque);
        arrayDeque.clear();
        if (zIsEmpty) {
            while (!arrayDeque2.isEmpty()) {
                ((Runnable) arrayDeque2.peekFirst()).run();
                arrayDeque2.removeFirst();
            }
        }
    }

    public final void zzg() {
        zzi();
        synchronized (this.zzg) {
            this.zzh = true;
        }
        CopyOnWriteArraySet copyOnWriteArraySet = this.zzd;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((zzec) it.next()).zzc(this.zzc);
        }
        copyOnWriteArraySet.clear();
    }

    public final /* synthetic */ boolean zzh(Message message) {
        zzeb zzebVar = this.zzc;
        zzebVar.getClass();
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            ((zzec) it.next()).zzb(zzebVar);
            zzdz zzdzVar = this.zzb;
            zzdzVar.getClass();
            if (zzdzVar.zzb(1)) {
                break;
            }
        }
        return true;
    }

    public zzef(Thread thread) {
        this(new CopyOnWriteArraySet(), null, thread, null, null, true);
    }

    public zzef(Looper looper, zzdo zzdoVar, zzeb zzebVar) {
        this(new CopyOnWriteArraySet(), looper, looper.getThread(), zzdoVar, zzebVar, true);
    }
}
