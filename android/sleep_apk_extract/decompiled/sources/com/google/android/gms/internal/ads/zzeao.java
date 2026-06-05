package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeao {
    private final Map zza = new ConcurrentHashMap();

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009c A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:3:0x0001, B:8:0x0019, B:10:0x0032, B:12:0x0038, B:14:0x0041, B:18:0x0049, B:25:0x0068, B:29:0x009c, B:31:0x00a6, B:32:0x00ae, B:33:0x00b5, B:35:0x00bb, B:36:0x00bf, B:38:0x00d4, B:39:0x00dd, B:41:0x00e3, B:43:0x00f1, B:45:0x00f7, B:46:0x0109, B:48:0x010f, B:50:0x0121, B:52:0x0129, B:56:0x013a, B:58:0x0142, B:60:0x0148, B:62:0x0151, B:63:0x015a, B:26:0x0079, B:27:0x008a), top: B:70:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zza(long j, int i, long j2) {
        int iIntValue;
        ArrayDeque arrayDeque;
        Long l;
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziK)).booleanValue()) {
                if (i == 2) {
                    zzeam zzeamVar = new zzeam();
                    zzeamVar.zza(j);
                    zzeamVar.zzb(1);
                    zzear zzearVarZzc = zzeamVar.zzc();
                    Map map = this.zza;
                    ArrayDeque arrayDeque2 = (ArrayDeque) map.get(zzearVarZzc);
                    if (arrayDeque2 != null && !arrayDeque2.isEmpty()) {
                        arrayDeque2.removeFirst();
                        if (arrayDeque2.isEmpty()) {
                            map.remove(zzearVarZzc);
                        }
                    }
                    i = 2;
                }
                zzeam zzeamVar2 = new zzeam();
                zzeamVar2.zza(j);
                zzeamVar2.zzb(i);
                zzear zzearVarZzc2 = zzeamVar2.zzc();
                int iZzb = zzearVarZzc2.zzb();
                if (iZzb == 0) {
                    iIntValue = 0;
                    if (iIntValue > 0) {
                        Map map2 = this.zza;
                        ArrayDeque arrayDeque3 = (ArrayDeque) map2.get(zzearVarZzc2);
                        if (arrayDeque3 == null) {
                            arrayDeque3 = new ArrayDeque();
                            map2.put(zzearVarZzc2, arrayDeque3);
                        }
                        arrayDeque3.addLast(Long.valueOf(j2));
                        while (arrayDeque3.size() > iIntValue) {
                            arrayDeque3.removeFirst();
                        }
                        zzc();
                        int iIntValue2 = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziU)).intValue();
                        if (iIntValue2 <= 0) {
                            map2.clear();
                            return;
                        }
                        while (true) {
                            Iterator it = map2.values().iterator();
                            int size = 0;
                            while (it.hasNext()) {
                                size += ((ArrayDeque) it.next()).size();
                            }
                            if (size <= iIntValue2) {
                                break;
                            }
                            if (!map2.isEmpty()) {
                                Long l2 = Long.MAX_VALUE;
                                Map.Entry entry = null;
                                for (Map.Entry entry2 : map2.entrySet()) {
                                    ArrayDeque arrayDeque4 = (ArrayDeque) entry2.getValue();
                                    if (!arrayDeque4.isEmpty() && (l = (Long) arrayDeque4.peekFirst()) != null && l.longValue() < l2.longValue()) {
                                        entry = entry2;
                                        l2 = l;
                                    }
                                }
                                if (entry != null && (arrayDeque = (ArrayDeque) entry.getValue()) != null && !arrayDeque.isEmpty()) {
                                    arrayDeque.removeFirst();
                                    if (arrayDeque.isEmpty()) {
                                        map2.remove(entry.getKey());
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (iZzb == 1) {
                        iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziR)).intValue();
                    } else if (iZzb == 2) {
                        iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziS)).intValue();
                    } else if (iZzb == 3) {
                        iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziT)).intValue();
                    }
                    if (iIntValue > 0) {
                    }
                }
            }
        } finally {
        }
    }

    public final synchronized Map zzb() {
        HashMap map;
        map = new HashMap();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziK)).booleanValue()) {
            zzc();
            for (Map.Entry entry : this.zza.entrySet()) {
                map.put((zzear) entry.getKey(), new ArrayDeque((Collection) entry.getValue()));
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc() {
        long jLongValue;
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
        Iterator it = this.zza.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzear zzearVar = (zzear) entry.getKey();
            ArrayDeque arrayDeque = (ArrayDeque) entry.getValue();
            int iZzb = zzearVar.zzb();
            if (iZzb == 0) {
                jLongValue = 0;
            } else if (iZzb == 1) {
                jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziO)).longValue();
            } else if (iZzb == 2) {
                jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziP)).longValue();
            } else if (iZzb == 3) {
                jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziQ)).longValue();
            }
            if (jLongValue == 0) {
                it.remove();
                jLongValue = 0;
            }
            if (jLongValue > 0) {
                Iterator it2 = arrayDeque.iterator();
                while (it2.hasNext() && jCurrentTimeMillis - ((Long) it2.next()).longValue() > jLongValue) {
                    it2.remove();
                }
                if (arrayDeque.isEmpty()) {
                    it.remove();
                }
            }
        }
    }
}
