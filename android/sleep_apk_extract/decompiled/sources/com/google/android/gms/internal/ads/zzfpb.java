package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfpb {
    final /* synthetic */ zzfpc zza;
    private final Object zzb;
    private final String zzc;
    private final ListenableFuture zzd;
    private final List zze;
    private final ListenableFuture zzf;

    private zzfpb(zzfpc zzfpcVar, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2) {
        Objects.requireNonNull(zzfpcVar);
        this.zza = zzfpcVar;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = listenableFuture;
        this.zze = list;
        this.zzf = listenableFuture2;
    }

    public final zzfpb zza(String str) {
        return new zzfpb(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfpb zzb(final zzfok zzfokVar) {
        return zzc(new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfpa
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzhbw.zza(zzfokVar.zza(obj));
            }
        });
    }

    public final zzfpb zzc(zzhbe zzhbeVar) {
        return zzd(zzhbeVar, this.zza.zze());
    }

    public final zzfpb zzd(zzhbe zzhbeVar, Executor executor) {
        return new zzfpb(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzhbw.zzj(this.zzf, zzhbeVar, executor));
    }

    public final zzfpb zze(final ListenableFuture listenableFuture) {
        return zzd(new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfox
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return listenableFuture;
            }
        }, zzcfr.zzh);
    }

    public final zzfpb zzf(Class cls, final zzfok zzfokVar) {
        return zzg(cls, new zzhbe(zzfokVar) { // from class: com.google.android.gms.internal.ads.zzfoy
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzhbw.zza("");
            }
        });
    }

    public final zzfpb zzg(Class cls, zzhbe zzhbeVar) {
        zzfpc zzfpcVar = this.zza;
        zzhcg zzhcgVarZze = zzfpcVar.zze();
        return new zzfpb(zzfpcVar, this.zzb, this.zzc, this.zzd, this.zze, zzhbw.zzh(this.zzf, cls, zzhbeVar, zzhcgVarZze));
    }

    public final zzfpb zzh(long j, TimeUnit timeUnit) {
        zzfpc zzfpcVar = this.zza;
        ScheduledExecutorService scheduledExecutorServiceZzf = zzfpcVar.zzf();
        return new zzfpb(zzfpcVar, this.zzb, this.zzc, this.zzd, this.zze, zzhbw.zzi(this.zzf, j, timeUnit, scheduledExecutorServiceZzf));
    }

    public final zzfor zzi() {
        Object obj = this.zzb;
        String strZzc = this.zzc;
        if (strZzc == null) {
            strZzc = this.zza.zzc(obj);
        }
        final zzfor zzforVar = new zzfor(obj, strZzc, this.zzf);
        this.zza.zzg().zza(zzforVar);
        ListenableFuture listenableFuture = this.zzd;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfoz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zza.zzg().zzb(zzforVar);
            }
        };
        zzhcg zzhcgVar = zzcfr.zzh;
        listenableFuture.addListener(runnable, zzhcgVar);
        zzhbw.zzr(zzforVar, new zzfow(this, zzforVar), zzhcgVar);
        return zzforVar;
    }

    public final zzfpb zzj(Object obj) {
        return this.zza.zza(obj, zzi());
    }

    public /* synthetic */ zzfpb(zzfpc zzfpcVar, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2, byte[] bArr) {
        this(zzfpcVar, obj, null, listenableFuture, list, listenableFuture2);
    }
}
