package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class zzerp {
    private final zzdng zza;

    public zzerp(zzdng zzdngVar) {
        this.zza = zzdngVar;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfkq zzfkqVar, zzfkf zzfkfVar, View view, zzerl zzerlVar) {
        zzern zzernVar = new zzern(this, new zzerm(this, zzfkfVar));
        zzdma zzdmaVarZzd = this.zza.zzd(new zzcyj(zzfkqVar, zzfkfVar, null), zzernVar);
        zzerlVar.zzd(new zzero(this, zzdmaVarZzd));
        return zzdmaVarZzd.zzh();
    }
}
