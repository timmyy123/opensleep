package com.urbandroid.sleep.media.lullaby;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LullabyService$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LullabyService f$0;

    public /* synthetic */ LullabyService$$ExternalSyntheticLambda1(LullabyService lullabyService, int i) {
        this.$r8$classId = i;
        this.f$0 = lullabyService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        LullabyService lullabyService = this.f$0;
        switch (i) {
            case 0:
                lullabyService.lambda$new$2();
                break;
            case 1:
                lullabyService.lambda$new$3();
                break;
            case 2:
                lullabyService.lambda$new$4();
                break;
            default:
                lullabyService.lambda$autoStop$1();
                break;
        }
    }
}
