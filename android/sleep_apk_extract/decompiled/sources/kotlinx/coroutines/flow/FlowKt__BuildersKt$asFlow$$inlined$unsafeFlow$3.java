package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3<T> implements Flow<T> {
    final /* synthetic */ Iterable $this_asFlow$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3", f = "Builders.kt", l = {114}, m = "collect", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(Iterable iterable) {
        this.$this_asFlow$inlined = iterable;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Iterable iterable;
        Iterator<T> it;
        AnonymousClass1 anonymousClass12;
        Continuation continuation2;
        int i;
        int i2;
        FlowCollector<? super T> flowCollector2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = anonymousClass1.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            Iterable iterable2 = this.$this_asFlow$inlined;
            iterable = iterable2;
            it = iterable2.iterator();
            anonymousClass12 = anonymousClass1;
            continuation2 = anonymousClass12;
            i = 0;
            i2 = 0;
            flowCollector2 = flowCollector;
        } else {
            if (i4 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = anonymousClass1.I$1;
            int i5 = anonymousClass1.I$0;
            Iterator<T> it2 = (Iterator) anonymousClass1.L$4;
            Iterable iterable3 = (Iterable) anonymousClass1.L$3;
            FlowCollector<? super T> flowCollector3 = (FlowCollector) anonymousClass1.L$2;
            Continuation continuation3 = (Continuation) anonymousClass1.L$1;
            FlowCollector<? super T> flowCollector4 = (FlowCollector) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            AnonymousClass1 anonymousClass13 = anonymousClass1;
            i2 = i5;
            flowCollector = flowCollector3;
            it = it2;
            anonymousClass12 = anonymousClass13;
            iterable = iterable3;
            continuation2 = continuation3;
            flowCollector2 = flowCollector4;
        }
        while (it.hasNext()) {
            T next = it.next();
            anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
            anonymousClass12.L$2 = flowCollector;
            anonymousClass12.L$3 = SpillingKt.nullOutSpilledVariable(iterable);
            anonymousClass12.L$4 = it;
            anonymousClass12.L$5 = SpillingKt.nullOutSpilledVariable(next);
            anonymousClass12.L$6 = SpillingKt.nullOutSpilledVariable(next);
            anonymousClass12.I$0 = i2;
            anonymousClass12.I$1 = i;
            anonymousClass12.I$2 = 0;
            anonymousClass12.label = 1;
            if (flowCollector.emit(next, anonymousClass12) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
