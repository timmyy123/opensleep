package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzaon {
    public static zzaoo zza(zzaoo zzaooVar, String[] strArr, Map map) {
        int length;
        int i = 0;
        if (zzaooVar == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzaoo) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzaoo zzaooVar2 = new zzaoo();
                while (i < length2) {
                    zzaooVar2.zzr((zzaoo) map.get(strArr[i]));
                    i++;
                }
                return zzaooVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                zzaooVar.zzr((zzaoo) map.get(strArr[0]));
                return zzaooVar;
            }
            if (strArr != null && (length = strArr.length) > 1) {
                while (i < length) {
                    zzaooVar.zzr((zzaoo) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return zzaooVar;
    }
}
