package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdtu {
    private final zzfky zza;
    private final Executor zzb;
    private final zzdwi zzc;
    private final zzdvd zzd;
    private final Context zze;
    private final zzdzl zzf;
    private final zzfsc zzg;
    private final zzekg zzh;
    private final zzdzg zzi;
    private final zzeao zzj;

    public zzdtu(zzfky zzfkyVar, Executor executor, zzdwi zzdwiVar, Context context, zzdzl zzdzlVar, zzfsc zzfscVar, zzekg zzekgVar, zzdvd zzdvdVar, zzdzg zzdzgVar, zzeao zzeaoVar) {
        this.zza = zzfkyVar;
        this.zzb = executor;
        this.zzc = zzdwiVar;
        this.zze = context;
        this.zzf = zzdzlVar;
        this.zzg = zzfscVar;
        this.zzh = zzekgVar;
        this.zzd = zzdvdVar;
        this.zzi = zzdzgVar;
        this.zzj = zzeaoVar;
    }

    private final void zzh(zzcku zzckuVar, zzcfv zzcfvVar) {
        com.google.android.gms.ads.internal.client.zzfw zzfwVar = this.zza.zza;
        if (zzfwVar != null && zzckuVar.zzh() != null) {
            zzckuVar.zzh().zzc(zzfwVar);
        }
        zzcfvVar.zzb();
    }

    private final void zzi(zzcku zzckuVar, com.google.android.gms.ads.internal.zzb zzbVar, zzcdn zzcdnVar) {
        zzeao zzeaoVar;
        zzj(zzckuVar);
        zzckuVar.zzab("/video", zzbpp.zzl);
        zzckuVar.zzab("/videoMeta", zzbpp.zzm);
        zzckuVar.zzab("/precache", new zzcjb());
        zzckuVar.zzab("/delayPageLoaded", zzbpp.zzp);
        zzckuVar.zzab("/instrument", zzbpp.zzn);
        zzckuVar.zzab("/log", zzbpp.zzg);
        zzckuVar.zzab("/click", zzbpp.zzb(null, null));
        if (this.zza.zzb != null) {
            zzckuVar.zzP().zzT(true);
            zzckuVar.zzab("/open", new zzbqd(true != ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpg)).booleanValue() ? null : zzbVar, null, null, null, null, null));
        } else {
            zzckuVar.zzP().zzT(false);
        }
        if (com.google.android.gms.ads.internal.zzt.zzD().zza(zzckuVar.getContext())) {
            Map map = new HashMap();
            if (zzckuVar.zzC() != null) {
                map = zzckuVar.zzC().zzaw;
            }
            zzckuVar.zzab("/logScionEvent", new zzbpw(zzckuVar.getContext(), map));
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpg)).booleanValue()) {
            zzckuVar.zzP().zzi(zzbVar);
            zzckuVar.zzP().zzj(zzcdnVar);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziK)).booleanValue() || (zzeaoVar = this.zzj) == null) {
            return;
        }
        zzckuVar.zzab("/onDeviceStorageEvent", new zzbpy(zzeaoVar));
    }

    private static final void zzj(zzcku zzckuVar) {
        zzckuVar.zzab("/videoClicked", zzbpp.zzh);
        zzckuVar.zzP().zzR(true);
        zzckuVar.zzab("/getNativeAdViewSignals", zzbpp.zzs);
        zzckuVar.zzab("/getNativeClickMeta", zzbpp.zzt);
    }

    public final ListenableFuture zza(final JSONObject jSONObject, final com.google.android.gms.ads.internal.zzb zzbVar, final zzcdn zzcdnVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcU)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.NATIVE_ASSETS_LOADING_VIDEO_START.zza(), this.zzi);
        }
        ListenableFuture listenableFutureZza = zzhbw.zza(null);
        zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.internal.ads.zzdtp
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zze(zzbVar, zzcdnVar, obj);
            }
        };
        Executor executor = this.zzb;
        return zzhbw.zzj(zzhbw.zzj(listenableFutureZza, zzhbeVar, executor), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzdtt
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc(jSONObject, (zzcku) obj);
            }
        }, executor);
    }

    public final ListenableFuture zzb(final String str, final String str2, final zzfkf zzfkfVar, final zzfki zzfkiVar, final com.google.android.gms.ads.internal.client.zzr zzrVar, final com.google.android.gms.ads.internal.zzb zzbVar, final zzcdn zzcdnVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcU)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.NATIVE_ASSETS_LOADING_VIDEO_COMPOSITION_START.zza(), this.zzi);
        }
        return zzhbw.zzj(zzhbw.zza(null), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzdto
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzd(zzrVar, zzfkfVar, zzfkiVar, zzbVar, zzcdnVar, str, str2, obj);
            }
        }, this.zzb);
    }

    public final /* synthetic */ ListenableFuture zzc(JSONObject jSONObject, final zzcku zzckuVar) {
        zzbsb zzbsbVar = this.zza.zzb;
        final zzcfv zzcfvVarZza = zzcfv.zza(zzckuVar);
        if (zzbsbVar != null) {
            zzckuVar.zzaf(zzcne.zze());
        } else {
            zzckuVar.zzaf(zzcne.zzd());
        }
        zzckuVar.zzP().zzG(new zzcmq() { // from class: com.google.android.gms.internal.ads.zzdts
            @Override // com.google.android.gms.internal.ads.zzcmq
            public final /* synthetic */ void zza(boolean z, int i, String str, String str2) {
                this.zza.zzg(zzckuVar, zzcfvVarZza, z, i, str, str2);
            }
        });
        zzckuVar.zzb("google.afma.nativeAds.renderVideo", jSONObject);
        return zzcfvVarZza;
    }

    public final /* synthetic */ ListenableFuture zzd(com.google.android.gms.ads.internal.client.zzr zzrVar, zzfkf zzfkfVar, zzfki zzfkiVar, com.google.android.gms.ads.internal.zzb zzbVar, zzcdn zzcdnVar, String str, String str2, Object obj) throws zzclj {
        final zzcku zzckuVarZza = this.zzc.zza(zzrVar, zzfkfVar, zzfkiVar);
        final zzcfv zzcfvVarZza = zzcfv.zza(zzckuVarZza);
        if (this.zza.zzb != null) {
            zzi(zzckuVarZza, zzbVar, zzcdnVar);
            zzckuVarZza.zzaf(zzcne.zze());
        } else {
            zzdva zzdvaVarZza = this.zzd.zza();
            zzcms zzcmsVarZzP = zzckuVarZza.zzP();
            zzbih zzbihVar = zzbiq.zzpg;
            zzcmsVarZzP.zzab(zzdvaVarZza, zzdvaVarZza, zzdvaVarZza, zzdvaVarZza, zzdvaVarZza, false, null, !((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() ? new com.google.android.gms.ads.internal.zzb(this.zze, null, null) : zzbVar, null, true != ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() ? null : zzcdnVar, this.zzh, this.zzg, this.zzf, null, zzdvaVarZza, null, null, null, null, this.zzj, null, null);
            zzj(zzckuVarZza);
        }
        zzckuVarZza.zzP().zzG(new zzcmq() { // from class: com.google.android.gms.internal.ads.zzdtr
            @Override // com.google.android.gms.internal.ads.zzcmq
            public final /* synthetic */ void zza(boolean z, int i, String str3, String str4) {
                this.zza.zzf(zzckuVarZza, zzcfvVarZza, z, i, str3, str4);
            }
        });
        zzckuVarZza.zzau(str, str2, null);
        return zzcfvVarZza;
    }

    public final /* synthetic */ ListenableFuture zze(com.google.android.gms.ads.internal.zzb zzbVar, zzcdn zzcdnVar, Object obj) throws zzclj {
        zzcku zzckuVarZza = this.zzc.zza(com.google.android.gms.ads.internal.client.zzr.zzb(), null, null);
        final zzcfv zzcfvVarZza = zzcfv.zza(zzckuVarZza);
        zzi(zzckuVarZza, zzbVar, zzcdnVar);
        zzckuVarZza.zzP().zzH(new zzcmr() { // from class: com.google.android.gms.internal.ads.zzdtq
            @Override // com.google.android.gms.internal.ads.zzcmr
            public final /* synthetic */ void zza() {
                zzcfvVarZza.zzb();
            }
        });
        zzckuVarZza.loadUrl((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeG));
        return zzcfvVarZza;
    }

    public final /* synthetic */ void zzf(zzcku zzckuVar, zzcfv zzcfvVar, boolean z, int i, String str, String str2) {
        if (z) {
            com.google.android.gms.ads.internal.client.zzfw zzfwVar = this.zza.zza;
            if (zzfwVar != null && zzckuVar.zzh() != null) {
                zzckuVar.zzh().zzc(zzfwVar);
            }
            zzcfvVar.zzb();
            return;
        }
        int length = String.valueOf(i).length();
        StringBuilder sb = new StringBuilder(length + 63 + String.valueOf(str).length() + 15 + String.valueOf(str2).length());
        zzba$$ExternalSyntheticOutline0.m(sb, "Html video Web View failed to load. Error code: ", i, ", Description: ", str);
        zzcfvVar.zzd(new zzeph(1, FileInsert$$ExternalSyntheticOutline0.m(sb, ", Failing URL: ", str2)));
    }

    public final /* synthetic */ void zzg(zzcku zzckuVar, zzcfv zzcfvVar, boolean z, int i, String str, String str2) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeO)).booleanValue()) {
            zzh(zzckuVar, zzcfvVar);
            return;
        }
        if (z) {
            zzh(zzckuVar, zzcfvVar);
            return;
        }
        int length = String.valueOf(i).length();
        StringBuilder sb = new StringBuilder(length + 64 + String.valueOf(str).length() + 15 + String.valueOf(str2).length());
        zzba$$ExternalSyntheticOutline0.m(sb, "Native Video WebView failed to load. Error code: ", i, ", Description: ", str);
        zzcfvVar.zzd(new zzeph(1, FileInsert$$ExternalSyntheticOutline0.m(sb, ", Failing URL: ", str2)));
    }
}
