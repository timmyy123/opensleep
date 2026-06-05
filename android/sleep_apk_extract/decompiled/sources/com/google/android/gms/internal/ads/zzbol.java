package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class zzbol implements zzbpq {
    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzc;
        zzcku zzckuVar = (zzcku) obj;
        zzblr zzblrVarZzar = zzckuVar.zzar();
        if (zzblrVarZzar == null || (jSONObjectZzc = zzblrVarZzar.zzc()) == null) {
            zzckuVar.zzd("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzckuVar.zzd("nativeAdViewSignalsReady", jSONObjectZzc);
        }
    }
}
