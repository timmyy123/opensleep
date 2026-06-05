package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzevr implements zzfck {
    private final Executor zza;
    private final zzcfd zzb;

    public zzevr(Executor executor, zzcfd zzcfdVar) {
        this.zza = executor;
        this.zzb = zzcfdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdO)).booleanValue()) {
            return zzhbw.zza(new zzevs(null));
        }
        zzcfd zzcfdVar = this.zzb;
        return zzhbw.zzk(zzcfdVar.zzq(), zzevq.zza, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 10;
    }
}
