package com.google.common.base;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import javax.annotation.CheckForNull;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Preconditions {
    private static String badElementIndex(int i, int i2, String str) {
        if (i < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i2, "negative size: "));
        return null;
    }

    private static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i2, "negative size: "));
        return null;
    }

    private static String badPositionIndexes(int i, int i2, int i3) {
        return (i < 0 || i > i3) ? badPositionIndex(i, i3, "start index") : (i2 < 0 || i2 > i3) ? badPositionIndex(i2, i3, "end index") : Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    public static void checkArgument(boolean z, String str, char c) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(Strings.lenientFormat(str, Character.valueOf(c)));
    }

    public static int checkElementIndex(int i, int i2, String str) {
        if (i >= 0 && i < i2) {
            return i;
        }
        Events$$ExternalSyntheticBUOutline0.m$2(badElementIndex(i, i2, str));
        return 0;
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        Types$$ExternalSyntheticBUOutline0.m$1(Strings.lenientFormat(str, obj));
        return null;
    }

    public static int checkPositionIndex(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        Events$$ExternalSyntheticBUOutline0.m$2(badPositionIndex(i, i2, str));
        return 0;
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            Events$$ExternalSyntheticBUOutline0.m$2(badPositionIndexes(i, i2, i3));
        }
    }

    public static void checkState(boolean z, String str, int i) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(Strings.lenientFormat(str, Integer.valueOf(i)));
    }

    public static int checkElementIndex(int i, int i2) {
        return checkElementIndex(i, i2, "index");
    }

    public static int checkPositionIndex(int i, int i2) {
        return checkPositionIndex(i, i2, "index");
    }

    public static <T> T checkNotNull(@CheckForNull T t, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object... objArr) {
        if (t != null) {
            return t;
        }
        Types$$ExternalSyntheticBUOutline0.m$1(Strings.lenientFormat(str, objArr));
        return null;
    }

    public static <T> T checkNotNull(@CheckForNull T t) {
        t.getClass();
        return t;
    }

    public static void checkArgument(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkState(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z, String str, @CheckForNull Object... objArr) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(Strings.lenientFormat(str, objArr));
    }

    public static void checkState(boolean z, @CheckForNull String str, @CheckForNull Object... objArr) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(Strings.lenientFormat(str, objArr));
    }

    public static void checkArgument(boolean z) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3();
    }

    public static void checkState(boolean z) {
        if (z) {
            return;
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
    }

    public static void checkArgument(boolean z, String str, int i) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(Strings.lenientFormat(str, Integer.valueOf(i)));
    }

    public static void checkState(boolean z, String str, @CheckForNull Object obj) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(Strings.lenientFormat(str, obj));
    }

    public static void checkArgument(boolean z, String str, long j) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(Strings.lenientFormat(str, Long.valueOf(j)));
    }

    public static void checkArgument(boolean z, String str, @CheckForNull Object obj) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(Strings.lenientFormat(str, obj));
    }
}
