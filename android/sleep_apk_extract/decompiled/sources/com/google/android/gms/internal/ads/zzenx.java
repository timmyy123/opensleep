package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzenx implements zzelu {
    private final zzdxc zza;

    public zzenx(zzdxc zzdxcVar) {
        this.zza = zzdxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzelu
    public final zzelv zza(String str, JSONObject jSONObject) {
        return new zzelv(this.zza.zza(str, jSONObject), new zzenh(), str);
    }
}
