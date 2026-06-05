package com.google.android.gms.internal.aicore;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzgm {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzgv zzb;

    static {
        int i = zzgh.$r8$clinit;
        zzb = new zzgx();
    }

    public static zzgv zza() {
        return zzb;
    }

    public static boolean zzb(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzc(zzel zzelVar, Object obj, Object obj2) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj2);
    }

    public static void zzd(zzgv zzgvVar, Object obj, Object obj2) {
        zzex zzexVar = (zzex) obj;
        zzgw zzgwVarZzc = zzexVar.zzc;
        zzgw zzgwVar = ((zzex) obj2).zzc;
        if (!zzgw.zza().equals(zzgwVar)) {
            if (zzgw.zza().equals(zzgwVarZzc)) {
                zzgwVarZzc = zzgw.zzc(zzgwVarZzc, zzgwVar);
            } else {
                zzgwVarZzc.zzh(zzgwVar);
            }
        }
        zzexVar.zzc = zzgwVarZzc;
    }
}
