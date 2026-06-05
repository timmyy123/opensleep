package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzaik extends zzaim {
    private long zzb;
    private long[] zzc;
    private long[] zzd;

    public zzaik() {
        super(new zzafv());
        this.zzb = -9223372036854775807L;
        this.zzc = new long[0];
        this.zzd = new long[0];
    }

    private static Double zzg(zzet zzetVar) {
        return Double.valueOf(Double.longBitsToDouble(zzetVar.zzD()));
    }

    private static String zzh(zzet zzetVar) {
        int iZzt = zzetVar.zzt();
        int iZzg = zzetVar.zzg();
        zzetVar.zzk(iZzt);
        return new String(zzetVar.zzi(), iZzg, iZzt);
    }

    private static HashMap zzi(zzet zzetVar) {
        int iZzH = zzetVar.zzH();
        HashMap map = new HashMap(iZzH);
        for (int i = 0; i < iZzH; i++) {
            String strZzh = zzh(zzetVar);
            Object objZzj = zzj(zzetVar, zzetVar.zzs());
            if (objZzj != null) {
                map.put(strZzh, objZzj);
            }
        }
        return map;
    }

    private static Object zzj(zzet zzetVar, int i) {
        if (i == 0) {
            return zzg(zzetVar);
        }
        if (i == 1) {
            return Boolean.valueOf(zzetVar.zzs() == 1);
        }
        if (i == 2) {
            return zzh(zzetVar);
        }
        if (i != 3) {
            if (i == 8) {
                return zzi(zzetVar);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) zzg(zzetVar).doubleValue());
                zzetVar.zzk(2);
                return date;
            }
            int iZzH = zzetVar.zzH();
            ArrayList arrayList = new ArrayList(iZzH);
            for (int i2 = 0; i2 < iZzH; i2++) {
                Object objZzj = zzj(zzetVar, zzetVar.zzs());
                if (objZzj != null) {
                    arrayList.add(objZzj);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strZzh = zzh(zzetVar);
            int iZzs = zzetVar.zzs();
            if (iZzs == 9) {
                return map;
            }
            Object objZzj2 = zzj(zzetVar, iZzs);
            if (objZzj2 != null) {
                map.put(strZzh, objZzj2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    public final boolean zza(zzet zzetVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    public final boolean zzb(zzet zzetVar, long j) {
        if (zzetVar.zzs() == 2 && "onMetaData".equals(zzh(zzetVar)) && zzetVar.zzd() != 0 && zzetVar.zzs() == 8) {
            HashMap mapZzi = zzi(zzetVar);
            Object obj = mapZzi.get("duration");
            if (obj instanceof Double) {
                double dDoubleValue = ((Double) obj).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.zzb = (long) (dDoubleValue * 1000000.0d);
                }
            }
            Object obj2 = mapZzi.get("keyframes");
            if (obj2 instanceof Map) {
                Map map = (Map) obj2;
                Object obj3 = map.get("filepositions");
                Object obj4 = map.get("times");
                if ((obj3 instanceof List) && (obj4 instanceof List)) {
                    List list = (List) obj3;
                    List list2 = (List) obj4;
                    int size = list2.size();
                    this.zzc = new long[size];
                    this.zzd = new long[size];
                    for (int i = 0; i < size; i++) {
                        Object obj5 = list.get(i);
                        Object obj6 = list2.get(i);
                        if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                            this.zzc = new long[0];
                            this.zzd = new long[0];
                            break;
                        }
                        this.zzc[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.zzd[i] = ((Double) obj5).longValue();
                    }
                }
            }
        }
        return false;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzc;
    }

    public final long[] zze() {
        return this.zzd;
    }
}
