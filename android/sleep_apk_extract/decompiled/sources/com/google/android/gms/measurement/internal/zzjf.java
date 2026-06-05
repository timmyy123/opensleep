package com.google.android.gms.measurement.internal;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzjf extends zzje {
    private boolean zza;

    public zzjf(zzic zzicVar) {
        super(zzicVar);
        this.zzu.zzF();
    }

    public abstract boolean zza();

    public void zzbb() {
    }

    public final boolean zzv() {
        return this.zza;
    }

    public final void zzw() {
        if (zzv()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Not initialized");
    }

    public final void zzx() {
        if (this.zza) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Can't initialize twice");
        } else {
            if (zza()) {
                return;
            }
            this.zzu.zzG();
            this.zza = true;
        }
    }

    public final void zzy() {
        if (this.zza) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Can't initialize twice");
            return;
        }
        zzbb();
        this.zzu.zzG();
        this.zza = true;
    }
}
