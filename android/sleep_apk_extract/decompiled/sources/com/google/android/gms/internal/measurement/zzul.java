package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final class zzul implements AsyncCallable {
    final /* synthetic */ zzut zza;
    private List zzb;

    public /* synthetic */ zzul(zzut zzutVar, byte[] bArr) {
        Objects.requireNonNull(zzutVar);
        this.zza = zzutVar;
    }

    @Override // com.google.common.util.concurrent.AsyncCallable
    public final ListenableFuture call() {
        zzut zzutVar = this.zza;
        zzwi zzwiVarZza = zzutVar.zzi().zza("Initialize ".concat(String.valueOf(zzutVar.zze())), zzxd.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        try {
            synchronized (zzutVar.zzh()) {
                try {
                    if (this.zzb == null) {
                        this.zzb = zzutVar.zzj();
                        zzutVar.zzk(Collections.EMPTY_LIST);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ArrayList arrayList = new ArrayList(this.zzb.size());
            zzus zzusVar = new zzus(this.zza, null);
            Iterator it = this.zzb.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(((AsyncFunction) it.next()).apply(zzusVar));
                } catch (Exception e) {
                    arrayList.add(Futures.immediateFailedFuture(e));
                }
            }
            ListenableFuture listenableFutureCall = Futures.whenAllSucceed(arrayList).call(new Callable() { // from class: com.google.android.gms.internal.measurement.zzuk
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    this.zza.zza();
                    return null;
                }
            }, MoreExecutors.directExecutor());
            zzwiVarZza.zza(listenableFutureCall);
            zzwiVarZza.close();
            return listenableFutureCall;
        } catch (Throwable th2) {
            try {
                zzwiVarZza.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final /* synthetic */ Object zza() {
        synchronized (this.zza.zzh()) {
            this.zzb = null;
        }
        return null;
    }
}
