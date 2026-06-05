package com.google.android.gms.internal.serialization;

import android.os.Build;
import dalvik.system.VMStack;

/* JADX INFO: loaded from: classes3.dex */
public final class zzha extends zzgu {
    private static final boolean zza = zza.zza();
    private static final boolean zzb;
    private static final zzgt zzc;

    abstract class zza {
        public static boolean zza() {
            return zzha.zzp();
        }
    }

    static {
        String str = Build.FINGERPRINT;
        boolean z = true;
        if (str != null && !"robolectric".equals(str)) {
            z = false;
        }
        zzb = z;
        zzc = new zzgt() { // from class: com.google.android.gms.internal.home.zzha.1
        };
    }

    public static boolean zzp() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", null);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzgu
    public zzfw zze(String str) {
        return zzhf.zze(str);
    }
}
