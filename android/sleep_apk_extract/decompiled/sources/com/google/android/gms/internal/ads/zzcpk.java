package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzcpk implements zzeav {
    private final zzcox zza;
    private final zzcpn zzb;
    private Long zzc;
    private String zzd;

    public /* synthetic */ zzcpk(zzcox zzcoxVar, zzcpn zzcpnVar, byte[] bArr) {
        this.zza = zzcoxVar;
        this.zzb = zzcpnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeav
    public final zzeaw zza() {
        zzinc.zzc(this.zzc, Long.class);
        zzinc.zzc(this.zzd, String.class);
        return new zzcpl(this.zza, this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzeav
    public final /* bridge */ /* synthetic */ zzeav zzb(String str) {
        str.getClass();
        this.zzd = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeav
    public final /* bridge */ /* synthetic */ zzeav zzc(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }
}
