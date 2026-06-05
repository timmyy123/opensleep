package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdqz implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdqz(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdqz zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdqz(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdqy(((zzdou) this.zza).zza(), (Clock) this.zzb.zzb());
    }
}
