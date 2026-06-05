package io.github.zeroone3010.yahueapi;

/* JADX INFO: loaded from: classes5.dex */
final class MathUtil {
    private MathUtil() {
    }

    public static boolean isInRange(Float f, float f2, float f3) {
        return f != null && f.floatValue() >= f2 && f.floatValue() <= f3;
    }
}
