package com.google.android.gms.internal.serialization;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzaag implements zzaao {
    private final zzaao[] zza;

    public zzaag(zzaao... zzaaoVarArr) {
        this.zza = zzaaoVarArr;
    }

    @Override // com.google.android.gms.internal.serialization.zzaao
    public final boolean zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.serialization.zzaao
    public final zzaan zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzaao zzaaoVar = this.zza[i];
            if (zzaaoVar.zzb(cls)) {
                return zzaaoVar.zzc(cls);
            }
        }
        Utf8$$ExternalSyntheticBUOutline0.m("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }
}
