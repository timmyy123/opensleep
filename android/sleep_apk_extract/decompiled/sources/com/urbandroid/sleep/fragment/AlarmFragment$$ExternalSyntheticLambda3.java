package com.urbandroid.sleep.fragment;

import android.content.Context;
import android.view.View;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.fragment.StatsFragmentNew;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmFragment$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AlarmFragment$$ExternalSyntheticLambda3(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                AlarmFragment.lambda$mapAlarmToView$0((Context) obj2, (AlarmFragment) obj, view);
                break;
            case 1:
                StatsFragmentNew$DayAdapter$Holder$bind$1.invokeSuspend$lambda$1((StatsFragmentNew.DayAdapter.Holder) obj2, (List) obj, view);
                break;
            default:
                AlarmFragment.lambda$mapAlarmToView$1((Context) obj2, (Alarm) obj, view);
                break;
        }
    }
}
