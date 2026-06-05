package com.facebook.bolts;

import com.facebook.bolts.Task;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Task$Companion$$ExternalSyntheticLambda1 implements Continuation {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AtomicBoolean f$0;
    public final /* synthetic */ TaskCompletionSource f$1;

    public /* synthetic */ Task$Companion$$ExternalSyntheticLambda1(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, int i) {
        this.$r8$classId = i;
        this.f$0 = atomicBoolean;
        this.f$1 = taskCompletionSource;
    }

    @Override // com.facebook.bolts.Continuation
    public final Object then(Task task) {
        int i = this.$r8$classId;
        TaskCompletionSource taskCompletionSource = this.f$1;
        AtomicBoolean atomicBoolean = this.f$0;
        switch (i) {
            case 0:
                return Task.Companion.whenAnyResult$lambda$3(atomicBoolean, taskCompletionSource, task);
            default:
                return Task.Companion.whenAny$lambda$4(atomicBoolean, taskCompletionSource, task);
        }
    }
}
