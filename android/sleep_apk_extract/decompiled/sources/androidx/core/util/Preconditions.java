package androidx.core.util;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import java.util.Locale;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public abstract class Preconditions {
    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int checkArgumentInRange(int i, int i2, int i3, String str) {
        if (i < i2) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + i2 + ", " + i3 + "] (too low)");
        }
        if (i <= i3) {
            return i;
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + i2 + ", " + i3 + "] (too high)");
    }

    public static int checkArgumentNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(str);
        return 0;
    }

    public static int checkFlagsArgument(int i, int i2) {
        if ((i & i2) == i) {
            return i;
        }
        OggIO$$ExternalSyntheticBUOutline0.m(Integer.toHexString(i), ", but only 0x", Integer.toHexString(i2), " are allowed", "Requested flags 0x");
        return 0;
    }

    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z, String str) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(str);
    }

    public static int checkArgumentNonnegative(int i) {
        if (i >= 0) {
            return i;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3();
        return 0;
    }

    public static void checkArgument(boolean z) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3();
    }

    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }
}
