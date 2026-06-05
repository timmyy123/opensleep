package com.google.android.gms.internal.ads;

import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzims implements zzimu {
    private zzind zza;

    public static void zza(zzind zzindVar, zzind zzindVar2) {
        zzims zzimsVar = (zzims) zzindVar;
        if (zzimsVar.zza == null) {
            zzimsVar.zza = zzindVar2;
        } else {
            Home$$ExternalSyntheticBUOutline0.m$2();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final Object zzb() {
        zzind zzindVar = this.zza;
        if (zzindVar != null) {
            return zzindVar.zzb();
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
        return null;
    }
}
