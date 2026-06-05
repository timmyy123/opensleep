package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
final class zzaal {
    public static final boolean zza(Object obj) {
        return !((zzaak) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzaak zzaakVarZzc = (zzaak) obj;
        zzaak zzaakVar = (zzaak) obj2;
        if (!zzaakVar.isEmpty()) {
            if (!zzaakVarZzc.zze()) {
                zzaakVarZzc = zzaakVarZzc.zzc();
            }
            zzaakVarZzc.zzb(zzaakVar);
        }
        return zzaakVarZzc;
    }
}
