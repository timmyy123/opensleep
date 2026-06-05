package com.urbandroid.sleep.share.analytics;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.CustomCrashInfoProvider;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.marketing.MonetizationSegmentation;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.util.Experiments;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class FirebaseAnalyticsManager {
    private final Context context;
    private final Boolean debug = Boolean.FALSE;
    private final Settings settings = SharedApplicationContext.getSettings();

    /* JADX INFO: renamed from: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager$31, reason: invalid class name */
    public class AnonymousClass31 extends LogEventTemplate {
        final /* synthetic */ long val$clickTs;
        final /* synthetic */ Context val$context;
        final /* synthetic */ long val$installTs;
        final /* synthetic */ String val$uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass31(Context context, long j, long j2, String str) {
            super(FirebaseAnalyticsManager.this, 0);
            this.val$context = context;
            this.val$installTs = j;
            this.val$clickTs = j2;
            this.val$uri = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$doSend$0(Settings settings, Bundle bundle, Context context, MonetizationSegmentation.Result result) {
            Logger.logInfo("Segmentation, score " + result.scorePoints + " segment " + result.segment);
            settings.setMarketingScore(result.scorePoints);
            settings.setMarketingSegment(result.segment);
            bundle.putString("segment", result.segment);
            bundle.putInt("score_points", result.scorePoints);
            bundle.putBoolean("holdout", Experiments.getInstance().isSegmentationHoldout());
            bundle.putString("country_bucket", result.countryBucket);
            bundle.putString("language_bucket", result.languageBucket);
            bundle.putString("device_category_bucket", result.deviceCategoryBucket);
            bundle.putString("brand_bucket", result.brandBucket);
            bundle.putString("hw_model_bucket", result.hwModelBucket);
            bundle.putString("os_bucket", result.osBucket);
            bundle.putString("install_source_bucket", result.installSourceBucket);
            bundle.putString("traffic_name_bucket", result.trafficNameBucket);
            bundle.putString("traffic_medium_bucket", result.trafficMediumBucket);
            bundle.putString("traffic_source_bucket", result.trafficSourceBucket);
            bundle.putString("segmentation_version_name", String.valueOf(0.4f));
            FirebaseAnalytics.getInstance(context).logEvent("Install_attribution", bundle);
        }

        @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
        public void doSend() {
            Settings settings = new Settings(this.val$context);
            if (settings.getMarketingScore() == -1 || settings.getMarketingSegment() == null) {
                Bundle bundle = new Bundle();
                bundle.putLong("Install_ts", this.val$installTs);
                bundle.putLong("Click_ts", this.val$clickTs);
                bundle.putString("deviceHwBrand", Build.BRAND);
                bundle.putString("deviceHwModel", Build.MODEL);
                bundle.putString("country", settings.getCountry());
                bundle.putString("countryLocale", Locale.getDefault().getCountry());
                try {
                    ParsedAttribution attribution = FirebaseAnalyticsManager.parseAttribution(this.val$uri);
                    bundle.putString("Source", attribution.source);
                    bundle.putString("Medium", attribution.medium);
                    bundle.putString("Campaign", attribution.campaign);
                    bundle.putString("Ad_set", attribution.adSet);
                    bundle.putString("Ad", attribution.ad);
                    bundle.putString("Ad_group", attribution.adGroup);
                    bundle.putString("fbclid", attribution.fbclid);
                    bundle.putString("gclid", attribution.gclid);
                    String str = attribution.wbraid;
                    if (str != null) {
                        bundle.putString("wbraid", str);
                    }
                    String str2 = attribution.gbraid;
                    if (str2 != null) {
                        bundle.putString("gbraid", str2);
                    }
                    String str3 = this.val$uri;
                    if (str3 != null) {
                        int i = 0;
                        for (String str4 : FirebaseAnalyticsManager.splitChunks(str3, 99)) {
                            if (i == 0) {
                                bundle.putString("rawReferer", str4);
                            } else {
                                bundle.putString("rawReferer" + i, str4);
                            }
                            i++;
                        }
                    }
                    if (attribution.campaign == null && (attribution.gclid != null || (attribution.gbraid != null && attribution.wbraid != null))) {
                        attribution.campaign = "google_ads";
                    }
                    settings.setMarketingMedium(attribution.medium);
                    settings.setMarketingCampaign(attribution.campaign);
                    settings.setMarketingSource(attribution.source);
                    Logger.logInfo("Install referer, src " + attribution.source + " campaign " + attribution.campaign + " medium " + attribution.medium);
                } catch (Exception e) {
                    Logger.logSevere("Referrer ", e);
                }
                MonetizationSegmentation monetizationSegmentation = new MonetizationSegmentation();
                Context context = this.val$context;
                monetizationSegmentation.calculateSegments(context, new FirebaseAnalyticsManager$31$$ExternalSyntheticLambda0(context, settings, bundle));
            }
        }
    }

    public enum Integration {
        GOOGLE_FIT,
        SAMSUNG_S_HEALTH,
        GOOGLE_CALENDAR,
        SPOTIFY_FREE,
        SPOTIFY_PREMIUM,
        HEALTH_CONNECT
    }

    public static class ParsedAttribution {
        String ad;
        String adGroup;
        String adSet;
        String campaign;
        String fbclid;
        String gbraid;
        String gclid;
        String medium;
        String source;
        String wbraid;

        public /* synthetic */ ParsedAttribution(int i) {
            this();
        }

        private ParsedAttribution() {
        }
    }

    public enum Smartlight {
        PHILIPS_HUE,
        SLEEP_PHASER
    }

    public FirebaseAnalyticsManager(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle addAlarmParamsToBundle(Context context, Settings settings, Alarm alarm, Bundle bundle) {
        bundle.putInt("Alarm_hour", alarm.hour);
        bundle.putInt("Alarm_minutes", alarm.minutes);
        bundle.putInt("Alarm_offset", alarm.getOffset());
        bundle.putInt("Alarm_weekRepeat", alarm.getWeekRepeat());
        if (alarm.getDaysOfWeek() != null) {
            bundle.putInt("Alarm_days", alarm.getDaysOfWeek().getCoded());
        }
        CaptchaInfo captchaInfo = settings.getCaptchaInfo(alarm);
        bundle.putString("Alarm_Active_Captcha", captchaInfo == null ? "No_captcha" : captchaInfo.getActivityName());
        bundle.putBoolean("Alarm_silent", alarm.silent);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle addCommonParamsToBundle(Context context, Settings settings, Bundle bundle) {
        bundle.putInt("Ideal_daily_sleep_income", settings.getIdealSleepMinutes());
        bundle.putInt("Bedtime_notify_min_before", settings.getTimeToBedBefore());
        if (settings.getTimeToBedBefore() != -1) {
            bundle.putBoolean("Bedtime_notify_smart_bedtime", settings.isTimeToBedSmart());
            bundle.putBoolean("Bedtime_notify_vibrating", settings.isTimeToBedVibrating());
        }
        if (AuthenticatedGateway.load(context) != null && settings.isSmartlightEnabled()) {
            bundle.putString("Smartlight", Smartlight.PHILIPS_HUE.name());
        }
        bundle.putBoolean("Smartlight_Flashlight", settings.isUseFlashlight());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle addRecordsParamsToBundle(Context context, SleepRecord sleepRecord, Bundle bundle) {
        if (sleepRecord != null) {
            bundle.putBoolean("Sleep_smart_wakeup_fired", sleepRecord.isAlarmRungInSmartPeriod().booleanValue());
            try {
                bundle.putString("Sleep_record", new SleepRecordStringBuilder(context).setAppendMeasures(true, Measure.ALL_MEASURES).setAppendDuration(true).setAppendSparkleTweet(true).build(sleepRecord));
            } catch (Exception unused) {
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle addSettingsParamsToBundle(Context context, Settings settings, Bundle bundle) {
        bundle.putString("Permission_missing", new CustomCrashInfoProvider(context).getMissingPermissions());
        if (settings.isTabAddon() || settings.isTabGraphs() || settings.isTabNoise() || settings.isTabStats() || settings.isDashboard()) {
            bundle.putString("Misc_App_mode", "ALARMS_AND_TRACKING");
            bundle.putBoolean("Misc_Dashboard", settings.isDashboard());
            if (!settings.isDashboard()) {
                StringBuilder sb = new StringBuilder();
                if (settings.isTabAddon()) {
                    sb.append("ADDON ");
                }
                if (settings.isTabGraphs()) {
                    sb.append("GRAPHS ");
                }
                if (settings.isTabNoise()) {
                    sb.append("NOISE ");
                }
                if (settings.isTabStats()) {
                    sb.append("STATS ");
                }
                bundle.putString("Misc_Visible_tabs", sb.toString());
            }
        } else {
            bundle.putString("Misc_App_mode", "ALARMS_ONLY");
        }
        bundle.putBoolean("Misc_Opt_out_experiments", settings.isOptedOutFromExperiments());
        bundle.putBoolean("Misc_Opt_out_geo", settings.isGeoOptOut());
        bundle.putBoolean("Misc_Force_English", settings.isForceEnglish());
        bundle.putBoolean("Service_Google_Calendar", settings.isGoogleCalendar());
        bundle.putBoolean("Service_IFTTT", settings.isIfttt());
        bundle.putBoolean("Service_Tasker", settings.isTasker());
        if (settings.isSpotify()) {
            if (settings.isSpotifyPremium()) {
                bundle.putString("Service_Spotify", Integration.SPOTIFY_PREMIUM.name());
            } else {
                bundle.putString("Service_Spotify", Integration.SPOTIFY_FREE.name());
            }
        }
        bundle.putBoolean("Service_Google_Fit", settings.isGoogleFit());
        bundle.putBoolean("Service_Cloud_Backup", settings.isBackup());
        bundle.putBoolean("Service_Health_Connect", settings.isHealthConnect());
        bundle.putBoolean("Service_SHealth", settings.isSamsungSHealth());
        bundle.putBoolean("Service_Smartligh", settings.isSmartlightEnabled());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle addSleepTrackingParamsToBundle(Context context, Settings settings, Bundle bundle) {
        bundle.putInt("Smartwake_min", settings.getSmartWakeupMinutes());
        bundle.putInt("Smartwake_nap_min", settings.getSmartWakeupNapMinutes());
        bundle.putString("Smartwake_intensity_sens", settings.getDeepSleepSensitivity().name());
        bundle.putInt("Smartwake_occurrence_sens", settings.getSmartWakeupSensitivityChecks());
        bundle.putBoolean("Smartwake_start_automatically", settings.getAutoStartMode() == 1);
        bundle.putBoolean("Sleep_tracking_DND", settings.isMuteAlerts());
        bundle.putBoolean("Sleep_tracking_Auto_airplane", settings.isAutoAirplaneMode());
        bundle.putBoolean("Sleep_tracking_Hide_morning_stats", settings.isHideMorningStats());
        bundle.putBoolean("Sleep_tracking_Battery_optimized", settings.isBatteryOptimized());
        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(context);
        if (smartWatch != null) {
            bundle.putString("Sleep_tracking_sensor", this.settings.getSelectedWearable() != null ? this.settings.getSelectedWearable().name() : smartWatch.getPlatform());
            bundle.putBoolean("Sleep_tracking_hr_btle", settings.isHrBt());
            bundle.putBoolean("Sleep_tracking_hr_wearable", settings.isHrWear());
        } else if (settings.isUltrasonicTracking()) {
            bundle.putString("Sleep_tracking_sensor", "Sonar");
            bundle.putInt("Sleep_tracking_sonar_signal_strength", settings.getSonarSignalStrength());
        } else {
            bundle.putString("Sleep_tracking_sensor", "Accelerometer");
        }
        bundle.putBoolean("Awake_detection", settings.isAwakeDetectionHighActivity());
        bundle.putBoolean("Awake_detection_when_using_phone", settings.isAwakeDetectionWhenUsingPhone());
        bundle.putBoolean("Noise_Master_switch", settings.isRecordingMasterSwitchEnabled());
        bundle.putBoolean("Noise_Snoring_detection", settings.isSnoringDetection());
        bundle.putBoolean("Noise_Antisnoring_detection", settings.getRecordingAntisnore());
        bundle.putBoolean("Lucid_dreaming", settings.getLucidEnabled());
        bundle.putBoolean("Jet_lag_prevention", settings.isJetLagPrevention());
        return bundle;
    }

    public static boolean canEnableAnalyticsGlobally(Context context) {
        if (Experiments.getInstance().isAnalyticsAlwaysEnabled()) {
            return true;
        }
        Settings settings = new Settings(context);
        if (settings.isFirstUsage()) {
            Logger.logDebug("Analytics: first usage");
            return true;
        }
        if (settings.isOptOutAnalytics()) {
            Logger.logDebug("Analytics: opt out");
            return false;
        }
        if (!settings.isEuCountry() || settings.isUserAnalyticsAgreed()) {
            return true;
        }
        Logger.logDebug("Analytics EU: " + settings.isEuCountry() + " " + settings.isUserAnalyticsAgreed());
        return false;
    }

    private static String first(Uri uri, String... strArr) {
        for (String str : strArr) {
            String queryParameter = uri.getQueryParameter(str);
            if (!isNullOrEmpty(queryParameter)) {
                return queryParameter;
            }
        }
        return null;
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ParsedAttribution parseAttribution(String str) {
        ParsedAttribution parsedAttribution = new ParsedAttribution(0);
        if (!isNullOrEmpty(str)) {
            Uri uri = Uri.parse("https://dummy.example/?" + str);
            parsedAttribution.source = first(uri, "utm_source", ShareConstants.FEED_SOURCE_PARAM);
            parsedAttribution.medium = first(uri, "utm_medium", "medium");
            parsedAttribution.campaign = first(uri, "utm_campaign", "utm_id", "campaign", "campaign_name", "campaign_id");
            parsedAttribution.adSet = first(uri, "ad_set", "adset", "adset_id", "adsetid");
            parsedAttribution.adGroup = first(uri, "ad_group", "adgroup", "adgroup_id", "adgroupid", "adgroupname");
            parsedAttribution.ad = first(uri, "ad", "ad_id", "adid", "creative", "creative_id");
            parsedAttribution.gclid = first(uri, "gclid");
            parsedAttribution.fbclid = first(uri, "fbclid");
            parsedAttribution.wbraid = first(uri, "wbraid");
            parsedAttribution.gbraid = first(uri, "gbraid");
            if (parsedAttribution.gclid != null && parsedAttribution.source == null) {
                parsedAttribution.source = "google";
            }
        }
        return parsedAttribution;
    }

    public static List<String> splitChunks(String str, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + i;
            arrayList.add(str.substring(i2, Math.min(str.length(), i3)));
            i2 = i3;
        }
        return arrayList;
    }

    public void setEventAdPaid(final String str, final String str2, final double d, final long j, final String str3) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Bundle bundle = new Bundle();
                bundle.putString("adUnit", str);
                bundle.putString("placement", str2);
                bundle.putDouble("price", d);
                bundle.putLong("microsOriginal", j);
                bundle.putString("currencyOriginal", str3);
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Ad_payed");
            }
        }.send();
    }

    public void setEventAdShown(final int i, final String str) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Bundle bundle = new Bundle();
                String str2 = str;
                if (str2 != null) {
                    bundle.putString("placement", str2);
                }
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(FirebaseAnalyticsManager.this.context);
                int i2 = i;
                firebaseAnalytics.logEvent(i2 == 1 ? "Ad_shown_banner" : i2 == 3 ? "Ad_shown_interstitial" : i2 == 2 ? "Ad_shown_native" : "Ad_shown", bundle);
            }
        }.send();
    }

    public void setEventAddonClicked(final String str) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Bundle bundle = new Bundle();
                bundle.putString("Addon_name", str);
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Addon_clicked");
            }
        }.send();
    }

    public void setEventAlarmRings(final Context context, final Alarm alarm, final SleepRecord sleepRecord) {
        if (alarm == null) {
            return;
        }
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Settings settings = SharedApplicationContext.getSettings();
                FirebaseAnalytics.getInstance(context).logEvent("Alarm_rings", FirebaseAnalyticsManager.this.addRecordsParamsToBundle(context, sleepRecord, FirebaseAnalyticsManager.this.addAlarmParamsToBundle(context, settings, alarm, FirebaseAnalyticsManager.this.addCommonParamsToBundle(context, settings, new Bundle()))));
                FirebaseAnalytics.getInstance(context).logEvent("Settings_logged", FirebaseAnalyticsManager.this.addSettingsParamsToBundle(context, settings, new Bundle()));
            }
        }.send();
    }

    public void setEventAlarmSet(final Context context, final Alarm alarm) {
        if (alarm == null) {
            return;
        }
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Settings settings = SharedApplicationContext.getSettings();
                FirebaseAnalytics.getInstance(context).logEvent("Alarm_set", FirebaseAnalyticsManager.this.addAlarmParamsToBundle(context, settings, alarm, FirebaseAnalyticsManager.this.addCommonParamsToBundle(context, settings, new Bundle())));
            }
        }.send();
    }

    public void setEventAppStarted() {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.3
            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, (Bundle) null, "App_started");
            }
        }.send();
    }

    public void setEventAutomaticRecordAddedFromSuggestion() {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.18
            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, (Bundle) null, "Sleep_auto_add_from_suggestion");
            }
        }.send();
    }

    public void setEventError(final Throwable th) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Bundle bundle = new Bundle();
                bundle.putString("message", th.getMessage());
                bundle.putInt(InAppPurchaseConstants.METHOD_BUILD, 231055);
                bundle.putString("type", th.getClass().getSimpleName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    StackTraceElement stackTraceElement = stackTrace[0];
                    bundle.putString("stack", stackTraceElement.getClassName() + ":" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber());
                }
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Error");
            }
        }.send();
    }

    public void setEventManualRecordAddedFromSuggestion() {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.17
            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, (Bundle) null, "Sleep_record_add_from_suggestion");
            }
        }.send();
    }

    public void setEventPromoCard() {
        Logger.logInfo("Analytics: Promo card link tapped");
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.21
            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, (Bundle) null, "promo_card");
            }
        }.send();
    }

    public void setEventReferrer(Context context, String str, long j, long j2) {
        new AnonymousClass31(context, j2, j, str).send();
    }

    public void setEventSearchFailed(final String str) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.25
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Bundle bundle = new Bundle();
                bundle.putString("Query", str);
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Search_failed");
            }
        }.send();
    }

    public void setEventSearchUsed() {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.24
            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, (Bundle) null, "Search_used");
            }
        }.send();
    }

    public void setEventSleepApiSegmentAdded() {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.22
            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, (Bundle) null, "Sleep_API_segment_added");
            }
        }.send();
    }

    public void setEventSleepApiSegmentCorrection(final int i) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.23
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Logger.logInfo("Analytics: Sleep API correction " + i);
                Bundle bundle = new Bundle();
                bundle.putInt("Analytics: Correction", i);
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Sleep_API_segment_correction");
                int i2 = i;
                if (i2 > 20 && i2 < 60) {
                    zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Sleep_API_segment_correction_medium");
                } else if (i2 > 60) {
                    zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Sleep_API_segment_correction_big");
                }
            }
        }.send();
    }

    public void setEventSleepApiSegmentShown() {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.19
            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, (Bundle) null, "Sleep_API_segment_shown");
            }
        }.send();
    }

    public void setEventSleepRecord(final Context context, final SleepRecord sleepRecord) {
        if (sleepRecord == null) {
            return;
        }
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                FirebaseAnalytics.getInstance(context).logEvent("Sleep_record", FirebaseAnalyticsManager.this.addRecordsParamsToBundle(context, sleepRecord, FirebaseAnalyticsManager.this.addCommonParamsToBundle(context, SharedApplicationContext.getSettings(), new Bundle())));
            }
        }.send();
    }

    public void setEventSleepTrackingStarted(final Context context) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Settings settings = SharedApplicationContext.getSettings();
                FirebaseAnalytics.getInstance(context).logEvent("Sleep_tracking_started", FirebaseAnalyticsManager.this.addSleepTrackingParamsToBundle(context, settings, FirebaseAnalyticsManager.this.addCommonParamsToBundle(context, settings, new Bundle())));
                FirebaseAnalytics.getInstance(context).logEvent("Settings_logged", FirebaseAnalyticsManager.this.addSettingsParamsToBundle(context, settings, new Bundle()));
            }
        }.send();
    }

    public void setEventSmsLink() {
        Logger.logInfo("Analytics: SMS link tapped");
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.20
            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, (Bundle) null, "SMS_Link");
            }
        }.send();
    }

    public void setEventSyncFinishedSuccessfully(final Integration integration) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Bundle bundle = new Bundle();
                bundle.putString("Integration", integration.name());
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Sync_finished_successfully");
            }
        }.send();
    }

    public void setEventSyncStarted(final Integration integration) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Bundle bundle = new Bundle();
                bundle.putString("Integration", integration.name());
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Sync_started");
            }
        }.send();
    }

    public void setEventTutorialFinished(String str) {
        if (str.equals("FirstUsePreviewActivity")) {
            new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.29
                @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
                public void doSend() {
                    zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, (Bundle) null, "Tutorial_complete");
                }
            }.send();
        }
    }

    public void setEventTutorialPage(String str, final String str2) {
        if (str.equals("FirstUsePreviewActivity")) {
            new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.28
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(FirebaseAnalyticsManager.this, 0);
                }

                @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
                public void doSend() {
                    Bundle bundle = new Bundle();
                    bundle.putString("page", str2);
                    bundle.putLong("time", System.currentTimeMillis());
                    zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Tutorial_page");
                }
            }.send();
        }
    }

    public void setEventTutorialSkipped(final String str, final int i) {
        if (str.equals("FirstUsePreviewActivity")) {
            new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.30
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(FirebaseAnalyticsManager.this, 0);
                }

                @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
                public void doSend() {
                    Logger.logDebug("Analytics: Tutorial skipped " + str + " " + i);
                    Bundle bundle = new Bundle();
                    bundle.putString("Page", String.valueOf(i));
                    zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Tutorial_skipped");
                }
            }.send();
        }
    }

    public void setEventTutorialStarted(String str) {
        if (str.equals("FirstUsePreviewActivity")) {
            new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.27
                @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
                public void doSend() {
                    zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, (Bundle) null, "Tutorial_begin");
                }
            }.send();
        }
    }

    public void setEventUnlockClicked(final boolean z, final long j) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                Bundle bundle = new Bundle();
                bundle.putBoolean("In_app_purchase", z);
                bundle.putLong("Days_used", j);
                zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Unlock_clicked");
            }
        }.send();
    }

    public void setEventUnlockPurchased(final String str, final long j, final double d, final String str2, final double d2) {
        if (d > 0.0d) {
            new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(FirebaseAnalyticsManager.this, 0);
                }

                @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
                public void doSend() {
                    Logger.logInfo("Analytics: Purchased " + str + " CZK " + d);
                    Bundle bundle = new Bundle();
                    bundle.putString("Product", str);
                    bundle.putLong("Days", j);
                    bundle.putDouble("Price", d);
                    bundle.putString("OriginalCurrency", str2);
                    bundle.putDouble("OriginalPrice", d2);
                    zza$$ExternalSyntheticOutline0.m(FirebaseAnalyticsManager.this, bundle, "Purchased");
                }
            }.send();
        }
    }

    public void setEventUnlocked(final boolean z) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                FirebaseAnalytics.getInstance(FirebaseAnalyticsManager.this.context).logEvent(z ? "Unlocked" : "Locked", new Bundle());
            }
        }.send();
    }

    public void setPlainEvent(final String str) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                FirebaseAnalytics.getInstance(FirebaseAnalyticsManager.this.context).logEvent(str, null);
                Logger.logInfo("Analytics: " + str);
            }
        }.send();
    }

    public abstract class LogEventTemplate {
        private LogEventTemplate() {
        }

        public abstract void doSend();

        public void send() {
            if (FirebaseAnalyticsManager.canEnableAnalyticsGlobally(FirebaseAnalyticsManager.this.context)) {
                FirebaseAnalyticsManager.this.settings.addAnalyticsEvent();
                doSend();
            }
        }

        public /* synthetic */ LogEventTemplate(FirebaseAnalyticsManager firebaseAnalyticsManager, int i) {
            this();
        }
    }

    public void setPlainEvent(final String str, final Bundle bundle) {
        new LogEventTemplate() { // from class: com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(FirebaseAnalyticsManager.this, 0);
            }

            @Override // com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager.LogEventTemplate
            public void doSend() {
                for (String str2 : bundle.keySet()) {
                    String string = bundle.getString(str2);
                    if (string != null && string.length() > 99) {
                        int i = 0;
                        for (String str3 : FirebaseAnalyticsManager.splitChunks(string, 99)) {
                            String strM = i < 10 ? FileInsert$$ExternalSyntheticOutline0.m(i, AppEventsConstants.EVENT_PARAM_VALUE_NO) : String.valueOf(i);
                            Bundle bundle2 = bundle;
                            if (i == 0) {
                                bundle2.putString(str2, str3);
                            } else {
                                bundle2.putString(str2 + "_" + strM, str3);
                            }
                            i++;
                        }
                    }
                }
                FirebaseAnalytics.getInstance(FirebaseAnalyticsManager.this.context).logEvent(str, bundle);
                Logger.logInfo("Analytics: " + str + " bundle " + bundle);
            }
        }.send();
    }
}
