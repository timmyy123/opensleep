package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\b\u0016\u0018\u0000 E2\u00020\u0001:\u0001EB\u0013\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B9\b\u0010\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\t\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u0004\u0010\fJ!\u0010\u0011\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u001c2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0000¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\rH\u0002¢\u0006\u0004\b/\u00100R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u00103R\u0011\u00106\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00108\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b7\u00105R\u0011\u0010:\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b9\u00105R\u0011\u0010<\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b;\u00105R\u0011\u0010>\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b=\u00105R\u0011\u0010@\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b?\u00105R\u0011\u0010B\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bA\u00105R\u0011\u0010D\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bC\u00105\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"Landroidx/graphics/shapes/Cubic;", "", "", "points", "<init>", "([F)V", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "anchor0", "control0", "control1", "anchor1", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "t", "pointOnCurve-OOQOV4g$graphics_shapes_release", "(F)J", "pointOnCurve", "", "zeroLength$graphics_shapes_release", "()Z", "zeroLength", "bounds", "approximate", "", "calculateBounds$graphics_shapes_release", "([FZ)V", "calculateBounds", "Lkotlin/Pair;", "split", "(F)Lkotlin/Pair;", "reverse", "()Landroidx/graphics/shapes/Cubic;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/graphics/shapes/PointTransformer;", "f", "transformed", "(Landroidx/graphics/shapes/PointTransformer;)Landroidx/graphics/shapes/Cubic;", "", "hashCode", "()I", SDKConstants.PARAM_VALUE, "zeroIsh", "(F)Z", "[F", "getPoints$graphics_shapes_release", "()[F", "getAnchor0X", "()F", "anchor0X", "getAnchor0Y", "anchor0Y", "getControl0X", "control0X", "getControl0Y", "control0Y", "getControl1X", "control1X", "getControl1Y", "control1Y", "getAnchor1X", "anchor1X", "getAnchor1Y", "anchor1Y", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class Cubic {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float[] points;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J(\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Landroidx/graphics/shapes/Cubic$Companion;", "", "()V", "circularArc", "Landroidx/graphics/shapes/Cubic;", "centerX", "", "centerY", "x0", "y0", "x1", "y1", "straightLine", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Cubic circularArc(float centerX, float centerY, float x0, float y0, float x1, float y1) {
            float f = x0 - centerX;
            float f2 = y0 - centerY;
            long jDirectionVector = Utils.directionVector(f, f2);
            float f3 = x1 - centerX;
            float f4 = y1 - centerY;
            long jDirectionVector2 = Utils.directionVector(f3, f4);
            long jM91rotate90DnnuFBc = Utils.m91rotate90DnnuFBc(jDirectionVector);
            long jM91rotate90DnnuFBc2 = Utils.m91rotate90DnnuFBc(jDirectionVector2);
            boolean z = PointKt.m74dotProduct5P9i7ZU(jM91rotate90DnnuFBc, f3, f4) >= 0.0f;
            float fM75dotProductybeJwSQ = PointKt.m75dotProductybeJwSQ(jDirectionVector, jDirectionVector2);
            if (fM75dotProductybeJwSQ > 0.999f) {
                return straightLine(x0, y0, x1, y1);
            }
            float fSqrt = (((((float) Math.sqrt(2.0f * r5)) - ((float) Math.sqrt(1.0f - (fM75dotProductybeJwSQ * fM75dotProductybeJwSQ)))) * ((Utils.distance(f, f2) * 4.0f) / 3.0f)) / (1.0f - fM75dotProductybeJwSQ)) * (z ? 1.0f : -1.0f);
            return CubicKt.Cubic(x0, y0, (PointKt.m78getXDnnuFBc(jM91rotate90DnnuFBc) * fSqrt) + x0, (PointKt.m79getYDnnuFBc(jM91rotate90DnnuFBc) * fSqrt) + y0, x1 - (PointKt.m78getXDnnuFBc(jM91rotate90DnnuFBc2) * fSqrt), y1 - (PointKt.m79getYDnnuFBc(jM91rotate90DnnuFBc2) * fSqrt), x1, y1);
        }

        public final Cubic straightLine(float x0, float y0, float x1, float y1) {
            return CubicKt.Cubic(x0, y0, Utils.interpolate(x0, x1, 0.33333334f), Utils.interpolate(y0, y1, 0.33333334f), Utils.interpolate(x0, x1, 0.6666667f), Utils.interpolate(y0, y1, 0.6666667f), x1, y1);
        }

        private Companion() {
        }
    }

    private Cubic(long j, long j2, long j3, long j4) {
        this(new float[]{PointKt.m78getXDnnuFBc(j), PointKt.m79getYDnnuFBc(j), PointKt.m78getXDnnuFBc(j2), PointKt.m79getYDnnuFBc(j2), PointKt.m78getXDnnuFBc(j3), PointKt.m79getYDnnuFBc(j3), PointKt.m78getXDnnuFBc(j4), PointKt.m79getYDnnuFBc(j4)});
    }

    private final boolean zeroIsh(float value) {
        return Math.abs(value) < 1.0E-4f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c5  */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void calculateBounds$graphics_shapes_release(float[] bounds, boolean approximate) {
        char c;
        char c2;
        char c3;
        boolean z;
        float anchor1Y;
        ?? r23;
        bounds.getClass();
        if (zeroLength$graphics_shapes_release()) {
            bounds[0] = getAnchor0X();
            bounds[1] = getAnchor0Y();
            bounds[2] = getAnchor0X();
            bounds[3] = getAnchor0Y();
            return;
        }
        float fMin = Math.min(getAnchor0X(), getAnchor1X());
        float fMin2 = Math.min(getAnchor0Y(), getAnchor1Y());
        float fMax = Math.max(getAnchor0X(), getAnchor1X());
        float fMax2 = Math.max(getAnchor0Y(), getAnchor1Y());
        if (approximate) {
            bounds[0] = Math.min(fMin, Math.min(getControl0X(), getControl1X()));
            bounds[1] = Math.min(fMin2, Math.min(getControl0Y(), getControl1Y()));
            bounds[2] = Math.max(fMax, Math.max(getControl0X(), getControl1X()));
            bounds[3] = Math.max(fMax2, Math.max(getControl0Y(), getControl1Y()));
            return;
        }
        float anchor1X = getAnchor1X() + (((getControl0X() * 3.0f) + (-getAnchor0X())) - (getControl1X() * 3.0f));
        float control1X = (getControl1X() * 2.0f) + ((getAnchor0X() * 2.0f) - (getControl0X() * 4.0f));
        float control0X = getControl0X() + (-getAnchor0X());
        if (!zeroIsh(anchor1X)) {
            float f = (control1X * control1X) - ((4.0f * anchor1X) * control0X);
            if (f >= 0.0f) {
                float f2 = -control1X;
                c = 3;
                c2 = 2;
                double d = f;
                c3 = 1;
                z = false;
                float f3 = anchor1X * 2.0f;
                float fSqrt = (((float) Math.sqrt(d)) + f2) / f3;
                if (0.0f <= fSqrt && fSqrt <= 1.0f) {
                    float fM78getXDnnuFBc = PointKt.m78getXDnnuFBc(m71pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt));
                    if (fM78getXDnnuFBc < fMin) {
                        fMin = fM78getXDnnuFBc;
                    }
                    if (fM78getXDnnuFBc > fMax) {
                        fMax = fM78getXDnnuFBc;
                    }
                }
                float fSqrt2 = (f2 - ((float) Math.sqrt(d))) / f3;
                if (0.0f <= fSqrt2 && fSqrt2 <= 1.0f) {
                    float fM78getXDnnuFBc2 = PointKt.m78getXDnnuFBc(m71pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt2));
                    if (fM78getXDnnuFBc2 < fMin) {
                        fMin = fM78getXDnnuFBc2;
                    }
                    if (fM78getXDnnuFBc2 > fMax) {
                        fMax = fM78getXDnnuFBc2;
                    }
                }
            }
            anchor1Y = getAnchor1Y() + (((getControl0Y() * 3.0f) + (-getAnchor0Y())) - (getControl1Y() * 3.0f));
            float control1Y = (getControl1Y() * 2.0f) + ((getAnchor0Y() * 2.0f) - (getControl0Y() * 4.0f));
            float control0Y = getControl0Y() + (-getAnchor0Y());
            if (zeroIsh(anchor1Y)) {
                float f4 = (control1Y * control1Y) - ((4.0f * anchor1Y) * control0Y);
                if (f4 >= 0.0f) {
                    float f5 = -control1Y;
                    double d2 = f4;
                    boolean z2 = z;
                    float f6 = 2.0f * anchor1Y;
                    float fSqrt3 = (((float) Math.sqrt(d2)) + f5) / f6;
                    if (0.0f <= fSqrt3 && fSqrt3 <= 1.0f) {
                        float fM79getYDnnuFBc = PointKt.m79getYDnnuFBc(m71pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt3));
                        if (fM79getYDnnuFBc < fMin2) {
                            fMin2 = fM79getYDnnuFBc;
                        }
                        if (fM79getYDnnuFBc > fMax2) {
                            fMax2 = fM79getYDnnuFBc;
                        }
                    }
                    float fSqrt4 = (f5 - ((float) Math.sqrt(d2))) / f6;
                    r23 = z2;
                    if (0.0f <= fSqrt4) {
                        r23 = z2;
                        if (fSqrt4 <= 1.0f) {
                            float fM79getYDnnuFBc2 = PointKt.m79getYDnnuFBc(m71pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt4));
                            if (fM79getYDnnuFBc2 < fMin2) {
                                fMin2 = fM79getYDnnuFBc2;
                            }
                            r23 = z2;
                            if (fM79getYDnnuFBc2 > fMax2) {
                                fMax2 = fM79getYDnnuFBc2;
                                r23 = z2;
                            }
                        }
                    }
                }
                bounds[r23] = fMin;
                bounds[c3] = fMin2;
                bounds[c2] = fMax;
                bounds[c] = fMax2;
            }
            if (control1Y != 0.0f) {
                float f7 = (2.0f * control0Y) / ((-2.0f) * control1Y);
                if (0.0f <= f7 && f7 <= 1.0f) {
                    float fM79getYDnnuFBc3 = PointKt.m79getYDnnuFBc(m71pointOnCurveOOQOV4g$graphics_shapes_release(f7));
                    if (fM79getYDnnuFBc3 < fMin2) {
                        fMin2 = fM79getYDnnuFBc3;
                    }
                    if (fM79getYDnnuFBc3 > fMax2) {
                        fMax2 = fM79getYDnnuFBc3;
                    }
                }
            }
            r23 = z;
            bounds[r23] = fMin;
            bounds[c3] = fMin2;
            bounds[c2] = fMax;
            bounds[c] = fMax2;
        }
        if (control1X != 0.0f) {
            float f8 = (control0X * 2.0f) / (control1X * (-2.0f));
            if (0.0f <= f8 && f8 <= 1.0f) {
                float fM78getXDnnuFBc3 = PointKt.m78getXDnnuFBc(m71pointOnCurveOOQOV4g$graphics_shapes_release(f8));
                if (fM78getXDnnuFBc3 < fMin) {
                    fMin = fM78getXDnnuFBc3;
                }
                if (fM78getXDnnuFBc3 > fMax) {
                    fMax = fM78getXDnnuFBc3;
                }
            }
        }
        c = 3;
        c2 = 2;
        c3 = 1;
        z = false;
        anchor1Y = getAnchor1Y() + (((getControl0Y() * 3.0f) + (-getAnchor0Y())) - (getControl1Y() * 3.0f));
        float control1Y2 = (getControl1Y() * 2.0f) + ((getAnchor0Y() * 2.0f) - (getControl0Y() * 4.0f));
        float control0Y2 = getControl0Y() + (-getAnchor0Y());
        if (zeroIsh(anchor1Y)) {
        }
        r23 = z;
        bounds[r23] = fMin;
        bounds[c3] = fMin2;
        bounds[c2] = fMax;
        bounds[c] = fMax2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Cubic) {
            return Arrays.equals(this.points, ((Cubic) other).points);
        }
        return false;
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    /* JADX INFO: renamed from: getPoints$graphics_shapes_release, reason: from getter */
    public final float[] getPoints() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    /* JADX INFO: renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release, reason: not valid java name */
    public final long m71pointOnCurveOOQOV4g$graphics_shapes_release(float t) {
        float f = 1.0f - t;
        float f2 = f * f * f;
        float f3 = 3.0f * t;
        float f4 = f3 * f * f;
        float f5 = f3 * t * f;
        float control1X = (getControl1X() * f5) + (getControl0X() * f4) + (getAnchor0X() * f2);
        float f6 = t * t * t;
        return FloatFloatPair.m43constructorimpl((getAnchor1X() * f6) + control1X, (getAnchor1Y() * f6) + (getControl1Y() * f5) + (getControl0Y() * f4) + (getAnchor0Y() * f2));
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final Pair<Cubic, Cubic> split(float t) {
        float f = 1.0f - t;
        long jM71pointOnCurveOOQOV4g$graphics_shapes_release = m71pointOnCurveOOQOV4g$graphics_shapes_release(t);
        float f2 = f * f;
        float f3 = 2.0f * f * t;
        float f4 = t * t;
        return TuplesKt.to(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f) + (getControl0X() * t), (getAnchor0Y() * f) + (getControl0Y() * t), (getControl1X() * f4) + (getControl0X() * f3) + (getAnchor0X() * f2), (getControl1Y() * f4) + (getControl0Y() * f3) + (getAnchor0Y() * f2), PointKt.m78getXDnnuFBc(jM71pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m79getYDnnuFBc(jM71pointOnCurveOOQOV4g$graphics_shapes_release)), CubicKt.Cubic(PointKt.m78getXDnnuFBc(jM71pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m79getYDnnuFBc(jM71pointOnCurveOOQOV4g$graphics_shapes_release), (getAnchor1X() * f4) + (getControl1X() * f3) + (getControl0X() * f2), (getAnchor1Y() * f4) + (getControl1Y() * f3) + (getControl0Y() * f2), (getAnchor1X() * t) + (getControl1X() * f), (getAnchor1Y() * t) + (getControl1Y() * f), getAnchor1X(), getAnchor1Y()));
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public final Cubic transformed(PointTransformer f) {
        f.getClass();
        MutableCubic mutableCubic = new MutableCubic();
        ArraysKt___ArraysJvmKt.copyInto$default(this.points, mutableCubic.getPoints(), 0, 0, 0, 14, (Object) null);
        mutableCubic.transform(f);
        return mutableCubic;
    }

    public final boolean zeroLength$graphics_shapes_release() {
        return Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f;
    }

    public Cubic(float[] fArr) {
        fArr.getClass();
        this.points = fArr;
        if (fArr.length == 8) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Points array size should be 8");
        throw null;
    }

    public /* synthetic */ Cubic(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new float[8] : fArr);
    }

    public /* synthetic */ Cubic(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }
}
