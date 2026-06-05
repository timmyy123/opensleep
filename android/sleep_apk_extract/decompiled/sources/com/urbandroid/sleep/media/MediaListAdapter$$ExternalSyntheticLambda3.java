package com.urbandroid.sleep.media;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.CompoundButton;
import com.google.android.material.button.MaterialButton;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen;
import com.urbandroid.sleep.alarmclock.RepeatChipPreference;
import com.urbandroid.sleep.fragment.AlarmFragment;
import com.urbandroid.sleep.fragment.dashboard.card.DismissNextAlarmCard;
import com.urbandroid.sleep.fragment.preview.PremiumPreviewPage;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MediaListAdapter$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ MediaListAdapter$$ExternalSyntheticLambda3(AlarmAlertFullScreen alarmAlertFullScreen, String str, ViewGroup viewGroup) {
        this.$r8$classId = 1;
        this.f$0 = alarmAlertFullScreen;
        this.f$2 = str;
        this.f$1 = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$2;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (i) {
            case 0:
                ((MediaListAdapter) obj3).lambda$updateSelectedSong$4((ViewGroup) obj2, (View) obj, view);
                break;
            case 1:
                ((AlarmAlertFullScreen) obj3).lambda$refreshSnoozeOptions$0((String) obj, (ViewGroup) obj2, view);
                break;
            case 2:
                RepeatChipPreference.updateUIControls$lambda$0((MaterialButton) obj3, (RepeatChipPreference) obj2, (Alarm.DaysOfWeek) obj, view);
                break;
            case 3:
                ((AlarmFragment.AlarmTimeAdapter) obj3).lambda$bindView$0((CompoundButton) obj2, (Alarm) obj, view);
                break;
            case 4:
                DismissNextAlarmCard.bindSleepRecordToView$lambda$0((DismissNextAlarmCard) obj3, (DismissNextAlarmCard.SleepRecordViewHolder) obj2, (Animation) obj, view);
                break;
            default:
                PremiumPreviewPage.adjustLayout$lambda$2((Activity) obj3, (ViewGroup) obj2, (Ref$ObjectRef) obj, view);
                break;
        }
    }

    public /* synthetic */ MediaListAdapter$$ExternalSyntheticLambda3(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
