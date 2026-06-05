package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WorkerKt$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AtomicBoolean f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;
    public final /* synthetic */ Function0 f$2;

    public /* synthetic */ WorkerKt$$ExternalSyntheticLambda2(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, Function0 function0, int i) {
        this.$r8$classId = i;
        this.f$0 = atomicBoolean;
        this.f$1 = completer;
        this.f$2 = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Function0 function0 = this.f$2;
        CallbackToFutureAdapter.Completer completer = this.f$1;
        AtomicBoolean atomicBoolean = this.f$0;
        switch (i) {
            case 0:
                WorkerKt.future$lambda$2$lambda$1(atomicBoolean, completer, function0);
                break;
            default:
                ListenableFutureKt.executeAsync$lambda$4$lambda$3(atomicBoolean, completer, function0);
                break;
        }
    }
}
