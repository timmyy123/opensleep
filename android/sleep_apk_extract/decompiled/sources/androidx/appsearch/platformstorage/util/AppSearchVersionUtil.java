package androidx.appsearch.platformstorage.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppSearchVersionUtil {
    private static volatile long sAppSearchVersionCode = -1;

    public static class ApiHelperForQ {
        public static String getAppSearchPackageName(PackageManager packageManager) {
            return packageManager.getModuleInfo("com.android.appsearch", 1).getPackageName();
        }

        public static long getPackageInfoLongVersionCode(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }
    }

    public static long getAppSearchVersionCode(Context context) {
        Preconditions.checkNotNull(context);
        if (sAppSearchVersionCode != -1) {
            return sAppSearchVersionCode;
        }
        synchronized (AppSearchVersionUtil.class) {
            if (sAppSearchVersionCode == -1) {
                long packageInfoLongVersionCode = 0;
                try {
                    PackageManager packageManager = context.getPackageManager();
                    String appSearchPackageName = ApiHelperForQ.getAppSearchPackageName(packageManager);
                    if (appSearchPackageName != null) {
                        packageInfoLongVersionCode = ApiHelperForQ.getPackageInfoLongVersionCode(packageManager.getPackageInfo(appSearchPackageName, 1073741824));
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                sAppSearchVersionCode = packageInfoLongVersionCode;
            }
        }
        return sAppSearchVersionCode;
    }

    public static boolean isAtLeastB() {
        int i = Build.VERSION.SDK_INT;
        if (i < 36) {
            return i >= 35 && Build.VERSION.CODENAME.equals("Baklava");
        }
        return true;
    }
}
