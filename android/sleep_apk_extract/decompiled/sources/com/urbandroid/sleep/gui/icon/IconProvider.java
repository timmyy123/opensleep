package com.urbandroid.sleep.gui.icon;

import android.content.Context;
import com.urbandroid.util.ResourceUtil;
import java.util.Calendar;

/* JADX INFO: loaded from: classes4.dex */
public abstract class IconProvider {
    public static int getResource(Context context, Calendar calendar, long j, String str) {
        int i = calendar.get(11);
        if (j > -650) {
            if (j < 1) {
                return getResource(context, str, "sleep");
            }
            if (j < 15) {
                return getResource(context, str, "read");
            }
            if (j < 30) {
                return getResource(context, str, "tooth");
            }
            if (j < 120) {
                return getResource(context, str, "home");
            }
        }
        return i == 12 ? getResource(context, str, "food") : i == 17 ? getResource(context, str, "food") : (i > 18 || i < 5) ? getResource(context, str, "home") : (calendar.get(7) == 1 || calendar.get(7) == 7) ? getResource(context, str, "home") : getResource(context, str, "work");
    }

    private static int getResource(Context context, String str, String str2) {
        return ResourceUtil.getResourceByName(context, "drawable", str + "_" + str2);
    }
}
