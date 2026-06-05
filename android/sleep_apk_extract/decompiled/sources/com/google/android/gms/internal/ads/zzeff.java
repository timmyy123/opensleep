package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeff {
    private final ScheduledExecutorService zza;
    private final zzhcg zzb;
    private final zzhcg zzc;
    private final zzege zzd;
    private final zzimo zze;

    public zzeff(ScheduledExecutorService scheduledExecutorService, zzhcg zzhcgVar, zzhcg zzhcgVar2, zzege zzegeVar, zzimo zzimoVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzhcgVar;
        this.zzc = zzhcgVar2;
        this.zzd = zzegeVar;
        this.zze = zzimoVar;
    }

    public final ListenableFuture zza(final zzcbd zzcbdVar) {
        ListenableFuture listenableFutureZzc;
        String str = zzcbdVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzc();
        if (com.google.android.gms.ads.internal.util.zzs.zzF(str)) {
            listenableFutureZzc = zzhbw.zzc(new zzegr(1));
        } else {
            listenableFutureZzc = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzix)).booleanValue() || ((Boolean) zzblb.zza.zze()).booleanValue()) ? this.zzc.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzefc
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzc(zzcbdVar);
                }
            }) : this.zzd.zza(zzcbdVar);
        }
        final int callingUid = Binder.getCallingUid();
        return (zzhbo) zzhbw.zzh((zzhbo) zzhbw.zzi(zzhbo.zzw(listenableFutureZzc), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgD)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefe
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzcbdVar, callingUid, (Throwable) obj);
            }
        }, this.zzb);
    }

    public final /* synthetic */ ListenableFuture zzb(final zzcbd zzcbdVar, int i, Throwable th) {
        Bundle bundle;
        if (zzcbdVar != null && (bundle = zzcbdVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzhbw.zzj(((zzeii) this.zze.zzb()).zzk(zzcbdVar, i), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefd
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzhbw.zza(new zzegs((InputStream) obj, zzcbdVar));
            }
        }, this.zzb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ zzegs zzc(zzcbd zzcbdVar) {
        return (zzegs) this.zzd.zza(zzcbdVar).get(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgD)).intValue(), TimeUnit.SECONDS);
    }
}
