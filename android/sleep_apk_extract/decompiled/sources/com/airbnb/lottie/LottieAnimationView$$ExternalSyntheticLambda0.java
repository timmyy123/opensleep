package com.airbnb.lottie;

import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LottieAnimationView$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ LottieAnimationView$$ExternalSyntheticLambda0(int i, Object obj, String str) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.$r8$classId;
        String str = this.f$1;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return ((LottieAnimationView) obj).lambda$fromAssets$2(str);
            default:
                return LottieCompositionFactory.fromJsonInputStreamSync((InputStream) obj, str);
        }
    }
}
