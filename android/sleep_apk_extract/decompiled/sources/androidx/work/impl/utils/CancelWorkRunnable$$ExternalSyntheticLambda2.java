package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CancelWorkRunnable$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ WorkDatabase f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ WorkManagerImpl f$2;

    public /* synthetic */ CancelWorkRunnable$$ExternalSyntheticLambda2(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl, int i) {
        this.$r8$classId = i;
        this.f$0 = workDatabase;
        this.f$1 = str;
        this.f$2 = workManagerImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        WorkManagerImpl workManagerImpl = this.f$2;
        String str = this.f$1;
        WorkDatabase workDatabase = this.f$0;
        switch (i) {
            case 0:
                CancelWorkRunnable.forNameInline$lambda$5(workDatabase, str, workManagerImpl);
                break;
            default:
                CancelWorkRunnable.forTag$lambda$3$lambda$2(workDatabase, str, workManagerImpl);
                break;
        }
    }
}
