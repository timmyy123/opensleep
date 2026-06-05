package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfez implements zzfck {
    private final zzcfd zza;
    private final boolean zzb;
    private final ScheduledExecutorService zzc;
    private final zzhcg zzd;
    private final int zze;

    public zzfez(zzcfd zzcfdVar, boolean z, zzcet zzcetVar, zzhcg zzhcgVar, String str, ScheduledExecutorService scheduledExecutorService, int i) {
        this.zza = zzcfdVar;
        this.zzb = z;
        this.zzd = zzhcgVar;
        this.zzc = scheduledExecutorService;
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhX)).booleanValue() && this.zzb) {
            return zzhbw.zza(new zzffa(null));
        }
        if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhZ)).split(",")).contains(String.valueOf(this.zze))) {
            return zzhbw.zza(new zzffa(null));
        }
        ListenableFuture listenableFutureZza = zzhbw.zza(null);
        zzhcg zzhcgVar = this.zzd;
        return zzhbw.zzg(zzhbw.zzi(zzhbw.zzk(listenableFutureZza, zzfey.zza, zzhcgVar), ((Long) zzblf.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzgta() { // from class: com.google.android.gms.internal.ads.zzfex
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzc((Exception) obj);
            }
        }, zzhcgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 50;
    }

    public final /* synthetic */ zzffa zzc(Exception exc) {
        this.zza.zzg(exc, "TrustlessTokenSignal");
        return new zzffa(null);
    }
}
