package com.urbandroid.sleep.alarmclock;

import android.content.DialogInterface;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmClock$$ExternalSyntheticLambda22 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Settings f$0;

    public /* synthetic */ AlarmClock$$ExternalSyntheticLambda22(Settings settings, int i) {
        this.$r8$classId = i;
        this.f$0 = settings;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        Settings settings = this.f$0;
        switch (i2) {
            case 0:
                settings.setRateLaterCancel();
                break;
            case 1:
                settings.setRateLater();
                break;
            default:
                AlarmClock.AnonymousClass34.lambda$onClick$1(settings, dialogInterface, i);
                break;
        }
    }
}
