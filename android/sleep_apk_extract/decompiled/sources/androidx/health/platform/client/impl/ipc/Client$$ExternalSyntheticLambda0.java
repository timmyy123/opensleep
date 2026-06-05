package androidx.health.platform.client.impl.ipc;

import android.os.IInterface;
import com.google.common.util.concurrent.SettableFuture;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Client$$ExternalSyntheticLambda0 implements RemoteFutureOperation {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ RemoteOperation f$0;

    public /* synthetic */ Client$$ExternalSyntheticLambda0(RemoteOperation remoteOperation, int i) {
        this.$r8$classId = i;
        this.f$0 = remoteOperation;
    }

    @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
    public final void execute(Object obj, SettableFuture settableFuture) {
        int i = this.$r8$classId;
        RemoteOperation remoteOperation = this.f$0;
        IInterface iInterface = (IInterface) obj;
        switch (i) {
            case 0:
                Client.lambda$registerListener$2(remoteOperation, iInterface, settableFuture);
                break;
            case 1:
                Client.lambda$execute$0(remoteOperation, iInterface, settableFuture);
                break;
            default:
                Client.lambda$unregisterListener$3(remoteOperation, iInterface, settableFuture);
                break;
        }
    }
}
