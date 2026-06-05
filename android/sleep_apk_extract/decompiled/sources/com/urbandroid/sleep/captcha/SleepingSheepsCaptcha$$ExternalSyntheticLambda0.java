package com.urbandroid.sleep.captcha;

import com.urbandroid.sleep.captcha.SleepingSheepsCaptcha;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SleepingSheepsCaptcha$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SleepingSheepsCaptcha f$0;

    public /* synthetic */ SleepingSheepsCaptcha$$ExternalSyntheticLambda0(SleepingSheepsCaptcha sleepingSheepsCaptcha, int i) {
        this.$r8$classId = i;
        this.f$0 = sleepingSheepsCaptcha;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        SleepingSheepsCaptcha sleepingSheepsCaptcha = this.f$0;
        switch (i) {
            case 0:
                SleepingSheepsCaptcha.onTouch$lambda$1(sleepingSheepsCaptcha);
                break;
            case 1:
                SleepingSheepsCaptcha.RedrawThread.run$lambda$0(sleepingSheepsCaptcha);
                break;
            default:
                SleepingSheepsCaptcha.onTouch$lambda$2(sleepingSheepsCaptcha);
                break;
        }
    }
}
