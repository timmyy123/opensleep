package com.google.android.gms.measurement.internal;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzg extends zzf {
    private boolean zza;

    public zzg(zzic zzicVar) {
        super(zzicVar);
        this.zzu.zzF();
    }

    public final boolean zza() {
        return this.zza;
    }

    public final void zzb() {
        if (zza()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Not initialized");
    }

    public final void zzc() {
        if (this.zza) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Can't initialize twice");
        } else {
            if (zze()) {
                return;
            }
            this.zzu.zzG();
            this.zza = true;
        }
    }

    public final void zzd() {
        if (this.zza) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Can't initialize twice");
            return;
        }
        zzf();
        this.zzu.zzG();
        this.zza = true;
    }

    public abstract boolean zze();

    public void zzf() {
    }
}
