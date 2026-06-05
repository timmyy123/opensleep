package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbhv$zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfhd implements zzfhw {
    private final zzfhw zza;
    private final zzfhw zzb;
    private final zzfnj zzc;
    private final String zzd;
    private zzdbz zze;
    private final Executor zzf;

    public zzfhd(zzfhw zzfhwVar, zzfhw zzfhwVar2, zzfnj zzfnjVar, String str, Executor executor) {
        this.zza = zzfhwVar;
        this.zzb = zzfhwVar2;
        this.zzc = zzfnjVar;
        this.zzd = str;
        this.zzf = executor;
    }

    private final ListenableFuture zzg(zzfmw zzfmwVar, zzfhx zzfhxVar) {
        zzdbz zzdbzVar = zzfmwVar.zza;
        this.zze = zzdbzVar;
        if (zzfmwVar.zzc != null) {
            if (zzdbzVar.zzc() != null) {
                zzfmwVar.zzc.zzp().zzv(zzfmwVar.zza.zzc());
            }
            return zzhbw.zza(zzfmwVar.zzc);
        }
        zzdbzVar.zza().zzh(zzfmwVar.zzb);
        return ((zzfhn) this.zza).zzb(zzfhxVar, null, zzfmwVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfhw
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzdbz zzd() {
        return this.zze;
    }

    public final synchronized ListenableFuture zzb(final zzfhx zzfhxVar, final zzfhv zzfhvVar, zzdbz zzdbzVar) {
        zzdby zzdbyVarZza = zzfhvVar.zza(zzfhxVar.zzb);
        zzdbyVarZza.zzi(new zzfhe(this.zzd));
        final zzdbz zzdbzVar2 = (zzdbz) zzdbyVarZza.zzh();
        zzdbzVar2.zzb();
        zzdbzVar2.zzb();
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzdbzVar2.zzb().zzd;
        if (zzmVar.zzs != null || zzmVar.zzx != null) {
            this.zze = zzdbzVar2;
            return ((zzfhn) this.zza).zzb(zzfhxVar, zzfhvVar, zzdbzVar2);
        }
        zzfky zzfkyVarZzb = zzdbzVar2.zzb();
        com.google.android.gms.ads.internal.client.zzm zzmVar2 = zzfkyVarZzb.zzd;
        String str = zzfkyVarZzb.zzg;
        com.google.android.gms.ads.internal.client.zzx zzxVar = zzfkyVarZzb.zzk;
        Executor executor = this.zzf;
        final zzfhc zzfhcVar = new zzfhc(zzfhvVar, zzfhxVar, zzmVar2, str, executor, zzxVar, null);
        return (zzhbo) zzhbw.zzj(zzhbo.zzw(((zzfhj) this.zzb).zza(zzfhxVar, zzfhvVar, zzdbzVar2)), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfhb
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zze(zzfhxVar, zzfhcVar, zzfhvVar, zzdbzVar2, (zzfhi) obj);
            }
        }, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzfhw
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfhx zzfhxVar, zzfhv zzfhvVar, Object obj) {
        return zzb(zzfhxVar, zzfhvVar, null);
    }

    public final /* synthetic */ ListenableFuture zze(zzfhx zzfhxVar, zzfhc zzfhcVar, zzfhv zzfhvVar, zzdbz zzdbzVar, zzfhi zzfhiVar) {
        if (zzfhiVar != null) {
            zzfhc zzfhcVar2 = new zzfhc(zzfhcVar.zza, zzfhcVar.zzb, zzfhcVar.zzc, zzfhcVar.zzd, zzfhcVar.zze, zzfhcVar.zzf, zzfhiVar.zza);
            zzfmw zzfmwVar = zzfhiVar.zzc;
            if (zzfmwVar != null) {
                this.zze = null;
                this.zzc.zza(zzfhcVar2);
                return zzg(zzfmwVar, zzfhxVar);
            }
            zzfnj zzfnjVar = this.zzc;
            ListenableFuture listenableFutureZzb = zzfnjVar.zzb(zzfhcVar2);
            if (listenableFutureZzb != null) {
                this.zze = null;
                return zzhbw.zzj(listenableFutureZzb, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfha
                    @Override // com.google.android.gms.internal.ads.zzhbe
                    public final /* synthetic */ ListenableFuture zza(Object obj) {
                        return this.zza.zzf((zzfnf) obj);
                    }
                }, this.zzf);
            }
            zzfnjVar.zza(zzfhcVar2);
            zzfhxVar = new zzfhx(zzfhxVar.zzb, zzfhiVar.zzb);
        }
        ListenableFuture listenableFutureZzb2 = ((zzfhn) this.zza).zzb(zzfhxVar, zzfhvVar, zzdbzVar);
        this.zze = zzdbzVar;
        return listenableFutureZzb2;
    }

    public final /* synthetic */ ListenableFuture zzf(zzfnf zzfnfVar) throws zzeed {
        zzfmw zzfmwVar;
        zzfnh zzfnhVar;
        if (zzfnfVar == null || (zzfmwVar = zzfnfVar.zza) == null || (zzfnhVar = zzfnfVar.zzb) == null) {
            throw new zzeed(1, "Empty prefetch");
        }
        zzbhv$zzb.zzc zzcVarZzs = zzbhv$zzb.zzs();
        zzbhv$zzb.zza.C0005zza c0005zzaZzs = zzbhv$zzb.zza.zzs();
        c0005zzaZzs.zzc(zzbhv$zzb.zzd.IN_MEMORY);
        c0005zzaZzs.zzg(zzbhv$zzb.zze.zzs());
        zzcVarZzs.zzh(c0005zzaZzs);
        zzfmwVar.zza.zza().zzd().zzl(zzcVarZzs.zzbm());
        return zzg(zzfmwVar, ((zzfhc) zzfnhVar).zzb);
    }
}
