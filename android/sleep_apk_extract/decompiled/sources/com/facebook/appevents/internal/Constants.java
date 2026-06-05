package com.facebook.appevents.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bH\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010L\u001a\u00020MH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/facebook/appevents/internal/Constants;", "", "()V", "AA_TIME_SPENT_EVENT_NAME", "", "AA_TIME_SPENT_SCREEN_PARAMETER_NAME", "ANDROID_DYNAMIC_ADS_CONTENT_ID", "EVENT_NAME_EVENT_KEY", "EVENT_NAME_PURCHASE_RESTORED", "EVENT_NAME_SUBSCRIPTION_RESTORED", "EVENT_PARAM_IS_AUTOLOG_APP_EVENTS_ENABLED", "EVENT_PARAM_IS_IMPLICIT_PURCHASE_LOGGING_ENABLED", "EVENT_PARAM_PRODUCT_AVAILABILITY", "EVENT_PARAM_PRODUCT_BRAND", "EVENT_PARAM_PRODUCT_CONDITION", "EVENT_PARAM_PRODUCT_DESCRIPTION", "EVENT_PARAM_PRODUCT_GTIN", "EVENT_PARAM_PRODUCT_IMAGE_LINK", "EVENT_PARAM_PRODUCT_ITEM_ID", "EVENT_PARAM_PRODUCT_LINK", "EVENT_PARAM_PRODUCT_MPN", "EVENT_PARAM_PRODUCT_PRICE_AMOUNT", "EVENT_PARAM_PRODUCT_PRICE_CURRENCY", "EVENT_PARAM_PRODUCT_TITLE", "GPS_ARA_FAILED", "GPS_ARA_FAILED_REASON", "GPS_ARA_SUCCEED", "GPS_PA_FAILED", "GPS_PA_FAILED_REASON", "GPS_PA_SUCCEED", "GP_IAP_AUTORENEWING", "GP_IAP_BASE_PLAN_ID", "GP_IAP_BILLING_PERIOD", "GP_IAP_DESCRIPTION", "GP_IAP_FREE_TRIAL_PERIOD", "GP_IAP_INTRODUCTORY_PRICE_AMOUNT_MICROS", "GP_IAP_INTRODUCTORY_PRICE_CYCLES", "GP_IAP_INTRODUCTORY_PRICE_PERIOD", "GP_IAP_OFFER_ID", "GP_IAP_ONE_TIME_PURCHASE_OFFER_DETAILS", "GP_IAP_PACKAGE_NAME", "GP_IAP_PRICE_AMOUNT_MICROS_V2V4", "GP_IAP_PRICE_AMOUNT_MICROS_V5V7", "GP_IAP_PRICE_CURRENCY_CODE_V2V4", "GP_IAP_PRICE_CURRENCY_CODE_V5V7", "GP_IAP_PRODUCT_ID", "GP_IAP_PURCHASE_TIME", "GP_IAP_PURCHASE_TOKEN", "GP_IAP_RECURRENCE_MODE", "GP_IAP_SUBSCRIPTION_OFFER_DETAILS", "GP_IAP_SUBSCRIPTION_PERIOD", "GP_IAP_SUBSCRIPTION_PRICING_PHASES", "GP_IAP_TITLE", "GP_IAP_TYPE", "IAP_ACTUAL_DEDUP_KEY_USED", "IAP_ACTUAL_DEDUP_RESULT", "IAP_AUTOLOG_IMPLEMENTATION", "IAP_BASE_PLAN", "IAP_BILLING_LIBRARY_VERSION", "IAP_FREE_TRIAL_PERIOD", "IAP_INTRO_PERIOD", "IAP_INTRO_PRICE_AMOUNT_MICROS", "IAP_INTRO_PRICE_CYCLES", "IAP_NON_DEDUPED_EVENT_TIME", "IAP_PACKAGE_NAME", "IAP_PRODUCT_DESCRIPTION", "IAP_PRODUCT_ID", "IAP_PRODUCT_TITLE", "IAP_PRODUCT_TYPE", "IAP_PURCHASE_TIME", "IAP_PURCHASE_TOKEN", "IAP_SUBSCRIPTION_AUTORENEWING", "IAP_SUBSCRIPTION_PERIOD", "IAP_TEST_DEDUP_KEY_USED", "IAP_TEST_DEDUP_RESULT", "LOG_TIME_APP_EVENT_KEY", "getDefaultAppEventsSessionTimeoutInSeconds", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Constants {
    public static final String AA_TIME_SPENT_EVENT_NAME = "fb_aa_time_spent_on_view";
    public static final String AA_TIME_SPENT_SCREEN_PARAMETER_NAME = "fb_aa_time_spent_view_name";
    public static final String ANDROID_DYNAMIC_ADS_CONTENT_ID = "android_dynamic_ads_content_id";
    public static final String EVENT_NAME_EVENT_KEY = "_eventName";
    public static final String EVENT_NAME_PURCHASE_RESTORED = "fb_mobile_purchase_restored";
    public static final String EVENT_NAME_SUBSCRIPTION_RESTORED = "SubscriptionRestore";
    public static final String EVENT_PARAM_IS_AUTOLOG_APP_EVENTS_ENABLED = "is_autolog_app_events_enabled";
    public static final String EVENT_PARAM_IS_IMPLICIT_PURCHASE_LOGGING_ENABLED = "is_implicit_purchase_logging_enabled";
    public static final String EVENT_PARAM_PRODUCT_AVAILABILITY = "fb_product_availability";
    public static final String EVENT_PARAM_PRODUCT_BRAND = "fb_product_brand";
    public static final String EVENT_PARAM_PRODUCT_CONDITION = "fb_product_condition";
    public static final String EVENT_PARAM_PRODUCT_DESCRIPTION = "fb_product_description";
    public static final String EVENT_PARAM_PRODUCT_GTIN = "fb_product_gtin";
    public static final String EVENT_PARAM_PRODUCT_IMAGE_LINK = "fb_product_image_link";
    public static final String EVENT_PARAM_PRODUCT_ITEM_ID = "fb_product_item_id";
    public static final String EVENT_PARAM_PRODUCT_LINK = "fb_product_link";
    public static final String EVENT_PARAM_PRODUCT_MPN = "fb_product_mpn";
    public static final String EVENT_PARAM_PRODUCT_PRICE_AMOUNT = "fb_product_price_amount";
    public static final String EVENT_PARAM_PRODUCT_PRICE_CURRENCY = "fb_product_price_currency";
    public static final String EVENT_PARAM_PRODUCT_TITLE = "fb_product_title";
    public static final String GPS_ARA_FAILED = "gps_ara_failed";
    public static final String GPS_ARA_FAILED_REASON = "gps_ara_failed_reason";
    public static final String GPS_ARA_SUCCEED = "gps_ara_succeed";
    public static final String GPS_PA_FAILED = "gps_pa_failed";
    public static final String GPS_PA_FAILED_REASON = "gps_pa_failed_reason";
    public static final String GPS_PA_SUCCEED = "gps_pa_succeed";
    public static final String GP_IAP_AUTORENEWING = "autoRenewing";
    public static final String GP_IAP_BASE_PLAN_ID = "basePlanId";
    public static final String GP_IAP_BILLING_PERIOD = "billingPeriod";
    public static final String GP_IAP_DESCRIPTION = "description";
    public static final String GP_IAP_FREE_TRIAL_PERIOD = "freeTrialPeriod";
    public static final String GP_IAP_INTRODUCTORY_PRICE_AMOUNT_MICROS = "introductoryPriceAmountMicros";
    public static final String GP_IAP_INTRODUCTORY_PRICE_CYCLES = "introductoryPriceCycles";
    public static final String GP_IAP_INTRODUCTORY_PRICE_PERIOD = "introductoryPricePeriod";
    public static final String GP_IAP_OFFER_ID = "offerId";
    public static final String GP_IAP_ONE_TIME_PURCHASE_OFFER_DETAILS = "oneTimePurchaseOfferDetails";
    public static final String GP_IAP_PACKAGE_NAME = "packageName";
    public static final String GP_IAP_PRICE_AMOUNT_MICROS_V2V4 = "price_amount_micros";
    public static final String GP_IAP_PRICE_AMOUNT_MICROS_V5V7 = "priceAmountMicros";
    public static final String GP_IAP_PRICE_CURRENCY_CODE_V2V4 = "price_currency_code";
    public static final String GP_IAP_PRICE_CURRENCY_CODE_V5V7 = "priceCurrencyCode";
    public static final String GP_IAP_PRODUCT_ID = "productId";
    public static final String GP_IAP_PURCHASE_TIME = "purchaseTime";
    public static final String GP_IAP_PURCHASE_TOKEN = "purchaseToken";
    public static final String GP_IAP_RECURRENCE_MODE = "recurrenceMode";
    public static final String GP_IAP_SUBSCRIPTION_OFFER_DETAILS = "subscriptionOfferDetails";
    public static final String GP_IAP_SUBSCRIPTION_PERIOD = "subscriptionPeriod";
    public static final String GP_IAP_SUBSCRIPTION_PRICING_PHASES = "pricingPhases";
    public static final String GP_IAP_TITLE = "title";
    public static final String GP_IAP_TYPE = "type";
    public static final String IAP_ACTUAL_DEDUP_KEY_USED = "fb_iap_actual_dedup_key_used";
    public static final String IAP_ACTUAL_DEDUP_RESULT = "fb_iap_actual_dedup_result";
    public static final String IAP_AUTOLOG_IMPLEMENTATION = "fb_iap_sdk_supported_library_versions";
    public static final String IAP_BASE_PLAN = "fb_iap_base_plan";
    public static final String IAP_BILLING_LIBRARY_VERSION = "fb_iap_client_library_version";
    public static final String IAP_FREE_TRIAL_PERIOD = "fb_free_trial_period";
    public static final String IAP_INTRO_PERIOD = "fb_intro_period";
    public static final String IAP_INTRO_PRICE_AMOUNT_MICROS = "fb_intro_price_amount_micros";
    public static final String IAP_INTRO_PRICE_CYCLES = "fb_intro_price_cycles";
    public static final String IAP_NON_DEDUPED_EVENT_TIME = "fb_iap_non_deduped_event_time";
    public static final String IAP_PACKAGE_NAME = "fb_iap_package_name";
    public static final String IAP_PRODUCT_DESCRIPTION = "fb_iap_product_description";
    public static final String IAP_PRODUCT_ID = "fb_iap_product_id";
    public static final String IAP_PRODUCT_TITLE = "fb_iap_product_title";
    public static final String IAP_PRODUCT_TYPE = "fb_iap_product_type";
    public static final String IAP_PURCHASE_TIME = "fb_iap_purchase_time";
    public static final String IAP_PURCHASE_TOKEN = "fb_iap_purchase_token";
    public static final String IAP_SUBSCRIPTION_AUTORENEWING = "fb_iap_subs_auto_renewing";
    public static final String IAP_SUBSCRIPTION_PERIOD = "fb_iap_subs_period";
    public static final String IAP_TEST_DEDUP_KEY_USED = "fb_iap_test_dedup_key_used";
    public static final String IAP_TEST_DEDUP_RESULT = "fb_iap_test_dedup_result";
    public static final Constants INSTANCE = new Constants();
    public static final String LOG_TIME_APP_EVENT_KEY = "_logTime";

    private Constants() {
    }

    public static final int getDefaultAppEventsSessionTimeoutInSeconds() {
        return 60;
    }
}
