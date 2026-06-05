package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.os.UserManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzaa {
    private static volatile UserManager zzdc;
    private static volatile boolean zzdd = !zzf();

    public static boolean zze(Context context) {
        return zzf() && !zzf(context);
    }

    private static boolean zzf(Context context) {
        boolean z = zzdd;
        if (z) {
            return z;
        }
        UserManager userManager = zzdc;
        if (userManager == null) {
            synchronized (zzaa.class) {
                try {
                    userManager = zzdc;
                    if (userManager == null) {
                        UserManager userManager2 = (UserManager) context.getSystemService(UserManager.class);
                        zzdc = userManager2;
                        if (userManager2 == null) {
                            zzdd = true;
                            return true;
                        }
                        userManager = userManager2;
                    }
                } finally {
                }
            }
        }
        boolean zIsUserUnlocked = userManager.isUserUnlocked();
        zzdd = zIsUserUnlocked;
        if (zIsUserUnlocked) {
            zzdc = null;
        }
        return zIsUserUnlocked;
    }

    private static boolean zzf() {
        return true;
    }
}
