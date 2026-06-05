package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfot {
    final /* synthetic */ zzfpc zza;
    private final Object zzb;
    private final List zzc;

    public /* synthetic */ zzfot(zzfpc zzfpcVar, Object obj, List list, byte[] bArr) {
        Objects.requireNonNull(zzfpcVar);
        this.zza = zzfpcVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfpb zza(Callable callable) {
        List list = this.zzc;
        zzhbv zzhbvVarZzp = zzhbw.zzp(list);
        ListenableFuture listenableFutureZza = zzhbvVarZzp.zza(zzfos.zza, zzcfr.zzh);
        zzfpc zzfpcVar = this.zza;
        return new zzfpb(zzfpcVar, this.zzb, null, listenableFutureZza, list, zzhbvVarZzp.zza(callable, zzfpcVar.zze()), null);
    }
}
