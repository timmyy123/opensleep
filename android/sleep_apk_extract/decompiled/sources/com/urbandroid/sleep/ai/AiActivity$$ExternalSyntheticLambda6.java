package com.urbandroid.sleep.ai;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.urbandroid.sleep.achievement.AchievementShowcaseItem;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.advice.AdviceAdapter;
import com.urbandroid.sleep.addon.stats.chart.IChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.group.ChartBuilderGroup;
import com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity;
import com.urbandroid.sleep.addon.stats.model.Advice;
import com.urbandroid.sleep.alarmclock.settings.CaptchaSettingsActivity;
import com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker;
import com.urbandroid.sleep.alarmclock.timepicker.TimePickerActivity;
import com.urbandroid.sleep.captcha.DreamDiaryCaptcha;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.domain.addon.AddonApp;
import com.urbandroid.sleep.domain.shortcut.Shortcut;
import com.urbandroid.sleep.fragment.addon.AddOnBinder;
import com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard;
import com.urbandroid.sleep.fragment.dashboard.card.ShortcutCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailCommentCard;
import com.urbandroid.sleep.fragment.dashboard.card.WeatherCard;
import com.urbandroid.sleep.fragment.dashboard.morning.MorningFragment;
import com.urbandroid.sleep.gui.NextAlarmPreference;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.lullaby.LullabySpotifyItem;
import com.urbandroid.sleep.smartlight.DiscoveryActivity;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AiActivity$$ExternalSyntheticLambda6 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AiActivity$$ExternalSyntheticLambda6(Object obj, Object obj2, int i) {
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
                AiActivity.onCreate$lambda$5((EditText) obj2, (AiActivity) obj, view);
                break;
            case 1:
                ((Snackbar) obj2).lambda$setAction$0((View.OnClickListener) obj, view);
                break;
            case 2:
                ((MaterialTimePicker) obj2).lambda$onCreateView$0((ViewGroup) obj, view);
                break;
            case 3:
                AchievementShowcaseItem.bindView$lambda$0$0((AchievementShowcaseItem) obj2, (Achievement) obj, view);
                break;
            case 4:
                AdviceAdapter.lambda$mapAdviceToView$0((TextView) obj2, (ViewGroup) obj, view);
                break;
            case 5:
                AdviceAdapter.lambda$mapAdviceToView$1((Context) obj2, (Advice) obj, view);
                break;
            case 6:
                ((ChartBuilderGroup) obj2).lambda$buildChart$0((IChartBuilder) obj, view);
                break;
            case 7:
                GoalCreateActivity.onCreate$lambda$1((GoalCreateActivity) obj2, (TabLayout.Tab) obj, view);
                break;
            case 8:
                ((CaptchaSettingsActivity) obj2).lambda$refresh$0((PreferenceActivity) obj, view);
                break;
            case 9:
                com.urbandroid.sleep.alarmclock.timepicker.MaterialTimePicker.show$lambda$6$0((com.urbandroid.sleep.alarmclock.timepicker.MaterialTimePicker) obj2, (MaterialTimePicker) obj, view);
                break;
            case 10:
                RoundTimePicker.createTimePickerDialog$lambda$6((TimePickerActivity) obj2, (RoundTimePicker) obj, view);
                break;
            case 11:
                ((DreamDiaryCaptcha) obj2).lambda$onCreate$0((AtomicBoolean) obj, view);
                break;
            case 12:
                AddOnBinder.bind$lambda$1((AddonApp) obj2, (Context) obj, view);
                break;
            case 13:
                ((NextAlarmCard) obj2).lambda$bindView$0((Context) obj, view);
                break;
            case 14:
                ShortcutCard.bindView$lambda$1$0((Shortcut) obj2, (ShortcutCard) obj, view);
                break;
            case 15:
                SleepDetailCommentCard.bindSleepRecordToView$lambda$1$2((SleepDetailCommentCard) obj2, (SleepDetailCommentCard.SleepRecordViewHolder) obj, view);
                break;
            case 16:
                SleepDetailCommentCard.bindSleepRecordToView$lambda$1$3((SleepDetailCommentCard) obj2, (SleepRecord) obj, view);
                break;
            case 17:
                WeatherCard.loadWeather$lambda$0((Activity) obj2, (WeatherCard) obj, view);
                break;
            case 18:
                MorningFragment.initFab$lambda$0$0$0((MorningFragment) obj2, (FragmentActivity) obj, view);
                break;
            case 19:
                NextAlarmPreference.openTimepicker$lambda$1((NextAlarmPreference) obj2, (MaterialTimePicker) obj, view);
                break;
            case 20:
                SleepStats.startFirstHandleTrial((Context) obj2, (String) obj);
                break;
            case 21:
                MediaListActivity.lambda$createAddRadioDialog$3((EditText) obj2, (Context) obj, view);
                break;
            case 22:
                LullabySpotifyItem.bindView$lambda$0((LullabySpotifyItem) obj2, (Handler) obj, view);
                break;
            default:
                DiscoveryActivity.inputSecurityCode$lambda$2((AlertDialog) obj2, (DiscoveryActivity) obj, view);
                break;
        }
    }
}
