package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class DelegatingScheduledExecutorService$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ DelegatingScheduledExecutorService f$0;
    public final /* synthetic */ Runnable f$1;
    public final /* synthetic */ DelegatingScheduledFuture.Completer f$2;

    public /* synthetic */ DelegatingScheduledExecutorService$$ExternalSyntheticLambda4(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer, int i) {
        this.$r8$classId = i;
        this.f$0 = delegatingScheduledExecutorService;
        this.f$1 = runnable;
        this.f$2 = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        DelegatingScheduledFuture.Completer completer = this.f$2;
        Runnable runnable = this.f$1;
        DelegatingScheduledExecutorService delegatingScheduledExecutorService = this.f$0;
        switch (i) {
            case 0:
                delegatingScheduledExecutorService.lambda$scheduleAtFixedRate$7(runnable, completer);
                break;
            case 1:
                delegatingScheduledExecutorService.lambda$schedule$1(runnable, completer);
                break;
            default:
                delegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$10(runnable, completer);
                break;
        }
    }
}
