package com.urbandroid.sleep.Instructions;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.os.TaskKillerChecker;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PowerManagerCompat;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.Sleep;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.SetAlarm;
import com.urbandroid.sleep.alarmclock.directorypicker.DirectoryPicker;
import com.urbandroid.sleep.alarmclock.settings.JetLagSettingsActivity;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.jetlag.SunTimeUtil;
import com.urbandroid.sleep.media.NoiseDirectory;
import com.urbandroid.sleep.nearby.core.ConnectionStatus;
import com.urbandroid.sleep.nearby.pairtracking.PairTracking;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaser;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.SleepPermissionCompat;
import com.urbandroid.util.VolumeUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes4.dex */
public class Instructions implements View.OnClickListener {
    private Alarm alarm;
    private TextView collapse;
    private Sleep context;
    private Settings settings;
    private Long snoozeAlarmTime;
    private boolean usingPhaser;
    private boolean usingSmartwatch;
    private Map<Integer, Instruction> instructions = new HashMap();
    private boolean charger = false;
    private boolean isSensorBatching = false;
    private boolean collapsed = false;
    private String[] assholeManufacturers = {"xiaomi", "huawei", "meizu", "samsung", "oneplus", "sony", "HMD Global"};

    public static class Instruction {
        private int id;
        private View view;
        private boolean collapsible = true;
        private boolean collapsed = false;
        private boolean shown = false;
        private boolean done = false;

        private Instruction(View view) {
            this.view = view;
        }

        public static Instruction init(Activity activity, int i) {
            Instruction instruction = new Instruction(activity.findViewById(i));
            Instructions.colorFilter(activity, ((ImageView) ((ViewGroup) activity.findViewById(i)).getChildAt(0)).getDrawable());
            instruction.setId(i);
            return instruction;
        }

        private void setShown(boolean z) {
            this.shown = z;
        }

        public void done() {
            this.done = true;
            hide();
        }

        public int getId() {
            return this.id;
        }

        public View getView() {
            return this.view;
        }

        public Instruction hide() {
            getView().setVisibility(8);
            setShown(false);
            return this;
        }

        public boolean isCollapsed() {
            return this.collapsed;
        }

        public boolean isCollapsible() {
            return this.collapsible;
        }

        public boolean isDone() {
            return this.done;
        }

        public boolean isShown() {
            return this.shown;
        }

        public void setCollapsed(boolean z) {
            if (isCollapsible()) {
                this.collapsed = z;
                if (isShown()) {
                    if (z) {
                        getView().setVisibility(8);
                    } else {
                        getView().setVisibility(0);
                    }
                }
            }
        }

        public Instruction setCollapsible(boolean z) {
            this.collapsible = z;
            return this;
        }

        public void setId(int i) {
            this.id = i;
        }

        public Instruction setNotCollapsible() {
            this.collapsible = false;
            return this;
        }

        public Instruction setOnClickListener(View.OnClickListener onClickListener) {
            this.view.setOnClickListener(onClickListener);
            return this;
        }

        public Instruction show() {
            if (!isDone()) {
                if (!isCollapsed()) {
                    getView().setVisibility(0);
                }
                setShown(true);
            }
            return this;
        }
    }

    public Instructions(final Sleep sleep) {
        boolean z = false;
        this.usingSmartwatch = false;
        this.usingPhaser = false;
        this.settings = null;
        this.context = sleep;
        this.settings = new Settings(sleep);
        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(sleep);
        if (smartWatch != null && (smartWatch instanceof SleepPhaser)) {
            this.usingPhaser = true;
        }
        this.usingSmartwatch = smartWatch != null;
        Instruction onClickListener = Instruction.init(sleep, R.id.step_airplane).setOnClickListener(this);
        if (TrialFilter.getInstance().isNewUser()) {
            onClickListener.setNotCollapsible();
        }
        put(onClickListener.show());
        put(Instruction.init(sleep, R.id.step_alarm).setOnClickListener(this).setNotCollapsible().show());
        put(Instruction.init(sleep, R.id.step_recording_failed).setOnClickListener(this));
        put(Instruction.init(sleep, R.id.step_stamina).setOnClickListener(this));
        put(Instruction.init(sleep, R.id.step_batching).setOnClickListener(this));
        put(Instruction.init(sleep, R.id.step_recording_permission).setOnClickListener(this));
        put(Instruction.init(sleep, R.id.step_awake).setCollapsible(false));
        updateSonarHeadset();
        if (!this.usingSmartwatch && !SharedApplicationContext.getSettings().isUltrasonicTracking()) {
            put(Instruction.init(sleep, R.id.step_bed).setOnClickListener(this).show());
        } else if (!this.usingSmartwatch && SharedApplicationContext.getSettings().isUltrasonicTracking()) {
            put(Instruction.init(sleep, R.id.step_sonar).setOnClickListener(this).show());
            put(Instruction.init(sleep, R.id.step_sonar_volume).setOnClickListener(this).show());
        } else if (this.usingPhaser) {
            Instruction instructionInit = Instruction.init(sleep, R.id.step_sleepphaser);
            ((TextView) sleep.findViewById(R.id.step_sleepphaser_text)).setText(sleep.getString(R.string.share_connected, sleep.getString(R.string.sleep_phaser)));
            instructionInit.setOnClickListener(this).show();
            put(instructionInit);
        } else if (this.usingSmartwatch) {
            Instruction instructionInit2 = Instruction.init(sleep, R.id.step_smartwatch);
            TextView textView = (TextView) sleep.findViewById(R.id.step_smartwatch_text);
            String string = sleep.getString(R.string.smartwatch);
            Wearable selectedWearable = SharedApplicationContext.getSettings().getSelectedWearable();
            if (selectedWearable != null && selectedWearable != Wearable.NONE && selectedWearable != Wearable.AUTO) {
                string = selectedWearable.getName(sleep);
            }
            textView.setText(sleep.getString(R.string.share_connected, string));
            instructionInit2.setOnClickListener(this).show();
            put(instructionInit2);
        }
        if (this.settings.isMuteAlerts()) {
            put(Instruction.init(this.context, R.id.step_dnd_already_on).setOnClickListener(this));
        }
        put(Instruction.init(sleep, R.id.step_charger).setOnClickListener(this));
        put(Instruction.init(sleep, R.id.step_disturb).setOnClickListener(this));
        put(Instruction.init(sleep, R.id.step_killer).setOnClickListener(this));
        put(Instruction.init(sleep, R.id.step_external_not_mounted).setOnClickListener(this));
        put(Instruction.init(sleep, R.id.step_low_battery).setOnClickListener(this));
        put(Instruction.init(sleep, R.id.step_trial).setOnClickListener(this).setNotCollapsible());
        put(Instruction.init(sleep, R.id.step_jetlag).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sleep.startActivity(new Intent(sleep, (Class<?>) JetLagSettingsActivity.class));
                Instructions.this.jetlag(false);
            }
        }));
        if (PairTracking.INSTANCE.isPairTrackingSwitchedOn(sleep)) {
            Instruction instructionPut = put(Instruction.init(sleep, R.id.step_pair_tracking));
            instructionPut.setCollapsible(false);
            updatePairTrackingStatus();
            instructionPut.show();
        }
        if (SharedApplicationContext.getSettings().isJetLagPrevention()) {
            jetlag(true);
        }
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
        if (Build.VERSION.SDK_INT >= 28 && activityManager.isBackgroundRestricted() && !this.settings.isIgnoreAssholeManufacturerWarning()) {
            z = true;
        }
        if ((getAssholeManufacturer() != null || z) && !this.settings.isIgnoreAssholeManufacturerWarning()) {
            get(R.id.step_stamina).show();
        }
        if (!SleepPermissionCompat.INSTANCE.isPermissionGranted(sleep, "android.permission.RECORD_AUDIO") && SharedApplicationContext.getSettings().isDoingMicrophoneRecording()) {
            get(R.id.step_recording_permission).show();
        }
        TextView textView2 = (TextView) sleep.findViewById(R.id.collapse);
        this.collapse = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Instructions.this.collapsed = !r2.collapsed;
                Instructions instructions = Instructions.this;
                instructions.collapse(instructions.collapse, Instructions.this.collapsed);
            }
        });
        showDisturb();
        showKiller(get(R.id.step_killer));
    }

    private String buildDisturbText(Resources resources, int... iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            if (i != -1) {
                sb.append(resources.getString(i));
                sb.append(", ");
            }
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static void colorFilter(Context context, Drawable drawable) {
        if (ColorUtil.i(context, R.color.primary) == -1) {
            drawable.mutate().setColorFilter(-1291845633, PorterDuff.Mode.SRC_IN);
        } else {
            drawable.mutate().setColorFilter(new ColorMatrixColorFilter(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        }
    }

    public static void colorFilterRed(Context context, Drawable drawable) {
        drawable.mutate().setColorFilter(new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 244.0f, 0.0f, 1.0f, 0.0f, 0.0f, 67.0f, 0.0f, 0.0f, 1.0f, 0.0f, 54.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void done(int i) {
        Instruction instruction = this.instructions.get(Integer.valueOf(i));
        if (instruction != null) {
            instruction.done();
            refreshCollapsed();
        }
    }

    private Instruction get(int i) {
        return this.instructions.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAssholeManufacturer() {
        String str;
        int i = 0;
        while (true) {
            String[] strArr = this.assholeManufacturers;
            if (i >= strArr.length) {
                str = null;
                break;
            }
            str = strArr[i];
            if (SharedApplicationContext.isManufacturer(str)) {
                break;
            }
            i++;
        }
        "samsung".equals(str);
        if ("huawei".equals(str) && "Nexus 6P".equals(Build.MODEL)) {
            str = null;
        }
        if (str != null && "xiaomi".equals(str.toLowerCase()) && Build.MODEL.toLowerCase().startsWith("mi a")) {
            str = null;
        }
        if ("HMD Global".equals(str)) {
            str = "nokia";
        }
        String str2 = ("sony".equals(str) && Settings.Secure.getInt(this.context.getContentResolver(), "somc.stamina_mode", 0) == 0) ? null : str;
        if (str2 != null) {
            Logger.logInfo("Asshole manufacturer: ".concat(str2));
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDndWarning$0(View view) {
        try {
            this.context.startActivity(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"));
            this.settings.setRevertDnd(true);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        get(R.id.step_dnd_already_on).hide();
    }

    private Instruction put(Instruction instruction) {
        this.instructions.put(Integer.valueOf(instruction.getId()), instruction);
        return instruction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshCollapsed() {
        collapse(this.collapse, this.collapsed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlarmInstructionText() {
        TextView textView = (TextView) get(R.id.step_alarm).getView().findViewById(R.id.step_alarm_text);
        ImageView imageView = (ImageView) get(R.id.step_alarm).getView().findViewById(R.id.step_alarm_icon);
        textView.setText(Alarms.formatAlarmText(this.context.getApplicationContext(), this.alarm, this.snoozeAlarmTime));
        if (this.alarm == null && this.snoozeAlarmTime == null) {
            imageView.setImageResource(R.drawable.ic_alarm_plus_white);
        } else {
            imageView.setImageResource(R.drawable.ic_action_time);
        }
        Alarm alarm = this.alarm;
        if (alarm == null) {
            textView.setTextColor(ColorUtil.i(this.context, R.color.white_secondary));
            colorFilter(this.context, imageView.getDrawable());
            return;
        }
        long earliesWakeTime = alarm.getEarliesWakeTime(CurrentSleepRecord.getInstance().getRecord()) - System.currentTimeMillis();
        Sleep sleep = this.context;
        if (earliesWakeTime > TimeChart.DAY) {
            textView.setTextColor(ColorUtil.i(sleep, R.color.red));
            colorFilterRed(this.context, imageView.getDrawable());
        } else {
            textView.setTextColor(ColorUtil.i(sleep, R.color.white_secondary));
            colorFilter(this.context, imageView.getDrawable());
        }
    }

    private void show(int i) {
        Instruction instruction = this.instructions.get(Integer.valueOf(i));
        if (instruction != null) {
            instruction.show();
            refreshCollapsed();
        }
    }

    private void showKiller(Instruction instruction) {
        try {
            TaskKillerChecker taskKillerChecker = new TaskKillerChecker(this.context.getApplicationContext());
            taskKillerChecker.refreshStatus();
            Set<TaskKillerChecker.TaskKillerPackage> installedTaskKiller = taskKillerChecker.getInstalledTaskKiller();
            StringBuilder sb = new StringBuilder();
            if (installedTaskKiller == null || installedTaskKiller.size() <= 0) {
                instruction.done();
                return;
            }
            Iterator<TaskKillerChecker.TaskKillerPackage> it = installedTaskKiller.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getUserName());
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            instruction.show();
            ((TextView) this.context.findViewById(R.id.step_killer_text)).setText(this.context.getString(R.string.warn_killer_installed, sb.toString()));
        } catch (Exception unused) {
        }
    }

    public void airplaneDone() {
        get(R.id.step_airplane).done();
    }

    public void alarm(Alarm alarm, Long l) {
        this.alarm = alarm;
        this.snoozeAlarmTime = l;
        setAlarmInstructionText();
        get(R.id.step_alarm).show();
    }

    public void awake(boolean z) {
        if (z) {
            show(R.id.step_awake);
        } else {
            get(R.id.step_awake).hide();
        }
    }

    public void batteryOptimizationsDone() {
        get(R.id.step_battery_optimized).done();
    }

    public void charging(boolean z, int i) {
        Instruction instruction = get(R.id.step_charger);
        if (z || this.isSensorBatching || (i > 70 && TrialFilter.getInstance().daysUsed() > 30)) {
            if (instruction.isShown()) {
                instruction.hide();
                refreshCollapsed();
            }
        } else if (!instruction.isShown()) {
            show(R.id.step_charger);
        }
        this.charger = z;
    }

    public void collapse(TextView textView, boolean z) {
        int i = 0;
        for (Instruction instruction : this.instructions.values()) {
            if (instruction.isCollapsible()) {
                instruction.setCollapsed(z);
                if (instruction.isShown()) {
                    i++;
                }
            }
        }
        if (i <= 0) {
            textView.setText("");
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        Sleep sleep = this.context;
        if (!z) {
            Drawable drawable = ContextCompat.getDrawable(sleep, R.drawable.ic_menu_up);
            colorFilter(this.context, drawable);
            textView.setText(R.string.hide);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sleep.getString(R.string.show));
        sb.append(" +");
        sb.append(this.context.getString(R.string.xmore, Integer.valueOf(i)));
        textView.setText(sb);
        Drawable drawable2 = ContextCompat.getDrawable(this.context, R.drawable.ic_menu_down);
        colorFilter(this.context, drawable2);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void ignoreAllIgnorable() {
        if (this.collapsed) {
            return;
        }
        this.collapsed = true;
        collapse(this.collapse, true);
    }

    public boolean isAirplaneDone() {
        return get(R.id.step_airplane).isDone();
    }

    public boolean isRecordingFailed() {
        return get(R.id.step_recording_failed).isShown();
    }

    public void jetlag(boolean z) {
        Instruction instruction = get(R.id.step_jetlag);
        if (!z) {
            instruction.done();
            return;
        }
        Date remoteSunriseInLocalTime = SunTimeUtil.getRemoteSunriseInLocalTime(SharedApplicationContext.getSettings().getJetLagTargetTimezone());
        Date remoteSunsetInLocalTime = SunTimeUtil.getRemoteSunsetInLocalTime(SharedApplicationContext.getSettings().getJetLagTargetTimezone());
        if (remoteSunriseInLocalTime == null || remoteSunsetInLocalTime == null) {
            return;
        }
        ((TextView) ((ViewGroup) instruction.getView()).getChildAt(1)).setText(this.context.getString(R.string.jetlag) + " " + DateUtil.formatTime(this.context, remoteSunriseInLocalTime.getTime()) + " - " + DateUtil.formatTime(this.context, remoteSunsetInLocalTime.getTime()), TextView.BufferType.SPANNABLE);
        instruction.show();
    }

    public void lowBattery(boolean z) {
        Instruction instruction = get(R.id.step_low_battery);
        if (z) {
            if (instruction.isShown()) {
                return;
            }
            show(R.id.step_low_battery);
        } else if (instruction.isShown()) {
            instruction.hide();
            refreshCollapsed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        Instruction next;
        final com.urbandroid.sleep.service.Settings settings = new com.urbandroid.sleep.service.Settings(this.context);
        Iterator<Instruction> it = this.instructions.values().iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (next.getView().equals(view)) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        if (next == null) {
            return;
        }
        switch (next.getId()) {
            case R.id.step_airplane /* 2131363038 */:
                ViewIntent.airplane(this.context);
                done(R.id.step_airplane);
                break;
            case R.id.step_alarm /* 2131363040 */:
                Alarm alarm = this.alarm;
                if (alarm == null && this.snoozeAlarmTime == null) {
                    DialogUtil.fixButtonsAndDivider(new MaterialAlertDialogBuilder(this.context).setTitle(R.string.instructions_no_alarm).setMessage(R.string.set_alarm).setPositiveButton(R.string.add_alarm, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.12
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Instructions.this.context.startActivity(new Intent(Instructions.this.context, (Class<?>) SetAlarm.class));
                        }
                    }).setNeutralButton(R.string.schedule_ideal, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.11
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            int idealSleepMinutes = SharedApplicationContext.getSettings().getIdealSleepMinutes();
                            int smartWakeupMinutes = SharedApplicationContext.getSettings().getSmartWakeupMinutes() / 2;
                            int trackingDelay = SharedApplicationContext.getSettings().getTrackingDelay();
                            Alarms.addQuickAlarm(view.getContext(), idealSleepMinutes + smartWakeupMinutes + (trackingDelay > 60000 ? trackingDelay / 60000 : 0), view.getContext().getString(R.string.ideal_alarm_label), false);
                            Instructions instructions = Instructions.this;
                            instructions.snoozeAlarmTime = Alarms.isSnoozing(instructions.context) ? Long.valueOf(Alarms.getSnoozeTime(Instructions.this.context)) : null;
                            Instructions instructions2 = Instructions.this;
                            instructions2.alarm = Alarms.calculateNextAlert(instructions2.context);
                            Instructions instructions3 = Instructions.this;
                            instructions3.alarm(instructions3.alarm, Instructions.this.snoozeAlarmTime);
                            Instructions.this.context.refreshAlarm(Instructions.this.alarm, Instructions.this.snoozeAlarmTime);
                            Instructions.this.setAlarmInstructionText();
                        }
                    }).setNegativeButton(R.string.instructions_ignore, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.10
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Instructions.this.done(R.id.step_alarm);
                        }
                    }).show(), R.color.white);
                } else if (alarm != null) {
                    SetAlarm.showSetAlarmActivity(this.context, alarm.id, false);
                }
                break;
            case R.id.step_battery_optimized /* 2131363047 */:
                if (!Experiments.getInstance().useAndroidMDozeHackForegroundService() && Environment.isMOrGreater()) {
                    PowerManagerCompat.requestIgnoreBatteryOptimizations(this.context);
                } else {
                    DialogUtil.fixButtonsAndDivider(new MaterialAlertDialogBuilder(this.context).setIcon(R.drawable.ic_battery_60_white).setTitle(R.string.sensor_batching_title).setMessage(R.string.step_battery_optimized).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            settings.setBatteryOptimized(true);
                            Instructions.this.done(R.id.step_battery_optimized);
                        }
                    }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Instructions.this.done(R.id.step_battery_optimized);
                        }
                    }).show(), R.color.white);
                }
                break;
            case R.id.step_charger /* 2131363051 */:
                DialogUtil.fixButtonsAndDivider(new MaterialAlertDialogBuilder(this.context).setIcon(R.drawable.ic_battery_60_white).setTitle(R.string.instructions_not_charging).setMessage(R.string.step_charger).setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).setNegativeButton(R.string.instructions_ignore, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Instructions.this.done(R.id.step_charger);
                    }
                }).show(), R.color.white);
                break;
            case R.id.step_recording_failed /* 2131363067 */:
                if (Environment.isLollipopOrGreater()) {
                    DirectoryPicker.open(this.context, 111);
                    if (new NoiseDirectory(this.context.getApplicationContext()).isContentUriDirAccessible()) {
                        next.done();
                        refreshCollapsed();
                    }
                }
                break;
            case R.id.step_recording_permission /* 2131363069 */:
                SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
                if (!sleepPermissionCompat.isPermissionGranted(this.context, "android.permission.RECORD_AUDIO")) {
                    sleepPermissionCompat.requestPermission(this.context, "android.permission.RECORD_AUDIO", 123);
                }
                next.done();
                refreshCollapsed();
                break;
            case R.id.step_stamina /* 2131363083 */:
                DialogUtil.fixButtonsAndDivider(new MaterialAlertDialogBuilder(this.context).setTitle(R.string.advice_caution).setMessage(R.string.step_problematic_manufacturer).setPositiveButton(R.string.addons_install, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.9
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Instructions.this.done(R.id.step_stamina);
                        Instructions.this.refreshCollapsed();
                        String assholeManufacturer = Instructions.this.getAssholeManufacturer();
                        if (assholeManufacturer == null) {
                            assholeManufacturer = "";
                        }
                        ViewIntent.url(Instructions.this.context, "https://dontkillmyapp.com/".concat(assholeManufacturer));
                    }
                }).setNeutralButton(R.string.never, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.8
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Instructions.this.done(R.id.step_stamina);
                        Instructions.this.refreshCollapsed();
                        settings.setIgnoreAssholeManufacturerWarning();
                    }
                }).setNegativeButton(R.string.instructions_ignore, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.Instructions.Instructions.7
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Instructions.this.done(R.id.step_stamina);
                        Instructions.this.refreshCollapsed();
                    }
                }).show(), R.color.white);
                break;
            case R.id.step_trial /* 2131363085 */:
                Intent intent = new Intent(this.context, (Class<?>) AlarmClock.class);
                intent.putExtra("com.urbandroid.sleep.START_UNLOCK_CLOUD_PURCHASE", true);
                this.context.startActivity(intent);
                next.done();
                refreshCollapsed();
                break;
            default:
                next.done();
                refreshCollapsed();
                break;
        }
    }

    public void showDisturb() {
        Resources resources = this.context.getResources();
        int i = -1;
        int i2 = SharedApplicationContext.getSettings().isJetLagPrevention() ? R.string.jetlag : -1;
        int i3 = SharedApplicationContext.getSettings().getLucidEnabled() ? R.string.settings_category_lucid_title : -1;
        if (SharedApplicationContext.getSettings().isRecordingMasterSwitchEnabled() && SharedApplicationContext.getSettings().getRecordingAntisnore()) {
            i = R.string.anti_snoring_title;
        }
        String strBuildDisturbText = buildDisturbText(resources, i2, i3, i);
        if (strBuildDisturbText != null) {
            Instruction instruction = get(R.id.step_disturb);
            instruction.show();
            ((TextView) ((ViewGroup) instruction.getView()).getChildAt(1)).setText(Html.fromHtml(this.context.getResources().getString(R.string.step_disturb, FileInsert$$ExternalSyntheticOutline0.m("<b>", strBuildDisturbText, "</b>"))), TextView.BufferType.SPANNABLE);
        }
    }

    public void showDndWarning() {
        if (get(R.id.step_dnd_already_on) != null) {
            boolean zIsNotificationPolicyAccessGranted = ((NotificationManager) this.context.getSystemService("notification")).isNotificationPolicyAccessGranted();
            if (!this.settings.isMuteAlerts() || zIsNotificationPolicyAccessGranted) {
                if (!this.settings.isMuteAlerts() || this.settings.isRevertDnd()) {
                    get(R.id.step_dnd_already_on).hide();
                    return;
                } else {
                    ((TextView) get(R.id.step_dnd_already_on).view.findViewById(R.id.step_dnd_already_on_text)).setText(R.string.step_dnd_already_on);
                    get(R.id.step_dnd_already_on).show();
                    return;
                }
            }
            ((TextView) get(R.id.step_dnd_already_on).view.findViewById(R.id.step_dnd_already_on_text)).setText(this.context.getString(R.string.no_permission) + " (" + this.context.getString(R.string.mute_alerts_summary) + ")");
            get(R.id.step_dnd_already_on).setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 4));
            get(R.id.step_dnd_already_on).show();
        }
    }

    public void showRecordingFailed() {
        show(R.id.step_recording_failed);
        this.context.findViewById(R.id.recording_parent).setVisibility(8);
    }

    public void showSonarRecordingInitializationFailed() {
        show(R.id.step_sonar_headphones);
        this.context.findViewById(R.id.recording_parent).setVisibility(8);
    }

    public void trial(boolean z) {
        if (z) {
            show(R.id.step_trial);
        } else {
            done(R.id.step_trial);
        }
    }

    public void updatePairTrackingStatus() {
        TextView textView = (TextView) this.context.findViewById(R.id.step_pair_tracking_text);
        if (textView != null) {
            ConnectionStatus connectionStatus = PairTracking.INSTANCE.getConnectionStatus();
            ConnectionStatus connectionStatus2 = ConnectionStatus.CONNECTED;
            Sleep sleep = this.context;
            textView.setText(connectionStatus == connectionStatus2 ? sleep.getString(R.string.share_connected, sleep.getString(R.string.pair_tracking)) : sleep.getString(R.string.share_disconnected, sleep.getString(R.string.pair_tracking)));
        }
    }

    public void updateSonarHeadset() {
        if (!new com.urbandroid.sleep.service.Settings(this.context).isUltrasonicTracking() || this.usingSmartwatch) {
            return;
        }
        if (get(R.id.step_sonar_headphones) == null) {
            put(Instruction.init(this.context, R.id.step_sonar_headphones).setOnClickListener(this).setNotCollapsible());
        }
        AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
        if (VolumeUtil.getHeadsetState(this.context) > 0) {
            Logger.logInfo("Instructions: headphones ");
            get(R.id.step_sonar_headphones).show();
            return;
        }
        get(R.id.step_sonar_headphones).hide();
        if (Environment.isMOrGreater()) {
            audioManager.getRingerMode();
            NotificationManager notificationManager = (NotificationManager) this.context.getSystemService("notification");
            Logger.logInfo("Instructions: DND " + notificationManager.getCurrentInterruptionFilter());
            if (notificationManager.getCurrentInterruptionFilter() == 3) {
                get(R.id.step_sonar_headphones).show();
            }
        }
    }
}
