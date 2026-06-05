package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzead implements zzimu {
    private final zzind zza;

    private zzead(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzead zza(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        return new zzead(zzeaaVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzc = zzeaa.zzc((zzeak) this.zza.zzb(), zzfoa.zzc());
        zzinc.zzb(setZzc);
        return setZzc;
    }
}
