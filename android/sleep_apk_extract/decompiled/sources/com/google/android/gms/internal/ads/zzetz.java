package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzetz implements zzets {
    private final zzfkx zza;
    private final zzcnj zzb;
    private final Context zzc;
    private final zzetp zzd;
    private final zzfqj zze;
    private zzcyi zzf;

    public zzetz(zzcnj zzcnjVar, Context context, zzetp zzetpVar, zzfkx zzfkxVar) {
        this.zzb = zzcnjVar;
        this.zzc = context;
        this.zzd = zzetpVar;
        this.zza = zzfkxVar;
        this.zze = zzcnjVar.zzx();
        zzfkxVar.zzt(zzetpVar.zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzets
    public final boolean zza(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzetq zzetqVar, zzetr zzetrVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdi)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzay.zzc();
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        Context context = this.zzc;
        if (com.google.android.gms.ads.internal.util.zzs.zzK(context) && zzmVar.zzs == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to load the ad because app ID is missing.");
            this.zzb.zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzety
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzc();
                }
            });
            return false;
        }
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzetx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzd();
                }
            });
            return false;
        }
        boolean z = zzmVar.zzf;
        zzflv.zzb(context, z);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzko)).booleanValue() && z) {
            this.zzb.zzw().zzc(true);
        }
        int i3 = ((zzett) zzetqVar).zza;
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
        String strZza = zzdyu.PUBLIC_API_CALL.zza();
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        Bundle bundleZza = zzdyw.zza(new Pair(strZza, lValueOf), new Pair(zzdyu.DYNAMITE_ENTER.zza(), lValueOf));
        zzfkx zzfkxVar = this.zza;
        zzfkxVar.zza(zzmVar);
        zzfkxVar.zzv(bundleZza);
        zzfkxVar.zzl(i3);
        zzfky zzfkyVarZzB = zzfkxVar.zzB();
        zzfpw zzfpwVarZzo = zzfpw.zzo(context, zzfqf.zzg(zzfkyVarZzB), 8, zzmVar);
        com.google.android.gms.ads.internal.client.zzcl zzclVar = zzfkyVarZzB.zzo;
        if (zzclVar != null) {
            this.zzd.zzc().zzo(zzclVar);
        }
        zzcnj zzcnjVar = this.zzb;
        zzdob zzdobVarZzo = zzcnjVar.zzo();
        zzdca zzdcaVar = new zzdca();
        zzdcaVar.zza(context);
        zzdcaVar.zzb(zzfkyVarZzB);
        zzdobVarZzo.zzf(zzdcaVar.zze());
        zzdiq zzdiqVar = new zzdiq();
        zzetp zzetpVar = this.zzd;
        zzdiqVar.zze(zzetpVar.zzc(), zzcnjVar.zzb());
        zzdobVarZzo.zzg(zzdiqVar.zzn());
        zzdobVarZzo.zze(zzetpVar.zzb());
        zzfqg zzfqgVarZzc = null;
        zzdobVarZzo.zzd(new zzcvi(null));
        zzdoc zzdocVarZza = zzdobVarZzo.zza();
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            zzfqgVarZzc = zzdocVarZza.zzc();
            zzfqgVarZzc.zzi(8);
            zzfqgVarZzc.zzc(zzmVar.zzp);
            zzfqgVarZzc.zzd(zzmVar.zzm);
        }
        zzfqg zzfqgVar = zzfqgVarZzc;
        zzcnjVar.zzv().zza(1);
        zzhcg zzhcgVarZzc = zzfoa.zzc();
        ScheduledExecutorService scheduledExecutorServiceZzc = zzcnjVar.zzc();
        zzcyx zzcyxVarZza = zzdocVarZza.zza();
        zzcyi zzcyiVar = new zzcyi(zzhcgVarZzc, scheduledExecutorServiceZzc, zzcyxVarZza.zzc(zzcyxVarZza.zzb()));
        this.zzf = zzcyiVar;
        zzcyiVar.zza(new zzetw(this, zzetrVar, zzfqgVar, zzfpwVarZzo, zzdocVarZza));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzets
    public final boolean zzb() {
        zzcyi zzcyiVar = this.zzf;
        return zzcyiVar != null && zzcyiVar.zzb();
    }

    public final /* synthetic */ void zzc() {
        this.zzd.zze().zzdJ(zzfma.zzd(4, null, null));
    }

    public final /* synthetic */ void zzd() {
        this.zzd.zze().zzdJ(zzfma.zzd(6, null, null));
    }

    public final /* synthetic */ zzcnj zze() {
        return this.zzb;
    }

    public final /* synthetic */ zzetp zzf() {
        return this.zzd;
    }

    public final /* synthetic */ zzfqj zzg() {
        return this.zze;
    }
}
