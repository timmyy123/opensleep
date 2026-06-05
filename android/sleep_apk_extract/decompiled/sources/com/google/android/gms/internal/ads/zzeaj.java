package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeaj implements zzimu {
    private final zzind zza;

    private zzeaj(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzeaj zza(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        return new zzeaj(zzeaaVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzi = zzeaa.zzi((zzeak) this.zza.zzb(), zzfoa.zzc());
        zzinc.zzb(setZzi);
        return setZzi;
    }
}
