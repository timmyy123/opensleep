package com.google.android.gms.internal.vision;

/* JADX INFO: loaded from: classes4.dex */
final class zzkd implements zzkl {
    private zzkl[] zza;

    public zzkd(zzkl... zzklVarArr) {
        this.zza = zzklVarArr;
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final boolean zza(Class<?> cls) {
        for (zzkl zzklVar : this.zza) {
            if (zzklVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final zzki zzb(Class<?> cls) {
        for (zzkl zzklVar : this.zza) {
            if (zzklVar.zza(cls)) {
                return zzklVar.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
