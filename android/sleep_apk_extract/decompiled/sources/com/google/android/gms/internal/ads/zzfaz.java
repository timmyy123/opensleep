package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfaz implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzfaz(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzfaz zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzfaz(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfax zzb() {
        return new zzfax((ApplicationInfo) this.zza.zzb(), (PackageInfo) this.zzb.zzb(), ((zzcns) this.zzc).zza());
    }
}
