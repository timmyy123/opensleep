package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzifb {
    public static final List zza(Object obj, long j) {
        zzieq zzieqVar = (zzieq) zziha.zzm(obj, j);
        if (zzieqVar.zza()) {
            return zzieqVar;
        }
        int size = zzieqVar.size();
        zzieq zzieqVarZzh = zzieqVar.zzh(size == 0 ? 10 : size + size);
        zziha.zzn(obj, j, zzieqVarZzh);
        return zzieqVarZzh;
    }
}
