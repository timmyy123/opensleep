package com.google.android.gms.internal.ads;

import android.content.Context;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeqf implements zzels {
    private final Context zza;
    private final zzdwi zzb;
    private final zzdvr zzc;
    private final zzfky zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbpt zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkn)).booleanValue();
    private final zzekr zzi;
    private final zzdzg zzj;
    private final zzdzl zzk;

    public zzeqf(Context context, VersionInfoParcel versionInfoParcel, zzfky zzfkyVar, Executor executor, zzdvr zzdvrVar, zzdwi zzdwiVar, zzbpt zzbptVar, zzekr zzekrVar, zzdzg zzdzgVar, zzdzl zzdzlVar) {
        this.zza = context;
        this.zzd = zzfkyVar;
        this.zzc = zzdvrVar;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdwiVar;
        this.zzg = zzbptVar;
        this.zzi = zzekrVar;
        this.zzj = zzdzgVar;
        this.zzk = zzdzlVar;
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
        zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.internal.ads.zzeqe
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzfkfVar, zzfkqVar, zzdwmVar, obj);
            }
        };
        Executor executor = this.zze;
        ListenableFuture listenableFutureZzj = zzhbw.zzj(listenableFutureZza, zzhbeVar, executor);
        listenableFutureZzj.addListener(new Runnable(zzdwmVar) { // from class: com.google.android.gms.internal.ads.zzepy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
            }
        }, executor);
        return listenableFutureZzj;
    }

    public final /* synthetic */ ListenableFuture zzc(final zzfkf zzfkfVar, zzfkq zzfkqVar, zzdwm zzdwmVar, Object obj) throws zzclj {
        zzbih zzbihVar = zzbiq.zzcQ;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_WEBVIEW_CREATION_START.zza(), this.zzj);
        }
        zzdwi zzdwiVar = this.zzb;
        zzfky zzfkyVar = this.zzd;
        final zzcku zzckuVarZza = zzdwiVar.zza(zzfkyVar.zzf, zzfkfVar, zzfkqVar.zzb.zzb);
        zzckuVarZza.zzaw(zzfkfVar.zzW);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_WEBVIEW_CREATION_END.zza(), this.zzj);
        }
        zzcfw zzcfwVar = new zzcfw();
        zzdvr zzdvrVar = this.zzc;
        zzcyj zzcyjVar = new zzcyj(zzfkqVar, zzfkfVar, null);
        Context context = this.zza;
        VersionInfoParcel versionInfoParcel = this.zzf;
        zzbpt zzbptVar = this.zzg;
        boolean z = this.zzh;
        zzekr zzekrVar = this.zzi;
        zzdzg zzdzgVar = this.zzj;
        final zzdvn zzdvnVarZzf = zzdvrVar.zzf(zzcyjVar, new zzdvo(new zzeqb(context, zzdwiVar, zzfkyVar, versionInfoParcel, zzfkfVar, zzcfwVar, zzckuVarZza, zzbptVar, z, zzekrVar, zzdzgVar, this.zzk), zzckuVarZza));
        zzcfwVar.zzc(zzdvnVarZzf);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_AD_COMPONENT_CREATION_END.zza(), zzdzgVar);
        }
        zzbqj.zzb(zzckuVarZza, zzdvnVarZzf.zzk());
        zzdvnVarZzf.zzd().zzq(new zzddl() { // from class: com.google.android.gms.internal.ads.zzeqc
            @Override // com.google.android.gms.internal.ads.zzddl
            public final /* synthetic */ void zzdr() {
                zzcku zzckuVar = zzckuVarZza;
                if (zzckuVar.zzP() != null) {
                    zzckuVar.zzP().zzq();
                }
            }
        }, zzcfr.zzh);
        zzdvnVarZzf.zzl().zzi(zzckuVarZza, true, true != z ? null : zzbptVar, zzdzgVar);
        zzfkk zzfkkVar = zzfkfVar.zzs;
        String strZza = zzfkkVar.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgn)).booleanValue() && zzdvnVarZzf.zzo().zza(true)) {
            strZza = zzcml.zza(strZza, zzcml.zzb(zzfkfVar));
        }
        zzdvnVarZzf.zzl();
        return zzhbw.zzk(zzdwh.zzj(zzckuVarZza, zzfkkVar.zzb, strZza, zzdzgVar, zzdvrVar.zzd()), new zzgta(this) { // from class: com.google.android.gms.internal.ads.zzeqd
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj2) {
                zzcku zzckuVar = zzckuVarZza;
                if (zzfkfVar.zzM) {
                    zzckuVar.zzav();
                }
                zzdvn zzdvnVar = zzdvnVarZzf;
                zzckuVar.zzJ();
                zzckuVar.onPause();
                return zzdvnVar.zzh();
            }
        }, this.zze);
    }
}
