package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcoq implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcoq(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcoq zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzcoq(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcaw zzb() {
        Context contextZza = ((zzcns) this.zza).zza();
        zzfqj zzfqjVar = (zzfqj) this.zzb.zzb();
        zzhcg zzhcgVarZzc = zzfoa.zzc();
        zzbui zzbuiVarZza = com.google.android.gms.ads.internal.zzt.zzr().zza(contextZza, VersionInfoParcel.forPackage(), zzfqjVar);
        zzbuc zzbucVar = zzbuf.zza;
        zzbuiVarZza.zza("google.afma.request.getAdDictionary", zzbucVar, zzbucVar);
        return new zzcaz(contextZza, com.google.android.gms.ads.internal.zzt.zzr().zza(contextZza, VersionInfoParcel.forPackage(), zzfqjVar).zza("google.afma.sdkConstants.getSdkConstants", zzbucVar, zzbucVar), VersionInfoParcel.forPackage(), zzhcgVarZzc);
    }
}
