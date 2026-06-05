package com.facebook.appevents.internal;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ActivityLifecycleTracker$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ ActivityLifecycleTracker$$ExternalSyntheticLambda2(long j, String str, int i) {
        this.$r8$classId = i;
        this.f$0 = j;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ActivityLifecycleTracker.onActivityPaused$lambda$7(this.f$0, this.f$1);
                break;
            default:
                ActivityLifecycleTracker.onActivityPaused$lambda$7$lambda$5(this.f$0, this.f$1);
                break;
        }
    }
}
