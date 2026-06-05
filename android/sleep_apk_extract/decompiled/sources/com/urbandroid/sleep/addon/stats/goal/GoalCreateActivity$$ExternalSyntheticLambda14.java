package com.urbandroid.sleep.addon.stats.goal;

import android.content.DialogInterface;
import com.urbandroid.sleep.domain.goal.Goal;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GoalCreateActivity$$ExternalSyntheticLambda14 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Goal f$0;
    public final /* synthetic */ GoalCreateActivity f$1;

    public /* synthetic */ GoalCreateActivity$$ExternalSyntheticLambda14(GoalCreateActivity goalCreateActivity, Goal goal) {
        this.f$1 = goalCreateActivity;
        this.f$0 = goal;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        Goal goal = this.f$0;
        GoalCreateActivity goalCreateActivity = this.f$1;
        switch (i2) {
            case 0:
                GoalCreateActivity.showDurationIdealDialog$lambda$0(goal, goalCreateActivity, dialogInterface, i);
                break;
            default:
                goalCreateActivity.createNewGoal(goal);
                break;
        }
    }

    public /* synthetic */ GoalCreateActivity$$ExternalSyntheticLambda14(Goal goal, GoalCreateActivity goalCreateActivity) {
        this.f$0 = goal;
        this.f$1 = goalCreateActivity;
    }
}
