package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzexe implements zzfck {
    private final zzhcg zza;
    private final zzdxh zzb;
    private final String zzc;
    private final zzfky zzd;

    public zzexe(zzhcg zzhcgVar, zzdxh zzdxhVar, zzfky zzfkyVar, String str) {
        this.zza = zzhcgVar;
        this.zzb = zzdxhVar;
        this.zzd = zzfkyVar;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzexd
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 17;
    }

    public final /* synthetic */ zzexf zzc() {
        zzfky zzfkyVar = this.zzd;
        zzdxh zzdxhVar = this.zzb;
        return new zzexf(zzdxhVar.zzb(zzfkyVar.zzg, this.zzc), zzdxhVar.zzc());
    }
}
