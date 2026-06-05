package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zzfjo implements zzhbt {
    final /* synthetic */ zzetr zza;
    final /* synthetic */ zzfqg zzb;
    final /* synthetic */ zzfpw zzc;
    final /* synthetic */ zzfjr zzd;
    final /* synthetic */ zzfjs zze;

    public zzfjo(zzfjs zzfjsVar, zzetr zzetrVar, zzfqg zzfqgVar, zzfpw zzfpwVar, zzfjr zzfjrVar) {
        this.zza = zzetrVar;
        this.zzb = zzfqgVar;
        this.zzc = zzfpwVar;
        this.zzd = zzfjrVar;
        Objects.requireNonNull(zzfjsVar);
        this.zze = zzfjsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfqg zzfqgVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgL)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Rewarded ad failed to load", th);
        }
        zzfjs zzfjsVar = this.zze;
        zzdvr zzdvrVar = (zzdvr) zzfjsVar.zzh().zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzdvrVar == null ? zzfma.zzb(th, null) : zzdvrVar.zza().zzg(th);
        synchronized (zzfjsVar) {
            try {
                if (zzdvrVar != null) {
                    zzdvrVar.zze().zzdJ(zzeVarZzb);
                    zzfjsVar.zzf().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfjn
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzg().zzdJ(zzeVarZzb);
                        }
                    });
                } else {
                    zzfjsVar.zzg().zzdJ(zzeVarZzb);
                    zzfjsVar.zze(this.zzd).zzh().zza().zzd().zzo();
                }
                zzflv.zza(zzeVarZzb.zza, th, "RewardedAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
                    zzfqj zzfqjVarZzi = zzfjsVar.zzi();
                    zzfpw zzfpwVar = this.zzc;
                    zzfpwVar.zzh(zzeVarZzb);
                    zzfpwVar.zzj(th);
                    zzfpwVar.zzd(false);
                    zzfqjVarZzi.zzb(zzfpwVar.zzm());
                } else {
                    zzfqgVar.zzf(zzeVarZzb);
                    zzfpw zzfpwVar2 = this.zzc;
                    zzfpwVar2.zzj(th);
                    zzfpwVar2.zzd(false);
                    zzfqgVar.zza(zzfpwVar2);
                    zzfqgVar.zzh();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfqg zzfqgVar;
        zzfjs zzfjsVar = this.zze;
        zzdvm zzdvmVar = (zzdvm) obj;
        synchronized (zzfjsVar) {
            if (zzdvmVar != null) {
                try {
                    zzdvmVar.zzt();
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzdvmVar.zzq().zzd(zzfjsVar.zzg());
            this.zza.zzb(zzdvmVar);
            Executor executorZzf = zzfjsVar.zzf();
            final zzfjj zzfjjVarZzg = zzfjsVar.zzg();
            Objects.requireNonNull(zzfjjVarZzg);
            executorZzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfjm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzfjjVarZzg.zzg();
                }
            });
            zzfjsVar.zzg().onAdMetadataChanged();
            if (!((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
                zzfqj zzfqjVarZzi = zzfjsVar.zzi();
                zzfpw zzfpwVar = this.zzc;
                zzfpwVar.zzg(zzdvmVar.zzr().zzb);
                zzfpwVar.zzi(zzdvmVar.zzn().zze());
                zzfpwVar.zzd(true);
                zzfqjVarZzi.zzb(zzfpwVar.zzm());
            } else {
                zzfqgVar.zze(zzdvmVar.zzr().zzb);
                zzfqgVar.zzg(zzdvmVar.zzn().zze());
                zzfpw zzfpwVar2 = this.zzc;
                zzfpwVar2.zzd(true);
                zzfqgVar.zza(zzfpwVar2);
                zzfqgVar.zzh();
            }
        }
    }
}
