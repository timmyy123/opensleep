package com.urbandroid.sleep.fragment.dashboard;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.Toast;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.fragment.app.FragmentActivity;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.releasenotes.ReleaseNotes;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionPermission;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.goal.GoalSelectActivity;
import com.urbandroid.sleep.ads.IAdsController;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmActivity;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.settings.AlarmSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.BedtimeSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.CaptchaSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.GentleSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SmartSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SmartwatchSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.TrackAutoSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.addon.AddonApp;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.fragment.dashboard.card.AchievementCard;
import com.urbandroid.sleep.fragment.dashboard.card.AddOnCard;
import com.urbandroid.sleep.fragment.dashboard.card.AdviceCard;
import com.urbandroid.sleep.fragment.dashboard.card.AiCard;
import com.urbandroid.sleep.fragment.dashboard.card.BackupCard;
import com.urbandroid.sleep.fragment.dashboard.card.BedtimeCard;
import com.urbandroid.sleep.fragment.dashboard.card.ChartCard;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.fragment.dashboard.card.GoalCard;
import com.urbandroid.sleep.fragment.dashboard.card.InterestingNoiseCard;
import com.urbandroid.sleep.fragment.dashboard.card.LastCard;
import com.urbandroid.sleep.fragment.dashboard.card.LastSleepRecordsCard;
import com.urbandroid.sleep.fragment.dashboard.card.NativeAdCard;
import com.urbandroid.sleep.fragment.dashboard.card.NewsCard;
import com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard;
import com.urbandroid.sleep.fragment.dashboard.card.NoAutoTrackCard;
import com.urbandroid.sleep.fragment.dashboard.card.NoNoiseCard;
import com.urbandroid.sleep.fragment.dashboard.card.NoiseRecordCard;
import com.urbandroid.sleep.fragment.dashboard.card.PromoCard;
import com.urbandroid.sleep.fragment.dashboard.card.ReleaseNotesCard;
import com.urbandroid.sleep.fragment.dashboard.card.ScoreCard;
import com.urbandroid.sleep.fragment.dashboard.card.ShortcutCard;
import com.urbandroid.sleep.fragment.dashboard.card.ShowCaseCard;
import com.urbandroid.sleep.fragment.dashboard.card.TutorialCard;
import com.urbandroid.sleep.fragment.dashboard.card.TutorialItem;
import com.urbandroid.sleep.fragment.dashboard.card.UnlockCard;
import com.urbandroid.sleep.gui.dialog.DocItemDialogFragment;
import com.urbandroid.sleep.media.lullaby.LullabyActivity;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.service.PrefStore;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.util.Experiments;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\r2\u0006\u0010\b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\f2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0006\u0010\b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*8\u0006¢\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010'R(\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010%\u001a\u0004\b/\u0010'\"\u0004\b0\u0010)R$\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R,\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010%\u001a\u0004\b8\u0010'\"\u0004\b9\u0010)R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/DashboardCardBuilder;", "Lcom/urbandroid/common/FeatureLogger;", "Lcom/urbandroid/sleep/fragment/dashboard/CardBuilder;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "loadData", "(Landroid/content/Context;)V", "Landroid/app/Activity;", "", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "buildCards", "(Landroid/app/Activity;)Ljava/util/List;", "card", "", "findPosition", "(Landroid/app/Activity;Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;)Ljava/lang/Integer;", "Lcom/urbandroid/sleep/fragment/dashboard/card/TutorialItem;", "initTutorial", "Lkotlinx/coroutines/CoroutineScope;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/domain/SleepRecord;", "lastSleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getLastSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "setLastSleepRecord", "(Lcom/urbandroid/sleep/domain/SleepRecord;)V", "lastSleepRecords", "Ljava/util/List;", "getLastSleepRecords", "()Ljava/util/List;", "setLastSleepRecords", "(Ljava/util/List;)V", "", "Lcom/urbandroid/sleep/domain/Noise;", "noises", "getNoises", "interestingNoises", "getInterestingNoises", "setInterestingNoises", "lastNoise", "Lcom/urbandroid/sleep/domain/Noise;", "getLastNoise", "()Lcom/urbandroid/sleep/domain/Noise;", "setLastNoise", "(Lcom/urbandroid/sleep/domain/Noise;)V", "cachedCards", "getCachedCards", "setCachedCards", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "nextAlarm", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "getNextAlarm", "()Lcom/urbandroid/sleep/alarmclock/Alarm;", "setNextAlarm", "(Lcom/urbandroid/sleep/alarmclock/Alarm;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DashboardCardBuilder implements FeatureLogger, CardBuilder {
    private List<DashboardCard<?>> cachedCards;
    private final CoroutineScope coroutineScope;
    private List<Noise> interestingNoises;
    private Noise lastNoise;
    private SleepRecord lastSleepRecord;
    private List<? extends SleepRecord> lastSleepRecords;
    private Alarm nextAlarm;
    private final List<Noise> noises;
    private final String tag;

    public DashboardCardBuilder(CoroutineScope coroutineScope) {
        coroutineScope.getClass();
        this.coroutineScope = coroutineScope;
        this.tag = "card-builder";
        this.lastSleepRecords = CollectionsKt.emptyList();
        this.noises = new ArrayList();
        this.interestingNoises = new ArrayList();
        this.cachedCards = new ArrayList();
    }

    private final List<TutorialItem> initTutorial(Activity context) {
        int i;
        Object obj;
        TutorialItem.Companion companion;
        Activity activity;
        Settings settings = new Settings(context);
        PrefStore prefStore = new PrefStore(context, "onboarding_prefs");
        ArrayList arrayList = new ArrayList();
        boolean zIsOurExperimentalPhone = Experiments.getInstance().isOurExperimentalPhone();
        TutorialItem.Companion companion2 = TutorialItem.INSTANCE;
        String string = context.getString(R.string.finish_setup_summary);
        string.getClass();
        arrayList.add(companion2.createItemFromRes(context, R.string.finish_setup, string, R.drawable.preview_personalize, R.color.tint_background_attention, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 0)));
        int i2 = 2;
        if (zIsOurExperimentalPhone || settings.getSmartWakeupMinutes() == 30) {
            String string2 = context.getString(R.string.settings_category_smart_summary);
            String string3 = context.getString(R.string.non_deep_sleep_window_title);
            int smartWakeupMinutes = settings.getSmartWakeupMinutes();
            StringBuilder sb = new StringBuilder();
            sb.append(smartWakeupMinutes);
            StringBuilder sbM66m = Fragment$$ExternalSyntheticOutline1.m66m(string2, ". ", string3, ": ", context.getString(R.string.minutes, sb.toString()));
            sbM66m.append(".");
            arrayList.add(companion2.createItemFromRes(context, R.string.settings_category_smart, sbM66m.toString(), R.drawable.preview_smart2, R.color.t3, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, i2)));
        }
        int i3 = 3;
        if (zIsOurExperimentalPhone || settings.getIdealSleepMinutes() == 420) {
            i = 3;
            arrayList.add(companion2.createItemFromRes(context, R.string.target_sleep_time_title, String.valueOf(context.getString(R.string.goal_duration_ideal)), R.drawable.preview_bedtime, R.color.t1, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, i3)));
        } else {
            i = 3;
        }
        if (zIsOurExperimentalPhone || settings.hasDefaultRingtone()) {
            String string4 = context.getString(R.string.ringtone_nature_ALL);
            String string5 = context.getString(R.string.alert);
            string5.getClass();
            String lowerCase = string5.toLowerCase(Locale.ROOT);
            String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string4, " ", lowerCase);
            String string6 = context.getString(R.string.natural_wake_up);
            string6.getClass();
            arrayList.add(companion2.createItemFromRes(context, strM$1, string6, R.drawable.preview_ring, R.color.t0, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 4)));
        }
        if (zIsOurExperimentalPhone || settings.getGradualVolumeIncreaseDuration() <= 60000) {
            arrayList.add(companion2.createItemFromRes(context, R.string.alarm_increasing_volume_title, R.string.alarm_increasing_volume_duration_summary, R.drawable.preview_gentle, R.color.t3, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 5)));
        }
        if ((zIsOurExperimentalPhone || settings.getDefaultCaptchaId() == 0) && PrefStore.getInt$default(prefStore, "captcha", 0, 2, null) != 0) {
            arrayList.add(companion2.createItemFromRes(context, R.string.stop_oversleeping, FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(R.string.settings_category_captcha), ": ", context.getString(R.string.captcha_preference_summary)), R.drawable.preview_captcha2, R.color.t2a, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 6)));
        }
        if (zIsOurExperimentalPhone || settings.getUsedLullabies().size() < i) {
            obj = null;
            if (PrefStore.getInt$default(prefStore, "lullaby", 0, 2, null) != 0) {
                String string7 = context.getString(R.string.settings_category_lullaby_summary);
                string7.getClass();
                arrayList.add(companion2.createItemFromRes(context, R.string.lullaby, string7, R.drawable.preview_lullaby, R.color.t0, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 7)));
            }
        } else {
            obj = null;
        }
        if (zIsOurExperimentalPhone || (!TrialFilter.getInstance().isAddonImport() && !settings.isGoogleFit() && !settings.isSamsungSHealth() && !settings.isTasker() && PrefStore.getInt$default(prefStore, "service", 0, 2, obj) != 0)) {
            arrayList.add(companion2.createItemFromRes(context, R.string.category_services, R.string.category_services_summary_more, R.drawable.preview_cloud, R.color.t2a, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 8)));
        }
        if ((zIsOurExperimentalPhone || settings.getCurrentGoal() == null) && PrefStore.getInt$default(prefStore, "goal", 0, 2, obj) != 0) {
            String string8 = context.getString(R.string.goal_summary);
            string8.getClass();
            arrayList.add(companion2.createItemFromRes(context, R.string.goal, string8, R.drawable.preview_goal, R.color.t3, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 9)));
        }
        if (zIsOurExperimentalPhone || (this.noises.isEmpty() && PrefStore.getInt$default(prefStore, "noise", 0, 2, obj) != 0)) {
            arrayList.add(companion2.createItemFromRes(context, R.string.sleep_recording_title, String.valueOf(context.getString(R.string.sleep_noise_analysis_summary)), R.drawable.preview_noise, R.color.t7, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 10)));
        }
        if ((zIsOurExperimentalPhone || settings.getRecordingAntisnoreResponse() == 0) && PrefStore.getInt$default(prefStore, "asnore", 0, 2, obj) != 0) {
            arrayList.add(companion2.createItemFromRes(context, R.string.anti_snoring_title, String.valueOf(context.getString(R.string.anti_snoring_summary)), R.drawable.preview_snore, R.color.t7, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 11)));
        }
        if ((zIsOurExperimentalPhone || !settings.isUltrasonicTracking()) && PrefStore.getInt$default(prefStore, "sonar", 0, 2, obj) != 0) {
            arrayList.add(companion2.createItemFromRes(context, R.string.sensor_sonar, R.string.sonar_explanation, R.drawable.preview_sonar, R.color.t2a, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 12)));
        }
        if ((zIsOurExperimentalPhone || settings.getSelectedWearable() == null || settings.getSelectedWearable() == Wearable.NONE) && PrefStore.getInt$default(prefStore, "wear", 0, 2, obj) != 0) {
            arrayList.add(companion2.createItemFromRes(context, R.string.smartwatch_title, R.string.smartwatch_support, R.drawable.preview_wearable, R.color.t2a, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 13)));
        }
        if (zIsOurExperimentalPhone || settings.getAutoStartMode() == 0) {
            String string9 = context.getString(R.string.auto_start_track_title);
            String string10 = context.getString(R.string.when_asleep);
            String string11 = context.getString(R.string.sleep_time_suggestion);
            StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("• ", string9, ": ", string10, "\n• ");
            sbM6m.append(string11);
            arrayList.add(companion2.createItemFromRes(context, R.string.automatic_sleep_tracking, sbM6m.toString(), R.drawable.preview_automagic, R.color.t2a, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 14)));
        }
        if (zIsOurExperimentalPhone || !settings.isSmartlightEnabled()) {
            String string12 = context.getString(R.string.sunrise_wakeup);
            string12.getClass();
            arrayList.add(companion2.createItemFromRes(context, string12, R.string.smartlight_support, R.drawable.preview_smartlight, R.color.t3, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 15)));
        }
        if (zIsOurExperimentalPhone || this.nextAlarm == null) {
            arrayList.add(companion2.createItemFromRes(context, R.string.set_alarm, FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(R.string.non_deep_sleep_window_title), ": ", context.getString(R.string.step_alarm_wake_at_range, "7:00", "7:30")), R.drawable.preview_alarm, R.color.t0, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 16)));
        }
        if (zIsOurExperimentalPhone || this.lastSleepRecord == null) {
            companion = companion2;
            activity = context;
            arrayList.add(companion.createItemFromRes(activity, R.string.start_sleep_tracking, String.valueOf(context.getString(R.string.step_bed)), R.drawable.preview_track, R.color.t2a, new DashboardCardBuilder$$ExternalSyntheticLambda2(context, 17)));
        } else {
            companion = companion2;
            activity = context;
        }
        arrayList.add(companion.createItemFromRes(activity, R.string.did_not_help, Fragment$$ExternalSyntheticOutline1.m(Fragment$$ExternalSyntheticOutline1.m66m(activity.getString(R.string.support_summary), "\n• ", activity.getString(R.string.documentation), "\n• ", activity.getString(R.string.faq)), "\n• ", activity.getString(R.string.forum), "\n• ", activity.getString(R.string.get_support)), R.drawable.preview_help, R.color.tint_background, new DashboardCardBuilder$$ExternalSyntheticLambda2(activity, 1)));
        TutorialItem tutorialItemCreateItemFromRes = companion.createItemFromRes(activity, R.string.thanks_for_watching, Fragment$$ExternalSyntheticOutline1.m("• ", activity.getString(R.string.tap_to_restart), "\n\n• ", activity.getString(R.string.dashboard_card_showcase_swipe)), R.drawable.preview_restart, R.color.tint_background, new Tool$$ExternalSyntheticLambda0(28));
        tutorialItemCreateItemFromRes.setLast(true);
        arrayList.add(tutorialItemCreateItemFromRes);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$0(Activity activity) {
        Toast.makeText(activity, R.string.dashboard_card_showcase_swipe, 1).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$1(Activity activity) {
        SimpleSettingsActivity.startHighlight(activity, SmartSettingsActivity.class, "non_deep_sleep_window");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$10(Activity activity) {
        SimpleSettingsActivity.startHighlight(activity, NoiseSettingsActivity.class, "anti_snoring_response");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$11(Activity activity) {
        SimpleSettingsActivity.startHighlight(activity, TrackSettingsActivity.class, "non_deep_sleep_method");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$12(Activity activity) {
        SimpleSettingsActivity.startHighlight(activity, SmartwatchSettingsActivity.class, "selected_wearable");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$13(Activity activity) {
        if (activity instanceof AlarmClock) {
            SimpleSettingsActivity.startHighlight(activity, TrackAutoSettingsActivity.class, "auto_start_track_smart");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$14(Activity activity) {
        SimpleSettingsActivity.startHighlight(activity, SmartLightSettingsActivity.class, "smartlight");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$15(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) AlarmActivity.class);
        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "tutorial");
        activity.startActivity(intent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$16(Activity activity) {
        DashboardFragment dashboardFragment;
        if ((activity instanceof AlarmClock) && (dashboardFragment = ((AlarmClock) activity).getDashboardFragment()) != null) {
            dashboardFragment.showTutorialStartTrackShowcase(activity);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$17(Activity activity) {
        DocItemDialogFragment docItemDialogFragmentNewInstance = DocItemDialogFragment.INSTANCE.newInstance("menu", null, null);
        activity.getClass();
        docItemDialogFragmentNewInstance.show(((FragmentActivity) activity).getSupportFragmentManager(), "help");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$2(Activity activity) {
        SimpleSettingsActivity.startHighlight(activity, BedtimeSettingsActivity.class, "target_sleep_time_minutes");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$3(Activity activity) {
        SimpleSettingsActivity.startHighlight(activity, AlarmSettingsActivity.class, "ringtone_pref_single");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$4(Activity activity) {
        SimpleSettingsActivity.startHighlight(activity, GentleSettingsActivity.class, "alarm_increasing_volume_duration");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$5(Activity activity) {
        SimpleSettingsActivity.startHighlight(activity, CaptchaSettingsActivity.class, "captcha_mode");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$6(Activity activity) {
        LullabyActivity.INSTANCE.start(activity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$7(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) ServicesSettingsActivity.class));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$8(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) GoalSelectActivity.class));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTutorial$lambda$0$9(Activity activity) {
        SimpleSettingsActivity.startHighlight(activity, NoiseSettingsActivity.class, "noise_recording_master_switch");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable loadData$lambda$1$1(Noise noise) {
        noise.getClass();
        return Boolean.valueOf(Tag.hasTag(noise.getComment(), Tag.SNORE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable loadData$lambda$1$2(Noise noise) {
        noise.getClass();
        return Long.valueOf(noise.getFromTime());
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.CardBuilder
    public List<DashboardCard<?>> buildCards(Activity context) {
        Activity activity;
        boolean z;
        context.getClass();
        Iterator<T> it = this.cachedCards.iterator();
        while (it.hasNext()) {
            ((DashboardCard) it.next()).onCardDestroyed();
        }
        this.cachedCards.clear();
        ArrayList arrayList = new ArrayList();
        Settings settings = new Settings(context);
        if (settings.isShowReleaseNotes() && new ReleaseNotes(context).isNewVersion()) {
            arrayList.add(new ReleaseNotesCard(context));
        }
        if (TrialFilter.getInstance().daysUsed(4)) {
            NewsCard newsCard = new NewsCard(context);
            if (newsCard.getLastShownCard() < 12) {
                try {
                    Cursor enabledAlarmsCursor = Alarms.getEnabledAlarmsCursor(context.getContentResolver());
                    int i = 0;
                    while (enabledAlarmsCursor.moveToNext()) {
                        if (new Alarm(enabledAlarmsCursor).getWeekRepeat() > 0) {
                            z = true;
                            break;
                        }
                        i++;
                        if (i > 20) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    Logger.logWarning("Failed to fetch active alarms", e);
                }
                z = false;
                if ((newsCard.getCurrentNewsNumber() != 12 && z) || (newsCard.getCurrentNewsNumber() != 12 && newsCard.shouldShowCurrentNews())) {
                    arrayList.add(newsCard);
                }
            } else {
                z = false;
                if (newsCard.getCurrentNewsNumber() != 12) {
                    arrayList.add(newsCard);
                } else {
                    arrayList.add(newsCard);
                }
            }
        }
        arrayList.add(new BedtimeCard(context));
        SleepRecord sleepRecord = this.lastSleepRecord;
        boolean z2 = sleepRecord != null && System.currentTimeMillis() - sleepRecord.getToTime() < 14400000;
        Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(context);
        if (settings.isDashboard()) {
            arrayList.add(new NextAlarmCard(context, alarmCalculateNextAlert, context.findViewById(R.id.fab)));
        }
        if ((this.lastSleepRecords.size() < 50 && TrialFilter.getInstance().daysUsed(0, 75)) || Experiments.getInstance().isOurExperimentalPhone()) {
            List<TutorialItem> listInitTutorial = initTutorial(context);
            if (!listInitTutorial.isEmpty()) {
                arrayList.add(new TutorialCard(context, listInitTutorial));
            }
        }
        if (TrialFilter.getInstance().isTrial()) {
            arrayList.add(new UnlockCard(context));
            if (IAdsController.isEligibleForAds(context) && settings.isDashboard()) {
                arrayList.add(new NativeAdCard(context));
            }
        }
        if (!this.interestingNoises.isEmpty()) {
            arrayList.add(new InterestingNoiseCard(context, new ArrayList(this.interestingNoises)));
        }
        if (this.lastSleepRecord != null && z2) {
            arrayList.add(new LastSleepRecordsCard(context, this.coroutineScope, this.lastSleepRecords));
        }
        SleepScore sleepScore = ContextExtKt.getSettings(context).getSleepScore();
        CoroutineScope coroutineScope = this.coroutineScope;
        sleepScore.getClass();
        arrayList.add(new ScoreCard(context, coroutineScope, sleepScore));
        if (this.lastSleepRecords.size() > 5) {
            String string = context.getString(R.string.sleep_assistant_summary);
            string.getClass();
            activity = context;
            arrayList.add(new AiCard(activity, string, null, 4, null));
        } else {
            activity = context;
        }
        if (TrialFilter.getInstance().isTrial() && IAdsController.isEligibleForAds(activity) && !settings.isDashboard()) {
            arrayList.add(new NativeAdCard(activity));
        }
        if (settings.getCurrentGoal() != null) {
            arrayList.add(new GoalCard(activity));
        }
        if (this.lastSleepRecord != null) {
            if (!z2) {
                arrayList.add(new LastSleepRecordsCard(activity, this.coroutineScope, this.lastSleepRecords));
            }
            if (this.noises.size() > 0) {
                try {
                    arrayList.add(new NoiseRecordCard(activity, this.lastSleepRecord, this.noises));
                } catch (ConcurrentModificationException e2) {
                    Logger.logSevere(Logger.defaultTag, getTag(), e2);
                }
            }
        } else if (TrialFilter.getInstance().isAddonImport()) {
            arrayList.add(new BackupCard(activity));
        }
        if (this.noises.size() == 0 && !settings.isRecordingMasterSwitchEnabled() && TrialFilter.getInstance().daysUsed(2, 30)) {
            arrayList.add(new NoNoiseCard(activity));
        }
        if (TrialFilter.getInstance().daysUsed(21, 42) && !ActivityRecognitionPermission.INSTANCE.isGranted(activity) && SharedApplicationContext.getSettings().getSleepTimeSuggestionMode() != SleepTimeSuggestionManager.Mode.DISABLED) {
            arrayList.add(new NoAutoTrackCard(activity));
        }
        if (settings.getRecordsCount() >= 5 || this.lastSleepRecords.size() >= 5) {
            arrayList.add(new ChartCard(activity));
        }
        if (TrialFilter.getInstance().daysUsed(7)) {
            PromoCard promoCard = new PromoCard(activity);
            if (promoCard.shouldShowCurrentPromo()) {
                arrayList.add(promoCard);
            }
        }
        arrayList.add(new AdviceCard(activity));
        arrayList.add(new ShortcutCard(activity));
        arrayList.add(new AchievementCard(activity));
        AddonApp addonAppRandom = AddonApp.INSTANCE.random(activity);
        if (this.lastSleepRecord != null && addonAppRandom != null) {
            arrayList.add(new AddOnCard(activity, addonAppRandom));
        }
        if (TrialFilter.getInstance().daysUsed(7, 60) || Experiments.getInstance().isOurExperimentalPhone()) {
            ShowCaseCard showCaseCard = new ShowCaseCard(activity);
            if (!showCaseCard.isRemoved()) {
                arrayList.add(showCaseCard);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((DashboardCard) obj).isPinned()) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!((DashboardCard) obj2).isPinned()) {
                arrayList3.add(obj2);
            }
        }
        LastCard lastCard = new LastCard(activity, CollectionsKt.toList(arrayList));
        List<DashboardCard<?>> list = this.cachedCards;
        list.addAll(arrayList2);
        list.addAll(arrayList3);
        list.add(lastCard);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : list) {
            if (!((DashboardCard) obj3).isRemoved()) {
                arrayList4.add(obj3);
            }
        }
        List<DashboardCard<?>> mutableList = CollectionsKt.toMutableList((Collection) arrayList4);
        this.cachedCards = mutableList;
        List<DashboardCard<?>> list2 = mutableList;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            ((DashboardCard) it2.next()).setCardBuilder(this);
            arrayList5.add(Unit.INSTANCE);
        }
        return CollectionsKt.toList(this.cachedCards);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.CardBuilder
    public Integer findPosition(Activity context, DashboardCard<?> card) {
        Integer next;
        context.getClass();
        card.getClass();
        if (this.cachedCards.size() == 0) {
            buildCards(context);
        }
        Iterator<Integer> it = CollectionsKt.getIndices(this.cachedCards).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (this.cachedCards.get(next.intValue()).getType() == card.getType()) {
                break;
            }
        }
        return next;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public void loadData(Context context) {
        context.getClass();
        DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
        this.lastSleepRecord = sleepRecordRepository.getLastSleepRecord();
        List<SleepRecord> sleepRecords = sleepRecordRepository.getSleepRecords(0, 10, false);
        sleepRecords.getClass();
        this.lastSleepRecords = sleepRecords;
        this.nextAlarm = Alarms.calculateNextAlert(context);
        List<Noise> noises = sleepRecordRepository.getNoises(1);
        if (noises.size() > 0) {
            this.lastNoise = noises.get(0);
        }
        SleepRecord sleepRecord = this.lastSleepRecord;
        if (sleepRecord != null) {
            this.noises.clear();
            List<Noise> list = this.noises;
            List<Noise> noises2 = sleepRecordRepository.getNoises(99, sleepRecord.getFromTime(), sleepRecord.getToTime());
            noises2.getClass();
            list.addAll(noises2);
            String strM = FileInsert$$ExternalSyntheticOutline0.m(this.noises.size(), "noises ");
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
            this.interestingNoises.clear();
            List<Noise> list2 = this.interestingNoises;
            List<Noise> noisesWithComment = sleepRecordRepository.getNoisesWithComment(20, sleepRecord.getFromTime(), sleepRecord.getToTime());
            noisesWithComment.getClass();
            list2.addAll(noisesWithComment);
            String strM2 = FileInsert$$ExternalSyntheticOutline0.m(this.interestingNoises.size(), "bestof ");
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM2, null);
            List<Noise> list3 = this.interestingNoises;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list3) {
                Noise noise = (Noise) obj;
                if ((noise.getFromTime() - sleepRecord.getFromTime()) / 60000 > 5 && (sleepRecord.getToTime() - noise.getToTime()) / 60000 > 5) {
                    String comment = noise.getComment();
                    Tag[] interestingSoundTags = InterestingNoiseCard.INSTANCE.getInterestingSoundTags();
                    if (Tag.hasOneOfTags(comment, (Tag[]) Arrays.copyOf(interestingSoundTags, interestingSoundTags.length))) {
                        arrayList.add(obj);
                    }
                }
            }
            CollectionsKt.sortWith(this.interestingNoises, ComparisonsKt.compareBy(new AiPrompt$$ExternalSyntheticLambda0(8), new AiPrompt$$ExternalSyntheticLambda0(9)));
        }
    }
}
