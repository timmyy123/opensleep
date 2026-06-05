package com.google.android.gms.internal.serialization;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzabg {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzabr zzb;

    static {
        int i = zzaba.$r8$clinit;
        zzb = new zzabt();
    }

    public static int zzA(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzxb.zzD(i << 3) + 4) * size;
    }

    public static int zzB(List list) {
        return list.size() * 8;
    }

    public static int zzC(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzxb.zzD(i << 3) + 8) * size;
    }

    public static int zzD(int i, Object obj, zzabe zzabeVar) {
        return zzxb.zzH((zzaaq) obj, zzabeVar) + zzxb.zzD(i << 3);
    }

    public static zzabr zzE() {
        return zzb;
    }

    public static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzG(zzyq zzyqVar, Object obj, Object obj2) {
        zzyu<zzzd> zzyuVar = ((zzzc) obj2).extensions;
        if (zzyuVar.zza.isEmpty()) {
            return;
        }
        ((zzzc) obj).ensureExtensionsAreMutable().zzl(zzyuVar);
    }

    public static void zzH(zzabr zzabrVar, Object obj, Object obj2) {
        zzzg zzzgVar = (zzzg) obj;
        zzabs zzabsVarZzc = zzzgVar.unknownFields;
        zzabs zzabsVar = ((zzzg) obj2).unknownFields;
        if (!zzabs.zza().equals(zzabsVar)) {
            if (zzabs.zza().equals(zzabsVarZzc)) {
                zzabsVarZzc = zzabs.zzc(zzabsVarZzc, zzabsVar);
            } else {
                zzabsVarZzc.zzm(zzabsVar);
            }
        }
        zzzgVar.unknownFields = zzabsVarZzc;
    }

    public static Object zzI(Object obj, int i, List list, zzzl zzzlVar, Object obj2, zzabr zzabrVar) {
        if (zzzlVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (zzzlVar.findValueByNumber(iIntValue) == null) {
                    obj2 = zzK(obj, i, iIntValue, obj2, zzabrVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Integer num = (Integer) list.get(i3);
            int iIntValue2 = num.intValue();
            if (zzzlVar.findValueByNumber(iIntValue2) != null) {
                if (i3 != i2) {
                    list.set(i2, num);
                }
                i2++;
            } else {
                obj2 = zzK(obj, i, iIntValue2, obj2, zzabrVar);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return obj2;
    }

    public static Object zzJ(Object obj, int i, List list, zzzm zzzmVar, Object obj2, zzabr zzabrVar) {
        if (zzzmVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzzmVar.isInRange(iIntValue)) {
                    obj2 = zzK(obj, i, iIntValue, obj2, zzabrVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Integer num = (Integer) list.get(i3);
            int iIntValue2 = num.intValue();
            if (zzzmVar.isInRange(iIntValue2)) {
                if (i3 != i2) {
                    list.set(i2, num);
                }
                i2++;
            } else {
                obj2 = zzK(obj, i, iIntValue2, obj2, zzabrVar);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return obj2;
    }

    public static Object zzK(Object obj, int i, int i2, Object obj2, zzabr zzabrVar) {
        if (obj2 == null) {
            obj2 = zzabrVar.zzh(obj);
        }
        zzabrVar.zza(obj2, i, i2);
        return obj2;
    }

    public static void zza(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzC(i, list, z);
    }

    public static void zzb(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzB(i, list, z);
    }

    public static void zzc(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzy(i, list, z);
    }

    public static void zzd(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzz(i, list, z);
    }

    public static void zze(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzL(i, list, z);
    }

    public static void zzf(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzA(i, list, z);
    }

    public static void zzg(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzJ(i, list, z);
    }

    public static void zzh(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzw(i, list, z);
    }

    public static void zzi(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzH(i, list, z);
    }

    public static void zzj(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzK(i, list, z);
    }

    public static void zzk(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzx(i, list, z);
    }

    public static void zzl(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzI(i, list, z);
    }

    public static void zzm(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzD(i, list, z);
    }

    public static void zzn(int i, List list, zzach zzachVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzE(i, list, z);
    }

    public static void zzo(int i, List list, zzach zzachVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzF(i, list);
    }

    public static void zzp(int i, List list, zzach zzachVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzachVar.zzG(i, list);
    }

    public static void zzq(int i, List list, zzach zzachVar, zzabe zzabeVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzxc) zzachVar).zzr(i, list.get(i2), zzabeVar);
        }
    }

    public static void zzr(int i, List list, zzach zzachVar, zzabe zzabeVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzxc) zzachVar).zzs(i, list.get(i2), zzabeVar);
        }
    }

    public static int zzs(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzaae)) {
            int iZzE = 0;
            while (i < size) {
                iZzE += zzxb.zzE(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzE;
        }
        zzaae zzaaeVar = (zzaae) list;
        int iZzE2 = 0;
        while (i < size) {
            iZzE2 += zzxb.zzE(zzaaeVar.zzc(i));
            i++;
        }
        return iZzE2;
    }

    public static int zzt(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzaae)) {
            int iZzE = 0;
            while (i < size) {
                iZzE += zzxb.zzE(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzE;
        }
        zzaae zzaaeVar = (zzaae) list;
        int iZzE2 = 0;
        while (i < size) {
            iZzE2 += zzxb.zzE(zzaaeVar.zzc(i));
            i++;
        }
        return iZzE2;
    }

    public static int zzu(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzaae)) {
            int iZzE = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzE += zzxb.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZzE;
        }
        zzaae zzaaeVar = (zzaae) list;
        int iZzE2 = 0;
        while (i < size) {
            long jZzc = zzaaeVar.zzc(i);
            iZzE2 += zzxb.zzE((jZzc >> 63) ^ (jZzc + jZzc));
            i++;
        }
        return iZzE2;
    }

    public static int zzv(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzzh)) {
            int iZzE = 0;
            while (i < size) {
                iZzE += zzxb.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzE;
        }
        zzzh zzzhVar = (zzzh) list;
        int iZzE2 = 0;
        while (i < size) {
            iZzE2 += zzxb.zzE(zzzhVar.zzf(i));
            i++;
        }
        return iZzE2;
    }

    public static int zzw(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzzh)) {
            int iZzE = 0;
            while (i < size) {
                iZzE += zzxb.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzE;
        }
        zzzh zzzhVar = (zzzh) list;
        int iZzE2 = 0;
        while (i < size) {
            iZzE2 += zzxb.zzE(zzzhVar.zzf(i));
            i++;
        }
        return iZzE2;
    }

    public static int zzx(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzzh)) {
            int iZzD = 0;
            while (i < size) {
                iZzD += zzxb.zzD(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzD;
        }
        zzzh zzzhVar = (zzzh) list;
        int iZzD2 = 0;
        while (i < size) {
            iZzD2 += zzxb.zzD(zzzhVar.zzf(i));
            i++;
        }
        return iZzD2;
    }

    public static int zzy(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzzh)) {
            int iZzD = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzD += zzxb.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzD;
        }
        zzzh zzzhVar = (zzzh) list;
        int iZzD2 = 0;
        while (i < size) {
            int iZzf = zzzhVar.zzf(i);
            iZzD2 += zzxb.zzD((iZzf >> 31) ^ (iZzf + iZzf));
            i++;
        }
        return iZzD2;
    }

    public static int zzz(List list) {
        return list.size() * 4;
    }
}
