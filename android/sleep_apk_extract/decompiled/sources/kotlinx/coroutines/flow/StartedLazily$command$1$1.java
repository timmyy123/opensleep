package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref$BooleanRef;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class StartedLazily$command$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref$BooleanRef $started;
    final /* synthetic */ FlowCollector<SharingCommand> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    public StartedLazily$command$1$1(Ref$BooleanRef ref$BooleanRef, FlowCollector<? super SharingCommand> flowCollector) {
        this.$started = ref$BooleanRef;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(int i, Continuation<? super Unit> continuation) {
        StartedLazily$command$1$1$emit$1 startedLazily$command$1$1$emit$1;
        if (continuation instanceof StartedLazily$command$1$1$emit$1) {
            startedLazily$command$1$1$emit$1 = (StartedLazily$command$1$1$emit$1) continuation;
            int i2 = startedLazily$command$1$1$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                startedLazily$command$1$1$emit$1.label = i2 - Integer.MIN_VALUE;
            } else {
                startedLazily$command$1$1$emit$1 = new StartedLazily$command$1$1$emit$1(this, continuation);
            }
        }
        Object obj = startedLazily$command$1$1$emit$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = startedLazily$command$1$1$emit$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (i > 0) {
                Ref$BooleanRef ref$BooleanRef = this.$started;
                if (!ref$BooleanRef.element) {
                    ref$BooleanRef.element = true;
                    FlowCollector<SharingCommand> flowCollector = this.$this_unsafeFlow;
                    SharingCommand sharingCommand = SharingCommand.START;
                    startedLazily$command$1$1$emit$1.I$0 = i;
                    startedLazily$command$1$1$emit$1.label = 1;
                    if (flowCollector.emit(sharingCommand, startedLazily$command$1$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        if (i3 != 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit(((Number) obj).intValue(), (Continuation<? super Unit>) continuation);
    }
}
