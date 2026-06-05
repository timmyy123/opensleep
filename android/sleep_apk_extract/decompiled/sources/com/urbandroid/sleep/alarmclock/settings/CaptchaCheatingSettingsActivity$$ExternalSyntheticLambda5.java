package com.urbandroid.sleep.alarmclock.settings;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class CaptchaCheatingSettingsActivity$$ExternalSyntheticLambda5 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CaptchaCheatingSettingsActivity f$0;

    public /* synthetic */ CaptchaCheatingSettingsActivity$$ExternalSyntheticLambda5(CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = captchaCheatingSettingsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity = this.f$0;
        switch (i) {
            case 0:
                captchaCheatingSettingsActivity.startWagerRefundFlow(false);
                break;
            case 1:
                CaptchaCheatingSettingsActivity.showRefundErrorDispute$lambda$0(captchaCheatingSettingsActivity, view);
                break;
            default:
                CaptchaCheatingSettingsActivity.startWagerRefundFlow$default(captchaCheatingSettingsActivity, false, 1, null);
                break;
        }
    }
}
