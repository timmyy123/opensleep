package com.urbandroid.sleep.alarmclock.settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class NoiseSettingsActivity$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ NoiseSettingsActivity f$0;

    public /* synthetic */ NoiseSettingsActivity$$ExternalSyntheticLambda9(NoiseSettingsActivity noiseSettingsActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = noiseSettingsActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        NoiseSettingsActivity noiseSettingsActivity = this.f$0;
        switch (i) {
            case 0:
                noiseSettingsActivity.lambda$refresh$3();
                break;
            default:
                noiseSettingsActivity.lambda$refresh$1();
                break;
        }
    }
}
