package com.google.android.gms.internal.ads;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzqz {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private int zzd = 0;

    public final zzqz zza(boolean z) {
        this.zza = z;
        return this;
    }

    public final zzqz zzb(boolean z) {
        this.zzb = z;
        return this;
    }

    public final zzqz zzc(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzqz zzd(int i) {
        this.zzd = i;
        return this;
    }

    public final zzra zze() {
        if (this.zza || !(this.zzb || this.zzc)) {
            return new zzra(this, null);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Secondary offload attribute fields are true but primary isFormatSupportedForOffload is false");
        return null;
    }

    public final /* synthetic */ boolean zzf() {
        return this.zza;
    }

    public final /* synthetic */ boolean zzg() {
        return this.zzb;
    }

    public final /* synthetic */ boolean zzh() {
        return this.zzc;
    }

    public final /* synthetic */ int zzi() {
        return this.zzd;
    }
}
