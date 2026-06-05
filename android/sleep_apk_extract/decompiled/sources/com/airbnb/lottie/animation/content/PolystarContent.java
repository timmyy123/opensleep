package com.airbnb.lottie.animation.content;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private final boolean hidden;
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final boolean isReversed;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private final PolystarShape.Type type;
    private final Path path = new Path();
    private final Path lastSegmentPath = new Path();
    private final PathMeasure lastSegmentPathMeasure = new PathMeasure();
    private final float[] lastSegmentPosition = new float[2];
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    /* JADX INFO: renamed from: com.airbnb.lottie.animation.content.PolystarContent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable;
        this.name = polystarShape.getName();
        PolystarShape.Type type = polystarShape.getType();
        this.type = type;
        this.hidden = polystarShape.isHidden();
        this.isReversed = polystarShape.isReversed();
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation = polystarShape.getPoints().createAnimation();
        this.pointsAnimation = floatKeyframeAnimationCreateAnimation;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationCreateAnimation = polystarShape.getPosition().createAnimation();
        this.positionAnimation = baseKeyframeAnimationCreateAnimation;
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation2 = polystarShape.getRotation().createAnimation();
        this.rotationAnimation = floatKeyframeAnimationCreateAnimation2;
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation3 = polystarShape.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = floatKeyframeAnimationCreateAnimation3;
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation4 = polystarShape.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = floatKeyframeAnimationCreateAnimation4;
        PolystarShape.Type type2 = PolystarShape.Type.STAR;
        if (type == type2) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation2);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation3);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation4);
        if (type == type2) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        floatKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
        floatKeyframeAnimationCreateAnimation2.addUpdateListener(this);
        floatKeyframeAnimationCreateAnimation3.addUpdateListener(this);
        floatKeyframeAnimationCreateAnimation4.addUpdateListener(this);
        if (type == type2) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    private void createPolygonPath() {
        double d;
        float f;
        float f2;
        float f3;
        int iFloor = (int) Math.floor(this.pointsAnimation.getValue().floatValue());
        double radians = Math.toRadians((this.rotationAnimation == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d2 = iFloor;
        float fFloatValue = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float fFloatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        double d3 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d3);
        float fSin = (float) (Math.sin(radians) * d3);
        this.path.moveTo(fCos, fSin);
        double d4 = (float) (6.283185307179586d / d2);
        double dCeil = Math.ceil(d2);
        double d5 = radians + d4;
        int i = 0;
        while (true) {
            double d6 = i;
            if (d6 >= dCeil) {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
            float fCos2 = (float) (Math.cos(d5) * d3);
            float fSin2 = (float) (Math.sin(d5) * d3);
            if (fFloatValue != 0.0f) {
                d = dCeil;
                f = fFloatValue;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f4 = fFloatValue2 * f * 0.25f;
                float f5 = f4 * fCos3;
                float f6 = f4 * fSin3;
                float fCos4 = ((float) Math.cos(dAtan22)) * f4;
                float fSin4 = f4 * ((float) Math.sin(dAtan22));
                if (d6 == d - 1.0d) {
                    this.lastSegmentPath.reset();
                    this.lastSegmentPath.moveTo(fCos, fSin);
                    float f7 = fCos - f5;
                    float f8 = fSin - f6;
                    float f9 = fCos2 + fCos4;
                    float f10 = fSin2 + fSin4;
                    f2 = fCos2;
                    f3 = fSin2;
                    this.lastSegmentPath.cubicTo(f7, f8, f9, f10, f2, f3);
                    this.lastSegmentPathMeasure.setPath(this.lastSegmentPath, false);
                    PathMeasure pathMeasure = this.lastSegmentPathMeasure;
                    pathMeasure.getPosTan(pathMeasure.getLength() * 0.9999f, this.lastSegmentPosition, null);
                    Path path = this.path;
                    float[] fArr = this.lastSegmentPosition;
                    path.cubicTo(f7, f8, f9, f10, fArr[0], fArr[1]);
                } else {
                    f2 = fCos2;
                    f3 = fSin2;
                    this.path.cubicTo(fCos - f5, fSin - f6, f2 + fCos4, f3 + fSin4, f2, f3);
                }
                fCos = f2;
                fSin = f3;
            } else {
                fCos = fCos2;
                fSin = fSin2;
                d = dCeil;
                f = fFloatValue;
                if (d6 == d - 1.0d) {
                    i++;
                    dCeil = d;
                    fFloatValue = f;
                } else {
                    this.path.lineTo(fCos, fSin);
                }
            }
            d5 += d4;
            i++;
            dCeil = d;
            fFloatValue = f;
        }
    }

    private void createStarPath() {
        float f;
        float f2;
        int i;
        float fCos;
        float fSin;
        float f3;
        float f4;
        double d;
        float fM;
        int i2;
        float f5;
        double d2;
        float f6;
        float f7;
        double d3;
        float f8;
        float f9;
        float fFloatValue = this.pointsAnimation.getValue().floatValue();
        double radians = Math.toRadians((this.rotationAnimation == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f10 = (float) (6.283185307179586d / d4);
        if (this.isReversed) {
            f10 *= -1.0f;
        }
        float f11 = f10 / 2.0f;
        float f12 = fFloatValue - ((int) fFloatValue);
        int i3 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (double) ((1.0f - f12) * f11);
        }
        float fFloatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        float fFloatValue3 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.innerRoundednessAnimation;
        float fFloatValue4 = baseKeyframeAnimation != null ? baseKeyframeAnimation.getValue().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.outerRoundednessAnimation;
        float fFloatValue5 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            fM = FileInsert$$ExternalSyntheticOutline0.m(fFloatValue2, fFloatValue3, f12, fFloatValue3);
            f2 = 0.0f;
            i = i3;
            double d5 = fM;
            f = 2.0f;
            float fCos2 = (float) (Math.cos(radians) * d5);
            fSin = (float) (Math.sin(radians) * d5);
            this.path.moveTo(fCos2, fSin);
            d = radians + ((double) ((f10 * f12) / 2.0f));
            f3 = f12;
            fCos = fCos2;
            f4 = f11;
        } else {
            f = 2.0f;
            f2 = 0.0f;
            i = i3;
            double d6 = fFloatValue2;
            fCos = (float) (Math.cos(radians) * d6);
            fSin = (float) (d6 * Math.sin(radians));
            this.path.moveTo(fCos, fSin);
            f3 = f12;
            f4 = f11;
            d = radians + ((double) f4);
            fM = 0.0f;
        }
        double dCeil = Math.ceil(d4) * 2.0d;
        int i4 = 0;
        boolean z = false;
        double d7 = d;
        float f13 = fSin;
        float f14 = fCos;
        double d8 = d7;
        while (true) {
            double d9 = i4;
            if (d9 >= dCeil) {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
            float f15 = z ? fFloatValue2 : fFloatValue3;
            if (fM == f2 || d9 != dCeil - 2.0d) {
                i2 = i4;
                f5 = f4;
            } else {
                i2 = i4;
                f5 = (f10 * f3) / f;
            }
            if (fM == f2 || d9 != dCeil - 1.0d) {
                d2 = d9;
                f6 = f15;
            } else {
                d2 = d9;
                f6 = fM;
            }
            double d10 = f6;
            float fCos3 = (float) (Math.cos(d8) * d10);
            float f16 = f10;
            float fSin2 = (float) (Math.sin(d8) * d10);
            if (fFloatValue4 == f2 && fFloatValue5 == f2) {
                this.path.lineTo(fCos3, fSin2);
                f9 = fCos3;
                f8 = fSin2;
                f7 = f4;
                d3 = d8;
            } else {
                f7 = f4;
                d3 = d8;
                double dAtan2 = (float) (Math.atan2(f13, f14) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                float f17 = f14;
                float f18 = f13;
                f8 = fSin2;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin4 = (float) Math.sin(dAtan22);
                float f19 = z ? fFloatValue4 : fFloatValue5;
                float f20 = z ? fFloatValue5 : fFloatValue4;
                float f21 = (z ? fFloatValue3 : fFloatValue2) * f19 * 0.47829f;
                float f22 = fCos4 * f21;
                float f23 = f21 * fSin3;
                float f24 = (z ? fFloatValue2 : fFloatValue3) * f20 * 0.47829f;
                float f25 = fCos5 * f24;
                float f26 = f24 * fSin4;
                if (i != 0) {
                    if (i2 == 0) {
                        f22 *= f3;
                        f23 *= f3;
                    } else if (d2 == dCeil - 1.0d) {
                        f25 *= f3;
                        f26 *= f3;
                    }
                }
                f9 = fCos3;
                this.path.cubicTo(f17 - f22, f18 - f23, fCos3 + f25, f8 + f26, f9, f8);
            }
            d8 = d3 + ((double) f5);
            z = !z;
            i4 = i2 + 1;
            f4 = f7;
            f14 = f9;
            f13 = f8;
            f10 = f16;
        }
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        boolean z = this.isPathValid;
        Path path = this.path;
        if (z) {
            return path;
        }
        path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int i = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (i == 1) {
            createStarPath();
        } else if (i == 2) {
            createPolygonPath();
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.addTrimPath(trimPathContent);
                    trimPathContent.addListener(this);
                }
            }
        }
    }
}
