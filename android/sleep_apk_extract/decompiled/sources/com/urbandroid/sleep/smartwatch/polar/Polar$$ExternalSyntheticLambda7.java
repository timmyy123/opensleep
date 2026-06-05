package com.urbandroid.sleep.smartwatch.polar;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Polar$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Polar f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ Polar$$ExternalSyntheticLambda7(Polar polar, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = polar;
        this.f$1 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        int i2 = this.f$1;
        Polar polar = this.f$0;
        switch (i) {
            case 0:
                Polar.startAccel$lambda$0(polar, i2);
                break;
            case 1:
                Polar.startHr$lambda$0(polar, i2);
                break;
            case 2:
                Polar.startHr$lambda$1(polar, i2);
                break;
            default:
                Polar.startAccel$lambda$1(polar, i2);
                break;
        }
    }
}
