package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzld implements zzmg {
    private final Object zza;
    private zzbf zzb;

    public zzld(Object obj, zzxf zzxfVar) {
        this.zza = obj;
        this.zzb = zzxfVar.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final zzbf zzb() {
        return this.zzb;
    }

    public final void zzc(zzbf zzbfVar) {
        this.zzb = zzbfVar;
    }
}
