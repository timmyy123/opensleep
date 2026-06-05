package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcxo implements zzimu {
    private final zzcxl zza;

    private zzcxo(zzcxl zzcxlVar) {
        this.zza = zzcxlVar;
    }

    public static zzcxo zzc(zzcxl zzcxlVar) {
        return new zzcxo(zzcxlVar);
    }

    public static zzdfs zzd(zzcxl zzcxlVar) {
        return zzcxlVar.zza();
    }

    public final zzdfs zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
