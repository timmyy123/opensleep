package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;

/* JADX INFO: loaded from: classes.dex */
public interface ShapeModifierContent extends Content {
    void addUpdateListener(BaseKeyframeAnimation.AnimationListener animationListener);

    ShapeData modifyShape(ShapeData shapeData);
}
