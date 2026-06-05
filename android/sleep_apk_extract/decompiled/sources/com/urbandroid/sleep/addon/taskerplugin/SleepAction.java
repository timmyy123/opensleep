package com.urbandroid.sleep.addon.taskerplugin;

import android.content.Context;
import android.content.Intent;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SleepAction {
    private final String action;
    public static final SleepAction START_SLEEP_TRACKING = new AnonymousClass1();
    public static final SleepAction START_SLEEP_TRACKING_WITH_BATTERY_SAVING = new AnonymousClass2();
    public static final SleepAction STOP_SLEEP_TRACKING = new AnonymousClass3();
    public static final SleepAction SNOOZE_ALARM = new AnonymousClass4();
    public static final SleepAction DISMISS_ALARM = new AnonymousClass5();
    public static final SleepAction START_LULLABY = new AnonymousClass6();
    public static final SleepAction STOP_LULLABY = new AnonymousClass7();
    public static final SleepAction START_SLEEP_TRACKING_WITH_IDEAL_ALARM = new AnonymousClass8();
    public static final SleepAction SKIP_NEXT_ALARM = new AnonymousClass9();
    private static final /* synthetic */ SleepAction[] $VALUES = $values();

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.taskerplugin.SleepAction$1, reason: invalid class name */
    public enum AnonymousClass1 extends SleepAction {
        public /* synthetic */ AnonymousClass1() {
            this("START_SLEEP_TRACKING", 0, "com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK");
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public void execute(Context context) {
            Logger.logInfo("Tasker send broadcast: " + getAction());
            Intent intent = new Intent(getAction());
            intent.putExtra("MANUALY_STARTED", true);
            ContextExtKt.sendExplicitBroadcast(context, intent);
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public String getLabel(Context context) {
            return context.getString(R.string.start_sleep_tracking);
        }

        private AnonymousClass1(String str, int i, String str2) {
            super(str, i, str2, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.taskerplugin.SleepAction$2, reason: invalid class name */
    public enum AnonymousClass2 extends SleepAction {
        public /* synthetic */ AnonymousClass2() {
            this("START_SLEEP_TRACKING_WITH_BATTERY_SAVING", 1, "com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK_BATTERY");
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public void execute(Context context) {
            Intent intent = new Intent(SleepAction.START_SLEEP_TRACKING.action);
            intent.putExtra("START_IN_BATTERY_SAVING_MODE", true);
            Logger.logInfo("Tasker send broadcast: " + intent);
            ContextExtKt.sendExplicitBroadcast(context, intent);
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public String getLabel(Context context) {
            return context.getString(R.string.start_sleep_tracking) + ": " + context.getString(R.string.enable_battery_save);
        }

        private AnonymousClass2(String str, int i, String str2) {
            super(str, i, str2, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.taskerplugin.SleepAction$3, reason: invalid class name */
    public enum AnonymousClass3 extends SleepAction {
        public /* synthetic */ AnonymousClass3() {
            this("STOP_SLEEP_TRACKING", 2, "com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK");
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public String getLabel(Context context) {
            return context.getString(R.string.player_stop) + " " + context.getString(R.string.settings_category_track);
        }

        private AnonymousClass3(String str, int i, String str2) {
            super(str, i, str2, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.taskerplugin.SleepAction$4, reason: invalid class name */
    public enum AnonymousClass4 extends SleepAction {
        public /* synthetic */ AnonymousClass4() {
            this("SNOOZE_ALARM", 3, "com.urbandroid.sleep.alarmclock.ALARM_SNOOZE");
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public String getLabel(Context context) {
            return context.getString(R.string.alarm_alert_snooze_text) + " (" + context.getString(R.string.default_label).toLowerCase() + ")";
        }

        private AnonymousClass4(String str, int i, String str2) {
            super(str, i, str2, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.taskerplugin.SleepAction$5, reason: invalid class name */
    public enum AnonymousClass5 extends SleepAction {
        public /* synthetic */ AnonymousClass5() {
            this("DISMISS_ALARM", 4, "com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA");
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public String getLabel(Context context) {
            return context.getString(R.string.alarm_alert_dismiss_text) + " (" + context.getString(R.string.default_label).toLowerCase() + ")";
        }

        private AnonymousClass5(String str, int i, String str2) {
            super(str, i, str2, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.taskerplugin.SleepAction$6, reason: invalid class name */
    public enum AnonymousClass6 extends SleepAction {
        public /* synthetic */ AnonymousClass6() {
            this("START_LULLABY", 5, "com.urbandroid.sleep.ACTION_LULLABY_START_PLAYBACK");
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public void execute(Context context) {
            Intent intent = new Intent(getAction());
            intent.setClassName("com.urbandroid.sleep", "com.urbandroid.sleep.media.lullaby.LullabyService");
            intent.putExtra("extra_lullaby", "play_last");
            ContextExtKt.startForegroundServiceWithLog(context, intent);
            Logger.logInfo("Tasker start service: " + intent);
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public String getLabel(Context context) {
            return context.getString(R.string.play) + " " + context.getString(R.string.lullaby).toLowerCase() + "";
        }

        private AnonymousClass6(String str, int i, String str2) {
            super(str, i, str2, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.taskerplugin.SleepAction$7, reason: invalid class name */
    public enum AnonymousClass7 extends SleepAction {
        public /* synthetic */ AnonymousClass7() {
            this("STOP_LULLABY", 6, "com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK");
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public String getLabel(Context context) {
            return context.getString(R.string.player_stop) + " " + context.getString(R.string.lullaby).toLowerCase() + "";
        }

        private AnonymousClass7(String str, int i, String str2) {
            super(str, i, str2, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.taskerplugin.SleepAction$8, reason: invalid class name */
    public enum AnonymousClass8 extends SleepAction {
        public /* synthetic */ AnonymousClass8() {
            this("START_SLEEP_TRACKING_WITH_IDEAL_ALARM", 7, "com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK_WITH_IDEAL_ALARM_ACTION");
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public String getLabel(Context context) {
            return context.getString(R.string.start_sleep_tracking) + ": " + context.getString(R.string.ideal_alarm_label);
        }

        private AnonymousClass8(String str, int i, String str2) {
            super(str, i, str2, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.taskerplugin.SleepAction$9, reason: invalid class name */
    public enum AnonymousClass9 extends SleepAction {
        public /* synthetic */ AnonymousClass9() {
            this("SKIP_NEXT_ALARM", 8, "com.urbandroid.sleep.alarmclock.SKIP_NEXT_ALARM_ACTION_AUTO");
        }

        @Override // com.urbandroid.sleep.addon.taskerplugin.SleepAction
        public String getLabel(Context context) {
            return context.getString(R.string.disable_alarm_for_today) + " (" + context.getString(R.string.default_label).toLowerCase() + ")";
        }

        private AnonymousClass9(String str, int i, String str2) {
            super(str, i, str2, 0);
        }
    }

    private static /* synthetic */ SleepAction[] $values() {
        return new SleepAction[]{START_SLEEP_TRACKING, START_SLEEP_TRACKING_WITH_BATTERY_SAVING, STOP_SLEEP_TRACKING, SNOOZE_ALARM, DISMISS_ALARM, START_LULLABY, STOP_LULLABY, START_SLEEP_TRACKING_WITH_IDEAL_ALARM, SKIP_NEXT_ALARM};
    }

    private SleepAction(String str, int i, String str2) {
        this.action = str2;
    }

    public static SleepAction findByAction(String str) {
        for (SleepAction sleepAction : values()) {
            if (sleepAction.getAction().equals(str)) {
                return sleepAction;
            }
        }
        return null;
    }

    public static String[] getLabels(Context context) {
        SleepAction[] sleepActionArrValues = values();
        int length = sleepActionArrValues.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = sleepActionArrValues[i].getLabel(context);
        }
        return strArr;
    }

    public static SleepAction valueOf(String str) {
        return (SleepAction) Enum.valueOf(SleepAction.class, str);
    }

    public static SleepAction[] values() {
        return (SleepAction[]) $VALUES.clone();
    }

    public void execute(Context context) {
        Logger.logInfo("Tasker send broadcast: " + getAction());
        ContextExtKt.sendExplicitBroadcast(context, new Intent(getAction()));
    }

    public String getAction() {
        return this.action;
    }

    public abstract String getLabel(Context context);

    public int getPosition() {
        SleepAction[] sleepActionArrValues = values();
        for (int i = 0; i < sleepActionArrValues.length; i++) {
            if (sleepActionArrValues[i] == this) {
                return i;
            }
        }
        FacebookSdk$$ExternalSyntheticLambda1.m(this, " not found");
        return 0;
    }

    public /* synthetic */ SleepAction(String str, int i, String str2, int i2) {
        this(str, i, str2);
    }
}
