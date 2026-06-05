package com.urbandroid.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PowerManagerCompat;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class Experiments {
    private static Experiments instance;
    private final Context context;
    private String cachedAndroidId = null;
    private String cachedImei = null;
    private final long experimentsSeed = getExperimentsSeed();

    private Experiments(Context context) {
        this.context = context;
    }

    private String getAndroidId() {
        if (this.cachedAndroidId == null) {
            try {
                this.cachedAndroidId = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        return this.cachedAndroidId;
    }

    private long getExperimentSeedPreference() {
        return PreferenceManager.getDefaultSharedPreferences(this.context).getLong("experiments_seed_pref_fixed", 0L);
    }

    private long getExperimentsSeed() {
        long experimentSeedPreference = getExperimentSeedPreference();
        if (experimentSeedPreference == 0) {
            String androidId = getAndroidId();
            if (androidId != null) {
                experimentSeedPreference = Math.abs(androidId.hashCode());
            }
            if (experimentSeedPreference == 0) {
                experimentSeedPreference = Math.abs(System.currentTimeMillis());
            }
            setExperimentSeedPreference(experimentSeedPreference);
        }
        return experimentSeedPreference;
    }

    private String getImei() {
        if (this.cachedImei == null && Build.VERSION.SDK_INT < 29 && SleepPermissionCompat.INSTANCE.isPermissionGranted(this.context, "android.permission.READ_PHONE_STATE")) {
            this.cachedImei = Environment.getImei(this.context);
        }
        return this.cachedImei;
    }

    public static synchronized Experiments getInstance() {
        return instance;
    }

    public static synchronized void initialize(Context context) {
        instance = new Experiments(context);
    }

    public static synchronized void initializeIfRequired(Context context) {
        if (instance == null) {
            instance = new Experiments(context);
        }
    }

    private boolean isJanMarekTemporaryTestingPhone() {
        return isTestingNexusLGPhone() || isTestingSamsungGT19300Phone() || isTestingSamsungS5Phone() || isSamsungNexus4SHealthPhone();
    }

    private boolean isMartinPhone() {
        return matchImei("358350040886951");
    }

    private boolean isNeveceralPhone() {
        return matchImei("356591076477692");
    }

    private boolean isPetrPhone() {
        return matchAndroidId("a5323cec814932da") || matchAndroidId("0a703f5423ab0828");
    }

    private boolean isSamsungNexus4SHealthPhone() {
        return matchImei("357506059489448");
    }

    private boolean isTestGroup(int i, int i2) {
        return Math.abs(this.experimentsSeed + ((long) i)) % 100 < ((long) i2);
    }

    private boolean isTestGroupOrBeta(int i, int i2) {
        return isBeta() || isTestGroup(i, i2);
    }

    private boolean isTestingNexusLGPhone() {
        return matchImei("358240052609872");
    }

    private boolean isTestingSamsungGT19300Phone() {
        return matchImei("355994052822611");
    }

    private boolean isTestingSamsungS5Phone() {
        return matchAndroidId("b1e9d00dc106e037");
    }

    private boolean isWitekKruzsynaPhone() {
        return matchImei("356144085504674");
    }

    private boolean matchAndroidId(String str) {
        return getAndroidId() != null && getAndroidId().equals(str);
    }

    private boolean matchImei(String str) {
        return getImei() != null && getImei().equals(str);
    }

    private void setExperimentSeedPreference(long j) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
        editorEdit.putLong("experiments_seed_pref_fixed", j);
        editorEdit.apply();
    }

    public Set<String> getActiveExperiments() {
        HashSet hashSet = new HashSet();
        if (isOptedOut()) {
            hashSet.add("OPT-OUT");
        }
        if (isAliveLoggingExperiment()) {
            hashSet.add("Alive logging");
        }
        if (isRestartingAlarmDialogExperiment2()) {
            hashSet.add("restarting alarm dialog 2");
        }
        if (isNewDndExperiment()) {
            hashSet.add("Samsung DND");
        }
        if (isReliableAlarmExperiment()) {
            hashSet.add("Reliable alarm");
        }
        if (isTensorflowV3()) {
            hashSet.add("Tensorflow sound classification V3");
        }
        if (isTensorflowV4()) {
            hashSet.add("Tensorflow sound classification V4");
        }
        if (isRespiratoryDetailsPersistentExperiment()) {
            hashSet.add("Detailed respiratory data logging");
        }
        if (isActivityPersistentExperiment()) {
            hashSet.add("Persisting actigraphic data (10s)");
        }
        if (isRawActigraphyPersistentExperiment()) {
            hashSet.add("Persisting RAW actigraphic data");
        }
        if (isRawBleHrDataPersistentExperiment()) {
            hashSet.add("Persisting RAW HR/RR/SPO2 data");
        }
        if (isActigraphyImprovementsExperiment2()) {
            hashSet.add("Actigraphy improvements 2");
        }
        if (isActigraphyImprovementsExperiment3()) {
            hashSet.add("Actigraphy improvements 3");
        }
        if (isBrokenMediaCodecDevice()) {
            hashSet.add("Broken media codec: Google Pixel 3 / Samsung Android S");
        }
        if (isScopedStorageExperiment()) {
            hashSet.add("Scoped storage");
        }
        if (isShowEstimateEvenTracking()) {
            hashSet.add("Show estimate even tracking");
        }
        if (isNewGoogleSleepApi()) {
            hashSet.add("Google Sleep API");
        }
        return hashSet;
    }

    public long getCachedSeed() {
        return this.experimentsSeed;
    }

    public String getPriceGroup() {
        String marketingSegment;
        return (isSegmentationHoldout() || (marketingSegment = new com.urbandroid.sleep.service.Settings(this.context).getMarketingSegment()) == null) ? "NORMAL" : "VIP".equals(marketingSegment) ? "HIGH" : (!"LIKELY_PAYER".equals(marketingSegment) && "REST_F2P".equals(marketingSegment)) ? "LOW" : "NORMAL";
    }

    public boolean is128BitRateExperiment() {
        return true;
    }

    public boolean isActigraphyImprovementsExperiment1() {
        return true;
    }

    public boolean isActigraphyImprovementsExperiment2() {
        return true;
    }

    public boolean isActigraphyImprovementsExperiment3() {
        return !isOptedOut();
    }

    public boolean isActivityPersistentExperiment() {
        return isPetrPhone() || isJanMarekPhone() || isJanMarekTemporaryTestingPhone() || isJirkaPhone() || isWitekKruzsynaPhone() || isNeveceralPhone() || matchImei("354268095213190");
    }

    public boolean isAlarmAsyncPrepareExperiment() {
        return true;
    }

    public boolean isAliveLoggingExperiment() {
        return isOurExperimentalPhone();
    }

    public boolean isAnalyticsAlwaysEnabled() {
        return isJirkaPhone();
    }

    public boolean isAnyTensorflow() {
        return isTensorflowV3() || isTensorflowV4();
    }

    public boolean isBackgroundLimitationApi26() {
        return true;
    }

    public boolean isBatchingFixExperiment() {
        return true;
    }

    public boolean isBeta() {
        return false;
    }

    public boolean isBrokenMediaCodecDevice() {
        String str = Build.MODEL;
        if (!str.contains("Pixel 3") || str.contains("Pixel 3a")) {
            return SharedApplicationContext.isManufacturer("Samsung") && Build.VERSION.SDK_INT == 31;
        }
        return true;
    }

    public boolean isColoredActionsExperiment() {
        return Build.VERSION.SDK_INT >= 25;
    }

    public boolean isDetailedGattLoggingExperiment() {
        return false;
    }

    public boolean isDetailedPairLoggingExperiment() {
        return false;
    }

    public boolean isDetailedSoundRecognitionLoggingExperiment() {
        return false;
    }

    public boolean isDimAsLowAsPossible() {
        return Environment.isKitKatOrGreater();
    }

    public boolean isDoMediaStoreBackup() {
        return true;
    }

    public boolean isEnableWiFiInMorningExperiment() {
        return true;
    }

    public boolean isFreemiumExperiment() {
        return false;
    }

    public boolean isGoogleCalendarExperiment() {
        return Environment.isMOrGreater();
    }

    public boolean isHeadupsWhenLeavingAlarmScreen() {
        return true;
    }

    public boolean isHrvExperiment() {
        return true;
    }

    public boolean isJanMarekPhone() {
        return matchAndroidId("a926e125c852a79") || matchAndroidId("346a99d380d081cf");
    }

    public boolean isJirkaPhone() {
        return matchImei("865170024015443") || matchImei("353490067556783") || matchImei("353627072805818") || matchImei("358549084997877");
    }

    public boolean isKeepLockWithScreenOnTracking() {
        return true;
    }

    public boolean isLenkaPhone() {
        return matchImei("353627076203713") || matchImei("351615080579204") || matchAndroidId("65aa590ffb6e20fa") || matchAndroidId("1269e6e1a809d9cd") || matchAndroidId("140eb186199c8e3b") || matchAndroidId("d2f68b29306462d0") || matchAndroidId("64e97a0ee61e78a9") || matchAndroidId("cae51d4396cb2cb3");
    }

    public boolean isLessAlarmReschedulingExperiment() {
        return true;
    }

    public boolean isMoreDebuggingExperiment() {
        return isMartinPhone();
    }

    public boolean isNewBatchingCompensationAlgorithm() {
        return true;
    }

    public boolean isNewDismissHeadsUpExperiment() {
        return true;
    }

    public boolean isNewDndExperiment() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        if (isOptedOut() || !Environment.isMOrGreater()) {
            return false;
        }
        return SharedApplicationContext.isManufacturer("samsung") || SharedApplicationContext.isManufacturer("huawei") || SharedApplicationContext.isManufacturer("oneplus");
    }

    public boolean isNewGoogleSleepApi() {
        return true;
    }

    public boolean isNoDelayInSnooze() {
        return false;
    }

    public boolean isOptedOut() {
        return new com.urbandroid.sleep.service.Settings(this.context).isOptedOutFromExperiments();
    }

    public boolean isOurExperimentalPhone() {
        return isPetrPhone() || isLenkaPhone();
    }

    public boolean isPhoneWithDisappearingAlarmDialog() {
        String str = Build.PRODUCT;
        return "zeroltexx".equals(str) || "himaulatt_rogers_wwe".equals(str) || "zerofltedv".equals(str) || "victara_tmo".equals(str) || "M3G".equals(str) || SharedApplicationContext.isManufacturer("htc") || SharedApplicationContext.isManufacturer("asus");
    }

    public boolean isRandomSleepDataExperiment() {
        return false;
    }

    public boolean isRawActigraphyPersistentExperiment() {
        return isJanMarekPhone() || isJanMarekTemporaryTestingPhone();
    }

    public boolean isRawBleHrDataPersistentExperiment() {
        return isJanMarekPhone() || isJanMarekTemporaryTestingPhone() || isJirkaPhone();
    }

    public boolean isRebootRestarting() {
        return true;
    }

    public boolean isReliableAlarmExperiment() {
        return Build.VERSION.SDK_INT > 27 || new com.urbandroid.sleep.service.Settings(this.context).getLoggingLevel() == 1 || (Environment.isKitKatOrGreater() && !isOptedOut());
    }

    public boolean isReplaceRestarting() {
        return !isOptedOut();
    }

    public boolean isRespiratoryDetailsPersistentExperiment() {
        return isJanMarekPhone() || isJanMarekTemporaryTestingPhone();
    }

    public boolean isRespiratoryDetectionV2Experiment() {
        return true;
    }

    public boolean isRestartingAlarmDialogExperiment() {
        return (isOptedOut() || isRestartingAlarmDialogExperiment2() || isHeadupsWhenLeavingAlarmScreen()) ? false : true;
    }

    public boolean isRestartingAlarmDialogExperiment2() {
        return (isOptedOut() || isHeadupsWhenLeavingAlarmScreen()) ? false : true;
    }

    public boolean isSMSExperiment() {
        return false;
    }

    public boolean isScopedStorageExperiment() {
        return new com.urbandroid.sleep.service.Settings(this.context).isScopedStorage();
    }

    public boolean isSegmentationHoldout() {
        return isTestGroupOrBeta(4242, 20);
    }

    public boolean isShowCaseExperiment() {
        return true;
    }

    public boolean isShowCaseInSettingsExperiment() {
        return false;
    }

    public boolean isShowEstimateEvenTracking() {
        return isOurExperimentalPhone();
    }

    public boolean isTensorflowV3() {
        return !isTensorflowV4();
    }

    public boolean isTensorflowV4() {
        return !isOptedOut();
    }

    public boolean isUserWithHeadphonesProblems() {
        return matchAndroidId("2cb2d6a1e9252df8");
    }

    public boolean isXiaomiMergeSessionFix() {
        return !isOptedOut();
    }

    public boolean showBetaDialogBecauseOfPermission() {
        return false;
    }

    public boolean useAndroidMDozeHackBatching() {
        return true;
    }

    public boolean useAndroidMDozeHackForegroundService() {
        return false;
    }

    public boolean useAndroidMDozeHackWakeLock(Context context) {
        return (useAndroidMDozeHackForegroundService() || PowerManagerCompat.isIgnoringBatteryOptimizations(context)) ? false : true;
    }

    public boolean useNokiaWakeScreenHack() {
        return false;
    }
}
