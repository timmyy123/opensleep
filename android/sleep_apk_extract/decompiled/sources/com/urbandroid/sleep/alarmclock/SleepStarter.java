package com.urbandroid.sleep.alarmclock;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.Sleep;
import com.urbandroid.sleep.SleepLockManager;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.SmartWatchActivity;
import com.urbandroid.sleep.StartTrackActivity;
import com.urbandroid.sleep.activityrecognition.ActivityIntervals;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.service.DeleteObsoleteNoisesService;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.sleep.smartwatch.fitbit.FitbitHttpServerService;
import com.urbandroid.sleep.smartwatch.zepp.ZeppHttpServerService;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SleepStarter {
    public static final Date FAR_FAR_DATE = new Date(new Date().getTime() + 1039228928);

    /* JADX INFO: Access modifiers changed from: private */
    public void startSleepServiceDirectly(Context context, Intent intent) {
        Settings settings = new Settings(context);
        if (!settings.canStartScreensFromBackground() || Build.VERSION.SDK_INT < 30 || (!settings.isRecordingMasterSwitchEnabled() && !settings.isUltrasonicTracking())) {
            ContextExtKt.startForegroundServiceWithLog(context, intent);
            return;
        }
        Logger.logInfo("AutoTracking: SleepStarter Workaround for noise recording and sonar in Android 11");
        Intent intent2 = new Intent(intent);
        intent2.setClass(context, StartTrackActivity.class);
        intent2.setPackage(context.getPackageName());
        intent2.addFlags(1417707520);
        context.startActivity(intent2);
    }

    public void autoStartSleep(Context context, ExpectedTrackingRange expectedTrackingRange, SleepRecord sleepRecord) {
        if (SleepService.isRunning()) {
            return;
        }
        Logger.logInfo("AutoTracking: autoStartSleep() starting service");
        Intent intent = new Intent(context, (Class<?>) SleepService.getServiceClass(context));
        intent.putExtra("MANUALY_STARTED", false);
        if (expectedTrackingRange != null) {
            intent.putExtra("SCHEDULED_AUTO_START", true);
        }
        expectedTrackingRange.putInto(intent);
        startSleep(context, intent, sleepRecord, false, true);
    }

    public void autoStopSleep(Context context, boolean z, ActivityIntervals activityIntervals) {
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record == null || !SleepService.isRunning() || SleepService.isStartedManually()) {
            Logger.logInfo("AutoTracking: autoStopSleep() NOT calling stop started manually");
            return;
        }
        if (z) {
            Logger.logInfo("AutoTracking: autoStopSleep() deleting record");
            if (new Settings(context).isRecordingEnabled()) {
                DeleteObsoleteNoisesService.start(context, record.getFromTime(), System.currentTimeMillis());
            }
            if (!SharedApplicationContext.getInstance().getSleepRecordRepository().deleteRecord(CurrentSleepRecord.getInstance().getRecord(), null)) {
                Logger.logInfo("AutoTracking: no record to be deleted");
            }
            try {
                CurrentSleepRecord.getInstance().invalidate();
                Intent intent = new Intent(context, (Class<?>) SleepService.getServiceClass(context));
                intent.setPackage(context.getPackageName());
                context.stopService(intent);
                return;
            } catch (Exception e) {
                Logger.logSevere("SleepStarted: STOP Failed", e);
                ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK"));
                return;
            }
        }
        Logger.logInfo("AutoTracking: autoStopSleep() calling stop");
        if (new Settings(context).isAnyAwakeDetectionEnabled()) {
            List<ActivityIntervals.Interval> intervals = activityIntervals.invert(record.getFromTime(), record.getToTime()).getIntervals();
            List<Interval> intervals2 = EventsUtil.getIntervals(record.getEvents().getCopiedEvents(), EventLabel.AWAKE_START, EventLabel.AWAKE_END);
            intervals2.addAll(EventsUtil.getIntervals(record.getEvents().getCopiedEvents(), EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED));
            intervals2.addAll(EventsUtil.getIntervals(record.getEvents().getCopiedEvents(), EventLabel.WALKING_START, EventLabel.WALKING_END));
            Logger.logInfo("AutoTracking: autoStopSleep() adding AWAKE from activity");
            for (ActivityIntervals.Interval interval : intervals) {
                Interval interval2 = new Interval(interval.getFrom(), interval.getTo());
                Iterator<Interval> it = intervals2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (interval2.hasIntersection(it.next())) {
                            break;
                        }
                    } else if (record.getInterval().contains(interval2)) {
                        long jMin = Math.min(interval2.getFrom(), interval2.getTo());
                        long jMax = Math.max(interval2.getFrom(), interval2.getTo());
                        Logger.logInfo("AutoTracking: ADD awake interval " + interval.toString());
                        record.addEventLabel(EventLabel.AWAKE_START, jMin);
                        record.addEventLabel(EventLabel.AWAKE_END, jMax);
                        intervals2.add(interval2);
                    }
                }
                Logger.logInfo("AutoTracking: DROP awake interval " + interval.toString());
            }
        }
        zza$$ExternalSyntheticOutline0.m(context, "com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK");
    }

    public void startSleep(final Context context, final Intent intent, SleepRecord sleepRecord, boolean z, boolean z2) {
        final boolean z3;
        final SleepRecord sleepRecordInitRecord;
        if (context == null) {
            Logger.logSevere("No context");
            return;
        }
        if (intent == null) {
            intent = new Intent(context, (Class<?>) Sleep.class);
            if (z) {
                intent.putExtra("MANUALY_STARTED", z);
            }
            intent.putExtra("INTENT_TIMESTAMP", System.currentTimeMillis());
            intent.setFlags(872415232);
        }
        boolean zHasExtra = intent.hasExtra("MANUALY_STARTED");
        boolean zHasExtra2 = intent.hasExtra("SCHEDULED_AUTO_START");
        Logger.logInfo("SleepStarter: Start sleep with intent. Manual: " + zHasExtra + " Auto: " + zHasExtra2);
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (zHasExtra2 && !SharedApplicationContext.getSettings().canStartScreensFromBackground() && !zHasExtra) {
            intent = new Intent(context, (Class<?>) SleepService.getServiceClass(context));
            intent.putExtra("MANUALY_STARTED", false);
            Logger.logInfo("SleepStarter: forcing manually false ");
            z2 = true;
        }
        if (record == null) {
            Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(context);
            Logger.logInfo("SleepStarter: New record required");
            if (sleepRecord != null) {
                Logger.logInfo("SleepStarter: Restoring parceled record from intent: " + sleepRecord);
                CurrentSleepRecord.getInstance().restoreRecord(sleepRecord);
                z3 = false;
            } else {
                intent.putExtra("NEW_RECORD", true);
                Logger.logInfo("SleepStarter: No record to restore");
                if (alarmCalculateNextAlert != null) {
                    sleepRecordInitRecord = CurrentSleepRecord.getInstance().initRecord(alarmCalculateNextAlert);
                } else {
                    Logger.logInfo("SleepStarter: Warning: No alarm time while starting sleep recorder");
                    sleepRecordInitRecord = CurrentSleepRecord.getInstance().initRecord(FAR_FAR_DATE);
                }
                if (sleepRecordInitRecord.getGeo() == null && !SharedApplicationContext.getSettings().isGeoOptOut()) {
                    LocationService.getLocation(context, new LocationService.LocationCallback() { // from class: com.urbandroid.sleep.alarmclock.SleepStarter.1
                        @Override // com.urbandroid.sleep.location.LocationService.LocationCallback
                        public void updateLocation(Location location) {
                            sleepRecordInitRecord.setGeo(LocationService.computeGeocell(location));
                        }
                    });
                }
                if (SharedApplicationContext.getSettings().isSnoringDetection()) {
                    sleepRecordInitRecord.setSnore(0);
                }
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (!SharedApplicationContext.getInstance().getLockManager().isUsingCpuOnlyLock()) {
            Logger.logInfo("SleepStarter: Start with non CPU lock only. Reasons...  Mode: " + SharedApplicationContext.getInstance().getLockManager().getSuspensSupportMode());
            SharedApplicationContext.getInstance().getLockManager().turnScreenOn();
        }
        boolean z4 = (SharedApplicationContext.getSettings().isLastRecordingStartedWithWatch() || sleepRecord == null) ? false : true;
        boolean z5 = SharedApplicationContext.getSettings().isSleepPhaserSleepTracking() && SharedApplicationContext.getSettings().getSleepPhaserAddress() != null;
        if (!z4 && ((SharedApplicationContext.getSettings().isSmartwatchEnabled() || z5) && SmartWatchProvider.getSmartWatch(context) == null && !SleepService.isRunning())) {
            if (new Settings(context).getSelectedWearable() == Wearable.FITBIT && !FitbitHttpServerService.INSTANCE.getRunning()) {
                FitbitHttpServerService.start(context);
            } else if (new Settings(context).getSelectedWearable() == Wearable.ZEPP && !FitbitHttpServerService.INSTANCE.getRunning()) {
                ZeppHttpServerService.start(context);
            }
            Intent intent2 = new Intent(context, (Class<?>) SmartWatchActivity.class);
            intent2.putExtras(intent);
            intent2.setFlags(intent.getFlags());
            if (!z2) {
                intent = intent2;
            }
        }
        StringBuilder sb = new StringBuilder("SleepStarter: Starting sleep tracking intent ");
        sb.append(intent.toURI());
        sb.append(" Skip smart watch: ");
        sb.append(z4);
        sb.append(" skipUI ");
        zza$$ExternalSyntheticOutline0.m(sb, z2);
        if (!z2) {
            if (Build.VERSION.SDK_INT >= 33 && !SharedApplicationContext.getInstance().getLockManager().isScreenOn()) {
                Logger.logInfo("SleepStarter: forcing screen on to fix audio recording");
                SharedApplicationContext.getInstance().getLockManager().turnScreenOn();
            }
            context.startActivity(intent);
            return;
        }
        if (SharedApplicationContext.getSettings().isSmartwatchEnabled() || SharedApplicationContext.getSettings().isSleepPhaserSleepTracking()) {
            Logger.logInfo("SleepStarter: AutoTracking: SleepStarter starting automatically with wearable");
            SmartWatchProvider.asyncSmartwatchConnect(context, new AbstractConnectivityCallback() { // from class: com.urbandroid.sleep.alarmclock.SleepStarter.2
                @Override // com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback
                public void doStatus(SmartWatch smartWatch, boolean z6) {
                    if (z6) {
                        Logger.logInfo("SleepStarter: AutoTracking: SleepStarter wearable connected " + smartWatch);
                        SleepStarter.this.startSleepServiceDirectly(context, intent);
                        return;
                    }
                    Logger.logInfo("SleepStarter: AutoTracking: SleepStarter wearable NOT connected");
                    if (z3) {
                        Logger.logWarning("SleepStarter: AutoTracking: invalidate new record");
                        CurrentSleepRecord.getInstance().invalidate();
                    }
                }
            }, 120000L, true);
            return;
        }
        Logger.logInfo("SleepStarter: AutoTracking: SleepStarter starting automatically (no wearable)");
        if (!new Settings(context).shouldBeOnChargerWhenAutoStart()) {
            intent.putExtra("MANUALY_STARTED", false);
            startSleepServiceDirectly(context, intent);
            return;
        }
        boolean zIsPluggedIn = SleepLockManager.isPluggedIn(context);
        zza$$ExternalSyntheticOutline0.m("SleepStarter: AutoTracking: charging ", zIsPluggedIn);
        if (zIsPluggedIn || !zHasExtra2) {
            intent.putExtra("MANUALY_STARTED", false);
            startSleepServiceDirectly(context, intent);
            return;
        }
        Logger.logWarning("SleepStarter: AutoTracking: SleepStarter not starting tracking,Reason: not charging");
        if (z3) {
            Logger.logWarning("SleepStarter: AutoTracking: invalidate new record");
            CurrentSleepRecord.getInstance().invalidate();
        }
    }

    public void startSleepSkipUi(Context context) {
        Intent intent = new Intent(context, (Class<?>) SleepService.getServiceClass(context));
        intent.putExtra("MANUALY_STARTED", false);
        startSleep(context, intent, null, false, true);
    }

    public void startSleepSkipUiButStartManually(Context context) {
        Intent intent = new Intent(context, (Class<?>) SleepService.getServiceClass(context));
        intent.putExtra("MANUALY_STARTED", true);
        startSleep(context, intent, null, true, true);
    }

    public void autoStartSleep(Context context, ExpectedTrackingRange expectedTrackingRange) {
        autoStartSleep(context, expectedTrackingRange, null);
    }

    public void startSleep(Context context, Intent intent, SleepRecord sleepRecord) {
        startSleep(context, intent, sleepRecord, true);
    }

    public void startSleep(Context context, Intent intent, SleepRecord sleepRecord, boolean z) {
        startSleep(context, intent, sleepRecord, z, false);
    }

    public void startSleep(Context context) {
        startSleep(context, null, null);
    }
}
