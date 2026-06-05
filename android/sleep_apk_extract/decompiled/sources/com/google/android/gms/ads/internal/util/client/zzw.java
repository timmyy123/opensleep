package com.google.android.gms.ads.internal.util.client;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzw {
    public static zzw zzd(JSONObject jSONObject) {
        return new zzm(jSONObject.optInt("impression_prerequisite", 0), jSONObject.optInt("click_prerequisite", 0), jSONObject.optBoolean("notification_flow_enabled", false));
    }

    public abstract int zza();

    public abstract int zzb();

    public abstract boolean zzc();
}
