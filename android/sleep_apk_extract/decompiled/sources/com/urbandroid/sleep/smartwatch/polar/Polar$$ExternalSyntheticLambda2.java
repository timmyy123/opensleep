package com.urbandroid.sleep.smartwatch.polar;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Polar$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Polar f$0;

    public /* synthetic */ Polar$$ExternalSyntheticLambda2(Polar polar, int i) {
        this.$r8$classId = i;
        this.f$0 = polar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Polar polar = this.f$0;
        switch (i) {
            case 0:
                Polar.startLed$default(polar, false, 0, 2, null);
                break;
            case 1:
                Polar.startLed$default(polar, false, 0, 2, null);
                break;
            case 2:
                Polar.startLed$default(polar, false, 0, 2, null);
                break;
            default:
                Polar.startLed$default(polar, false, 0, 2, null);
                break;
        }
    }
}
