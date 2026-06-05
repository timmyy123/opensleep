package androidx.graphics.shapes;

import kotlin.Metadata;
import org.achartengine.chart.CubicLineChart;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003*\n\u0010\u000b\"\u00020\f2\u00020\f¨\u0006\r"}, d2 = {CubicLineChart.TYPE, "Landroidx/graphics/shapes/Cubic;", "anchor0X", "", "anchor0Y", "control0X", "control0Y", "control1X", "control1Y", "anchor1X", "anchor1Y", "TransformResult", "Landroidx/collection/FloatFloatPair;", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public abstract class CubicKt {
    public static final Cubic Cubic(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return new Cubic(new float[]{f, f2, f3, f4, f5, f6, f7, f8});
    }
}
