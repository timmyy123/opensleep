package androidx.appfunctions.internal;

import androidx.appfunctions.AppFunctionSearchSpec;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.appfunctions.metadata.AppFunctionPackageMetadata;
import androidx.appsearch.app.GlobalSearchSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1", f = "AppSearchAppFunctionReader.kt", l = {105}, m = "invokeSuspend", v = 1)
public final class AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProducerScope<List<AppFunctionPackageMetadata>> $$this$callbackFlow;
    final /* synthetic */ AppSearchAppFunctionReader.AppSearchChannelObserver $appSearchChannelObserver;
    final /* synthetic */ AppFunctionSearchSpec $searchFunctionSpec;
    final /* synthetic */ GlobalSearchSession $session;
    int label;
    final /* synthetic */ AppSearchAppFunctionReader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1(AppSearchAppFunctionReader.AppSearchChannelObserver appSearchChannelObserver, ProducerScope<? super List<AppFunctionPackageMetadata>> producerScope, AppSearchAppFunctionReader appSearchAppFunctionReader, GlobalSearchSession globalSearchSession, AppFunctionSearchSpec appFunctionSearchSpec, Continuation<? super AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1> continuation) {
        super(2, continuation);
        this.$appSearchChannelObserver = appSearchChannelObserver;
        this.$$this$callbackFlow = producerScope;
        this.this$0 = appSearchAppFunctionReader;
        this.$session = globalSearchSession;
        this.$searchFunctionSpec = appFunctionSearchSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1(this.$appSearchChannelObserver, this.$$this$callbackFlow, this.this$0, this.$session, this.$searchFunctionSpec, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flowM2601debounceHG0u8IE = FlowKt.m2601debounceHG0u8IE(this.$appSearchChannelObserver.observe(), AppSearchAppFunctionReader.Companion.m36getOBSERVER_DEBOUNCE_MILLISUwyO8pc());
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$callbackFlow, this.this$0, this.$session, this.$searchFunctionSpec);
            this.label = 1;
            if (flowM2601debounceHG0u8IE.collect(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ ProducerScope<List<AppFunctionPackageMetadata>> $$this$callbackFlow;
        final /* synthetic */ AppFunctionSearchSpec $searchFunctionSpec;
        final /* synthetic */ GlobalSearchSession $session;
        final /* synthetic */ AppSearchAppFunctionReader this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(ProducerScope<? super List<AppFunctionPackageMetadata>> producerScope, AppSearchAppFunctionReader appSearchAppFunctionReader, GlobalSearchSession globalSearchSession, AppFunctionSearchSpec appFunctionSearchSpec) {
            this.$$this$callbackFlow = producerScope;
            this.this$0 = appSearchAppFunctionReader;
            this.$session = globalSearchSession;
            this.$searchFunctionSpec = appFunctionSearchSpec;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        
            if (r7.send(r9, r8) == r0) goto L22;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
            AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1 appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1;
            ProducerScope producerScope;
            if (continuation instanceof AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1) {
                appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1 = (AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1) continuation;
                int i = appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1 = new AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1(this, continuation);
                }
            }
            Object obj = appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope<List<AppFunctionPackageMetadata>> producerScope2 = this.$$this$callbackFlow;
                AppSearchAppFunctionReader appSearchAppFunctionReader = this.this$0;
                GlobalSearchSession globalSearchSession = this.$session;
                AppFunctionSearchSpec appFunctionSearchSpec = this.$searchFunctionSpec;
                appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1.L$0 = producerScope2;
                appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1.label = 1;
                Object objPerformSearch = appSearchAppFunctionReader.performSearch(globalSearchSession, appFunctionSearchSpec, appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1);
                if (objPerformSearch != coroutine_suspended) {
                    obj = objPerformSearch;
                    producerScope = producerScope2;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            producerScope = (ProducerScope) appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1.L$0;
            ResultKt.throwOnFailure(obj);
            appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1.L$0 = null;
            appSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1.label = 2;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Unit) obj, (Continuation<? super Unit>) continuation);
        }
    }
}
