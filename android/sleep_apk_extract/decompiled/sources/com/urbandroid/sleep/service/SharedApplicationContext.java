package com.urbandroid.sleep.service;

import android.content.Context;
import android.os.Build;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.os.BatteryMonitor;
import com.urbandroid.common.os.GatherDataAndReportExcessAction;
import com.urbandroid.sleep.SleepLockManager;
import com.urbandroid.sleep.SleepRestarter;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.captcha.BaseCaptchaManager;
import com.urbandroid.sleep.captcha.CaptchaManager;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.share.CommonShareService;
import com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager;
import com.urbandroid.sleep.share.twitter.TwitterAPI;
import java.util.Date;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class SharedApplicationContext {
    private static CaptchaManager captchaManager;
    private static Context context;
    private static SharedApplicationContext instance;
    private static Settings settings;
    private GatherDataAndReportExcessAction batteryExcessAction;
    private final BatteryMonitor batteryMonitor;
    private FirebaseAnalyticsManager firebaseAnalyticsManager;
    private IFlashlightService flashlightService;
    private final SleepLockManager lockManager;
    private final CommonShareService shareService;
    private DbSleepRecordRepository sleepRecordRepository;
    private final SleepRestarter sleepRestarter;

    private SharedApplicationContext(boolean z) {
        DbSleepRecordRepository dbSleepRecordRepository = new DbSleepRecordRepository(context);
        this.sleepRecordRepository = dbSleepRecordRepository;
        dbSleepRecordRepository.initialize();
        this.shareService = new CommonShareService(new TwitterAPI());
        if (z) {
            Alarms.clearExpiredSnooze(context, new Date().getTime());
            try {
                Alarms.setNextAlert(context);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        this.sleepRestarter = new SleepRestarter(context, true);
        this.firebaseAnalyticsManager = new FirebaseAnalyticsManager(context);
        GatherDataAndReportExcessAction gatherDataAndReportExcessAction = new GatherDataAndReportExcessAction();
        this.batteryExcessAction = gatherDataAndReportExcessAction;
        this.batteryMonitor = new BatteryMonitor(58, gatherDataAndReportExcessAction);
        this.lockManager = new SleepLockManager(context);
    }

    public static CaptchaManager getCaptchaManager() {
        Context context2 = context;
        if (context2 == null) {
            Types$$ExternalSyntheticBUOutline0.m$2("Cannot get captcha manager, until a global context is set via \"initialize\"");
            return null;
        }
        if (captchaManager == null) {
            captchaManager = new BaseCaptchaManager(context2.getApplicationContext());
        }
        return captchaManager;
    }

    public static synchronized SharedApplicationContext getInstance() {
        if (context == null) {
            throw new RuntimeException("Cannot get shared context instance, until a global context is set via \"initialize\"");
        }
        return instance;
    }

    public static Settings getSettings() {
        if (context == null) {
            Types$$ExternalSyntheticBUOutline0.m$2("Cannot get settings, until a global context is set via \"initialize\"");
            return null;
        }
        if (settings == null) {
            settings = new Settings(context);
        }
        return settings;
    }

    public static synchronized void initialize(Context context2, boolean z) {
        Context applicationContext = context2.getApplicationContext();
        context = applicationContext;
        if (applicationContext == null) {
            throw new RuntimeException("Cannot initialize SharedAppContext with null context.");
        }
        StringBuilder sb = new StringBuilder("SAC: Initializing SharedAppContext, new context: ");
        sb.append(!context2.equals(context));
        Logger.logInfo(sb.toString());
        if (instance == null) {
            instance = new SharedApplicationContext(z);
        }
    }

    public static synchronized boolean isInitialized() {
        return context != null;
    }

    public static boolean isManufacturer(String str) {
        String str2;
        return (str == null || (str2 = Build.MANUFACTURER) == null || !str2.equalsIgnoreCase(str)) ? false : true;
    }

    public void decPendingDbOperations() {
        this.sleepRecordRepository.decPendingOperations();
    }

    public void deleteRecord(SleepRecord sleepRecord, UndoOperationGroup undoOperationGroup) {
        this.sleepRecordRepository.deleteRecord(sleepRecord, undoOperationGroup);
    }

    public String getAndResetBatteryErrorReport() {
        GatherDataAndReportExcessAction gatherDataAndReportExcessAction = this.batteryExcessAction;
        if (gatherDataAndReportExcessAction == null || gatherDataAndReportExcessAction.getReportText() == null) {
            return null;
        }
        String reportText = this.batteryExcessAction.getReportText();
        this.batteryExcessAction = null;
        return reportText;
    }

    public Context getContext() {
        return context;
    }

    public FirebaseAnalyticsManager getFirebaseAnalyticsManager() {
        return this.firebaseAnalyticsManager;
    }

    public IFlashlightService getFlashlightService() {
        if (this.flashlightService == null) {
            this.flashlightService = new FlashlightServiceAndroidM(getContext());
        }
        return this.flashlightService;
    }

    public SleepLockManager getLockManager() {
        return this.lockManager;
    }

    public CommonShareService getShareService() {
        return this.shareService;
    }

    public DbSleepRecordRepository getSleepRecordRepository() {
        return this.sleepRecordRepository;
    }

    public SleepRestarter getSleepRestarter() {
        return this.sleepRestarter;
    }

    public void incPendingDbOperations() {
        this.sleepRecordRepository.incPendingOperations();
    }

    public void recordDataUpdated(SleepRecord sleepRecord, SleepRecord sleepRecord2, UndoOperationGroup undoOperationGroup) {
        this.sleepRecordRepository.recordDataUpdated(sleepRecord, sleepRecord2, undoOperationGroup);
    }

    public void recordRatingUpdated(SleepRecord sleepRecord, SleepRecord sleepRecord2, UndoOperationGroup undoOperationGroup) {
        this.sleepRecordRepository.recordRatingUpdated(sleepRecord, sleepRecord2, undoOperationGroup);
    }

    public void saveNewSleepRecord(SleepRecord sleepRecord, UndoOperationGroup undoOperationGroup) {
        this.sleepRecordRepository.addNewSleepRecord(sleepRecord, undoOperationGroup);
    }
}
