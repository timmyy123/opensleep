package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeai implements zzimu {
    private final zzind zza;

    private zzeai(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzeai zza(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        return new zzeai(zzeaaVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzh = zzeaa.zzh((zzeak) this.zza.zzb(), zzfoa.zzc());
        zzinc.zzb(setZzh);
        return setZzh;
    }
}
