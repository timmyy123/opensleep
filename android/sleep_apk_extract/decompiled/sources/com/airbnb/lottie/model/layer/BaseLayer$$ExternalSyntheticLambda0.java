package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BaseLayer$$ExternalSyntheticLambda0 implements BaseKeyframeAnimation.AnimationListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ BaseLayer$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void onValueChanged() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((BaseLayer) obj).lambda$setupInOutAnimations$0();
                break;
            case 1:
                ((TransformKeyframeAnimation) obj).lambda$addListener$0();
                break;
            case 2:
                ((TransformKeyframeAnimation) obj).lambda$addListener$1();
                break;
            default:
                ((TransformKeyframeAnimation) obj).lambda$addListener$2();
                break;
        }
    }
}
