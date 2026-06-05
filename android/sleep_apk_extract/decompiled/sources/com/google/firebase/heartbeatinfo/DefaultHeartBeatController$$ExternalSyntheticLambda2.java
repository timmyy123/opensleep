package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class DefaultHeartBeatController$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ DefaultHeartBeatController f$0;

    public /* synthetic */ DefaultHeartBeatController$$ExternalSyntheticLambda2(DefaultHeartBeatController defaultHeartBeatController, int i) {
        this.$r8$classId = i;
        this.f$0 = defaultHeartBeatController;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.$r8$classId;
        DefaultHeartBeatController defaultHeartBeatController = this.f$0;
        switch (i) {
            case 0:
                return defaultHeartBeatController.lambda$getHeartBeatsHeader$1();
            default:
                return defaultHeartBeatController.lambda$registerHeartBeat$0();
        }
    }
}
