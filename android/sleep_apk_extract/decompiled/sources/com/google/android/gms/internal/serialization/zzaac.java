package com.google.android.gms.internal.serialization;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzaac {
    public static final List zza(Object obj, long j) {
        zzzs zzzsVar = (zzzs) zzaby.zzn(obj, j);
        if (zzzsVar.zza()) {
            return zzzsVar;
        }
        int size = zzzsVar.size();
        zzzs zzzsVarZzh = zzzsVar.zzh(size == 0 ? 10 : size + size);
        zzaby.zzo(obj, j, zzzsVarZzh);
        return zzzsVarZzh;
    }
}
