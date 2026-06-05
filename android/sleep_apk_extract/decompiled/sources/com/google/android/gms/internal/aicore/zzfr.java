package com.google.android.gms.internal.aicore;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzfr implements zzfy {
    private final zzfy[] zza;

    public zzfr(zzfy... zzfyVarArr) {
        this.zza = zzfyVarArr;
    }

    @Override // com.google.android.gms.internal.aicore.zzfy
    public final boolean zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.aicore.zzfy
    public final zzfx zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzfy zzfyVar = this.zza[i];
            if (zzfyVar.zzb(cls)) {
                return zzfyVar.zzc(cls);
            }
        }
        Utf8$$ExternalSyntheticBUOutline0.m("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }
}
