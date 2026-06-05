package com.google.android.gms.internal.ads;

import android.content.Context;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzemd implements zzels {
    private final zzcuz zza;
    private final zzdwi zzb;
    private final zzfky zzc;
    private final Executor zzd;
    private final VersionInfoParcel zze;
    private final zzbpt zzf;
    private final boolean zzg = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkn)).booleanValue();
    private final zzekr zzh;
    private final zzdzg zzi;
    private final zzdzl zzj;

    public zzemd(zzcuz zzcuzVar, Context context, Executor executor, zzdwi zzdwiVar, zzfky zzfkyVar, VersionInfoParcel versionInfoParcel, zzbpt zzbptVar, zzekr zzekrVar, zzdzg zzdzgVar, zzdzl zzdzlVar) {
        this.zza = zzcuzVar;
        this.zzd = executor;
        this.zzb = zzdwiVar;
        this.zzc = zzfkyVar;
        this.zze = versionInfoParcel;
        this.zzf = zzbptVar;
        this.zzh = zzekrVar;
        this.zzi = zzdzgVar;
        this.zzj = zzdzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final boolean zza(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        zzfkk zzfkkVar = zzfkfVar.zzs;
        return (zzfkkVar == null || zzfkkVar.zza == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final ListenableFuture zzb(final zzfkq zzfkqVar, final zzfkf zzfkfVar) {
        final zzdwm zzdwmVar = new zzdwm();
        ListenableFuture listenableFutureZza = zzhbw.zza(null);
        zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.internal.ads.zzemb
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzfkfVar, zzfkqVar, zzdwmVar, obj);
            }
        };
        Executor executor = this.zzd;
        ListenableFuture listenableFutureZzj = zzhbw.zzj(listenableFutureZza, zzhbeVar, executor);
        listenableFutureZzj.addListener(new Runnable(zzdwmVar) { // from class: com.google.android.gms.internal.ads.zzemc
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
            }
        }, executor);
        return listenableFutureZzj;
    }

    public final /* synthetic */ ListenableFuture zzc(final zzfkf zzfkfVar, zzfkq zzfkqVar, zzdwm zzdwmVar, Object obj) throws zzclj {
        zzbih zzbihVar = zzbiq.zzcQ;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_WEBVIEW_CREATION_START.zza(), this.zzi);
        }
        zzdwi zzdwiVar = this.zzb;
        zzfky zzfkyVar = this.zzc;
        final zzcku zzckuVarZza = zzdwiVar.zza(zzfkyVar.zzf, zzfkfVar, zzfkqVar.zzb.zzb);
        zzckuVarZza.zzaw(zzfkfVar.zzW);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_WEBVIEW_CREATION_END.zza(), this.zzi);
        }
        zzcfw zzcfwVar = new zzcfw();
        zzcuz zzcuzVar = this.zza;
        zzcyj zzcyjVar = new zzcyj(zzfkqVar, zzfkfVar, null);
        VersionInfoParcel versionInfoParcel = this.zze;
        boolean z = this.zzg;
        zzbpt zzbptVar = this.zzf;
        final zzcuw zzcuwVarZzf = zzcuzVar.zzf(zzcyjVar, new zzdmd(new zzemf(versionInfoParcel, zzcfwVar, zzfkfVar, zzckuVarZza, zzfkyVar, z, zzbptVar, this.zzh, this.zzj), zzckuVarZza), new zzcux(zzfkfVar.zzaa));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_AD_COMPONENT_CREATION_END.zza(), this.zzi);
        }
        zzdwh zzdwhVarZzi = zzcuwVarZzf.zzi();
        zzbpt zzbptVar2 = true == z ? zzbptVar : null;
        zzdzg zzdzgVar = this.zzi;
        zzdwhVarZzi.zzi(zzckuVarZza, false, zzbptVar2, zzdzgVar);
        zzcfwVar.zzc(zzcuwVarZzf);
        zzcuwVarZzf.zzd().zzq(new zzddl() { // from class: com.google.android.gms.internal.ads.zzelz
            @Override // com.google.android.gms.internal.ads.zzddl
            public final /* synthetic */ void zzdr() {
                zzcku zzckuVar = zzckuVarZza;
                if (zzckuVar.zzP() != null) {
                    zzckuVar.zzP().zzq();
                }
            }
        }, zzcfr.zzh);
        zzfkk zzfkkVar = zzfkfVar.zzs;
        String strZza = zzfkkVar.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgn)).booleanValue() && zzcuwVarZzf.zzk().zza(true)) {
            strZza = zzcml.zza(strZza, zzcml.zzb(zzfkfVar));
        }
        zzcuwVarZzf.zzi();
        return zzhbw.zzk(zzdwh.zzj(zzckuVarZza, zzfkkVar.zzb, strZza, zzdzgVar, zzcuzVar.zzd()), new zzgta(this) { // from class: com.google.android.gms.internal.ads.zzema
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj2) {
                zzcku zzckuVar = zzckuVarZza;
                if (zzfkfVar.zzM) {
                    zzckuVar.zzav();
                }
                zzcuw zzcuwVar = zzcuwVarZzf;
                zzckuVar.zzJ();
                zzckuVar.onPause();
                return zzcuwVar.zzh();
            }
        }, this.zzd);
    }
}
