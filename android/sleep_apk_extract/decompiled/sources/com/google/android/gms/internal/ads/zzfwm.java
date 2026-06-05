package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfwm {
    private JSONObject zza;
    private final zzfwv zzb;

    public zzfwm(zzfwv zzfwvVar) {
        this.zzb = zzfwvVar;
    }

    public final void zza(JSONObject jSONObject, HashSet hashSet, long j) {
        this.zzb.zza(new zzfwy(this, hashSet, jSONObject, j));
    }

    public final void zzb(JSONObject jSONObject, HashSet hashSet, long j) {
        this.zzb.zza(new zzfwx(this, hashSet, jSONObject, j));
    }

    public final void zzc() {
        this.zzb.zza(new zzfww(this));
    }

    public final JSONObject zzd() {
        return this.zza;
    }

    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
