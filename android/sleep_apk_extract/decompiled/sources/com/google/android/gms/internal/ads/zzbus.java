package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class zzbus implements zzbqg {
    private final zzcfw zza;

    public zzbus(zzbuu zzbuuVar, zzcfw zzcfwVar) {
        Objects.requireNonNull(zzbuuVar);
        this.zza = zzcfwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zza(JSONObject jSONObject) {
        try {
            this.zza.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zza.zzd(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zzb(String str) {
        zzcfw zzcfwVar = this.zza;
        try {
            if (str == null) {
                zzcfwVar.zzd(new zzbtx());
            } else {
                zzcfwVar.zzd(new zzbtx(str));
            }
        } catch (IllegalStateException unused) {
        }
    }
}
