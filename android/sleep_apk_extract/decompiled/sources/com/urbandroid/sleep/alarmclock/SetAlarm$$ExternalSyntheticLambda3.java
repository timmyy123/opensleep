package com.urbandroid.sleep.alarmclock;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SetAlarm$$ExternalSyntheticLambda3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SetAlarm f$0;

    public /* synthetic */ SetAlarm$$ExternalSyntheticLambda3(SetAlarm setAlarm, int i) {
        this.$r8$classId = i;
        this.f$0 = setAlarm;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        SetAlarm setAlarm = this.f$0;
        switch (i2) {
            case 0:
                setAlarm.lambda$saveAlarmAndFinish$23(dialogInterface, i);
                break;
            case 1:
                setAlarm.lambda$onCreatePreference$14(dialogInterface, i);
                break;
            case 2:
                setAlarm.lambda$deleteAlarm$24(dialogInterface, i);
                break;
            default:
                setAlarm.lambda$onRequestPermissionsResult$25(dialogInterface, i);
                break;
        }
    }
}
