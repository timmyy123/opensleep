package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcur implements zzimu {
    private final zzind zza;

    private zzcur(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcur zza(zzind zzindVar) {
        return new zzcur(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcyk) this.zza).zza().zzz);
        } catch (JSONException unused) {
            return null;
        }
    }
}
