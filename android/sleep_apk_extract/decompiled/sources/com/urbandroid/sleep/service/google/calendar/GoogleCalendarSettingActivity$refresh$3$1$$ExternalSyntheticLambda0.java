package com.urbandroid.sleep.service.google.calendar;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class GoogleCalendarSettingActivity$refresh$3$1$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ GoogleCalendarSettingActivity$refresh$3$1$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                GoogleCalendarSettingActivity$refresh$3$1.invokeSuspend$lambda$0(dialogInterface, i);
                break;
            case 1:
                GoogleCalendarSettingActivity$refresh$2$1$1.invokeSuspend$lambda$0(dialogInterface, i);
                break;
            default:
                GoogleCalendarSettingActivity$refresh$5$1.invokeSuspend$lambda$0(dialogInterface, i);
                break;
        }
    }
}
