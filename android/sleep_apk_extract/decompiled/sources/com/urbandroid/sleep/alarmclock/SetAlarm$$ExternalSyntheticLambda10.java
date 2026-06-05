package com.urbandroid.sleep.alarmclock;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SetAlarm$$ExternalSyntheticLambda10 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SetAlarm f$0;

    public /* synthetic */ SetAlarm$$ExternalSyntheticLambda10(SetAlarm setAlarm, int i) {
        this.$r8$classId = i;
        this.f$0 = setAlarm;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        SetAlarm setAlarm = this.f$0;
        switch (i) {
            case 0:
                setAlarm.lambda$onCreatePreference$17(view);
                break;
            case 1:
                setAlarm.lambda$onCreatePreference$9(view);
                break;
            default:
                setAlarm.lambda$onCreatePreference$6(view);
                break;
        }
    }
}
