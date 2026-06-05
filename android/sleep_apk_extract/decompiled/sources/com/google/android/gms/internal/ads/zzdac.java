package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdac implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdac(zzdab zzdabVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdac zza(zzdab zzdabVar, zzind zzindVar, zzind zzindVar2) {
        return new zzdac(zzdabVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new com.google.android.gms.ads.internal.zzb((Context) this.zza.zzb(), (zzcdn) this.zzb.zzb(), null);
    }
}
