package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LottieDrawable$$ExternalSyntheticLambda9 implements LottieDrawable.LazyCompositionTask {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LottieDrawable f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ LottieDrawable$$ExternalSyntheticLambda9(LottieDrawable lottieDrawable, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = lottieDrawable;
        this.f$1 = i;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run(LottieComposition lottieComposition) {
        int i = this.$r8$classId;
        int i2 = this.f$1;
        LottieDrawable lottieDrawable = this.f$0;
        switch (i) {
            case 0:
                lottieDrawable.lambda$setFrame$15(i2, lottieComposition);
                break;
            case 1:
                lottieDrawable.lambda$setMaxFrame$7(i2, lottieComposition);
                break;
            default:
                lottieDrawable.lambda$setMinFrame$5(i2, lottieComposition);
                break;
        }
    }
}
