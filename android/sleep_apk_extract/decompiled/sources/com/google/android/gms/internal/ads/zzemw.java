package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzemw implements zzely {
    private final Context zza;
    private final zzcwq zzb;
    private final Executor zzc;

    public zzemw(Context context, zzcwq zzcwqVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcwqVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        com.google.android.gms.ads.internal.client.zzr zzrVar;
        zzfky zzfkyVar = zzfkqVar.zza.zza;
        com.google.android.gms.ads.internal.client.zzr zzrVar2 = zzfkyVar.zzf;
        if (zzrVar2.zzn) {
            zzrVar = new com.google.android.gms.ads.internal.client.zzr(this.zza, com.google.android.gms.ads.zzc.zzb(zzrVar2.zze, zzrVar2.zzb));
        } else {
            zzrVar = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziZ)).booleanValue() && zzfkfVar.zzag) ? new com.google.android.gms.ads.internal.client.zzr(this.zza, com.google.android.gms.ads.zzc.zzc(zzrVar2.zze, zzrVar2.zzb)) : zzfle.zza(this.zza, zzfkfVar.zzu);
        }
        com.google.android.gms.ads.internal.client.zzr zzrVar3 = zzrVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziZ)).booleanValue() && zzfkfVar.zzag) {
            ((zzflw) zzelvVar.zzb).zzb(this.zza, zzrVar3, zzfkyVar.zzd, zzfkfVar.zzv.toString(), com.google.android.gms.ads.internal.util.zzbp.zzm(zzfkfVar.zzs), (zzbvi) zzelvVar.zzc);
        } else {
            ((zzflw) zzelvVar.zzb).zzg(this.zza, zzrVar3, zzfkyVar.zzd, zzfkfVar.zzv.toString(), com.google.android.gms.ads.internal.util.zzbp.zzm(zzfkfVar.zzs), (zzbvi) zzelvVar.zzc);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, final zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        final View viewZza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziZ)).booleanValue() && zzfkfVar.zzag) {
            zzbvl zzbvlVarZzc = ((zzflw) zzelvVar.zzb).zzc();
            if (zzbvlVarZzc == null) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzf("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
                throw new zzflf(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
            }
            try {
                viewZza = (View) ObjectWrapper.unwrap(zzbvlVarZzc.zze());
                boolean zZzf = zzbvlVarZzc.zzf();
                if (viewZza == null) {
                    throw new zzflf(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        viewZza = (View) zzhbw.zzj(zzhbw.zza(null), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzemu
                            @Override // com.google.android.gms.internal.ads.zzhbe
                            public final /* synthetic */ ListenableFuture zza(Object obj) {
                                return this.zza.zzc(viewZza, zzfkfVar, obj);
                            }
                        }, zzcfr.zzf).get();
                    } catch (InterruptedException | ExecutionException e) {
                        zzbuy$$ExternalSyntheticBUOutline0.m(e);
                        return null;
                    }
                }
            } catch (RemoteException e2) {
                zzbuy$$ExternalSyntheticBUOutline0.m((Throwable) e2);
                return null;
            }
        } else {
            viewZza = ((zzflw) zzelvVar.zzb).zza();
        }
        zzcwq zzcwqVar = this.zzb;
        zzcyj zzcyjVar = new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza);
        final zzflw zzflwVar = (zzflw) zzelvVar.zzb;
        Objects.requireNonNull(zzflwVar);
        zzcvm zzcvmVarZzf = zzcwqVar.zzf(zzcyjVar, new zzcvs(viewZza, null, new zzcxr() { // from class: com.google.android.gms.internal.ads.zzemv
            @Override // com.google.android.gms.internal.ads.zzcxr
            public final /* synthetic */ com.google.android.gms.ads.internal.client.zzea zza() {
                return zzflwVar.zzt();
            }
        }, (zzfkg) zzfkfVar.zzu.get(0)));
        zzcvmVarZzf.zzk().zza(viewZza);
        zzcvmVarZzf.zza().zzq(new zzcsz(zzflwVar), this.zzc);
        ((zzenh) zzelvVar.zzc).zzc(zzcvmVarZzf.zzf());
        return zzcvmVarZzf.zzi();
    }

    public final /* synthetic */ ListenableFuture zzc(View view, zzfkf zzfkfVar, Object obj) {
        return zzhbw.zza(zzcxf.zza(this.zza, view, zzfkfVar));
    }
}
