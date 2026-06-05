package com.urbandroid.sleep.achievement;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getpebble.android.kit.Constants;
import com.google.android.material.slider.Slider;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.achievement.AbstractAchievementItem;
import com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.StatsActivity;
import com.urbandroid.sleep.alarmclock.settings.AlarmSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.CaptchaSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SmartSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.gui.NextAlarmPreference$$ExternalSyntheticLambda1;
import com.urbandroid.sleep.media.lullaby.LullabyActivity;
import com.urbandroid.util.ColorUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/achievement/AchievementItem;", "Lcom/urbandroid/sleep/achievement/AbstractAchievementItem;", "Lcom/urbandroid/sleep/achievement/AchievementItem$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/achievement/Achievement;", "achievement", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/domain/achievement/Achievement;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/achievement/AchievementItem$ViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/achievement/AchievementItem$ViewHolder;)V", "onItemClicked", "()V", "Lcom/urbandroid/sleep/domain/achievement/Achievement;", "getAchievement", "()Lcom/urbandroid/sleep/domain/achievement/Achievement;", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AchievementItem extends AbstractAchievementItem<ViewHolder> {
    private final Achievement achievement;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\fR\"\u0010!\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u0006$"}, d2 = {"Lcom/urbandroid/sleep/achievement/AchievementItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "summary", "getSummary", "setSummary", "Landroid/widget/ImageView;", Constants.CUST_ICON, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "Lcom/google/android/material/slider/Slider;", "progress", "Lcom/google/android/material/slider/Slider;", "getProgress", "()Lcom/google/android/material/slider/Slider;", "setProgress", "(Lcom/google/android/material/slider/Slider;)V", "progressText", "getProgressText", "setProgressText", "level", "getLevel", "setLevel", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private ImageView icon;
        private ImageView level;
        private Slider progress;
        private TextView progressText;
        private TextView summary;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.title);
            viewFindViewById.getClass();
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.summary);
            viewFindViewById2.getClass();
            this.summary = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.icon);
            viewFindViewById3.getClass();
            this.icon = (ImageView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(com.urbandroid.sleep.R.id.progressText);
            viewFindViewById4.getClass();
            this.progressText = (TextView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(com.urbandroid.sleep.R.id.progress);
            viewFindViewById5.getClass();
            this.progress = (Slider) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(com.urbandroid.sleep.R.id.level);
            viewFindViewById6.getClass();
            this.level = (ImageView) viewFindViewById6;
        }

        public final ImageView getIcon() {
            return this.icon;
        }

        public final ImageView getLevel() {
            return this.level;
        }

        public final Slider getProgress() {
            return this.progress;
        }

        public final TextView getProgressText() {
            return this.progressText;
        }

        public final TextView getSummary() {
            return this.summary;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Achievement.Type.values().length];
            try {
                iArr[Achievement.Type.TRACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Achievement.Type.WEARABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Achievement.Type.SONAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Achievement.Type.SMARTLIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Achievement.Type.CLOUD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Achievement.Type.SCORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Achievement.Type.LULLABY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Achievement.Type.SOUND_RECOGNITION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Achievement.Type.SMART_WAKE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Achievement.Type.GOAL_DURATION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[Achievement.Type.PREMIUM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[Achievement.Type.GOAL_BEDTIME.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[Achievement.Type.GOAL_REGULARITY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[Achievement.Type.GOAL_AWAKE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[Achievement.Type.GOAL_DEEP.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[Achievement.Type.GOAL_SNOOZE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[Achievement.Type.GOAL_SNORING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[Achievement.Type.WAKE_UP_CHECK.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[Achievement.Type.CAPTCHA_CODE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[Achievement.Type.CAPTCHA_MATH.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[Achievement.Type.CAPTCHA_SHEEP.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[Achievement.Type.CAPTCHA_SMILE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[Achievement.Type.CAPTCHA_ZOMBIE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AchievementItem(Context context, Achievement achievement) {
        super(context, com.urbandroid.sleep.R.layout.row_achievement, AbstractAchievementItem.Type.ACHIEVEMENT);
        context.getClass();
        achievement.getClass();
        this.achievement = achievement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindView$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // com.urbandroid.sleep.achievement.AbstractAchievementItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        viewHolder.getTitle().setText(this.achievement.getType().getTitle(getContext()));
        viewHolder.getSummary().setText(this.achievement.getType().getSummary(getContext()));
        viewHolder.getProgressText().setText(this.achievement.getProgressString());
        viewHolder.getProgressText().setVisibility(0);
        viewHolder.getProgress().setOnTouchListener(new NextAlarmPreference$$ExternalSyntheticLambda1(1));
        int i = ColorUtil.i(getContext(), this.achievement.getColorRes());
        viewHolder.getProgressText().setTextColor(i);
        viewHolder.getProgress().setTrackActiveTintList(ColorStateList.valueOf(i));
        viewHolder.getProgress().setValue(this.achievement.getProgress());
        viewHolder.getProgress().setCustomThumbDrawable(this.achievement.getNextLevelIcon());
        viewHolder.getIcon().setImageResource(this.achievement.getType().getIconRes());
        viewHolder.getLevel().setImageResource(this.achievement.getEarnedLevelIcon());
        viewHolder.getLevel().setVisibility(0);
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.getSummary().setVisibility(0);
        if (this.achievement.earned()) {
            return;
        }
        viewHolder.itemView.setAlpha(0.7f);
        viewHolder.getLevel().setVisibility(8);
    }

    @Override // com.urbandroid.sleep.achievement.AbstractAchievementItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }

    @Override // com.urbandroid.sleep.achievement.AbstractAchievementItem
    public void onItemClicked() {
        if (getContext() instanceof Activity) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.achievement.getType().ordinal()]) {
                case 1:
                    Activity activity = (Activity) getContext();
                    Intent intent = new Intent(getContext(), (Class<?>) AlarmClock.class);
                    intent.putExtra("track_onboarding", true);
                    activity.startActivity(intent);
                    break;
                case 2:
                    SimpleSettingsActivity.startHighlight(getContext(), TrackSettingsActivity.class, "smartwatch");
                    break;
                case 3:
                    SimpleSettingsActivity.startHighlight(getContext(), TrackSettingsActivity.class, "settings_category_sensor");
                    break;
                case 4:
                    ((Activity) getContext()).startActivity(new Intent(getContext(), (Class<?>) SmartLightSettingsActivity.class));
                    break;
                case 5:
                    ((Activity) getContext()).startActivity(new Intent(getContext(), (Class<?>) ServicesSettingsActivity.class));
                    break;
                case 6:
                    ((Activity) getContext()).startActivity(new Intent(getContext(), (Class<?>) StatsActivity.class));
                    break;
                case 7:
                    ((Activity) getContext()).startActivity(new Intent(getContext(), (Class<?>) LullabyActivity.class));
                    break;
                case 8:
                    ((Activity) getContext()).startActivity(new Intent(getContext(), (Class<?>) NoiseSettingsActivity.class));
                    break;
                case 9:
                    ((Activity) getContext()).startActivity(new Intent(getContext(), (Class<?>) SmartSettingsActivity.class));
                    break;
                case 10:
                    GoalDetailActivity.INSTANCE.start(getContext(), Goal.Type.DURATION);
                    break;
                case 11:
                    Intent intent2 = new Intent(getContext(), (Class<?>) AlarmClock.class);
                    intent2.putExtra("com.urbandroid.sleep.START_UNLOCK_CLOUD_PURCHASE", true);
                    ((Activity) getContext()).startActivity(intent2);
                    break;
                case 12:
                    GoalDetailActivity.INSTANCE.start(getContext(), Goal.Type.FALL_ASLEEP_HOUR);
                    break;
                case 13:
                    GoalDetailActivity.INSTANCE.start(getContext(), Goal.Type.REGULARITY);
                    break;
                case 14:
                    GoalDetailActivity.INSTANCE.start(getContext(), Goal.Type.AWAKE);
                    break;
                case 15:
                    GoalDetailActivity.INSTANCE.start(getContext(), Goal.Type.DEEP_SLEEP);
                    break;
                case 16:
                    GoalDetailActivity.INSTANCE.start(getContext(), Goal.Type.SNOOZE);
                    break;
                case 17:
                    GoalDetailActivity.INSTANCE.start(getContext(), Goal.Type.SNORING);
                    break;
                case 18:
                    SimpleSettingsActivity.startHighlight(getContext(), CaptchaSettingsActivity.class, "settings_category_wake_up_check");
                    break;
                case 19:
                case 20:
                case 21:
                case 22:
                    SimpleSettingsActivity.startHighlight(getContext(), AlarmSettingsActivity.class, "settings_category_captcha");
                    break;
                case 23:
                    if (TrialFilter.getInstance().isAddonCaptchaPack()) {
                        SimpleSettingsActivity.startHighlight(getContext(), AlarmSettingsActivity.class, "settings_category_captcha");
                    } else {
                        try {
                            ViewIntent.market(getContext(), "com.urbandroid.sleep.captchapack");
                        } catch (Exception e) {
                            Logger.logSevere(e);
                            Toast.makeText(getContext(), com.urbandroid.sleep.R.string.general_unspecified_error, 0).show();
                            return;
                        }
                    }
                    break;
                default:
                    ((Activity) getContext()).finish();
                    break;
            }
        }
    }
}
