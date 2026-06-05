package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.work.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    private static int getComponentEnabledSetting(Context context, String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, str));
    }

    private static boolean isComponentEnabled(int i, boolean z) {
        return i == 0 ? z : i == 1;
    }

    public static void setComponentEnabled(Context context, Class<?> cls, boolean z) {
        try {
            if (z == isComponentEnabled(getComponentEnabledSetting(context, cls.getName()), false)) {
                Logger.get().debug(TAG, "Skipping component enablement for ".concat(cls.getName()));
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            Logger logger = Logger.get();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            sb.append(z ? "enabled" : "disabled");
            logger.debug(str, sb.toString());
        } catch (Exception e) {
            Logger logger2 = Logger.get();
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            Fragment$$ExternalSyntheticOutline1.m(cls, sb2, "could not be ");
            sb2.append(z ? "enabled" : "disabled");
            logger2.debug(str2, sb2.toString(), e);
        }
    }
}
