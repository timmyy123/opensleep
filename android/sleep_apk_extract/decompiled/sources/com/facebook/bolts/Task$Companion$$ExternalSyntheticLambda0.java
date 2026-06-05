package com.facebook.bolts;

import com.facebook.bolts.Task;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Task$Companion$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CancellationToken f$0;
    public final /* synthetic */ TaskCompletionSource f$1;
    public final /* synthetic */ Continuation f$2;
    public final /* synthetic */ Task f$3;

    public /* synthetic */ Task$Companion$$ExternalSyntheticLambda0(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task, int i) {
        this.$r8$classId = i;
        this.f$0 = cancellationToken;
        this.f$1 = taskCompletionSource;
        this.f$2 = continuation;
        this.f$3 = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                Task.Companion.completeAfterTask$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3);
                break;
            default:
                Task.Companion.completeImmediately$lambda$5(this.f$0, this.f$1, this.f$2, this.f$3);
                break;
        }
    }
}
