package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AnimationUtilsCompat {
    public static Interpolator loadInterpolator(Context context, int i) {
        return AnimationUtils.loadInterpolator(context, i);
    }
}
