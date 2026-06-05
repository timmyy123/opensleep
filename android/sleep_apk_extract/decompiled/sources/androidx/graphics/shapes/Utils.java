package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a#\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\u0004\u001a4\u0010\u0011\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u00060\u0006j\u0002`\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0014\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001e\u0010\u0004\u001a1\u0010$\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"H\u0000¢\u0006\u0004\b$\u0010%\"\u001e\u0010&\u001a\u00060\u0006j\u0002`\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u001a\u0010*\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u001a\u0010.\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"", "x", "y", "distance", "(FF)F", "distanceSquared", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "directionVector", "(FF)J", "angleRadians", "(F)J", "angle", "radius", "center", "radialToCartesian-L6JJ3z0", "(FFJ)J", "radialToCartesian", "rotate90-DnnuFBc", "(J)J", "rotate90", "square", "(F)F", "start", "stop", "fraction", "interpolate", "(FFF)F", "num", "mod", "positiveModulo", "v0", "v1", "tolerance", "Landroidx/graphics/shapes/FindMinimumFunction;", "f", "findMinimum", "(FFFLandroidx/graphics/shapes/FindMinimumFunction;)F", "Zero", "J", "getZero", "()J", "FloatPi", "F", "getFloatPi", "()F", "TwoPi", "getTwoPi", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public abstract class Utils {
    private static final long Zero = FloatFloatPair.m43constructorimpl(0.0f, 0.0f);
    private static final float FloatPi = 3.1415927f;
    private static final float TwoPi = 6.2831855f;

    public static final float angle(float f, float f2) {
        float fAtan2 = (float) Math.atan2(f2, f);
        float f3 = TwoPi;
        return (fAtan2 + f3) % f3;
    }

    public static final long directionVector(float f, float f2) {
        float fDistance = distance(f, f2);
        if (fDistance > 0.0f) {
            return FloatFloatPair.m43constructorimpl(f / fDistance, f2 / fDistance);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Required distance greater than zero");
        return 0L;
    }

    public static final float distance(float f, float f2) {
        return (float) Math.sqrt((f2 * f2) + (f * f));
    }

    public static final float distanceSquared(float f, float f2) {
        return (f2 * f2) + (f * f);
    }

    public static final float findMinimum(float f, float f2, float f3, FindMinimumFunction findMinimumFunction) {
        findMinimumFunction.getClass();
        while (f2 - f > f3) {
            float f4 = ((2.0f * f) + f2) / 3.0f;
            float f5 = ((2.0f * f2) + f) / 3.0f;
            AngleMeasurer$$ExternalSyntheticLambda0 angleMeasurer$$ExternalSyntheticLambda0 = (AngleMeasurer$$ExternalSyntheticLambda0) findMinimumFunction;
            if (angleMeasurer$$ExternalSyntheticLambda0.invoke(f4) < angleMeasurer$$ExternalSyntheticLambda0.invoke(f5)) {
                f2 = f5;
            } else {
                f = f4;
            }
        }
        return (f + f2) / 2.0f;
    }

    public static final float getFloatPi() {
        return FloatPi;
    }

    public static final float getTwoPi() {
        return TwoPi;
    }

    public static final float interpolate(float f, float f2, float f3) {
        return (f3 * f2) + ((1.0f - f3) * f);
    }

    public static final float positiveModulo(float f, float f2) {
        return ((f % f2) + f2) % f2;
    }

    /* JADX INFO: renamed from: radialToCartesian-L6JJ3z0, reason: not valid java name */
    public static final long m89radialToCartesianL6JJ3z0(float f, float f2, long j) {
        return PointKt.m82plusybeJwSQ(PointKt.m83timesso9K2fw(directionVector(f2), f), j);
    }

    /* JADX INFO: renamed from: radialToCartesian-L6JJ3z0$default, reason: not valid java name */
    public static /* synthetic */ long m90radialToCartesianL6JJ3z0$default(float f, float f2, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Zero;
        }
        return m89radialToCartesianL6JJ3z0(f, f2, j);
    }

    /* JADX INFO: renamed from: rotate90-DnnuFBc, reason: not valid java name */
    public static final long m91rotate90DnnuFBc(long j) {
        return FloatFloatPair.m43constructorimpl(-PointKt.m79getYDnnuFBc(j), PointKt.m78getXDnnuFBc(j));
    }

    public static final float square(float f) {
        return f * f;
    }

    public static final long directionVector(float f) {
        double d = f;
        return FloatFloatPair.m43constructorimpl((float) Math.cos(d), (float) Math.sin(d));
    }
}
