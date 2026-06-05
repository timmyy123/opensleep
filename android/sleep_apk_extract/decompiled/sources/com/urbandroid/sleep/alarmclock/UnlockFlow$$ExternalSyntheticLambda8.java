package com.urbandroid.sleep.alarmclock;

import android.view.View;
import com.urbandroid.sleep.trial.JavaBilling;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class UnlockFlow$$ExternalSyntheticLambda8 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ JavaBilling f$0;

    public /* synthetic */ UnlockFlow$$ExternalSyntheticLambda8(JavaBilling javaBilling, int i) {
        this.$r8$classId = i;
        this.f$0 = javaBilling;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        JavaBilling javaBilling = this.f$0;
        switch (i) {
            case 0:
                UnlockFlow.lambda$setBilling$0(javaBilling, view);
                break;
            case 1:
                UnlockFlow.lambda$setBilling$2(javaBilling, view);
                break;
            case 2:
                UnlockFlow.lambda$loadPrices$19(javaBilling, view);
                break;
            default:
                UnlockFlow.lambda$setBilling$1(javaBilling, view);
                break;
        }
    }
}
