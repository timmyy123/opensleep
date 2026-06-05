package kotlin.ranges;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.ranges.IntProgression;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000b\u001a\u00020\r*\u00020\r2\u0006\u0010\n\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000e\u001a\u0019\u0010\u000b\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000f¢\u0006\u0004\b\u000b\u0010\u0010\u001a\u0019\u0010\u000b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011¢\u0006\u0004\b\u000b\u0010\u0012\u001a\u0019\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\f\u001a\u0019\u0010\u0014\u001a\u00020\r*\u00020\r2\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u000e\u001a\u0019\u0010\u0014\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0010\u001a\u0019\u0010\u0014\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0012\u001a!\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a!\u0010\u0015\u001a\u00020\r*\u00020\r2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0017\u001a!\u0010\u0015\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0018¨\u0006\u0019"}, d2 = {"", "to", "Lkotlin/ranges/IntProgression;", "downTo", "(II)Lkotlin/ranges/IntProgression;", "step", "(Lkotlin/ranges/IntProgression;I)Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/IntRange;", "until", "(II)Lkotlin/ranges/IntRange;", "minimumValue", "coerceAtLeast", "(II)I", "", "(JJ)J", "", "(FF)F", "", "(DD)D", "maximumValue", "coerceAtMost", "coerceIn", "(III)I", "(JJJ)J", "(FFF)F", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
public abstract class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static double coerceAtLeast(double d, double d2) {
        return d < d2 ? d2 : d;
    }

    public static double coerceAtMost(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    public static float coerceIn(float f, float f2, float f3) {
        if (f2 <= f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    public static IntProgression downTo(int i, int i2) {
        return IntProgression.INSTANCE.fromClosedRange(i, i2, -1);
    }

    public static IntProgression step(IntProgression intProgression, int i) {
        intProgression.getClass();
        RangesKt__RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        IntProgression.Companion companion = IntProgression.INSTANCE;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    public static IntRange until(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? IntRange.INSTANCE.getEMPTY() : new IntRange(i, i2 - 1);
    }

    public static float coerceAtLeast(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static float coerceAtMost(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static int coerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static int coerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long coerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static long coerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static long coerceIn(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m("Cannot coerce value to an empty range: maximum ", " is less than minimum ", j3), j2, '.'));
        return 0L;
    }

    public static int coerceIn(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }
}
