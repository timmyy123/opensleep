package com.google.android.gms.internal.measurement;

import com.google.common.base.Function;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ExecutionSequencer;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzut {
    private final String zza;
    private final ListenableFuture zzb;
    private final zzuv zzc;
    private final zzvm zze;
    private final zzvm zzf = new zzvm(new zzul(this, null), MoreExecutors.directExecutor());
    private final Object zzg = new Object();
    private List zzi = new ArrayList();
    private final ExecutionSequencer zzd = ExecutionSequencer.create();
    private final zzwb zzh = zzwb.zzb();

    public zzut(zzuv zzuvVar, zzvc zzvcVar, ListenableFuture listenableFuture, boolean z, String str) {
        this.zzc = zzuvVar;
        this.zzb = listenableFuture;
        this.zza = zzuvVar.zzc();
        final zzui zzuiVar = (zzui) zzuvVar;
        this.zze = new zzvm(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzuh
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final /* synthetic */ ListenableFuture call() {
                return zzuiVar.zzd();
            }
        }, MoreExecutors.directExecutor());
        zza(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzuq
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.zza.zzc((zzth) obj);
            }
        });
    }

    public final void zza(AsyncFunction asyncFunction) {
        synchronized (this.zzg) {
            this.zzi.add(asyncFunction);
        }
    }

    public final ListenableFuture zzb(final Function function, final Executor executor) {
        final AsyncFunction asyncFunctionZzc = zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzuo
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return Futures.immediateFuture(function.apply(obj));
            }
        });
        Stopwatch.createStarted(zzxh.zza());
        zzwi zzwiVarZza = this.zzh.zza("Update ".concat(String.valueOf(this.zza)), zzxd.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        try {
            final ListenableFuture listenableFutureZza = this.zzf.zza();
            ExecutionSequencer executionSequencer = this.zzd;
            executionSequencer.submitAsync(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzum
                @Override // com.google.common.util.concurrent.AsyncCallable
                public final /* synthetic */ ListenableFuture call() {
                    return listenableFutureZza;
                }
            }, MoreExecutors.directExecutor());
            ListenableFuture listenableFutureSubmitAsync = executionSequencer.submitAsync(zzxa.zzb(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzun
                @Override // com.google.common.util.concurrent.AsyncCallable
                public final /* synthetic */ ListenableFuture call() {
                    final zzut zzutVar = this.zza;
                    final AsyncFunction asyncFunction = asyncFunctionZzc;
                    final Executor executor2 = executor;
                    return Futures.transformAsync(listenableFutureZza, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzup
                        @Override // com.google.common.util.concurrent.AsyncFunction
                        public final /* synthetic */ ListenableFuture apply(Object obj) {
                            return zzutVar.zzd(asyncFunction, executor2, obj);
                        }
                    }), MoreExecutors.directExecutor());
                }
            }), MoreExecutors.directExecutor());
            Futures.propagateCancellation(listenableFutureSubmitAsync, listenableFutureZza);
            Futures.nonCancellationPropagating(this.zzb);
            ListenableFuture listenableFutureZza2 = zzuy.zza(listenableFutureSubmitAsync);
            zzwiVarZza.zza(listenableFutureZza2);
            zzwiVarZza.close();
            return listenableFutureZza2;
        } catch (Throwable th) {
            try {
                zzwiVarZza.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final /* synthetic */ ListenableFuture zzc(zzth zzthVar) {
        return this.zze.zza();
    }

    public final /* synthetic */ ListenableFuture zzd(AsyncFunction asyncFunction, Executor executor, Object obj) {
        return this.zzc.zzb(asyncFunction, executor, null);
    }

    public final /* synthetic */ String zze() {
        return this.zza;
    }

    public final /* synthetic */ zzuv zzf() {
        return this.zzc;
    }

    public final /* synthetic */ zzvm zzg() {
        return this.zze;
    }

    public final /* synthetic */ Object zzh() {
        return this.zzg;
    }

    public final /* synthetic */ zzwb zzi() {
        return this.zzh;
    }

    public final /* synthetic */ List zzj() {
        return this.zzi;
    }

    public final /* synthetic */ void zzk(List list) {
        this.zzi = list;
    }
}
