package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgff {
    private final zzimo zza;
    private final zzimo zzb;
    private final ExecutorService zzc;
    private final zzimo zzd;
    private ListenableFuture zze = null;

    public zzgff(zzimo zzimoVar, zzimo zzimoVar2, ExecutorService executorService, zzimo zzimoVar3) {
        this.zza = zzimoVar;
        this.zzb = zzimoVar2;
        this.zzc = executorService;
        this.zzd = zzimoVar3;
    }

    public final synchronized ListenableFuture zza() {
        try {
            ListenableFuture listenableFuture = this.zze;
            if (listenableFuture != null) {
                return listenableFuture;
            }
            Set set = (Set) this.zzb.zzb();
            ArrayList arrayList = new ArrayList(set.size());
            Iterator it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzgfd) it.next()).zza());
            }
            zzgqh zzgqhVar = (zzgqh) this.zzd.zzb();
            ListenableFuture listenableFutureZzk = zzhbw.zzk(zzhbw.zzm(arrayList), zzgfe.zza, this.zzc);
            zzgqhVar.zze(2, listenableFutureZzk);
            this.zze = listenableFutureZzk;
            Iterator it2 = ((Set) this.zza.zzb()).iterator();
            while (it2.hasNext()) {
                ((zzgfd) it2.next()).zza();
            }
            ListenableFuture listenableFuture2 = this.zze;
            if (listenableFuture2 != null) {
                return listenableFuture2;
            }
            throw null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized ListenableFuture zzb() {
        ListenableFuture listenableFuture;
        listenableFuture = this.zze;
        if (listenableFuture == null) {
            throw null;
        }
        return listenableFuture;
    }
}
