package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzahn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
final class zzad extends zzos {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    public zzad(zzpg zzpgVar) {
        super(zzpgVar);
    }

    private final zzy zzc(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzy) this.zzc.get(num);
        }
        zzy zzyVar = new zzy(this, this.zza, null);
        this.zzc.put(num, zzyVar);
        return zzyVar;
    }

    private final boolean zzd(int i, int i2) {
        zzy zzyVar = (zzy) this.zzc.get(Integer.valueOf(i));
        if (zzyVar == null) {
            return false;
        }
        return zzyVar.zzc().get(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:405:0x096b, code lost:
    
        r0 = r13.zzaW().zze();
        r2 = com.google.android.gms.measurement.internal.zzgu.zzl(r34.zza);
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x097d, code lost:
    
        if (r12.zza() == false) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x097f, code lost:
    
        r3 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x0988, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0989, code lost:
    
        r0.zzc("Invalid property filter ID. appId, id", r2, java.lang.String.valueOf(r3));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x06d6  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x06ee  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x077d  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0856 A[PHI: r0 r13 r36
      0x0856: PHI (r0v120 java.util.Map) = (r0v122 java.util.Map), (r0v128 java.util.Map) binds: [B:370:0x087a, B:360:0x0854] A[DONT_GENERATE, DONT_INLINE]
      0x0856: PHI (r13v4 android.database.Cursor) = (r13v5 android.database.Cursor), (r13v6 android.database.Cursor) binds: [B:370:0x087a, B:360:0x0854] A[DONT_GENERATE, DONT_INLINE]
      0x0856: PHI (r36v4 java.util.Iterator) = (r36v5 java.util.Iterator), (r36v9 java.util.Iterator) binds: [B:370:0x087a, B:360:0x0854] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0a4a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a2 A[Catch: all -> 0x01b0, SQLiteException -> 0x01b3, TRY_LEAVE, TryCatch #14 {all -> 0x01b0, blocks: (B:59:0x019c, B:61:0x01a2, B:69:0x01bc, B:70:0x01c1, B:71:0x01cb, B:72:0x01db, B:81:0x0207, B:74:0x01ea, B:78:0x01fa, B:80:0x0200, B:98:0x0230), top: B:454:0x019c }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01bc A[Catch: all -> 0x01b0, SQLiteException -> 0x01b3, TRY_ENTER, TryCatch #14 {all -> 0x01b0, blocks: (B:59:0x019c, B:61:0x01a2, B:69:0x01bc, B:70:0x01c1, B:71:0x01cb, B:72:0x01db, B:81:0x0207, B:74:0x01ea, B:78:0x01fa, B:80:0x0200, B:98:0x0230), top: B:454:0x019c }] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzb(String str, List list, List list2, Long l, Long l2, boolean z) throws Throwable {
        int i;
        int i2;
        boolean z2;
        Map map;
        zzaw zzawVarZzj;
        String str2;
        Cursor cursor;
        boolean z3;
        String str3;
        String str4;
        Cursor cursorQuery;
        Map map2;
        HashSet<Integer> hashSet;
        Map map3;
        List list3;
        boolean z4;
        ?? r5;
        Cursor cursorRawQuery;
        Map map4;
        HashSet hashSet2;
        Iterator it;
        Iterator it2;
        Map map5;
        String str5;
        ArrayMap arrayMap;
        Cursor cursor2;
        String str6;
        Cursor cursorQuery2;
        List arrayList;
        zzz zzzVar;
        Iterator it3;
        zzbd zzbdVar;
        Iterator it4;
        Map map6;
        Iterator it5;
        long j;
        String str7;
        Cursor cursor3;
        Cursor cursor4;
        List arrayList2;
        Cursor cursorQuery3;
        List arrayList3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator it6 = list.iterator();
        while (true) {
            i = 0;
            i2 = 1;
            if (!it6.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it6.next()).zzd())) {
                z2 = true;
                break;
            }
        }
        zzahn.zza();
        zzic zzicVar = this.zzu;
        boolean zZzp = zzicVar.zzc().zzp(this.zza, zzfy.zzaF);
        zzahn.zza();
        boolean zZzp2 = zzicVar.zzc().zzp(this.zza, zzfy.zzaE);
        if (z2) {
            zzaw zzawVarZzj2 = this.zzg.zzj();
            String str8 = this.zza;
            zzawVarZzj2.zzay();
            zzawVarZzj2.zzg();
            Preconditions.checkNotEmpty(str8);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                zzawVarZzj2.zze().update("events", contentValues, "app_id = ?", new String[]{str8});
            } catch (SQLiteException e) {
                zzawVarZzj2.zzu.zzaW().zzb().zzc("Error resetting session-scoped event counts. appId", zzgu.zzl(str8), e);
            }
        }
        Map map7 = Collections.EMPTY_MAP;
        String str9 = "data";
        String str10 = "audience_id";
        if (zZzp2 && zZzp) {
            zzaw zzawVarZzj3 = this.zzg.zzj();
            String str11 = this.zza;
            Preconditions.checkNotEmpty(str11);
            ArrayMap arrayMap2 = new ArrayMap();
            try {
                cursorQuery3 = zzawVarZzj3.zze().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str11}, null, null, null);
                try {
                    try {
                        if (cursorQuery3.moveToFirst()) {
                            while (true) {
                                try {
                                    com.google.android.gms.internal.measurement.zzff zzffVar = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), cursorQuery3.getBlob(i2))).zzbd();
                                    if (zzffVar.zzh()) {
                                        Integer numValueOf = Integer.valueOf(cursorQuery3.getInt(i));
                                        List list4 = (List) arrayMap2.get(numValueOf);
                                        if (list4 == null) {
                                            arrayList3 = new ArrayList();
                                            arrayMap2.put(numValueOf, arrayList3);
                                        } else {
                                            arrayList3 = list4;
                                        }
                                        arrayList3.add(zzffVar);
                                    }
                                } catch (IOException e2) {
                                    zzawVarZzj3.zzu.zzaW().zzb().zzc("Failed to merge filter. appId", zzgu.zzl(str11), e2);
                                }
                                if (!cursorQuery3.moveToNext()) {
                                    break;
                                }
                                i = 0;
                                i2 = 1;
                            }
                            cursorQuery3.close();
                            map = arrayMap2;
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        zzawVarZzj3.zzu.zzaW().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str11), e);
                        map7 = Collections.EMPTY_MAP;
                        if (cursorQuery3 != null) {
                        }
                        map = map7;
                        zzawVarZzj = this.zzg.zzj();
                        str2 = this.zza;
                        zzawVarZzj.zzay();
                        zzawVarZzj.zzg();
                        Preconditions.checkNotEmpty(str2);
                        cursorQuery = zzawVarZzj.zze().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str2}, null, null, null);
                        try {
                            try {
                                if (cursorQuery.moveToFirst()) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursorQuery;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e4) {
                            e = e4;
                            z3 = z2;
                            str3 = "data";
                        }
                        if (!map2.isEmpty()) {
                        }
                        String str12 = str3;
                        String str13 = str4;
                        String str14 = "Skipping failed audience ID";
                        if (!list.isEmpty()) {
                        }
                        if (z) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery3 != null) {
                        cursorQuery3.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e5) {
                e = e5;
                cursorQuery3 = null;
            } catch (Throwable th3) {
                th = th3;
                cursorQuery3 = null;
                if (cursorQuery3 != null) {
                }
                throw th;
            }
            cursorQuery3.close();
            map = map7;
        } else {
            map = map7;
        }
        zzawVarZzj = this.zzg.zzj();
        str2 = this.zza;
        zzawVarZzj.zzay();
        zzawVarZzj.zzg();
        Preconditions.checkNotEmpty(str2);
        try {
            cursorQuery = zzawVarZzj.zze().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str2}, null, null, null);
            if (cursorQuery.moveToFirst()) {
                Map map8 = Collections.EMPTY_MAP;
                cursorQuery.close();
                map2 = map8;
                z3 = z2;
                str3 = "data";
                str4 = "audience_id";
            } else {
                ArrayMap arrayMap3 = new ArrayMap();
                while (true) {
                    int i3 = cursorQuery.getInt(0);
                    try {
                        arrayMap3.put(Integer.valueOf(i3), (com.google.android.gms.internal.measurement.zzii) ((com.google.android.gms.internal.measurement.zzih) zzpk.zzw(com.google.android.gms.internal.measurement.zzii.zzj(), cursorQuery.getBlob(1))).zzbd());
                        z3 = z2;
                        str3 = str9;
                        str4 = str10;
                    } catch (IOException e6) {
                        z3 = z2;
                        str3 = str9;
                        try {
                            str4 = str10;
                            try {
                                zzawVarZzj.zzu.zzaW().zzb().zzd("Failed to merge filter results. appId, audienceId, error", zzgu.zzl(str2), Integer.valueOf(i3), e6);
                            } catch (SQLiteException e7) {
                                e = e7;
                                zzawVarZzj.zzu.zzaW().zzb().zzc("Database error querying filter results. appId", zzgu.zzl(str2), e);
                                Map map9 = Collections.EMPTY_MAP;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                map2 = map9;
                            }
                        } catch (SQLiteException e8) {
                            e = e8;
                            str4 = str10;
                            zzawVarZzj.zzu.zzaW().zzb().zzc("Database error querying filter results. appId", zzgu.zzl(str2), e);
                            Map map92 = Collections.EMPTY_MAP;
                            if (cursorQuery != null) {
                            }
                            map2 = map92;
                        }
                    }
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    z2 = z3;
                    str9 = str3;
                    str10 = str4;
                }
                cursorQuery.close();
                map2 = arrayMap3;
            }
        } catch (SQLiteException e9) {
            e = e9;
            z3 = z2;
            str3 = "data";
            str4 = "audience_id";
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        if (!map2.isEmpty()) {
            HashSet hashSet3 = new HashSet(map2.keySet());
            if (z3) {
                String str15 = this.zza;
                zzaw zzawVarZzj4 = this.zzg.zzj();
                String str16 = this.zza;
                zzawVarZzj4.zzay();
                zzawVarZzj4.zzg();
                Preconditions.checkNotEmpty(str16);
                Map arrayMap4 = new ArrayMap();
                SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj4.zze();
                try {
                    try {
                        cursorRawQuery = sQLiteDatabaseZze.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str16, str16});
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                do {
                                    Integer numValueOf2 = Integer.valueOf(cursorRawQuery.getInt(0));
                                    List arrayList4 = (List) arrayMap4.get(numValueOf2);
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList();
                                        arrayMap4.put(numValueOf2, arrayList4);
                                    }
                                    arrayList4.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                } while (cursorRawQuery.moveToNext());
                            } else {
                                arrayMap4 = Collections.EMPTY_MAP;
                            }
                        } catch (SQLiteException e10) {
                            e = e10;
                            zzawVarZzj4.zzu.zzaW().zzb().zzc("Database error querying scoped filters. appId", zzgu.zzl(str16), e);
                            arrayMap4 = Collections.EMPTY_MAP;
                            if (cursorRawQuery != null) {
                            }
                            Preconditions.checkNotEmpty(str15);
                            Preconditions.checkNotNull(map2);
                            ArrayMap arrayMap5 = new ArrayMap();
                            if (!map2.isEmpty()) {
                            }
                            hashSet = hashSet3;
                            map3 = arrayMap5;
                            while (r16.hasNext()) {
                            }
                            String str122 = str3;
                            String str132 = str4;
                            String str142 = "Skipping failed audience ID";
                            if (!list.isEmpty()) {
                            }
                            if (z) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r5 = sQLiteDatabaseZze;
                        if (r5 != 0) {
                            r5.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    cursorRawQuery = null;
                } catch (Throwable th6) {
                    th = th6;
                    r5 = 0;
                    if (r5 != 0) {
                    }
                    throw th;
                }
                cursorRawQuery.close();
                Preconditions.checkNotEmpty(str15);
                Preconditions.checkNotNull(map2);
                ArrayMap arrayMap52 = new ArrayMap();
                if (!map2.isEmpty()) {
                    Iterator it7 = map2.keySet().iterator();
                    while (it7.hasNext()) {
                        Integer num = (Integer) it7.next();
                        num.intValue();
                        com.google.android.gms.internal.measurement.zzii zziiVar = (com.google.android.gms.internal.measurement.zzii) map2.get(num);
                        List list5 = (List) arrayMap4.get(num);
                        if (list5 == null || list5.isEmpty()) {
                            map4 = arrayMap4;
                            hashSet2 = hashSet3;
                            it = it7;
                            arrayMap52.put(num, zziiVar);
                            arrayMap4 = map4;
                            hashSet3 = hashSet2;
                            it7 = it;
                        } else {
                            zzpg zzpgVar = this.zzg;
                            map4 = arrayMap4;
                            hashSet2 = hashSet3;
                            List listZzq = zzpgVar.zzp().zzq(zziiVar.zzc(), list5);
                            if (listZzq.isEmpty()) {
                                arrayMap4 = map4;
                                hashSet3 = hashSet2;
                            } else {
                                com.google.android.gms.internal.measurement.zzih zzihVar = (com.google.android.gms.internal.measurement.zzih) zziiVar.zzco();
                                zzihVar.zzd();
                                zzihVar.zzc(listZzq);
                                List listZzq2 = zzpgVar.zzp().zzq(zziiVar.zza(), list5);
                                zzihVar.zzb();
                                zzihVar.zza(listZzq2);
                                ArrayList arrayList5 = new ArrayList();
                                Iterator it8 = zziiVar.zze().iterator();
                                while (it8.hasNext()) {
                                    Iterator it9 = it7;
                                    com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) it8.next();
                                    Iterator it10 = it8;
                                    if (!list5.contains(Integer.valueOf(zzhqVar.zzb()))) {
                                        arrayList5.add(zzhqVar);
                                    }
                                    it7 = it9;
                                    it8 = it10;
                                }
                                it = it7;
                                zzihVar.zzf();
                                zzihVar.zze(arrayList5);
                                ArrayList arrayList6 = new ArrayList();
                                for (com.google.android.gms.internal.measurement.zzik zzikVar : zziiVar.zzh()) {
                                    if (!list5.contains(Integer.valueOf(zzikVar.zzb()))) {
                                        arrayList6.add(zzikVar);
                                    }
                                }
                                zzihVar.zzh();
                                zzihVar.zzg(arrayList6);
                                arrayMap52.put(num, (com.google.android.gms.internal.measurement.zzii) zzihVar.zzbd());
                                arrayMap4 = map4;
                                hashSet3 = hashSet2;
                                it7 = it;
                            }
                        }
                    }
                }
                hashSet = hashSet3;
                map3 = arrayMap52;
            } else {
                hashSet = hashSet3;
                map3 = map2;
            }
            for (Integer num2 : hashSet) {
                num2.intValue();
                com.google.android.gms.internal.measurement.zzii zziiVar2 = (com.google.android.gms.internal.measurement.zzii) map3.get(num2);
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap6 = new ArrayMap();
                if (zziiVar2 != null && zziiVar2.zzf() != 0) {
                    for (com.google.android.gms.internal.measurement.zzhq zzhqVar2 : zziiVar2.zze()) {
                        if (zzhqVar2.zza()) {
                            Map map10 = map3;
                            arrayMap6.put(Integer.valueOf(zzhqVar2.zzb()), zzhqVar2.zzc() ? Long.valueOf(zzhqVar2.zzd()) : null);
                            map3 = map10;
                        }
                    }
                }
                Map map11 = map3;
                ArrayMap arrayMap7 = new ArrayMap();
                if (zziiVar2 != null && zziiVar2.zzi() != 0) {
                    Iterator it11 = zziiVar2.zzh().iterator();
                    while (it11.hasNext()) {
                        com.google.android.gms.internal.measurement.zzik zzikVar2 = (com.google.android.gms.internal.measurement.zzik) it11.next();
                        if (zzikVar2.zza() && zzikVar2.zzd() > 0) {
                            arrayMap7.put(Integer.valueOf(zzikVar2.zzb()), Long.valueOf(zzikVar2.zze(zzikVar2.zzd() - 1)));
                            it11 = it11;
                            zziiVar2 = zziiVar2;
                        }
                    }
                }
                com.google.android.gms.internal.measurement.zzii zziiVar3 = zziiVar2;
                if (zziiVar3 != null) {
                    int i4 = 0;
                    while (i4 < zziiVar3.zzb() * 64) {
                        if (zzpk.zzn(zziiVar3.zza(), i4)) {
                            z4 = zZzp;
                            this.zzu.zzaW().zzk().zzc("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i4));
                            bitSet2.set(i4);
                            if (zzpk.zzn(zziiVar3.zzc(), i4)) {
                                bitSet.set(i4);
                            }
                            i4++;
                            zZzp = z4;
                        } else {
                            z4 = zZzp;
                        }
                        arrayMap6.remove(Integer.valueOf(i4));
                        i4++;
                        zZzp = z4;
                    }
                }
                boolean z5 = zZzp;
                com.google.android.gms.internal.measurement.zzii zziiVar4 = (com.google.android.gms.internal.measurement.zzii) map2.get(num2);
                if (zZzp2 && z5 && (list3 = (List) map.get(num2)) != null && this.zze != null && this.zzd != null) {
                    Iterator it12 = list3.iterator();
                    while (it12.hasNext()) {
                        com.google.android.gms.internal.measurement.zzff zzffVar2 = (com.google.android.gms.internal.measurement.zzff) it12.next();
                        int iZzb = zzffVar2.zzb();
                        Iterator it13 = it12;
                        long jLongValue = this.zze.longValue() / 1000;
                        if (zzffVar2.zzk()) {
                            jLongValue = this.zzd.longValue() / 1000;
                        }
                        Integer numValueOf3 = Integer.valueOf(iZzb);
                        if (arrayMap6.containsKey(numValueOf3)) {
                            arrayMap6.put(numValueOf3, Long.valueOf(jLongValue));
                        }
                        if (arrayMap7.containsKey(numValueOf3)) {
                            arrayMap7.put(numValueOf3, Long.valueOf(jLongValue));
                        }
                        it12 = it13;
                    }
                }
                this.zzc.put(num2, new zzy(this, this.zza, zziiVar4, bitSet, bitSet2, arrayMap6, arrayMap7, null));
                str3 = str3;
                map = map;
                str4 = str4;
                map2 = map2;
                zZzp = z5;
                map3 = map11;
            }
        }
        String str1222 = str3;
        String str1322 = str4;
        String str1422 = "Skipping failed audience ID";
        if (!list.isEmpty()) {
            zzz zzzVar2 = new zzz(this, null);
            ArrayMap arrayMap8 = new ArrayMap();
            Iterator it14 = list.iterator();
            while (it14.hasNext()) {
                com.google.android.gms.internal.measurement.zzhs zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it14.next();
                com.google.android.gms.internal.measurement.zzhs zzhsVarZza = zzzVar2.zza(this.zza, zzhsVar);
                if (zzhsVarZza != null) {
                    zzpg zzpgVar2 = this.zzg;
                    zzbd zzbdVarZzah = zzpgVar2.zzj().zzah(this.zza, zzhsVar, zzhsVarZza.zzd());
                    zzpgVar2.zzj().zzh(zzbdVarZzah);
                    if (z) {
                        continue;
                    } else {
                        long j2 = zzbdVarZzah.zzc;
                        String strZzd = zzhsVarZza.zzd();
                        Map map12 = (Map) arrayMap8.get(strZzd);
                        if (map12 == null) {
                            zzaw zzawVarZzj5 = zzpgVar2.zzj();
                            zzzVar = zzzVar2;
                            String str17 = this.zza;
                            zzawVarZzj5.zzay();
                            zzawVarZzj5.zzg();
                            Preconditions.checkNotEmpty(str17);
                            Preconditions.checkNotEmpty(strZzd);
                            it3 = it14;
                            ArrayMap arrayMap9 = new ArrayMap();
                            try {
                                try {
                                    str7 = str17;
                                } catch (Throwable th7) {
                                    th = th7;
                                    cursor3 = null;
                                }
                            } catch (SQLiteException e12) {
                                e = e12;
                                str7 = str17;
                            }
                            try {
                                Cursor cursorQuery4 = zzawVarZzj5.zze().query("event_filters", new String[]{str1322, str1222}, "app_id=? AND event_name=?", new String[]{str17, strZzd}, null, null, null);
                                try {
                                    try {
                                        if (cursorQuery4.moveToFirst()) {
                                            zzbdVar = zzbdVarZzah;
                                            while (true) {
                                                try {
                                                    try {
                                                        com.google.android.gms.internal.measurement.zzff zzffVar3 = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), cursorQuery4.getBlob(1))).zzbd();
                                                        Integer numValueOf4 = Integer.valueOf(cursorQuery4.getInt(0));
                                                        List list6 = (List) arrayMap9.get(numValueOf4);
                                                        if (list6 == null) {
                                                            cursor4 = cursorQuery4;
                                                            try {
                                                                arrayList2 = new ArrayList();
                                                                arrayMap9.put(numValueOf4, arrayList2);
                                                            } catch (SQLiteException e13) {
                                                                e = e13;
                                                                cursor3 = cursor4;
                                                                try {
                                                                    zzawVarZzj5.zzu.zzaW().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str7), e);
                                                                    map12 = Collections.EMPTY_MAP;
                                                                    if (cursor3 != null) {
                                                                    }
                                                                } catch (Throwable th8) {
                                                                    th = th8;
                                                                    if (cursor3 != null) {
                                                                        cursor3.close();
                                                                    }
                                                                    throw th;
                                                                }
                                                            } catch (Throwable th9) {
                                                                th = th9;
                                                                cursor3 = cursor4;
                                                                if (cursor3 != null) {
                                                                }
                                                                throw th;
                                                            }
                                                        } else {
                                                            cursor4 = cursorQuery4;
                                                            arrayList2 = list6;
                                                        }
                                                        arrayList2.add(zzffVar3);
                                                    } catch (IOException e14) {
                                                        cursor4 = cursorQuery4;
                                                        zzawVarZzj5.zzu.zzaW().zzb().zzc("Failed to merge filter. appId", zzgu.zzl(str7), e14);
                                                    }
                                                    if (!cursor4.moveToNext()) {
                                                        break;
                                                    }
                                                    cursorQuery4 = cursor4;
                                                } catch (SQLiteException e15) {
                                                    e = e15;
                                                    cursor4 = cursorQuery4;
                                                }
                                            }
                                            cursor4.close();
                                            map12 = arrayMap9;
                                        } else {
                                            zzbdVar = zzbdVarZzah;
                                            map12 = Collections.EMPTY_MAP;
                                            cursorQuery4.close();
                                        }
                                    } catch (SQLiteException e16) {
                                        e = e16;
                                        cursor4 = cursorQuery4;
                                        zzbdVar = zzbdVarZzah;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    cursor4 = cursorQuery4;
                                }
                            } catch (SQLiteException e17) {
                                e = e17;
                                zzbdVar = zzbdVarZzah;
                                cursor3 = null;
                                zzawVarZzj5.zzu.zzaW().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str7), e);
                                map12 = Collections.EMPTY_MAP;
                                if (cursor3 != null) {
                                    cursor3.close();
                                }
                                arrayMap8.put(strZzd, map12);
                                it4 = map12.keySet().iterator();
                                while (it4.hasNext()) {
                                }
                                it14 = it3;
                                zzzVar2 = zzzVar;
                            }
                            arrayMap8.put(strZzd, map12);
                        } else {
                            zzzVar = zzzVar2;
                            it3 = it14;
                            zzbdVar = zzbdVarZzah;
                        }
                        it4 = map12.keySet().iterator();
                        while (it4.hasNext()) {
                            Integer num3 = (Integer) it4.next();
                            int iIntValue = num3.intValue();
                            if (this.zzb.contains(num3)) {
                                this.zzu.zzaW().zzk().zzb("Skipping failed audience ID", num3);
                            } else {
                                Iterator it15 = ((List) map12.get(num3)).iterator();
                                boolean zZzd = true;
                                while (true) {
                                    if (!it15.hasNext()) {
                                        map6 = map12;
                                        it5 = it4;
                                        j = j2;
                                        break;
                                    }
                                    com.google.android.gms.internal.measurement.zzff zzffVar4 = (com.google.android.gms.internal.measurement.zzff) it15.next();
                                    map6 = map12;
                                    it5 = it4;
                                    zzaa zzaaVar = new zzaa(this, this.zza, iIntValue, zzffVar4);
                                    j = j2;
                                    zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhsVarZza, j, zzbdVar, zzd(iIntValue, zzffVar4.zzb()));
                                    if (!zZzd) {
                                        this.zzb.add(num3);
                                        break;
                                    }
                                    zzc(num3).zza(zzaaVar);
                                    j2 = j;
                                    map12 = map6;
                                    it4 = it5;
                                }
                                if (!zZzd) {
                                    this.zzb.add(num3);
                                }
                                j2 = j;
                                map12 = map6;
                                it4 = it5;
                            }
                        }
                        it14 = it3;
                        zzzVar2 = zzzVar;
                    }
                }
            }
        }
        if (z) {
            return new ArrayList();
        }
        if (!list2.isEmpty()) {
            ArrayMap arrayMap10 = new ArrayMap();
            Iterator it16 = list2.iterator();
            while (it16.hasNext()) {
                com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) it16.next();
                String strZzc = zziuVar.zzc();
                Map map13 = (Map) arrayMap10.get(strZzc);
                if (map13 == null) {
                    zzaw zzawVarZzj6 = this.zzg.zzj();
                    String str18 = this.zza;
                    zzawVarZzj6.zzay();
                    zzawVarZzj6.zzg();
                    Preconditions.checkNotEmpty(str18);
                    Preconditions.checkNotEmpty(strZzc);
                    ArrayMap arrayMap11 = new ArrayMap();
                    try {
                        cursorQuery2 = zzawVarZzj6.zze().query("property_filters", new String[]{str1322, str1222}, "app_id=? AND property_name=?", new String[]{str18, strZzc}, null, null, null);
                        try {
                            try {
                            } catch (SQLiteException e18) {
                                e = e18;
                                it2 = it16;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            cursor2 = cursorQuery2;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e19) {
                        e = e19;
                        it2 = it16;
                        str6 = str18;
                        cursorQuery2 = null;
                    } catch (Throwable th12) {
                        th = th12;
                        cursor2 = null;
                    }
                    if (cursorQuery2.moveToFirst()) {
                        while (true) {
                            try {
                                com.google.android.gms.internal.measurement.zzfn zzfnVar = (com.google.android.gms.internal.measurement.zzfn) ((com.google.android.gms.internal.measurement.zzfm) zzpk.zzw(com.google.android.gms.internal.measurement.zzfn.zzj(), cursorQuery2.getBlob(1))).zzbd();
                                Integer numValueOf5 = Integer.valueOf(cursorQuery2.getInt(0));
                                List list7 = (List) arrayMap11.get(numValueOf5);
                                if (list7 == null) {
                                    it2 = it16;
                                    try {
                                        arrayList = new ArrayList();
                                        arrayMap11.put(numValueOf5, arrayList);
                                    } catch (SQLiteException e20) {
                                        e = e20;
                                        str6 = str18;
                                        zzawVarZzj6.zzu.zzaW().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str6), e);
                                        map13 = Collections.EMPTY_MAP;
                                        if (cursorQuery2 != null) {
                                            cursorQuery2.close();
                                        }
                                    }
                                } else {
                                    it2 = it16;
                                    arrayList = list7;
                                }
                                arrayList.add(zzfnVar);
                                str6 = str18;
                            } catch (IOException e21) {
                                it2 = it16;
                                str6 = str18;
                                try {
                                    zzawVarZzj6.zzu.zzaW().zzb().zzc("Failed to merge filter", zzgu.zzl(str6), e21);
                                } catch (SQLiteException e22) {
                                    e = e22;
                                    zzawVarZzj6.zzu.zzaW().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str6), e);
                                    map13 = Collections.EMPTY_MAP;
                                    if (cursorQuery2 != null) {
                                    }
                                }
                            }
                            if (!cursorQuery2.moveToNext()) {
                                break;
                            }
                            it16 = it2;
                            str18 = str6;
                        }
                        cursorQuery2.close();
                        map13 = arrayMap11;
                        arrayMap10.put(strZzc, map13);
                    } else {
                        it2 = it16;
                        map13 = Collections.EMPTY_MAP;
                        cursorQuery2.close();
                        arrayMap10.put(strZzc, map13);
                    }
                } else {
                    it2 = it16;
                }
                Iterator it17 = map13.keySet().iterator();
                while (true) {
                    if (it17.hasNext()) {
                        Integer num4 = (Integer) it17.next();
                        int iIntValue2 = num4.intValue();
                        if (this.zzb.contains(num4)) {
                            this.zzu.zzaW().zzk().zzb(str1422, num4);
                            break;
                        }
                        Iterator it18 = ((List) map13.get(num4)).iterator();
                        boolean zZzd2 = true;
                        while (true) {
                            if (!it18.hasNext()) {
                                map5 = map13;
                                str5 = str1422;
                                arrayMap = arrayMap10;
                                break;
                            }
                            com.google.android.gms.internal.measurement.zzfn zzfnVar2 = (com.google.android.gms.internal.measurement.zzfn) it18.next();
                            zzic zzicVar2 = this.zzu;
                            map5 = map13;
                            if (Log.isLoggable(zzicVar2.zzaW().zzn(), 2)) {
                                str5 = str1422;
                                arrayMap = arrayMap10;
                                zzicVar2.zzaW().zzk().zzd("Evaluating filter. audience, filter, property", num4, zzfnVar2.zza() ? Integer.valueOf(zzfnVar2.zzb()) : null, zzicVar2.zzl().zzc(zzfnVar2.zzc()));
                                zzicVar2.zzaW().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfnVar2));
                            } else {
                                str5 = str1422;
                                arrayMap = arrayMap10;
                            }
                            if (!zzfnVar2.zza() || zzfnVar2.zzb() > 256) {
                                break;
                            }
                            zzac zzacVar = new zzac(this, this.zza, iIntValue2, zzfnVar2);
                            zZzd2 = zzacVar.zzd(this.zzd, this.zze, zziuVar, zzd(iIntValue2, zzfnVar2.zzb()));
                            if (!zZzd2) {
                                this.zzb.add(num4);
                                break;
                            }
                            zzc(num4).zza(zzacVar);
                            map13 = map5;
                            arrayMap10 = arrayMap;
                            str1422 = str5;
                        }
                        if (!zZzd2) {
                            this.zzb.add(num4);
                        }
                        map13 = map5;
                        arrayMap10 = arrayMap;
                        str1422 = str5;
                    }
                }
                it16 = it2;
            }
        }
        ArrayList arrayList7 = new ArrayList();
        Set<Integer> setKeySet = this.zzc.keySet();
        setKeySet.removeAll(this.zzb);
        for (Integer num5 : setKeySet) {
            int iIntValue3 = num5.intValue();
            zzy zzyVar = (zzy) this.zzc.get(num5);
            Preconditions.checkNotNull(zzyVar);
            com.google.android.gms.internal.measurement.zzhg zzhgVarZzb = zzyVar.zzb(iIntValue3);
            arrayList7.add(zzhgVarZzb);
            zzaw zzawVarZzj7 = this.zzg.zzj();
            String str19 = this.zza;
            com.google.android.gms.internal.measurement.zzii zziiVarZzc = zzhgVarZzb.zzc();
            zzawVarZzj7.zzay();
            zzawVarZzj7.zzg();
            Preconditions.checkNotEmpty(str19);
            Preconditions.checkNotNull(zziiVarZzc);
            byte[] bArrZzcd = zziiVarZzc.zzcd();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str19);
            contentValues2.put(str1322, num5);
            contentValues2.put("current_results", bArrZzcd);
            try {
                try {
                    if (zzawVarZzj7.zze().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                        zzawVarZzj7.zzu.zzaW().zzb().zzb("Failed to insert filter results (got -1). appId", zzgu.zzl(str19));
                    }
                } catch (SQLiteException e23) {
                    e = e23;
                    zzawVarZzj7.zzu.zzaW().zzb().zzc("Error storing filter results. appId", zzgu.zzl(str19), e);
                }
            } catch (SQLiteException e24) {
                e = e24;
            }
        }
        return arrayList7;
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    public final boolean zzbc() {
        return false;
    }
}
