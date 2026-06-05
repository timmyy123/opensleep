package androidx.core.view;

import android.os.Build;
import android.view.Display;

/* JADX INFO: loaded from: classes.dex */
public abstract class DisplayCompat {
    public static RoundedCornerCompat getRoundedCorner(Display display, int i) {
        if (Build.VERSION.SDK_INT >= 31) {
            return RoundedCornerCompat.toRoundedCornerCompat(display.getRoundedCorner(i));
        }
        return null;
    }
}
