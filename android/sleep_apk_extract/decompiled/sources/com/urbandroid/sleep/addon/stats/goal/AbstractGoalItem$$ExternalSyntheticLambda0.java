package com.urbandroid.sleep.addon.stats.goal;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AbstractGoalItem$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AbstractGoalItem$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((AbstractGoalItem) obj).onItemClicked();
                break;
            case 1:
                GoalDetailActivity.access$doNextGoal((GoalDetailActivity) obj);
                break;
            default:
                ((GoalDetailActivity) obj).showGiveUpDialog();
                break;
        }
    }
}
