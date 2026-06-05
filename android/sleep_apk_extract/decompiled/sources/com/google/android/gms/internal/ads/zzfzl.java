package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public interface zzfzl {
    static String zzb(File file, String str, zzfzp zzfzpVar) {
        return new File(file, str).getPath();
    }

    default String zza(File file, String str) {
        return zzb(file, str, zzfzp.zza);
    }
}
