package com.urbandroid.sleep.fragment;

import android.view.View;
import com.urbandroid.sleep.fragment.StatsFragmentNew;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AlarmFragment$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((AlarmFragment) obj).lambda$updateLayout$4(view);
                break;
            case 1:
                StatsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1.invokeSuspend$lambda$0((StatsFragmentNew.CountryAdapter.Holder.CountryStats) obj, view);
                break;
            default:
                StatsFragmentNew$ScoreAdapter$Holder$bind$1.invokeSuspend$lambda$7$0((StatsFragmentNew) obj, view);
                break;
        }
    }
}
