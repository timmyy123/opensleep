package com.google.android.gms.internal.ads;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class zzeie implements zzbub {
    @Override // com.google.android.gms.internal.ads.zzbub
    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzeif zzeifVar = (zzeif) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkH)).booleanValue()) {
            zzcbf zzcbfVar = zzeifVar.zzc;
            jSONObject2.put("ad_request_url", zzcbfVar.zze());
            jSONObject2.put("ad_request_post_body", zzcbfVar.zzd());
        }
        zzcbf zzcbfVar2 = zzeifVar.zzc;
        jSONObject2.put("base_url", zzcbfVar2.zzc());
        jSONObject2.put("signals", zzeifVar.zzb);
        zzeil zzeilVar = zzeifVar.zza;
        jSONObject3.put(SDKConstants.PARAM_A2U_BODY, zzeilVar.zzc);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.client.zzay.zza().zzm(zzeilVar.zzb));
        jSONObject3.put("response_code", zzeilVar.zza);
        jSONObject3.put("latency", zzeilVar.zzd);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcbfVar2.zzh());
        return jSONObject;
    }
}
