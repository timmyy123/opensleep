package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcyx {
    private final zzefs zza;
    private final zzfky zzb;
    private final zzfpk zzc;
    private final zzcrr zzd;
    private final zzepk zze;
    private final zzdig zzf;
    private zzfkq zzg;
    private final zzehd zzh;
    private final zzdbw zzi;
    private final Executor zzj;
    private final zzego zzk;
    private final zzelx zzl;

    public zzcyx(zzefs zzefsVar, zzfky zzfkyVar, zzfpk zzfpkVar, zzcrr zzcrrVar, zzepk zzepkVar, zzdig zzdigVar, zzfkq zzfkqVar, zzehd zzehdVar, zzdbw zzdbwVar, Executor executor, zzego zzegoVar, zzelx zzelxVar) {
        this.zza = zzefsVar;
        this.zzb = zzfkyVar;
        this.zzc = zzfpkVar;
        this.zzd = zzcrrVar;
        this.zze = zzepkVar;
        this.zzf = zzdigVar;
        this.zzg = zzfkqVar;
        this.zzh = zzehdVar;
        this.zzi = zzdbwVar;
        this.zzj = executor;
        this.zzk = zzegoVar;
        this.zzl = zzelxVar;
    }

    public final ListenableFuture zza(ListenableFuture listenableFuture) {
        if (this.zzg != null) {
            zzfpk zzfpkVar = this.zzc;
            zzfpe zzfpeVar = zzfpe.SERVER_TRANSACTION;
            Objects.requireNonNull(zzfpkVar);
            return zzfov.zza(zzhbw.zza(this.zzg), zzfpeVar, zzfpkVar).zzi();
        }
        com.google.android.gms.ads.internal.zzt.zzj().zzb();
        zzfpb zzfpbVarZza = this.zzc.zza(zzfpe.SERVER_TRANSACTION, listenableFuture);
        final zzego zzegoVar = this.zzk;
        Objects.requireNonNull(zzegoVar);
        return zzfpbVarZza.zzc(new zzhbe() { // from class: com.google.android.gms.internal.ads.zzcyw
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzegoVar.zza((zzcbd) obj);
            }
        }).zzi();
    }

    public final ListenableFuture zzb() {
        zzfky zzfkyVar = this.zzb;
        if (!zzfkyVar.zzv) {
            com.google.android.gms.ads.internal.client.zzm zzmVar = zzfkyVar.zzd;
            if (zzmVar.zzx != null || zzmVar.zzs != null) {
                zzfpk zzfpkVar = this.zzc;
                zzfpe zzfpeVar = zzfpe.PRELOADED_LOADER;
                Objects.requireNonNull(zzfpkVar);
                return zzfov.zza(this.zza.zza(), zzfpeVar, zzfpkVar).zzi();
            }
        }
        return zza(this.zzi.zzb());
    }

    public final ListenableFuture zzc(ListenableFuture listenableFuture) {
        zzfpb zzfpbVarZzc = this.zzc.zza(zzfpe.RENDERER, listenableFuture).zzb(new zzfok() { // from class: com.google.android.gms.internal.ads.zzcyv
            @Override // com.google.android.gms.internal.ads.zzfok
            public final /* synthetic */ Object zza(Object obj) {
                zzfkq zzfkqVar = (zzfkq) obj;
                this.zza.zzi(zzfkqVar);
                return zzfkqVar;
            }
        }).zzc(this.zze);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgC)).booleanValue()) {
            zzfpbVarZzc = zzfpbVarZzc.zzh(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgD)).intValue(), TimeUnit.SECONDS);
        }
        return zzfpbVarZzc.zzi();
    }

    public final zzdig zzd() {
        return this.zzf;
    }

    public final ListenableFuture zze(final zzfmu zzfmuVar) {
        zzfor zzforVarZzi = this.zzc.zza(zzfpe.GET_CACHE_KEY, this.zzi.zzb()).zzc(new zzhbe() { // from class: com.google.android.gms.internal.ads.zzcyu
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzj(zzfmuVar, (zzcbd) obj);
            }
        }).zzi();
        zzhbw.zzr(zzforVarZzi, new zzcys(this), this.zzj);
        return zzforVarZzi;
    }

    public final ListenableFuture zzf(zzcbd zzcbdVar) {
        zzfor zzforVarZzi = this.zzc.zza(zzfpe.NOTIFY_CACHE_HIT, this.zzh.zzb(zzcbdVar)).zzi();
        zzhbw.zzr(zzforVarZzi, new zzcyt(this), this.zzj);
        return zzforVarZzi;
    }

    public final com.google.android.gms.ads.internal.client.zze zzg(Throwable th) {
        return zzfma.zzb(th, this.zzl);
    }

    public final void zzh(zzfkq zzfkqVar) {
        this.zzg = zzfkqVar;
    }

    public final /* synthetic */ zzfkq zzi(zzfkq zzfkqVar) {
        this.zzd.zza(zzfkqVar);
        return zzfkqVar;
    }

    public final /* synthetic */ ListenableFuture zzj(zzfmu zzfmuVar, zzcbd zzcbdVar) {
        zzcbdVar.zzi = zzfmuVar;
        return this.zzh.zza(zzcbdVar);
    }

    public final /* synthetic */ zzdig zzk() {
        return this.zzf;
    }
}
