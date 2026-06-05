package androidx.health.connect.client.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.health.connect.AggregateRecordsGroupedByDurationResponse;
import android.health.connect.HealthConnectException;
import android.health.connect.HealthConnectManager;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.os.OutcomeReceiverKt;
import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.HealthConnectFeatures;
import androidx.health.connect.client.PermissionController;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.feature.HealthConnectFeaturesPlatformImpl;
import androidx.health.connect.client.impl.platform.ExceptionConverterKt;
import androidx.health.connect.client.impl.platform.aggregate.AggregationExtensionsKt;
import androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.impl.platform.request.RequestConvertersKt;
import androidx.health.connect.client.impl.platform.response.InsertRecordsResponseConverterKt;
import androidx.health.connect.client.impl.platform.response.ResponseConvertersKt;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.response.InsertRecordsResponse;
import androidx.health.connect.client.response.ReadRecordsResponse;
import androidx.health.connect.client.time.TimeRangeFilter;
import j$.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u0005\u0010\fJ\u001e\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J(\u0010\u0017\u001a\u00020\n2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J.\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\b\b\u0000\u0010\u0019*\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\r2\u0006\u0010\u001b\u001a\u00020\u001fH\u0096@¢\u0006\u0004\b!\u0010\"J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0#H\u0096@¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\nH\u0096@¢\u0006\u0004\b&\u0010%J!\u0010)\u001a\u00020\n2\u0010\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0#H\u0002¢\u0006\u0004\b)\u0010*J4\u0010.\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00192\u001c\u0010-\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+\u0012\u0006\u0012\u0004\u0018\u00010,0\u0007H\u0082@¢\u0006\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R&\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00107R\u001a\u00109\u001a\u0002088\u0016X\u0096\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006@"}, d2 = {"Landroidx/health/connect/client/impl/HealthConnectClientUpsideDownImpl;", "Landroidx/health/connect/client/HealthConnectClient;", "Landroidx/health/connect/client/PermissionController;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "Lkotlin/Function1;", "", "", "", "revokePermissionsFunction", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "", "Landroidx/health/connect/client/records/Record;", "records", "Landroidx/health/connect/client/response/InsertRecordsResponse;", "insertRecords", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/reflect/KClass;", "recordType", "Landroidx/health/connect/client/time/TimeRangeFilter;", "timeRangeFilter", "deleteRecords", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "request", "Landroidx/health/connect/client/response/ReadRecordsResponse;", "readRecords", "(Landroidx/health/connect/client/request/ReadRecordsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "aggregateGroupByDuration", "(Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getGrantedPermissions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revokeAllPermissions", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "metrics", "requireAggregationMetrics", "(Ljava/util/Set;)V", "Lkotlin/coroutines/Continuation;", "", "function", "wrapPlatformException", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/concurrent/Executor;", "Landroid/content/Context;", "Landroid/health/connect/HealthConnectManager;", "healthConnectManager", "Landroid/health/connect/HealthConnectManager;", "Lkotlin/jvm/functions/Function1;", "Landroidx/health/connect/client/HealthConnectFeatures;", "features", "Landroidx/health/connect/client/HealthConnectFeatures;", "getFeatures", "()Landroidx/health/connect/client/HealthConnectFeatures;", "getPermissionController", "()Landroidx/health/connect/client/PermissionController;", "permissionController", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HealthConnectClientUpsideDownImpl implements HealthConnectClient, PermissionController {
    private final Context context;
    private final Executor executor;
    private final HealthConnectFeatures features;
    private final HealthConnectManager healthConnectManager;
    private final Function1<Collection<String>, Unit> revokePermissionsFunction;

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", l = {263, 273}, m = "aggregateGroupByDuration")
    public static final class C01051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C01051(Continuation<? super C01051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.aggregateGroupByDuration(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$deleteRecords$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$deleteRecords$4", f = "HealthConnectClientUpsideDownImpl.kt", l = {634}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Void>, Object> {
        final /* synthetic */ KClass<? extends Record> $recordType;
        final /* synthetic */ TimeRangeFilter $timeRangeFilter;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(KClass<? extends Record> kClass, TimeRangeFilter timeRangeFilter, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$recordType = kClass;
            this.$timeRangeFilter = timeRangeFilter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HealthConnectClientUpsideDownImpl.this.new AnonymousClass4(this.$recordType, this.$timeRangeFilter, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Void> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl = HealthConnectClientUpsideDownImpl.this;
            KClass<? extends Record> kClass = this.$recordType;
            TimeRangeFilter timeRangeFilter = this.$timeRangeFilter;
            this.L$0 = healthConnectClientUpsideDownImpl;
            this.L$1 = kClass;
            this.L$2 = timeRangeFilter;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            healthConnectClientUpsideDownImpl.healthConnectManager.deleteRecords(RecordConvertersKt.toPlatformRecordClass(kClass), RequestConvertersKt.toPlatformTimeRangeFilter(timeRangeFilter), healthConnectClientUpsideDownImpl.executor, OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            return result == coroutine_suspended ? coroutine_suspended : result;
        }
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$insertRecords$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", l = {118}, m = "insertRecords")
    public static final class C01061 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01061(Continuation<? super C01061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.insertRecords(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecords$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", l = {216}, m = "readRecords")
    public static final class C01071<T extends Record> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01071(Continuation<? super C01071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.readRecords(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$wrapPlatformException$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", f = "HealthConnectClientUpsideDownImpl.kt", l = {627}, m = "wrapPlatformException")
    public static final class C01081<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01081(Continuation<? super C01081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientUpsideDownImpl.this.wrapPlatformException(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HealthConnectClientUpsideDownImpl(Context context, Function1<? super Collection<String>, Unit> function1) {
        context.getClass();
        function1.getClass();
        this.executor = ExecutorsKt.asExecutor(Dispatchers.getDefault());
        this.features = new HealthConnectFeaturesPlatformImpl();
        this.context = context;
        Object systemService = context.getSystemService("healthconnect");
        systemService.getClass();
        this.healthConnectManager = (HealthConnectManager) systemService;
        this.revokePermissionsFunction = function1;
    }

    private final void requireAggregationMetrics(Set<? extends AggregateMetric<?>> metrics) {
        if (metrics.isEmpty()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("At least one of the aggregation types must be set");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object wrapPlatformException(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Exception {
        C01081 c01081;
        if (continuation instanceof C01081) {
            c01081 = (C01081) continuation;
            int i = c01081.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01081.label = i - Integer.MIN_VALUE;
            } else {
                c01081 = new C01081(continuation);
            }
        }
        Object obj = c01081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01081.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                c01081.label = 1;
                Object objInvoke = function1.invoke(c01081);
                return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        } catch (HealthConnectException e) {
            throw ExceptionConverterKt.toKtException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8 A[LOOP:0: B:33:0x00b2->B:35:0x00b8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object aggregateGroupByDuration(AggregateGroupByDurationRequest aggregateGroupByDurationRequest, Continuation<? super List<AggregationResultGroupedByDuration>> continuation) throws Exception {
        C01051 c01051;
        List list;
        Set set;
        Iterator it;
        Iterator<AggregationResultGroupedByDuration> itSourceIterator;
        if (continuation instanceof C01051) {
            c01051 = (C01051) continuation;
            int i = c01051.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01051.label = i - Integer.MIN_VALUE;
            } else {
                c01051 = new C01051(continuation);
            }
        }
        Object objAggregateFallback = c01051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01051.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAggregateFallback);
            requireAggregationMetrics(aggregateGroupByDurationRequest.getMetrics$connect_client_release());
            c01051.L$0 = aggregateGroupByDurationRequest;
            c01051.label = 1;
            objAggregateFallback = HealthConnectClientAggregationExtensionsKt.aggregateFallback(this, aggregateGroupByDurationRequest, c01051);
            if (objAggregateFallback != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            set = (Set) c01051.L$1;
            list = (List) c01051.L$0;
            ResultKt.throwOnFailure(objAggregateFallback);
            objAggregateFallback.getClass();
            Iterable iterable = (Iterable) objAggregateFallback;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            it = iterable.iterator();
            while (it.hasNext()) {
                AggregateRecordsGroupedByDurationResponse aggregateRecordsGroupedByDurationResponseM = Fragment$$ExternalSyntheticBUOutline0.m(it.next());
                aggregateRecordsGroupedByDurationResponseM.getClass();
                arrayList.add(ResponseConvertersKt.toSdkResponse(aggregateRecordsGroupedByDurationResponseM, set));
            }
            final List listPlus = CollectionsKt.plus((Collection) list, (Iterable) arrayList);
            Grouping<AggregationResultGroupedByDuration, Instant> grouping = new Grouping<AggregationResultGroupedByDuration, Instant>() { // from class: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$$inlined$groupingBy$1
                @Override // kotlin.collections.Grouping
                public Instant keyOf(AggregationResultGroupedByDuration element) {
                    return element.getStartTime();
                }

                @Override // kotlin.collections.Grouping
                public Iterator<AggregationResultGroupedByDuration> sourceIterator() {
                    return listPlus.iterator();
                }
            };
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            itSourceIterator = grouping.sourceIterator();
            while (itSourceIterator.hasNext()) {
                AggregationResultGroupedByDuration next = itSourceIterator.next();
                Instant instantKeyOf = grouping.keyOf(next);
                Object obj = linkedHashMap.get(instantKeyOf);
                if (obj != null || linkedHashMap.containsKey(instantKeyOf)) {
                    AggregationResultGroupedByDuration aggregationResultGroupedByDuration = (AggregationResultGroupedByDuration) obj;
                    next = new AggregationResultGroupedByDuration(aggregationResultGroupedByDuration.getResult().plus$connect_client_release(next.getResult()), instantKeyOf, aggregationResultGroupedByDuration.getEndTime(), aggregationResultGroupedByDuration.getZoneOffset(), false, 16, null);
                }
                linkedHashMap.put(instantKeyOf, next);
            }
            return CollectionsKt.sortedWith(linkedHashMap.values(), new Comparator() { // from class: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((AggregationResultGroupedByDuration) t).getStartTime(), ((AggregationResultGroupedByDuration) t2).getStartTime());
                }
            });
        }
        aggregateGroupByDurationRequest = (AggregateGroupByDurationRequest) c01051.L$0;
        ResultKt.throwOnFailure(objAggregateFallback);
        List list2 = (List) objAggregateFallback;
        Set<AggregateMetric<?>> metrics$connect_client_release = aggregateGroupByDurationRequest.getMetrics$connect_client_release();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : metrics$connect_client_release) {
            if (AggregationExtensionsKt.isPlatformSupportedMetric((AggregateMetric) obj2)) {
                arrayList2.add(obj2);
            }
        }
        Set set2 = CollectionsKt.toSet(arrayList2);
        if (set2.isEmpty()) {
            return list2;
        }
        HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$platformResponse$1 healthConnectClientUpsideDownImpl$aggregateGroupByDuration$platformResponse$1 = new HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$platformResponse$1(this, aggregateGroupByDurationRequest, null);
        c01051.L$0 = list2;
        c01051.L$1 = set2;
        c01051.label = 2;
        Object objWrapPlatformException = wrapPlatformException(healthConnectClientUpsideDownImpl$aggregateGroupByDuration$platformResponse$1, c01051);
        if (objWrapPlatformException != coroutine_suspended) {
            list = list2;
            objAggregateFallback = objWrapPlatformException;
            set = set2;
            objAggregateFallback.getClass();
            Iterable iterable2 = (Iterable) objAggregateFallback;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            it = iterable2.iterator();
            while (it.hasNext()) {
            }
            final Iterable listPlus2 = CollectionsKt.plus((Collection) list, (Iterable) arrayList3);
            Grouping<AggregationResultGroupedByDuration, Instant> grouping2 = new Grouping<AggregationResultGroupedByDuration, Instant>() { // from class: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$$inlined$groupingBy$1
                @Override // kotlin.collections.Grouping
                public Instant keyOf(AggregationResultGroupedByDuration element) {
                    return element.getStartTime();
                }

                @Override // kotlin.collections.Grouping
                public Iterator<AggregationResultGroupedByDuration> sourceIterator() {
                    return listPlus2.iterator();
                }
            };
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            itSourceIterator = grouping2.sourceIterator();
            while (itSourceIterator.hasNext()) {
            }
            return CollectionsKt.sortedWith(linkedHashMap2.values(), new Comparator() { // from class: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((AggregationResultGroupedByDuration) t).getStartTime(), ((AggregationResultGroupedByDuration) t2).getStartTime());
                }
            });
        }
        return coroutine_suspended;
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public Object deleteRecords(KClass<? extends Record> kClass, TimeRangeFilter timeRangeFilter, Continuation<? super Unit> continuation) throws Exception {
        Object objWrapPlatformException = wrapPlatformException(new AnonymousClass4(kClass, timeRangeFilter, null), continuation);
        return objWrapPlatformException == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWrapPlatformException : Unit.INSTANCE;
    }

    @Override // androidx.health.connect.client.PermissionController
    public Object getGrantedPermissions(Continuation<? super Set<String>> continuation) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), PackageManager.PackageInfoFlags.of(4096L));
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        String[] strArr = packageInfo.requestedPermissions;
        if (strArr == null) {
            strArr = new String[0];
        }
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            str.getClass();
            if (StringsKt.startsWith$default(str, "android.permission.health.")) {
                int[] iArr = packageInfo.requestedPermissionsFlags;
                iArr.getClass();
                if ((iArr[i] & 2) > 0) {
                    String str2 = strArr[i];
                    str2.getClass();
                    setCreateSetBuilder.add(str2);
                }
            }
        }
        return SetsKt.build(setCreateSetBuilder);
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public PermissionController getPermissionController() {
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object insertRecords(List<? extends Record> list, Continuation<? super InsertRecordsResponse> continuation) throws Exception {
        C01061 c01061;
        if (continuation instanceof C01061) {
            c01061 = (C01061) continuation;
            int i = c01061.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01061.label = i - Integer.MIN_VALUE;
            } else {
                c01061 = new C01061(continuation);
            }
        }
        Object objWrapPlatformException = c01061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01061.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWrapPlatformException);
            HealthConnectClientUpsideDownImpl$insertRecords$response$1 healthConnectClientUpsideDownImpl$insertRecords$response$1 = new HealthConnectClientUpsideDownImpl$insertRecords$response$1(this, list, null);
            c01061.label = 1;
            objWrapPlatformException = wrapPlatformException(healthConnectClientUpsideDownImpl$insertRecords$response$1, c01061);
            if (objWrapPlatformException == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWrapPlatformException);
        }
        android.health.connect.InsertRecordsResponse insertRecordsResponse = (android.health.connect.InsertRecordsResponse) objWrapPlatformException;
        insertRecordsResponse.getClass();
        return InsertRecordsResponseConverterKt.toKtResponse(insertRecordsResponse);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends Record> Object readRecords(ReadRecordsRequest<T> readRecordsRequest, Continuation<? super ReadRecordsResponse<T>> continuation) throws Exception {
        C01071 c01071;
        if (continuation instanceof C01071) {
            c01071 = (C01071) continuation;
            int i = c01071.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01071.label = i - Integer.MIN_VALUE;
            } else {
                c01071 = new C01071(continuation);
            }
        }
        Object objWrapPlatformException = c01071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01071.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWrapPlatformException);
            if (readRecordsRequest.getDeduplicateStrategy() != 0) {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }
            HealthConnectClientUpsideDownImpl$readRecords$response$1 healthConnectClientUpsideDownImpl$readRecords$response$1 = new HealthConnectClientUpsideDownImpl$readRecords$response$1(this, readRecordsRequest, null);
            c01071.label = 1;
            objWrapPlatformException = wrapPlatformException(healthConnectClientUpsideDownImpl$readRecords$response$1, c01071);
            if (objWrapPlatformException == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWrapPlatformException);
        }
        android.health.connect.ReadRecordsResponse readRecordsResponse = (android.health.connect.ReadRecordsResponse) objWrapPlatformException;
        List records = readRecordsResponse.getRecords();
        records.getClass();
        List list = records;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            android.health.connect.datatypes.Record recordM64m = Fragment$$ExternalSyntheticBUOutline0.m64m(it.next());
            recordM64m.getClass();
            Record sdkRecord = RecordConvertersKt.toSdkRecord(recordM64m);
            sdkRecord.getClass();
            arrayList.add(sdkRecord);
        }
        Long lBoxLong = Boxing.boxLong(readRecordsResponse.getNextPageToken());
        if (lBoxLong.longValue() == -1) {
            lBoxLong = null;
        }
        return new ReadRecordsResponse(arrayList, lBoxLong != null ? lBoxLong.toString() : null);
    }

    @Override // androidx.health.connect.client.PermissionController
    public Object revokeAllPermissions(Continuation<? super Unit> continuation) {
        String[] strArr = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), PackageManager.PackageInfoFlags.of(4096L)).requestedPermissions;
        if (strArr == null) {
            strArr = new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            str.getClass();
            if (StringsKt.startsWith$default(str, "android.permission.health.")) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            this.revokePermissionsFunction.invoke(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Collection<String>, Unit> {
        public AnonymousClass1(Object obj) {
            super(1, obj, Context.class, "revokeSelfPermissionsOnKill", "revokeSelfPermissionsOnKill(Ljava/util/Collection;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Collection<String> collection) {
            collection.getClass();
            ((Context) this.receiver).revokeSelfPermissionsOnKill(collection);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Collection<String> collection) {
            invoke2(collection);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HealthConnectClientUpsideDownImpl(Context context) {
        this(context, new AnonymousClass1(context));
        context.getClass();
    }
}
