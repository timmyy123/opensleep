package com.google.android.gms.ads.internal.util.client;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzv {
    private final zzx zza;

    private zzv(zzx zzxVar) {
        this.zza = zzxVar;
    }

    public static zzv zzb(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ping_strategy");
        return new zzv(jSONObjectOptJSONObject == null ? new zzn(1, 0, 1.0d, false) : new zzn(jSONObjectOptJSONObject.optInt("max_attempts", 1), jSONObjectOptJSONObject.optInt("initial_backoff_ms", 0), jSONObjectOptJSONObject.optDouble("backoff_multiplier", 1.0d), jSONObjectOptJSONObject.optBoolean("buffer_after_max_attempts", false)));
    }

    public final zzx zza() {
        return this.zza;
    }
}
