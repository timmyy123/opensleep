package com.urbandroid.sleep;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Sleep$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Sleep f$0;

    public /* synthetic */ Sleep$$ExternalSyntheticLambda4(Sleep sleep, int i) {
        this.$r8$classId = i;
        this.f$0 = sleep;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Sleep sleep = this.f$0;
        switch (i) {
            case 0:
                sleep.lambda$new$6();
                break;
            case 1:
                sleep.lambda$onActivityResult$10();
                break;
            case 2:
                sleep.lambda$onActivityResult$11();
                break;
            default:
                sleep.handleShowCase();
                break;
        }
    }
}
