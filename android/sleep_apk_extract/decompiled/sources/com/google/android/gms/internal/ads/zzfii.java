package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfii implements zzets {
    private final Context zza;
    private final Executor zzb;
    private final zzcnj zzc;
    private final zzetc zzd;
    private final zzfjj zze;
    private zzbjl zzf;
    private final zzfqj zzg;
    private final zzfkx zzh;
    private ListenableFuture zzi;

    public zzfii(Context context, Executor executor, zzcnj zzcnjVar, zzetc zzetcVar, zzfjj zzfjjVar, zzfkx zzfkxVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcnjVar;
        this.zzd = zzetcVar;
        this.zzh = zzfkxVar;
        this.zze = zzfjjVar;
        this.zzg = zzcnjVar.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzets
    public final boolean zza(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzetq zzetqVar, zzetr zzetrVar) {
        zzdng zzdngVarZza;
        zzfqg zzfqgVarZzc;
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfih
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzd();
                }
            });
            return false;
        }
        if (zzb()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdi)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzay.zzc();
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzko)).booleanValue() && zzmVar.zzf) {
            this.zzc.zzw().zzc(true);
        }
        com.google.android.gms.ads.internal.client.zzr zzrVar = ((zzfib) zzetqVar).zza;
        Bundle bundleZza = zzdyw.zza(new Pair(zzdyu.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar.zzz)), new Pair(zzdyu.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis())));
        zzfkx zzfkxVar = this.zzh;
        zzfkxVar.zzg(str);
        zzfkxVar.zzc(zzrVar);
        zzfkxVar.zza(zzmVar);
        zzfkxVar.zzv(bundleZza);
        Context context = this.zza;
        zzfky zzfkyVarZzB = zzfkxVar.zzB();
        zzfpw zzfpwVarZzo = zzfpw.zzo(context, zzfqf.zzg(zzfkyVarZzB), 4, zzmVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjw)).booleanValue()) {
            zzdnf zzdnfVarZzm = this.zzc.zzm();
            zzdca zzdcaVar = new zzdca();
            zzdcaVar.zza(context);
            zzdcaVar.zzb(zzfkyVarZzB);
            zzdnfVarZzm.zze(zzdcaVar.zze());
            zzdiq zzdiqVar = new zzdiq();
            zzetc zzetcVar = this.zzd;
            Executor executor = this.zzb;
            zzdiqVar.zzm(zzetcVar, executor);
            zzdiqVar.zze(zzetcVar, executor);
            zzdnfVarZzm.zzf(zzdiqVar.zzn());
            zzdnfVarZzm.zzd(new zzeri(this.zzf));
            zzdngVarZza = zzdnfVarZzm.zzh();
        } else {
            zzdiq zzdiqVar2 = new zzdiq();
            zzfjj zzfjjVar = this.zze;
            if (zzfjjVar != null) {
                Executor executor2 = this.zzb;
                zzdiqVar2.zza(zzfjjVar, executor2);
                zzdiqVar2.zzb(zzfjjVar, executor2);
                zzdiqVar2.zzc(zzfjjVar, executor2);
            }
            zzdnf zzdnfVarZzm2 = this.zzc.zzm();
            zzdca zzdcaVar2 = new zzdca();
            zzdcaVar2.zza(context);
            zzdcaVar2.zzb(zzfkyVarZzB);
            zzdnfVarZzm2.zze(zzdcaVar2.zze());
            zzetc zzetcVar2 = this.zzd;
            Executor executor3 = this.zzb;
            zzdiqVar2.zzm(zzetcVar2, executor3);
            zzdiqVar2.zza(zzetcVar2, executor3);
            zzdiqVar2.zzb(zzetcVar2, executor3);
            zzdiqVar2.zzc(zzetcVar2, executor3);
            zzdiqVar2.zzf(zzetcVar2, executor3);
            zzdiqVar2.zzg(zzetcVar2, executor3);
            zzdiqVar2.zze(zzetcVar2, executor3);
            zzdiqVar2.zzk(zzetcVar2, executor3);
            zzdiqVar2.zzd(zzetcVar2, executor3);
            zzdnfVarZzm2.zzf(zzdiqVar2.zzn());
            zzdnfVarZzm2.zzd(new zzeri(this.zzf));
            zzdngVarZza = zzdnfVarZzm2.zzh();
        }
        zzdng zzdngVar = zzdngVarZza;
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            zzfqgVarZzc = zzdngVar.zzc();
            zzfqgVarZzc.zzi(4);
            zzfqgVarZzc.zzc(zzmVar.zzp);
            zzfqgVarZzc.zzd(zzmVar.zzm);
        } else {
            zzfqgVarZzc = null;
        }
        zzfqg zzfqgVar = zzfqgVarZzc;
        zzcyx zzcyxVarZzb = zzdngVar.zzb();
        ListenableFuture listenableFutureZzc = zzcyxVarZzb.zzc(zzcyxVarZzb.zzb());
        this.zzi = listenableFutureZzc;
        zzhbw.zzr(listenableFutureZzc, new zzfig(this, zzetrVar, zzfqgVar, zzfpwVarZzo, zzdngVar), this.zzb);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzets
    public final boolean zzb() {
        ListenableFuture listenableFuture = this.zzi;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    public final void zzc(zzbjl zzbjlVar) {
        this.zzf = zzbjlVar;
    }

    public final /* synthetic */ void zzd() {
        this.zzd.zzdJ(zzfma.zzd(6, null, null));
    }

    public final /* synthetic */ Executor zze() {
        return this.zzb;
    }

    public final /* synthetic */ zzetc zzf() {
        return this.zzd;
    }

    public final /* synthetic */ zzfjj zzg() {
        return this.zze;
    }

    public final /* synthetic */ zzfqj zzh() {
        return this.zzg;
    }

    public final /* synthetic */ void zzi(ListenableFuture listenableFuture) {
        this.zzi = null;
    }
}
