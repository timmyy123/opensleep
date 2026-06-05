package com.google.android.gms.internal.ads;

import androidx.datastore.core.DataStore;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgcf implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzgcf(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.zza = zzindVar;
        this.zzb = zzindVar3;
    }

    public static zzgcf zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzgcf(zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzgce zzb() {
        return new zzgce((DataStore) this.zza.zzb(), zzcnu.zzc(), (zzdww) this.zzb.zzb(), new zzgbd());
    }
}
