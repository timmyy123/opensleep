package com.urbandroid.sleep.addon.stats;

import android.app.Activity;
import com.urbandroid.sleep.addon.stats.ChartFragment;
import com.urbandroid.sleep.addon.stats.chart.group.ChartBuilderGroup;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ChartFragment$1$$ExternalSyntheticLambda0 implements ChartBuilderGroup.SelectedListener {
    public final /* synthetic */ ChartFragment.AnonymousClass1 f$0;
    public final /* synthetic */ Activity f$1;

    public /* synthetic */ ChartFragment$1$$ExternalSyntheticLambda0(ChartFragment.AnonymousClass1 anonymousClass1, Activity activity) {
        this.f$0 = anonymousClass1;
        this.f$1 = activity;
    }

    public final void selected(int i) {
        this.f$0.lambda$createViews$0(this.f$1, i);
    }
}
