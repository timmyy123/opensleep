package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzgfv implements zzhbe {
    static final /* synthetic */ zzgfv zza = new zzgfv();

    private /* synthetic */ zzgfv() {
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        final zzgfr zzgfrVar = (zzgfr) obj;
        return zzhbw.zzk(zzgfrVar.zzb(), new zzgta() { // from class: com.google.android.gms.internal.ads.zzgfw
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj2) {
                return zzgfrVar;
            }
        }, zzhcn.zza());
    }
}
