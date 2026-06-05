package com.urbandroid.sleep.smartwatch;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public enum Wearable {
    NONE(R.drawable.ic_captcha_disabled, R.string.lullaby_name_NONE, R.string.no_wearable_tracking),
    AUTO(R.drawable.ic_sound_alarm_defaults, R.string.automatic, R.string.wearable_auto_desc),
    PEBBLE_GADGETBRIDGE(R.drawable.ic_wearable_rect_watch, R.string.control_pebble, R.string.control_gadgetbridge, "", "nodomain.freeyourgadget.gadgetbridge", "https://f-droid.org/en/packages/nodomain.freeyourgadget.gadgetbridge/"),
    PEBBLE(R.drawable.ic_wearable_rect_watch, R.string.control_pebble_legacy, R.string.legacy, "", "com.getpebble.android", "https://www.apkmirror.com/apk/pebble-technology-corp/pebble-old-version/pebble-old-version-2-5-0-release/pebble-old-version-2-5-0-android-apk-download/"),
    PEBBLE_TIME(R.drawable.ic_wearable_rect_watch, R.string.control_pebble, R.string.pebble_rebble, "", "io.rebble.cobble", "https://rebble.io/apk/"),
    REPEBBLE(R.drawable.ic_wearable_rect_watch, R.string.control_pebble, R.string.repebble, "com.urbandroid.watchsleepstarter", "coredevices.coreapp"),
    WEAR_OS_3_PLUS(R.drawable.ic_wearable_round_watch2, R.string.control_wear_os_3_plus, R.string.wearos_instruction, "", null),
    WEAR_OS(R.drawable.ic_wearable_round_watch, R.string.control_wear_os, R.string.wearos_instruction, "", "com.google.android.wearable.app"),
    FITBIT(R.drawable.ic_wearable_rect_watch, R.string.control_fitbit, R.string.control_fitbit_summary, "com.urbandroid.sleep", "com.fitbit.FitbitMobile"),
    ZEPP(R.drawable.ic_wearable_rect_watch, R.string.control_zepp, R.string.control_zepp_summary, "com.urbandroid.sleep", "com.huami.watch.hmwatchmanager"),
    ADDON_URBANDROID_SONY(R.drawable.ic_wearable_rect_watch, R.string.addon_urbandroid_sony, 0, "com.urbandroid.sleep.addon.sony", null),
    SAMSUNG_WEAR(R.drawable.ic_wearable_round_watch, R.string.addon_urbandroid_samsung_wear, R.string.addon_urbandroid_samsung_wear_description, "", null),
    ADDON_URBANDROID_SAMSUNG(R.drawable.ic_wearable_round_watch, R.string.addon_urbandroid_samsung, R.string.addon_urbandroid_samsung_description, "com.urbandroid.sleep.addon.samsung", "com.samsung.android.app.watchmanager"),
    ADDON_URBANDROID_SAMSUNG_NEW(R.drawable.ic_wearable_round_watch, R.string.addon_urbandroid_samsung, R.string.addon_urbandroid_samsung_description, "com.urbandroid.sleep.addon.generic.samsung", null),
    ADDON_URBANDROID_SAMSUNG_NEW2(R.drawable.ic_wearable_round_watch, R.string.addon_urbandroid_samsung, R.string.addon_urbandroid_samsung_description, "com.urbandroid.sleep.addon.generic.samsung", null),
    ADDON_URBANDROID_GARMIN(R.drawable.ic_wearable_round_watch, R.string.addon_urbandroid_garmin, R.string.addon_urbandroid_garmin_addon, null, "com.garmin.android.apps.connectmobile"),
    ADDON_3RD_PARTY_GARMIN(R.drawable.ic_wearable_round_watch, R.string.addon_3rd_party_garmin, R.string.third_party_addon_by_chakaponden, "com.chakaponden.sleepasandroid.garmin", "com.garmin.android.apps.connectmobile"),
    ADDON_3RD_PARTY_MAXIM_INTEGRATED(R.drawable.ic_wearable_oxi, R.string.addon_maxim_integrated, R.string.third_party_addon_by_chakaponden, "com.chakaponden.sleepasandroid.maxim", null),
    ADDON_3RD_PARTY_GO2SLEEP(R.drawable.ic_wearable_oxi, R.string.addon_go2sleep, R.string.third_party_addon_by_chakaponden, "com.chakaponden.sleepasandroid.go2sleep", null),
    ADDON_3RD_PARTY_O2RING(R.drawable.ic_wearable_oxi, R.string.addon_o2ring, R.string.third_party_addon_by_chakaponden, "com.chakaponden.sleepasandroid.o2ring", null),
    ADDON_3RD_PARTY_MI_BAND_TOOLS(R.drawable.ic_wearable_tracker, R.string.wearable_miband, R.string.addon_3rd_party_mi_band_tools, "cz.zdenekhorak.mibandtools", null),
    ADDON_3RD_PARTY_MI_BAND_NOTIFY_FITNESS_FOR_XIAOMI(R.drawable.ic_wearable_tracker, R.string.wearable_miband_for_xiaomi, R.string.wearable_miband_for_xiaomi_desc, "com.mc.xiaomi1", null),
    ADDON_3RD_PARTY_MI_BAND_NOTIFY_FITNESS_FOR_XIAOMI_HUAWEI(R.drawable.ic_wearable_tracker, R.string.wearable_miband_for_xiaomi, R.string.wearable_miband_for_xiaomi_desc_huawei, "com.mc.xiaomi1.huawei", null),
    ADDON_3RD_PARTY_MI_BAND_NOTIFY_FITNESS(R.drawable.ic_wearable_tracker, R.string.wearable_miband, R.string.addon_3rd_party_mi_band_notify_fitness, "com.mc.miband1", null),
    ADDON_3RD_PARTY_MI_BAND_NOTIFY_FITNESS_HUAWEI(R.drawable.ic_wearable_tracker, R.string.wearable_miband, R.string.addon_3rd_party_mi_band_notify_fitness_huawei, "com.mc.miband1.huawei", null),
    ADDON_3RD_PARTY_AMAZFIT_TOOLS(R.drawable.ic_wearable_rect_watch, R.string.wearable_amazfit, R.string.addon_3rd_party_amazfit_tools, "cz.zdenekhorak.amazfittools", null),
    ADDON_3RD_PARTY_AMAZFIT_NOTIFY_FITNESS(R.drawable.ic_wearable_rect_watch, R.string.wearable_amazfit, R.string.addon_3rd_party_amazfit_notify_fitness, "com.mc.amazfit1", null),
    ADDON_3RD_PARTY_AMAZFIT_NOTIFY_FITNESS_HUAWEI(R.drawable.ic_wearable_rect_watch, R.string.wearable_amazfit, R.string.addon_3rd_party_amazfit_notify_fitness_huawei, "com.mc.amazfit1.huawei", null),
    ADDON_3RD_PARTY_AMAZFIT_ANDROID_AMAZMOD(R.drawable.ic_wearable_rect_watch, R.string.wearable_amazfit_android, R.string.third_party_addon_by_amazmod, "com.edotassi.amazmod", null),
    POLAR(R.drawable.ic_wearable_sensor, R.string.wearable_polar, R.string.wearable_polar_desc),
    POLAR_SDK(R.drawable.ic_wearable_rect_watch, R.string.wearable_polar_sdk, R.string.wearable_polar_sdk_desc),
    PINE_TIME_INFINI_TIME(R.drawable.ic_wearable_rect_watch, R.string.wearable_pine_time_infini_time, R.string.wearable_pine_time_infini_time_desc),
    BANGLE_JS(R.drawable.ic_wearable_round_watch, R.string.wearable_bangle_js, 0, "", "com.espruino.gadgetbridge.banglejs"),
    TASKER(R.drawable.ic_sound_alarm_defaults, R.string.wearable_tasker, R.string.wearable_custom_summary, "net.dinglisch.android.taskerm", null),
    AUTOMATE(R.drawable.ic_sound_alarm_defaults, R.string.wearable_automate, R.string.wearable_custom_summary, "com.llamalab.automate", null),
    CUSTOM(R.drawable.ic_feature_sensor, R.string.wearable_custom, R.string.wearable_custom_summary, null, null);

    public String addonPackageName;
    public int descriptionRes;
    public int friendlyTitleRes;
    public int iconRes;
    private String vendorDownloadLink;
    public String vendorPackageName;

    Wearable(int i, int i2, int i3) {
        this.addonPackageName = null;
        this.vendorPackageName = null;
        this.vendorDownloadLink = null;
        this.friendlyTitleRes = i2;
        this.descriptionRes = i3;
        this.iconRes = i;
    }

    private boolean isInstalled(Context context, String str) {
        if (this == NONE || this == AUTO || str == null || str.equals("")) {
            return true;
        }
        return TrialFilter.getInstance().isPackageInstalled(context.getPackageManager(), str);
    }

    public boolean canGatherWearableReport() {
        return Arrays.asList("com.urbandroid.sleep.addon.samsung", "com.urbandroid.sleep.addon.generic.samsung", "com.urbandroid.sleep.garmin").contains(this.addonPackageName);
    }

    public String getDescription(Context context) {
        return this.descriptionRes == 0 ? "" : context.getResources().getString(this.descriptionRes);
    }

    public String getName(Context context) {
        return context.getResources().getString(this.friendlyTitleRes);
    }

    public String getVendorDownloadLink() {
        return this.vendorDownloadLink;
    }

    public boolean isAddonInstalled(Context context) {
        return isInstalled(context, this.addonPackageName);
    }

    public boolean isDirectBleWearable() {
        return this == POLAR || this == PINE_TIME_INFINI_TIME;
    }

    public boolean isShowAddOnAfterSelect() {
        return this == ADDON_URBANDROID_SAMSUNG || this == ADDON_URBANDROID_SAMSUNG_NEW || this == ADDON_URBANDROID_SAMSUNG_NEW2;
    }

    public boolean isVendorInstalled(Context context) {
        return isInstalled(context, this.vendorPackageName);
    }

    Wearable(int i, int i2, int i3, String str, String str2) {
        this.vendorDownloadLink = null;
        this.addonPackageName = str;
        this.vendorPackageName = str2;
        this.friendlyTitleRes = i2;
        this.descriptionRes = i3;
        this.iconRes = i;
    }

    Wearable(int i, int i2, int i3, String str, String str2, String str3) {
        this.addonPackageName = str;
        this.vendorPackageName = str2;
        this.friendlyTitleRes = i2;
        this.descriptionRes = i3;
        this.vendorDownloadLink = str3;
        this.iconRes = i;
    }
}
