package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzaeo {
    public static final List zza(Object obj, long j) {
        zzaef zzaefVar = (zzaef) zzagg.zzm(obj, j);
        if (zzaefVar.zza()) {
            return zzaefVar;
        }
        int size = zzaefVar.size();
        zzaef zzaefVarZzg = zzaefVar.zzg(size == 0 ? 10 : size + size);
        zzagg.zzn(obj, j, zzaefVarZzg);
        return zzaefVarZzg;
    }
}
