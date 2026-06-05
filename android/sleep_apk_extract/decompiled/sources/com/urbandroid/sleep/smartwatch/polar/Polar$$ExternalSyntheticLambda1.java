package com.urbandroid.sleep.smartwatch.polar;

import com.urbandroid.common.logging.Logger;
import io.reactivex.rxjava3.functions.Action;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Polar$$ExternalSyntheticLambda1 implements Action {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Polar$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                Logger.logInfo("Polar: scan completed");
                break;
            case 1:
                Logger.logInfo("Polar: scan completed");
                break;
            case 2:
                Logger.logInfo("Polar: PP streaming end");
                break;
            case 3:
                Logger.logInfo("Polar: HR streaming end");
                break;
            default:
                Logger.logInfo("Polar: ACC streaming end");
                break;
        }
    }
}
