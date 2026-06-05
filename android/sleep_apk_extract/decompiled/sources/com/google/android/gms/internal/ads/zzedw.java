package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzedw implements zzimu {
    private final zzind zza;

    private zzedw(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzedw zza(zzind zzindVar) {
        return new zzedw(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzedv(((zzcns) this.zza).zza());
    }
}
