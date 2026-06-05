package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzecx implements zzimu {
    private final zzind zza;

    private zzecx(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzecx zza(zzind zzindVar) {
        return new zzecx(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzedu(((zzcns) this.zza).zza());
    }
}
