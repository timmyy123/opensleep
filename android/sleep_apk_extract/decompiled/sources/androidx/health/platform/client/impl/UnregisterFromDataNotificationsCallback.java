package androidx.health.platform.client.impl;

import androidx.health.platform.client.error.ErrorStatus;
import androidx.health.platform.client.impl.error.ErrorStatusConverterKt;
import androidx.health.platform.client.service.IUnregisterFromDataNotificationsCallback;
import com.facebook.internal.AnalyticsEvents;
import com.google.common.util.concurrent.SettableFuture;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/health/platform/client/impl/UnregisterFromDataNotificationsCallback;", "Landroidx/health/platform/client/service/IUnregisterFromDataNotificationsCallback$Stub;", "resultFuture", "Lcom/google/common/util/concurrent/SettableFuture;", "Ljava/lang/Void;", "<init>", "(Lcom/google/common/util/concurrent/SettableFuture;)V", "onSuccess", "", "onError", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "Landroidx/health/platform/client/error/ErrorStatus;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnregisterFromDataNotificationsCallback extends IUnregisterFromDataNotificationsCallback.Stub {
    private final SettableFuture<Void> resultFuture;

    public UnregisterFromDataNotificationsCallback(SettableFuture<Void> settableFuture) {
        settableFuture.getClass();
        this.resultFuture = settableFuture;
    }

    @Override // androidx.health.platform.client.service.IUnregisterFromDataNotificationsCallback
    public void onError(ErrorStatus status) {
        status.getClass();
        this.resultFuture.setException(ErrorStatusConverterKt.toException(status));
    }

    @Override // androidx.health.platform.client.service.IUnregisterFromDataNotificationsCallback
    public void onSuccess() {
        this.resultFuture.set(null);
    }
}
