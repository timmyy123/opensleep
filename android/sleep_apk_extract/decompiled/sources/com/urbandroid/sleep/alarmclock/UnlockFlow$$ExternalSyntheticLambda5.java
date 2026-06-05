package com.urbandroid.sleep.alarmclock;

import android.app.Activity;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class UnlockFlow$$ExternalSyntheticLambda5 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Activity f$1;

    public /* synthetic */ UnlockFlow$$ExternalSyntheticLambda5(Activity activity, int i, boolean z) {
        this.$r8$classId = i;
        this.f$0 = z;
        this.f$1 = activity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        int i = this.$r8$classId;
        Activity activity = this.f$1;
        boolean z = this.f$0;
        switch (i) {
            case 0:
                UnlockFlow.lambda$showUnlockDialog$24(z, activity, dialogInterface);
                break;
            default:
                UnlockFlow.lambda$showWarningDialog$28(z, activity, dialogInterface);
                break;
        }
    }
}
