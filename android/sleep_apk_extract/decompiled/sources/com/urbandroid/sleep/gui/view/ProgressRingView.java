package com.urbandroid.sleep.gui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import flepsik.github.com.progress_ring.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class ProgressRingView extends View {
    private boolean animated;
    private int animationDuration;
    private BackgroundPainter background;
    private EmptyRingPainter emptyRing;
    private Interpolator interpolator;
    private float progress;
    private ValueAnimator progressAnimator;
    private ProgressRingPainter progressRing;
    private int ringWidth;
    public static final int DEFAULT_BACKGROUND_PROGRESS_COLOR = Color.parseColor("#e9e9e9");
    public static final int DEFAULT_PROGRESS_COLOR = Color.parseColor("#27cf6b");
    private static final Interpolator DEFAULT_INTERPOLATOR = new AccelerateDecelerateInterpolator();

    public interface AnimationUpdateListener {
    }

    public static class BackgroundPainter extends Painter {
        protected int color;

        public BackgroundPainter(int i) {
            this.color = i;
            initialize();
        }

        private void initialize() {
            this.paint.setColor(this.color);
        }

        public void draw(Canvas canvas) {
            if (this.color != 0) {
                Point point = this.center;
                canvas.drawCircle(point.x, point.y, this.radius, this.paint);
            }
        }

        public int getColor() {
            return this.color;
        }

        public void setColor(int i) {
            this.color = i;
            this.paint.setColor(i);
        }
    }

    public static abstract class Painter {
        Point center = new Point();
        Paint paint;
        int radius;

        public Painter() {
            Paint paint = new Paint();
            this.paint = paint;
            paint.setAntiAlias(true);
        }

        public void onSizeChanged(Point point, int i) {
            this.center = point;
            this.radius = i;
        }
    }

    public static class ProgressRingPainter extends EmptyRingPainter {
        private int innerColor;
        private float progress;
        private boolean shouldFillInnerProgress;
        private int sweepAngle;

        public ProgressRingPainter(int i, int i2, int i3) {
            super(i, i2, i3);
            this.innerColor = this.color;
            initialize();
        }

        private void initialize() {
            this.paint.setColor(this.color);
        }

        @Override // com.urbandroid.sleep.gui.view.ProgressRingView.EmptyRingPainter
        public void draw(Canvas canvas) {
            Canvas canvas2;
            if (this.shouldFillInnerProgress) {
                Paint paint = this.paint;
                int i = this.innerColor;
                if (i == ProgressRingView.DEFAULT_PROGRESS_COLOR) {
                    i = this.color;
                }
                paint.setColor(i);
                this.paint.setStyle(Paint.Style.FILL);
                canvas2 = canvas;
                canvas2.drawArc(this.rect, this.startAngle, this.sweepAngle, true, this.paint);
            } else {
                canvas2 = canvas;
            }
            this.paint.setColor(this.color);
            this.paint.setStyle(Paint.Style.STROKE);
            canvas2.drawArc(this.rect, this.startAngle, this.sweepAngle, false, this.paint);
            this.paint.setStyle(Paint.Style.FILL);
            if (!this.shouldCornerEdges || this.sweepAngle <= 0) {
                return;
            }
            Point point = this.startCircle;
            canvas2.drawCircle(point.x, point.y, this.ringWidth / 2, this.paint);
            Point point2 = this.endCircle;
            canvas2.drawCircle(point2.x, point2.y, this.ringWidth / 2, this.paint);
        }

        public int getInnerProgressColor() {
            return this.innerColor;
        }

        @Override // com.urbandroid.sleep.gui.view.ProgressRingView.EmptyRingPainter, com.urbandroid.sleep.gui.view.ProgressRingView.Painter
        public void onSizeChanged(Point point, int i) {
            super.onSizeChanged(point, i);
            RectF rectF = this.rect;
            int i2 = point.x;
            int i3 = this.radius;
            int i4 = point.y;
            rectF.set(i2 - i3, i4 - i3, i2 + i3, i4 + i3);
            setProgress(this.progress);
        }

        public void setInnerProgressColor(int i) {
            this.innerColor = i;
        }

        public void setProgress(float f) {
            this.progress = f;
            this.sweepAngle = (int) (this.sweepAngleDegree * f);
            this.startCircle = calculateStartAngleOvalPoint(this.startAngle);
            this.endCircle = calculateStartAngleOvalPoint(this.sweepAngle + this.startAngle);
        }

        public void setShouldFillInnerProgress(boolean z) {
            this.shouldFillInnerProgress = z;
        }
    }

    public ProgressRingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ringWidth = -1;
        this.animationDuration = 300;
        this.interpolator = DEFAULT_INTERPOLATOR;
        initialize(context, attributeSet);
    }

    private static int convertDpToPixel(float f, Context context) {
        return Math.round(context.getResources().getDisplayMetrics().density * f);
    }

    public int getAnimationDuration() {
        return this.animationDuration;
    }

    public int getBackgroundColor() {
        return this.background.getColor();
    }

    public int getBackgroundProgressColor() {
        return this.emptyRing.color;
    }

    public Interpolator getInterpolator() {
        return this.interpolator;
    }

    public float getProgress() {
        return this.progress;
    }

    public int getProgressColor() {
        return this.progressRing.color;
    }

    public int getProgressInnerFillColor() {
        return this.progressRing.getInnerProgressColor();
    }

    public int getRingWidth() {
        return this.ringWidth;
    }

    public void initialize(Context context, AttributeSet attributeSet) {
        int i;
        boolean z;
        int color = DEFAULT_BACKGROUND_PROGRESS_COLOR;
        int i2 = DEFAULT_PROGRESS_COLOR;
        int i3 = 0;
        int i4 = 360;
        int i5 = -90;
        boolean z2 = true;
        float f = 0.0f;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ProgressRingView);
            f = typedArrayObtainStyledAttributes.getFloat(5, 0.0f);
            i4 = typedArrayObtainStyledAttributes.getInt(11, 360);
            i5 = typedArrayObtainStyledAttributes.getInt(10, -90);
            this.ringWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, -1);
            int color2 = typedArrayObtainStyledAttributes.getColor(2, 0);
            color = typedArrayObtainStyledAttributes.getColor(3, color);
            int color3 = typedArrayObtainStyledAttributes.getColor(6, i2);
            int color4 = typedArrayObtainStyledAttributes.getColor(8, i2);
            this.animationDuration = typedArrayObtainStyledAttributes.getInt(1, 300);
            z = typedArrayObtainStyledAttributes.getBoolean(7, false);
            z2 = typedArrayObtainStyledAttributes.getBoolean(4, true);
            this.animated = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
            i3 = color2;
            i = color4;
            i2 = color3;
        } else {
            i = i2;
            z = false;
        }
        this.background = new BackgroundPainter(i3);
        this.emptyRing = new EmptyRingPainter(color, i5, i4);
        ProgressRingPainter progressRingPainter = new ProgressRingPainter(i2, i5, i4);
        this.progressRing = progressRingPainter;
        progressRingPainter.setInnerProgressColor(i);
        this.progressRing.setShouldFillInnerProgress(z);
        this.emptyRing.cornerEdges(z2);
        this.progressRing.cornerEdges(z2);
        setProgress(f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.background.draw(canvas);
        this.emptyRing.draw(canvas);
        this.progressRing.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int iConvertDpToPixel = convertDpToPixel(50.0f, getContext());
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(iConvertDpToPixel, size) : iConvertDpToPixel;
        }
        if (mode2 == 1073741824) {
            iConvertDpToPixel = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            iConvertDpToPixel = Math.min(iConvertDpToPixel, size2);
        }
        setMeasuredDimension(size, iConvertDpToPixel);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.progress);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.progress = this.progress;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        Point point = new Point(i / 2, i2 / 2);
        int iMin = Math.min(i, i2) / 2;
        int i6 = this.ringWidth;
        if (i6 != -1) {
            i5 = iMin - i6;
        } else {
            float f = iMin;
            i6 = (int) (f * 0.1f);
            i5 = (int) (0.9f * f);
        }
        this.background.onSizeChanged(point, i5);
        this.emptyRing.onSizeChanged(point, i5);
        this.progressRing.onSizeChanged(point, i5);
        setRingWidth(i6);
        invalidate();
    }

    public void setAnimated(boolean z) {
        this.animated = z;
    }

    public void setAnimationDuration(int i) {
        this.animationDuration = i;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.background.getColor() != i) {
            this.background.setColor(i);
            invalidate();
        }
    }

    public void setBackgroundProgressColor(int i) {
        this.emptyRing.setColor(i);
        invalidate();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }

    public void setListener(AnimationUpdateListener animationUpdateListener) {
    }

    public void setProgress(float f) {
        if (isInEditMode()) {
            this.animated = false;
        }
        if (this.progress != f) {
            this.emptyRing.calculateStartAngleOvalPoint();
            if (!this.animated) {
                this.progressRing.setProgress(f);
                invalidate();
                return;
            }
            ValueAnimator valueAnimator = this.progressAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.progress, f);
            this.progressAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setInterpolator(this.interpolator);
            this.progressAnimator.setDuration(this.animationDuration);
            this.progressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.urbandroid.sleep.gui.view.ProgressRingView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    ProgressRingView.this.progress = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    ProgressRingView.this.getClass();
                    ProgressRingView.this.progressRing.setProgress(ProgressRingView.this.progress);
                    ProgressRingView.this.invalidate();
                }
            });
            this.progressAnimator.start();
        }
    }

    public void setProgressColor(int i) {
        if (this.progressRing.getColor() != i) {
            this.progressRing.setColor(i);
            invalidate();
        }
    }

    public void setProgressInnerFillColor(int i) {
        if (this.progressRing.getColor() != i) {
            this.progressRing.setInnerProgressColor(i);
            invalidate();
        }
    }

    public void setRingWidth(int i) {
        this.ringWidth = i;
        this.emptyRing.setRingWidth(i);
        this.progressRing.setRingWidth(i);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.urbandroid.sleep.gui.view.ProgressRingView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        float progress;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readFloat();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.progress);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public /* synthetic */ SavedState(Parcel parcel, int i) {
            this(parcel);
        }
    }

    public static class EmptyRingPainter extends Painter {
        protected int color;
        int ringWidth;
        int startAngle;
        int sweepAngleDegree;
        RectF rect = new RectF();
        Point endCircle = new Point();
        Point startCircle = new Point();
        boolean shouldCornerEdges = true;

        public EmptyRingPainter(int i, int i2, int i3) {
            setColor(i);
            setStartAngle(i2);
            setSweepAngleDegree(i3);
            initialize();
        }

        private void initialize() {
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setColor(this.color);
        }

        public Point calculateStartAngleOvalPoint(int i) {
            Point point = new Point();
            double radians = Math.toRadians(i);
            point.x = (int) ((Math.cos(radians) * ((double) this.radius)) + ((double) this.center.x));
            point.y = (int) ((Math.sin(radians) * ((double) this.radius)) + ((double) this.center.y));
            return point;
        }

        public void cornerEdges(boolean z) {
            this.shouldCornerEdges = z;
        }

        public void draw(Canvas canvas) {
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(this.rect, this.startAngle, this.sweepAngleDegree, false, this.paint);
            this.paint.setStyle(Paint.Style.FILL);
            if (this.shouldCornerEdges) {
                float f = this.ringWidth / 2;
                Point point = this.endCircle;
                int i = point.x;
                int i2 = point.y;
                canvas.drawArc(i - f, i2 - f, i + f, i2 + f, 198.0f, -178.0f, true, this.paint);
            }
        }

        public int getColor() {
            return this.color;
        }

        @Override // com.urbandroid.sleep.gui.view.ProgressRingView.Painter
        public void onSizeChanged(Point point, int i) {
            super.onSizeChanged(point, i);
            RectF rectF = this.rect;
            int i2 = point.x;
            int i3 = this.radius;
            int i4 = point.y;
            rectF.set(i2 - i3, i4 - i3, i2 + i3, i4 + i3);
            calculateStartAngleOvalPoint();
        }

        public void setColor(int i) {
            this.color = i;
            this.paint.setColor(i);
        }

        public void setRingWidth(int i) {
            this.paint.setStrokeWidth(i);
            this.ringWidth = i;
        }

        public void setStartAngle(int i) {
            this.startAngle = i;
        }

        public void setSweepAngleDegree(int i) {
            this.sweepAngleDegree = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void calculateStartAngleOvalPoint() {
            this.startCircle = calculateStartAngleOvalPoint(this.startAngle);
            this.endCircle = calculateStartAngleOvalPoint(this.sweepAngleDegree + this.startAngle);
        }
    }
}
