package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001a\u0010\u0005\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a&\u0010\t\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00012\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a*\u0010\t\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00012\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a&\u0010\u0011\u001a\u00020\u000e*\u00060\u0000j\u0002`\u00012\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0014\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0017\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0001H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a+\u0010\u0019\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0001H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016\u001a'\u0010\u001d\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u001a\u001a\u00020\u0002H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a'\u0010\u001f\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u001a\u001a\u00020\u0002H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001c\u001a6\u0010%\u001a\u00060\u0000j\u0002`\u00012\n\u0010 \u001a\u00060\u0000j\u0002`\u00012\n\u0010!\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\"\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a&\u0010*\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010'\u001a\u00020&H\u0000ø\u0001\u0000¢\u0006\u0004\b(\u0010)\"\u001c\u0010,\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0004\"\u001c\u0010.\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0004*\f\b\u0000\u0010/\"\u00020\u00002\u00020\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "", "getDistance-DnnuFBc", "(J)F", "getDistance", "other", "dotProduct-ybeJwSQ", "(JJ)F", "dotProduct", "otherX", "otherY", "dotProduct-5P9i7ZU", "(JFF)F", "", "clockwise-ybeJwSQ", "(JJ)Z", "clockwise", "getDirection-DnnuFBc", "(J)J", "getDirection", "minus-ybeJwSQ", "(JJ)J", "minus", "plus-ybeJwSQ", "plus", "operand", "times-so9K2fw", "(JF)J", "times", "div-so9K2fw", "div", "start", "stop", "fraction", "interpolate-dLqxh1s", "(JJF)J", "interpolate", "Landroidx/graphics/shapes/PointTransformer;", "f", "transformed-so9K2fw", "(JLandroidx/graphics/shapes/PointTransformer;)J", "transformed", "getX-DnnuFBc", "x", "getY-DnnuFBc", "y", "Point", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public abstract class PointKt {
    /* JADX INFO: renamed from: clockwise-ybeJwSQ, reason: not valid java name */
    public static final boolean m72clockwiseybeJwSQ(long j, long j2) {
        return (m79getYDnnuFBc(j2) * m78getXDnnuFBc(j)) - (m78getXDnnuFBc(j2) * m79getYDnnuFBc(j)) > 0.0f;
    }

    /* JADX INFO: renamed from: div-so9K2fw, reason: not valid java name */
    public static final long m73divso9K2fw(long j, float f) {
        return FloatFloatPair.m43constructorimpl(m78getXDnnuFBc(j) / f, m79getYDnnuFBc(j) / f);
    }

    /* JADX INFO: renamed from: dotProduct-5P9i7ZU, reason: not valid java name */
    public static final float m74dotProduct5P9i7ZU(long j, float f, float f2) {
        return (m79getYDnnuFBc(j) * f2) + (m78getXDnnuFBc(j) * f);
    }

    /* JADX INFO: renamed from: dotProduct-ybeJwSQ, reason: not valid java name */
    public static final float m75dotProductybeJwSQ(long j, long j2) {
        return (m79getYDnnuFBc(j2) * m79getYDnnuFBc(j)) + (m78getXDnnuFBc(j2) * m78getXDnnuFBc(j));
    }

    /* JADX INFO: renamed from: getDirection-DnnuFBc, reason: not valid java name */
    public static final long m76getDirectionDnnuFBc(long j) {
        float fM77getDistanceDnnuFBc = m77getDistanceDnnuFBc(j);
        if (fM77getDistanceDnnuFBc > 0.0f) {
            return m73divso9K2fw(j, fM77getDistanceDnnuFBc);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Can't get the direction of a 0-length vector");
        return 0L;
    }

    /* JADX INFO: renamed from: getDistance-DnnuFBc, reason: not valid java name */
    public static final float m77getDistanceDnnuFBc(long j) {
        return (float) Math.sqrt((m79getYDnnuFBc(j) * m79getYDnnuFBc(j)) + (m78getXDnnuFBc(j) * m78getXDnnuFBc(j)));
    }

    /* JADX INFO: renamed from: getX-DnnuFBc, reason: not valid java name */
    public static final float m78getXDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getY-DnnuFBc, reason: not valid java name */
    public static final float m79getYDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: interpolate-dLqxh1s, reason: not valid java name */
    public static final long m80interpolatedLqxh1s(long j, long j2, float f) {
        return FloatFloatPair.m43constructorimpl(Utils.interpolate(m78getXDnnuFBc(j), m78getXDnnuFBc(j2), f), Utils.interpolate(m79getYDnnuFBc(j), m79getYDnnuFBc(j2), f));
    }

    /* JADX INFO: renamed from: minus-ybeJwSQ, reason: not valid java name */
    public static final long m81minusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m43constructorimpl(m78getXDnnuFBc(j) - m78getXDnnuFBc(j2), m79getYDnnuFBc(j) - m79getYDnnuFBc(j2));
    }

    /* JADX INFO: renamed from: plus-ybeJwSQ, reason: not valid java name */
    public static final long m82plusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m43constructorimpl(m78getXDnnuFBc(j2) + m78getXDnnuFBc(j), m79getYDnnuFBc(j2) + m79getYDnnuFBc(j));
    }

    /* JADX INFO: renamed from: times-so9K2fw, reason: not valid java name */
    public static final long m83timesso9K2fw(long j, float f) {
        return FloatFloatPair.m43constructorimpl(m78getXDnnuFBc(j) * f, m79getYDnnuFBc(j) * f);
    }

    /* JADX INFO: renamed from: transformed-so9K2fw, reason: not valid java name */
    public static final long m84transformedso9K2fw(long j, PointTransformer pointTransformer) {
        pointTransformer.getClass();
        long jMo85transformXgqJiTY = pointTransformer.mo85transformXgqJiTY(m78getXDnnuFBc(j), m79getYDnnuFBc(j));
        return FloatFloatPair.m43constructorimpl(Float.intBitsToFloat((int) (jMo85transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (jMo85transformXgqJiTY & 4294967295L)));
    }
}
