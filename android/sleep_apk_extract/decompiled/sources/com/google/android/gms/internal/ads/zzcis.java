package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcis extends com.google.android.gms.ads.internal.util.zzb {
    final zzchn zza;
    final zzcja zzb;
    private final String zzc;
    private final String[] zzd;

    public zzcis(zzchn zzchnVar, zzcja zzcjaVar, String str, String[] strArr) {
        this.zza = zzchnVar;
        this.zzb = zzcjaVar;
        this.zzc = str;
        this.zzd = strArr;
        com.google.android.gms.ads.internal.zzt.zzB().zzc(this);
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        try {
            this.zzb.zzf(this.zzc, this.zzd);
        } finally {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new zzciq(this));
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final ListenableFuture zzb() {
        return (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcH)).booleanValue() && (this.zzb instanceof zzcjj)) ? zzcfr.zzf.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzcir
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zze();
            }
        }) : super.zzb();
    }

    public final String zzd() {
        return this.zzc;
    }

    public final /* synthetic */ Boolean zze() {
        return Boolean.valueOf(this.zzb.zzg(this.zzc, this.zzd, this));
    }
}
