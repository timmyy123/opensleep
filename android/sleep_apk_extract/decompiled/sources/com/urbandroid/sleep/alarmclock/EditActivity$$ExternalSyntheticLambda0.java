package com.urbandroid.sleep.alarmclock;

import android.view.View;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.NewAddRecordActivity;
import com.urbandroid.sleep.alarmclock.AlarmClock;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditActivity$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ EditActivity$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((EditActivity) obj).lambda$buildActivityFromIntent$0(view);
                break;
            case 1:
                ((AlarmClock.AnonymousClass54) obj).lambda$getView$1(view);
                break;
            case 2:
                ((AddonActivity) obj).lambda$onCreate$0(view);
                break;
            case 3:
                ViewIntent.url((CountriesActivity) obj, "https://sleep.urbandroid.org/sleepcloud-study/");
                break;
            default:
                NewAddRecordActivity.start((StatsActivity) obj);
                break;
        }
    }
}
