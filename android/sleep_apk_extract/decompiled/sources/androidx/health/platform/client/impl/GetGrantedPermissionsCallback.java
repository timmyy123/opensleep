package androidx.health.platform.client.impl;

import androidx.health.platform.client.error.ErrorStatus;
import androidx.health.platform.client.impl.error.ErrorStatusConverterKt;
import androidx.health.platform.client.permission.Permission;
import androidx.health.platform.client.proto.PermissionProto;
import androidx.health.platform.client.service.IGetGrantedPermissionsCallback;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/health/platform/client/impl/GetGrantedPermissionsCallback;", "Landroidx/health/platform/client/service/IGetGrantedPermissionsCallback$Stub;", "resultFuture", "Lcom/google/common/util/concurrent/SettableFuture;", "", "Landroidx/health/platform/client/proto/PermissionProto$Permission;", "<init>", "(Lcom/google/common/util/concurrent/SettableFuture;)V", "onSuccess", "", "response", "", "Landroidx/health/platform/client/permission/Permission;", "onError", "error", "Landroidx/health/platform/client/error/ErrorStatus;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GetGrantedPermissionsCallback extends IGetGrantedPermissionsCallback.Stub {
    private final SettableFuture<Set<PermissionProto.Permission>> resultFuture;

    public GetGrantedPermissionsCallback(SettableFuture<Set<PermissionProto.Permission>> settableFuture) {
        settableFuture.getClass();
        this.resultFuture = settableFuture;
    }

    @Override // androidx.health.platform.client.service.IGetGrantedPermissionsCallback
    public void onError(ErrorStatus error) {
        error.getClass();
        this.resultFuture.setException(ErrorStatusConverterKt.toException(error));
    }

    @Override // androidx.health.platform.client.service.IGetGrantedPermissionsCallback
    public void onSuccess(List<Permission> response) {
        response.getClass();
        SettableFuture<Set<PermissionProto.Permission>> settableFuture = this.resultFuture;
        List<Permission> list = response;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Permission) it.next()).getProto());
        }
        settableFuture.set(CollectionsKt.toSet(arrayList));
    }
}
