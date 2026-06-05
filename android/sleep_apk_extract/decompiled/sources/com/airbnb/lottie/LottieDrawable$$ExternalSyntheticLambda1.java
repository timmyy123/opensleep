package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LottieDrawable$$ExternalSyntheticLambda1 implements LottieDrawable.LazyCompositionTask {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LottieDrawable f$0;

    public /* synthetic */ LottieDrawable$$ExternalSyntheticLambda1(LottieDrawable lottieDrawable, int i) {
        this.$r8$classId = i;
        this.f$0 = lottieDrawable;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run(LottieComposition lottieComposition) {
        int i = this.$r8$classId;
        LottieDrawable lottieDrawable = this.f$0;
        switch (i) {
            case 0:
                lottieDrawable.lambda$resumeAnimation$4(lottieComposition);
                break;
            default:
                lottieDrawable.lambda$playAnimation$3(lottieComposition);
                break;
        }
    }
}
