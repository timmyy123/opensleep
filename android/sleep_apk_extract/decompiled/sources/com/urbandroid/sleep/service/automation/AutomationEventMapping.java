package com.urbandroid.sleep.service.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.facebook.internal.AnalyticsEvents;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.jetlag.JetLagService;
import com.urbandroid.sleep.mic.SnoringReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b&\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00063"}, d2 = {"Lcom/urbandroid/sleep/service/automation/AutomationEventMapping;", "", "", "action", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "getLabel", "(Landroid/content/Context;)Ljava/lang/String;", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "", "getPosition", "()I", "position", "Companion", "SLEEP_TRACKING_STARTED", "SLEEP_TRACKING_STOPPED", "SLEEP_TRACKING_PAUSED", "SLEEP_TRACKING_RESUMED", "ALARM_SNOOZE_CLICKED", "ALARM_SNOOZE_CANCELED", "TIME_TO_BED_ALARM_ALERT", "ALARM_ALERT_START", "ALARM_ALERT_DISMISS", "ALARM_SKIP_NEXT", "REM", "ANTISNORING", "SMART_PERIOD", "BEFORE_SMART_PERIOD", "LULLABY_START", "LULLABY_STOP", "LULLABY_VOLUME_DOWN", "DEEP_SLEEP", "LIGHT_SLEEP", "AWAKE", "NOT_AWAKE", "APNEA_ALARM", "SOUND_EVENT_SNORE", "SOUND_EVENT_TALK", "SOUND_EVENT_COUGH", "SOUND_EVENT_BABY", "SOUND_EVENT_LAUGH", "BEFORE_ALARM", "ALARM_RESCHEDULED", "ALARM_WAKE_UP_CHECK", "JET_LAG_START", "JET_LAG_STOP", "UNKNOWN", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AutomationEventMapping {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AutomationEventMapping[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String action;
    public static final AutomationEventMapping SLEEP_TRACKING_STARTED = new AutomationEventMapping("SLEEP_TRACKING_STARTED", 0) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.SLEEP_TRACKING_STARTED
        {
            String str = "com.urbandroid.sleep.alarmclock.SLEEP_TRACKING_STARTED";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            String string = context.getString(R.string.settings_category_track);
            String string2 = context.getString(R.string.start, "");
            string2.getClass();
            String lowerCase = string2.toLowerCase(Locale.ROOT);
            return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
        }
    };
    public static final AutomationEventMapping SLEEP_TRACKING_STOPPED = new AutomationEventMapping("SLEEP_TRACKING_STOPPED", 1) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.SLEEP_TRACKING_STOPPED
        {
            String str = "com.urbandroid.sleep.alarmclock.SLEEP_TRACKING_STOPPED";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            String string = context.getString(R.string.settings_category_track);
            String string2 = context.getString(R.string.player_stop);
            string2.getClass();
            String lowerCase = string2.toLowerCase(Locale.ROOT);
            return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
        }
    };
    public static final AutomationEventMapping SLEEP_TRACKING_PAUSED = new AutomationEventMapping("SLEEP_TRACKING_PAUSED", 2) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.SLEEP_TRACKING_PAUSED
        {
            String str = "com.urbandroid.sleep.ACTION_TRACKING_USER_PAUSED";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            String string = context.getString(R.string.settings_category_track);
            String string2 = context.getString(R.string.pause);
            string2.getClass();
            String lowerCase = string2.toLowerCase(Locale.ROOT);
            return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
        }
    };
    public static final AutomationEventMapping SLEEP_TRACKING_RESUMED = new AutomationEventMapping("SLEEP_TRACKING_RESUMED", 3) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.SLEEP_TRACKING_RESUMED
        {
            String str = "com.urbandroid.sleep.ACTION_TRACKING_USER_RESUMED";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            String string = context.getString(R.string.settings_category_track);
            String string2 = context.getString(R.string.button_tracking_resume);
            string2.getClass();
            String lowerCase = string2.toLowerCase(Locale.ROOT);
            return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
        }
    };
    public static final AutomationEventMapping ALARM_SNOOZE_CLICKED = new AutomationEventMapping("ALARM_SNOOZE_CLICKED", 4) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.ALARM_SNOOZE_CLICKED
        {
            String str = "com.urbandroid.sleep.alarmclock.ALARM_SNOOZE_CLICKED_ACTION";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            String string = context.getString(R.string.default_label);
            String string2 = context.getString(R.string.alarm_alert_snooze_text);
            string2.getClass();
            String lowerCase = string2.toLowerCase(Locale.ROOT);
            return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
        }
    };
    public static final AutomationEventMapping ALARM_SNOOZE_CANCELED = new AutomationEventMapping("ALARM_SNOOZE_CANCELED", 5) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.ALARM_SNOOZE_CANCELED
        {
            String str = "com.urbandroid.sleep.alarmclock.cancel_snooze_finished";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.snooze_canceled);
        }
    };
    public static final AutomationEventMapping TIME_TO_BED_ALARM_ALERT = new AutomationEventMapping("TIME_TO_BED_ALARM_ALERT", 6) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.TIME_TO_BED_ALARM_ALERT
        {
            String str = "com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALARM_ALERT";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.time_to_bed_title);
        }
    };
    public static final AutomationEventMapping ALARM_ALERT_START = new AutomationEventMapping("ALARM_ALERT_START", 7) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.ALARM_ALERT_START
        {
            String str = "com.urbandroid.sleep.alarmclock.ALARM_ALERT_START";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            String string = context.getString(R.string.started, context.getString(R.string.default_label));
            string.getClass();
            return string;
        }
    };
    public static final AutomationEventMapping ALARM_ALERT_DISMISS = new AutomationEventMapping("ALARM_ALERT_DISMISS", 8) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.ALARM_ALERT_DISMISS
        {
            String str = "com.urbandroid.sleep.alarmclock.ALARM_ALERT_DISMISS";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            String string = context.getString(R.string.default_label);
            String string2 = context.getString(R.string.alarm_alert_dismiss_text);
            string2.getClass();
            String lowerCase = string2.toLowerCase(Locale.ROOT);
            return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
        }
    };
    public static final AutomationEventMapping ALARM_SKIP_NEXT = new AutomationEventMapping("ALARM_SKIP_NEXT", 9) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.ALARM_SKIP_NEXT
        {
            String str = "com.urbandroid.sleep.alarmclock.SKIP_NEXT_ALARM_ACTION";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            String string = context.getString(R.string.default_label);
            String string2 = context.getString(R.string.disable_alarm_for_today);
            string2.getClass();
            String lowerCase = string2.toLowerCase(Locale.ROOT);
            return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
        }
    };
    public static final AutomationEventMapping REM = new AutomationEventMapping("REM", 10) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.REM
        {
            String str = "com.urbandroid.sleep.LUCID_CUE_ACTION";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            String upperCase = zza$$ExternalSyntheticOutline0.m(context, R.string.rem).toUpperCase(Locale.ROOT);
            upperCase.getClass();
            return upperCase;
        }
    };
    public static final AutomationEventMapping ANTISNORING = new AutomationEventMapping("ANTISNORING", 11) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.ANTISNORING
        {
            String str = SnoringReceiver.ANTISNORING_ACTION;
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.anti_snoring_title);
        }
    };
    public static final AutomationEventMapping SMART_PERIOD = new AutomationEventMapping("SMART_PERIOD", 12) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.SMART_PERIOD
        {
            String str = "com.urbandroid.sleep.SMART_PERIOD";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.non_deep_sleep_window_title);
        }
    };
    public static final AutomationEventMapping BEFORE_SMART_PERIOD = new AutomationEventMapping("BEFORE_SMART_PERIOD", 13) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.BEFORE_SMART_PERIOD
        {
            String str = "com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            String string = context.getString(R.string.before);
            String string2 = context.getString(R.string.non_deep_sleep_window_title);
            string2.getClass();
            String lowerCase = string2.toLowerCase(Locale.ROOT);
            return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
        }
    };
    public static final AutomationEventMapping LULLABY_START = new AutomationEventMapping("LULLABY_START", 14) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.LULLABY_START
        {
            String str = "com.urbandroid.sleep.ACTION_LULLABY_START_PLAYBACK";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            String string = context.getString(R.string.lullaby);
            String string2 = context.getString(R.string.start, "");
            string2.getClass();
            String lowerCase = string2.toLowerCase(Locale.ROOT);
            return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
        }
    };
    public static final AutomationEventMapping LULLABY_STOP = new AutomationEventMapping("LULLABY_STOP", 15) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.LULLABY_STOP
        {
            String str = "com.urbandroid.sleep.ACTION_LULLABY_STOPPED_PLAYBACK";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            String string = context.getString(R.string.lullaby);
            String string2 = context.getString(R.string.player_stop);
            string2.getClass();
            String lowerCase = string2.toLowerCase(Locale.ROOT);
            return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
        }
    };
    public static final AutomationEventMapping LULLABY_VOLUME_DOWN = new AutomationEventMapping("LULLABY_VOLUME_DOWN", 16) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.LULLABY_VOLUME_DOWN
        {
            String str = "com.urbandroid.sleep.LULLABY_VOLUME_DOWN";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.when_asleep);
        }
    };
    public static final AutomationEventMapping DEEP_SLEEP = new AutomationEventMapping("DEEP_SLEEP", 17) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.DEEP_SLEEP
        {
            String str = "com.urbandroid.sleep.TRACKING_DEEP_SLEEP";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.label_deep_sleep);
        }
    };
    public static final AutomationEventMapping LIGHT_SLEEP = new AutomationEventMapping("LIGHT_SLEEP", 18) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.LIGHT_SLEEP
        {
            String str = "com.urbandroid.sleep.TRACKING_LIGHT_SLEEP";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.label_light_sleep);
        }
    };
    public static final AutomationEventMapping AWAKE = new AutomationEventMapping("AWAKE", 19) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.AWAKE
        {
            String str = "com.urbandroid.sleep.AWAKE";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.awake);
        }
    };
    public static final AutomationEventMapping NOT_AWAKE = new AutomationEventMapping("NOT_AWAKE", 20) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.NOT_AWAKE
        {
            String str = "com.urbandroid.sleep.NOT_AWAKE";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.asleep);
        }
    };
    public static final AutomationEventMapping APNEA_ALARM = new AutomationEventMapping("APNEA_ALARM", 21) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.APNEA_ALARM
        {
            String str = "com.urbandroid.sleep.ACTION_APNEA_ALARM";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.oximeter_alarm);
        }
    };
    public static final AutomationEventMapping SOUND_EVENT_SNORE = new AutomationEventMapping("SOUND_EVENT_SNORE", 22) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.SOUND_EVENT_SNORE
        {
            String str = "com.urbandroid.sleep.audio.SOUND_EVENT_SNORE";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.stats_caption_snore);
        }
    };
    public static final AutomationEventMapping SOUND_EVENT_TALK = new AutomationEventMapping("SOUND_EVENT_TALK", 23) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.SOUND_EVENT_TALK
        {
            String str = "com.urbandroid.sleep.audio.SOUND_EVENT_TALK";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.talk);
        }
    };
    public static final AutomationEventMapping SOUND_EVENT_COUGH = new AutomationEventMapping("SOUND_EVENT_COUGH", 24) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.SOUND_EVENT_COUGH
        {
            String str = "com.urbandroid.sleep.audio.SOUND_EVENT_COUGH";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.sound_sick);
        }
    };
    public static final AutomationEventMapping SOUND_EVENT_BABY = new AutomationEventMapping("SOUND_EVENT_BABY", 25) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.SOUND_EVENT_BABY
        {
            String str = "com.urbandroid.sleep.audio.SOUND_EVENT_BABY";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.sound_baby_cry);
        }
    };
    public static final AutomationEventMapping SOUND_EVENT_LAUGH = new AutomationEventMapping("SOUND_EVENT_LAUGH", 26) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.SOUND_EVENT_LAUGH
        {
            String str = "com.urbandroid.sleep.audio.SOUND_EVENT_LAUGH";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.sound_laughter);
        }
    };
    public static final AutomationEventMapping BEFORE_ALARM = new AutomationEventMapping("BEFORE_ALARM", 27) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.BEFORE_ALARM
        {
            String str = "com.urbandroid.sleep.alarmclock.SHOW_SKIP_NEXT_ALARM_ACTION";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            return FileInsert$$ExternalSyntheticOutline0.m("1h ", context.getString(R.string.before_alarm_notification));
        }
    };
    public static final AutomationEventMapping ALARM_RESCHEDULED = new AutomationEventMapping("ALARM_RESCHEDULED", 28) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.ALARM_RESCHEDULED
        {
            String str = "com.urbandroid.sleep.alarmclock.ALARM_RESCHEDULED";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.calendar_event_preference_title);
        }
    };
    public static final AutomationEventMapping ALARM_WAKE_UP_CHECK = new AutomationEventMapping("ALARM_WAKE_UP_CHECK", 29) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.ALARM_WAKE_UP_CHECK
        {
            String str = "com.urbandroid.sleep.alarmclock.ALARM_WAKE_UP_CHECK";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            return zza$$ExternalSyntheticOutline0.m(context, R.string.settings_wake_up_check);
        }
    };
    public static final AutomationEventMapping JET_LAG_START = new AutomationEventMapping("JET_LAG_START", 30) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.JET_LAG_START
        {
            JetLagService.ACTION_JETLAG_START.getClass();
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            return FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(R.string.jetlag), " ", context.getString(R.string.start, ""));
        }
    };
    public static final AutomationEventMapping JET_LAG_STOP = new AutomationEventMapping("JET_LAG_STOP", 31) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.JET_LAG_STOP
        {
            JetLagService.ACTION_JETLAG_STOP.getClass();
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            return FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(R.string.jetlag), " ", context.getString(R.string.stop));
        }
    };
    public static final AutomationEventMapping UNKNOWN = new AutomationEventMapping("UNKNOWN", 32) { // from class: com.urbandroid.sleep.service.automation.AutomationEventMapping.UNKNOWN
        {
            String str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.urbandroid.sleep.service.automation.AutomationEventMapping
        public String getLabel(Context context) {
            context.getClass();
            return name();
        }
    };

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/service/automation/AutomationEventMapping$Companion;", "", "<init>", "()V", "", "", "getActionSet", "()Ljava/util/Set;", "action", "Lcom/urbandroid/sleep/service/automation/AutomationEventMapping;", "findByAction", "(Ljava/lang/String;)Lcom/urbandroid/sleep/service/automation/AutomationEventMapping;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "getLabels", "(Landroid/content/Context;)Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AutomationEventMapping findByAction(String action) {
            action.getClass();
            for (AutomationEventMapping automationEventMapping : AutomationEventMapping.values()) {
                if (Intrinsics.areEqual(automationEventMapping.getAction(), action)) {
                    return automationEventMapping;
                }
            }
            return null;
        }

        public final Set<String> getActionSet() {
            AutomationEventMapping[] automationEventMappingArrValues = AutomationEventMapping.values();
            ArrayList arrayList = new ArrayList();
            for (AutomationEventMapping automationEventMapping : automationEventMappingArrValues) {
                if (automationEventMapping != AutomationEventMapping.UNKNOWN) {
                    arrayList.add(automationEventMapping);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((AutomationEventMapping) it.next()).getAction());
            }
            return CollectionsKt.toSet(arrayList2);
        }

        public final List<String> getLabels(Context context) {
            context.getClass();
            AutomationEventMapping[] automationEventMappingArrValues = AutomationEventMapping.values();
            ArrayList arrayList = new ArrayList(automationEventMappingArrValues.length);
            for (AutomationEventMapping automationEventMapping : automationEventMappingArrValues) {
                arrayList.add(automationEventMapping.getLabel(context));
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ AutomationEventMapping[] $values() {
        return new AutomationEventMapping[]{SLEEP_TRACKING_STARTED, SLEEP_TRACKING_STOPPED, SLEEP_TRACKING_PAUSED, SLEEP_TRACKING_RESUMED, ALARM_SNOOZE_CLICKED, ALARM_SNOOZE_CANCELED, TIME_TO_BED_ALARM_ALERT, ALARM_ALERT_START, ALARM_ALERT_DISMISS, ALARM_SKIP_NEXT, REM, ANTISNORING, SMART_PERIOD, BEFORE_SMART_PERIOD, LULLABY_START, LULLABY_STOP, LULLABY_VOLUME_DOWN, DEEP_SLEEP, LIGHT_SLEEP, AWAKE, NOT_AWAKE, APNEA_ALARM, SOUND_EVENT_SNORE, SOUND_EVENT_TALK, SOUND_EVENT_COUGH, SOUND_EVENT_BABY, SOUND_EVENT_LAUGH, BEFORE_ALARM, ALARM_RESCHEDULED, ALARM_WAKE_UP_CHECK, JET_LAG_START, JET_LAG_STOP, UNKNOWN};
    }

    static {
        AutomationEventMapping[] automationEventMappingArr$values = $values();
        $VALUES = automationEventMappingArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(automationEventMappingArr$values);
        INSTANCE = new Companion(null);
    }

    private AutomationEventMapping(String str, int i, String str2) {
        this.action = str2;
    }

    public static final AutomationEventMapping findByAction(String str) {
        return INSTANCE.findByAction(str);
    }

    public static final Set<String> getActionSet() {
        return INSTANCE.getActionSet();
    }

    public static final List<String> getLabels(Context context) {
        return INSTANCE.getLabels(context);
    }

    public static AutomationEventMapping valueOf(String str) {
        return (AutomationEventMapping) Enum.valueOf(AutomationEventMapping.class, str);
    }

    public static AutomationEventMapping[] values() {
        return (AutomationEventMapping[]) $VALUES.clone();
    }

    public final String getAction() {
        return this.action;
    }

    public abstract String getLabel(Context context);

    public final int getPosition() {
        AutomationEventMapping[] automationEventMappingArrValues = values();
        int length = automationEventMappingArrValues.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            if (automationEventMappingArrValues[i] == this) {
                return i2;
            }
            i++;
            i2 = i3;
        }
        FacebookSdk$$ExternalSyntheticLambda1.m(this, " not found");
        return 0;
    }

    public /* synthetic */ AutomationEventMapping(String str, int i, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2);
    }
}
