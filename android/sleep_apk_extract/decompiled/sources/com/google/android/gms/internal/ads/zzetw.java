package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzetw implements zzhbt {
    final /* synthetic */ zzetr zza;
    final /* synthetic */ zzfqg zzb;
    final /* synthetic */ zzfpw zzc;
    final /* synthetic */ zzdoc zzd;
    final /* synthetic */ zzetz zze;

    public zzetw(zzetz zzetzVar, zzetr zzetrVar, zzfqg zzfqgVar, zzfpw zzfpwVar, zzdoc zzdocVar) {
        this.zza = zzetrVar;
        this.zzb = zzfqgVar;
        this.zzc = zzfpwVar;
        this.zzd = zzdocVar;
        Objects.requireNonNull(zzetzVar);
        this.zze = zzetzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfqg zzfqgVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgL)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Native ad failed to load", th);
        }
        zzdoc zzdocVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzdocVar.zza().zzg(th);
        zzdocVar.zzb().zzdJ(zzeVarZzg);
        zzetz zzetzVar = this.zze;
        zzetzVar.zze().zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzetu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze.zzf().zze().zzdJ(zzeVarZzg);
            }
        });
        zzflv.zza(zzeVarZzg.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
            zzfqj zzfqjVarZzg = zzetzVar.zzg();
            zzfpw zzfpwVar = this.zzc;
            zzfpwVar.zzh(zzeVarZzg);
            zzfpwVar.zzj(th);
            zzfpwVar.zzd(false);
            zzfqjVarZzg.zzb(zzfpwVar.zzm());
            return;
        }
        zzfqgVar.zzf(zzeVarZzg);
        zzfpw zzfpwVar2 = this.zzc;
        zzfpwVar2.zzj(th);
        zzfpwVar2.zzd(false);
        zzfqgVar.zza(zzfpwVar2);
        zzfqgVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfqg zzfqgVar;
        zzetz zzetzVar = this.zze;
        zzcxt zzcxtVar = (zzcxt) obj;
        synchronized (zzetzVar) {
            if (zzcxtVar != null) {
                try {
                    zzcxtVar.zzt();
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzcxtVar.zzq().zza(zzetzVar.zzf().zzc());
            this.zza.zzb(zzcxtVar);
            zzetzVar.zze().zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzetv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zze.zzf().zzd().zzg();
                }
            });
            if (!((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
                zzfqj zzfqjVarZzg = zzetzVar.zzg();
                zzfpw zzfpwVar = this.zzc;
                zzfpwVar.zzg(zzcxtVar.zzr().zzb);
                zzfpwVar.zzi(zzcxtVar.zzn().zze());
                zzfpwVar.zzd(true);
                zzfqjVarZzg.zzb(zzfpwVar.zzm());
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
