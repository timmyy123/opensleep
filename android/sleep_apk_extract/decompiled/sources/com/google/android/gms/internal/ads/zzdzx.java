package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdzx implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdzx(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdzx zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdzx(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdzw((String) this.zza.zzb(), (zzdzq) this.zzb.zzb());
    }
}
