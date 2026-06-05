package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgnu implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzgnu(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzgnu zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzgnu(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        File file = (File) this.zza.zzb();
        zzgfc zzgfcVar = (zzgfc) this.zzb.zzb();
        final zzgqh zzgqhVar = (zzgqh) this.zzc.zzb();
        return zzgfcVar.zzb(file, new byte[0], new zzgta() { // from class: com.google.android.gms.internal.ads.zzgne
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                zzgqhVar.zzd(15310, (Throwable) obj);
                return new byte[0];
            }
        });
    }
}
