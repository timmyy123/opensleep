package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmReceiver;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.DigitalClock;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.media.MediaListAdapter$$ExternalSyntheticLambda3;
import java.util.Calendar;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001 B!\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u000eJ\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b\b\u0010\u001b¨\u0006!"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/DismissNextAlarmCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DismissNextAlarmCard$SleepRecordViewHolder;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/alarmclock/Alarm;", "alarm", "", "isAlarmSnoozed", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/alarmclock/Alarm;Z)V", "viewHolder", "", "bindSleepRecordToView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/DismissNextAlarmCard$SleepRecordViewHolder;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/DismissNextAlarmCard$SleepRecordViewHolder;", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "(Landroid/view/View;)V", "bindView", "", "getNameResource", "()I", "isScreenReady", "()Z", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "getAlarm", "()Lcom/urbandroid/sleep/alarmclock/Alarm;", "Z", "SleepRecordViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DismissNextAlarmCard extends DashboardCard<SleepRecordViewHolder> {
    private final Alarm alarm;
    private final boolean isAlarmSnoozed;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u0005R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/DismissNextAlarmCard$SleepRecordViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "alarmButton", "Landroid/view/View;", "getAlarmButton", "()Landroid/view/View;", "setAlarmButton", "alarmCard", "getAlarmCard", "setAlarmCard", "Lcom/urbandroid/sleep/alarmclock/DigitalClock;", "digitalClock", "Lcom/urbandroid/sleep/alarmclock/DigitalClock;", "getDigitalClock", "()Lcom/urbandroid/sleep/alarmclock/DigitalClock;", "setDigitalClock", "(Lcom/urbandroid/sleep/alarmclock/DigitalClock;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SleepRecordViewHolder extends LayeredViewHolder {
        private View alarmButton;
        private View alarmCard;
        private DigitalClock digitalClock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SleepRecordViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.alarm);
            viewFindViewById.getClass();
            this.alarmButton = viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.foreground);
            viewFindViewById2.getClass();
            this.alarmCard = viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.digitalClock);
            viewFindViewById3.getClass();
            this.digitalClock = (DigitalClock) viewFindViewById3;
        }

        public final View getAlarmButton() {
            return this.alarmButton;
        }

        public final View getAlarmCard() {
            return this.alarmCard;
        }

        public final DigitalClock getDigitalClock() {
            return this.digitalClock;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DismissNextAlarmCard(Activity activity, Alarm alarm, boolean z) {
        super(activity, DashboardCard.Type.DISMISS_NEXT_ALARM, R.layout.card_dismiss_next_alarm);
        alarm.getClass();
        this.alarm = alarm;
        this.isAlarmSnoozed = z;
    }

    private final void bindSleepRecordToView(SleepRecordViewHolder viewHolder) {
        Logger.logInfo("DismissNextAlarmCard");
        long snoozeTime = this.isAlarmSnoozed ? Alarms.getSnoozeTime(getContext()) : this.alarm.time;
        viewHolder.getDigitalClock().setLive(false);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(snoozeTime);
        viewHolder.getDigitalClock().updateTime(calendar);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fly_in);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.scale_min);
        viewHolder.getAlarmCard().startAnimation(animationLoadAnimation);
        viewHolder.getAlarmButton().setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda3(this, viewHolder, animationLoadAnimation2, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindSleepRecordToView$lambda$0(DismissNextAlarmCard dismissNextAlarmCard, SleepRecordViewHolder sleepRecordViewHolder, Animation animation, View view) {
        Alarm alarm;
        Logger.logInfo("AlarmDismiss: called skipping next ");
        if (dismissNextAlarmCard.isAlarmSnoozed) {
            int snoozeAlarmId = Alarms.getSnoozeAlarmId(dismissNextAlarmCard.getContext());
            if (snoozeAlarmId != -1 && (alarm = Alarms.getAlarm(dismissNextAlarmCard.getContext().getContentResolver(), snoozeAlarmId)) != null) {
                Intent intent = new Intent(dismissNextAlarmCard.getContext(), (Class<?>) AlarmReceiver.class);
                intent.setAction("com.urbandroid.sleep.alarmclock.cancel_snooze");
                intent.putExtra("alarm_id", snoozeAlarmId);
                intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
                Activity context = dismissNextAlarmCard.getContext();
                context.getClass();
                ContextExtKt.sendExplicitBroadcast$default(context, intent, null, 2, null);
                sleepRecordViewHolder.getAlarmButton().startAnimation(animation);
                sleepRecordViewHolder.getAlarmButton().setVisibility(8);
            }
        } else {
            Alarms.skipAlarmOrShowCaptcha(dismissNextAlarmCard.getContext(), dismissNextAlarmCard.alarm);
        }
        sleepRecordViewHolder.getAlarmCard().startAnimation(animation);
        Activity context2 = dismissNextAlarmCard.getContext();
        View view2 = sleepRecordViewHolder.itemView;
        view2.getClass();
        dismissNextAlarmCard.setCardVisibility(context2, (ViewGroup) view2, false);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepRecordViewHolder viewHolder) {
        viewHolder.getClass();
        bindSleepRecordToView(viewHolder);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepRecordViewHolder createViewHolder(View v) {
        v.getClass();
        return new SleepRecordViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.next_alarm;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isScreenReady() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
    }
}
