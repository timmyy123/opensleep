package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LottieDrawable$$ExternalSyntheticLambda0 implements LottieDrawable.LazyCompositionTask {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LottieDrawable f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ LottieDrawable$$ExternalSyntheticLambda0(LottieDrawable lottieDrawable, String str, int i) {
        this.$r8$classId = i;
        this.f$0 = lottieDrawable;
        this.f$1 = str;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run(LottieComposition lottieComposition) {
        int i = this.$r8$classId;
        String str = this.f$1;
        LottieDrawable lottieDrawable = this.f$0;
        switch (i) {
            case 0:
                lottieDrawable.lambda$setMinAndMaxFrame$11(str, lottieComposition);
                break;
            case 1:
                lottieDrawable.lambda$setMaxFrame$10(str, lottieComposition);
                break;
            default:
                lottieDrawable.lambda$setMinFrame$9(str, lottieComposition);
                break;
        }
    }
}
