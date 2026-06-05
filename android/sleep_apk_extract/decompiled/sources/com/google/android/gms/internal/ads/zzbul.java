package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class zzbul implements zzbqg {
    final /* synthetic */ zzbum zza;
    private final zzbto zzb;
    private final zzcfw zzc;

    public zzbul(zzbum zzbumVar, zzbto zzbtoVar, zzcfw zzcfwVar) {
        Objects.requireNonNull(zzbumVar);
        this.zza = zzbumVar;
        this.zzb = zzbtoVar;
        this.zzc = zzcfwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zza(JSONObject jSONObject) {
        try {
            try {
                this.zzc.zzc(this.zza.zzd().zza(jSONObject));
            } catch (IllegalStateException unused) {
            } catch (JSONException e) {
                this.zzc.zzd(e);
            }
        } finally {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zzb(String str) {
        zzcfw zzcfwVar = this.zzc;
        try {
            if (str == null) {
                zzcfwVar.zzd(new zzbtx());
            } else {
                zzcfwVar.zzd(new zzbtx(str));
            }
        } catch (IllegalStateException unused) {
        } catch (Throwable th) {
            this.zzb.zza();
            throw th;
        }
        this.zzb.zza();
    }
}
