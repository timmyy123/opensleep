package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeym implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeym(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeym zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeym(zzindVar, zzindVar2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
    @Override // com.google.android.gms.internal.ads.zzinj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgww zzgwwVarZzi;
        zzezk zzezkVarZzb = ((zzezm) this.zza).zzb();
        Context contextZza = ((zzcns) this.zzb).zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmN)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzc();
            zzgwwVarZzi = com.google.android.gms.ads.internal.util.zzs.zzE(contextZza) ? zzgww.zzi(zzezkVarZzb) : zzgww.zzh();
        }
        zzinc.zzb(zzgwwVarZzi);
        return zzgwwVarZzi;
    }
}
