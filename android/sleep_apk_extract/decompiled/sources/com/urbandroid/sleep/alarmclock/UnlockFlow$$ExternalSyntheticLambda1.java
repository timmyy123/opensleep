package com.urbandroid.sleep.alarmclock;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class UnlockFlow$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ UnlockFlow f$0;

    public /* synthetic */ UnlockFlow$$ExternalSyntheticLambda1(UnlockFlow unlockFlow, int i) {
        this.$r8$classId = i;
        this.f$0 = unlockFlow;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        UnlockFlow unlockFlow = this.f$0;
        switch (i) {
            case 0:
                unlockFlow.lambda$onStart$16(view);
                break;
            case 1:
                unlockFlow.lambda$onCreate$3(view);
                break;
            case 2:
                unlockFlow.lambda$onCreate$6(view);
                break;
            case 3:
                unlockFlow.lambda$onCreate$8(view);
                break;
            case 4:
                unlockFlow.lambda$onCreate$9(view);
                break;
            case 5:
                unlockFlow.lambda$onCreate$10(view);
                break;
            case 6:
                unlockFlow.lambda$onStart$12(view);
                break;
            case 7:
                unlockFlow.lambda$onStart$13(view);
                break;
            case 8:
                unlockFlow.lambda$onStart$14(view);
                break;
            case 9:
                unlockFlow.lambda$onStart$17(view);
                break;
            default:
                unlockFlow.lambda$onStart$18(view);
                break;
        }
    }
}
