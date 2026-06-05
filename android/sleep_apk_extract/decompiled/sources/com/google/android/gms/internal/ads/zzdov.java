package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdov implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdov(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdov zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdov(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdks((Context) this.zza.zzb(), new HashSet(), ((zzcyk) this.zzb).zza());
    }
}
