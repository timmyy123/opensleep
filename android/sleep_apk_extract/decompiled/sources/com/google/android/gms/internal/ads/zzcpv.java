package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzcpv implements zzehp {
    private final zzcox zza;
    private final zzcpu zzb;
    private zzefw zzc;

    public /* synthetic */ zzcpv(zzcox zzcoxVar, zzcpu zzcpuVar, byte[] bArr) {
        this.zza = zzcoxVar;
        this.zzb = zzcpuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehp
    public final zzehq zza() {
        zzinc.zzc(this.zzc, zzefw.class);
        return new zzcpw(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzehp
    public final /* bridge */ /* synthetic */ zzehp zzb(zzefw zzefwVar) {
        this.zzc = zzefwVar;
        return this;
    }
}
