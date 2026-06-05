package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzffj implements zzhbt {
    final /* synthetic */ zzetr zza;
    final /* synthetic */ zzfqg zzb;
    final /* synthetic */ zzfpw zzc;
    final /* synthetic */ zzffk zzd;
    final /* synthetic */ zzffn zze;

    public zzffj(zzffn zzffnVar, zzetr zzetrVar, zzfqg zzfqgVar, zzfpw zzfpwVar, zzffk zzffkVar) {
        this.zza = zzetrVar;
        this.zzb = zzfqgVar;
        this.zzc = zzfpwVar;
        this.zzd = zzffkVar;
        Objects.requireNonNull(zzffnVar);
        this.zze = zzffnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfqg zzfqgVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgL)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("App open ad failed to load", th);
        }
        zzffn zzffnVar = this.zze;
        zzcuv zzcuvVar = (zzcuv) zzffnVar.zzj().zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzcuvVar == null ? zzfma.zzb(th, null) : zzcuvVar.zza().zzg(th);
        synchronized (zzffnVar) {
            try {
                zzffnVar.zzl(null);
                if (zzcuvVar != null) {
                    zzcuvVar.zze().zzdJ(zzeVarZzb);
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjv)).booleanValue()) {
                        zzffnVar.zzh().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffi
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zze.zzi().zzdJ(zzeVarZzb);
                            }
                        });
                    }
                } else {
                    zzffnVar.zzi().zzdJ(zzeVarZzb);
                    ((zzcuv) zzffnVar.zzg(this.zzd).zzh()).zza().zzd().zzo();
                }
                zzflv.zza(zzeVarZzb.zza, th, "AppOpenAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
                    zzfqj zzfqjVarZzk = zzffnVar.zzk();
                    zzfpw zzfpwVar = this.zzc;
                    zzfpwVar.zzh(zzeVarZzb);
                    zzfpwVar.zzj(th);
                    zzfpwVar.zzd(false);
                    zzfqjVarZzk.zzb(zzfpwVar.zzm());
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
        zzffn zzffnVar = this.zze;
        zzcxt zzcxtVar = (zzcxt) obj;
        synchronized (zzffnVar) {
            if (zzcxtVar != null) {
                try {
                    zzcxtVar.zzt();
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzffnVar.zzl(null);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjv)).booleanValue()) {
                zzcxtVar.zzq().zzc(zzffnVar.zzi());
            }
            this.zza.zzb(zzcxtVar);
            if (!((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
                zzfqj zzfqjVarZzk = zzffnVar.zzk();
                zzfpw zzfpwVar = this.zzc;
                zzfpwVar.zzg(zzcxtVar.zzr().zzb);
                zzfpwVar.zzi(zzcxtVar.zzn().zze());
                zzfpwVar.zzd(true);
                zzfqjVarZzk.zzb(zzfpwVar.zzm());
            } else {
                zzfqgVar.zze(zzcxtVar.zzr().zzb);
                zzfqgVar.zzg(zzcxtVar.zzn().zze());
                zzfpw zzfpwVar2 = this.zzc;
                zzfpwVar2.zzd(true);
                zzfqgVar.zza(zzfpwVar2);
                zzfqgVar.zzh();
            }
        }
    }
}
