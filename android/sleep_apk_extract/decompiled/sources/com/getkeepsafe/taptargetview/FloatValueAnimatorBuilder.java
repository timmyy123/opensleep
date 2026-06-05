package com.getkeepsafe.taptargetview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes3.dex */
class FloatValueAnimatorBuilder {
    final ValueAnimator animator;
    EndListener endListener;

    public interface EndListener {
        void onEnd();
    }

    public interface UpdateListener {
        void onUpdate(float f);
    }

    public FloatValueAnimatorBuilder(boolean z) {
        if (z) {
            this.animator = ValueAnimator.ofFloat(1.0f, 0.0f);
        } else {
            this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        }
    }

    public ValueAnimator build() {
        if (this.endListener != null) {
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.getkeepsafe.taptargetview.FloatValueAnimatorBuilder.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    FloatValueAnimatorBuilder.this.endListener.onEnd();
                }
            });
        }
        return this.animator;
    }

    public FloatValueAnimatorBuilder delayBy(long j) {
        this.animator.setStartDelay(j);
        return this;
    }

    public FloatValueAnimatorBuilder duration(long j) {
        this.animator.setDuration(j);
        return this;
    }

    public FloatValueAnimatorBuilder interpolator(TimeInterpolator timeInterpolator) {
        this.animator.setInterpolator(timeInterpolator);
        return this;
    }

    public FloatValueAnimatorBuilder onEnd(EndListener endListener) {
        this.endListener = endListener;
        return this;
    }

    public FloatValueAnimatorBuilder onUpdate(final UpdateListener updateListener) {
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.getkeepsafe.taptargetview.FloatValueAnimatorBuilder.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                updateListener.onUpdate(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return this;
    }

    public FloatValueAnimatorBuilder repeat(int i) {
        this.animator.setRepeatCount(i);
        return this;
    }

    public FloatValueAnimatorBuilder() {
        this(false);
    }
}
