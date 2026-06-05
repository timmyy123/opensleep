package androidx.work;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Worker$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Worker f$0;

    public /* synthetic */ Worker$$ExternalSyntheticLambda0(Worker worker, int i) {
        this.$r8$classId = i;
        this.f$0 = worker;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Worker worker = this.f$0;
        switch (i) {
            case 0:
                return worker.doWork();
            default:
                return worker.getForegroundInfo();
        }
    }
}
