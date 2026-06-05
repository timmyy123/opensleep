package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzwy implements AsyncFunction {
    final /* synthetic */ zzws zza;
    final /* synthetic */ AsyncFunction zzb;

    public zzwy(zzws zzwsVar, AsyncFunction asyncFunction) {
        this.zza = zzwsVar;
        this.zzb = asyncFunction;
    }

    @Override // com.google.common.util.concurrent.AsyncFunction
    public final ListenableFuture apply(Object obj) {
        zzws zzwsVar = this.zza;
        zzwsVar.getClass();
        zzws zzwsVarZzc = zzvy.zzc(zzvy.zzd(), zzwsVar);
        try {
            ListenableFuture listenableFutureApply = this.zzb.apply(obj);
            if (listenableFutureApply != null) {
                return listenableFutureApply;
            }
            throw new IllegalStateException("AsyncFunction should return a ListenableFuture instead of null.");
        } finally {
        }
    }

    public final String toString() {
        AsyncFunction asyncFunction = this.zzb;
        StringBuilder sb = new StringBuilder(asyncFunction.toString().length() + 14);
        sb.append("propagating=[");
        sb.append(asyncFunction);
        sb.append("]");
        return sb.toString();
    }
}
