package com.facebook.appevents.integrity;

import android.os.Bundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.AppLinkManager;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0015H\u0007J\b\u0010\u0017\u001a\u00020\u000fH\u0007J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/appevents/integrity/ProtectedModeManager;", "", "()V", "PROTECTED_MODE_IS_APPLIED_KEY", "", "PROTECTED_MODE_IS_APPLIED_VALUE", "PROTECTED_MODE_METADATA_KEY", "defaultStandardParameterNames", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getDefaultStandardParameterNames", "()Ljava/util/HashSet;", "defaultStandardParameterNames$delegate", "Lkotlin/Lazy;", "enabled", "", "standardParams", "convertJSONArrayToHashSet", "jsonArray", "Lorg/json/JSONArray;", "disable", "", "enable", IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "loadStandardParams", "processParametersForProtectedMode", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "Landroid/os/Bundle;", "protectedModeIsApplied", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProtectedModeManager {
    private static final String PROTECTED_MODE_IS_APPLIED_KEY = "pm";
    private static final String PROTECTED_MODE_IS_APPLIED_VALUE = "1";
    private static final String PROTECTED_MODE_METADATA_KEY = "pm_metadata";
    private static boolean enabled;
    private static HashSet<String> standardParams;
    public static final ProtectedModeManager INSTANCE = new ProtectedModeManager();

    /* JADX INFO: renamed from: defaultStandardParameterNames$delegate, reason: from kotlin metadata */
    private static final Lazy defaultStandardParameterNames = LazyKt.lazy(new Function0<HashSet<String>>() { // from class: com.facebook.appevents.integrity.ProtectedModeManager$defaultStandardParameterNames$2
        @Override // kotlin.jvm.functions.Function0
        public final HashSet<String> invoke() {
            return SetsKt.hashSetOf("_currency", AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, "fb_availability", "fb_body_style", "fb_checkin_date", "fb_checkout_date", "fb_city", "fb_condition_of_vehicle", "fb_content_ids", AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, "fb_contents", "fb_country", AppEventsConstants.EVENT_PARAM_CURRENCY, "fb_delivery_category", "fb_departing_arrival_date", "fb_departing_departure_date", "fb_destination_airport", "fb_destination_ids", "fb_dma_code", "fb_drivetrain", "fb_exterior_color", "fb_fuel_type", "fb_hotel_score", "fb_interior_color", "fb_lease_end_date", "fb_lease_start_date", "fb_listing_type", "fb_make", "fb_mileage.unit", "fb_mileage.value", "fb_model", "fb_neighborhood", "fb_num_adults", "fb_num_children", "fb_num_infants", AppEventsConstants.EVENT_PARAM_NUM_ITEMS, AppEventsConstants.EVENT_PARAM_ORDER_ID, "fb_origin_airport", "fb_postal_code", "fb_predicted_ltv", "fb_preferred_baths_range", "fb_preferred_beds_range", "fb_preferred_neighborhoods", "fb_preferred_num_stops", "fb_preferred_price_range", "fb_preferred_star_ratings", "fb_price", "fb_property_type", "fb_region", "fb_returning_arrival_date", "fb_returning_departure_date", "fb_state_of_vehicle", "fb_suggested_destinations", "fb_suggested_home_listings", "fb_suggested_hotels", "fb_suggested_jobs", "fb_suggested_local_service_businesses", "fb_suggested_location_based_items", "fb_suggested_vehicles", "fb_transmission", "fb_travel_class", "fb_travel_end", "fb_travel_start", "fb_trim", "fb_user_bucket", "fb_value", "fb_vin", "fb_year", "lead_event_source", "predicted_ltv", "product_catalog_id", "app_user_id", "appVersion", Constants.EVENT_NAME_EVENT_KEY, "_eventName_md5", "_implicitlyLogged", "_inBackground", "_isTimedEvent", Constants.LOG_TIME_APP_EVENT_KEY, "_session_id", "_ui", "_valueToUpdate", com.facebook.appevents.codeless.internal.Constants.IS_CODELESS_EVENT_KEY, "_is_suggested_event", "_fb_pixel_referral_id", "fb_pixel_id", "trace_id", "subscription_id", "event_id", "_restrictedParams", "_onDeviceParams", "purchase_valid_result_type", "core_lib_included", "login_lib_included", "share_lib_included", "place_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "_codeless_action", "sdk_initialized", "billing_client_lib_included", "billing_service_lib_included", "user_data_keys", "device_push_token", "fb_mobile_pckg_fp", "fb_mobile_app_cert_hash", "aggregate_id", "anonymous_id", AppLinkManager.CAMPAIGN_IDS_KEY, "fb_post_attachment", "receipt_data", AppEventsConstants.EVENT_PARAM_AD_TYPE, AppEventsConstants.EVENT_PARAM_CONTENT, AppEventsConstants.EVENT_PARAM_CONTENT_ID, AppEventsConstants.EVENT_PARAM_DESCRIPTION, AppEventsConstants.EVENT_PARAM_LEVEL, AppEventsConstants.EVENT_PARAM_MAX_RATING_VALUE, AppEventsConstants.EVENT_PARAM_PAYMENT_INFO_AVAILABLE, AppEventsConstants.EVENT_PARAM_REGISTRATION_METHOD, AppEventsConstants.EVENT_PARAM_SUCCESS, "pm", "_audiencePropertyIds", "cs_maca");
        }
    });

    private ProtectedModeManager() {
    }

    private final HashSet<String> convertJSONArrayToHashSet(JSONArray jsonArray) {
        if (!CrashShieldHandler.isObjectCrashing(this) && jsonArray != null) {
            try {
                if (jsonArray.length() != 0) {
                    HashSet<String> hashSet = new HashSet<>();
                    int length = jsonArray.length();
                    for (int i = 0; i < length; i++) {
                        String string = jsonArray.getString(i);
                        string.getClass();
                        hashSet.add(string);
                    }
                    return hashSet;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
        return null;
    }

    public static final void disable() {
        if (CrashShieldHandler.isObjectCrashing(ProtectedModeManager.class)) {
            return;
        }
        try {
            enabled = false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ProtectedModeManager.class);
        }
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(ProtectedModeManager.class)) {
            return;
        }
        try {
            enabled = true;
            INSTANCE.loadStandardParams();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ProtectedModeManager.class);
        }
    }

    public static final boolean isEnabled() {
        if (CrashShieldHandler.isObjectCrashing(ProtectedModeManager.class)) {
            return false;
        }
        try {
            return enabled;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ProtectedModeManager.class);
            return false;
        }
    }

    private final void loadStandardParams() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            HashSet<String> hashSetConvertJSONArrayToHashSet = convertJSONArrayToHashSet(fetchedAppSettingsQueryAppSettings.getProtectedModeStandardParamsSetting());
            if (hashSetConvertJSONArrayToHashSet == null) {
                hashSetConvertJSONArrayToHashSet = getDefaultStandardParameterNames();
            }
            standardParams = hashSetConvertJSONArrayToHashSet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void processParametersForProtectedMode(Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(ProtectedModeManager.class)) {
            return;
        }
        try {
            if (enabled && parameters != null && !parameters.isEmpty() && standardParams != null) {
                ArrayList<String> arrayList = new ArrayList();
                Set<String> setKeySet = parameters.keySet();
                setKeySet.getClass();
                for (String str : setKeySet) {
                    HashSet<String> hashSet = standardParams;
                    hashSet.getClass();
                    if (!hashSet.contains(str)) {
                        str.getClass();
                        arrayList.add(str);
                    }
                }
                boolean z = false;
                for (String str2 : arrayList) {
                    if (parameters.containsKey(str2)) {
                        parameters.remove(str2);
                        z = true;
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cd", z);
                parameters.putString(PROTECTED_MODE_METADATA_KEY, jSONObject.toString());
                parameters.putString(PROTECTED_MODE_IS_APPLIED_KEY, "1");
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ProtectedModeManager.class);
        }
    }

    public final HashSet<String> getDefaultStandardParameterNames() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return (HashSet) defaultStandardParameterNames.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final boolean protectedModeIsApplied(Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(this) || parameters == null) {
            return false;
        }
        try {
            if (parameters.containsKey(PROTECTED_MODE_IS_APPLIED_KEY)) {
                if (Intrinsics.areEqual(parameters.get(PROTECTED_MODE_IS_APPLIED_KEY), "1")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
