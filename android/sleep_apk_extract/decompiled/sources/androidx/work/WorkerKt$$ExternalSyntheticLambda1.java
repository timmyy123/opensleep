package androidx.work;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WorkerKt$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AtomicBoolean f$0;

    public /* synthetic */ WorkerKt$$ExternalSyntheticLambda1(AtomicBoolean atomicBoolean, int i) {
        this.$r8$classId = i;
        this.f$0 = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        AtomicBoolean atomicBoolean = this.f$0;
        switch (i) {
            case 0:
                atomicBoolean.set(true);
                break;
            default:
                atomicBoolean.set(true);
                break;
        }
    }
}
