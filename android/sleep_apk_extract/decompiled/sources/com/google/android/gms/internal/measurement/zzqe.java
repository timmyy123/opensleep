package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Log;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public final class zzqe {
    private final Context zza;
    private final Supplier zzb;
    private final Supplier zzc;
    private final Supplier zzd;
    private volatile int zze = 0;
    private final CopyOnWriteArrayList zzf = new CopyOnWriteArrayList();
    private final Object zzg = new Object();
    private volatile ListenableFuture zzh = null;

    public zzqe(Context context, Supplier supplier, Supplier supplier2, Supplier supplier3) {
        this.zza = context;
        this.zzb = supplier;
        this.zzc = supplier2;
        this.zzd = supplier3;
    }

    public final ListenableFuture zza(zzabz zzabzVar, boolean z, zzqc zzqcVar) {
        final ListenableFuture listenableFutureTransformAsync;
        final zzqm zzqmVar = (zzqm) this.zzc.get();
        if (zzqmVar == null && !z) {
            return Futures.immediateVoidFuture();
        }
        int iZza = zzabzVar.zza();
        Preconditions.checkArgument(true);
        int i = 1 << iZza;
        if ((this.zze & i) == 0) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.zzf;
            synchronized (copyOnWriteArrayList) {
                try {
                    int i2 = this.zze;
                    if ((i2 & i) == 0) {
                        copyOnWriteArrayList.add(zzqcVar);
                        this.zze = i | i2;
                    }
                } finally {
                }
            }
        }
        ListenableFuture listenableFuture = this.zzh;
        if (listenableFuture != null) {
            return listenableFuture;
        }
        synchronized (this.zzg) {
            try {
                listenableFutureTransformAsync = this.zzh;
                if (listenableFutureTransformAsync == null) {
                    if (zzqmVar == null) {
                        zzqmVar = zzqb.zza;
                    }
                    Context context = this.zza;
                    if (zzky.zzb(context)) {
                        zzpz zzpzVar = zzpz.zza;
                        Supplier supplier = this.zzb;
                        listenableFutureTransformAsync = Futures.transformAsync(zzky.zzd(context, Executors.callable(zzpzVar, null), (Executor) supplier.get()), new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzqa
                            @Override // com.google.common.util.concurrent.AsyncFunction
                            public final /* synthetic */ ListenableFuture apply(Object obj) {
                                return this.zza.zzb(zzqmVar, (Void) obj);
                            }
                        }, (Executor) supplier.get());
                        this.zzh = listenableFutureTransformAsync;
                    } else {
                        listenableFutureTransformAsync = (ListenableFuture) Preconditions.checkNotNull(((zzmj) this.zzd.get()).zze(new zzqd(this, zzqmVar)));
                        this.zzh = listenableFutureTransformAsync;
                    }
                    listenableFutureTransformAsync.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzpy
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            try {
                                Futures.getDone(listenableFutureTransformAsync);
                            } catch (Exception e) {
                                Log.w("PhFlagUpdateRegistry", "Failed to register flag update listener which may lead to stale flags.", e);
                            }
                        }
                    }, (Executor) this.zzb.get());
                }
            } finally {
            }
        }
        return listenableFutureTransformAsync;
    }

    public final /* synthetic */ ListenableFuture zzb(zzqm zzqmVar, Void r3) {
        return (ListenableFuture) Preconditions.checkNotNull(((zzmj) this.zzd.get()).zze(new zzqd(this, zzqmVar)));
    }

    public final /* synthetic */ CopyOnWriteArrayList zzc() {
        return this.zzf;
    }
}
