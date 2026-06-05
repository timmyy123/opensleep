package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzctn implements zzdcu {
    private final zzfki zza;
    private final zzfkq zzb;
    private final zzfry zzc;
    private final zzfsc zzd;

    public zzctn(zzfkq zzfkqVar, zzfsc zzfscVar, zzfry zzfryVar) {
        this.zzb = zzfkqVar;
        this.zzd = zzfscVar;
        this.zzc = zzfryVar;
        this.zza = zzfkqVar.zzb.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzdJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
        List list = this.zza.zza;
        this.zzd.zza(this.zzc.zza(this.zzb, null, list), null);
    }
}
