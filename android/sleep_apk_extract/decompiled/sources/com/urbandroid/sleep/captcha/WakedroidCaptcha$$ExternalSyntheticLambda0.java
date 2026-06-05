package com.urbandroid.sleep.captcha;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class WakedroidCaptcha$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ WakedroidCaptcha f$0;

    public /* synthetic */ WakedroidCaptcha$$ExternalSyntheticLambda0(WakedroidCaptcha wakedroidCaptcha, int i) {
        this.$r8$classId = i;
        this.f$0 = wakedroidCaptcha;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        WakedroidCaptcha wakedroidCaptcha = this.f$0;
        switch (i) {
            case 0:
                wakedroidCaptcha.lambda$new$4();
                break;
            case 1:
                wakedroidCaptcha.lambda$update$5();
                break;
            default:
                wakedroidCaptcha.lambda$update$6();
                break;
        }
    }
}
