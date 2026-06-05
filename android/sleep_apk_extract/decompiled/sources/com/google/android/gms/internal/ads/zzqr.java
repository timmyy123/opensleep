package com.google.android.gms.internal.ads;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzqr {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;

    public final zzqr zza(boolean z) {
        this.zza = z;
        return this;
    }

    public final zzqr zzb(boolean z) {
        this.zzb = z;
        return this;
    }

    public final zzqr zzc(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzqs zzd() {
        if (this.zza || !(this.zzb || this.zzc)) {
            return new zzqs(this, null);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Secondary offload attribute fields are true but primary isFormatSupported is false");
        return null;
    }

    public final /* synthetic */ boolean zze() {
        return this.zza;
    }

    public final /* synthetic */ boolean zzf() {
        return this.zzb;
    }

    public final /* synthetic */ boolean zzg() {
        return this.zzc;
    }
}
