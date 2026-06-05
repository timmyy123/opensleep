package com.urbandroid.sleep.alarmclock;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmClock$$ExternalSyntheticLambda3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AlarmClock f$0;

    public /* synthetic */ AlarmClock$$ExternalSyntheticLambda3(AlarmClock alarmClock, int i) {
        this.$r8$classId = i;
        this.f$0 = alarmClock;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        AlarmClock alarmClock = this.f$0;
        switch (i2) {
            case 0:
                alarmClock.lambda$onCreateDialog$11(dialogInterface, i);
                break;
            case 1:
                alarmClock.lambda$handlePermissions$13(dialogInterface, i);
                break;
            case 2:
                alarmClock.lambda$handlePermissions$14(dialogInterface, i);
                break;
            case 3:
                alarmClock.lambda$handlePermissions$15(dialogInterface, i);
                break;
            case 4:
                alarmClock.lambda$handlePermissions$16(dialogInterface, i);
                break;
            case 5:
                alarmClock.lambda$showRatingDialog$26(dialogInterface, i);
                break;
            default:
                alarmClock.lambda$onCreateDialog$12(dialogInterface, i);
                break;
        }
    }
}
