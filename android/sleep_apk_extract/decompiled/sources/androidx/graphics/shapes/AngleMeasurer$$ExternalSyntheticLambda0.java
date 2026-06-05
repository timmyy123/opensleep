package androidx.graphics.shapes;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AngleMeasurer$$ExternalSyntheticLambda0 implements FindMinimumFunction {
    public final /* synthetic */ Cubic f$0;
    public final /* synthetic */ AngleMeasurer f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ float f$3;

    public /* synthetic */ AngleMeasurer$$ExternalSyntheticLambda0(Cubic cubic, AngleMeasurer angleMeasurer, float f, float f2) {
        this.f$0 = cubic;
        this.f$1 = angleMeasurer;
        this.f$2 = f;
        this.f$3 = f2;
    }

    public final float invoke(float f) {
        return AngleMeasurer.findCubicCutPoint$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, f);
    }
}
