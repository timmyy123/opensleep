package androidx.health.platform.client.impl;

import androidx.health.platform.client.impl.ipc.RemoteFutureOperation;
import androidx.health.platform.client.request.UpsertDataRequest;
import androidx.health.platform.client.service.IHealthDataService;
import com.google.common.util.concurrent.SettableFuture;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ServiceBackedHealthDataClient$$ExternalSyntheticLambda7 implements RemoteFutureOperation {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ServiceBackedHealthDataClient f$0;
    public final /* synthetic */ UpsertDataRequest f$1;

    public /* synthetic */ ServiceBackedHealthDataClient$$ExternalSyntheticLambda7(ServiceBackedHealthDataClient serviceBackedHealthDataClient, UpsertDataRequest upsertDataRequest, int i) {
        this.$r8$classId = i;
        this.f$0 = serviceBackedHealthDataClient;
        this.f$1 = upsertDataRequest;
    }

    @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
    public final void execute(Object obj, SettableFuture settableFuture) {
        int i = this.$r8$classId;
        UpsertDataRequest upsertDataRequest = this.f$1;
        ServiceBackedHealthDataClient serviceBackedHealthDataClient = this.f$0;
        IHealthDataService iHealthDataService = (IHealthDataService) obj;
        switch (i) {
            case 0:
                ServiceBackedHealthDataClient.insertData$lambda$5(serviceBackedHealthDataClient, upsertDataRequest, iHealthDataService, settableFuture);
                break;
            default:
                ServiceBackedHealthDataClient.updateData$lambda$6(serviceBackedHealthDataClient, upsertDataRequest, iHealthDataService, settableFuture);
                break;
        }
    }
}
