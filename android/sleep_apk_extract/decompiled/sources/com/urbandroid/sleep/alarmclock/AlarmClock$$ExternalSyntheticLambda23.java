package com.urbandroid.sleep.alarmclock;

import android.content.DialogInterface;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmClock$$ExternalSyntheticLambda23 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Settings f$0;

    public /* synthetic */ AlarmClock$$ExternalSyntheticLambda23(Settings settings, int i) {
        this.$r8$classId = i;
        this.f$0 = settings;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        int i = this.$r8$classId;
        Settings settings = this.f$0;
        switch (i) {
            case 0:
                settings.setRateLaterCancel();
                break;
            default:
                settings.setRateLater();
                break;
        }
    }
}
