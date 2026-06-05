package com.urbandroid.sleep.addon.stats.goal;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GoalDetailActivity$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ GoalDetailActivity$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                GoalDetailActivity.onCreate$lambda$1(dialogInterface, i);
                break;
            default:
                GoalCreateActivity.onCreate$lambda$1$0(dialogInterface, i);
                break;
        }
    }
}
