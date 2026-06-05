package com.urbandroid.sleep.captcha;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LOLCaptcha$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AbstractCaptchaActivity f$0;

    public /* synthetic */ LOLCaptcha$$ExternalSyntheticLambda0(AbstractCaptchaActivity abstractCaptchaActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = abstractCaptchaActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        AbstractCaptchaActivity abstractCaptchaActivity = this.f$0;
        switch (i) {
            case 0:
                ((LOLCaptcha) abstractCaptchaActivity).userInteraction();
                break;
            default:
                ((DreamDiaryCaptcha) abstractCaptchaActivity).lambda$onCreate$1(view);
                break;
        }
    }
}
