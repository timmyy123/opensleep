package com.airbnb.lottie.model.animatable;

/* JADX INFO: loaded from: classes.dex */
public class AnimatableTextStyle {
    public final AnimatableColorValue color;
    public final AnimatableIntegerValue opacity;
    public final AnimatableColorValue stroke;
    public final AnimatableFloatValue strokeWidth;
    public final AnimatableFloatValue tracking;

    public AnimatableTextStyle(AnimatableColorValue animatableColorValue, AnimatableColorValue animatableColorValue2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableIntegerValue animatableIntegerValue) {
        this.color = animatableColorValue;
        this.stroke = animatableColorValue2;
        this.strokeWidth = animatableFloatValue;
        this.tracking = animatableFloatValue2;
        this.opacity = animatableIntegerValue;
    }
}
