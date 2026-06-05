package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DeterminateDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                ((ViewPropertyAnimatorUpdateListener) obj2).onAnimationUpdate((View) obj);
                break;
            case 1:
                ((AppBarLayout) obj2).lambda$initializeLiftOnScrollWithElevation$1((MaterialShapeDrawable) obj, valueAnimator);
                break;
            default:
                ((DeterminateDrawable) obj2).lambda$new$0((BaseProgressIndicatorSpec) obj, valueAnimator);
                break;
        }
    }
}
