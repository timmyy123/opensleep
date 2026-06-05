package com.urbandroid.sleep.alarmclock;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmClock$$ExternalSyntheticLambda8 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AlarmClock f$0;

    public /* synthetic */ AlarmClock$$ExternalSyntheticLambda8(AlarmClock alarmClock, int i) {
        this.$r8$classId = i;
        this.f$0 = alarmClock;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        AlarmClock alarmClock = this.f$0;
        switch (i) {
            case 0:
                alarmClock.lambda$onWindowFocusChanged$6(view);
                break;
            case 1:
                alarmClock.lambda$onCreate$2(view);
                break;
            case 2:
                alarmClock.lambda$onCreate$4(view);
                break;
            case 3:
                alarmClock.lambda$refreshTrialStatusForTabs$18(view);
                break;
            case 4:
                alarmClock.lambda$refreshTrialStatusForTabs$19(view);
                break;
            case 5:
                alarmClock.lambda$updateFabState$20(view);
                break;
            case 6:
                alarmClock.lambda$showEuConsent$10(view);
                break;
            default:
                alarmClock.lambda$setupTrial$17(view);
                break;
        }
    }
}
