package com.urbandroid.sleep.alarmclock;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.error.DefaultConfigurationBuilder;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.CryptoUtil;
import com.urbandroid.common.util.CustomCrashInfoProvider;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.wifi.WifiEnabler;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.addon.taskerplugin.TaskerPlugin;
import com.urbandroid.sleep.ads.IAdsController;
import com.urbandroid.sleep.autostart.AutoTrackingScheduler;
import com.urbandroid.sleep.media.mode.RingerModeUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.automation.AutomationReceiver;
import com.urbandroid.sleep.service.google.calendar.GoogleCalendarChangeReceiver;
import com.urbandroid.sleep.service.refferer.ReferrerCheck;
import com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager;
import com.urbandroid.sleep.trial.CheckReceiver;
import com.urbandroid.sleep.trial.eu.LocationUtils;
import com.urbandroid.util.Experiments;
import java.util.Arrays;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GlobalInitializator {
    private static boolean alreadyInitialized = false;
    private static Handler handler = null;
    private static long initTs = -1;

    private static int findNearestMatchingGradualVibration(Settings settings, int i) {
        if (settings.getGradualVolumeIncreaseDuration() <= 0) {
            return 0;
        }
        int gradualVolumeIncreaseDuration = (settings.getGradualVolumeIncreaseDuration() * i) / 100;
        int[] iArr = {1440000, 1080000, 720000, 540000, 360000, 180000, 60000};
        for (int i2 = 0; i2 < 7; i2++) {
            int i3 = iArr[i2];
            if (i3 < gradualVolumeIncreaseDuration) {
                return i3;
            }
        }
        return 0;
    }

    public static synchronized boolean initializeIfRequired(Context context, Handler handler2, boolean z) {
        boolean z2;
        try {
            if (alreadyInitialized) {
                return false;
            }
            initTs = System.currentTimeMillis();
            Context applicationContext = context.getApplicationContext();
            if (!Logger.isInitialized()) {
                Logger.setFiltersEnabled(true);
                Logger.initialize(applicationContext, "SleepAsAndroid", 1, 1, new Logger.LogConfig[0]);
            }
            if (Looper.myLooper() == null) {
                Looper.prepare();
                Logger.logInfo("New looper prepared: " + Looper.myLooper());
            }
            WifiEnabler.initialize(applicationContext);
            String currentProcessName = Environment.getCurrentProcessName(applicationContext);
            if (currentProcessName == null || applicationContext.getPackageName().equals(currentProcessName)) {
                z2 = true;
            } else {
                Logger.logInfo("Initializing for non-main process: ".concat(currentProcessName));
                z2 = false;
            }
            if (z2) {
                Logger.logInfo("Permissions: Android SDK_INT " + Build.VERSION.SDK_INT);
                Logger.logInfo("Permissions: Android CODENAME " + Build.VERSION.CODENAME);
            }
            if (z2) {
                Logger.logInfo("Permissions: Android M");
            }
            if (handler2 != null) {
                handler = handler2;
            } else {
                try {
                    handler = new Handler();
                } catch (Exception unused) {
                    Logger.logSevere("Failed to create handler and it was not provided! App may be broken!");
                }
            }
            ErrorReporter.initialize(applicationContext, new DefaultConfigurationBuilder.Builder(applicationContext, handler, "Sleep", new String[]{"urbandroid.info@gmail.com"}).withAdditionalDataProvider(new CustomCrashInfoProvider(applicationContext)).withLockupDatection(false).build());
            ErrorReporter.getInstance().getExceptionHandler().addNonFatalThread("GAThread");
            for (int i = 1; i <= 12; i++) {
                ErrorReporter.getInstance().getExceptionHandler().addNonFatalThread("AdWorker #" + i);
            }
            ErrorReporter.getInstance().getExceptionHandler().addNonFatalThread("disconnect check");
            ErrorReporter.getInstance().getExceptionHandler().addNonFatalThread("Service Reconnect");
            Experiments.initialize(applicationContext);
            SharedApplicationContext.initialize(applicationContext, z2);
            Logger.logInfo("Global structures initialized: " + new Date());
            if (z2) {
                initializeOnMainProcessOnly(applicationContext, z);
            }
            Settings settings = new Settings(applicationContext);
            new ReferrerCheck().checkReferrer(applicationContext);
            SleepTimeSuggestionManager.Mode sleepTimeSuggestionMode = settings.getSleepTimeSuggestionMode();
            SleepTimeSuggestionManager.Mode mode = SleepTimeSuggestionManager.Mode.DISABLED;
            if (sleepTimeSuggestionMode != mode || settings.getAutoStartMode() == 1) {
                ActivityRecognitionInitializer.transitions(applicationContext).initialize();
            }
            if (settings.getAutoStartMode() == 1) {
                AutoTrackingScheduler.schedule(applicationContext);
            }
            alreadyInitialized = true;
            if (settings.getSleepTimeSuggestionMode() != mode) {
                new SleepTimeSuggestionManager(applicationContext).schedule();
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void initializeOnMainProcessOnly(Context context, boolean z) {
        int i;
        TrialFilter.getInstance().initialize(context);
        try {
            TrialFilter.getInstance().reevaluate();
        } catch (SecurityException unused) {
            Logger.logSevere("Cannot reevaluate trial, no permission, probably called from content provider.");
        }
        Logger.logInfo("TrialFilter: initialize " + TrialFilter.getInstance().isTrial());
        if (TrialFilter.getInstance().isTrial()) {
            Logger.logInfo("TrialFilter: initialize " + TrialFilter.getInstance().isTrial());
            if (IAdsController.isEligibleForAds(context)) {
                AdSettings.addTestDevice("1ba600e3-de3d-453f-8538-bccfb5ae78fe");
                AdSettings.addTestDevice("e7a512d0-f4ee-43ee-8141-3bd49dc89c08");
                AdSettings.addTestDevice("d5617e3a-e652-4ddc-a16a-e4502d96a817");
                AudienceNetworkAds.buildInitSettings(context).withInitListener(new UnlockFlow$1$$ExternalSyntheticLambda0()).initialize();
                MobileAds.initialize(context, new GlobalInitializator$$ExternalSyntheticLambda1());
                MobileAds.setRequestConfiguration(new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("F4A20E71FD213C94AC9093D2405DFE19", "98C4F04E409732EF0B3C1E74BD096C4E", "B3EEABB8EE11C2BE770B684D95219ECB")).build());
            }
            try {
                FacebookSdk.setAutoInitEnabled(true);
                FacebookSdk.setAdvertiserIDCollectionEnabled(true);
                FacebookSdk.setAutoLogAppEventsEnabled(true);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        } else {
            try {
                FacebookSdk.setAutoInitEnabled(false);
                FacebookSdk.setAdvertiserIDCollectionEnabled(false);
                FacebookSdk.setAutoLogAppEventsEnabled(false);
            } catch (Exception e2) {
                Logger.logSevere(e2);
            }
        }
        FirebaseAnalytics.getInstance(context).setAnalyticsCollectionEnabled(FirebaseAnalyticsManager.canEnableAnalyticsGlobally(context));
        Settings settings = new Settings(context, z);
        migratePreferences(context, settings);
        RingerModeUtil.resetAlarmSilentSettings(context, settings);
        try {
            long jUpdateLastAppStartedTime = settings.updateLastAppStartedTime(System.currentTimeMillis());
            if (jUpdateLastAppStartedTime == 0 || jUpdateLastAppStartedTime + 3600000 < System.currentTimeMillis()) {
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventAppStarted();
            }
            try {
                i = context.getPackageManager().getPackageInfo("com.urbandroid.sleep.full.key", 0).versionCode;
            } catch (Exception unused2) {
                i = -1;
            }
            if (i >= 10 && i >= 35 && !CheckReceiver.isAlreadyChecked() && settings.getLicenseChecker() != 256) {
                Intent intent = new Intent("com.urbandroid.sleep.CHECK_L");
                intent.addFlags(32);
                intent.setPackage("com.urbandroid.sleep.full.key");
                Logger.logInfo("Sending com.urbandroid.sleep.CHECK_L");
                context.sendBroadcast(intent);
            }
            try {
                GoogleCalendarChangeReceiver.setEnabled(context, settings.isGoogleCalendar());
            } catch (Exception e3) {
                Logger.logSevere(e3);
            }
            try {
                AutomationReceiver.setEnabled(context, true);
            } catch (Exception e4) {
                Logger.logSevere(e4);
            }
            try {
                TaskerPlugin.enable(context, settings.isTasker());
            } catch (Exception e5) {
                Logger.logSevere(e5);
            }
            if (settings.getActualDefaultRingtoneUri() == null) {
                DefaultRingtoneResolveService.start(context);
            }
            LocationUtils.updateCountryAsync(context);
        } catch (Exception e6) {
            Logger.logSevere(e6);
        }
    }

    public static boolean isInitRecently() {
        return initTs == -1 || System.currentTimeMillis() - initTs < 120000;
    }

    private static void migratePreferences(Context context, Settings settings) {
        int i;
        if (settings.isPrefMigrationNeeded()) {
            if (!settings.isDefaultLegacyRecordingThreshold()) {
                settings.setRecordingThreshold(settings.getLegacyRecordingThreshold() * 10);
            }
            if (settings.getAirplaneMode() == -1) {
                settings.setAutoAirplaneMode(false);
            }
            if (!settings.isLegacyGradualVolumeIncrease()) {
                settings.setGradualVolumeIncreaseDuration(-1);
            }
            if (!settings.isLegacyPublicComment()) {
                settings.setPublicComment(false);
            }
        }
        settings.resetAutomationEvents();
        if (settings.isAlarmInSilentResetNeeded()) {
            settings.setAlarmInSilent(true);
        }
        try {
            i = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString("alarm_increasing_volume_speed", "-1"));
        } catch (NumberFormatException unused) {
            i = -1;
        }
        if (i != -1) {
            String strValueOf = String.valueOf(i * 12);
            String[] stringArray = context.getResources().getStringArray(R.array.alarm_increasing_volume_duration_values);
            int length = stringArray.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    strValueOf = "60000";
                    break;
                } else if (stringArray[i2].equals(strValueOf)) {
                    break;
                } else {
                    i2++;
                }
            }
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editorEdit.putString("alarm_increasing_volume_duration", strValueOf);
            editorEdit.putString("alarm_increasing_volume_speed", "-1");
            editorEdit.apply();
            Logger.logInfo("Migrating old gradual volume increase. From: " + i + " to " + strValueOf);
        }
        String prefString = settings.getPrefString("qr_captcha_code", "");
        if (prefString != null && prefString.length() > 0) {
            SharedPreferences.Editor editorEdit2 = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editorEdit2.putString("qr_captcha_code", "");
            editorEdit2.putString("qr_captcha_code_new", CryptoUtil.md5(prefString.replaceAll("\\s", "")));
            editorEdit2.apply();
        }
        String prefString2 = settings.getPrefString("nfc_captcha_code", "");
        if (prefString2 != null && prefString2.length() > 0) {
            SharedPreferences.Editor editorEdit3 = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editorEdit3.putString("nfc_captcha_code", "");
            editorEdit3.putString("nfc_captcha_code_new", CryptoUtil.md5(prefString2));
            editorEdit3.apply();
        }
        if (settings.isFirstUsage()) {
            Logger.logInfo("First use -> migration");
            settings.setUseFlashlight(false);
            settings.setAutoStartLegacy(false);
        } else {
            String prefString3 = settings.getPrefString("alarm_with_flashlight_internal", "");
            if (prefString3 == null || prefString3.length() == 0) {
                Logger.logInfo("Migrate flashlight to -> " + settings.isUseFlashlightLegacy());
                settings.setUseFlashlight(settings.isUseFlashlightLegacy());
            }
        }
        if (settings.getTimeDifference() == 0) {
            settings.setTimeDifference();
        }
        if (settings.getGradualVibrationLegacy() != -100) {
            int gradualVibrationLegacy = settings.getGradualVibrationLegacy();
            int iFindNearestMatchingGradualVibration = findNearestMatchingGradualVibration(settings, gradualVibrationLegacy);
            zza$$ExternalSyntheticOutline0.m(gradualVibrationLegacy, iFindNearestMatchingGradualVibration, "Migrating gradual vibration from ", " to ");
            settings.setGradualVibration(iFindNearestMatchingGradualVibration);
            settings.resetVibrationLegacy();
        }
        if (settings.getGradualVibrationSmartwatchLegacy() != -100) {
            int gradualVibrationSmartwatchLegacy = settings.getGradualVibrationSmartwatchLegacy();
            int iFindNearestMatchingGradualVibration2 = findNearestMatchingGradualVibration(settings, gradualVibrationSmartwatchLegacy);
            zza$$ExternalSyntheticOutline0.m(gradualVibrationSmartwatchLegacy, iFindNearestMatchingGradualVibration2, "Migrating gradual vibration smartwatch from ", " to ");
            settings.setGradualVibrationSmartwatch(iFindNearestMatchingGradualVibration2);
            settings.resetVibrationSmartwtchLegacy();
        }
        if (settings.getGradualVibration() == -20000) {
            settings.setGradualVibration(0);
            settings.setSoundDelay(60000);
        }
        if (settings.getGradualVibrationSmartwatch() == -20000) {
            settings.setGradualVibrationSmartwatch(0);
            settings.setSoundDelay(60000);
        }
    }

    public static synchronized boolean initializeIfRequired(Context context, boolean z) {
        return initializeIfRequired(context, null, false);
    }

    public static synchronized boolean initializeIfRequired(Context context, Handler handler2) {
        return initializeIfRequired(context, handler2, false);
    }

    public static synchronized boolean initializeIfRequired(Context context) {
        return initializeIfRequired(context, (Handler) null);
    }
}
