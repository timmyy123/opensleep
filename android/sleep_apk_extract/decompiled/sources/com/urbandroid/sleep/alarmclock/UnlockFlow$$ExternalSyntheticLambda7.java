package com.urbandroid.sleep.alarmclock;

import android.app.Activity;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class UnlockFlow$$ExternalSyntheticLambda7 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Activity f$1;

    public /* synthetic */ UnlockFlow$$ExternalSyntheticLambda7(Activity activity, int i, boolean z) {
        this.$r8$classId = i;
        this.f$0 = z;
        this.f$1 = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        Activity activity = this.f$1;
        boolean z = this.f$0;
        switch (i2) {
            case 0:
                UnlockFlow.lambda$showUnlockDialog$26(z, activity, dialogInterface, i);
                break;
            default:
                UnlockFlow.lambda$showWarningDialog$27(z, activity, dialogInterface, i);
                break;
        }
    }
}
