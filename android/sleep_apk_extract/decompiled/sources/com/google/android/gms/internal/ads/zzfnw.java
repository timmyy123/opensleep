package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfnw implements zzimu {
    public static zzfnw zza() {
        return zzfnv.zza;
    }

    public static zzhcg zzc() {
        zzhcg zzhcgVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgK)).booleanValue()) {
            zzhcgVar = zzcfr.zzc;
        } else {
            zzhcgVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgJ)).booleanValue() ? zzcfr.zza : zzcfr.zzf;
        }
        zzinc.zzb(zzhcgVar);
        return zzhcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return zzc();
    }
}
