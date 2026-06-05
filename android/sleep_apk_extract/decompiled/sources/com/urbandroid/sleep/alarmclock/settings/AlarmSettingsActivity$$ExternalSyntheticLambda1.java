package com.urbandroid.sleep.alarmclock.settings;

import android.content.DialogInterface;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmSettingsActivity$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Settings f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ AlarmSettingsActivity$$ExternalSyntheticLambda1(Settings settings, String str, int i) {
        this.$r8$classId = i;
        this.f$0 = settings;
        this.f$1 = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        String str = this.f$1;
        Settings settings = this.f$0;
        switch (i2) {
            case 0:
                settings.addShowCaseShown(str);
                break;
            default:
                AlarmSettingsActivity.lambda$askOverlay$12(settings, str, dialogInterface, i);
                break;
        }
    }
}
