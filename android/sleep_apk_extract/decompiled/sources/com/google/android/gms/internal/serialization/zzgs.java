package com.google.android.gms.internal.serialization;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzgs {
    private static final zzgu zza = zzb(zzgu.zzd);

    private static zzgu zzb(String[] strArr) {
        zzha zzhaVar;
        try {
            zzhaVar = zzhb.zza;
        } catch (NoClassDefFoundError unused) {
            zzhaVar = null;
        }
        if (zzhaVar != null) {
            return zzhaVar;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzgu) Class.forName(str).getConstructor(null).newInstance(null);
            } catch (Throwable th) {
                th = th;
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
