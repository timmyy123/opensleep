package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzevn implements zzfck {
    private final zzhcg zza;
    private final zzfky zzb;
    private final zzcfi zzc;

    public zzevn(zzhcg zzhcgVar, zzfky zzfkyVar, zzcfi zzcfiVar) {
        this.zza = zzhcgVar;
        this.zzb = zzfkyVar;
        this.zzc = zzcfiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzevm
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 9;
    }

    public final /* synthetic */ zzevo zzc() {
        return new zzevo(this.zzb.zzk, this.zzc.zzl());
    }
}
