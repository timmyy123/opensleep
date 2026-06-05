package com.urbandroid.sleep.captcha;

import com.urbandroid.sleep.captcha.ShakeItCaptcha;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BaseScanningCaptcha$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ BaseScanningCaptcha$$ExternalSyntheticLambda6(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((BaseScanningCaptcha) obj).lambda$onCreate$5();
                break;
            default:
                ((ShakeItCaptcha.AccelThread) obj).lambda$run$0();
                break;
        }
    }
}
