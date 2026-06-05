package androidx.health.connect.client.impl;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.HealthConnectFeatures;
import androidx.health.connect.client.PermissionController;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.feature.HealthConnectFeaturesApkImpl;
import androidx.health.connect.client.feature.HealthConnectFeaturesUnavailableImpl;
import androidx.health.connect.client.impl.converters.aggregate.ProtoToAggregateDataRowKt;
import androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt;
import androidx.health.connect.client.impl.converters.request.AggregateRequestToProtoKt;
import androidx.health.connect.client.impl.converters.request.DeleteDataRangeRequestToProtoKt;
import androidx.health.connect.client.impl.converters.request.ReadDataRangeRequestToProtoKt;
import androidx.health.connect.client.impl.converters.response.ProtoToReadRecordsResponseKt;
import androidx.health.connect.client.permission.HealthPermission;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.response.InsertRecordsResponse;
import androidx.health.connect.client.response.ReadRecordsResponse;
import androidx.health.connect.client.time.TimeRangeFilter;
import androidx.health.platform.client.HealthDataAsyncClient;
import androidx.health.platform.client.HealthDataService;
import androidx.health.platform.client.impl.logger.Logger;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.PermissionProto;
import androidx.health.platform.client.proto.ResponseProto;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.guava.ListenableFutureKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\rJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0012\u0010\u0010J\u001e\u0010\u0017\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u001d\u001a\u00020\u00112\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ.\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"\"\b\b\u0000\u0010\u001f*\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0096@¢\u0006\u0004\b#\u0010$J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00132\u0006\u0010!\u001a\u00020%H\u0096@¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010)R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Landroidx/health/connect/client/impl/HealthConnectClientImpl;", "Landroidx/health/connect/client/HealthConnectClient;", "Landroidx/health/connect/client/PermissionController;", "Landroidx/health/platform/client/HealthDataAsyncClient;", "delegate", "Landroidx/health/connect/client/HealthConnectFeatures;", "features", "<init>", "(Landroidx/health/platform/client/HealthDataAsyncClient;Landroidx/health/connect/client/HealthConnectFeatures;)V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "providerPackageName", "(Landroid/content/Context;Ljava/lang/String;)V", "", "getGrantedPermissions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "revokeAllPermissions", "", "Landroidx/health/connect/client/records/Record;", "records", "Landroidx/health/connect/client/response/InsertRecordsResponse;", "insertRecords", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/reflect/KClass;", "recordType", "Landroidx/health/connect/client/time/TimeRangeFilter;", "timeRangeFilter", "deleteRecords", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "request", "Landroidx/health/connect/client/response/ReadRecordsResponse;", "readRecords", "(Landroidx/health/connect/client/request/ReadRecordsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "aggregateGroupByDuration", "(Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/platform/client/HealthDataAsyncClient;", "Landroidx/health/connect/client/HealthConnectFeatures;", "getFeatures", "()Landroidx/health/connect/client/HealthConnectFeatures;", "getPermissionController", "()Landroidx/health/connect/client/PermissionController;", "permissionController", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HealthConnectClientImpl implements HealthConnectClient, PermissionController {
    private final HealthDataAsyncClient delegate;
    private final HealthConnectFeatures features;

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$aggregateGroupByDuration$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", l = {243}, m = "aggregateGroupByDuration")
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.aggregateGroupByDuration(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$deleteRecords$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", l = {159}, m = "deleteRecords")
    public static final class AnonymousClass3 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.deleteRecords(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$getGrantedPermissions$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", l = {101}, m = "getGrantedPermissions")
    public static final class C01011 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01011(Continuation<? super C01011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.getGrantedPermissions(this);
        }
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$insertRecords$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", l = {122}, m = "insertRecords")
    public static final class C01021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C01021(Continuation<? super C01021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.insertRecords(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$readRecords$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", l = {225}, m = "readRecords")
    public static final class C01031<T extends Record> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01031(Continuation<? super C01031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.readRecords(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.HealthConnectClientImpl$revokeAllPermissions$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientImpl", f = "HealthConnectClientImpl.kt", l = {113}, m = "revokeAllPermissions")
    public static final class C01041 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01041(Continuation<? super C01041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientImpl.this.revokeAllPermissions(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HealthConnectClientImpl(Context context, String str) {
        this(HealthDataService.INSTANCE.getClient(context, str), Intrinsics.areEqual(str, "com.google.android.apps.healthdata") ? new HealthConnectFeaturesApkImpl(context, str) : HealthConnectFeaturesUnavailableImpl.INSTANCE);
        context.getClass();
        str.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object aggregateGroupByDuration(AggregateGroupByDurationRequest aggregateGroupByDurationRequest, Continuation<? super List<AggregationResultGroupedByDuration>> continuation) throws Throwable {
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
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAwait);
                ListenableFuture<ResponseProto.AggregateDataResponse> listenableFutureAggregate = this.delegate.aggregate(AggregateRequestToProtoKt.toProto(aggregateGroupByDurationRequest));
                anonymousClass1.label = 1;
                objAwait = ListenableFutureKt.await(listenableFutureAggregate, anonymousClass1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objAwait);
            }
            List<DataProto.AggregateDataRow> rowsList = ((ResponseProto.AggregateDataResponse) objAwait).getRowsList();
            rowsList.getClass();
            List<DataProto.AggregateDataRow> list = rowsList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (DataProto.AggregateDataRow aggregateDataRow : list) {
                aggregateDataRow.getClass();
                arrayList.add(ProtoToAggregateDataRowKt.toAggregateDataRowGroupByDuration(aggregateDataRow));
            }
            List list2 = CollectionsKt.toList(arrayList);
            Logger.debug("HealthConnectClient", "Retrieved " + list2.size() + " duration aggregation buckets.");
            return list2;
        } catch (RemoteException e) {
            Throwable transactionTooLargeException = !(e instanceof DeadObjectException) ? e instanceof TransactionTooLargeException ? new TransactionTooLargeException(e.getMessage()) : new RemoteException(e.getMessage()) : new DeadObjectException(e.getMessage());
            transactionTooLargeException.initCause(e);
            throw transactionTooLargeException;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteRecords(KClass<? extends Record> kClass, TimeRangeFilter timeRangeFilter, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass3 anonymousClass3;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i = anonymousClass3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        }
        Object obj = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass3.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                ListenableFuture<Unit> listenableFutureDeleteDataRange = this.delegate.deleteDataRange(DeleteDataRangeRequestToProtoKt.toDeleteDataRangeRequestProto(kClass, timeRangeFilter));
                anonymousClass3.label = 1;
                if (ListenableFutureKt.await(listenableFutureDeleteDataRange, anonymousClass3) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            Logger.debug("HealthConnectClient", "Records deletion successful.");
            return Unit.INSTANCE;
        } catch (RemoteException e) {
            Throwable transactionTooLargeException = !(e instanceof DeadObjectException) ? e instanceof TransactionTooLargeException ? new TransactionTooLargeException(e.getMessage()) : new RemoteException(e.getMessage()) : new DeadObjectException(e.getMessage());
            transactionTooLargeException.initCause(e);
            throw transactionTooLargeException;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.health.connect.client.PermissionController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getGrantedPermissions(Continuation<? super Set<String>> continuation) throws Throwable {
        C01011 c01011;
        if (continuation instanceof C01011) {
            c01011 = (C01011) continuation;
            int i = c01011.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01011.label = i - Integer.MIN_VALUE;
            } else {
                c01011 = new C01011(continuation);
            }
        }
        Object objAwait = c01011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01011.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAwait);
                HealthDataAsyncClient healthDataAsyncClient = this.delegate;
                List<String> list = HealthPermission.ALL_PERMISSIONS;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(PermissionProto.Permission.newBuilder().setPermission((String) it.next()).build());
                }
                ListenableFuture<Set<PermissionProto.Permission>> listenableFutureFilterGrantedPermissions = healthDataAsyncClient.filterGrantedPermissions(CollectionsKt.toSet(arrayList));
                c01011.label = 1;
                objAwait = ListenableFutureKt.await(listenableFutureFilterGrantedPermissions, c01011);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objAwait);
            }
            Iterable iterable = (Iterable) objAwait;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((PermissionProto.Permission) it2.next()).getPermission());
            }
            Set set = CollectionsKt.toSet(arrayList2);
            Logger.debug("HealthConnectClient", "Granted " + set.size() + " out of " + HealthPermission.ALL_PERMISSIONS.size() + " permissions.");
            return set;
        } catch (RemoteException e) {
            Throwable transactionTooLargeException = !(e instanceof DeadObjectException) ? e instanceof TransactionTooLargeException ? new TransactionTooLargeException(e.getMessage()) : new RemoteException(e.getMessage()) : new DeadObjectException(e.getMessage());
            transactionTooLargeException.initCause(e);
            throw transactionTooLargeException;
        }
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
    public Object insertRecords(List<? extends Record> list, Continuation<? super InsertRecordsResponse> continuation) throws Throwable {
        C01021 c01021;
        if (continuation instanceof C01021) {
            c01021 = (C01021) continuation;
            int i = c01021.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01021.label = i - Integer.MIN_VALUE;
            } else {
                c01021 = new C01021(continuation);
            }
        }
        Object objAwait = c01021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01021.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAwait);
                HealthDataAsyncClient healthDataAsyncClient = this.delegate;
                List<? extends Record> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(RecordToProtoConvertersKt.toProto((Record) it.next()));
                }
                ListenableFuture<List<String>> listenableFutureInsertData = healthDataAsyncClient.insertData(arrayList);
                c01021.L$0 = list;
                c01021.label = 1;
                objAwait = ListenableFutureKt.await(listenableFutureInsertData, c01021);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                list = (List) c01021.L$0;
                ResultKt.throwOnFailure(objAwait);
            }
            List list3 = (List) objAwait;
            Logger.debug("HealthConnectClient", list.size() + " records inserted.");
            return new InsertRecordsResponse(list3);
        } catch (RemoteException e) {
            Throwable transactionTooLargeException = !(e instanceof DeadObjectException) ? e instanceof TransactionTooLargeException ? new TransactionTooLargeException(e.getMessage()) : new RemoteException(e.getMessage()) : new DeadObjectException(e.getMessage());
            transactionTooLargeException.initCause(e);
            throw transactionTooLargeException;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends Record> Object readRecords(ReadRecordsRequest<T> readRecordsRequest, Continuation<? super ReadRecordsResponse<T>> continuation) throws Throwable {
        C01031 c01031;
        if (continuation instanceof C01031) {
            c01031 = (C01031) continuation;
            int i = c01031.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01031.label = i - Integer.MIN_VALUE;
            } else {
                c01031 = new C01031(continuation);
            }
        }
        Object objAwait = c01031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01031.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAwait);
                if (readRecordsRequest.getDeduplicateStrategy() != 0) {
                    throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                }
                ListenableFuture<ResponseProto.ReadDataRangeResponse> dataRange = this.delegate.readDataRange(ReadDataRangeRequestToProtoKt.toReadDataRangeRequestProto(readRecordsRequest));
                c01031.label = 1;
                objAwait = ListenableFutureKt.await(dataRange, c01031);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objAwait);
            }
            ReadRecordsResponse readRecordsResponse = ProtoToReadRecordsResponseKt.toReadRecordsResponse((ResponseProto.ReadDataRangeResponse) objAwait);
            Logger.debug("HealthConnectClient", "Retrieve records successful.");
            return readRecordsResponse;
        } catch (RemoteException e) {
            Throwable transactionTooLargeException = !(e instanceof DeadObjectException) ? e instanceof TransactionTooLargeException ? new TransactionTooLargeException(e.getMessage()) : new RemoteException(e.getMessage()) : new DeadObjectException(e.getMessage());
            transactionTooLargeException.initCause(e);
            throw transactionTooLargeException;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.health.connect.client.PermissionController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object revokeAllPermissions(Continuation<? super Unit> continuation) throws Throwable {
        C01041 c01041;
        if (continuation instanceof C01041) {
            c01041 = (C01041) continuation;
            int i = c01041.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01041.label = i - Integer.MIN_VALUE;
            } else {
                c01041 = new C01041(continuation);
            }
        }
        Object obj = c01041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01041.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                ListenableFuture<Unit> listenableFutureRevokeAllPermissions = this.delegate.revokeAllPermissions();
                c01041.label = 1;
                if (ListenableFutureKt.await(listenableFutureRevokeAllPermissions, c01041) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            Logger.debug("HealthConnectClient", "Revoked all permissions.");
            return Unit.INSTANCE;
        } catch (RemoteException e) {
            Throwable transactionTooLargeException = !(e instanceof DeadObjectException) ? e instanceof TransactionTooLargeException ? new TransactionTooLargeException(e.getMessage()) : new RemoteException(e.getMessage()) : new DeadObjectException(e.getMessage());
            transactionTooLargeException.initCause(e);
            throw transactionTooLargeException;
        }
    }

    public HealthConnectClientImpl(HealthDataAsyncClient healthDataAsyncClient, HealthConnectFeatures healthConnectFeatures) {
        healthDataAsyncClient.getClass();
        healthConnectFeatures.getClass();
        this.delegate = healthDataAsyncClient;
        this.features = healthConnectFeatures;
    }
}
