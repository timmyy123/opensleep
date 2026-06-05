package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfjs implements zzets {
    private final Context zza;
    private final Executor zzb;
    private final zzcnj zzc;
    private final zzfjj zzd;
    private final zzfhw zze;
    private final zzfkr zzf;
    private final zzfqj zzg;
    private final zzfkx zzh;
    private ListenableFuture zzi;

    public zzfjs(Context context, Executor executor, zzcnj zzcnjVar, zzfhw zzfhwVar, zzfjj zzfjjVar, zzfkx zzfkxVar, zzfkr zzfkrVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcnjVar;
        this.zze = zzfhwVar;
        this.zzd = zzfjjVar;
        this.zzh = zzfkxVar;
        this.zzf = zzfkrVar;
        this.zzg = zzcnjVar.zzx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzdvq zze(zzfhu zzfhuVar) {
        zzdvq zzdvqVarZzp = this.zzc.zzp();
        zzdca zzdcaVar = new zzdca();
        zzdcaVar.zza(this.zza);
        zzdcaVar.zzb(((zzfjr) zzfhuVar).zza);
        zzdcaVar.zzf(this.zzf);
        zzdvqVarZzp.zzd(zzdcaVar.zze());
        zzdvqVarZzp.zze(new zzdiq().zzn());
        return zzdvqVarZzp;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    @Override // com.google.android.gms.internal.ads.zzets
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zza(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzetq zzetqVar, zzetr zzetrVar) {
        zzfqg zzfqgVar;
        zzcbw zzcbwVar = new zzcbw(zzmVar, str);
        String str2 = zzcbwVar.zzb;
        if (str2 == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfjq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzc();
                }
            });
            return false;
        }
        ListenableFuture listenableFuture = this.zzi;
        if (listenableFuture != null && !listenableFuture.isDone()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdi)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzay.zzc();
        }
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            zzfhw zzfhwVar = this.zze;
            if (zzfhwVar.zzd() != null) {
                zzfqg zzfqgVarZzd = ((zzdvr) zzfhwVar.zzd()).zzd();
                zzfqgVarZzd.zzi(5);
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = zzcbwVar.zza;
                zzfqgVarZzd.zzc(zzmVar2.zzp);
                zzfqgVarZzd.zzd(zzmVar2.zzm);
                zzfqgVar = zzfqgVarZzd;
            } else {
                zzfqgVar = null;
            }
        }
        Context context = this.zza;
        com.google.android.gms.ads.internal.client.zzm zzmVar3 = zzcbwVar.zza;
        boolean z = zzmVar3.zzf;
        zzflv.zzb(context, z);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzko)).booleanValue() && z) {
            this.zzc.zzw().zzc(true);
        }
        Bundle bundleZza = zzdyw.zza(new Pair(zzdyu.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar3.zzz)), new Pair(zzdyu.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis())));
        zzfkx zzfkxVar = this.zzh;
        zzfkxVar.zzg(str2);
        zzfkxVar.zzc(com.google.android.gms.ads.internal.client.zzr.zzc());
        zzfkxVar.zza(zzmVar3);
        zzfkxVar.zzv(bundleZza);
        zzfky zzfkyVarZzB = zzfkxVar.zzB();
        zzfpw zzfpwVarZzo = zzfpw.zzo(context, zzfqf.zzg(zzfkyVarZzB), 5, zzmVar3);
        zzfjr zzfjrVar = new zzfjr(null);
        zzfjrVar.zza = zzfkyVarZzB;
        ListenableFuture listenableFutureZzc = this.zze.zzc(new zzfhx(zzfjrVar, null), new zzfhv() { // from class: com.google.android.gms.internal.ads.zzfjp
            @Override // com.google.android.gms.internal.ads.zzfhv
            public final /* synthetic */ zzdby zza(zzfhu zzfhuVar) {
                return this.zza.zzd(zzfhuVar);
            }
        }, null);
        this.zzi = listenableFutureZzc;
        zzhbw.zzr(listenableFutureZzc, new zzfjo(this, zzetrVar, zzfqgVar, zzfpwVarZzo, zzfjrVar), this.zzb);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzets
    public final boolean zzb() {
        throw null;
    }

    public final /* synthetic */ void zzc() {
        this.zzd.zzdJ(zzfma.zzd(6, null, null));
    }

    public final /* synthetic */ Executor zzf() {
        return this.zzb;
    }

    public final /* synthetic */ zzfjj zzg() {
        return this.zzd;
    }

    public final /* synthetic */ zzfhw zzh() {
        return this.zze;
    }

    public final /* synthetic */ zzfqj zzi() {
        return this.zzg;
    }

    public final void zzj(int i) {
        this.zzh.zzj().zza(i);
    }
}
