package com.facebook.bolts;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Task$$ExternalSyntheticLambda1 implements Continuation {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ TaskCompletionSource f$0;
    public final /* synthetic */ Continuation f$1;
    public final /* synthetic */ Executor f$2;
    public final /* synthetic */ CancellationToken f$3;

    public /* synthetic */ Task$$ExternalSyntheticLambda1(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken, int i) {
        this.$r8$classId = i;
        this.f$0 = taskCompletionSource;
        this.f$1 = continuation;
        this.f$2 = executor;
        this.f$3 = cancellationToken;
    }

    @Override // com.facebook.bolts.Continuation
    public final Object then(Task task) {
        int i = this.$r8$classId;
        CancellationToken cancellationToken = this.f$3;
        Executor executor = this.f$2;
        Continuation continuation = this.f$1;
        TaskCompletionSource taskCompletionSource = this.f$0;
        switch (i) {
            case 0:
                return Task.continueWith$lambda$10$lambda$9(taskCompletionSource, continuation, executor, cancellationToken, task);
            default:
                return Task.continueWithTask$lambda$12$lambda$11(taskCompletionSource, continuation, executor, cancellationToken, task);
        }
    }
}
