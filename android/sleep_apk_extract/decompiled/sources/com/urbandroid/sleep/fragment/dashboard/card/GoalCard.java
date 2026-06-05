package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.slider.Slider;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.StartTrackActivity$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.gui.NextAlarmPreference$$ExternalSyntheticLambda1;
import com.urbandroid.sleep.gui.view.ProgressRingView;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ColorUtil;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u0010\u000f\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u0000H\u0016J\u001e\u0010\u0011\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/GoalCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/GoalCard$GoalViewHolder;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "createViewHolder", "v", "Landroid/view/View;", "onCardClicked", "", ViewHierarchyConstants.VIEW_KEY, "getNameResource", "", "bindView", "viewHolder", "refresh", "goal", "Lcom/urbandroid/sleep/domain/goal/Goal;", "GoalViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoalCard extends DashboardCard<GoalViewHolder> {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001f\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001f\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u000e0\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0013\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001f\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\u00150\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001b\u001a\n \u0007*\u0004\u0018\u00010\u001a0\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\u001f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000bR\u001f\u0010!\u001a\n \u0007*\u0004\u0018\u00010\u001a0\u001a8\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e¨\u0006#"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/GoalCard$GoalViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Lcom/urbandroid/sleep/fragment/dashboard/card/GoalCard;Landroid/view/View;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "text", "getText", "Landroidx/cardview/widget/CardView;", "card", "Landroidx/cardview/widget/CardView;", "getCard", "()Landroidx/cardview/widget/CardView;", "goalValue", "getGoalValue", "Lcom/urbandroid/sleep/gui/view/ProgressRingView;", "goalProgress", "Lcom/urbandroid/sleep/gui/view/ProgressRingView;", "getGoalProgress", "()Lcom/urbandroid/sleep/gui/view/ProgressRingView;", "Lcom/google/android/material/slider/Slider;", "goalProgressBar", "Lcom/google/android/material/slider/Slider;", "getGoalProgressBar", "()Lcom/google/android/material/slider/Slider;", "goalDuration", "getGoalDuration", "goalDurationProgressBar", "getGoalDurationProgressBar", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class GoalViewHolder extends LayeredViewHolder {
        private final CardView card;
        private final TextView goalDuration;
        private final Slider goalDurationProgressBar;
        private final ProgressRingView goalProgress;
        private final Slider goalProgressBar;
        private final TextView goalValue;
        private final TextView text;
        final /* synthetic */ GoalCard this$0;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoalViewHolder(GoalCard goalCard, View view) {
            super(view);
            view.getClass();
            this.this$0 = goalCard;
            this.title = (TextView) view.findViewById(R.id.title);
            this.text = (TextView) view.findViewById(R.id.text);
            this.card = (CardView) view.findViewById(R.id.foreground);
            this.goalValue = (TextView) view.findViewById(R.id.goalValue);
            this.goalProgress = (ProgressRingView) view.findViewById(R.id.goalProgress);
            this.goalProgressBar = (Slider) view.findViewById(R.id.goal_progress_bar);
            this.goalDuration = (TextView) view.findViewById(R.id.goal_duration);
            this.goalDurationProgressBar = (Slider) view.findViewById(R.id.goal_duration_progress_bar);
        }

        public final TextView getGoalDuration() {
            return this.goalDuration;
        }

        public final Slider getGoalDurationProgressBar() {
            return this.goalDurationProgressBar;
        }

        public final ProgressRingView getGoalProgress() {
            return this.goalProgress;
        }

        public final Slider getGoalProgressBar() {
            return this.goalProgressBar;
        }

        public final TextView getGoalValue() {
            return this.goalValue;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoalCard(Activity activity) {
        super(activity, DashboardCard.Type.GOAL, R.layout.card_goal);
        activity.getClass();
    }

    private final void refresh(GoalViewHolder viewHolder, Goal goal) {
        String string;
        Goal.Type type;
        if (goal == null) {
            Activity context = getContext();
            View view = viewHolder.itemView;
            view.getClass();
            setCardVisibility(context, (ViewGroup) view, false);
            return;
        }
        Handler handler = new Handler();
        Activity context2 = getContext();
        View view2 = viewHolder.itemView;
        view2.getClass();
        setCardVisibility(context2, (ViewGroup) view2, true);
        TextView title = viewHolder.getTitle();
        Activity context3 = getContext();
        context3.getClass();
        title.setText(goal.getGoalTitle(context3));
        viewHolder.getGoalValue().setText(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(goal.getProgressInt(), 100), 0) + "%");
        viewHolder.getGoalValue().setTextColor(goal.getProgressInt() >= goal.getTimeProgressInt() ? ColorUtil.i(getContext(), R.color.primary) : ColorUtil.i(getContext(), R.color.negative_light));
        Logger.logInfo("Goal: PIE " + ((float) RangesKt___RangesKt.coerceAtMost(RangesKt___RangesKt.coerceAtLeast(goal.getProgress(), 0.0d), 1.0d)));
        int i = 3;
        handler.postDelayed(new StartTrackActivity$$ExternalSyntheticLambda0(viewHolder, goal, i), 100L);
        viewHolder.getGoalProgress().setProgressColor(goal.getProgressInt() >= goal.getTimeProgressInt() ? ColorUtil.i(getContext(), R.color.positive) : ColorUtil.i(getContext(), R.color.negative_light));
        TextView goalDuration = viewHolder.getGoalDuration();
        if (goal.nextTarget == -1.0d || (type = goal.type) == Goal.Type.IRREGULARITY || type == Goal.Type.FALL_ASLEEP_HOUR) {
            string = getContext().getResources().getString(R.string.days_left, Long.valueOf(Math.round((1.0d - goal.getProgressWholeDays(new Date())) * ((double) goal.getGoalDays()))));
        } else {
            Goal.Companion companion = Goal.INSTANCE;
            Activity context4 = getContext();
            context4.getClass();
            string = companion.getNextTargetString(context4, goal);
        }
        goalDuration.setText(string);
        viewHolder.getGoalDurationProgressBar().setValue(RangesKt___RangesKt.coerceAtMost(RangesKt.coerceAtLeast((float) goal.getTimeProgress(), 0.0f), 1.0f));
        viewHolder.getGoalProgressBar().setValue(RangesKt___RangesKt.coerceAtMost(RangesKt.coerceAtLeast((float) goal.getProgress(), 0.0f), 1.0f));
        viewHolder.getGoalDurationProgressBar().setOnTouchListener(new NextAlarmPreference$$ExternalSyntheticLambda1(2));
        viewHolder.getGoalProgressBar().setOnTouchListener(new NextAlarmPreference$$ExternalSyntheticLambda1(i));
        viewHolder.getGoalProgressBar().setCustomThumbDrawable(R.drawable.ic_goal_progress_thumb);
        viewHolder.getGoalDurationProgressBar().setCustomThumbDrawable(R.drawable.ic_goal_progress_duration_thumb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$0(GoalViewHolder goalViewHolder, Goal goal) {
        goalViewHolder.getGoalProgress().setProgress((float) RangesKt___RangesKt.coerceAtMost(RangesKt___RangesKt.coerceAtLeast(goal.getProgress(), 0.0d), 1.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$2(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(GoalViewHolder viewHolder) {
        viewHolder.getClass();
        Settings settings = new Settings(getContext());
        Goal currentGoal = settings.getCurrentGoal();
        if (currentGoal != null && currentGoal.updateStatus()) {
            settings.setCurrentGoal(currentGoal);
        }
        refresh(viewHolder, currentGoal);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public GoalViewHolder createViewHolder(View v) {
        v.getClass();
        return new GoalViewHolder(this, v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.goal;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        GoalDetailActivity.Companion companion = GoalDetailActivity.INSTANCE;
        Activity context = getContext();
        context.getClass();
        GoalDetailActivity.Companion.start$default(companion, context, null, 2, null);
    }
}
