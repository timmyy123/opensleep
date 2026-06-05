package com.urbandroid.sleep.alarmclock;

import com.google.android.material.button.MaterialButton;
import com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmActivity$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AlarmActivity$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                AlarmActivity.onPostResume$lambda$1((MaterialButton) obj);
                break;
            case 1:
                ((AlarmAlertFullScreen.AnonymousClass7) obj).lambda$onClick$0();
                break;
            case 2:
                ((RatingActivity) obj).lambda$new$9();
                break;
            default:
                RepeatChipPreference.preferenceChangeRunnable$lambda$0((RepeatChipPreference) obj);
                break;
        }
    }
}
