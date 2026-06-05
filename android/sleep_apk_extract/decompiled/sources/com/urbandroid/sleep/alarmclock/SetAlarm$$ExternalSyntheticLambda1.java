package com.urbandroid.sleep.alarmclock;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SetAlarm$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ SetAlarm$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                dialogInterface.dismiss();
                break;
            case 1:
                AlarmClock.lambda$startHomeScreenSelectionDialog$31(dialogInterface, i);
                break;
            default:
                AlarmClock.lambda$showRatingDialog$27(dialogInterface, i);
                break;
        }
    }
}
