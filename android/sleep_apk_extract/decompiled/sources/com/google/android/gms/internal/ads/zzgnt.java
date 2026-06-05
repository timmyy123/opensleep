package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgnt implements zzimu {
    private final zzind zza;

    private zzgnt(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgnt zza(zzind zzindVar) {
        return new zzgnt(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new File(new File((File) this.zza.zzb(), "drgd"), "pcbc");
    }
}
