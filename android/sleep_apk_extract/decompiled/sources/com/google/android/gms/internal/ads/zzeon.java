package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeon {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcxw zzc;
    private final zzepd zzd;
    private final zzfry zze;
    private final zzhcp zzf = zzhcp.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    private zzeoo zzh;
    private zzfkq zzi;

    public zzeon(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcxw zzcxwVar, zzepd zzepdVar, zzfry zzfryVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcxwVar;
        this.zzd = zzepdVar;
        this.zze = zzfryVar;
    }

    private final synchronized ListenableFuture zzd(zzfkf zzfkfVar) {
        Iterator it = zzfkfVar.zza.iterator();
        while (it.hasNext()) {
            zzels zzelsVarZza = this.zzc.zza(zzfkfVar.zzb, (String) it.next());
            if (zzelsVarZza != null && zzelsVarZza.zza(this.zzi, zzfkfVar)) {
                return zzhbw.zzi(zzelsVarZza.zzb(this.zzi, zzfkfVar), zzfkfVar.zzR, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzhbw.zzc(new zzeed(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final void zzb(zzfkf zzfkfVar) {
        ListenableFuture listenableFutureZzd = zzd(zzfkfVar);
        this.zzd.zze(this.zzi, zzfkfVar, listenableFutureZzd, this.zze);
        zzhbw.zzr(listenableFutureZzd, new zzeom(this, zzfkfVar), this.zza);
    }

    public final synchronized ListenableFuture zza(zzfkq zzfkqVar) {
        try {
            if (!this.zzg.getAndSet(true)) {
                List list = zzfkqVar.zzb.zza;
                if (list.isEmpty()) {
                    this.zzf.zzb(new zzeph(3, zzepk.zzb(zzfkqVar)));
                } else {
                    this.zzi = zzfkqVar;
                    zzepd zzepdVar = this.zzd;
                    this.zzh = new zzeoo(zzfkqVar, zzepdVar, this.zzf);
                    zzepdVar.zzc(list);
                    zzfkf zzfkfVarZza = this.zzh.zza();
                    while (zzfkfVarZza != null) {
                        zzb(zzfkfVarZza);
                        zzfkfVarZza = this.zzh.zza();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzf;
    }

    public final /* synthetic */ zzeoo zzc() {
        return this.zzh;
    }
}
