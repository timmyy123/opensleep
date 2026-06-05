package com.urbandroid.sleep.smartwatch.pebble;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RePebble$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ RePebble f$0;

    public /* synthetic */ RePebble$$ExternalSyntheticLambda0(RePebble rePebble, int i) {
        this.$r8$classId = i;
        this.f$0 = rePebble;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        RePebble rePebble = this.f$0;
        switch (i) {
            case 0:
                rePebble.setEnableHr();
                break;
            case 1:
                RePebble.startAppRunnable$lambda$0(rePebble);
                break;
            default:
                RePebble.closeSenderRunnable$lambda$0(rePebble);
                break;
        }
    }
}
