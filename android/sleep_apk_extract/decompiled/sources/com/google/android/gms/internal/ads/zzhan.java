package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
final class zzhan extends zzhao {
    public zzhan(ListenableFuture listenableFuture, Class cls, zzgta zzgtaVar) {
        super(listenableFuture, cls, zzgtaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhao
    public final void zze(Object obj) {
        zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhao
    public final /* synthetic */ Object zzf(Object obj, Throwable th) {
        return ((zzgta) obj).apply(th);
    }
}
