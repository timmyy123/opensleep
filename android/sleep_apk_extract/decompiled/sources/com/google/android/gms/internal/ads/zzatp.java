package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzatp {
    public static final boolean zza = zzatq.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    public final void finalize() {
        if (this.zzc) {
            return;
        }
        zzb("Request on the loose");
        zzatq.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }

    public final synchronized void zza(String str, long j) {
        if (this.zzc) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.zzb.add(new zzato(str, j, SystemClock.elapsedRealtime()));
    }

    public final synchronized void zzb(String str) {
        this.zzc = true;
        List<zzato> list = this.zzb;
        long j = list.size() == 0 ? 0L : ((zzato) list.get(list.size() - 1)).zzc - ((zzato) list.get(0)).zzc;
        if (j > 0) {
            long j2 = ((zzato) list.get(0)).zzc;
            zzatq.zzb("(%-4d ms) %s", Long.valueOf(j), str);
            for (zzato zzatoVar : list) {
                long j3 = zzatoVar.zzc;
                zzatq.zzb("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(zzatoVar.zzb), zzatoVar.zza);
                j2 = j3;
            }
        }
    }
}
