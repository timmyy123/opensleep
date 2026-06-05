package com.getkeepsafe.taptargetview;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.getkeepsafe.taptargetview.FloatValueAnimatorBuilder;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public class TapTargetView extends View {
    final int CIRCLE_PADDING;
    final int GUTTER_DIM;
    final int SHADOW_DIM;
    final int SHADOW_JITTER_DIM;
    final int TARGET_PADDING;
    final int TARGET_PULSE_RADIUS;
    final int TARGET_RADIUS;
    final int TEXT_MAX_WIDTH;
    final int TEXT_PADDING;
    final int TEXT_POSITIONING_BIAS;
    final int TEXT_SAFE_AREA_PADDING;
    final int TEXT_SPACING;
    private ValueAnimator[] animators;
    int bottomBoundary;
    final ViewGroup boundingParent;
    int calculatedOuterCircleRadius;
    boolean cancelable;
    boolean debug;
    DynamicLayout debugLayout;
    Paint debugPaint;
    SpannableStringBuilder debugStringBuilder;
    TextPaint debugTextPaint;
    CharSequence description;
    StaticLayout descriptionLayout;
    final TextPaint descriptionPaint;
    int dimColor;
    final ValueAnimator dismissAnimation;
    private final ValueAnimator dismissConfirmAnimation;
    Rect drawingBounds;
    final ValueAnimator expandAnimation;
    final FloatValueAnimatorBuilder.UpdateListener expandContractUpdateListener;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    boolean isDark;
    private boolean isDismissed;
    private boolean isDismissing;
    private boolean isInteractable;
    float lastTouchX;
    float lastTouchY;
    Listener listener;
    int outerCircleAlpha;
    int[] outerCircleCenter;
    final Paint outerCirclePaint;
    Path outerCirclePath;
    float outerCircleRadius;
    final Paint outerCircleShadowPaint;
    ViewOutlineProvider outlineProvider;
    final ViewManager parent;
    final ValueAnimator pulseAnimation;
    boolean shouldDrawShadow;
    boolean shouldTintTarget;
    final TapTarget target;
    final Rect targetBounds;
    int targetCircleAlpha;
    final Paint targetCirclePaint;
    int targetCirclePulseAlpha;
    final Paint targetCirclePulsePaint;
    float targetCirclePulseRadius;
    float targetCircleRadius;
    int textAlpha;
    Rect textBounds;
    Bitmap tintedTarget;
    CharSequence title;
    StaticLayout titleLayout;
    final TextPaint titlePaint;
    int topBoundary;
    boolean visible;

    public static class Listener {
        public void onOuterCircleClick(TapTargetView tapTargetView) {
        }

        public void onTargetCancel(TapTargetView tapTargetView) {
            tapTargetView.dismiss(false);
        }

        public void onTargetClick(TapTargetView tapTargetView) {
            tapTargetView.dismiss(true);
        }

        public void onTargetDismissed(TapTargetView tapTargetView, boolean z) {
        }

        public void onTargetLongClick(TapTargetView tapTargetView) {
            onTargetClick(tapTargetView);
        }
    }

    public TapTargetView(final Context context, ViewManager viewManager, final ViewGroup viewGroup, final TapTarget tapTarget, Listener listener) {
        super(context);
        boolean z = false;
        this.isDismissed = false;
        this.isDismissing = false;
        this.isInteractable = true;
        this.expandContractUpdateListener = new FloatValueAnimatorBuilder.UpdateListener() { // from class: com.getkeepsafe.taptargetview.TapTargetView.1
            @Override // com.getkeepsafe.taptargetview.FloatValueAnimatorBuilder.UpdateListener
            public void onUpdate(float f) {
                TapTargetView tapTargetView = TapTargetView.this;
                float f2 = tapTargetView.calculatedOuterCircleRadius * f;
                boolean z2 = f2 > tapTargetView.outerCircleRadius;
                if (!z2) {
                    tapTargetView.calculateDrawingBounds();
                }
                TapTargetView tapTargetView2 = TapTargetView.this;
                float f3 = tapTargetView2.target.outerCircleAlpha * 255.0f;
                tapTargetView2.outerCircleRadius = f2;
                float f4 = 1.5f * f;
                tapTargetView2.outerCircleAlpha = (int) Math.min(f3, f4 * f3);
                TapTargetView.this.outerCirclePath.reset();
                TapTargetView tapTargetView3 = TapTargetView.this;
                Path path = tapTargetView3.outerCirclePath;
                int[] iArr = tapTargetView3.outerCircleCenter;
                path.addCircle(iArr[0], iArr[1], tapTargetView3.outerCircleRadius, Path.Direction.CW);
                TapTargetView.this.targetCircleAlpha = (int) Math.min(255.0f, f4 * 255.0f);
                TapTargetView tapTargetView4 = TapTargetView.this;
                if (z2) {
                    tapTargetView4.targetCircleRadius = Math.min(1.0f, f4) * tapTargetView4.TARGET_RADIUS;
                } else {
                    tapTargetView4.targetCircleRadius = tapTargetView4.TARGET_RADIUS * f;
                    tapTargetView4.targetCirclePulseRadius *= f;
                }
                TapTargetView tapTargetView5 = TapTargetView.this;
                tapTargetView5.textAlpha = (int) (tapTargetView5.delayedLerp(f, 0.7f) * 255.0f);
                if (z2) {
                    TapTargetView.this.calculateDrawingBounds();
                }
                TapTargetView tapTargetView6 = TapTargetView.this;
                tapTargetView6.invalidateViewAndOutline(tapTargetView6.drawingBounds);
            }
        };
        ValueAnimator valueAnimatorBuild = new FloatValueAnimatorBuilder().duration(250L).delayBy(250L).interpolator(new AccelerateDecelerateInterpolator()).onUpdate(new FloatValueAnimatorBuilder.UpdateListener() { // from class: com.getkeepsafe.taptargetview.TapTargetView.3
            @Override // com.getkeepsafe.taptargetview.FloatValueAnimatorBuilder.UpdateListener
            public void onUpdate(float f) {
                TapTargetView.this.expandContractUpdateListener.onUpdate(f);
            }
        }).onEnd(new FloatValueAnimatorBuilder.EndListener() { // from class: com.getkeepsafe.taptargetview.TapTargetView.2
            @Override // com.getkeepsafe.taptargetview.FloatValueAnimatorBuilder.EndListener
            public void onEnd() {
                TapTargetView.this.pulseAnimation.start();
                TapTargetView.this.isInteractable = true;
            }
        }).build();
        this.expandAnimation = valueAnimatorBuild;
        ValueAnimator valueAnimatorBuild2 = new FloatValueAnimatorBuilder().duration(1000L).repeat(-1).interpolator(new AccelerateDecelerateInterpolator()).onUpdate(new FloatValueAnimatorBuilder.UpdateListener() { // from class: com.getkeepsafe.taptargetview.TapTargetView.4
            @Override // com.getkeepsafe.taptargetview.FloatValueAnimatorBuilder.UpdateListener
            public void onUpdate(float f) {
                float fDelayedLerp = TapTargetView.this.delayedLerp(f, 0.5f);
                TapTargetView tapTargetView = TapTargetView.this;
                int i = tapTargetView.TARGET_RADIUS;
                tapTargetView.targetCirclePulseRadius = (fDelayedLerp + 1.0f) * i;
                tapTargetView.targetCirclePulseAlpha = (int) ((1.0f - fDelayedLerp) * 255.0f);
                float fHalfwayLerp = tapTargetView.halfwayLerp(f);
                TapTargetView tapTargetView2 = TapTargetView.this;
                tapTargetView.targetCircleRadius = (fHalfwayLerp * tapTargetView2.TARGET_PULSE_RADIUS) + i;
                float f2 = tapTargetView2.outerCircleRadius;
                int i2 = tapTargetView2.calculatedOuterCircleRadius;
                if (f2 != i2) {
                    tapTargetView2.outerCircleRadius = i2;
                }
                tapTargetView2.calculateDrawingBounds();
                TapTargetView tapTargetView3 = TapTargetView.this;
                tapTargetView3.invalidateViewAndOutline(tapTargetView3.drawingBounds);
            }
        }).build();
        this.pulseAnimation = valueAnimatorBuild2;
        ValueAnimator valueAnimatorBuild3 = new FloatValueAnimatorBuilder(true).duration(250L).interpolator(new AccelerateDecelerateInterpolator()).onUpdate(new FloatValueAnimatorBuilder.UpdateListener() { // from class: com.getkeepsafe.taptargetview.TapTargetView.6
            @Override // com.getkeepsafe.taptargetview.FloatValueAnimatorBuilder.UpdateListener
            public void onUpdate(float f) {
                TapTargetView.this.expandContractUpdateListener.onUpdate(f);
            }
        }).onEnd(new FloatValueAnimatorBuilder.EndListener() { // from class: com.getkeepsafe.taptargetview.TapTargetView.5
            @Override // com.getkeepsafe.taptargetview.FloatValueAnimatorBuilder.EndListener
            public void onEnd() {
                TapTargetView.this.finishDismiss(true);
            }
        }).build();
        this.dismissAnimation = valueAnimatorBuild3;
        ValueAnimator valueAnimatorBuild4 = new FloatValueAnimatorBuilder().duration(250L).interpolator(new AccelerateDecelerateInterpolator()).onUpdate(new FloatValueAnimatorBuilder.UpdateListener() { // from class: com.getkeepsafe.taptargetview.TapTargetView.8
            @Override // com.getkeepsafe.taptargetview.FloatValueAnimatorBuilder.UpdateListener
            public void onUpdate(float f) {
                float fMin = Math.min(1.0f, 2.0f * f);
                TapTargetView tapTargetView = TapTargetView.this;
                tapTargetView.outerCircleRadius = ((0.2f * fMin) + 1.0f) * tapTargetView.calculatedOuterCircleRadius;
                float f2 = 1.0f - fMin;
                tapTargetView.outerCircleAlpha = (int) (tapTargetView.target.outerCircleAlpha * f2 * 255.0f);
                tapTargetView.outerCirclePath.reset();
                TapTargetView tapTargetView2 = TapTargetView.this;
                Path path = tapTargetView2.outerCirclePath;
                int[] iArr = tapTargetView2.outerCircleCenter;
                path.addCircle(iArr[0], iArr[1], tapTargetView2.outerCircleRadius, Path.Direction.CW);
                TapTargetView tapTargetView3 = TapTargetView.this;
                float f3 = 1.0f - f;
                int i = tapTargetView3.TARGET_RADIUS;
                tapTargetView3.targetCircleRadius = i * f3;
                tapTargetView3.targetCircleAlpha = (int) (f3 * 255.0f);
                tapTargetView3.targetCirclePulseRadius = (f + 1.0f) * i;
                tapTargetView3.targetCirclePulseAlpha = (int) (f3 * tapTargetView3.targetCirclePulseAlpha);
                tapTargetView3.textAlpha = (int) (f2 * 255.0f);
                tapTargetView3.calculateDrawingBounds();
                TapTargetView tapTargetView4 = TapTargetView.this;
                tapTargetView4.invalidateViewAndOutline(tapTargetView4.drawingBounds);
            }
        }).onEnd(new FloatValueAnimatorBuilder.EndListener() { // from class: com.getkeepsafe.taptargetview.TapTargetView.7
            @Override // com.getkeepsafe.taptargetview.FloatValueAnimatorBuilder.EndListener
            public void onEnd() {
                TapTargetView.this.finishDismiss(true);
            }
        }).build();
        this.dismissConfirmAnimation = valueAnimatorBuild4;
        this.animators = new ValueAnimator[]{valueAnimatorBuild, valueAnimatorBuild2, valueAnimatorBuild4, valueAnimatorBuild3};
        if (tapTarget == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Target cannot be null");
            throw null;
        }
        this.target = tapTarget;
        this.parent = viewManager;
        this.boundingParent = viewGroup;
        this.listener = listener == null ? new Listener() : listener;
        this.title = tapTarget.title;
        this.description = tapTarget.description;
        this.TARGET_PADDING = UiUtil.dp(context, 20);
        this.CIRCLE_PADDING = UiUtil.dp(context, 40);
        int iDp = UiUtil.dp(context, tapTarget.targetRadius);
        this.TARGET_RADIUS = iDp;
        this.TEXT_PADDING = UiUtil.dp(context, 40);
        this.TEXT_SPACING = UiUtil.dp(context, 8);
        this.TEXT_MAX_WIDTH = UiUtil.dp(context, 360);
        this.TEXT_POSITIONING_BIAS = UiUtil.dp(context, 20);
        this.TEXT_SAFE_AREA_PADDING = UiUtil.dp(getContext(), 10);
        this.GUTTER_DIM = UiUtil.dp(context, 88);
        this.SHADOW_DIM = UiUtil.dp(context, 8);
        int iDp2 = UiUtil.dp(context, 1);
        this.SHADOW_JITTER_DIM = iDp2;
        this.TARGET_PULSE_RADIUS = (int) (iDp * 0.1f);
        this.outerCirclePath = new Path();
        this.targetBounds = new Rect();
        this.drawingBounds = new Rect();
        TextPaint textPaint = new TextPaint();
        this.titlePaint = textPaint;
        textPaint.setTextSize(tapTarget.titleTextSizePx(context));
        textPaint.setTypeface(Typeface.create("sans-serif-medium", 0));
        textPaint.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.descriptionPaint = textPaint2;
        textPaint2.setTextSize(tapTarget.descriptionTextSizePx(context));
        textPaint2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        textPaint2.setAntiAlias(true);
        textPaint2.setAlpha(137);
        Paint paint = new Paint();
        this.outerCirclePaint = paint;
        paint.setAntiAlias(true);
        paint.setAlpha((int) (tapTarget.outerCircleAlpha * 255.0f));
        Paint paint2 = new Paint();
        this.outerCircleShadowPaint = paint2;
        paint2.setAntiAlias(true);
        paint2.setAlpha(50);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(iDp2);
        paint2.setColor(Color.BLACK);
        Paint paint3 = new Paint();
        this.targetCirclePaint = paint3;
        paint3.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.targetCirclePulsePaint = paint4;
        paint4.setAntiAlias(true);
        applyTargetOptions(context);
        if ((context instanceof Activity) && (((Activity) context).getWindow().getAttributes().flags & 512) != 0) {
            z = true;
        }
        final boolean z2 = z;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.getkeepsafe.taptargetview.TapTargetView.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (TapTargetView.this.isDismissing) {
                    return;
                }
                TapTargetView.this.updateTextLayouts();
                tapTarget.onReady(new Runnable() { // from class: com.getkeepsafe.taptargetview.TapTargetView.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int[] iArr = new int[2];
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        TapTargetView.this.targetBounds.set(tapTarget.bounds());
                        TapTargetView.this.getLocationOnScreen(iArr);
                        TapTargetView.this.targetBounds.offset(-iArr[0], -iArr[1]);
                        AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                        if (viewGroup != null) {
                            WindowManager windowManager = (WindowManager) context.getSystemService("window");
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                            Rect rect = new Rect();
                            viewGroup.getWindowVisibleDisplayFrame(rect);
                            int[] iArr2 = new int[2];
                            viewGroup.getLocationInWindow(iArr2);
                            AnonymousClass9 anonymousClass93 = AnonymousClass9.this;
                            TapTarget tapTarget2 = tapTarget;
                            if (tapTarget2.drawBehindStatusBar) {
                                rect.top = iArr2[1];
                            }
                            if (tapTarget2.drawBehindNavigationBar) {
                                rect.bottom = viewGroup.getHeight() + iArr2[1];
                            }
                            AnonymousClass9 anonymousClass94 = AnonymousClass9.this;
                            if (z2) {
                                TapTargetView.this.topBoundary = Math.max(0, rect.top);
                                TapTargetView.this.bottomBoundary = Math.min(rect.bottom, displayMetrics.heightPixels);
                            } else {
                                TapTargetView tapTargetView = TapTargetView.this;
                                tapTargetView.topBoundary = rect.top;
                                tapTargetView.bottomBoundary = rect.bottom;
                            }
                        }
                        TapTargetView.this.drawTintedTarget();
                        TapTargetView.this.requestFocus();
                        TapTargetView.this.calculateDimensions();
                        TapTargetView.this.startExpandAnimation();
                    }
                });
            }
        };
        this.globalLayoutListener = onGlobalLayoutListener;
        getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        setFocusableInTouchMode(true);
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.getkeepsafe.taptargetview.TapTargetView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TapTargetView tapTargetView = TapTargetView.this;
                if (tapTargetView.listener == null || tapTargetView.outerCircleCenter == null || !tapTargetView.isInteractable) {
                    return;
                }
                TapTargetView tapTargetView2 = TapTargetView.this;
                int iCenterX = tapTargetView2.targetBounds.centerX();
                int iCenterY = TapTargetView.this.targetBounds.centerY();
                TapTargetView tapTargetView3 = TapTargetView.this;
                double dDistance = tapTargetView2.distance(iCenterX, iCenterY, (int) tapTargetView3.lastTouchX, (int) tapTargetView3.lastTouchY);
                TapTargetView tapTargetView4 = TapTargetView.this;
                boolean z3 = dDistance <= ((double) tapTargetView4.targetCircleRadius);
                int[] iArr = tapTargetView4.outerCircleCenter;
                double dDistance2 = tapTargetView4.distance(iArr[0], iArr[1], (int) tapTargetView4.lastTouchX, (int) tapTargetView4.lastTouchY);
                TapTargetView tapTargetView5 = TapTargetView.this;
                boolean z4 = dDistance2 <= ((double) tapTargetView5.outerCircleRadius);
                if (z3) {
                    tapTargetView5.isInteractable = false;
                    TapTargetView tapTargetView6 = TapTargetView.this;
                    tapTargetView6.listener.onTargetClick(tapTargetView6);
                } else if (z4) {
                    tapTargetView5.listener.onOuterCircleClick(tapTargetView5);
                } else if (tapTargetView5.cancelable) {
                    tapTargetView5.isInteractable = false;
                    TapTargetView tapTargetView7 = TapTargetView.this;
                    tapTargetView7.listener.onTargetCancel(tapTargetView7);
                }
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.getkeepsafe.taptargetview.TapTargetView.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                TapTargetView tapTargetView = TapTargetView.this;
                if (tapTargetView.listener == null || !tapTargetView.targetBounds.contains((int) tapTargetView.lastTouchX, (int) tapTargetView.lastTouchY)) {
                    return false;
                }
                TapTargetView tapTargetView2 = TapTargetView.this;
                tapTargetView2.listener.onTargetLongClick(tapTargetView2);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDismiss(boolean z) {
        onDismiss(z);
        ViewUtil.removeView(this.parent, this);
    }

    public static TapTargetView showFor(Dialog dialog, TapTarget tapTarget, Listener listener) {
        if (dialog == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Dialog is null");
            return null;
        }
        Context context = dialog.getContext();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2;
        layoutParams.format = 1;
        layoutParams.flags = 0;
        layoutParams.gravity = 8388659;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        TapTargetView tapTargetView = new TapTargetView(context, windowManager, null, tapTarget, listener);
        windowManager.addView(tapTargetView, layoutParams);
        return tapTargetView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startExpandAnimation() {
        if (this.visible) {
            return;
        }
        this.isInteractable = false;
        this.expandAnimation.start();
        this.visible = true;
    }

    public void applyTargetOptions(Context context) {
        TapTarget tapTarget = this.target;
        boolean z = tapTarget.transparentTarget;
        this.shouldTintTarget = !z && tapTarget.tintTarget;
        boolean z2 = tapTarget.drawShadow;
        this.shouldDrawShadow = z2;
        this.cancelable = tapTarget.cancelable;
        if (z2 && !z) {
            ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: com.getkeepsafe.taptargetview.TapTargetView.12
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    TapTargetView tapTargetView = TapTargetView.this;
                    int[] iArr = tapTargetView.outerCircleCenter;
                    if (iArr == null) {
                        return;
                    }
                    int i = iArr[0];
                    float f = tapTargetView.outerCircleRadius;
                    int i2 = iArr[1];
                    outline.setOval((int) (i - f), (int) (i2 - f), (int) (i + f), (int) (i2 + f));
                    outline.setAlpha(TapTargetView.this.outerCircleAlpha / 255.0f);
                    outline.offset(0, TapTargetView.this.SHADOW_DIM);
                }
            };
            this.outlineProvider = viewOutlineProvider;
            setOutlineProvider(viewOutlineProvider);
            setElevation(this.SHADOW_DIM);
        }
        setLayerType(2, null);
        Resources.Theme theme = context.getTheme();
        this.isDark = UiUtil.themeIntAttr(context, "isLightTheme") == 0;
        Integer numOuterCircleColorInt = this.target.outerCircleColorInt(context);
        if (numOuterCircleColorInt != null) {
            this.outerCirclePaint.setColor(numOuterCircleColorInt.intValue());
        } else {
            Paint paint = this.outerCirclePaint;
            if (theme != null) {
                paint.setColor(UiUtil.themeIntAttr(context, "colorPrimary"));
            } else {
                paint.setColor(-1);
            }
        }
        Integer numTargetCircleColorInt = this.target.targetCircleColorInt(context);
        Paint paint2 = this.targetCirclePaint;
        if (numTargetCircleColorInt != null) {
            paint2.setColor(numTargetCircleColorInt.intValue());
        } else {
            paint2.setColor(this.isDark ? -16777216 : -1);
        }
        if (this.target.transparentTarget) {
            this.targetCirclePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        this.targetCirclePulsePaint.setColor(this.targetCirclePaint.getColor());
        Integer numDimColorInt = this.target.dimColorInt(context);
        if (numDimColorInt != null) {
            this.dimColor = UiUtil.setAlpha(numDimColorInt.intValue(), 0.3f);
        } else {
            this.dimColor = -1;
        }
        Integer numTitleTextColorInt = this.target.titleTextColorInt(context);
        TextPaint textPaint = this.titlePaint;
        if (numTitleTextColorInt != null) {
            textPaint.setColor(numTitleTextColorInt.intValue());
        } else {
            textPaint.setColor(this.isDark ? -16777216 : -1);
        }
        Integer numDescriptionTextColorInt = this.target.descriptionTextColorInt(context);
        TextPaint textPaint2 = this.descriptionPaint;
        if (numDescriptionTextColorInt != null) {
            textPaint2.setColor(numDescriptionTextColorInt.intValue());
        } else {
            textPaint2.setColor(this.titlePaint.getColor());
        }
        Typeface typeface = this.target.titleTypeface;
        if (typeface != null) {
            this.titlePaint.setTypeface(typeface);
        }
        Typeface typeface2 = this.target.descriptionTypeface;
        if (typeface2 != null) {
            this.descriptionPaint.setTypeface(typeface2);
        }
    }

    public void calculateDimensions() {
        this.textBounds = getTextBounds();
        int[] outerCircleCenterPoint = getOuterCircleCenterPoint();
        this.outerCircleCenter = outerCircleCenterPoint;
        this.calculatedOuterCircleRadius = getOuterCircleRadius(outerCircleCenterPoint[0], outerCircleCenterPoint[1], this.textBounds, this.targetBounds);
    }

    public void calculateDrawingBounds() {
        if (this.outerCircleCenter == null) {
            return;
        }
        this.drawingBounds.left = (int) Math.max(0.0f, r0[0] - this.outerCircleRadius);
        this.drawingBounds.top = (int) Math.min(0.0f, this.outerCircleCenter[1] - this.outerCircleRadius);
        this.drawingBounds.right = (int) Math.min(getWidth(), this.outerCircleCenter[0] + this.outerCircleRadius + this.CIRCLE_PADDING);
        this.drawingBounds.bottom = (int) Math.min(getHeight(), this.outerCircleCenter[1] + this.outerCircleRadius + this.CIRCLE_PADDING);
    }

    public float delayedLerp(float f, float f2) {
        if (f < f2) {
            return 0.0f;
        }
        return (f - f2) / (1.0f - f2);
    }

    public void dismiss(boolean z) {
        this.isDismissing = true;
        this.pulseAnimation.cancel();
        this.expandAnimation.cancel();
        if (!this.visible || this.outerCircleCenter == null) {
            finishDismiss(z);
        } else if (z) {
            this.dismissConfirmAnimation.start();
        } else {
            this.dismissAnimation.start();
        }
    }

    public double distance(int i, int i2, int i3, int i4) {
        return Math.sqrt(Math.pow(i4 - i2, 2.0d) + Math.pow(i3 - i, 2.0d));
    }

    public void drawDebugInformation(Canvas canvas) {
        if (this.debugPaint == null) {
            Paint paint = new Paint();
            this.debugPaint = paint;
            paint.setARGB(PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN, 0, 0);
            this.debugPaint.setStyle(Paint.Style.STROKE);
            this.debugPaint.setStrokeWidth(UiUtil.dp(getContext(), 1));
        }
        if (this.debugTextPaint == null) {
            TextPaint textPaint = new TextPaint();
            this.debugTextPaint = textPaint;
            textPaint.setColor(Color.RED);
            this.debugTextPaint.setTextSize(UiUtil.sp(getContext(), 16));
        }
        this.debugPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(this.textBounds, this.debugPaint);
        canvas.drawRect(this.targetBounds, this.debugPaint);
        int[] iArr = this.outerCircleCenter;
        canvas.drawCircle(iArr[0], iArr[1], 10.0f, this.debugPaint);
        int[] iArr2 = this.outerCircleCenter;
        canvas.drawCircle(iArr2[0], iArr2[1], this.calculatedOuterCircleRadius - this.CIRCLE_PADDING, this.debugPaint);
        canvas.drawCircle(this.targetBounds.centerX(), this.targetBounds.centerY(), this.TARGET_RADIUS + this.TARGET_PADDING, this.debugPaint);
        this.debugPaint.setStyle(Paint.Style.FILL);
        String str = "Text bounds: " + this.textBounds.toShortString() + "\nTarget bounds: " + this.targetBounds.toShortString() + "\nCenter: " + this.outerCircleCenter[0] + " " + this.outerCircleCenter[1] + "\nView size: " + getWidth() + " " + getHeight() + "\nTarget bounds: " + this.targetBounds.toShortString();
        SpannableStringBuilder spannableStringBuilder = this.debugStringBuilder;
        if (spannableStringBuilder == null) {
            this.debugStringBuilder = new SpannableStringBuilder(str);
        } else {
            spannableStringBuilder.clear();
            this.debugStringBuilder.append((CharSequence) str);
        }
        if (this.debugLayout == null) {
            this.debugLayout = new DynamicLayout(str, this.debugTextPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
        int iSave = canvas.save();
        this.debugPaint.setARGB(220, 0, 0, 0);
        canvas.translate(0.0f, this.topBoundary);
        canvas.drawRect(0.0f, 0.0f, this.debugLayout.getWidth(), this.debugLayout.getHeight(), this.debugPaint);
        this.debugPaint.setARGB(PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN, 0, 0);
        this.debugLayout.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public void drawJitteredShadow(Canvas canvas) {
        float f = this.outerCircleAlpha * 0.2f;
        this.outerCircleShadowPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.outerCircleShadowPaint.setAlpha((int) f);
        int[] iArr = this.outerCircleCenter;
        canvas.drawCircle(iArr[0], iArr[1] + this.SHADOW_DIM, this.outerCircleRadius, this.outerCircleShadowPaint);
        this.outerCircleShadowPaint.setStyle(Paint.Style.STROKE);
        for (int i = 6; i > 0; i--) {
            this.outerCircleShadowPaint.setAlpha((int) ((i / 7.0f) * f));
            int[] iArr2 = this.outerCircleCenter;
            canvas.drawCircle(iArr2[0], iArr2[1] + this.SHADOW_DIM, this.outerCircleRadius + ((7 - i) * this.SHADOW_JITTER_DIM), this.outerCircleShadowPaint);
        }
    }

    public void drawTintedTarget() {
        Drawable drawable = this.target.icon;
        if (!this.shouldTintTarget || drawable == null) {
            this.tintedTarget = null;
            return;
        }
        if (this.tintedTarget != null) {
            return;
        }
        this.tintedTarget = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.tintedTarget);
        drawable.setColorFilter(new PorterDuffColorFilter(this.outerCirclePaint.getColor(), PorterDuff.Mode.SRC_ATOP));
        drawable.draw(canvas);
        drawable.setColorFilter(null);
    }

    public int[] getOuterCircleCenterPoint() {
        if (inGutter(this.targetBounds.centerY()) || this.target.forceCenteredTarget) {
            return new int[]{this.targetBounds.centerX(), this.targetBounds.centerY()};
        }
        int iMax = (Math.max(this.targetBounds.width(), this.targetBounds.height()) / 2) + this.TARGET_PADDING;
        int totalTextHeight = getTotalTextHeight();
        boolean z = ((this.targetBounds.centerY() - this.TARGET_RADIUS) - this.TARGET_PADDING) - totalTextHeight > 0;
        int iMin = Math.min(this.textBounds.left, this.targetBounds.left - iMax);
        int iMax2 = Math.max(this.textBounds.right, this.targetBounds.right + iMax);
        StaticLayout staticLayout = this.titleLayout;
        int height = staticLayout != null ? staticLayout.getHeight() : 0;
        Rect rect = this.targetBounds;
        return new int[]{(iMin + iMax2) / 2, z ? (((rect.centerY() - this.TARGET_RADIUS) - this.TARGET_PADDING) - totalTextHeight) + height : rect.centerY() + this.TARGET_RADIUS + this.TARGET_PADDING + height};
    }

    public int getOuterCircleRadius(int i, int i2, Rect rect, Rect rect2) {
        int iCenterX = rect2.centerX();
        int iCenterY = rect2.centerY();
        Rect rect3 = new Rect(iCenterX, iCenterY, iCenterX, iCenterY);
        int i3 = -((int) (this.TARGET_RADIUS * 1.1f));
        rect3.inset(i3, i3);
        return Math.max(maxDistanceToPoints(i, i2, rect), maxDistanceToPoints(i, i2, rect3)) + this.CIRCLE_PADDING;
    }

    public Rect getTextBounds() {
        int iCenterY;
        int totalTextHeight = getTotalTextHeight();
        int totalTextWidth = getTotalTextWidth();
        int iCenterY2 = ((this.targetBounds.centerY() - this.TARGET_RADIUS) - this.TARGET_PADDING) - totalTextHeight;
        if (iCenterY2 > this.topBoundary) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            rect.inset(0, this.TEXT_SAFE_AREA_PADDING);
            iCenterY = Math.max(iCenterY2, rect.top);
        } else {
            iCenterY = this.targetBounds.centerY() + this.TARGET_RADIUS + this.TARGET_PADDING;
        }
        int width = (getWidth() / 2) - this.targetBounds.centerX();
        int i = this.TEXT_POSITIONING_BIAS;
        if (width < 0) {
            i = -i;
        }
        int iMax = Math.max(this.TEXT_PADDING, (this.targetBounds.centerX() - i) - totalTextWidth);
        return new Rect(iMax, iCenterY, Math.min(getWidth() - this.TEXT_PADDING, totalTextWidth + iMax), totalTextHeight + iCenterY);
    }

    public int getTotalTextHeight() {
        StaticLayout staticLayout = this.titleLayout;
        if (staticLayout == null) {
            return 0;
        }
        if (this.descriptionLayout == null) {
            return staticLayout.getHeight() + this.TEXT_SPACING;
        }
        return this.descriptionLayout.getHeight() + staticLayout.getHeight() + this.TEXT_SPACING;
    }

    public int getTotalTextWidth() {
        StaticLayout staticLayout = this.titleLayout;
        if (staticLayout == null) {
            return 0;
        }
        return this.descriptionLayout == null ? staticLayout.getWidth() : Math.max(staticLayout.getWidth(), this.descriptionLayout.getWidth());
    }

    public float halfwayLerp(float f) {
        return f < 0.5f ? f / 0.5f : (1.0f - f) / 0.5f;
    }

    public boolean inGutter(int i) {
        int i2 = this.bottomBoundary;
        int i3 = this.GUTTER_DIM;
        return i2 > 0 ? i < i3 || i > i2 - i3 : i < i3 || i > getHeight() - this.GUTTER_DIM;
    }

    public void invalidateViewAndOutline(Rect rect) {
        invalidate(rect);
        if (this.outlineProvider != null) {
            invalidateOutline();
        }
    }

    public boolean isVisible() {
        return !this.isDismissed && this.visible;
    }

    public int maxDistanceToPoints(int i, int i2, Rect rect) {
        return (int) Math.max(distance(i, i2, rect.left, rect.top), Math.max(distance(i, i2, rect.right, rect.top), Math.max(distance(i, i2, rect.left, rect.bottom), distance(i, i2, rect.right, rect.bottom))));
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDismiss(false);
    }

    public void onDismiss(boolean z) {
        if (this.isDismissed) {
            return;
        }
        this.isDismissing = false;
        this.isDismissed = true;
        for (ValueAnimator valueAnimator : this.animators) {
            valueAnimator.cancel();
            valueAnimator.removeAllUpdateListeners();
        }
        ViewUtil.removeOnGlobalLayoutListener(getViewTreeObserver(), this.globalLayoutListener);
        this.visible = false;
        Listener listener = this.listener;
        if (listener != null) {
            listener.onTargetDismissed(this, z);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        StaticLayout staticLayout;
        if (this.isDismissed || this.outerCircleCenter == null) {
            return;
        }
        int i = this.topBoundary;
        if (i > 0 && this.bottomBoundary > 0) {
            canvas.clipRect(0, i, getWidth(), this.bottomBoundary);
        }
        int i2 = this.dimColor;
        if (i2 != -1) {
            canvas.drawColor(i2);
        }
        this.outerCirclePaint.setAlpha(this.outerCircleAlpha);
        if (this.shouldDrawShadow && this.outlineProvider == null) {
            int iSave = canvas.save();
            canvas.clipPath(this.outerCirclePath, Region.Op.DIFFERENCE);
            drawJitteredShadow(canvas);
            canvas.restoreToCount(iSave);
        }
        int[] iArr = this.outerCircleCenter;
        canvas.drawCircle(iArr[0], iArr[1], this.outerCircleRadius, this.outerCirclePaint);
        this.targetCirclePaint.setAlpha(this.targetCircleAlpha);
        int i3 = this.targetCirclePulseAlpha;
        if (i3 > 0) {
            this.targetCirclePulsePaint.setAlpha(i3);
            canvas.drawCircle(this.targetBounds.centerX(), this.targetBounds.centerY(), this.targetCirclePulseRadius, this.targetCirclePulsePaint);
        }
        canvas.drawCircle(this.targetBounds.centerX(), this.targetBounds.centerY(), this.targetCircleRadius, this.targetCirclePaint);
        int iSave2 = canvas.save();
        Rect rect = this.textBounds;
        canvas.translate(rect.left, rect.top);
        this.titlePaint.setAlpha(this.textAlpha);
        StaticLayout staticLayout2 = this.titleLayout;
        if (staticLayout2 != null) {
            staticLayout2.draw(canvas);
        }
        if (this.descriptionLayout != null && (staticLayout = this.titleLayout) != null) {
            canvas.translate(0.0f, staticLayout.getHeight() + this.TEXT_SPACING);
            this.descriptionPaint.setAlpha((int) (this.target.descriptionTextAlpha * this.textAlpha));
            this.descriptionLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        if (this.tintedTarget != null) {
            canvas.translate(this.targetBounds.centerX() - (this.tintedTarget.getWidth() / 2), this.targetBounds.centerY() - (this.tintedTarget.getHeight() / 2));
            canvas.drawBitmap(this.tintedTarget, 0.0f, 0.0f, this.targetCirclePaint);
        } else if (this.target.icon != null) {
            canvas.translate(this.targetBounds.centerX() - (this.target.icon.getBounds().width() / 2), this.targetBounds.centerY() - (this.target.icon.getBounds().height() / 2));
            this.target.icon.setAlpha(this.targetCirclePaint.getAlpha());
            this.target.icon.draw(canvas);
        }
        canvas.restoreToCount(iSave3);
        if (this.debug) {
            drawDebugInformation(canvas);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!isVisible() || !this.cancelable || i != 4) {
            return false;
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!isVisible() || !this.isInteractable || !this.cancelable || i != 4 || !keyEvent.isTracking() || keyEvent.isCanceled()) {
            return false;
        }
        this.isInteractable = false;
        Listener listener = this.listener;
        if (listener != null) {
            listener.onTargetCancel(this);
            return true;
        }
        new Listener().onTargetCancel(this);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.lastTouchX = motionEvent.getX();
        this.lastTouchY = motionEvent.getY();
        return super.onTouchEvent(motionEvent);
    }

    public void setDrawDebug(boolean z) {
        if (this.debug != z) {
            this.debug = z;
            postInvalidate();
        }
    }

    public void updateTextLayouts() {
        int iMin = Math.min(getWidth(), this.TEXT_MAX_WIDTH) - (this.TEXT_PADDING * 2);
        if (iMin <= 0) {
            return;
        }
        CharSequence charSequence = this.title;
        TextPaint textPaint = this.titlePaint;
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        this.titleLayout = new StaticLayout(charSequence, textPaint, iMin, alignment, 1.0f, 0.0f, false);
        if (this.description != null) {
            this.descriptionLayout = new StaticLayout(this.description, this.descriptionPaint, iMin, alignment, 1.0f, 0.0f, false);
        } else {
            this.descriptionLayout = null;
        }
    }

    public static TapTargetView showFor(Activity activity, TapTarget tapTarget, Listener listener) {
        if (activity != null) {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            TapTargetView tapTargetView = new TapTargetView(activity, viewGroup, (ViewGroup) viewGroup.findViewById(R.id.content), tapTarget, listener);
            viewGroup.addView(tapTargetView, layoutParams);
            return tapTargetView;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Activity is null");
        return null;
    }

    public static TapTargetView showFor(Activity activity, TapTarget tapTarget) {
        return showFor(activity, tapTarget, (Listener) null);
    }
}
