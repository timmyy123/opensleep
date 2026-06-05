package com.google.home;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.HasId;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003B\u001d\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0012H\u0096A¢\u0006\u0004\b\u0015\u0010\u0016R#\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/google/home/HomeObjectsFlow;", "Lcom/google/home/HasId;", "T", "Lkotlinx/coroutines/flow/Flow;", "", "flow", "<init>", "(Lkotlinx/coroutines/flow/Flow;)V", "list", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/home/Id;", "id", "itemFlow-ImLHPvw", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "itemFlow", "get-4rhpr1w", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HomeObjectsFlow<T extends HasId> implements Flow<Set<? extends T>> {
    private final Flow<Set<T>> flow;

    /* JADX WARN: Multi-variable type inference failed */
    public HomeObjectsFlow(Flow<? extends Set<? extends T>> flow) {
        flow.getClass();
        this.flow = flow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super Set<? extends T>> flowCollector, Continuation<? super Unit> continuation) {
        return this.flow.collect(flowCollector, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: get-4rhpr1w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m438get4rhpr1w(String str, Continuation<? super T> continuation) {
        HomeObjectsFlow$get$1 homeObjectsFlow$get$1;
        if (continuation instanceof HomeObjectsFlow$get$1) {
            homeObjectsFlow$get$1 = (HomeObjectsFlow$get$1) continuation;
            int i = homeObjectsFlow$get$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                homeObjectsFlow$get$1.label = i - Integer.MIN_VALUE;
            } else {
                homeObjectsFlow$get$1 = new HomeObjectsFlow$get$1(this, continuation);
            }
        }
        Object list = homeObjectsFlow$get$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = homeObjectsFlow$get$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(list);
            homeObjectsFlow$get$1.L$0 = str;
            homeObjectsFlow$get$1.label = 1;
            list = list(homeObjectsFlow$get$1);
            if (list == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str = (String) homeObjectsFlow$get$1.L$0;
            ResultKt.throwOnFailure(list);
        }
        for (Object obj : (Iterable) list) {
            if (Id.m443equalsimpl0(((HasId) obj).getZza(), str)) {
                return obj;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: itemFlow-ImLHPvw, reason: not valid java name */
    public final Flow<T> m439itemFlowImLHPvw(final String id) {
        id.getClass();
        return FlowKt.distinctUntilChanged(FlowKt.filterNotNull(new Flow<T>() { // from class: com.google.home.HomeObjectsFlow$itemFlow-ImLHPvw$$inlined$map$1

            /* JADX INFO: renamed from: com.google.home.HomeObjectsFlow$itemFlow-ImLHPvw$$inlined$map$1$2, reason: invalid class name */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", SDKConstants.PARAM_VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ String $id$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.google.home.HomeObjectsFlow$itemFlow-ImLHPvw$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "com.google.home.HomeObjectsFlow$itemFlow-ImLHPvw$$inlined$map$1$2", f = "HomeObjectsFlow.kt", l = {50}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, String str) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$id$inlined = str;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    T t = null;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Iterator<T> it = ((Set) obj).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            T next = it.next();
                            if (Id.m443equalsimpl0(((HasId) next).getZza(), this.$id$inlined)) {
                                t = next;
                                break;
                            }
                        }
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(t, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = this.collect(new AnonymousClass2(flowCollector, id), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }));
    }

    public final Object list(Continuation<? super Set<? extends T>> continuation) {
        return FlowKt.first(this, continuation);
    }
}
