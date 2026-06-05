package androidx.health.platform.client.impl;

import androidx.health.platform.client.error.ErrorStatus;
import androidx.health.platform.client.impl.error.ErrorStatusConverterKt;
import androidx.health.platform.client.response.InsertDataResponse;
import androidx.health.platform.client.service.IInsertDataCallback;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/health/platform/client/impl/InsertDataCallback;", "Landroidx/health/platform/client/service/IInsertDataCallback$Stub;", "resultFuture", "Lcom/google/common/util/concurrent/SettableFuture;", "", "", "<init>", "(Lcom/google/common/util/concurrent/SettableFuture;)V", "onSuccess", "", "response", "Landroidx/health/platform/client/response/InsertDataResponse;", "onError", "error", "Landroidx/health/platform/client/error/ErrorStatus;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InsertDataCallback extends IInsertDataCallback.Stub {
    private final SettableFuture<List<String>> resultFuture;

    public InsertDataCallback(SettableFuture<List<String>> settableFuture) {
        settableFuture.getClass();
        this.resultFuture = settableFuture;
    }

    @Override // androidx.health.platform.client.service.IInsertDataCallback
    public void onError(ErrorStatus error) {
        error.getClass();
        this.resultFuture.setException(ErrorStatusConverterKt.toException(error));
    }

    @Override // androidx.health.platform.client.service.IInsertDataCallback
    public void onSuccess(InsertDataResponse response) {
        response.getClass();
        this.resultFuture.set(response.getDataPointUids());
    }
}
