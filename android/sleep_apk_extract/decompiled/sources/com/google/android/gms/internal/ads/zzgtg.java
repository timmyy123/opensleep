package com.google.android.gms.internal.ads;

import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgtg {
    public static Object zza(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        if (obj2 != null) {
            return obj2;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Both parameters are null");
        return null;
    }

    public static zzgtf zzb(Object obj) {
        return new zzgtf(obj.getClass().getSimpleName(), null);
    }
}
