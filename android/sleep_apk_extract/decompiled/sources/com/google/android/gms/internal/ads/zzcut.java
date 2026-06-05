package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcut {
    private final zzdzl zza;
    private final zzfkq zzb;

    public zzcut(zzdzl zzdzlVar, zzfkq zzfkqVar) {
        this.zza = zzdzlVar;
        this.zzb = zzfkqVar;
    }

    public final void zza(long j, int i) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zza(this.zzb.zzb.zzb);
        zzdzkVarZza.zzc("action", "ad_closed");
        zzdzkVarZza.zzc("show_time", String.valueOf(j));
        zzdzkVarZza.zzc("ad_format", "app_open_ad");
        int i2 = i - 1;
        zzdzkVarZza.zzc("acr", i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : "h");
        zzdzkVarZza.zzd();
    }
}
