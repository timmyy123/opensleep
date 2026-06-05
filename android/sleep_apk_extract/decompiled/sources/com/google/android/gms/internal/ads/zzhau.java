package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
final class zzhau extends zzhav {
    public zzhau(ListenableFuture listenableFuture, zzgta zzgtaVar) {
        super(listenableFuture, zzgtaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhav
    public final void zze(Object obj) {
        zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhav
    public final /* synthetic */ Object zzf(Object obj, Object obj2) {
        return ((zzgta) obj).apply(obj2);
    }
}
