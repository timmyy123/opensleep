package kotlinx.coroutines.flow;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.platform.traits.ValidationIssue;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030#2\u0006\u0010\"\u001a\u00020!H\u0014¢\u0006\u0004\b$\u0010%J-\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020!2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R$\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u0010\tR\u0011\u00104\u001a\b\u0012\u0004\u0012\u00020\u0005038\u0002X\u0082\u0004¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "<init>", "(Ljava/lang/Object;)V", "expectedState", "newState", "", "updateState", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "expect", "update", "compareAndSet", SDKConstants.PARAM_VALUE, "tryEmit", "(Ljava/lang/Object;)Z", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetReplayCache", "()V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlin/coroutines/CoroutineContext;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "Lkotlinx/atomicfu/AtomicRef;", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, Flow, FusibleFlow<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    private int sequence;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {389, ValidationIssue.TOO_MANY_NODES_FIELD_NUMBER, 406}, m = "collect", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StateFlowImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StateFlowImpl<T> stateFlowImpl, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = stateFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    public StateFlowImpl(Object obj) {
        this._state$volatile = obj;
    }

    private final boolean updateState(Object expectedState, Object newState) {
        int i;
        StateFlowSlot[] slots;
        synchronized (this) {
            Object obj = _state$volatile$FU.get(this);
            if (expectedState != null && !Intrinsics.areEqual(obj, expectedState)) {
                return false;
            }
            if (Intrinsics.areEqual(obj, newState)) {
                return true;
            }
            _state$volatile$FU.set(this, newState);
            int i2 = this.sequence;
            if ((i2 & 1) != 0) {
                this.sequence = i2 + 2;
                return true;
            }
            int i3 = i2 + 1;
            this.sequence = i3;
            StateFlowSlot[] slots2 = getSlots();
            Unit unit = Unit.INSTANCE;
            while (true) {
                StateFlowSlot[] stateFlowSlotArr = slots2;
                if (stateFlowSlotArr != null) {
                    for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                        if (stateFlowSlot != null) {
                            stateFlowSlot.makePending();
                        }
                    }
                }
                synchronized (this) {
                    i = this.sequence;
                    if (i == i3) {
                        this.sequence = i3 + 1;
                        return true;
                    }
                    slots = getSlots();
                    Unit unit2 = Unit.INSTANCE;
                }
                slots2 = slots;
                i3 = i;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:29:0x007f, B:46:0x00ba], limit reached: 49 */
    /* JADX WARN: Path cross not found for [B:46:0x00ba, B:29:0x007f], limit reached: 49 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:15:0x003a, B:29:0x007f, B:31:0x0089, B:33:0x008e, B:44:0x00b4, B:46:0x00ba, B:35:0x0094, B:39:0x009b, B:22:0x0055, B:25:0x0062, B:28:0x0070), top: B:51:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:15:0x003a, B:29:0x007f, B:31:0x0089, B:33:0x008e, B:44:0x00b4, B:46:0x00ba, B:35:0x0094, B:39:0x009b, B:22:0x0055, B:25:0x0062, B:28:0x0070), top: B:51:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ba A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #0 {all -> 0x003e, blocks: (B:15:0x003a, B:29:0x007f, B:31:0x0089, B:33:0x008e, B:44:0x00b4, B:46:0x00ba, B:35:0x0094, B:39:0x009b, B:22:0x0055, B:25:0x0062, B:28:0x0070), top: B:51:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00b8 -> B:29:0x007f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00ce -> B:29:0x007f). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        AnonymousClass1 anonymousClass1;
        StateFlowSlot stateFlowSlotAllocateSlot;
        ?? r7;
        Job job;
        Object obj;
        ?? r72;
        Object obj2;
        ?? r73;
        Object obj3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        }
        Object obj4 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj4);
                stateFlowSlotAllocateSlot = allocateSlot();
            } else if (i2 == 1) {
                stateFlowSlotAllocateSlot = (StateFlowSlot) anonymousClass1.L$1;
                flowCollector = (FlowCollector) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj4);
            } else if (i2 == 2) {
                obj = anonymousClass1.L$4;
                job = (Job) anonymousClass1.L$2;
                stateFlowSlotAllocateSlot = (StateFlowSlot) anonymousClass1.L$1;
                FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj4);
                r72 = flowCollector2;
                obj2 = obj;
                r73 = r72;
                r7 = r73;
                if (!stateFlowSlotAllocateSlot.takePending()) {
                }
                obj2 = _state$volatile$FU.get(this);
                if (job != null) {
                }
                if (obj != null) {
                }
                if (obj2 != NullSurrogateKt.NULL) {
                }
                anonymousClass1.L$0 = r7;
                anonymousClass1.L$1 = stateFlowSlotAllocateSlot;
                anonymousClass1.L$2 = job;
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(obj);
                anonymousClass1.L$4 = obj2;
                anonymousClass1.label = 2;
                if (r7.emit(obj3, anonymousClass1) != coroutine_suspended) {
                }
            } else {
                if (i2 != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                obj = anonymousClass1.L$3;
                job = (Job) anonymousClass1.L$2;
                stateFlowSlotAllocateSlot = (StateFlowSlot) anonymousClass1.L$1;
                FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj4);
                r7 = flowCollector3;
                obj2 = _state$volatile$FU.get(this);
                if (job != null) {
                    JobKt.ensureActive(job);
                }
                if (obj != null) {
                    r73 = r7;
                    if (Intrinsics.areEqual(obj, obj2)) {
                        r7 = r73;
                        if (!stateFlowSlotAllocateSlot.takePending()) {
                            anonymousClass1.L$0 = r73;
                            anonymousClass1.L$1 = stateFlowSlotAllocateSlot;
                            anonymousClass1.L$2 = job;
                            anonymousClass1.L$3 = obj;
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                            anonymousClass1.label = 3;
                            r7 = r73;
                            if (stateFlowSlotAllocateSlot.awaitPending(anonymousClass1) != coroutine_suspended) {
                            }
                        }
                        obj2 = _state$volatile$FU.get(this);
                        if (job != null) {
                        }
                        if (obj != null) {
                        }
                    }
                    return coroutine_suspended;
                }
                obj3 = obj2 != NullSurrogateKt.NULL ? null : obj2;
                anonymousClass1.L$0 = r7;
                anonymousClass1.L$1 = stateFlowSlotAllocateSlot;
                anonymousClass1.L$2 = job;
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(obj);
                anonymousClass1.L$4 = obj2;
                anonymousClass1.label = 2;
                if (r7.emit(obj3, anonymousClass1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = obj2;
                r72 = r7;
                obj2 = obj;
                r73 = r72;
                r7 = r73;
                if (!stateFlowSlotAllocateSlot.takePending()) {
                }
                obj2 = _state$volatile$FU.get(this);
                if (job != null) {
                }
                if (obj != null) {
                }
                if (obj2 != NullSurrogateKt.NULL) {
                }
                anonymousClass1.L$0 = r7;
                anonymousClass1.L$1 = stateFlowSlotAllocateSlot;
                anonymousClass1.L$2 = job;
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(obj);
                anonymousClass1.L$4 = obj2;
                anonymousClass1.label = 2;
                if (r7.emit(obj3, anonymousClass1) != coroutine_suspended) {
                }
            }
            r7 = flowCollector;
            job = (Job) anonymousClass1.getContext().get(Job.INSTANCE);
            obj = null;
            obj2 = _state$volatile$FU.get(this);
            if (job != null) {
            }
            if (obj != null) {
            }
            if (obj2 != NullSurrogateKt.NULL) {
            }
            anonymousClass1.L$0 = r7;
            anonymousClass1.L$1 = stateFlowSlotAllocateSlot;
            anonymousClass1.L$2 = job;
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(obj);
            anonymousClass1.L$4 = obj2;
            anonymousClass1.label = 2;
            if (r7.emit(obj3, anonymousClass1) != coroutine_suspended) {
            }
        } catch (Throwable th) {
            freeSlot(stateFlowSlotAllocateSlot);
            throw th;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T expect, T update) {
        if (expect == null) {
            expect = (T) NullSurrogateKt.NULL;
        }
        if (update == null) {
            update = (T) NullSurrogateKt.NULL;
        }
        return updateState(expect, update);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        T t = (T) _state$volatile$FU.get(this);
        if (t == symbol) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        updateState(null, t);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        setValue(value);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot[] createSlotArray(int size) {
        return new StateFlowSlot[size];
    }
}
