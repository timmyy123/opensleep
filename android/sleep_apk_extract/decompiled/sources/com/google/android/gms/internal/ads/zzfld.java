package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfld implements zzimu {
    private final zzind zza;

    private zzfld(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzfld zza(zzind zzindVar) {
        return new zzfld(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzflc((zzbap) this.zza.zzb());
    }
}
