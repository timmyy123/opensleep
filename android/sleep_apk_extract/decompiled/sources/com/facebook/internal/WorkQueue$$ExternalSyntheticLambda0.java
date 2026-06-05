package com.facebook.internal;

import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.WorkQueue;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WorkQueue$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ WorkQueue$$ExternalSyntheticLambda0(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                WorkQueue.execute$lambda$2((WorkQueue.WorkNode) obj2, (WorkQueue) obj);
                break;
            default:
                ((FetchedAppSettingsManager.FetchedAppSettingsCallback) obj2).onSuccess((FetchedAppSettings) obj);
                break;
        }
    }
}
