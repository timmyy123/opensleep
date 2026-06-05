package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfwv {
    private final BlockingQueue zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque zzc = new ArrayDeque();
    private zzfwu zzd = null;

    public zzfwv() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.zza = linkedBlockingQueue;
        this.zzb = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void zzc() {
        zzfwu zzfwuVar = (zzfwu) this.zzc.poll();
        this.zzd = zzfwuVar;
        if (zzfwuVar != null) {
            zzfwuVar.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzfwu zzfwuVar) {
        zzfwuVar.zzb(this);
        this.zzc.add(zzfwuVar);
        if (this.zzd == null) {
            zzc();
        }
    }

    public final void zzb(zzfwu zzfwuVar) {
        this.zzd = null;
        zzc();
    }
}
