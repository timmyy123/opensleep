package com.polar.sdk.impl;

import androidx.core.util.Pair;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDBleApiImpl$$ExternalSyntheticLambda2 implements Action, Consumer {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BDBleApiImpl f$0;

    public /* synthetic */ BDBleApiImpl$$ExternalSyntheticLambda2(BDBleApiImpl bDBleApiImpl, int i) {
        this.$r8$classId = i;
        this.f$0 = bDBleApiImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Object obj) {
        BDBleApiImpl.deviceStateMonitorObserver$lambda$82(this.f$0, (Pair) obj);
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        int i = this.$r8$classId;
        BDBleApiImpl bDBleApiImpl = this.f$0;
        switch (i) {
            case 1:
                BDBleApiImpl.setupDevice$lambda$84(bDBleApiImpl);
                break;
            default:
                BDBleApiImpl.setupDevice$lambda$85(bDBleApiImpl);
                break;
        }
    }
}
