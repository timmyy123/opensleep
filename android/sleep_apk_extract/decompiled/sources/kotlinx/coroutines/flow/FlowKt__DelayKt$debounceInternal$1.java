package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", l = {215, 415}, m = "invokeSuspend", v = 1)
public final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a5, code lost:
    
        if (r1.emit(r6, r17) == r8) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fc, code lost:
    
        if (r6.doSelect(r17) != r8) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa A[PHI: r3 r4 r5
      0x00aa: PHI (r3v4 kotlin.jvm.internal.Ref$LongRef) = (r3v6 kotlin.jvm.internal.Ref$LongRef), (r3v8 kotlin.jvm.internal.Ref$LongRef), (r3v8 kotlin.jvm.internal.Ref$LongRef) binds: [B:29:0x00a8, B:15:0x006b, B:22:0x0088] A[DONT_GENERATE, DONT_INLINE]
      0x00aa: PHI (r4v2 kotlin.jvm.internal.Ref$ObjectRef) = 
      (r4v8 kotlin.jvm.internal.Ref$ObjectRef)
      (r4v9 kotlin.jvm.internal.Ref$ObjectRef)
      (r4v9 kotlin.jvm.internal.Ref$ObjectRef)
     binds: [B:29:0x00a8, B:15:0x006b, B:22:0x0088] A[DONT_GENERATE, DONT_INLINE]
      0x00aa: PHI (r5v2 kotlinx.coroutines.channels.ReceiveChannel) = 
      (r5v3 kotlinx.coroutines.channels.ReceiveChannel)
      (r5v4 kotlinx.coroutines.channels.ReceiveChannel)
      (r5v4 kotlinx.coroutines.channels.ReceiveChannel)
     binds: [B:29:0x00a8, B:15:0x006b, B:22:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00fc -> B:7:0x002e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref$ObjectRef ref$ObjectRef;
        ReceiveChannel receiveChannel;
        Ref$LongRef ref$LongRef;
        Ref$ObjectRef ref$ObjectRef2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        FlowCollector flowCollector = (FlowCollector) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ReceiveChannel receiveChannelProduce$default = ProduceKt.produce$default(coroutineScope, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
            ref$ObjectRef = new Ref$ObjectRef();
            receiveChannel = receiveChannelProduce$default;
            if (ref$ObjectRef.element != NullSurrogateKt.DONE) {
            }
        } else if (i == 1) {
            ref$LongRef = (Ref$LongRef) this.L$4;
            ref$ObjectRef = (Ref$ObjectRef) this.L$3;
            receiveChannel = (ReceiveChannel) this.L$2;
            ResultKt.throwOnFailure(obj);
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRef;
            Ref$LongRef ref$LongRef2 = ref$LongRef;
            ref$ObjectRef2 = ref$ObjectRef3;
            SelectImplementation selectImplementation = new SelectImplementation(getContext());
            if (ref$ObjectRef2.element != null) {
            }
            selectImplementation.invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(ref$ObjectRef2, flowCollector, null));
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = flowCollector;
            this.L$2 = receiveChannel;
            this.L$3 = ref$ObjectRef2;
            this.L$4 = SpillingKt.nullOutSpilledVariable(ref$LongRef2);
            this.L$5 = SpillingKt.nullOutSpilledVariable(selectImplementation);
            this.I$0 = 0;
            this.I$1 = 0;
            this.label = 2;
        } else {
            if (i != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$ObjectRef2 = (Ref$ObjectRef) this.L$3;
            ReceiveChannel receiveChannel2 = (ReceiveChannel) this.L$2;
            ResultKt.throwOnFailure(obj);
            receiveChannel = receiveChannel2;
            ref$ObjectRef = ref$ObjectRef2;
            if (ref$ObjectRef.element != NullSurrogateKt.DONE) {
                ref$LongRef = new Ref$LongRef();
                T t = ref$ObjectRef.element;
                if (t != null) {
                    Function1<T, Long> function1 = this.$timeoutMillisSelector;
                    Symbol symbol = NullSurrogateKt.NULL;
                    if (t == symbol) {
                        t = null;
                    }
                    long jLongValue = function1.invoke(t).longValue();
                    ref$LongRef.element = jLongValue;
                    if (jLongValue < 0) {
                        Utf8$$ExternalSyntheticBUOutline0.m$2("Debounce timeout should not be negative");
                        return null;
                    }
                    if (jLongValue != 0) {
                        Ref$ObjectRef ref$ObjectRef32 = ref$ObjectRef;
                        Ref$LongRef ref$LongRef22 = ref$LongRef;
                        ref$ObjectRef2 = ref$ObjectRef32;
                        SelectImplementation selectImplementation2 = new SelectImplementation(getContext());
                        if (ref$ObjectRef2.element != null) {
                            OnTimeoutKt.onTimeout(selectImplementation2, ref$LongRef22.element, new FlowKt__DelayKt$debounceInternal$1$3$1(flowCollector, ref$ObjectRef2, null));
                        }
                        selectImplementation2.invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(ref$ObjectRef2, flowCollector, null));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = flowCollector;
                        this.L$2 = receiveChannel;
                        this.L$3 = ref$ObjectRef2;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(ref$LongRef22);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(selectImplementation2);
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 2;
                    } else {
                        T t2 = ref$ObjectRef.element;
                        if (t2 == symbol) {
                            t2 = null;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = flowCollector;
                        this.L$2 = receiveChannel;
                        this.L$3 = ref$ObjectRef;
                        this.L$4 = ref$LongRef;
                        this.L$5 = null;
                        this.label = 1;
                    }
                    return coroutine_suspended;
                }
                if (ref$ObjectRef.element != NullSurrogateKt.DONE) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
