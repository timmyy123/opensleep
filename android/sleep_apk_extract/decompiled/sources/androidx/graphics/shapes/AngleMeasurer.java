package androidx.graphics.shapes;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/graphics/shapes/AngleMeasurer;", "Landroidx/graphics/shapes/Measurer;", "", "centerX", "centerY", "<init>", "(FF)V", "Landroidx/graphics/shapes/Cubic;", "c", "measureCubic", "(Landroidx/graphics/shapes/Cubic;)F", "m", "findCubicCutPoint", "(Landroidx/graphics/shapes/Cubic;F)F", "F", "getCenterX", "()F", "getCenterY", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AngleMeasurer implements Measurer {
    private final float centerX;
    private final float centerY;

    public AngleMeasurer(float f, float f2) {
        this.centerX = f;
        this.centerY = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float findCubicCutPoint$lambda$1(Cubic cubic, AngleMeasurer angleMeasurer, float f, float f2, float f3) {
        cubic.getClass();
        angleMeasurer.getClass();
        long jM71pointOnCurveOOQOV4g$graphics_shapes_release = cubic.m71pointOnCurveOOQOV4g$graphics_shapes_release(f3);
        return Math.abs(Utils.positiveModulo(Utils.angle(PointKt.m78getXDnnuFBc(jM71pointOnCurveOOQOV4g$graphics_shapes_release) - angleMeasurer.centerX, PointKt.m79getYDnnuFBc(jM71pointOnCurveOOQOV4g$graphics_shapes_release) - angleMeasurer.centerY) - f, Utils.getTwoPi()) - f2);
    }

    @Override // androidx.graphics.shapes.Measurer
    public float findCubicCutPoint(Cubic c, float m) {
        c.getClass();
        return Utils.findMinimum(0.0f, 1.0f, 1.0E-5f, new AngleMeasurer$$ExternalSyntheticLambda0(c, this, Utils.angle(c.getAnchor0X() - this.centerX, c.getAnchor0Y() - this.centerY), m));
    }

    @Override // androidx.graphics.shapes.Measurer
    public float measureCubic(Cubic c) {
        c.getClass();
        float fPositiveModulo = Utils.positiveModulo(Utils.angle(c.getAnchor1X() - this.centerX, c.getAnchor1Y() - this.centerY) - Utils.angle(c.getAnchor0X() - this.centerX, c.getAnchor0Y() - this.centerY), Utils.getTwoPi());
        if (fPositiveModulo > Utils.getTwoPi() - 1.0E-4f) {
            return 0.0f;
        }
        return fPositiveModulo;
    }
}
