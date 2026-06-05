package com.urbandroid.sleep.addon.stats.goal;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GoalCreateActivity$$ExternalSyntheticLambda10 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ GoalCreateActivity f$0;

    public /* synthetic */ GoalCreateActivity$$ExternalSyntheticLambda10(GoalCreateActivity goalCreateActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = goalCreateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        GoalCreateActivity goalCreateActivity = this.f$0;
        switch (i2) {
            case 0:
                GoalCreateActivity.onCreateDialog$lambda$0(goalCreateActivity, dialogInterface, i);
                break;
            case 1:
                GoalCreateActivity.onCreateDialog$lambda$1(goalCreateActivity, dialogInterface, i);
                break;
            case 2:
                GoalCreateActivity.onCreate$lambda$9$0(goalCreateActivity, dialogInterface, i);
                break;
            default:
                GoalCreateActivity.onCreate$lambda$9$1(goalCreateActivity, dialogInterface, i);
                break;
        }
    }
}
