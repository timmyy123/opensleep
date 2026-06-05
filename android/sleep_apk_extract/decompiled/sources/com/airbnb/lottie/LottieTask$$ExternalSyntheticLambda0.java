package com.airbnb.lottie;

import com.airbnb.lottie.utils.Utils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LottieTask$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ LottieTask$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((LottieTask) obj).notifyListenersInternal();
                break;
            default:
                Utils.closeQuietly((InputStream) obj);
                break;
        }
    }
}
