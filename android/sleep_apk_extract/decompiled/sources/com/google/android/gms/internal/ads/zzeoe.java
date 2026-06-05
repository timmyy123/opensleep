package com.google.android.gms.internal.ads;

import android.content.Context;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.GraphResponse;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeoe implements zzeny {
    private final zzdoc zza;
    private final zzhcg zzb;
    private final zzdsn zzc;
    private final zzflx zzd;
    private final zzdvd zze;
    private final zzdzg zzf;
    private final VersionInfoParcel zzg;
    private final Context zzh;
    private final zzcdj zzi;

    public zzeoe(zzdoc zzdocVar, zzhcg zzhcgVar, zzdsn zzdsnVar, zzflx zzflxVar, zzdvd zzdvdVar, zzdzg zzdzgVar, VersionInfoParcel versionInfoParcel, Context context, zzcdj zzcdjVar) {
        this.zzg = versionInfoParcel;
        this.zzh = context;
        this.zzi = zzcdjVar;
        this.zza = zzdocVar;
        this.zzb = zzhcgVar;
        this.zzc = zzdsnVar;
        this.zzd = zzflxVar;
        this.zze = zzdvdVar;
        this.zzf = zzdzgVar;
    }

    private final ListenableFuture zzg(final zzfkq zzfkqVar, final zzfkf zzfkfVar, final JSONObject jSONObject) {
        com.google.android.gms.ads.internal.zzb zzbVar;
        zzcdn zzcdnVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcQ)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_WEBVIEW_CREATION_START.zza(), this.zzf);
        }
        final ListenableFuture listenableFutureZzb = this.zzd.zzb();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpg)).booleanValue();
        Context context = this.zzh;
        if (zBooleanValue) {
            zzcdn zzcdnVarZza = zzdcm.zza(context, this.zzg, zzfkfVar, this.zzi);
            zzbVar = new com.google.android.gms.ads.internal.zzb(context, zzcdnVarZza, null);
            zzcdnVar = zzcdnVarZza;
        } else {
            zzbVar = new com.google.android.gms.ads.internal.zzb(context, null, null);
            zzcdnVar = null;
        }
        final com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar;
        final zzcdn zzcdnVar2 = zzcdnVar;
        final ListenableFuture listenableFutureZza = this.zzc.zza(zzfkqVar, zzfkfVar, jSONObject, zzbVar2, zzcdnVar2);
        return zzhbw.zzo(listenableFutureZzb, listenableFutureZza).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeoc
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzf(listenableFutureZza, listenableFutureZzb, zzfkqVar, zzfkfVar, jSONObject, zzbVar2, zzcdnVar2);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final boolean zza(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        zzfkk zzfkkVar = zzfkfVar.zzs;
        return (zzfkkVar == null || zzfkkVar.zzc == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final ListenableFuture zzb(final zzfkq zzfkqVar, final zzfkf zzfkfVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcP)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_NATIVE_ADS_NATIVE_JS_WEBVIEW_START.zza(), this.zzf);
        }
        ListenableFuture listenableFutureZzb = this.zzd.zzb();
        zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.internal.ads.zzeod
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzfkfVar, (zzdux) obj);
            }
        };
        zzhcg zzhcgVar = this.zzb;
        return zzhbw.zzj(zzhbw.zzj(listenableFutureZzb, zzhbeVar, zzhcgVar), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzenz
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzd(zzfkqVar, zzfkfVar, (JSONArray) obj);
            }
        }, zzhcgVar);
    }

    public final /* synthetic */ ListenableFuture zzc(zzfkf zzfkfVar, final zzdux zzduxVar) throws JSONException {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcP)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_NATIVE_ADS_PREPROCESS_START.zza(), this.zzf);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjV)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfkfVar.zzs.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzhbw.zzj(zzduxVar.zzc("google.afma.nativeAds.preProcessJson", jSONObject2), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzeoa
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zze(zzduxVar, (JSONObject) obj);
            }
        }, this.zzb);
    }

    public final /* synthetic */ ListenableFuture zzd(zzfkq zzfkqVar, zzfkf zzfkfVar, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return zzhbw.zzc(new zzeed(3));
        }
        int i = zzfkqVar.zza.zza.zzl;
        if (i <= 1) {
            return zzhbw.zzk(zzg(zzfkqVar, zzfkfVar, jSONArray.getJSONObject(0)), zzeob.zza, this.zzb);
        }
        int length = jSONArray.length();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcR)).booleanValue()) {
            this.zzf.zzd("nsl", String.valueOf(length));
        }
        this.zzd.zza(Math.min(length, i));
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < length) {
                arrayList.add(zzg(zzfkqVar, zzfkfVar, jSONArray.getJSONObject(i2)));
            } else {
                arrayList.add(zzhbw.zzc(new zzeed(3)));
            }
        }
        return zzhbw.zza(arrayList);
    }

    public final /* synthetic */ ListenableFuture zze(zzdux zzduxVar, JSONObject jSONObject) throws zzbtx {
        this.zzd.zzc(zzhbw.zza(zzduxVar));
        if (!jSONObject.optBoolean(GraphResponse.SUCCESS_KEY)) {
            throw new zzbtx("process json failed");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcP)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_NATIVE_ADS_PREPROCESS_END.zza(), this.zzf);
        }
        return zzhbw.zza(jSONObject.getJSONObject("json").getJSONArray("ads"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ zzdpo zzf(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfkq zzfkqVar, zzfkf zzfkfVar, JSONObject jSONObject, com.google.android.gms.ads.internal.zzb zzbVar, zzcdn zzcdnVar) {
        zzdpt zzdptVar = (zzdpt) listenableFuture.get();
        zzdux zzduxVar = (zzdux) listenableFuture2.get();
        zzbih zzbihVar = zzbiq.zzcQ;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_WEBVIEW_CREATION_END.zza(), this.zzf);
        }
        zzdpu zzdpuVarZzd = this.zza.zzd(new zzcyj(zzfkqVar, zzfkfVar, null), new zzdqe(zzdptVar), new zzdop(jSONObject, zzduxVar, zzbVar, zzcdnVar));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            zzdzg zzdzgVar = this.zzf;
            zzdzgVar.zzf(zzdyu.RENDERING_AD_COMPONENT_CREATION_END.zza(), jCurrentTimeMillis);
            zzdzgVar.zzf(zzdyu.RENDERING_CONFIGURE_WEBVIEW_START.zza(), jCurrentTimeMillis);
        }
        zzdpuVarZzd.zzi().zzb();
        zzdpuVarZzd.zzj().zza(zzduxVar);
        zzdpuVarZzd.zzk().zza(zzdptVar.zzT());
        zzdpuVarZzd.zzl().zza(this.zze, zzdptVar.zzU());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.RENDERING_CONFIGURE_WEBVIEW_END.zza(), this.zzf);
        }
        return zzdpuVarZzd.zzh();
    }
}
