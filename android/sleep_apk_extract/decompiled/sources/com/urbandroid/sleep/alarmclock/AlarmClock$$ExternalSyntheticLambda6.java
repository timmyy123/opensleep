package com.urbandroid.sleep.alarmclock;

import com.urbandroid.sleep.trial.IBillingServiceStatusListener;
import com.urbandroid.sleep.trial.IBillingStatusListener;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmClock$$ExternalSyntheticLambda6 implements IBillingServiceStatusListener, IBillingStatusListener {
    public final /* synthetic */ AlarmClock f$0;

    public /* synthetic */ AlarmClock$$ExternalSyntheticLambda6(AlarmClock alarmClock) {
        this.f$0 = alarmClock;
    }

    @Override // com.urbandroid.sleep.trial.IBillingServiceStatusListener
    public void onServiceConnected() {
        this.f$0.lambda$startSleepCloudPurchaseIfNeeded$0();
    }

    @Override // com.urbandroid.sleep.trial.IBillingStatusListener
    public void onStatusDetected(String str, IBillingStatusListener.Status status) {
        this.f$0.lambda$startSleepCloudPurchaseIfNeeded$1(str, status);
    }
}
