package com.urbandroid.sleep.alarmclock.settings;

import android.app.Activity;
import android.content.DialogInterface;
import com.urbandroid.sleep.gui.dialog.BackupItemDialogFragment;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TrackSettingsActivity$$ExternalSyntheticLambda8 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Activity f$0;

    public /* synthetic */ TrackSettingsActivity$$ExternalSyntheticLambda8(Activity activity, int i) {
        this.$r8$classId = i;
        this.f$0 = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        Activity activity = this.f$0;
        switch (i2) {
            case 0:
                TrackSettingsActivity.lambda$initiateSonarSensorTest$7(activity, dialogInterface, i);
                break;
            case 1:
                AlarmSettingsActivity.lambda$askOverlay$10(activity, dialogInterface, i);
                break;
            case 2:
                BackupItemDialogFragment.AnonymousClass3.onClick$lambda$1$0(activity, dialogInterface, i);
                break;
            default:
                BackupItemDialogFragment.AnonymousClass3.onClick$lambda$1$1(activity, dialogInterface, i);
                break;
        }
    }
}
