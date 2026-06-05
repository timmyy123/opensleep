package com.urbandroid.sleep.gui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.core.graphics.ColorUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010)R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020'8\u0002X\u0082D¢\u0006\u0006\n\u0004\b1\u0010)R\u0014\u00102\u001a\u00020'8\u0002X\u0082D¢\u0006\u0006\n\u0004\b2\u0010)R\u0014\u00103\u001a\u00020'8\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u0010)R\"\u00104\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010)\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010)\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\"\u0010<\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010)\u001a\u0004\b=\u00106\"\u0004\b>\u00108R*\u0010@\u001a\u00020'2\u0006\u0010?\u001a\u00020'8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010)\u001a\u0004\bA\u00106\"\u0004\bB\u00108R*\u0010C\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR*\u0010I\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010H¨\u0006L"}, d2 = {"Lcom/urbandroid/sleep/gui/SquigglyProgress;", "Landroid/graphics/drawable/Drawable;", "<init>", "()V", "", "tintColor", "alpha", "", "updateColors", "(II)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "getOpacity", "()I", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "setAlpha", "(I)V", "getAlpha", "setTint", "level", "", "onLevelChange", "(I)Z", "Landroid/content/res/ColorStateList;", "tint", "setTintList", "(Landroid/content/res/ColorStateList;)V", "Landroid/graphics/Paint;", "wavePaint", "Landroid/graphics/Paint;", "linePaint", "Landroid/graphics/Path;", "path", "Landroid/graphics/Path;", "", "heightFraction", "F", "Landroid/animation/ValueAnimator;", "heightAnimator", "Landroid/animation/ValueAnimator;", "phaseOffset", "", "lastFrameTime", "J", "transitionPeriods", "minWaveEndpoint", "matchedWaveEndpoint", "waveLength", "getWaveLength", "()F", "setWaveLength", "(F)V", "lineAmplitude", "getLineAmplitude", "setLineAmplitude", "phaseSpeed", "getPhaseSpeed", "setPhaseSpeed", SDKConstants.PARAM_VALUE, "strokeWidth", "getStrokeWidth", "setStrokeWidth", "transitionEnabled", "Z", "getTransitionEnabled", "()Z", "setTransitionEnabled", "(Z)V", "animate", "getAnimate", "setAnimate", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SquigglyProgress extends Drawable {
    private boolean animate;
    private ValueAnimator heightAnimator;
    private float heightFraction;
    private long lastFrameTime;
    private float lineAmplitude;
    private final Paint linePaint;
    private final float matchedWaveEndpoint;
    private final float minWaveEndpoint;
    private final Path path;
    private float phaseOffset;
    private float phaseSpeed;
    private float strokeWidth;
    private boolean transitionEnabled;
    private final float transitionPeriods;
    private float waveLength;
    private final Paint wavePaint;

    public SquigglyProgress() {
        Paint paint = new Paint();
        this.wavePaint = paint;
        Paint paint2 = new Paint();
        this.linePaint = paint2;
        this.path = new Path();
        this.lastFrameTime = -1L;
        this.transitionPeriods = 1.5f;
        this.minWaveEndpoint = 0.2f;
        this.matchedWaveEndpoint = 0.6f;
        this.transitionEnabled = true;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint2.setStrokeCap(cap);
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        paint.setStyle(style);
        paint2.setAlpha(77);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _set_animate_$lambda$0$0(SquigglyProgress squigglyProgress, ValueAnimator valueAnimator) {
        valueAnimator.getClass();
        Object animatedValue = valueAnimator.getAnimatedValue();
        animatedValue.getClass();
        squigglyProgress.heightFraction = ((Float) animatedValue).floatValue();
        squigglyProgress.invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float draw$lambda$0(SquigglyProgress squigglyProgress, float f, float f2, float f3) {
        if (!squigglyProgress.transitionEnabled) {
            return f3 * squigglyProgress.heightFraction * squigglyProgress.lineAmplitude;
        }
        float f4 = (squigglyProgress.transitionPeriods * squigglyProgress.waveLength) / 2.0f;
        return f3 * squigglyProgress.heightFraction * squigglyProgress.lineAmplitude * MathUtils.lerpInvSat(f + f4, f - f4, f2);
    }

    private final void updateColors(int tintColor, int alpha) {
        this.wavePaint.setColor(ColorUtils.setAlphaComponent(tintColor, alpha));
        this.linePaint.setColor(ColorUtils.setAlphaComponent(tintColor, (int) ((alpha / 255.0f) * 77.0f)));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.getClass();
        if (this.animate) {
            invalidateSelf();
            long jUptimeMillis = SystemClock.uptimeMillis();
            this.phaseOffset = ((((jUptimeMillis - this.lastFrameTime) / 1000.0f) * this.phaseSpeed) + this.phaseOffset) % this.waveLength;
            this.lastFrameTime = jUptimeMillis;
        }
        float level = getLevel() / 10000.0f;
        float fWidth = getBounds().width();
        float f = fWidth * level;
        if (this.transitionEnabled) {
            float f2 = this.matchedWaveEndpoint;
            if (level <= f2) {
                level = MathUtils.lerp(this.minWaveEndpoint, f2, MathUtils.lerpInv(0.0f, f2, level));
            }
        }
        float f3 = level * fWidth;
        float f4 = (-this.phaseOffset) - (this.waveLength / 2.0f);
        float f5 = this.transitionEnabled ? fWidth : f3;
        this.path.rewind();
        this.path.moveTo(f4, 0.0f);
        float f6 = 1.0f;
        float fDraw$lambda$0 = draw$lambda$0(this, f3, f4, 1.0f);
        float f7 = this.waveLength / 2.0f;
        float f8 = fDraw$lambda$0;
        float f9 = f4;
        while (f9 < f5) {
            f6 = -f6;
            float f10 = f9 + f7;
            float f11 = (f7 / 2.0f) + f9;
            float fDraw$lambda$02 = draw$lambda$0(this, f3, f10, f6);
            this.path.cubicTo(f11, f8, f11, fDraw$lambda$02, f10, fDraw$lambda$02);
            f8 = fDraw$lambda$02;
            f9 = f10;
        }
        float f12 = this.lineAmplitude + this.strokeWidth;
        canvas.save();
        canvas.translate(getBounds().left, getBounds().centerY());
        canvas.save();
        float f13 = (-1.0f) * f12;
        canvas.clipRect(0.0f, f13, f, f12);
        canvas.drawPath(this.path, this.wavePaint);
        canvas.restore();
        if (this.transitionEnabled) {
            canvas.save();
            canvas.clipRect(f, f13, fWidth, f12);
            canvas.drawPath(this.path, this.linePaint);
            canvas.restore();
        } else {
            canvas.drawLine(f, 0.0f, fWidth, 0.0f, this.linePaint);
        }
        canvas.drawPoint(0.0f, ((float) Math.cos((Math.abs(f4) / this.waveLength) * 6.2831855f)) * this.lineAmplitude * this.heightFraction, this.wavePaint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.wavePaint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int level) {
        return this.animate;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        updateColors(this.wavePaint.getColor(), alpha);
    }

    public final void setAnimate(boolean z) {
        if (this.animate == z) {
            return;
        }
        this.animate = z;
        if (z) {
            this.lastFrameTime = SystemClock.uptimeMillis();
        }
        ValueAnimator valueAnimator = this.heightAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i = 0;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.heightFraction, this.animate ? 1.0f : 0.0f);
        if (this.animate) {
            valueAnimatorOfFloat.setStartDelay(60L);
            valueAnimatorOfFloat.setDuration(800L);
            valueAnimatorOfFloat.setInterpolator(Interpolators.EMPHASIZED_DECELERATE);
        } else {
            valueAnimatorOfFloat.setDuration(550L);
            valueAnimatorOfFloat.setInterpolator(Interpolators.STANDARD_DECELERATE);
        }
        valueAnimatorOfFloat.addUpdateListener(new SquigglyProgress$$ExternalSyntheticLambda0(this, i));
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.urbandroid.sleep.gui.SquigglyProgress$animate$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                animation.getClass();
                this.this$0.heightAnimator = null;
            }
        });
        valueAnimatorOfFloat.start();
        this.heightAnimator = valueAnimatorOfFloat;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.wavePaint.setColorFilter(colorFilter);
        this.linePaint.setColorFilter(colorFilter);
    }

    public final void setLineAmplitude(float f) {
        this.lineAmplitude = f;
    }

    public final void setPhaseSpeed(float f) {
        this.phaseSpeed = f;
    }

    public final void setStrokeWidth(float f) {
        if (this.strokeWidth == f) {
            return;
        }
        this.strokeWidth = f;
        this.wavePaint.setStrokeWidth(f);
        this.linePaint.setStrokeWidth(f);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int tintColor) {
        updateColors(tintColor, getAlpha());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList tint) {
        if (tint == null) {
            return;
        }
        updateColors(tint.getDefaultColor(), getAlpha());
    }

    public final void setTransitionEnabled(boolean z) {
        this.transitionEnabled = z;
        invalidateSelf();
    }

    public final void setWaveLength(float f) {
        this.waveLength = f;
    }
}
