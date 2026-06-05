package com.urbandroid.sleep.alarmclock.settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class NoEscapeActivity$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ NoEscapeActivity f$0;

    public /* synthetic */ NoEscapeActivity$$ExternalSyntheticLambda0(NoEscapeActivity noEscapeActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = noEscapeActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        NoEscapeActivity noEscapeActivity = this.f$0;
        switch (i) {
            case 0:
                NoEscapeActivity.onStart$lambda$0(noEscapeActivity);
                break;
            default:
                NoEscapeActivity.onCreate$lambda$0(noEscapeActivity, 0);
                break;
        }
    }
}
