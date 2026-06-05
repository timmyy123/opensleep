package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzehx implements zzfok {
    static final /* synthetic */ zzehx zza = new zzehx();

    private /* synthetic */ zzehx() {
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final /* synthetic */ Object zza(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        com.google.android.gms.ads.internal.util.zze.zza("Ad request signals:");
        com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
        return jSONObject;
    }
}
