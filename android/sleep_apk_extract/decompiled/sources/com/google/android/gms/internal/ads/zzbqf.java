package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class zzbqf implements zzbqg {
    final /* synthetic */ zzcfw zza;

    public zzbqf(zzbqh zzbqhVar, zzcfw zzcfwVar) {
        this.zza = zzcfwVar;
        Objects.requireNonNull(zzbqhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zza(JSONObject jSONObject) {
        this.zza.zzc(jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zzb(String str) {
        this.zza.zzd(new zzbtx(str));
    }
}
