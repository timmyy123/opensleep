package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.impl.converters.datatype.RecordsTypeNameMapKt;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.response.ReadRecordsResponse;
import com.google.home.platform.traits.ValidationIssue;
import j$.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\u001aF\u0010\u000e\u001a\u00028\u0001\"\b\b\u0000\u0010\b*\u00020\u0007\"\u0004\b\u0001\u0010\t*\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH\u0080@¢\u0006\u0004\b\u000e\u0010\u000f\u001a7\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0010\"\b\b\u0000\u0010\b*\u00020\u0007*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/health/connect/client/HealthConnectClient;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "request", "", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "aggregateFallback", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/records/Record;", "T", "R", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "readRecordsRequest", "Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "aggregator", "aggregate", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/ReadRecordsRequest;Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "readRecordsFlow", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/ReadRecordsRequest;)Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/reflect/KClass;", "AGGREGATION_FALLBACK_RECORD_TYPES", "Ljava/util/Set;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class HealthConnectClientAggregationExtensionsKt {
    private static final Set<KClass<? extends Record>> AGGREGATION_FALLBACK_RECORD_TYPES = SetsKt.setOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(BloodPressureRecord.class), Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), Reflection.getOrCreateKotlinClass(NutritionRecord.class), Reflection.getOrCreateKotlinClass(SpeedRecord.class), Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class)});

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregate$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt", f = "HealthConnectClientAggregationExtensions.kt", l = {160}, m = "aggregate")
    public static final class AnonymousClass1<T extends Record, R> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientAggregationExtensionsKt.aggregate(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$9, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt", f = "HealthConnectClientAggregationExtensions.kt", l = {123, 196, 126, ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_FIELD_NUMBER, 214}, m = "aggregateFallback")
    public static final class AnonymousClass9 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass9(Continuation<? super AnonymousClass9> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientAggregationExtensionsKt.aggregateFallback(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "", "T", "Landroidx/health/connect/client/records/Record;", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1", f = "HealthConnectClientAggregationExtensions.kt", l = {173, 174}, m = "invokeSuspend")
    public static final class C01091<T> extends SuspendLambda implements Function2<FlowCollector<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReadRecordsRequest<T> $request;
        final /* synthetic */ HealthConnectClient $this_readRecordsFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01091(ReadRecordsRequest<T> readRecordsRequest, HealthConnectClient healthConnectClient, Continuation<? super C01091> continuation) {
            super(2, continuation);
            this.$request = readRecordsRequest;
            this.$this_readRecordsFlow = healthConnectClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01091 c01091 = new C01091(this.$request, this.$this_readRecordsFlow, continuation);
            c01091.L$0 = obj;
            return c01091;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super List<? extends T>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C01091) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
        
            if (r6.emit(r8, r7) != r0) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0064 -> B:7:0x001e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            ReadRecordsRequest<T> readRecordsRequestWithPageToken$connect_client_release;
            FlowCollector flowCollector2;
            ReadRecordsRequest<T> readRecordsRequest;
            ReadRecordsResponse readRecordsResponse;
            Object records;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                readRecordsRequestWithPageToken$connect_client_release = this.$request;
                HealthConnectClient healthConnectClient = this.$this_readRecordsFlow;
                this.L$0 = flowCollector;
                this.L$1 = readRecordsRequestWithPageToken$connect_client_release;
                this.L$2 = null;
                this.label = 1;
                records = healthConnectClient.readRecords(readRecordsRequestWithPageToken$connect_client_release, this);
                if (records != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                readRecordsResponse = (ReadRecordsResponse) this.L$2;
                readRecordsRequest = (ReadRecordsRequest) this.L$1;
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector2;
                readRecordsRequestWithPageToken$connect_client_release = readRecordsRequest.withPageToken$connect_client_release(readRecordsResponse.getPageToken());
                if (readRecordsRequestWithPageToken$connect_client_release.getPageToken() == null) {
                    return Unit.INSTANCE;
                }
                HealthConnectClient healthConnectClient2 = this.$this_readRecordsFlow;
                this.L$0 = flowCollector;
                this.L$1 = readRecordsRequestWithPageToken$connect_client_release;
                this.L$2 = null;
                this.label = 1;
                records = healthConnectClient2.readRecords(readRecordsRequestWithPageToken$connect_client_release, this);
                if (records != coroutine_suspended) {
                    flowCollector2 = flowCollector;
                    obj = records;
                    readRecordsRequest = readRecordsRequestWithPageToken$connect_client_release;
                    readRecordsResponse = (ReadRecordsResponse) obj;
                    List records2 = readRecordsResponse.getRecords();
                    this.L$0 = flowCollector2;
                    this.L$1 = readRecordsRequest;
                    this.L$2 = readRecordsResponse;
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            readRecordsRequestWithPageToken$connect_client_release = (ReadRecordsRequest) this.L$1;
            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            flowCollector2 = flowCollector3;
            readRecordsRequest = readRecordsRequestWithPageToken$connect_client_release;
            readRecordsResponse = (ReadRecordsResponse) obj;
            List records22 = readRecordsResponse.getRecords();
            this.L$0 = flowCollector2;
            this.L$1 = readRecordsRequest;
            this.L$2 = readRecordsResponse;
            this.label = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T extends Record, R> Object aggregate(HealthConnectClient healthConnectClient, ReadRecordsRequest<T> readRecordsRequest, final Aggregator<T, R> aggregator, Continuation<? super R> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow recordsFlow = readRecordsFlow(healthConnectClient, readRecordsRequest);
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.aggregate.2
                public final Object emit(List<? extends T> list, Continuation<? super Unit> continuation2) {
                    Aggregator<T, R> aggregator2 = aggregator;
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        aggregator2.filterAndAggregate((Record) it.next());
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation2) {
                    return emit((List) obj2, (Continuation<? super Unit>) continuation2);
                }
            };
            anonymousClass1.L$0 = aggregator;
            anonymousClass1.label = 1;
            if (recordsFlow.collect(flowCollector, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            aggregator = (Aggregator) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return aggregator.getResult();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0278 -> B:69:0x027a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object aggregateFallback(HealthConnectClient healthConnectClient, AggregateGroupByDurationRequest aggregateGroupByDurationRequest, Continuation<? super List<AggregationResultGroupedByDuration>> continuation) {
        AnonymousClass9 anonymousClass9;
        Collection arrayList;
        Iterator it;
        HealthConnectClient healthConnectClient2;
        Object obj;
        HealthConnectClient healthConnectClient3;
        List list;
        if (continuation instanceof AnonymousClass9) {
            anonymousClass9 = (AnonymousClass9) continuation;
            int i = anonymousClass9.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass9.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass9 = new AnonymousClass9(continuation);
            }
        }
        Object obj2 = anonymousClass9.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass9.label;
        Object obj3 = null;
        if (i2 != 0) {
            if (i2 == 1) {
                it = (Iterator) anonymousClass9.L$2;
                arrayList = (Collection) anonymousClass9.L$1;
                healthConnectClient3 = (HealthConnectClient) anonymousClass9.L$0;
                ResultKt.throwOnFailure(obj2);
                list = (List) obj2;
                obj = null;
            } else if (i2 == 2) {
                it = (Iterator) anonymousClass9.L$2;
                arrayList = (Collection) anonymousClass9.L$1;
                healthConnectClient3 = (HealthConnectClient) anonymousClass9.L$0;
                ResultKt.throwOnFailure(obj2);
                obj = null;
                list = (List) obj2;
            } else if (i2 == 3) {
                it = (Iterator) anonymousClass9.L$2;
                arrayList = (Collection) anonymousClass9.L$1;
                healthConnectClient3 = (HealthConnectClient) anonymousClass9.L$0;
                ResultKt.throwOnFailure(obj2);
                obj = null;
                list = (List) obj2;
            } else if (i2 == 4) {
                it = (Iterator) anonymousClass9.L$2;
                arrayList = (Collection) anonymousClass9.L$1;
                healthConnectClient3 = (HealthConnectClient) anonymousClass9.L$0;
                ResultKt.throwOnFailure(obj2);
                obj = null;
                list = (List) obj2;
            } else {
                if (i2 != 5) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                it = (Iterator) anonymousClass9.L$2;
                arrayList = (Collection) anonymousClass9.L$1;
                healthConnectClient3 = (HealthConnectClient) anonymousClass9.L$0;
                ResultKt.throwOnFailure(obj2);
                obj = null;
                list = (List) obj2;
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
            obj3 = obj;
            healthConnectClient2 = healthConnectClient3;
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                KClass kClass = (KClass) entry.getKey();
                final AggregateGroupByDurationRequest aggregateGroupByDurationRequest2 = (AggregateGroupByDurationRequest) entry.getValue();
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(BloodPressureRecord.class))) {
                    anonymousClass9.L$0 = healthConnectClient2;
                    anonymousClass9.L$1 = arrayList;
                    anonymousClass9.L$2 = it;
                    anonymousClass9.label = 1;
                    Object objAggregateBloodPressure = BloodPressureAggregationExtensionsKt.aggregateBloodPressure(healthConnectClient2, aggregateGroupByDurationRequest2, anonymousClass9);
                    if (objAggregateBloodPressure != coroutine_suspended) {
                        healthConnectClient3 = healthConnectClient2;
                        list = (List) objAggregateBloodPressure;
                        obj = obj3;
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
                        obj3 = obj;
                        healthConnectClient2 = healthConnectClient3;
                    }
                    return coroutine_suspended;
                }
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class))) {
                    ReadRecordsRequest readRecordsRequest = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(aggregateGroupByDurationRequest2.getTimeRangeFilter()), aggregateGroupByDurationRequest2.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                    obj = obj3;
                    ResultGroupedByDurationAggregator resultGroupedByDurationAggregator = new ResultGroupedByDurationAggregator(TimeRangeFilterUtilsKt.createTimeRange(aggregateGroupByDurationRequest2.getTimeRangeFilter()), aggregateGroupByDurationRequest2.getTimeRangeSlicer(), new Function1<InstantTimeRange, AggregationProcessor<CyclingPedalingCadenceRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$lambda$11$$inlined$aggregateSeries$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final AggregationProcessor<CyclingPedalingCadenceRecord> invoke(InstantTimeRange instantTimeRange) {
                            instantTimeRange.getClass();
                            return new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), aggregateGroupByDurationRequest2.getMetrics$connect_client_release(), instantTimeRange);
                        }
                    });
                    anonymousClass9.L$0 = healthConnectClient2;
                    anonymousClass9.L$1 = arrayList;
                    anonymousClass9.L$2 = it;
                    anonymousClass9.label = 2;
                    Object objAggregate = aggregate(healthConnectClient2, readRecordsRequest, resultGroupedByDurationAggregator, anonymousClass9);
                    if (objAggregate != coroutine_suspended) {
                        healthConnectClient3 = healthConnectClient2;
                        list = (List) objAggregate;
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
                        obj3 = obj;
                        healthConnectClient2 = healthConnectClient3;
                    }
                    return coroutine_suspended;
                }
                obj = obj3;
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(NutritionRecord.class))) {
                    anonymousClass9.L$0 = healthConnectClient2;
                    anonymousClass9.L$1 = arrayList;
                    anonymousClass9.L$2 = it;
                    anonymousClass9.label = 3;
                    Object objAggregateNutritionTransFatTotal = NutritionAggregationExtensionsKt.aggregateNutritionTransFatTotal(healthConnectClient2, aggregateGroupByDurationRequest2, anonymousClass9);
                    if (objAggregateNutritionTransFatTotal != coroutine_suspended) {
                        healthConnectClient3 = healthConnectClient2;
                        list = (List) objAggregateNutritionTransFatTotal;
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
                        obj3 = obj;
                        healthConnectClient2 = healthConnectClient3;
                    }
                    return coroutine_suspended;
                }
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(SpeedRecord.class))) {
                    ReadRecordsRequest readRecordsRequest2 = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(SpeedRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(aggregateGroupByDurationRequest2.getTimeRangeFilter()), aggregateGroupByDurationRequest2.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                    ResultGroupedByDurationAggregator resultGroupedByDurationAggregator2 = new ResultGroupedByDurationAggregator(TimeRangeFilterUtilsKt.createTimeRange(aggregateGroupByDurationRequest2.getTimeRangeFilter()), aggregateGroupByDurationRequest2.getTimeRangeSlicer(), new Function1<InstantTimeRange, AggregationProcessor<SpeedRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$lambda$11$$inlined$aggregateSeries$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final AggregationProcessor<SpeedRecord> invoke(InstantTimeRange instantTimeRange) {
                            instantTimeRange.getClass();
                            return new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(SpeedRecord.class), aggregateGroupByDurationRequest2.getMetrics$connect_client_release(), instantTimeRange);
                        }
                    });
                    anonymousClass9.L$0 = healthConnectClient2;
                    anonymousClass9.L$1 = arrayList;
                    anonymousClass9.L$2 = it;
                    anonymousClass9.label = 4;
                    Object objAggregate2 = aggregate(healthConnectClient2, readRecordsRequest2, resultGroupedByDurationAggregator2, anonymousClass9);
                    if (objAggregate2 != coroutine_suspended) {
                        healthConnectClient3 = healthConnectClient2;
                        list = (List) objAggregate2;
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
                        obj3 = obj;
                        healthConnectClient2 = healthConnectClient3;
                    }
                } else {
                    if (!Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class))) {
                        Utf8$$ExternalSyntheticBUOutline0.m("Invalid record type for aggregation fallback: ", kClass);
                        return obj;
                    }
                    ReadRecordsRequest readRecordsRequest3 = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(aggregateGroupByDurationRequest2.getTimeRangeFilter()), aggregateGroupByDurationRequest2.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                    ResultGroupedByDurationAggregator resultGroupedByDurationAggregator3 = new ResultGroupedByDurationAggregator(TimeRangeFilterUtilsKt.createTimeRange(aggregateGroupByDurationRequest2.getTimeRangeFilter()), aggregateGroupByDurationRequest2.getTimeRangeSlicer(), new Function1<InstantTimeRange, AggregationProcessor<StepsCadenceRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$lambda$11$$inlined$aggregateSeries$3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final AggregationProcessor<StepsCadenceRecord> invoke(InstantTimeRange instantTimeRange) {
                            instantTimeRange.getClass();
                            return new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), aggregateGroupByDurationRequest2.getMetrics$connect_client_release(), instantTimeRange);
                        }
                    });
                    anonymousClass9.L$0 = healthConnectClient2;
                    anonymousClass9.L$1 = arrayList;
                    anonymousClass9.L$2 = it;
                    anonymousClass9.label = 5;
                    Object objAggregate3 = aggregate(healthConnectClient2, readRecordsRequest3, resultGroupedByDurationAggregator3, anonymousClass9);
                    if (objAggregate3 != coroutine_suspended) {
                        healthConnectClient3 = healthConnectClient2;
                        obj2 = objAggregate3;
                        list = (List) obj2;
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
                        obj3 = obj;
                        healthConnectClient2 = healthConnectClient3;
                    }
                }
                return coroutine_suspended;
                if (it.hasNext()) {
                    final List list2 = (List) arrayList;
                    Grouping<AggregationResultGroupedByDurationWithMinTime, Instant> grouping = new Grouping<AggregationResultGroupedByDurationWithMinTime, Instant>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$$inlined$groupingBy$2
                        @Override // kotlin.collections.Grouping
                        public Instant keyOf(AggregationResultGroupedByDurationWithMinTime element) {
                            return element.getAggregationResultGroupedByDuration().getStartTime();
                        }

                        @Override // kotlin.collections.Grouping
                        public Iterator<AggregationResultGroupedByDurationWithMinTime> sourceIterator() {
                            return list2.iterator();
                        }
                    };
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Iterator<AggregationResultGroupedByDurationWithMinTime> itSourceIterator = grouping.sourceIterator();
                    while (itSourceIterator.hasNext()) {
                        AggregationResultGroupedByDurationWithMinTime next = itSourceIterator.next();
                        Instant instantKeyOf = grouping.keyOf(next);
                        Object obj4 = linkedHashMap.get(instantKeyOf);
                        if (obj4 != null || linkedHashMap.containsKey(instantKeyOf)) {
                            AggregationResultGroupedByDurationWithMinTime aggregationResultGroupedByDurationWithMinTime = next;
                            AggregationResultGroupedByDurationWithMinTime aggregationResultGroupedByDurationWithMinTime2 = (AggregationResultGroupedByDurationWithMinTime) obj4;
                            next = new AggregationResultGroupedByDurationWithMinTime(new AggregationResultGroupedByDuration(aggregationResultGroupedByDurationWithMinTime2.getAggregationResultGroupedByDuration().getResult().plus$connect_client_release(aggregationResultGroupedByDurationWithMinTime.getAggregationResultGroupedByDuration().getResult()), instantKeyOf, aggregationResultGroupedByDurationWithMinTime2.getAggregationResultGroupedByDuration().getEndTime(), ((AggregationResultGroupedByDurationWithMinTime) ComparisonsKt.minOf(aggregationResultGroupedByDurationWithMinTime2, aggregationResultGroupedByDurationWithMinTime, new Comparator() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$lambda$14$$inlined$compareBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    return ComparisonsKt.compareValues(((AggregationResultGroupedByDurationWithMinTime) t).getMinTime(), ((AggregationResultGroupedByDurationWithMinTime) t2).getMinTime());
                                }
                            })).getAggregationResultGroupedByDuration().getZoneOffset(), false, 16, null), (Instant) ComparisonsKt___ComparisonsJvmKt.minOf(aggregationResultGroupedByDurationWithMinTime2.getMinTime(), aggregationResultGroupedByDurationWithMinTime.getMinTime()));
                        }
                        linkedHashMap.put(instantKeyOf, next);
                    }
                    ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
                    Iterator it2 = linkedHashMap.entrySet().iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((AggregationResultGroupedByDurationWithMinTime) ((Map.Entry) it2.next()).getValue()).getAggregationResultGroupedByDuration());
                    }
                    return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$$inlined$sortedBy$2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((AggregationResultGroupedByDuration) t).getStartTime(), ((AggregationResultGroupedByDuration) t2).getStartTime());
                        }
                    });
                }
            }
        } else {
            ResultKt.throwOnFailure(obj2);
            Set<KClass<? extends Record>> set = AGGREGATION_FALLBACK_RECORD_TYPES;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set, 10)), 16));
            for (Object obj5 : set) {
                final KClass kClass2 = (KClass) obj5;
                linkedHashMap2.put(obj5, AggregationExtensionsKt.withFilteredMetrics(aggregateGroupByDurationRequest, new Function1<AggregateMetric<?>, Boolean>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$10$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Boolean invoke(AggregateMetric<?> aggregateMetric) {
                        boolean z;
                        aggregateMetric.getClass();
                        if (!AggregationExtensionsKt.isPlatformSupportedMetric(aggregateMetric)) {
                            String dataTypeName = aggregateMetric.getDataTypeName();
                            String str = RecordsTypeNameMapKt.getRECORDS_CLASS_NAME_MAP().get(kClass2);
                            str.getClass();
                            z = Intrinsics.areEqual(dataTypeName, str);
                        }
                        return Boolean.valueOf(z);
                    }
                }));
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                if (!((AggregateGroupByDurationRequest) entry2.getValue()).getMetrics$connect_client_release().isEmpty()) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            arrayList = new ArrayList();
            it = linkedHashMap3.entrySet().iterator();
            healthConnectClient2 = healthConnectClient;
            if (it.hasNext()) {
            }
        }
    }

    public static final <T extends Record> Flow<List<T>> readRecordsFlow(HealthConnectClient healthConnectClient, ReadRecordsRequest<T> readRecordsRequest) {
        healthConnectClient.getClass();
        readRecordsRequest.getClass();
        return FlowKt.flow(new C01091(readRecordsRequest, healthConnectClient, null));
    }
}
