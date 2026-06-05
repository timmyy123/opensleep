package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class MutexImpl$$ExternalSyntheticLambda2 implements Function3 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MutexImpl f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ MutexImpl$$ExternalSyntheticLambda2(MutexImpl mutexImpl, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = mutexImpl;
        this.f$1 = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.$r8$classId;
        Object obj4 = this.f$1;
        MutexImpl mutexImpl = this.f$0;
        switch (i) {
            case 0:
                return MutexImpl.onSelectCancellationUnlockConstructor$lambda$0$0(mutexImpl, obj4, (Throwable) obj, obj2, (CoroutineContext) obj3);
            default:
                return MutexImpl.CancellableContinuationWithOwner.tryResume$lambda$1(mutexImpl, (MutexImpl.CancellableContinuationWithOwner) obj4, (Throwable) obj, (Unit) obj2, (CoroutineContext) obj3);
        }
    }
}
