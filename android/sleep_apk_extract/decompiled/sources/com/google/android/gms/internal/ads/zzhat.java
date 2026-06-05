package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
final class zzhat extends zzhav {
    public zzhat(ListenableFuture listenableFuture, zzhbe zzhbeVar) {
        super(listenableFuture, zzhbeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhav
    public final /* synthetic */ void zze(Object obj) {
        zzk((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhav
    public final /* bridge */ /* synthetic */ Object zzf(Object obj, Object obj2) {
        zzhbe zzhbeVar = (zzhbe) obj;
        ListenableFuture listenableFutureZza = zzhbeVar.zza(obj2);
        zzgtj.zzl(listenableFutureZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzhbeVar);
        return listenableFutureZza;
    }
}
