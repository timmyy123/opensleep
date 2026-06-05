package com.google.android.gms.measurement.internal;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzos extends zzol {
    private boolean zza;

    public zzos(zzpg zzpgVar) {
        super(zzpgVar);
        this.zzg.zzaf();
    }

    public final boolean zzax() {
        return this.zza;
    }

    public final void zzay() {
        if (zzax()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Not initialized");
    }

    public final void zzaz() {
        if (this.zza) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Can't initialize twice");
            return;
        }
        zzbc();
        this.zzg.zzag();
        this.zza = true;
    }

    public abstract boolean zzbc();
}
