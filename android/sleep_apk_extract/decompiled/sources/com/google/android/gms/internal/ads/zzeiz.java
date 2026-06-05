package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeiz {
    private final zzeiv zza;
    private final zzhcg zzb;

    public zzeiz(zzeiv zzeivVar, zzhcg zzhcgVar) {
        this.zza = zzeivVar;
        this.zzb = zzhcgVar;
    }

    public final void zza(zzfok zzfokVar) {
        final zzeiv zzeivVar = this.zza;
        Objects.requireNonNull(zzeivVar);
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzeiy
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return zzeivVar.getWritableDatabase();
            }
        };
        zzhcg zzhcgVar = this.zzb;
        zzhbw.zzr(zzhcgVar.zzc(callable), new zzeix(this, zzfokVar), zzhcgVar);
    }
}
