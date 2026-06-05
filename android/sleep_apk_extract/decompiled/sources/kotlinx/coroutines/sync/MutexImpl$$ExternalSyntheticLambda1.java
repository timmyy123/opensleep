package kotlinx.coroutines.sync;

import com.urbandroid.sleep.nearby.pairtracking.PairTracking;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class MutexImpl$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MutexImpl$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.$r8$classId;
        Object obj4 = this.f$0;
        switch (i) {
            case 0:
                return MutexImpl.onSelectCancellationUnlockConstructor$lambda$0((MutexImpl) obj4, (SelectInstance) obj, obj2, obj3);
            case 1:
                return PairTracking._init_$lambda$0((PairTracking) obj4, ((Integer) obj).intValue(), (String) obj2, (Throwable) obj3);
            case 2:
                return CancellableContinuationImpl.resume$lambda$0$0((Function1) obj4, (Throwable) obj, obj2, (CoroutineContext) obj3);
            case 3:
                return BufferedChannel.onUndeliveredElementReceiveCancellationConstructor$lambda$0$0((BufferedChannel) obj4, (SelectInstance) obj, obj2, obj3);
            default:
                return SemaphoreAndMutexImpl.onCancellationRelease$lambda$0((SemaphoreAndMutexImpl) obj4, (Throwable) obj, (Unit) obj2, (CoroutineContext) obj3);
        }
    }
}
