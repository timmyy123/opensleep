package com.urbandroid.sleep.activityrecognition;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.NewAddRecordActivity;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.activityrecognition.ActivityIntervals;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeCalculator;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeSuggestion;
import com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailActivity;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.Experiments;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0002$%B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J(\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0012J\u0019\u0010\u0019\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u0011\u001a\u00020\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006&"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/SleepTimeSuggestionManager;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "currentTimeInMs", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "tag", "", "getTag", "()Ljava/lang/String;", "suggest", "", "mode", "Lcom/urbandroid/sleep/activityrecognition/SleepTimeSuggestionManager$Mode;", "schedule", "", "suggestNotification", "estimate", "Lcom/urbandroid/sleep/activityrecognition/calculator/SleepTimeCalculator$Estimate;", "notificationId", "", "fromGoogleSleepApi", "calculateScheduleTime", "suggestedTime", "(Ljava/lang/Long;)J", "utcTime", "(Ljava/lang/Long;)V", "cancelAlarm", "cancel", "addRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "prepareIntent", "Lcom/urbandroid/sleep/PendingIntentBuilder;", "Mode", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepTimeSuggestionManager implements FeatureLogger {
    private final Context context;
    private final Function0<Long> currentTimeInMs;
    private final String tag;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/SleepTimeSuggestionManager$Mode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "DISABLED", "MANUAL", "AUTOMATIC", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int code;
        public static final Mode DISABLED = new Mode("DISABLED", 0, 0);
        public static final Mode MANUAL = new Mode("MANUAL", 1, 1);
        public static final Mode AUTOMATIC = new Mode("AUTOMATIC", 2, 2);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/SleepTimeSuggestionManager$Mode$Companion;", "", "<init>", "()V", "findOrNull", "Lcom/urbandroid/sleep/activityrecognition/SleepTimeSuggestionManager$Mode;", "code", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Mode findOrNull(int code) {
                for (Mode mode : Mode.values()) {
                    if (mode.getCode() == code) {
                        return mode;
                    }
                }
                return null;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{DISABLED, MANUAL, AUTOMATIC};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(modeArr$values);
            INSTANCE = new Companion(null);
        }

        private Mode(String str, int i, int i2) {
            this.code = i2;
        }

        public static final Mode findOrNull(int i) {
            return INSTANCE.findOrNull(i);
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        public final int getCode() {
            return this.code;
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SleepTimeCalculator.Estimate.Type.values().length];
            try {
                iArr[SleepTimeCalculator.Estimate.Type.BASIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SleepTimeCalculator.Estimate.Type.ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SleepTimeCalculator.Estimate.Type.DB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SleepTimeSuggestionManager(Context context, Function0<Long> function0) {
        context.getClass();
        function0.getClass();
        this.context = context;
        this.currentTimeInMs = function0;
        this.tag = "activity:estimate";
    }

    private final SleepRecord addRecord(SleepTimeCalculator.Estimate estimate) {
        SleepRecord sleepRecord = new SleepRecord(TimeZone.getDefault().getID(), estimate.getFrom().getTime(), estimate.getTo().getTime());
        sleepRecord.updateLatestTo(estimate.getTo().getTime());
        sleepRecord.setTo(estimate.getTo().getTime());
        sleepRecord.setFinished(true);
        sleepRecord.addTag(Tag.AUTO);
        sleepRecord.setHistory(CollectionsKt.listOf(Float.valueOf(0.0f)));
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        String str = Logger.defaultTag;
        Logger.logInfo(str, getTag() + ": " + ("Automatic save current record " + record), null);
        if (record != null && record.getInterval().hasIntersection(sleepRecord.getInterval())) {
            String str2 = Logger.defaultTag;
            Logger.logInfo(str2, getTag() + ": " + ("Automatic save NOT saving " + sleepRecord + " intersection with current"), null);
            return sleepRecord;
        }
        String str3 = Logger.defaultTag;
        Logger.logInfo(str3, getTag() + ": " + ("Automatic save new record " + sleepRecord), null);
        SharedApplicationContext sharedApplicationContext = SharedApplicationContext.getInstance();
        sharedApplicationContext.getSleepRecordRepository().addNewSleepRecord(sleepRecord);
        Context context = sharedApplicationContext.getContext();
        context.getClass();
        ContextExtKt.getSettings(context).incRecordsCount();
        sharedApplicationContext.getFirebaseAnalyticsManager().setEventAutomaticRecordAddedFromSuggestion();
        Logger.logInfo(Logger.defaultTag, getTag() + ": SYNC data changed broadcast", null);
        ContextExtKt.sendExplicitBroadcast$default(this.context, new Intent("com.urbandroid.sleep.REQUEST_SYNC"), null, 2, null);
        return sleepRecord;
    }

    private final long calculateScheduleTime(Long suggestedTime) {
        Calendar calendar;
        if (suggestedTime != null && suggestedTime.longValue() > this.currentTimeInMs.invoke().longValue()) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": Keeping suggested time - not calculating schedule", null);
            return suggestedTime.longValue();
        }
        SleepTimeCalculator.Estimate estimateNextNightBasicEstimate = SleepTimeCalculator.INSTANCE.nextNightBasicEstimate(this.currentTimeInMs);
        SleepTimeCalculator.Estimate estimateCalculate$default = SleepTimeSuggestion.calculate$default(new SleepTimeSuggestion(), this.context, estimateNextNightBasicEstimate, null, 4, null);
        if (estimateCalculate$default == null) {
            estimateCalculate$default = estimateNextNightBasicEstimate;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[estimateCalculate$default.getType().ordinal()];
        if (i == 1 || i == 2) {
            Calendar to = estimateNextNightBasicEstimate.getTo();
            calendar = Calendar.getInstance();
            calendar.setTimeInMillis(to.getTimeInMillis());
            calendar.add(11, 3);
        } else {
            if (i != 3) {
                Home$$ExternalSyntheticBUOutline0.m();
                return 0L;
            }
            Calendar to2 = estimateCalculate$default.getTo();
            calendar = Calendar.getInstance();
            calendar.setTimeInMillis(to2.getTimeInMillis());
            calendar.add(11, 1);
        }
        return calendar.getTimeInMillis();
    }

    private final PendingIntentBuilder prepareIntent() {
        return new PendingIntentBuilder(this.context, 0, new Intent(this.context, (Class<?>) NotifySleepTimeSuggestionReceiver.class), 134217728);
    }

    public static /* synthetic */ void schedule$default(SleepTimeSuggestionManager sleepTimeSuggestionManager, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        sleepTimeSuggestionManager.schedule(l);
    }

    public static /* synthetic */ void suggest$default(SleepTimeSuggestionManager sleepTimeSuggestionManager, Mode mode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        sleepTimeSuggestionManager.suggest(mode, z);
    }

    public static /* synthetic */ void suggestNotification$default(SleepTimeSuggestionManager sleepTimeSuggestionManager, Mode mode, SleepTimeCalculator.Estimate estimate, int i, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        sleepTimeSuggestionManager.suggestNotification(mode, estimate, i, z);
    }

    public final void cancel(int notificationId) {
        NotificationManagerCompat.from(this.context).cancel(notificationId);
    }

    public final void cancelAlarm() {
        prepareIntent().cancelAlarmBroadcast();
        Settings settings = ContextExtKt.getSettings(this.context);
        settings.setSleepTimeSuggestionLastDay(-1);
        settings.setSleepTimeSuggestionScheduledNotificationTime(-1L);
        Logger.logDebug(Logger.defaultTag, getTag() + ": Cancel Sleep Time Suggestion alarm", null);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void schedule(Long utcTime) {
        boolean z;
        Settings settings = ContextExtKt.getSettings(this.context);
        long jLongValue = this.currentTimeInMs.invoke().longValue();
        long sleepTimeSuggestionLastNotificationTime = settings.getSleepTimeSuggestionLastNotificationTime();
        final boolean z2 = false;
        boolean z3 = sleepTimeSuggestionLastNotificationTime != -1 && jLongValue - Utils.getHoursInMillis(4) <= sleepTimeSuggestionLastNotificationTime && sleepTimeSuggestionLastNotificationTime <= jLongValue;
        long sleepTimeSuggestionScheduledNotificationTime = settings.getSleepTimeSuggestionScheduledNotificationTime();
        boolean z4 = sleepTimeSuggestionScheduledNotificationTime == -1;
        boolean z5 = !z4 && (sleepTimeSuggestionLastNotificationTime != -1 || sleepTimeSuggestionLastNotificationTime < sleepTimeSuggestionScheduledNotificationTime - Utils.getMinutesInMillis(30));
        if (!z4) {
            z = sleepTimeSuggestionScheduledNotificationTime <= Utils.getHoursInMillis(36) + jLongValue && jLongValue - Utils.getMinutesInMillis(30) <= sleepTimeSuggestionScheduledNotificationTime;
        }
        final String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(getTag(), ":scheduled notification");
        FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager$schedule$$inlined$featureLog$default$1
            @Override // com.urbandroid.common.FeatureLogger
            public String getTag() {
                String str = strM$1;
                boolean z6 = z2;
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str);
                String strConcat = "";
                if (z6) {
                    String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
                    if (strM == null) {
                        strConcat = null;
                    } else if (!StringsKt.isBlank(strM)) {
                        strConcat = ":".concat(strM);
                    }
                }
                sbM.append(strConcat);
                return sbM.toString();
            }
        };
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("shownTime: ", Utils.getPrettyDate(sleepTimeSuggestionLastNotificationTime), " scheduledTime: ", Utils.getPrettyDate(sleepTimeSuggestionScheduledNotificationTime), " firstTime: ");
        sbM6m.append(z4);
        sbM6m.append(" notShownAfterSchedule: ");
        sbM6m.append(z5);
        sbM6m.append(" scheduledInNearFuture: ");
        sbM6m.append(z);
        String string = sbM6m.toString();
        Logger.logDebug(Logger.defaultTag, featureLogger.getTag() + ": " + string, null);
        if (z5) {
            if (z) {
                Logger.logDebug(Logger.defaultTag, featureLogger.getTag() + ": scheduled but not yet fired after time - NOT SCHEDULING", null);
                return;
            }
            if (z3) {
                Logger.logDebug(Logger.defaultTag, featureLogger.getTag() + ": Already shown recently - NOT SHOWING", null);
                return;
            }
            Logger.logDebug(Logger.defaultTag, featureLogger.getTag() + ": scheduled but was not shown by alarm: force showing", null);
            Mode sleepTimeSuggestionMode = settings.getSleepTimeSuggestionMode();
            sleepTimeSuggestionMode.getClass();
            suggest(sleepTimeSuggestionMode, false);
        }
        if (z4 || !z) {
            long jCalculateScheduleTime = calculateScheduleTime(utcTime);
            try {
                PendingIntentBuilder pendingIntentBuilderPrepareIntent = prepareIntent();
                AlarmManager alarmManager = ContextExtKt.getAlarmManager(this.context);
                PendingIntent explicitBroadcast = pendingIntentBuilderPrepareIntent.getExplicitBroadcast();
                alarmManager.cancel(explicitBroadcast);
                alarmManager.set(1, jCalculateScheduleTime, explicitBroadcast);
                settings.setSleepTimeSuggestionScheduledNotificationTime(jCalculateScheduleTime);
                String str = "scheduled at " + Utils.getPrettyDate(jCalculateScheduleTime);
                Logger.logDebug(Logger.defaultTag, featureLogger.getTag() + ": " + str, null);
            } catch (Exception e) {
                Logger.logSevere(Logger.defaultTag, featureLogger.getTag(), e);
            }
        }
    }

    public final void suggest(Mode mode, boolean schedule) {
        mode.getClass();
        boolean zIsGranted = ActivityRecognitionPermission.INSTANCE.isGranted(this.context);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + ("suggest mode: " + mode + " permission: " + zIsGranted), null);
        if (mode == Mode.DISABLED || !zIsGranted) {
            return;
        }
        long jLongValue = this.currentTimeInMs.invoke().longValue();
        try {
            long sleepTimeSuggestionLastNotificationTime = ContextExtKt.getSettings(this.context).getSleepTimeSuggestionLastNotificationTime();
            if (sleepTimeSuggestionLastNotificationTime != -1 && jLongValue - Utils.getHoursInMillis(12) <= sleepTimeSuggestionLastNotificationTime && sleepTimeSuggestionLastNotificationTime <= jLongValue) {
                String str = "notification already shown at " + Utils.getPrettyDate(sleepTimeSuggestionLastNotificationTime);
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
                if (schedule) {
                    return;
                } else {
                    return;
                }
            }
            SleepTimeCalculator.Estimate estimateCalculate$default = SleepTimeSuggestion.calculate$default(new SleepTimeSuggestion(), this.context, SleepTimeCalculator.Companion.lastNightBasicEstimate$default(SleepTimeCalculator.INSTANCE, null, 1, null), null, 4, null);
            if (estimateCalculate$default == null) {
                Logger.logInfo(Logger.defaultTag, getTag() + ": no estimate", null);
                if (schedule) {
                    schedule$default(new SleepTimeSuggestionManager(this.context, this.currentTimeInMs), null, 1, null);
                }
                if (schedule) {
                    schedule$default(this, null, 1, null);
                    return;
                }
                return;
            }
            if (estimateCalculate$default.getTo().getTimeInMillis() <= jLongValue) {
                suggestNotification$default(this, mode, estimateCalculate$default, 2442, false, 8, null);
                if (schedule) {
                    schedule$default(this, null, 1, null);
                    return;
                }
                return;
            }
            String str2 = "suggested estimate in future: " + estimateCalculate$default + "  now: " + Utils.getPrettyDate(jLongValue);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
            long timeInMillis = estimateCalculate$default.getTo().getTimeInMillis() + Utils.getMinutesInMillis(5);
            String str3 = "scheduled to " + Utils.getPrettyDate(timeInMillis);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str3, null);
            if (schedule) {
                new SleepTimeSuggestionManager(this.context, this.currentTimeInMs).schedule(Long.valueOf(timeInMillis));
            }
            if (schedule) {
                schedule$default(this, null, 1, null);
            }
        } finally {
            if (schedule) {
                schedule$default(this, null, 1, null);
            }
        }
    }

    public final void suggestNotification(Mode mode, SleepTimeCalculator.Estimate estimate, int notificationId, boolean fromGoogleSleepApi) {
        String str;
        int i;
        mode.getClass();
        estimate.getClass();
        if (mode == Mode.DISABLED) {
            return;
        }
        long jLongValue = this.currentTimeInMs.invoke().longValue();
        Mode mode2 = Mode.AUTOMATIC;
        if (mode == mode2) {
            if (estimate.getType() == SleepTimeCalculator.Estimate.Type.ACTIVITY) {
                addRecord(estimate);
                return;
            }
            String str2 = "Automatic mode is enabled but " + estimate.getType() + " was not calculated from detected activities";
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + str2, null);
            return;
        }
        PendingIntentBuilder.Companion companion = PendingIntentBuilder.INSTANCE;
        Context context = this.context;
        Intent intent = new Intent(this.context, (Class<?>) TrackSettingsActivity.class);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        intent.putExtra("notification_id", notificationId);
        intent.putExtra("SHOW_SLEEP_SUGGESTION_MODES", true);
        Unit unit = Unit.INSTANCE;
        PendingIntent activity = companion.get(context, notificationId, intent, 134217728).getActivity();
        boolean zIs24HourFormat = new Settings(this.context).is24HourFormat();
        Context context2 = this.context;
        ActivityIntervals.Companion companion2 = ActivityIntervals.INSTANCE;
        String string = context2.getString(R.string.sleep_time_suggestion_notification, companion2.formatWithDay(estimate.getFrom().getTimeInMillis(), zIs24HourFormat), companion2.format(estimate.getTo().getTimeInMillis(), estimate.getFrom().getTimeInMillis(), zIs24HourFormat));
        if (Experiments.getInstance().isOurExperimentalPhone()) {
            string = FileInsert$$ExternalSyntheticOutline0.m(fromGoogleSleepApi ? "G-" : "A-", string);
        } else {
            string.getClass();
        }
        NotificationCompat.Builder style = new NotificationCompat.Builder(this.context, "sleepTimeSuggestionChannel").setColor(ColorUtil.i(this.context, R.color.tint_notification)).setAutoCancel(true).setContentTitle(string).setContentText(this.context.getString(R.string.sleep_time_suggestion_description)).setSmallIcon(R.drawable.ic_action_track_white).setStyle(new NotificationCompat.BigTextStyle().bigText(this.context.getString(R.string.sleep_time_suggestion_description)));
        style.getClass();
        Mode sleepTimeSuggestionMode = ContextExtKt.getSettings(this.context).getSleepTimeSuggestionMode();
        Context context3 = this.context;
        if (sleepTimeSuggestionMode == mode2) {
            PendingIntent activity2 = companion.get(context3, notificationId, SleepDetailActivity.Companion.getStartIntent$default(SleepDetailActivity.INSTANCE, context3, null, false, 4, null), 134217728).getActivity();
            style.addAction(0, this.context.getString(R.string.edit_record), activity2);
            style.setContentIntent(activity2);
            str = ": ";
            i = 0;
        } else {
            Intent intent2 = new Intent(this.context, (Class<?>) NewAddRecordActivity.class);
            intent2.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent2.putExtra("sleep_suggestion", notificationId);
            str = ": ";
            intent2.putExtra("rangeFrom", estimate.getFrom().getTimeInMillis());
            intent2.putExtra("rangeTo", estimate.getTo().getTimeInMillis());
            PendingIntent activity3 = companion.get(context3, notificationId, intent2, 134217728).getActivity();
            i = 0;
            style.addAction(0, this.context.getString(R.string.add_record_button), activity3);
            style.setContentIntent(activity3);
        }
        style.addAction(i, this.context.getString(R.string.settings), activity);
        ContextExtKt.getSettings(this.context).setSleepTimeSuggestionLastNotificationTime(jLongValue);
        Context context4 = this.context;
        Notification notificationBuild = style.build();
        notificationBuild.getClass();
        NotificationsKt.notify(context4, notificationId, notificationBuild);
        try {
            if (SharedApplicationContext.getSettings().isActivityRecognitionNewSleepApi()) {
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSleepApiSegmentShown();
            }
        } catch (Exception unused) {
        }
        String strM = FileInsert$$ExternalSyntheticOutline0.m("show notification called: ", string);
        Logger.logInfo(Logger.defaultTag, getTag() + str + strM, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SleepTimeSuggestionManager(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        context.getClass();
    }

    public /* synthetic */ SleepTimeSuggestionManager(Context context, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new Tool$$ExternalSyntheticLambda0(22) : function0);
    }

    public final void schedule() {
        schedule$default(this, null, 1, null);
    }
}
