package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcxl {
    private final zzdfs zza;
    private final zzdhx zzb;

    public zzcxl(zzdfs zzdfsVar, zzdhx zzdhxVar) {
        this.zza = zzdfsVar;
        this.zzb = zzdhxVar;
    }

    public final zzdfs zza() {
        return this.zza;
    }

    public final zzdkq zzb() {
        zzdhx zzdhxVar = this.zzb;
        return zzdhxVar != null ? new zzdkq(zzdhxVar, zzcfr.zzh) : new zzdkq(new zzcxk(this), zzcfr.zzh);
    }

    public final zzdhx zzc() {
        return this.zzb;
    }
}
