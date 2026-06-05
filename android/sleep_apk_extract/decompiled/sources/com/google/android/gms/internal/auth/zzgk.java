package com.google.android.gms.internal.auth;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzgk {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final Class zzb;
    private static final zzgz zzc;
    private static final zzgz zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzgz zzgzVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzgzVar = (zzgz) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzgzVar;
        zzd = new zzhb();
    }

    public static zzgz zza() {
        return zzc;
    }

    public static zzgz zzb() {
        return zzd;
    }

    public static void zzd(zzgz zzgzVar, Object obj, Object obj2) {
        zzgzVar.zzf(obj, zzgzVar.zzc(zzgzVar.zzb(obj), zzgzVar.zzb(obj2)));
    }

    public static void zze(Class cls) {
        Class cls2;
        if (zzev.class.isAssignableFrom(cls) || (cls2 = zzb) == null || cls2.isAssignableFrom(cls)) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    public static boolean zzf(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
