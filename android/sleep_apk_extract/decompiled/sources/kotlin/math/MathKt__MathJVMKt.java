package kotlin.math;

import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0007H\u0007¢\u0006\u0004\b\u0002\u0010\b\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"", "", "roundToInt", "(D)I", "", "roundToLong", "(D)J", "", "(F)I", "getSign", "(J)I", "getSign$annotations", "(J)V", "sign", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/math/MathKt")
public abstract class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static int getSign(long j) {
        return Long.signum(j);
    }

    public static int roundToInt(double d) {
        if (Double.isNaN(d)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Cannot round NaN value.");
            return 0;
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    public static long roundToLong(double d) {
        if (!Double.isNaN(d)) {
            return Math.round(d);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Cannot round NaN value.");
        return 0L;
    }

    public static int roundToInt(float f) {
        if (!Float.isNaN(f)) {
            return Math.round(f);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Cannot round NaN value.");
        return 0;
    }
}
