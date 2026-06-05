package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcvp implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;
    private final zzind zzf;
    private final zzind zzg;
    private final zzind zzh;
    private final zzind zzi;
    private final zzind zzj;

    private zzcvp(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar5;
        this.zzf = zzindVar6;
        this.zzg = zzindVar7;
        this.zzh = zzindVar8;
        this.zzi = zzindVar9;
        this.zzj = zzindVar10;
    }

    public static zzcvp zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10) {
        return new zzcvp(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5, zzindVar6, zzindVar7, zzindVar8, zzindVar9, zzindVar10);
    }

    public static zzcvo zzd(zzcxs zzcxsVar, Context context, zzfkg zzfkgVar, View view, zzcku zzckuVar, zzcxr zzcxrVar, zzdqd zzdqdVar, zzdla zzdlaVar, zzimo zzimoVar, Executor executor) {
        return new zzcvo(zzcxsVar, context, zzfkgVar, view, zzckuVar, zzcxrVar, zzdqdVar, zzdlaVar, zzimoVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcvo zzb() {
        return new zzcvo(((zzdaa) this.zza).zzb(), (Context) this.zzb.zzb(), ((zzcvv) this.zzc).zza(), ((zzcvu) this.zzd).zza(), ((zzcwj) this.zze).zza(), ((zzcvw) this.zzf).zza(), ((zzdoa) this.zzg).zza(), (zzdla) this.zzh.zzb(), zzimt.zzc(this.zzi), (Executor) this.zzj.zzb());
    }
}
