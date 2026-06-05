package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgz {
    private final zzgy zza;
    private final ArrayDeque zzb = new ArrayDeque();
    private final ArrayDeque zzc = new ArrayDeque();
    private final PriorityQueue zzd = new PriorityQueue();
    private int zze = -1;
    private zzgx zzf;

    public zzgz(zzgy zzgyVar) {
        this.zza = zzgyVar;
    }

    private final void zzf(int i) {
        List list;
        while (true) {
            PriorityQueue priorityQueue = this.zzd;
            if (priorityQueue.size() <= i) {
                return;
            }
            zzgx zzgxVar = (zzgx) priorityQueue.poll();
            String str = zzfl.zza;
            int i2 = 0;
            while (true) {
                list = zzgxVar.zza;
                if (i2 >= list.size()) {
                    break;
                }
                this.zza.zza(zzgxVar.zzb, (zzet) list.get(i2));
                this.zzb.push((zzet) list.get(i2));
                i2++;
            }
            list.clear();
            zzgx zzgxVar2 = this.zzf;
            if (zzgxVar2 != null && zzgxVar2.zzb == zzgxVar.zzb) {
                this.zzf = null;
            }
            this.zzc.push(zzgxVar);
        }
    }

    public final void zza(int i) {
        zzgtj.zzi(i >= 0);
        this.zze = i;
        zzf(i);
    }

    public final int zzb() {
        return this.zze;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r7 < r0.zzb) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc(long j, zzet zzetVar) {
        if (j != -9223372036854775807L) {
            int i = this.zze;
            if (i != 0) {
                if (i != -1) {
                    PriorityQueue priorityQueue = this.zzd;
                    if (priorityQueue.size() >= this.zze) {
                        zzgx zzgxVar = (zzgx) priorityQueue.peek();
                        String str = zzfl.zza;
                    }
                }
                ArrayDeque arrayDeque = this.zzb;
                zzet zzetVar2 = arrayDeque.isEmpty() ? new zzet() : (zzet) arrayDeque.pop();
                zzetVar2.zza(zzetVar.zzd());
                System.arraycopy(zzetVar.zzi(), zzetVar.zzg(), zzetVar2.zzi(), 0, zzetVar2.zzd());
                zzgx zzgxVar2 = this.zzf;
                if (zzgxVar2 != null && j == zzgxVar2.zzb) {
                    zzgxVar2.zza.add(zzetVar2);
                    return;
                }
                ArrayDeque arrayDeque2 = this.zzc;
                zzgx zzgxVar3 = arrayDeque2.isEmpty() ? new zzgx() : (zzgx) arrayDeque2.pop();
                List list = zzgxVar3.zza;
                zzgtj.zzi(list.isEmpty());
                zzgxVar3.zzb = j;
                list.add(zzetVar2);
                this.zzd.add(zzgxVar3);
                this.zzf = zzgxVar3;
                int i2 = this.zze;
                if (i2 != -1) {
                    zzf(i2);
                    return;
                }
                return;
            }
        } else {
            j = -9223372036854775807L;
        }
        this.zza.zza(j, zzetVar);
    }

    public final void zzd() {
        this.zzd.clear();
    }

    public final void zze() {
        zzf(0);
    }
}
