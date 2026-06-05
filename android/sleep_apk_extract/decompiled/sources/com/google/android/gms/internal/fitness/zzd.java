package com.google.android.gms.internal.fitness;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzd {
    public static int zza(Object obj, List list) {
        if (obj == null) {
            return -1;
        }
        int iIndexOf = list.indexOf(obj);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        list.add(obj);
        return list.size() - 1;
    }
}
