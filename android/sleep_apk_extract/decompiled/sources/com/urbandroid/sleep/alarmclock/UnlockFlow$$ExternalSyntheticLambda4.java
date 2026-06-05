package com.urbandroid.sleep.alarmclock;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class UnlockFlow$$ExternalSyntheticLambda4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;

    public /* synthetic */ UnlockFlow$$ExternalSyntheticLambda4(Context context, int i) {
        this.$r8$classId = i;
        this.f$0 = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        Context context = this.f$0;
        switch (i2) {
            case 0:
                UnlockFlow.lambda$showUnlockDialog$23((Activity) context, dialogInterface, i);
                break;
            case 1:
                AlarmClock.lambda$showReleaseNotes$22((Activity) context, dialogInterface, i);
                break;
            default:
                AlarmClock.lambda$showGarminDialog$5(context, dialogInterface, i);
                break;
        }
    }
}
