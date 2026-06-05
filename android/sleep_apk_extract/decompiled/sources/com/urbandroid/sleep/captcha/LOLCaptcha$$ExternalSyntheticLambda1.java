package com.urbandroid.sleep.captcha;

import com.urbandroid.sleep.captcha.LOLCaptcha;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LOLCaptcha$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LOLCaptcha f$0;

    public /* synthetic */ LOLCaptcha$$ExternalSyntheticLambda1(LOLCaptcha lOLCaptcha, int i) {
        this.$r8$classId = i;
        this.f$0 = lOLCaptcha;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        LOLCaptcha lOLCaptcha = this.f$0;
        switch (i) {
            case 0:
                lOLCaptcha.solved();
                break;
            default:
                LOLCaptcha.LaughterThread.run$lambda$0(lOLCaptcha);
                break;
        }
    }
}
