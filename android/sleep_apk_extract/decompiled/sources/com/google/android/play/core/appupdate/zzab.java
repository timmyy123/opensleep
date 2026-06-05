package com.google.android.play.core.appupdate;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzab {
    private zzi zza;

    public /* synthetic */ zzab(zzaa zzaaVar) {
    }

    public final zza zza() {
        zzi zziVar = this.zza;
        zzy zzyVar = null;
        if (zziVar != null) {
            return new zzz(zziVar, zzyVar);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(String.valueOf(zzi.class.getCanonicalName()).concat(" must be set"));
        return null;
    }

    public final zzab zzb(zzi zziVar) {
        this.zza = zziVar;
        return this;
    }

    private zzab() {
    }
}
