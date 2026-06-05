package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfas implements zzfck {
    private final zzhcg zza;
    private final zzeao zzb;

    public zzfas(zzhcg zzhcgVar, zzeao zzeaoVar) {
        this.zza = zzhcgVar;
        this.zzb = zzeaoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzfar
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 62;
    }

    public final /* synthetic */ zzfat zzc() {
        return new zzfat(this.zzb.zzb());
    }
}
