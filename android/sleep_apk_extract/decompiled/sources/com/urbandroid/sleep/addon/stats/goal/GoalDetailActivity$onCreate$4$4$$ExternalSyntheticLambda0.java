package com.urbandroid.sleep.addon.stats.goal;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.chart.ChartLoader;
import com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity;
import com.urbandroid.sleep.domain.goal.Goal;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GoalDetailActivity$onCreate$4$4$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ Goal f$1;
    public final /* synthetic */ List f$2;

    public /* synthetic */ GoalDetailActivity$onCreate$4$4$$ExternalSyntheticLambda0(Context context, Goal goal, List list, int i) {
        this.$r8$classId = i;
        this.f$0 = context;
        this.f$1 = goal;
        this.f$2 = list;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        ChartLoader chartLoader = (ChartLoader) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (i) {
            case 0:
                return GoalDetailActivity.AnonymousClass4.C00264.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2, chartLoader, iIntValue);
            default:
                return GoalDetailActivity.AnonymousClass4.AnonymousClass5.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2, chartLoader, iIntValue);
        }
    }
}
