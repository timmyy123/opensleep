package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeaf implements zzimu {
    private final zzind zza;

    private zzeaf(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzeaf zza(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        return new zzeaf(zzeaaVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZze = zzeaa.zze((zzeak) this.zza.zzb(), zzfoa.zzc());
        zzinc.zzb(setZze);
        return setZze;
    }
}
