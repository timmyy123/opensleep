package androidx.health.platform.client.impl;

import androidx.health.platform.client.error.ErrorStatus;
import androidx.health.platform.client.impl.error.ErrorStatusConverterKt;
import androidx.health.platform.client.proto.ResponseProto;
import androidx.health.platform.client.response.GetChangesResponse;
import androidx.health.platform.client.service.IGetChangesCallback;
import com.google.common.util.concurrent.SettableFuture;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/health/platform/client/impl/GetChangesCallback;", "Landroidx/health/platform/client/service/IGetChangesCallback$Stub;", "resultFuture", "Lcom/google/common/util/concurrent/SettableFuture;", "Landroidx/health/platform/client/proto/ResponseProto$GetChangesResponse;", "<init>", "(Lcom/google/common/util/concurrent/SettableFuture;)V", "onSuccess", "", "response", "Landroidx/health/platform/client/response/GetChangesResponse;", "onError", "error", "Landroidx/health/platform/client/error/ErrorStatus;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GetChangesCallback extends IGetChangesCallback.Stub {
    private final SettableFuture<ResponseProto.GetChangesResponse> resultFuture;

    public GetChangesCallback(SettableFuture<ResponseProto.GetChangesResponse> settableFuture) {
        settableFuture.getClass();
        this.resultFuture = settableFuture;
    }

    @Override // androidx.health.platform.client.service.IGetChangesCallback
    public void onError(ErrorStatus error) {
        error.getClass();
        this.resultFuture.setException(ErrorStatusConverterKt.toException(error));
    }

    @Override // androidx.health.platform.client.service.IGetChangesCallback
    public void onSuccess(GetChangesResponse response) {
        response.getClass();
        this.resultFuture.set(response.getProto());
    }
}
