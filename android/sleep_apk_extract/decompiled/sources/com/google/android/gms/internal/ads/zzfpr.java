package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfpr implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzfpr(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzfpr zza(zzind zzindVar, zzind zzindVar2) {
        return new zzfpr(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfpq(((zzcns) this.zza).zza(), (zzfqg) this.zzb.zzb());
    }
}
