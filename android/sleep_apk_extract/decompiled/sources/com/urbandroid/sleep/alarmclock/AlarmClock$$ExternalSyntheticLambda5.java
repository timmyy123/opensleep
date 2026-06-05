package com.urbandroid.sleep.alarmclock;

import com.urbandroid.common.BaseActivity;
import com.urbandroid.sleep.alarmclock.UnlockFlow;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmClock$$ExternalSyntheticLambda5 implements UnlockFlow.UnlockFlowListener, Serializable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BaseActivity f$0;

    public /* synthetic */ AlarmClock$$ExternalSyntheticLambda5(BaseActivity baseActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = baseActivity;
    }

    @Override // com.urbandroid.sleep.alarmclock.UnlockFlow.UnlockFlowListener
    public final void onBackButton() {
        int i = this.$r8$classId;
        BaseActivity baseActivity = this.f$0;
        switch (i) {
            case 0:
                ((AlarmClock) baseActivity).lambda$startUnlockFlow$4479d2c5$1();
                break;
            default:
                ((UnlockActivity) baseActivity).lambda$onCreate$18e01f66$1();
                break;
        }
    }
}
