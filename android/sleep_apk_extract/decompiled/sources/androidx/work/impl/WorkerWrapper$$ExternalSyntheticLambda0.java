package androidx.work.impl;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WorkerWrapper$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ WorkerWrapper f$0;

    public /* synthetic */ WorkerWrapper$$ExternalSyntheticLambda0(WorkerWrapper workerWrapper, int i) {
        this.$r8$classId = i;
        this.f$0 = workerWrapper;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.$r8$classId;
        WorkerWrapper workerWrapper = this.f$0;
        switch (i) {
            case 0:
                return WorkerWrapper.runWorker$lambda$1(workerWrapper);
            default:
                return WorkerWrapper.trySetRunning$lambda$14(workerWrapper);
        }
    }
}
