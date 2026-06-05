package com.urbandroid.sleep.gui;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.DrawerLayoutUtils;
import com.google.android.material.progressindicator.DeterminateDrawable;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SquigglyProgress$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SquigglyProgress$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                SquigglyProgress._set_animate_$lambda$0$0((SquigglyProgress) obj, valueAnimator);
                break;
            case 1:
                DrawerLayoutUtils.lambda$getScrimCloseAnimatorUpdateListener$0((DrawerLayout) obj, valueAnimator);
                break;
            case 2:
                ((DeterminateDrawable) obj).lambda$maybeInitializeAmplitudeAnimator$1(valueAnimator);
                break;
            default:
                ScrollAnimator.initAnim$lambda$0$0((View) obj, valueAnimator);
                break;
        }
    }
}
