package com.facebook.bolts;

import com.facebook.bolts.Task;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Task$$ExternalSyntheticLambda0 implements Continuation {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CancellationToken f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Task$$ExternalSyntheticLambda0(CancellationToken cancellationToken, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = cancellationToken;
        this.f$1 = obj;
    }

    @Override // com.facebook.bolts.Continuation
    public final Object then(Task task) {
        switch (this.$r8$classId) {
            case 0:
                return Task.onSuccessTask$lambda$14(this.f$0, (Continuation) this.f$1, task);
            case 1:
                return Task.onSuccess$lambda$13(this.f$0, (Continuation) this.f$1, task);
            default:
                return Task.Companion.completeAfterTask$lambda$7$lambda$6(this.f$0, (TaskCompletionSource) this.f$1, task);
        }
    }
}
