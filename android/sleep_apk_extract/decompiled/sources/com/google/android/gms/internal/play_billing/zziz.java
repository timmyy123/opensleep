package com.google.android.gms.internal.play_billing;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class zziz {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzjj zzb;

    static {
        int i = zziu.$r8$clinit;
        zzb = new zzjl();
    }

    public static void zzA(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzC(i, list, z);
    }

    public static void zzB(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzE(i, list, z);
    }

    public static void zzC(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzJ(i, list, z);
    }

    public static void zzD(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzL(i, list, z);
    }

    public static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhl)) {
            int iZzA = 0;
            while (i < size) {
                iZzA += zzgr.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzA;
        }
        zzhl zzhlVar = (zzhl) list;
        int iZzA2 = 0;
        while (i < size) {
            iZzA2 += zzgr.zzA(zzhlVar.zze(i));
            i++;
        }
        return iZzA2;
    }

    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgr.zzz(i << 3) + 4) * size;
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgr.zzz(i << 3) + 8) * size;
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhl)) {
            int iZzA = 0;
            while (i < size) {
                iZzA += zzgr.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzA;
        }
        zzhl zzhlVar = (zzhl) list;
        int iZzA2 = 0;
        while (i < size) {
            iZzA2 += zzgr.zzA(zzhlVar.zze(i));
            i++;
        }
        return iZzA2;
    }

    public static int zzg(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzib) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZzA = 0;
        for (int i = 0; i < size; i++) {
            iZzA += zzgr.zzA(((Long) list.get(i)).longValue());
        }
        return iZzA;
    }

    public static int zzh(int i, Object obj, zzix zzixVar) {
        return zzgr.zzx((zzim) obj, zzixVar) + zzgr.zzz(i << 3);
    }

    public static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhl)) {
            int iZzz = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzz += zzgr.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzz;
        }
        zzhl zzhlVar = (zzhl) list;
        int iZzz2 = 0;
        while (i < size) {
            int iZze = zzhlVar.zze(i);
            iZzz2 += zzgr.zzz((iZze >> 31) ^ (iZze + iZze));
            i++;
        }
        return iZzz2;
    }

    public static int zzj(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzib) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZzA = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iZzA += zzgr.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
        }
        return iZzA;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhl)) {
            int iZzz = 0;
            while (i < size) {
                iZzz += zzgr.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzz;
        }
        zzhl zzhlVar = (zzhl) list;
        int iZzz2 = 0;
        while (i < size) {
            iZzz2 += zzgr.zzz(zzhlVar.zze(i));
            i++;
        }
        return iZzz2;
    }

    public static int zzl(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzib) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZzA = 0;
        for (int i = 0; i < size; i++) {
            iZzA += zzgr.zzA(((Long) list.get(i)).longValue());
        }
        return iZzA;
    }

    public static zzjj zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i, int i2, Object obj2, zzjj zzjjVar) {
        Object obj3 = obj2;
        if (obj2 == null) {
            zzhk zzhkVar = (zzhk) obj;
            zzjk zzjkVar = zzhkVar.zzc;
            obj3 = zzjkVar;
            if (zzjkVar == zzjk.zzc()) {
                zzjk zzjkVarZzf = zzjk.zzf();
                zzhkVar.zzc = zzjkVarZzf;
                obj3 = zzjkVarZzf;
            }
        }
        ((zzjk) obj3).zzj(i << 3, Long.valueOf(i2));
        return obj3;
    }

    public static void zzo(zzgx zzgxVar, Object obj, Object obj2) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj2);
    }

    public static void zzp(zzjj zzjjVar, Object obj, Object obj2) {
        zzhk zzhkVar = (zzhk) obj;
        zzjk zzjkVarZze = zzhkVar.zzc;
        zzjk zzjkVar = ((zzhk) obj2).zzc;
        if (!zzjk.zzc().equals(zzjkVar)) {
            if (zzjk.zzc().equals(zzjkVarZze)) {
                zzjkVarZze = zzjk.zze(zzjkVarZze, zzjkVar);
            } else {
                zzjkVarZze.zzd(zzjkVar);
            }
        }
        zzhkVar.zzc = zzjkVarZze;
    }

    public static void zzq(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzg(i, list, z);
    }

    public static void zzs(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzj(i, list, z);
    }

    public static void zzt(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzl(i, list, z);
    }

    public static void zzu(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzn(i, list, z);
    }

    public static void zzv(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzp(i, list, z);
    }

    public static void zzw(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzs(i, list, z);
    }

    public static void zzx(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzu(i, list, z);
    }

    public static void zzy(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzy(i, list, z);
    }

    public static void zzz(int i, List list, zzjw zzjwVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzA(i, list, z);
    }
}
