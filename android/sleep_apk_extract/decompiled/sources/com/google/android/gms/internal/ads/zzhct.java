package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzhct extends zzhcd {
    final /* synthetic */ zzhcv zza;
    private final zzhbd zzb;

    public zzhct(zzhcv zzhcvVar, zzhbd zzhbdVar) {
        Objects.requireNonNull(zzhcvVar);
        this.zza = zzhcvVar;
        this.zzb = zzhbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final /* bridge */ /* synthetic */ Object zza() {
        zzhbd zzhbdVar = this.zzb;
        ListenableFuture listenableFutureZza = zzhbdVar.zza();
        zzgtj.zzl(listenableFutureZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzhbdVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final String zzc() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final boolean zzd() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final /* synthetic */ void zzf(Object obj) {
        this.zza.zzk((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    public final void zzg(Throwable th) {
        this.zza.zzb(th);
    }
}
