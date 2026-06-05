package androidx.health.platform.client.impl;

import androidx.health.platform.client.error.ErrorStatus;
import androidx.health.platform.client.impl.error.ErrorStatusConverterKt;
import androidx.health.platform.client.service.IDeleteDataCallback;
import com.google.common.util.concurrent.SettableFuture;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/health/platform/client/impl/DeleteDataCallback;", "Landroidx/health/platform/client/service/IDeleteDataCallback$Stub;", "resultFuture", "Lcom/google/common/util/concurrent/SettableFuture;", "", "<init>", "(Lcom/google/common/util/concurrent/SettableFuture;)V", "onSuccess", "onError", "error", "Landroidx/health/platform/client/error/ErrorStatus;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeleteDataCallback extends IDeleteDataCallback.Stub {
    private final SettableFuture<Unit> resultFuture;

    public DeleteDataCallback(SettableFuture<Unit> settableFuture) {
        settableFuture.getClass();
        this.resultFuture = settableFuture;
    }

    @Override // androidx.health.platform.client.service.IDeleteDataCallback
    public void onError(ErrorStatus error) {
        error.getClass();
        this.resultFuture.setException(ErrorStatusConverterKt.toException(error));
    }

    @Override // androidx.health.platform.client.service.IDeleteDataCallback
    public void onSuccess() {
        this.resultFuture.set(Unit.INSTANCE);
    }
}
