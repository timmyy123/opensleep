package androidx.health.platform.client.impl.ipc.internal;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectionConfiguration {
    private final String mBindAction;
    private final String mClientName;
    private final String mPackageName;
    private final QueueOperation mRefreshVersionOperation;

    public ConnectionConfiguration(String str, String str2, String str3, QueueOperation queueOperation) {
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mClientName = (String) Preconditions.checkNotNull(str2);
        this.mBindAction = (String) Preconditions.checkNotNull(str3);
        this.mRefreshVersionOperation = (QueueOperation) Preconditions.checkNotNull(queueOperation);
    }

    public String getBindAction() {
        return this.mBindAction;
    }

    public String getClientName() {
        return this.mClientName;
    }

    public String getKey() {
        return Fragment$$ExternalSyntheticOutline1.m(this.mClientName, "#", this.mPackageName, "#", this.mBindAction);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public QueueOperation getRefreshVersionOperation() {
        return this.mRefreshVersionOperation;
    }
}
