package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbur {
    private final zzbtu zza;
    private ListenableFuture zzb;

    public zzbur(zzbtu zzbtuVar) {
        this.zza = zzbtuVar;
    }

    private final void zzd() {
        if (this.zzb == null) {
            final zzcfw zzcfwVar = new zzcfw();
            this.zzb = zzcfwVar;
            this.zza.zzb(null).zze(new zzcga() { // from class: com.google.android.gms.internal.ads.zzbuq
                @Override // com.google.android.gms.internal.ads.zzcga
                public final /* synthetic */ void zza(Object obj) {
                    zzcfwVar.zzc((zzbtv) obj);
                }
            }, new zzcfy() { // from class: com.google.android.gms.internal.ads.zzbun
                @Override // com.google.android.gms.internal.ads.zzcfy
                public final /* synthetic */ void zza() {
                    zzcfwVar.zzd(new zzbtx("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final zzbuu zza(String str, zzbub zzbubVar, zzbua zzbuaVar) {
        zzd();
        return new zzbuu(this.zzb, "google.afma.activeView.handleUpdate", zzbubVar, zzbuaVar);
    }

    public final void zzb(final String str, final zzbpq zzbpqVar) {
        zzd();
        this.zzb = zzhbw.zzj(this.zzb, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzbuo
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                zzbtv zzbtvVar = (zzbtv) obj;
                zzbtvVar.zzm(str, zzbpqVar);
                return zzhbw.zza(zzbtvVar);
            }
        }, zzcfr.zzh);
    }

    public final void zzc(final String str, final zzbpq zzbpqVar) {
        this.zzb = zzhbw.zzk(this.zzb, new zzgta() { // from class: com.google.android.gms.internal.ads.zzbup
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                zzbtv zzbtvVar = (zzbtv) obj;
                zzbtvVar.zzn(str, zzbpqVar);
                return zzbtvVar;
            }
        }, zzcfr.zzh);
    }
}
