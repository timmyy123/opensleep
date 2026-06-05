package androidx.health.platform.client.impl;

import androidx.health.platform.client.impl.ipc.RemoteFutureOperation;
import androidx.health.platform.client.service.IHealthDataService;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ServiceBackedHealthDataClient$$ExternalSyntheticLambda3 implements RemoteFutureOperation {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ServiceBackedHealthDataClient f$0;
    public final /* synthetic */ Set f$1;

    public /* synthetic */ ServiceBackedHealthDataClient$$ExternalSyntheticLambda3(ServiceBackedHealthDataClient serviceBackedHealthDataClient, Set set, int i) {
        this.$r8$classId = i;
        this.f$0 = serviceBackedHealthDataClient;
        this.f$1 = set;
    }

    @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
    public final void execute(Object obj, SettableFuture settableFuture) {
        int i = this.$r8$classId;
        Set set = this.f$1;
        ServiceBackedHealthDataClient serviceBackedHealthDataClient = this.f$0;
        IHealthDataService iHealthDataService = (IHealthDataService) obj;
        switch (i) {
            case 0:
                ServiceBackedHealthDataClient.filterGrantedPermissions$lambda$3(serviceBackedHealthDataClient, set, iHealthDataService, settableFuture);
                break;
            default:
                ServiceBackedHealthDataClient.getGrantedPermissions$lambda$1(serviceBackedHealthDataClient, set, iHealthDataService, settableFuture);
                break;
        }
    }
}
