package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdth {
    private final Executor zza;
    private final zzdtc zzb;
    private final zzdzg zzc;

    public zzdth(Executor executor, zzdtc zzdtcVar, zzdzg zzdzgVar) {
        this.zza = executor;
        this.zzb = zzdtcVar;
        this.zzc = zzdzgVar;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture listenableFutureZza;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("custom_assets");
        if (jSONArrayOptJSONArray == null) {
            return zzhbw.zza(Collections.EMPTY_LIST);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcU)).booleanValue()) {
            zzba$$ExternalSyntheticOutline0.m(zzdyu.NATIVE_ASSETS_LOADING_CUSTOM_START.zza(), this.zzc);
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                listenableFutureZza = zzhbw.zza(null);
            } else {
                final String strOptString = jSONObjectOptJSONObject.optString("name");
                if (strOptString == null) {
                    listenableFutureZza = zzhbw.zza(null);
                } else {
                    String strOptString2 = jSONObjectOptJSONObject.optString("type");
                    listenableFutureZza = "string".equals(strOptString2) ? zzhbw.zza(new zzdte(strOptString, jSONObjectOptJSONObject.optString("string_value"))) : "image".equals(strOptString2) ? zzhbw.zzk(this.zzb.zza(jSONObjectOptJSONObject, "image_value", null), new zzgta() { // from class: com.google.android.gms.internal.ads.zzdtf
                        @Override // com.google.android.gms.internal.ads.zzgta
                        public final /* synthetic */ Object apply(Object obj) {
                            return new zzdte(strOptString, (zzblp) obj);
                        }
                    }, this.zza) : zzhbw.zza(null);
                }
            }
            arrayList.add(listenableFutureZza);
        }
        return zzhbw.zzk(zzhbw.zzm(arrayList), zzdtg.zza, this.zza);
    }
}
