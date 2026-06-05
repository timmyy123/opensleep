package com.urbandroid.sleep.alarmclock;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SetAlarm$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SetAlarm f$0;

    public /* synthetic */ SetAlarm$$ExternalSyntheticLambda0(SetAlarm setAlarm, int i) {
        this.$r8$classId = i;
        this.f$0 = setAlarm;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        SetAlarm setAlarm = this.f$0;
        switch (i) {
            case 0:
                setAlarm.lambda$onPreferenceChange$21();
                break;
            default:
                setAlarm.lambda$refreshRepeating$0();
                break;
        }
    }
}
