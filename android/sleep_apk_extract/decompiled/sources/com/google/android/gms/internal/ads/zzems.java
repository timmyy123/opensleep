package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzems implements zzels {
    private final zzcwq zza;
    private final Context zzb;
    private final zzdwi zzc;
    private final zzfky zzd;
    private final Executor zze;
    private final zzgta zzf;
    private final zzdzg zzg;

    public zzems(zzcwq zzcwqVar, Context context, Executor executor, zzdwi zzdwiVar, zzfky zzfkyVar, zzgta zzgtaVar, zzdzg zzdzgVar) {
        this.zzb = context;
        this.zza = zzcwqVar;
        this.zze = executor;
        this.zzc = zzdwiVar;
        this.zzd = zzfkyVar;
        this.zzf = zzgtaVar;
        this.zzg = zzdzgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final boolean zza(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        zzfkk zzfkkVar = zzfkfVar.zzs;
        return (zzfkkVar == null || zzfkkVar.zza == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final ListenableFuture zzb(final zzfkq zzfkqVar, final zzfkf zzfkfVar) {
        return zzhbw.zzj(zzhbw.zza(null), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzemr
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzfkqVar, zzfkfVar, obj);
            }
        }, this.zze);
    }

    public final /* synthetic */ ListenableFuture zzc(zzfkq zzfkqVar, zzfkf zzfkfVar, Object obj) throws zzclj {
        zzbih zzbihVar = zzbiq.zzcQ;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_WEBVIEW_CREATION_START.zza(), this.zzg);
        }
        Context context = this.zzb;
        com.google.android.gms.ads.internal.client.zzr zzrVarZza = zzfle.zza(context, zzfkfVar.zzu);
        final zzcku zzckuVarZza = this.zzc.zza(zzrVarZza, zzfkfVar, zzfkqVar.zzb.zzb);
        zzckuVarZza.zzaw(zzfkfVar.zzW);
        View viewZza = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziZ)).booleanValue() && zzfkfVar.zzag) ? zzcxf.zza(context, zzckuVarZza.zzE(), zzfkfVar) : new zzdwl(context, zzckuVarZza.zzE(), (com.google.android.gms.ads.internal.util.zzat) this.zzf.apply(zzfkfVar));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_WEBVIEW_CREATION_END.zza(), this.zzg);
        }
        zzcwq zzcwqVar = this.zza;
        final zzcvm zzcvmVarZzf = zzcwqVar.zzf(new zzcyj(zzfkqVar, zzfkfVar, null), new zzcvs(viewZza, zzckuVarZza, new zzcxr() { // from class: com.google.android.gms.internal.ads.zzemn
            @Override // com.google.android.gms.internal.ads.zzcxr
            public final /* synthetic */ com.google.android.gms.ads.internal.client.zzea zza() {
                return zzckuVarZza.zzh();
            }
        }, zzfle.zzb(zzrVarZza)));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_AD_COMPONENT_CREATION_END.zza(), this.zzg);
        }
        zzdwh zzdwhVarZzj = zzcvmVarZzf.zzj();
        zzdzg zzdzgVar = this.zzg;
        zzdwhVarZzj.zzi(zzckuVarZza, false, null, zzdzgVar);
        zzddj zzddjVarZzd = zzcvmVarZzf.zzd();
        zzddl zzddlVar = new zzddl() { // from class: com.google.android.gms.internal.ads.zzemo
            @Override // com.google.android.gms.internal.ads.zzddl
            public final /* synthetic */ void zzdr() {
                zzcku zzckuVar = zzckuVarZza;
                if (zzckuVar.zzP() != null) {
                    zzckuVar.zzP().zzq();
                }
            }
        };
        zzhcg zzhcgVar = zzcfr.zzh;
        zzddjVarZzd.zzq(zzddlVar, zzhcgVar);
        zzfkk zzfkkVar = zzfkfVar.zzs;
        String strZza = zzfkkVar.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgn)).booleanValue() && zzcvmVarZzf.zzm().zza(true)) {
            strZza = zzcml.zza(strZza, zzcml.zzb(zzfkfVar));
        }
        zzcvmVarZzf.zzj();
        ListenableFuture listenableFutureZzj = zzdwh.zzj(zzckuVarZza, zzfkkVar.zzb, strZza, zzdzgVar, zzcwqVar.zze());
        if (zzfkfVar.zzM) {
            listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzemm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzckuVarZza.zzav();
                }
            }, this.zze);
        }
        listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzemp
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd(zzckuVarZza);
            }
        }, this.zze);
        return zzhbw.zzk(listenableFutureZzj, new zzgta() { // from class: com.google.android.gms.internal.ads.zzemq
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj2) {
                return zzcvmVarZzf.zzi();
            }
        }, zzhcgVar);
    }

    public final /* synthetic */ void zzd(zzcku zzckuVar) {
        zzckuVar.zzJ();
        zzfky zzfkyVar = this.zzd;
        zzcma zzcmaVarZzh = zzckuVar.zzh();
        com.google.android.gms.ads.internal.client.zzfw zzfwVar = zzfkyVar.zza;
        if (zzfwVar != null && zzcmaVarZzh != null) {
            zzcmaVarZzh.zzc(zzfwVar);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbU)).booleanValue() || zzckuVar.isAttachedToWindow()) {
            return;
        }
        zzckuVar.onPause();
        zzckuVar.zzaG(true);
    }
}
