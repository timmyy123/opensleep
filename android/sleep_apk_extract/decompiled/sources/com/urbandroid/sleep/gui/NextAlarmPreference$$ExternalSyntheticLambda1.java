package com.urbandroid.sleep.gui;

import android.view.MotionEvent;
import android.view.View;
import com.urbandroid.sleep.achievement.AchievementItem;
import com.urbandroid.sleep.fragment.dashboard.card.GoalCard;
import com.urbandroid.sleep.media.lullaby.LullabyActivity;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class NextAlarmPreference$$ExternalSyntheticLambda1 implements View.OnTouchListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ NextAlarmPreference$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.$r8$classId) {
            case 0:
                return NextAlarmPreference.onCreateView$lambda$0(view, motionEvent);
            case 1:
                return AchievementItem.bindView$lambda$0(view, motionEvent);
            case 2:
                return GoalCard.refresh$lambda$1(view, motionEvent);
            case 3:
                return GoalCard.refresh$lambda$2(view, motionEvent);
            default:
                return LullabyActivity.updatePlaying$lambda$0(view, motionEvent);
        }
    }
}
