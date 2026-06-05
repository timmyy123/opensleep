package androidx.health.platform.client.impl;

import androidx.health.platform.client.changes.ChangesEvent;
import androidx.health.platform.client.proto.ChangeProto;
import androidx.health.platform.client.service.IOnChangesListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/health/platform/client/impl/OnChangesListenerProxy;", "Landroidx/health/platform/client/service/IOnChangesListener$Stub;", "listener", "Lkotlin/Function1;", "Landroidx/health/platform/client/proto/ChangeProto$ChangesEvent;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onChanges", "changesEvent", "Landroidx/health/platform/client/changes/ChangesEvent;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OnChangesListenerProxy extends IOnChangesListener.Stub {
    private final Function1<ChangeProto.ChangesEvent, Unit> listener;

    /* JADX WARN: Multi-variable type inference failed */
    public OnChangesListenerProxy(Function1<? super ChangeProto.ChangesEvent, Unit> function1) {
        function1.getClass();
        this.listener = function1;
    }

    @Override // androidx.health.platform.client.service.IOnChangesListener
    public void onChanges(ChangesEvent changesEvent) {
        changesEvent.getClass();
        this.listener.invoke(changesEvent.getProto());
    }
}
