package com.urbandroid.sleep.alarmclock;

import androidx.view.result.ActivityResultCallback;
import com.urbandroid.sleep.gui.AlarmTimePreference;
import com.urbandroid.sleep.gui.IOnBindListener;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SetAlarm$$ExternalSyntheticLambda2 implements AlarmTimePreference.OnAlarmSwitch, IOnBindListener, ActivityResultCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SetAlarm f$0;

    public /* synthetic */ SetAlarm$$ExternalSyntheticLambda2(SetAlarm setAlarm, int i) {
        this.$r8$classId = i;
        this.f$0 = setAlarm;
    }

    @Override // androidx.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        this.f$0.lambda$new$19((Boolean) obj);
    }

    @Override // com.urbandroid.sleep.gui.IOnBindListener
    public void onBind() {
        int i = this.$r8$classId;
        SetAlarm setAlarm = this.f$0;
        switch (i) {
            case 2:
                setAlarm.lambda$onCreatePreference$7();
                break;
            default:
                setAlarm.lambda$onCreatePreference$10();
                break;
        }
    }
}
