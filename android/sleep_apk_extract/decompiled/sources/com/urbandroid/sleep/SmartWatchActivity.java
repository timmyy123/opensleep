package com.urbandroid.sleep;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback;
import com.urbandroid.sleep.smartwatch.IConnectivityCallback;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.sleep.smartwatch.fitbit.FitbitHttpServerService;
import com.urbandroid.sleep.smartwatch.garmin.GarminProviderService;
import com.urbandroid.sleep.smartwatch.garmin.Utils;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaserProvider;
import com.urbandroid.sleep.smartwatch.zepp.ZeppHttpServerService;

/* JADX INFO: loaded from: classes4.dex */
public class SmartWatchActivity extends BaseActivity {
    private IConnectivityCallback connectivityCallback;
    private Handler h;
    private LinearProgressIndicator progressBar;
    private BroadcastReceiver receiver;
    private TextView selectedWearable;
    private Intent sleepTrackIntent;
    private long startTime;
    private boolean isSleepPhaser = false;
    private boolean isSensorTest = false;
    Runnable checkWatchRunnable = new AnonymousClass3();

    /* JADX INFO: renamed from: com.urbandroid.sleep.SmartWatchActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(Wearable wearable, View view) {
            SharedApplicationContext.getSettings().installWearableAddon(wearable);
        }

        @Override // java.lang.Runnable
        public void run() {
            Wearable selectedWearable;
            int i = 0;
            SmartWatchActivity.this.progressBar.setIndeterminate(false);
            SmartWatchActivity.this.progressBar.animate();
            SmartWatchActivity.this.progressBar.setProgress(((int) (System.currentTimeMillis() - SmartWatchActivity.this.startTime)) + 12000);
            SmartWatchActivity.this.progressBar.setMax(132000);
            if (SmartWatchActivity.this.findViewById(R.id.instructions) != null && System.currentTimeMillis() > SmartWatchActivity.this.startTime + 3000 && SmartWatchActivity.this.findViewById(R.id.instructions).getVisibility() == 8 && (selectedWearable = new Settings(SmartWatchActivity.this).getSelectedWearable()) != null) {
                SmartWatchActivity.this.findViewById(R.id.instructions).startAnimation(AnimationUtils.loadAnimation(SmartWatchActivity.this.getApplicationContext(), R.anim.unfade_slow));
                SmartWatchActivity.this.findViewById(R.id.instructions).setVisibility(0);
                ((TextView) SmartWatchActivity.this.findViewById(R.id.instruction_title)).setText(SmartWatchActivity.this.getString(R.string.install_button) + " " + selectedWearable.getName(SmartWatchActivity.this.getApplicationContext()) + " " + SmartWatchActivity.this.getString(R.string.addons_title).toLowerCase());
                TextView textView = (TextView) SmartWatchActivity.this.findViewById(R.id.instruction);
                int i2 = selectedWearable.descriptionRes;
                if (i2 <= 0) {
                    i2 = R.string.empty;
                }
                textView.setText(i2);
                Button button = (Button) SmartWatchActivity.this.findViewById(R.id.instruction_button);
                if (button != null) {
                    if (selectedWearable.isAddonInstalled(SmartWatchActivity.this) && selectedWearable.isVendorInstalled(SmartWatchActivity.this)) {
                        button.setVisibility(8);
                    } else {
                        button.setVisibility(0);
                        button.setOnClickListener(new SmartWatchActivity$3$$ExternalSyntheticLambda0(selectedWearable, i));
                    }
                }
            }
            if (System.currentTimeMillis() > SmartWatchActivity.this.startTime + 120000) {
                Logger.logInfo("Smartwatch: Timed out");
                SmartWatchActivity.this.h.removeCallbacks(SmartWatchActivity.this.checkWatchRunnable);
                SmartWatchActivity.this.shutdownSleepPhaser();
                StringBuilder sb = new StringBuilder("Smartwatch: timeout Starting ");
                sb.append(!SmartWatchActivity.this.isSensorTest);
                sb.append(" ");
                zza$$ExternalSyntheticOutline0.m(sb, !SmartWatchActivity.this.sleepTrackIntent.hasExtra("test_sensors"));
                if (!SmartWatchActivity.this.sleepTrackIntent.hasExtra("test_sensors")) {
                    Logger.logInfo("Smartwatch: Starting activity");
                    SmartWatchActivity smartWatchActivity = SmartWatchActivity.this;
                    smartWatchActivity.startActivity(smartWatchActivity.sleepTrackIntent);
                }
                SmartWatchActivity.this.cancelWakeupIntent();
                Toast.makeText(SmartWatchActivity.this, R.string.no_connection, 1).show();
                SmartWatchActivity.this.finish();
                return;
            }
            SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(SmartWatchActivity.this);
            SmartWatchActivity smartWatchActivity2 = SmartWatchActivity.this;
            if (smartWatch == null) {
                smartWatchActivity2.h.removeCallbacks(SmartWatchActivity.this.checkWatchRunnable);
                SmartWatchActivity.this.h.postDelayed(this, SharedApplicationContext.getSettings().getSelectedWearable() == Wearable.AUTO ? 150L : 100L);
                return;
            }
            smartWatchActivity2.h.removeCallbacks(SmartWatchActivity.this.checkWatchRunnable);
            Logger.logInfo("SmartWatchActivity: Watch connected -> Starting");
            SmartWatchActivity smartWatchActivity3 = SmartWatchActivity.this;
            smartWatchActivity3.startActivity(smartWatchActivity3.sleepTrackIntent);
            SmartWatchActivity.this.cancelWakeupIntent();
            SmartWatchActivity.this.finish();
            if (SmartWatchActivity.this.sleepTrackIntent.getBooleanExtra("MANUALY_STARTED", false) && SharedApplicationContext.getSettings().isVibeWhenConnected() && !SmartWatchActivity.this.isSleepPhaser) {
                SmartWatchProvider.getSmartWatch(SmartWatchActivity.this).hint(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelWakeupIntent() {
        PendingIntentBuilder.get(this, 234, new Intent("com.urbandroid.sleep.CHECK_WATCH_STATUS"), 134217728).cancelAlarmBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        this.h.removeCallbacks(this.checkWatchRunnable);
        Logger.logInfo("SmartWatchActivity cancel ");
        if (!SleepService.isRunning()) {
            SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
            if (smartWatch != null) {
                smartWatch.stopAlarm();
                SmartWatchProvider.releaseSmartwatch();
            }
            Settings settings = new Settings(this);
            if (settings.getSelectedWearable() == Wearable.FITBIT) {
                FitbitHttpServerService.stop(this);
            } else if (settings.getSelectedWearable() == Wearable.ZEPP) {
                ZeppHttpServerService.stop(this);
            }
            shutdownSleepPhaser();
            CurrentSleepRecord.getInstance().invalidate();
        }
        unregisterBroadcastReceiver();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
        if (smartWatch != null) {
            smartWatch.stopTracking();
            SmartWatchProvider.releaseSmartwatch();
        }
        Settings settings = new Settings(this);
        if (settings.getSelectedWearable() == Wearable.FITBIT) {
            FitbitHttpServerService.stop(this);
        } else if (settings.getSelectedWearable() == Wearable.ZEPP) {
            ZeppHttpServerService.stop(this);
        }
        Logger.logInfo("SmartWatchActivity:Track without -> Starting");
        IConnectivityCallback iConnectivityCallback = this.connectivityCallback;
        if (iConnectivityCallback != null) {
            iConnectivityCallback.cancel();
        }
        shutdownSleepPhaser();
        this.sleepTrackIntent.putExtra("track_without_smartwatch", true);
        startActivity(this.sleepTrackIntent);
        finish();
    }

    private void registerBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter("com.urbandroid.sleep.CHECK_WATCH_STATUS");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.SmartWatchActivity.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ((PowerManager) context.getSystemService("power")).newWakeLock(1, SleepLockManager.getWakeLockTag(context, "StartTemporaryLock")).acquire(10000L);
                SmartWatchActivity smartWatchActivity = SmartWatchActivity.this;
                smartWatchActivity.startActivity(smartWatchActivity.sleepTrackIntent);
                SmartWatchActivity.this.unregisterBroadcastReceiver();
                SmartWatchActivity.this.finish();
            }
        };
        this.receiver = broadcastReceiver;
        ContextCompat.registerReceiver(this, broadcastReceiver, intentFilter, 2);
    }

    private void scheduleWakeupIntent() {
        long j = this.startTime + 120000;
        PendingIntent explicitBroadcast = PendingIntentBuilder.get(this, 234, new Intent("com.urbandroid.sleep.CHECK_WATCH_STATUS"), 134217728).getExplicitBroadcast();
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        if (Build.VERSION.SDK_INT >= 31 && !alarmManager.canScheduleExactAlarms()) {
            Logger.logSevere("Cannot set EXACT alarms");
            alarmManager.set(0, j, explicitBroadcast);
        } else if (Environment.isKitKatOrGreater()) {
            alarmManager.setExact(0, j, explicitBroadcast);
        } else {
            alarmManager.set(0, j, explicitBroadcast);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownSleepPhaser() {
        if (!SharedApplicationContext.getSettings().isSleepPhaserSleepTracking() || SleepPhaserProvider.getSleepPhaser(this) == null) {
            return;
        }
        SleepPhaserProvider.discardSleepPhaser();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterBroadcastReceiver() {
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
                Logger.logSevere("SmartWatchActivity: Cannot unregister reciever");
            }
            this.receiver = null;
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_no_smart_watch);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        getSupportActionBar().setTitle(getString(R.string.smartwatch_title));
        if (getIntent() != null) {
            this.isSensorTest = getIntent().hasExtra("test_sensors");
        }
        this.selectedWearable = (TextView) findViewById(R.id.selected_wearable);
        Wearable selectedWearable = new Settings(this).getSelectedWearable();
        if (selectedWearable != null && selectedWearable != Wearable.NONE) {
            Logger.logInfo("onCreate SmartWatchActivity wearable " + selectedWearable.getName(this));
            this.selectedWearable.setText(selectedWearable.getName(this));
        }
        if (this.isSleepPhaser) {
            this.selectedWearable.setText(R.string.sleep_phaser);
        }
        this.h = new Handler();
        LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) findViewById(R.id.progress);
        this.progressBar = linearProgressIndicator;
        char c = 1;
        linearProgressIndicator.setIndeterminate(true);
        this.progressBar.animate();
        this.progressBar.setMax(132000);
        final int i = 0;
        findViewById(R.id.button_cancel).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.SmartWatchActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ SmartWatchActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = i;
                SmartWatchActivity smartWatchActivity = this.f$0;
                switch (i2) {
                    case 0:
                        smartWatchActivity.lambda$onCreate$0(view);
                        break;
                    default:
                        smartWatchActivity.lambda$onCreate$1(view);
                        break;
                }
            }
        });
        Intent intent = getIntent();
        this.sleepTrackIntent = intent;
        if (intent != null) {
            Intent intent2 = new Intent(getApplicationContext(), (Class<?>) (this.sleepTrackIntent.hasExtra("test_sensors") ? SleepTest.class : Sleep.class));
            intent2.putExtras(this.sleepTrackIntent);
            if (this.sleepTrackIntent.hasExtra("test_sensors")) {
                intent2.putExtra("test_sensors", true);
            }
            intent2.setFlags(this.sleepTrackIntent.getFlags());
            this.sleepTrackIntent = intent2;
        }
        View viewFindViewById = findViewById(R.id.button_track_without);
        final char c2 = c == true ? 1 : 0;
        viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.SmartWatchActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ SmartWatchActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = c2;
                SmartWatchActivity smartWatchActivity = this.f$0;
                switch (i2) {
                    case 0:
                        smartWatchActivity.lambda$onCreate$0(view);
                        break;
                    default:
                        smartWatchActivity.lambda$onCreate$1(view);
                        break;
                }
            }
        });
        this.connectivityCallback = new AbstractConnectivityCallback() { // from class: com.urbandroid.sleep.SmartWatchActivity.1
            @Override // com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback
            public void doStatus(SmartWatch smartWatch, boolean z) {
                if (!z) {
                    Logger.logInfo("SmartWatchActivity:No watch connected before timeout passed.");
                    return;
                }
                Logger.logInfo("SmartWatchActivity:Watch connected: " + smartWatch.getClass());
            }
        };
        Logger.logInfo("SmartWatchActivity:Async connecting smart watch ");
        SmartWatchProvider.asyncSmartwatchConnect(getApplicationContext(), this.connectivityCallback, 120000L, true);
        if (selectedWearable == Wearable.ADDON_URBANDROID_GARMIN) {
            Utils.startForegroundService(this, new Intent(this, (Class<?>) GarminProviderService.class));
        }
        this.startTime = System.currentTimeMillis();
        this.h.postDelayed(this.checkWatchRunnable, 3000L);
        scheduleWakeupIntent();
        registerBroadcastReceiver();
        boolean z = new Settings(this).isSleepPhaserSleepTracking() && SleepPhaserProvider.getSleepPhaser(this) != null;
        this.isSleepPhaser = z;
        if (!z) {
            findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_action_watch);
        } else {
            getSupportActionBar().setTitle(getString(R.string.sleep_phaser));
            findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_sleep_phaser);
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cancelWakeupIntent();
        unregisterBroadcastReceiver();
        IConnectivityCallback iConnectivityCallback = this.connectivityCallback;
        if (iConnectivityCallback != null) {
            iConnectivityCallback.cancel();
        }
        this.h.removeCallbacks(this.checkWatchRunnable);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (SleepService.isRunning()) {
            Logger.logSevere("Finishing SmartWatch activity as tracking is already running");
            finish();
        }
    }
}
