package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import com.facebook.AuthenticationTokenClaims;
import com.urbandroid.common.util.math.sun.MoreMath;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\u001a%\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\t\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\b\u001a5\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\u0010\u001a\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0010\u001a%\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001d\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0010\u001a%\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0012\u001a\u001d\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0004\u001a%\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0015\u0010\b\u001a-\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a-\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a%\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u0012\u001a%\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u0012¨\u0006\u001f"}, d2 = {"", "x", "cycle", "normalize", "(FF)F", "fixRoundingErrors", "y", AuthenticationTokenClaims.JSON_KEY_SUB, "(FFF)F", "distance", "weightX", "weightY", "center", "(FFFFF)F", "", "xs", "([FF)F", "median", "([FFF)F", "stdev", "opposite", "clockwiseDistance", "start", "end", "", "isBetweenClockwise", "(FFFF)Z", "filterBetweenClockwise", "([FFFF)[F", "halfStdevClockwise", "halfStdevAnticlockwise", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class CyclicFloatKt {
    public static final float center(float f, float f2, float f3, float f4, float f5) {
        if (f2 < 0.0f) {
            Events$$ExternalSyntheticBUOutline0.m("weightX must be non-negative: ", f2);
            return 0.0f;
        }
        if (f4 < 0.0f) {
            Events$$ExternalSyntheticBUOutline0.m("weightY must be non-negative: ", f4);
            return 0.0f;
        }
        float fNormalize = normalize(f, f5);
        float fNormalize2 = normalize(f3, f5);
        float fDistance = distance(fNormalize, fNormalize2, f5);
        return fNormalize < fNormalize2 ? fNormalize2 - fNormalize < f5 / 2.0f ? normalize(((fDistance * f4) / (f2 + f4)) + fNormalize, f5) : normalize(fNormalize - ((fDistance * f4) / (f2 + f4)), f5) : fNormalize - fNormalize2 < f5 / 2.0f ? normalize(((fDistance * f2) / (f2 + f4)) + fNormalize2, f5) : normalize(fNormalize2 - ((fDistance * f2) / (f2 + f4)), f5);
    }

    public static final float clockwiseDistance(float f, float f2, float f3) {
        return f <= f2 ? f2 - f : f3 - (f - f2);
    }

    public static final float distance(float f, float f2, float f3) {
        return Math.min(sub(f, f2, f3), sub(f2, f, f3));
    }

    public static final float[] filterBetweenClockwise(float[] fArr, float f, float f2, float f3) {
        fArr.getClass();
        ArrayList arrayList = new ArrayList();
        for (float f4 : fArr) {
            if (isBetweenClockwise(f4, f, f2, f3)) {
                arrayList.add(Float.valueOf(f4));
            }
        }
        return CollectionsKt.toFloatArray(arrayList);
    }

    private static final float fixRoundingErrors(float f, float f2) {
        if (f < 0.0f || f >= f2) {
            return 0.0f;
        }
        return f;
    }

    public static final float halfStdevAnticlockwise(float[] fArr, float f, float f2) {
        fArr.getClass();
        return stdev(filterBetweenClockwise(fArr, opposite(f, f2), f, f2), f, f2);
    }

    public static final float halfStdevClockwise(float[] fArr, float f, float f2) {
        fArr.getClass();
        return stdev(filterBetweenClockwise(fArr, f, opposite(f, f2), f2), f, f2);
    }

    public static final boolean isBetweenClockwise(float f, float f2, float f3, float f4) {
        return clockwiseDistance(f2, f, f4) <= clockwiseDistance(f2, f3, f4);
    }

    public static final float median(float[] fArr, float f, float f2) {
        fArr.getClass();
        float fOpposite = opposite(f, f2);
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f3 : fArr) {
            arrayList.add(new Pair(Float.valueOf(f3), Float.valueOf(clockwiseDistance(fOpposite, f3, f2))));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.CyclicFloatKt$median$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Float) ((Pair) t).getSecond(), (Float) ((Pair) t2).getSecond());
            }
        });
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
        Iterator it = listSortedWith.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((Number) ((Pair) it.next()).getFirst()).floatValue()));
        }
        int size = arrayList2.size();
        if (size == 0) {
            return Float.NaN;
        }
        if (MoreMath.odd(size)) {
            return ((Number) arrayList2.get(size / 2)).floatValue();
        }
        int i = size / 2;
        return (((Number) arrayList2.get(i)).floatValue() + ((Number) arrayList2.get(i - 1)).floatValue()) / 2.0f;
    }

    public static final float normalize(float f, float f2) {
        if (f2 > 0.0f) {
            return f >= 0.0f ? f < f2 ? f : fixRoundingErrors(f - (((float) Math.floor(f / f2)) * f2), f2) : f > (-f2) ? fixRoundingErrors(f + f2, f2) : fixRoundingErrors((f2 + f) - (((float) Math.ceil(f / f2)) * f2), f2);
        }
        Events$$ExternalSyntheticBUOutline0.m("Cycle must be positive: ", f2);
        return 0.0f;
    }

    public static final float opposite(float f, float f2) {
        return normalize((f2 / 2.0f) + f, f2);
    }

    public static final float stdev(float[] fArr, float f, float f2) {
        fArr.getClass();
        if (fArr.length == 0) {
            return Float.NaN;
        }
        float f3 = 0.0f;
        for (float f4 : fArr) {
            float fDistance = distance(f4, f, f2);
            f3 += fDistance * fDistance;
        }
        return (float) Math.sqrt(f3 / fArr.length);
    }

    public static final float sub(float f, float f2, float f3) {
        return normalize(f - f2, f3);
    }

    public static final float stdev(float[] fArr, float f) {
        fArr.getClass();
        return stdev(fArr, center(fArr, f), f);
    }

    public static final float center(float[] fArr, float f) {
        fArr.getClass();
        if (fArr.length == 0) {
            return Float.NaN;
        }
        float fCenter = fArr[0];
        int length = fArr.length;
        for (int i = 1; i < length; i++) {
            fCenter = center(fCenter, i, fArr[i], 1.0f, f);
        }
        return fCenter;
    }

    public static final float median(float[] fArr, float f) {
        fArr.getClass();
        return median(fArr, center(fArr, f), f);
    }
}
