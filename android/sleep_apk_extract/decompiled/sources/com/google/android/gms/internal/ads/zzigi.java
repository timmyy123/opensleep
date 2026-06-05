package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzigi {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzigt zzb;

    static {
        int i = zzicn.$r8$clinit;
        zzb = new zzigv();
    }

    public static int zzA(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzidj.zzF(i << 3) + 4) * size;
    }

    public static int zzB(List list) {
        return list.size() * 8;
    }

    public static int zzC(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzidj.zzF(i << 3) + 8) * size;
    }

    public static int zzD(int i, Object obj, zzigh zzighVar) {
        int iZzF = zzidj.zzF(i << 3);
        int iZzaT = ((zzicj) obj).zzaT(zzighVar);
        return zzba$$ExternalSyntheticOutline0.m(iZzaT, iZzaT, iZzF);
    }

    @Deprecated
    public static int zzE(int i, zzifp zzifpVar, zzigh zzighVar) {
        int iZzF = zzidj.zzF(i << 3);
        return ((zzicj) zzifpVar).zzaT(zzighVar) + iZzF + iZzF;
    }

    public static zzigt zzF() {
        return zzb;
    }

    public static boolean zzG(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzH(zzidp zzidpVar, Object obj, Object obj2) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj2);
    }

    public static void zzI(zzigt zzigtVar, Object obj, Object obj2) {
        zziee zzieeVar = (zziee) obj;
        zzigu zziguVarZzc = zzieeVar.zzt;
        zzigu zziguVar = ((zziee) obj2).zzt;
        if (!zzigu.zza().equals(zziguVar)) {
            if (zzigu.zza().equals(zziguVarZzc)) {
                zziguVarZzc = zzigu.zzc(zziguVarZzc, zziguVar);
            } else {
                zziguVarZzc.zzm(zziguVar);
            }
        }
        zzieeVar.zzt = zziguVarZzc;
    }

    public static Object zzJ(Object obj, int i, List list, zziek zziekVar, Object obj2, zzigt zzigtVar) {
        if (zziekVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zziekVar.zza(iIntValue)) {
                    obj2 = zzK(obj, i, iIntValue, obj2, zzigtVar);
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
            if (zziekVar.zza(iIntValue2)) {
                if (i3 != i2) {
                    list.set(i2, num);
                }
                i2++;
            } else {
                obj2 = zzK(obj, i, iIntValue2, obj2, zzigtVar);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return obj2;
    }

    public static Object zzK(Object obj, int i, int i2, Object obj2, zzigt zzigtVar) {
        if (obj2 == null) {
            obj2 = zzigtVar.zzh(obj);
        }
        zzigtVar.zza(obj2, i, i2);
        return obj2;
    }

    public static void zza(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzC(i, list, z);
    }

    public static void zzb(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzB(i, list, z);
    }

    public static void zzc(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzy(i, list, z);
    }

    public static void zzd(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzz(i, list, z);
    }

    public static void zze(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzL(i, list, z);
    }

    public static void zzf(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzA(i, list, z);
    }

    public static void zzg(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzJ(i, list, z);
    }

    public static void zzh(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzw(i, list, z);
    }

    public static void zzi(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzH(i, list, z);
    }

    public static void zzj(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzK(i, list, z);
    }

    public static void zzk(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzx(i, list, z);
    }

    public static void zzl(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzI(i, list, z);
    }

    public static void zzm(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzD(i, list, z);
    }

    public static void zzn(int i, List list, zzihi zzihiVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzE(i, list, z);
    }

    public static void zzo(int i, List list, zzihi zzihiVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzF(i, list);
    }

    public static void zzp(int i, List list, zzihi zzihiVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzG(i, list);
    }

    public static void zzq(int i, List list, zzihi zzihiVar, zzigh zzighVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzidk) zzihiVar).zzr(i, list.get(i2), zzighVar);
        }
    }

    public static void zzr(int i, List list, zzihi zzihiVar, zzigh zzighVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzidk) zzihiVar).zzs(i, list.get(i2), zzighVar);
        }
    }

    public static int zzs(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzifd)) {
            int iZzG = 0;
            while (i < size) {
                iZzG += zzidj.zzG(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzG;
        }
        zzifd zzifdVar = (zzifd) list;
        int iZzG2 = 0;
        while (i < size) {
            iZzG2 += zzidj.zzG(zzifdVar.zzc(i));
            i++;
        }
        return iZzG2;
    }

    public static int zzt(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzifd)) {
            int iZzG = 0;
            while (i < size) {
                iZzG += zzidj.zzG(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzG;
        }
        zzifd zzifdVar = (zzifd) list;
        int iZzG2 = 0;
        while (i < size) {
            iZzG2 += zzidj.zzG(zzifdVar.zzc(i));
            i++;
        }
        return iZzG2;
    }

    public static int zzu(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzifd)) {
            int iZzG = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzG += zzidj.zzG((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZzG;
        }
        zzifd zzifdVar = (zzifd) list;
        int iZzG2 = 0;
        while (i < size) {
            long jZzc = zzifdVar.zzc(i);
            iZzG2 += zzidj.zzG((jZzc >> 63) ^ (jZzc + jZzc));
            i++;
        }
        return iZzG2;
    }

    public static int zzv(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzief)) {
            int iZzG = 0;
            while (i < size) {
                iZzG += zzidj.zzG(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzG;
        }
        zzief zziefVar = (zzief) list;
        int iZzG2 = 0;
        while (i < size) {
            iZzG2 += zzidj.zzG(zziefVar.zzf(i));
            i++;
        }
        return iZzG2;
    }

    public static int zzw(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzief)) {
            int iZzG = 0;
            while (i < size) {
                iZzG += zzidj.zzG(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzG;
        }
        zzief zziefVar = (zzief) list;
        int iZzG2 = 0;
        while (i < size) {
            iZzG2 += zzidj.zzG(zziefVar.zzf(i));
            i++;
        }
        return iZzG2;
    }

    public static int zzx(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzief)) {
            int iZzF = 0;
            while (i < size) {
                iZzF += zzidj.zzF(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzF;
        }
        zzief zziefVar = (zzief) list;
        int iZzF2 = 0;
        while (i < size) {
            iZzF2 += zzidj.zzF(zziefVar.zzf(i));
            i++;
        }
        return iZzF2;
    }

    public static int zzy(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzief)) {
            int iZzF = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzF += zzidj.zzF((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzF;
        }
        zzief zziefVar = (zzief) list;
        int iZzF2 = 0;
        while (i < size) {
            int iZzf = zziefVar.zzf(i);
            iZzF2 += zzidj.zzF((iZzf >> 31) ^ (iZzf + iZzf));
            i++;
        }
        return iZzF2;
    }

    public static int zzz(List list) {
        return list.size() * 4;
    }
}
