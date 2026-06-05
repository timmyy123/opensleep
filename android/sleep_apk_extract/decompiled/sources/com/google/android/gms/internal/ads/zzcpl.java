package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzcpl implements zzeaw {
    private final Long zza;
    private final String zzb;
    private final zzcox zzc;
    private final zzcpn zzd;

    public zzcpl(zzcox zzcoxVar, zzcpn zzcpnVar, Long l, String str) {
        this.zzc = zzcoxVar;
        this.zzd = zzcpnVar;
        this.zza = l;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzeaw
    public final zzebf zza() {
        long jLongValue = this.zza.longValue();
        zzcpn zzcpnVar = this.zzd;
        return zzebg.zza(jLongValue, zzcpnVar.zzd(), zzcpnVar.zza(), this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzeaw
    public final zzebj zzb() {
        long jLongValue = this.zza.longValue();
        zzcpn zzcpnVar = this.zzd;
        return zzebk.zza(jLongValue, zzcpnVar.zzd(), zzcpnVar.zza(), this.zzc, this.zzb);
    }
}
