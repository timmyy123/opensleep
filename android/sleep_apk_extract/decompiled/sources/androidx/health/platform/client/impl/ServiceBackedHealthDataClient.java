package androidx.health.platform.client.impl;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.health.platform.client.HealthDataAsyncClient;
import androidx.health.platform.client.impl.internal.ProviderConnectionManager;
import androidx.health.platform.client.impl.ipc.Client;
import androidx.health.platform.client.impl.ipc.ClientConfiguration;
import androidx.health.platform.client.impl.ipc.internal.ConnectionManager;
import androidx.health.platform.client.impl.permission.foregroundstate.ForegroundStateChecker;
import androidx.health.platform.client.impl.permission.token.PermissionTokenManager;
import androidx.health.platform.client.permission.Permission;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.PermissionProto;
import androidx.health.platform.client.proto.RequestProto;
import androidx.health.platform.client.proto.ResponseProto;
import androidx.health.platform.client.request.AggregateDataRequest;
import androidx.health.platform.client.request.DeleteDataRangeRequest;
import androidx.health.platform.client.request.DeleteDataRequest;
import androidx.health.platform.client.request.GetChangesRequest;
import androidx.health.platform.client.request.GetChangesTokenRequest;
import androidx.health.platform.client.request.ReadDataRangeRequest;
import androidx.health.platform.client.request.ReadDataRequest;
import androidx.health.platform.client.request.RegisterForDataNotificationsRequest;
import androidx.health.platform.client.request.RequestContext;
import androidx.health.platform.client.request.UnregisterFromDataNotificationsRequest;
import androidx.health.platform.client.request.UpsertDataRequest;
import androidx.health.platform.client.service.IHealthDataService;
import androidx.work.WorkerKt$$ExternalSyntheticLambda0;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\"\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013H\u0016J\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001b0\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bH\u0016J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bH\u0016J*\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001bH\u0016J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\u00132\u0006\u0010\u001c\u001a\u00020$H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00132\u0006\u0010\u001c\u001a\u00020&H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00132\u0006\u0010\u001c\u001a\u00020)H\u0016J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00132\u0006\u0010,\u001a\u00020-H\u0016J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00132\u0006\u0010,\u001a\u000200H\u0016J\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00132\u0006\u0010,\u001a\u000203H\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00132\u0006\u0010,\u001a\u000206H\u0016J\u0016\u00107\u001a\b\u0012\u0004\u0012\u0002050\u00132\u0006\u0010,\u001a\u000208H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Landroidx/health/platform/client/impl/ServiceBackedHealthDataClient;", "Landroidx/health/platform/client/impl/ipc/Client;", "Landroidx/health/platform/client/service/IHealthDataService;", "Landroidx/health/platform/client/HealthDataAsyncClient;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "clientConfiguration", "Landroidx/health/platform/client/impl/ipc/ClientConfiguration;", "connectionManager", "Landroidx/health/platform/client/impl/ipc/internal/ConnectionManager;", "<init>", "(Landroid/content/Context;Landroidx/health/platform/client/impl/ipc/ClientConfiguration;Landroidx/health/platform/client/impl/ipc/internal/ConnectionManager;)V", "(Landroid/content/Context;Landroidx/health/platform/client/impl/ipc/ClientConfiguration;)V", "callingPackageName", "", "kotlin.jvm.PlatformType", "getRequestContext", "Landroidx/health/platform/client/request/RequestContext;", "getGrantedPermissions", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "Landroidx/health/platform/client/proto/PermissionProto$Permission;", "permissions", "filterGrantedPermissions", "revokeAllPermissions", "", "insertData", "", "dataCollection", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "updateData", "deleteData", "uidsCollection", "Landroidx/health/platform/client/proto/RequestProto$DataTypeIdPair;", "clientIdsCollection", "deleteDataRange", "Landroidx/health/platform/client/proto/RequestProto$DeleteDataRangeRequest;", "readData", "Landroidx/health/platform/client/proto/RequestProto$ReadDataRequest;", "readDataRange", "Landroidx/health/platform/client/proto/ResponseProto$ReadDataRangeResponse;", "Landroidx/health/platform/client/proto/RequestProto$ReadDataRangeRequest;", "aggregate", "Landroidx/health/platform/client/proto/ResponseProto$AggregateDataResponse;", "request", "Landroidx/health/platform/client/proto/RequestProto$AggregateDataRequest;", "getChangesToken", "Landroidx/health/platform/client/proto/ResponseProto$GetChangesTokenResponse;", "Landroidx/health/platform/client/proto/RequestProto$GetChangesTokenRequest;", "getChanges", "Landroidx/health/platform/client/proto/ResponseProto$GetChangesResponse;", "Landroidx/health/platform/client/proto/RequestProto$GetChangesRequest;", "registerForDataNotifications", "Ljava/lang/Void;", "Landroidx/health/platform/client/proto/RequestProto$RegisterForDataNotificationsRequest;", "unregisterFromDataNotifications", "Landroidx/health/platform/client/proto/RequestProto$UnregisterFromDataNotificationsRequest;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ServiceBackedHealthDataClient extends Client<IHealthDataService> implements HealthDataAsyncClient {
    private final String callingPackageName;
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceBackedHealthDataClient(Context context, ClientConfiguration clientConfiguration, ConnectionManager connectionManager) {
        super(clientConfiguration, connectionManager, new FacebookSdk$$ExternalSyntheticLambda1(), new FacebookSdk$$ExternalSyntheticLambda1());
        context.getClass();
        clientConfiguration.getClass();
        connectionManager.getClass();
        this.context = context;
        this.callingPackageName = context.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aggregate$lambda$11(ServiceBackedHealthDataClient serviceBackedHealthDataClient, RequestProto.AggregateDataRequest aggregateDataRequest, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        AggregateDataRequest aggregateDataRequest2 = new AggregateDataRequest(aggregateDataRequest);
        settableFuture.getClass();
        iHealthDataService.aggregate(requestContext, aggregateDataRequest2, new AggregateDataCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteData$lambda$7(ServiceBackedHealthDataClient serviceBackedHealthDataClient, DeleteDataRequest deleteDataRequest, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        settableFuture.getClass();
        iHealthDataService.deleteData(requestContext, deleteDataRequest, new DeleteDataCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteDataRange$lambda$8(ServiceBackedHealthDataClient serviceBackedHealthDataClient, DeleteDataRangeRequest deleteDataRangeRequest, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        settableFuture.getClass();
        iHealthDataService.deleteDataRange(requestContext, deleteDataRangeRequest, new DeleteDataRangeCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterGrantedPermissions$lambda$3(ServiceBackedHealthDataClient serviceBackedHealthDataClient, Set set, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(new Permission((PermissionProto.Permission) it.next()));
        }
        List<Permission> list = CollectionsKt.toList(arrayList);
        settableFuture.getClass();
        iHealthDataService.filterGrantedPermissions(requestContext, list, new FilterGrantedPermissionsCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChanges$lambda$13(ServiceBackedHealthDataClient serviceBackedHealthDataClient, RequestProto.GetChangesRequest getChangesRequest, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        GetChangesRequest getChangesRequest2 = new GetChangesRequest(getChangesRequest);
        settableFuture.getClass();
        iHealthDataService.getChanges(requestContext, getChangesRequest2, new GetChangesCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChangesToken$lambda$12(ServiceBackedHealthDataClient serviceBackedHealthDataClient, RequestProto.GetChangesTokenRequest getChangesTokenRequest, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        GetChangesTokenRequest getChangesTokenRequest2 = new GetChangesTokenRequest(getChangesTokenRequest);
        settableFuture.getClass();
        iHealthDataService.getChangesToken(requestContext, getChangesTokenRequest2, new GetChangesTokenCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGrantedPermissions$lambda$1(ServiceBackedHealthDataClient serviceBackedHealthDataClient, Set set, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(new Permission((PermissionProto.Permission) it.next()));
        }
        List<Permission> list = CollectionsKt.toList(arrayList);
        settableFuture.getClass();
        iHealthDataService.getGrantedPermissions(requestContext, list, new GetGrantedPermissionsCallback(settableFuture));
    }

    private final RequestContext getRequestContext() {
        String str = this.callingPackageName;
        str.getClass();
        return new RequestContext(str, 112, PermissionTokenManager.getCurrentToken(this.context), ForegroundStateChecker.isInForeground());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertData$lambda$5(ServiceBackedHealthDataClient serviceBackedHealthDataClient, UpsertDataRequest upsertDataRequest, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        settableFuture.getClass();
        iHealthDataService.insertData(requestContext, upsertDataRequest, new InsertDataCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void readData$lambda$9(ServiceBackedHealthDataClient serviceBackedHealthDataClient, ReadDataRequest readDataRequest, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        settableFuture.getClass();
        iHealthDataService.readData(requestContext, readDataRequest, new ReadDataCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void readDataRange$lambda$10(ServiceBackedHealthDataClient serviceBackedHealthDataClient, ReadDataRangeRequest readDataRangeRequest, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        settableFuture.getClass();
        iHealthDataService.readDataRange(requestContext, readDataRangeRequest, new ReadDataRangeCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerForDataNotifications$lambda$14(ServiceBackedHealthDataClient serviceBackedHealthDataClient, RequestProto.RegisterForDataNotificationsRequest registerForDataNotificationsRequest, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        RegisterForDataNotificationsRequest registerForDataNotificationsRequest2 = new RegisterForDataNotificationsRequest(registerForDataNotificationsRequest);
        settableFuture.getClass();
        iHealthDataService.registerForDataNotifications(requestContext, registerForDataNotificationsRequest2, new RegisterForDataNotificationsCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void revokeAllPermissions$lambda$4(ServiceBackedHealthDataClient serviceBackedHealthDataClient, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        settableFuture.getClass();
        iHealthDataService.revokeAllPermissions(requestContext, new RevokeAllPermissionsCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unregisterFromDataNotifications$lambda$15(ServiceBackedHealthDataClient serviceBackedHealthDataClient, RequestProto.UnregisterFromDataNotificationsRequest unregisterFromDataNotificationsRequest, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        UnregisterFromDataNotificationsRequest unregisterFromDataNotificationsRequest2 = new UnregisterFromDataNotificationsRequest(unregisterFromDataNotificationsRequest);
        settableFuture.getClass();
        iHealthDataService.unregisterFromDataNotifications(requestContext, unregisterFromDataNotificationsRequest2, new UnregisterFromDataNotificationsCallback(settableFuture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateData$lambda$6(ServiceBackedHealthDataClient serviceBackedHealthDataClient, UpsertDataRequest upsertDataRequest, IHealthDataService iHealthDataService, SettableFuture settableFuture) {
        RequestContext requestContext = serviceBackedHealthDataClient.getRequestContext();
        settableFuture.getClass();
        iHealthDataService.updateData(requestContext, upsertDataRequest, new UpdateDataCallback(settableFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<ResponseProto.AggregateDataResponse> aggregate(RequestProto.AggregateDataRequest request) {
        request.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(1, new WorkerKt$$ExternalSyntheticLambda0(this, request, 3));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Unit> deleteData(List<RequestProto.DataTypeIdPair> uidsCollection, List<RequestProto.DataTypeIdPair> clientIdsCollection) {
        uidsCollection.getClass();
        clientIdsCollection.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(1, new WorkerKt$$ExternalSyntheticLambda0(this, new DeleteDataRequest(uidsCollection, clientIdsCollection), 4));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Unit> deleteDataRange(RequestProto.DeleteDataRangeRequest dataCollection) {
        dataCollection.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(1, new WorkerKt$$ExternalSyntheticLambda0(this, new DeleteDataRangeRequest(dataCollection), 5));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Set<PermissionProto.Permission>> filterGrantedPermissions(Set<PermissionProto.Permission> permissions) {
        permissions.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(Math.min(1, 5), new ServiceBackedHealthDataClient$$ExternalSyntheticLambda3(this, permissions, 0));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<ResponseProto.GetChangesResponse> getChanges(RequestProto.GetChangesRequest request) {
        request.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(1, new WorkerKt$$ExternalSyntheticLambda0(this, request, 1));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<ResponseProto.GetChangesTokenResponse> getChangesToken(RequestProto.GetChangesTokenRequest request) {
        request.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(1, new WorkerKt$$ExternalSyntheticLambda0(this, request, 2));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Set<PermissionProto.Permission>> getGrantedPermissions(Set<PermissionProto.Permission> permissions) {
        permissions.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(1, new ServiceBackedHealthDataClient$$ExternalSyntheticLambda3(this, permissions, 1));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<List<String>> insertData(List<DataProto.DataPoint> dataCollection) {
        dataCollection.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(1, new ServiceBackedHealthDataClient$$ExternalSyntheticLambda7(this, new UpsertDataRequest(dataCollection), 0));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<DataProto.DataPoint> readData(RequestProto.ReadDataRequest dataCollection) {
        dataCollection.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(1, new WorkerKt$$ExternalSyntheticLambda0(this, new ReadDataRequest(dataCollection), 9));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<ResponseProto.ReadDataRangeResponse> readDataRange(RequestProto.ReadDataRangeRequest dataCollection) {
        dataCollection.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(1, new WorkerKt$$ExternalSyntheticLambda0(this, new ReadDataRangeRequest(dataCollection), 7));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Void> registerForDataNotifications(RequestProto.RegisterForDataNotificationsRequest request) {
        request.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(Math.min(1, 2), new WorkerKt$$ExternalSyntheticLambda0(this, request, 6));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Unit> revokeAllPermissions() {
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(1, new LoginFragment$$ExternalSyntheticLambda0(this, 2));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Void> unregisterFromDataNotifications(RequestProto.UnregisterFromDataNotificationsRequest request) {
        request.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(Math.min(1, 2), new WorkerKt$$ExternalSyntheticLambda0(this, request, 8));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Unit> updateData(List<DataProto.DataPoint> dataCollection) {
        dataCollection.getClass();
        ListenableFuture listenableFutureExecuteWithVersionCheck = executeWithVersionCheck(1, new ServiceBackedHealthDataClient$$ExternalSyntheticLambda7(this, new UpsertDataRequest(dataCollection), 1));
        listenableFutureExecuteWithVersionCheck.getClass();
        return listenableFutureExecuteWithVersionCheck;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ServiceBackedHealthDataClient(Context context, ClientConfiguration clientConfiguration) {
        this(context, clientConfiguration, ProviderConnectionManager.INSTANCE.getInstance(context));
        context.getClass();
        clientConfiguration.getClass();
    }
}
