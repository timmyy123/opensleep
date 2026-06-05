package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzj {
    public static Object zza(Class cls, String str, zzi... zziVarArr) {
        return zzc(cls, "isIsolated", null, false, zziVarArr);
    }

    private static Object zzc(Class cls, String str, Object obj, boolean z, zzi... zziVarArr) {
        int length = zziVarArr.length;
        Class<?>[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        Object obj2 = null;
        if (zziVarArr.length <= 0) {
            return cls.getDeclaredMethod(str, clsArr).invoke(null, objArr);
        }
        zzi zziVar = zziVarArr[0];
        obj2.getClass();
        throw null;
    }
}
