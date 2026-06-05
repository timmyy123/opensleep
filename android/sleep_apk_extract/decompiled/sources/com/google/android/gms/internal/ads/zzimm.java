package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzimm {
    public static zzimm zzb(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzimh(cls.getSimpleName()) : new zzimj(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
