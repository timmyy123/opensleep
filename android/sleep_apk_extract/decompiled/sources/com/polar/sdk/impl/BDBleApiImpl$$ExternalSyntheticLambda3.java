package com.polar.sdk.impl;

import io.reactivex.rxjava3.functions.Action;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDBleApiImpl$$ExternalSyntheticLambda3 implements Action {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BDBleApiImpl f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ BDBleApiImpl$$ExternalSyntheticLambda3(BDBleApiImpl bDBleApiImpl, String str, int i) {
        this.$r8$classId = i;
        this.f$0 = bDBleApiImpl;
        this.f$1 = str;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        int i = this.$r8$classId;
        String str = this.f$1;
        BDBleApiImpl bDBleApiImpl = this.f$0;
        switch (i) {
            case 0:
                BDBleApiImpl.connectToDevice$lambda$6$lambda$5(bDBleApiImpl, str);
                break;
            case 1:
                BDBleApiImpl$setupDevice$disposable$2.apply$lambda$0(bDBleApiImpl, str);
                break;
            default:
                BDBleApiImpl$setupDevice$disposable$2.apply$lambda$3(bDBleApiImpl, str);
                break;
        }
    }
}
