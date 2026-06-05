package com.google.android.gms.internal.ads;

import android.app.Activity;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzejw extends zzeks {
    private Activity zza;
    private com.google.android.gms.ads.internal.overlay.zzm zzb;
    private String zzc;
    private String zzd;

    @Override // com.google.android.gms.internal.ads.zzeks
    public final zzeks zza(Activity activity) {
        if (activity != null) {
            this.zza = activity;
            return this;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Null activity");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzeks
    public final zzeks zzb(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzb = zzmVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeks
    public final zzeks zzc(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeks
    public final zzeks zzd(String str) {
        this.zzd = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeks
    public final zzekt zze() {
        Activity activity = this.zza;
        if (activity != null) {
            return new zzejx(activity, this.zzb, this.zzc, this.zzd, null);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Missing required properties: activity");
        return null;
    }
}
