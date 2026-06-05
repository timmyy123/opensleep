package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class DelegatingScheduledExecutorService$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Runnable f$0;
    public final /* synthetic */ DelegatingScheduledFuture.Completer f$1;

    public /* synthetic */ DelegatingScheduledExecutorService$$ExternalSyntheticLambda8(Runnable runnable, DelegatingScheduledFuture.Completer completer, int i) {
        this.$r8$classId = i;
        this.f$0 = runnable;
        this.f$1 = completer;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        switch (this.$r8$classId) {
            case 0:
                DelegatingScheduledExecutorService.lambda$schedule$0(this.f$0, this.f$1);
                break;
            case 1:
                DelegatingScheduledExecutorService.lambda$scheduleAtFixedRate$6(this.f$0, this.f$1);
                break;
            default:
                DelegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$9(this.f$0, this.f$1);
                break;
        }
    }
}
