package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b \b\u0002\u0018\u00002\u00020\u0001B7\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJf\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0015\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0016\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019JJ\u0010\u001f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u001b\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u001c\u001a\u00060\u0002j\u0002`\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000bH\u0007¢\u0006\u0004\b#\u0010$R!\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b&\u0010'R!\u0010\u0005\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b(\u0010'R!\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b)\u0010'R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b+\u0010,R!\u0010\u001c\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001c\u0010%\u001a\u0004\b-\u0010'R!\u0010.\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b.\u0010%\u001a\u0004\b/\u0010'R\u0017\u00100\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u00104\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103R\u0017\u00106\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00103R\u0017\u00108\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103R\u0017\u0010:\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b:\u00101\u001a\u0004\b;\u00103R,\u0010<\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b<\u0010%\u001a\u0004\b=\u0010'\"\u0004\b>\u0010?R\u0011\u0010A\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b@\u00103\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/graphics/shapes/RoundedCorner;", "", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "p0", "p1", "p2", "Landroidx/graphics/shapes/CornerRounding;", "rounding", "<init>", "(JJJLandroidx/graphics/shapes/CornerRounding;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "allowedCut", "calculateActualSmoothingValue", "(F)F", "actualRoundCut", "actualSmoothingValues", "corner", "sideStart", "circleSegmentIntersection", "otherCircleSegmentIntersection", "circleCenter", "actualR", "Landroidx/graphics/shapes/Cubic;", "computeFlankingCurve-oAJzIJU", "(FFJJJJJF)Landroidx/graphics/shapes/Cubic;", "computeFlankingCurve", "d0", "d1", "lineIntersection-CBFvKDc", "(JJJJ)Landroidx/collection/FloatFloatPair;", "lineIntersection", "allowedCut0", "allowedCut1", "", "getCubics", "(FF)Ljava/util/List;", "J", "getP0-1ufDz9w", "()J", "getP1-1ufDz9w", "getP2-1ufDz9w", "Landroidx/graphics/shapes/CornerRounding;", "getRounding", "()Landroidx/graphics/shapes/CornerRounding;", "getD1-1ufDz9w", "d2", "getD2-1ufDz9w", "cornerRadius", "F", "getCornerRadius", "()F", "smoothing", "getSmoothing", "cosAngle", "getCosAngle", "sinAngle", "getSinAngle", "expectedRoundCut", "getExpectedRoundCut", "center", "getCenter-1ufDz9w", "setCenter-DnnuFBc", "(J)V", "getExpectedCut", "expectedCut", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RoundedCorner {
    private long center;
    private final float cornerRadius;
    private final float cosAngle;
    private final long d1;
    private final long d2;
    private final float expectedRoundCut;
    private final long p0;
    private final long p1;
    private final long p2;
    private final CornerRounding rounding;
    private final float sinAngle;
    private final float smoothing;

    private RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding) {
        this.p0 = j;
        this.p1 = j2;
        this.p2 = j3;
        this.rounding = cornerRounding;
        long jM76getDirectionDnnuFBc = PointKt.m76getDirectionDnnuFBc(PointKt.m81minusybeJwSQ(j, j2));
        this.d1 = jM76getDirectionDnnuFBc;
        long jM76getDirectionDnnuFBc2 = PointKt.m76getDirectionDnnuFBc(PointKt.m81minusybeJwSQ(j3, j2));
        this.d2 = jM76getDirectionDnnuFBc2;
        float radius = cornerRounding != null ? cornerRounding.getRadius() : 0.0f;
        this.cornerRadius = radius;
        this.smoothing = cornerRounding != null ? cornerRounding.getSmoothing() : 0.0f;
        float fM75dotProductybeJwSQ = PointKt.m75dotProductybeJwSQ(jM76getDirectionDnnuFBc, jM76getDirectionDnnuFBc2);
        this.cosAngle = fM75dotProductybeJwSQ;
        float fSqrt = (float) Math.sqrt(1.0f - Utils.square(fM75dotProductybeJwSQ));
        this.sinAngle = fSqrt;
        this.expectedRoundCut = ((double) fSqrt) > 0.001d ? ((fM75dotProductybeJwSQ + 1.0f) * radius) / fSqrt : 0.0f;
        this.center = FloatFloatPair.m43constructorimpl(0.0f, 0.0f);
    }

    private final float calculateActualSmoothingValue(float allowedCut) {
        if (allowedCut > getExpectedCut()) {
            return this.smoothing;
        }
        float f = this.expectedRoundCut;
        if (allowedCut <= f) {
            return 0.0f;
        }
        return ((allowedCut - f) * this.smoothing) / (getExpectedCut() - this.expectedRoundCut);
    }

    /* JADX INFO: renamed from: computeFlankingCurve-oAJzIJU, reason: not valid java name */
    private final Cubic m86computeFlankingCurveoAJzIJU(float actualRoundCut, float actualSmoothingValues, long corner, long sideStart, long circleSegmentIntersection, long otherCircleSegmentIntersection, long circleCenter, float actualR) {
        long jM76getDirectionDnnuFBc = PointKt.m76getDirectionDnnuFBc(PointKt.m81minusybeJwSQ(sideStart, corner));
        long jM82plusybeJwSQ = PointKt.m82plusybeJwSQ(corner, PointKt.m83timesso9K2fw(PointKt.m83timesso9K2fw(jM76getDirectionDnnuFBc, actualRoundCut), 1.0f + actualSmoothingValues));
        long packedValue = circleSegmentIntersection;
        long jM80interpolatedLqxh1s = PointKt.m80interpolatedLqxh1s(packedValue, PointKt.m73divso9K2fw(PointKt.m82plusybeJwSQ(circleSegmentIntersection, otherCircleSegmentIntersection), 2.0f), actualSmoothingValues);
        long jM82plusybeJwSQ2 = PointKt.m82plusybeJwSQ(circleCenter, PointKt.m83timesso9K2fw(Utils.directionVector(PointKt.m78getXDnnuFBc(jM80interpolatedLqxh1s) - PointKt.m78getXDnnuFBc(circleCenter), PointKt.m79getYDnnuFBc(jM80interpolatedLqxh1s) - PointKt.m79getYDnnuFBc(circleCenter)), actualR));
        FloatFloatPair floatFloatPairM87lineIntersectionCBFvKDc = m87lineIntersectionCBFvKDc(sideStart, jM76getDirectionDnnuFBc, jM82plusybeJwSQ2, Utils.m91rotate90DnnuFBc(PointKt.m81minusybeJwSQ(jM82plusybeJwSQ2, circleCenter)));
        if (floatFloatPairM87lineIntersectionCBFvKDc != null) {
            packedValue = floatFloatPairM87lineIntersectionCBFvKDc.getPackedValue();
        }
        return new Cubic(jM82plusybeJwSQ, PointKt.m73divso9K2fw(PointKt.m82plusybeJwSQ(jM82plusybeJwSQ, PointKt.m83timesso9K2fw(packedValue, 2.0f)), 3.0f), packedValue, jM82plusybeJwSQ2, null);
    }

    /* JADX INFO: renamed from: lineIntersection-CBFvKDc, reason: not valid java name */
    private final FloatFloatPair m87lineIntersectionCBFvKDc(long p0, long d0, long p1, long d1) {
        long jM91rotate90DnnuFBc = Utils.m91rotate90DnnuFBc(d1);
        float fM75dotProductybeJwSQ = PointKt.m75dotProductybeJwSQ(d0, jM91rotate90DnnuFBc);
        if (Math.abs(fM75dotProductybeJwSQ) < 1.0E-4f) {
            return null;
        }
        float fM75dotProductybeJwSQ2 = PointKt.m75dotProductybeJwSQ(PointKt.m81minusybeJwSQ(p1, p0), jM91rotate90DnnuFBc);
        if (Math.abs(fM75dotProductybeJwSQ) < Math.abs(fM75dotProductybeJwSQ2) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m42boximpl(PointKt.m82plusybeJwSQ(p0, PointKt.m83timesso9K2fw(d0, fM75dotProductybeJwSQ2 / fM75dotProductybeJwSQ)));
    }

    /* JADX INFO: renamed from: getCenter-1ufDz9w, reason: not valid java name and from getter */
    public final long getCenter() {
        return this.center;
    }

    public final List<Cubic> getCubics(float allowedCut0, float allowedCut1) {
        float fMin = Math.min(allowedCut0, allowedCut1);
        float f = this.expectedRoundCut;
        if (f < 1.0E-4f || fMin < 1.0E-4f || this.cornerRadius < 1.0E-4f) {
            long j = this.p1;
            this.center = j;
            return CollectionsKt.listOf(Cubic.INSTANCE.straightLine(PointKt.m78getXDnnuFBc(j), PointKt.m79getYDnnuFBc(this.p1), PointKt.m78getXDnnuFBc(this.p1), PointKt.m79getYDnnuFBc(this.p1)));
        }
        float fMin2 = Math.min(fMin, f);
        float fCalculateActualSmoothingValue = calculateActualSmoothingValue(allowedCut0);
        float fCalculateActualSmoothingValue2 = calculateActualSmoothingValue(allowedCut1);
        float f2 = (this.cornerRadius * fMin2) / this.expectedRoundCut;
        this.center = PointKt.m82plusybeJwSQ(this.p1, PointKt.m83timesso9K2fw(PointKt.m76getDirectionDnnuFBc(PointKt.m73divso9K2fw(PointKt.m82plusybeJwSQ(this.d1, this.d2), 2.0f)), (float) Math.sqrt(Utils.square(fMin2) + Utils.square(f2))));
        long jM82plusybeJwSQ = PointKt.m82plusybeJwSQ(this.p1, PointKt.m83timesso9K2fw(this.d1, fMin2));
        long jM82plusybeJwSQ2 = PointKt.m82plusybeJwSQ(this.p1, PointKt.m83timesso9K2fw(this.d2, fMin2));
        Cubic cubicM86computeFlankingCurveoAJzIJU = m86computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue, this.p1, this.p0, jM82plusybeJwSQ, jM82plusybeJwSQ2, this.center, f2);
        Cubic cubicReverse = m86computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue2, this.p1, this.p2, jM82plusybeJwSQ2, jM82plusybeJwSQ, this.center, f2).reverse();
        return CollectionsKt.listOf((Object[]) new Cubic[]{cubicM86computeFlankingCurveoAJzIJU, Cubic.INSTANCE.circularArc(PointKt.m78getXDnnuFBc(this.center), PointKt.m79getYDnnuFBc(this.center), cubicM86computeFlankingCurveoAJzIJU.getAnchor1X(), cubicM86computeFlankingCurveoAJzIJU.getAnchor1Y(), cubicReverse.getAnchor0X(), cubicReverse.getAnchor0Y()), cubicReverse});
    }

    public final float getExpectedCut() {
        return (1.0f + this.smoothing) * this.expectedRoundCut;
    }

    public final float getExpectedRoundCut() {
        return this.expectedRoundCut;
    }

    public /* synthetic */ RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, cornerRounding);
    }
}
