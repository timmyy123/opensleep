package androidx.appfunctions;

import android.os.CancellationSignal;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppFunctionService$$ExternalSyntheticLambda0 implements CancellationSignal.OnCancelListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Job f$0;

    public /* synthetic */ AppFunctionService$$ExternalSyntheticLambda0(Job job, int i) {
        this.$r8$classId = i;
        this.f$0 = job;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        int i = this.$r8$classId;
        Job job = this.f$0;
        switch (i) {
            case 0:
                Job.DefaultImpls.cancel$default(job, null, 1, null);
                break;
            default:
                Job.DefaultImpls.cancel$default(job, null, 1, null);
                break;
        }
    }
}
