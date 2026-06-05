package com.urbandroid.sleep.alarmclock;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RepeatChipPreference$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ RepeatChipPreference f$0;

    public /* synthetic */ RepeatChipPreference$$ExternalSyntheticLambda1(RepeatChipPreference repeatChipPreference, int i) {
        this.$r8$classId = i;
        this.f$0 = repeatChipPreference;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        RepeatChipPreference repeatChipPreference = this.f$0;
        switch (i) {
            case 0:
                RepeatChipPreference.initModeSelectChip$lambda$0(repeatChipPreference, view);
                break;
            default:
                RepeatChipPreference.initDayOfWeekChips$lambda$0$0(repeatChipPreference, view);
                break;
        }
    }
}
