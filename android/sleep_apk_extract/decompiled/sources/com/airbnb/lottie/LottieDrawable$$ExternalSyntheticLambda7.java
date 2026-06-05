package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LottieDrawable$$ExternalSyntheticLambda7 implements LottieDrawable.LazyCompositionTask {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LottieDrawable f$0;
    public final /* synthetic */ float f$1;

    public /* synthetic */ LottieDrawable$$ExternalSyntheticLambda7(LottieDrawable lottieDrawable, float f, int i) {
        this.$r8$classId = i;
        this.f$0 = lottieDrawable;
        this.f$1 = f;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run(LottieComposition lottieComposition) {
        int i = this.$r8$classId;
        float f = this.f$1;
        LottieDrawable lottieDrawable = this.f$0;
        switch (i) {
            case 0:
                lottieDrawable.lambda$setMinProgress$6(f, lottieComposition);
                break;
            case 1:
                lottieDrawable.lambda$setMaxProgress$8(f, lottieComposition);
                break;
            default:
                lottieDrawable.lambda$setProgress$16(f, lottieComposition);
                break;
        }
    }
}
