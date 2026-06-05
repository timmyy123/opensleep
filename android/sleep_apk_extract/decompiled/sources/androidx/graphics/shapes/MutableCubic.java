package androidx.graphics.shapes;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/graphics/shapes/MutableCubic;", "Landroidx/graphics/shapes/Cubic;", "<init>", "()V", "Landroidx/graphics/shapes/PointTransformer;", "f", "", "ix", "", "transformOnePoint", "(Landroidx/graphics/shapes/PointTransformer;I)V", "transform", "(Landroidx/graphics/shapes/PointTransformer;)V", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableCubic extends Cubic {
    public MutableCubic() {
        super(null, 1, null);
    }

    private final void transformOnePoint(PointTransformer f, int ix) {
        int i = ix + 1;
        long jMo85transformXgqJiTY = f.mo85transformXgqJiTY(getPoints()[ix], getPoints()[i]);
        getPoints()[ix] = Float.intBitsToFloat((int) (jMo85transformXgqJiTY >> 32));
        getPoints()[i] = Float.intBitsToFloat((int) (4294967295L & jMo85transformXgqJiTY));
    }

    public final void transform(PointTransformer f) {
        f.getClass();
        transformOnePoint(f, 0);
        transformOnePoint(f, 2);
        transformOnePoint(f, 4);
        transformOnePoint(f, 6);
    }
}
