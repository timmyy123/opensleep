package com.urbandroid.sleep;

import android.preference.CheckBoxPreference;
import com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.fragment.dashboard.card.GoalCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailCommentCard;
import com.urbandroid.sleep.fragment.dashboard.card.TutorialCard;
import com.urbandroid.sleep.nearby.core.Endpoint;
import com.urbandroid.sleep.nearby.core.ReliableMessageQueue;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.android.HandlerContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class StartTrackActivity$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ StartTrackActivity$$ExternalSyntheticLambda0(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                StartTrackActivity.onCreate$lambda$1((SleepLockManager) obj2, (StartTrackActivity) obj);
                break;
            case 1:
                ServicesSettingsActivity.refresh$lambda$9$0$0((ServicesSettingsActivity) obj2, (CheckBoxPreference) obj);
                break;
            case 2:
                ((SimpleSettingsActivity) obj2).lambda$onCreatePreference$1((String) obj);
                break;
            case 3:
                GoalCard.refresh$lambda$0((GoalCard.GoalViewHolder) obj2, (Goal) obj);
                break;
            case 4:
                SleepDetailCommentCard.bindSleepRecordToView$lambda$0((SleepDetailCommentCard) obj2, (SleepDetailCommentCard.SleepRecordViewHolder) obj);
                break;
            case 5:
                TutorialCard.bindView$lambda$1((TutorialCard) obj2, (TutorialCard.TutorialViewHolder) obj);
                break;
            case 6:
                Endpoint.requestConnectionAfterDelay$lambda$0((Endpoint) obj2, (String) obj);
                break;
            case 7:
                Endpoint.send$lambda$0((Endpoint) obj2, (byte[]) obj);
                break;
            case 8:
                ReliableMessageQueue.sendReliable$lambda$0((ReliableMessageQueue) obj2, (JSONObject) obj);
                break;
            default:
                HandlerContext.scheduleResumeAfterDelay$lambda$0((CancellableContinuation) obj2, (HandlerContext) obj);
                break;
        }
    }
}
