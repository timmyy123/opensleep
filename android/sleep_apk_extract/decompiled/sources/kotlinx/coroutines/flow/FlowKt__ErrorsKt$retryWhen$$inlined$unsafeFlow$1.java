package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", l = {116, 118}, m = "collect", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.$this_retryWhen$inlined = flow;
        this.$predicate$inlined = function4;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009f -> B:30:0x00de). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ce -> B:27:0x00d1). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        FlowCollector<? super T> flowCollector2;
        AnonymousClass1 anonymousClass12;
        int i;
        long j;
        FlowCollector<? super T> flowCollector3;
        Continuation continuation2;
        FlowCollector<? super T> flowCollector4;
        Continuation continuation3;
        FlowCollector<? super T> flowCollector5;
        int i2;
        int i3;
        Throwable th;
        Object objCatchImpl;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i4 = anonymousClass1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i4 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = anonymousClass1.label;
        Object obj2 = null;
        int i6 = 0;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector2 = flowCollector;
            anonymousClass12 = anonymousClass1;
            i = 0;
            j = 0;
            flowCollector3 = flowCollector2;
            continuation2 = anonymousClass12;
            Flow flow = this.$this_retryWhen$inlined;
            anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
            anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
            anonymousClass12.L$2 = flowCollector2;
            anonymousClass12.L$3 = obj2;
            anonymousClass12.I$0 = i;
            anonymousClass12.J$0 = j;
            anonymousClass12.I$1 = i6;
            anonymousClass12.label = 1;
            objCatchImpl = FlowKt.catchImpl(flow, flowCollector2, anonymousClass12);
            if (objCatchImpl != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 == 1) {
            int i7 = anonymousClass1.I$1;
            long j2 = anonymousClass1.J$0;
            int i8 = anonymousClass1.I$0;
            flowCollector5 = (FlowCollector) anonymousClass1.L$2;
            continuation3 = (Continuation) anonymousClass1.L$1;
            flowCollector4 = (FlowCollector) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i7;
            i3 = i8;
            j = j2;
            th = (Throwable) obj;
            if (th != null) {
            }
            flowCollector2 = flowCollector5;
            i = i3;
            anonymousClass12 = anonymousClass1;
            flowCollector3 = flowCollector4;
            if (i2 == 0) {
            }
        } else {
            if (i5 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            long j3 = anonymousClass1.J$0;
            i3 = anonymousClass1.I$0;
            Throwable th2 = (Throwable) anonymousClass1.L$3;
            flowCollector5 = (FlowCollector) anonymousClass1.L$2;
            continuation3 = (Continuation) anonymousClass1.L$1;
            flowCollector4 = (FlowCollector) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            if (!((Boolean) obj).booleanValue()) {
                j = j3 + 1;
                i2 = 1;
                flowCollector2 = flowCollector5;
                i = i3;
                anonymousClass12 = anonymousClass1;
                flowCollector3 = flowCollector4;
                if (i2 == 0) {
                    return Unit.INSTANCE;
                }
                continuation2 = continuation3;
                obj2 = null;
                i6 = 0;
                Flow flow2 = this.$this_retryWhen$inlined;
                anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
                anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                anonymousClass12.L$2 = flowCollector2;
                anonymousClass12.L$3 = obj2;
                anonymousClass12.I$0 = i;
                anonymousClass12.J$0 = j;
                anonymousClass12.I$1 = i6;
                anonymousClass12.label = 1;
                objCatchImpl = FlowKt.catchImpl(flow2, flowCollector2, anonymousClass12);
                if (objCatchImpl != coroutine_suspended) {
                    flowCollector4 = flowCollector3;
                    anonymousClass1 = anonymousClass12;
                    i3 = i;
                    flowCollector5 = flowCollector2;
                    obj = objCatchImpl;
                    continuation3 = continuation2;
                    i2 = i6;
                    th = (Throwable) obj;
                    if (th != null) {
                        Function4 function4 = this.$predicate$inlined;
                        Long lBoxLong = Boxing.boxLong(j);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector4);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(continuation3);
                        anonymousClass1.L$2 = flowCollector5;
                        anonymousClass1.L$3 = th;
                        anonymousClass1.I$0 = i3;
                        anonymousClass1.J$0 = j;
                        anonymousClass1.I$1 = i2;
                        anonymousClass1.label = 2;
                        InlineMarker.mark(6);
                        Object objInvoke = function4.invoke(flowCollector5, th, lBoxLong, anonymousClass1);
                        InlineMarker.mark(7);
                        if (objInvoke != coroutine_suspended) {
                            j3 = j;
                            th2 = th;
                            obj = objInvoke;
                            if (!((Boolean) obj).booleanValue()) {
                                throw th2;
                            }
                        }
                    }
                    flowCollector2 = flowCollector5;
                    i = i3;
                    anonymousClass12 = anonymousClass1;
                    flowCollector3 = flowCollector4;
                    if (i2 == 0) {
                    }
                }
                return coroutine_suspended;
            }
        }
    }
}
