package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeah implements zzimu {
    private final zzind zza;

    private zzeah(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzeah zza(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        return new zzeah(zzeaaVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzg = zzeaa.zzg((zzeak) this.zza.zzb(), zzfoa.zzc());
        zzinc.zzb(setZzg);
        return setZzg;
    }
}
