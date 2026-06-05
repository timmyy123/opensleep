package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class zzbom implements zzbpq {
    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzd;
        zzcku zzckuVar = (zzcku) obj;
        zzblr zzblrVarZzar = zzckuVar.zzar();
        if (zzblrVarZzar == null || (jSONObjectZzd = zzblrVarZzar.zzd()) == null) {
            zzckuVar.zzd("nativeClickMetaReady", new JSONObject());
        } else {
            zzckuVar.zzd("nativeClickMetaReady", jSONObjectZzd);
        }
    }
}
