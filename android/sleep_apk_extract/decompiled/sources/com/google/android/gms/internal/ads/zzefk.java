package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class zzefk implements zzegq {
    private static final Pattern zzh = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzeel zza;
    private final zzhcg zzb;
    private final zzfky zzc;
    private final ScheduledExecutorService zzd;
    private final zzejd zze;
    private final zzfqg zzf;
    private final Context zzg;

    public zzefk(Context context, zzfky zzfkyVar, zzeel zzeelVar, zzhcg zzhcgVar, ScheduledExecutorService scheduledExecutorService, zzejd zzejdVar, zzfqg zzfqgVar) {
        this.zzg = context;
        this.zzc = zzfkyVar;
        this.zza = zzeelVar;
        this.zzb = zzhcgVar;
        this.zzd = scheduledExecutorService;
        this.zze = zzejdVar;
        this.zzf = zzfqgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    public final ListenableFuture zza(zzcbd zzcbdVar) {
        Context context = this.zzg;
        ListenableFuture listenableFutureZza = this.zza.zza(zzcbdVar);
        zzfpw zzfpwVarZzn = zzfpw.zzn(context, 11);
        zzfqf.zzb(listenableFutureZza, zzfpwVarZzn);
        ListenableFuture listenableFutureZzj = zzhbw.zzj(listenableFutureZza, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefj
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzb((zzegs) obj);
            }
        }, this.zzb);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgC)).booleanValue()) {
            listenableFutureZzj = zzhbw.zzh(zzhbw.zzi(listenableFutureZzj, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgD)).intValue(), TimeUnit.SECONDS, this.zzd), TimeoutException.class, zzefi.zza, zzcfr.zzh);
        }
        zzfqf.zzd(listenableFutureZzj, this.zzf, zzfpwVarZzn);
        zzhbw.zzr(listenableFutureZzj, new zzefh(this), zzcfr.zzh);
        return listenableFutureZzj;
    }

    public final /* synthetic */ ListenableFuture zzb(zzegs zzegsVar) {
        return zzhbw.zza(new zzfkq(new zzfkn(this.zzc), zzfkp.zza(new InputStreamReader(zzegsVar.zza()), zzegsVar.zzb().zzm)));
    }

    public final /* synthetic */ zzejd zzc() {
        return this.zze;
    }
}
