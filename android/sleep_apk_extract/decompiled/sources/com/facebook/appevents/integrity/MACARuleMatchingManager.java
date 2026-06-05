package com.facebook.appevents.integrity;

import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\""}, d2 = {"Lcom/facebook/appevents/integrity/MACARuleMatchingManager;", "", "()V", "MACARules", "Lorg/json/JSONArray;", "enabled", "", "keys", "", "", "[Ljava/lang/String;", "enable", "", "generateInfo", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "event", "getKey", "logic", "Lorg/json/JSONObject;", "getMatchPropertyIDs", "getStringArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "isMatchCCRule", "ruleString", "data", "loadMACARules", "processParameters", "removeGeneratedInfo", "stringComparison", "variable", "values", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MACARuleMatchingManager {
    private static JSONArray MACARules;
    private static boolean enabled;
    public static final MACARuleMatchingManager INSTANCE = new MACARuleMatchingManager();
    private static String[] keys = {"event", "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private MACARuleMatchingManager() {
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            INSTANCE.loadMACARules();
            if (MACARules != null) {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    public static final void generateInfo(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            params.getClass();
            event.getClass();
            params.putString("event", event);
            StringBuilder sb = new StringBuilder();
            Utility utility = Utility.INSTANCE;
            Locale locale = utility.getLocale();
            String language = locale != null ? locale.getLanguage() : null;
            String str = "";
            if (language == null) {
                language = "";
            }
            sb.append(language);
            sb.append('_');
            Locale locale2 = utility.getLocale();
            String country = locale2 != null ? locale2.getCountry() : null;
            if (country == null) {
                country = "";
            }
            sb.append(country);
            params.putString("_locale", sb.toString());
            String versionName = utility.getVersionName();
            if (versionName == null) {
                versionName = "";
            }
            params.putString("_appVersion", versionName);
            params.putString("_deviceOS", "ANDROID");
            params.putString("_platform", "mobile");
            String str2 = Build.MODEL;
            if (str2 == null) {
                str2 = "";
            }
            params.putString("_deviceModel", str2);
            params.putString("_nativeAppID", FacebookSdk.getApplicationId());
            String versionName2 = utility.getVersionName();
            if (versionName2 != null) {
                str = versionName2;
            }
            params.putString("_nativeAppShortVersion", str);
            params.putString("_timezone", utility.getDeviceTimeZoneName());
            params.putString("_carrier", utility.getCarrierName());
            params.putString("_deviceOSTypeName", "ANDROID");
            params.putString("_deviceOSVersion", Build.VERSION.RELEASE);
            params.putLong("_remainingDiskGB", utility.getAvailableExternalStorageGB());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    public static final String getKey(JSONObject logic) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            logic.getClass();
            Iterator<String> itKeys = logic.keys();
            if (itKeys.hasNext()) {
                return itKeys.next();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    public static final String getMatchPropertyIDs(Bundle params) {
        String strOptString;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = MACARules;
            if (jSONArray == null) {
                return "[]";
            }
            if (jSONArray != null && jSONArray.length() == 0) {
                return "[]";
            }
            JSONArray jSONArray2 = MACARules;
            jSONArray2.getClass();
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                String strOptString2 = jSONArray2.optString(i);
                if (strOptString2 != null) {
                    JSONObject jSONObject = new JSONObject(strOptString2);
                    long jOptLong = jSONObject.optLong("id");
                    if (jOptLong != 0 && (strOptString = jSONObject.optString("rule")) != null && isMatchCCRule(strOptString, params)) {
                        arrayList.add(Long.valueOf(jOptLong));
                    }
                }
            }
            String string = new JSONArray((Collection) arrayList).toString();
            string.getClass();
            return string;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    public static final ArrayList<String> getStringArrayList(JSONArray jsonArray) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) || jsonArray == null) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(jsonArray.get(i).toString());
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    public static final boolean isMatchCCRule(String ruleString, Bundle data2) {
        if (!CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) && ruleString != null && data2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(ruleString);
                String key = getKey(jSONObject);
                if (key == null) {
                    return false;
                }
                Object obj = jSONObject.get(key);
                int iHashCode = key.hashCode();
                if (iHashCode != 3555) {
                    if (iHashCode != 96727) {
                        if (iHashCode == 109267 && key.equals("not")) {
                            return !isMatchCCRule(obj.toString(), data2);
                        }
                    } else if (key.equals("and")) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray == null) {
                            return false;
                        }
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            if (!isMatchCCRule(jSONArray.get(i).toString(), data2)) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else if (key.equals("or")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    if (jSONArray2 == null) {
                        return false;
                    }
                    int length2 = jSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        if (isMatchCCRule(jSONArray2.get(i2).toString(), data2)) {
                            return true;
                        }
                    }
                    return false;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2 == null) {
                    return false;
                }
                return stringComparison(key, jSONObject2, data2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            }
        }
        return false;
    }

    private final void loadMACARules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            MACARules = fetchedAppSettingsQueryAppSettings.getMACARuleMatchingSetting();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void processParameters(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            event.getClass();
            if (!enabled || params == null) {
                return;
            }
            try {
                generateInfo(params, event);
                params.putString("_audiencePropertyIds", getMatchPropertyIDs(params));
                params.putString("cs_maca", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                removeGeneratedInfo(params);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    public static final void removeGeneratedInfo(Bundle params) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            params.getClass();
            for (String str : keys) {
                params.remove(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ad A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:5:0x000b, B:8:0x0019, B:11:0x0033, B:17:0x0044, B:25:0x0061, B:26:0x0065, B:28:0x006a, B:31:0x0074, B:33:0x008d, B:36:0x0097, B:39:0x00a3, B:128:0x0212, B:131:0x021a, B:132:0x021e, B:134:0x0224, B:42:0x00ad, B:45:0x00b7, B:47:0x00d0, B:142:0x0254, B:145:0x025c, B:146:0x0260, B:148:0x0266, B:50:0x00da, B:53:0x00e4, B:55:0x00fd, B:103:0x01ad, B:58:0x0107, B:97:0x0191, B:61:0x0111, B:88:0x016b, B:64:0x011b, B:67:0x0125, B:120:0x01f2, B:70:0x012f, B:73:0x0139, B:187:0x0316, B:76:0x0143, B:109:0x01c3, B:79:0x014d, B:82:0x0157, B:115:0x01df, B:85:0x0161, B:91:0x017d, B:94:0x0187, B:100:0x01a3, B:106:0x01b9, B:112:0x01d5, B:117:0x01e8, B:123:0x0204, B:137:0x0246, B:151:0x0288, B:154:0x0292, B:157:0x02ae, B:160:0x02b8, B:162:0x02c1, B:180:0x0301, B:165:0x02cb, B:168:0x02d5, B:170:0x02e3, B:173:0x02ec, B:175:0x02f5, B:182:0x030a, B:189:0x031f, B:192:0x0328, B:20:0x0055), top: B:199:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c3 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:5:0x000b, B:8:0x0019, B:11:0x0033, B:17:0x0044, B:25:0x0061, B:26:0x0065, B:28:0x006a, B:31:0x0074, B:33:0x008d, B:36:0x0097, B:39:0x00a3, B:128:0x0212, B:131:0x021a, B:132:0x021e, B:134:0x0224, B:42:0x00ad, B:45:0x00b7, B:47:0x00d0, B:142:0x0254, B:145:0x025c, B:146:0x0260, B:148:0x0266, B:50:0x00da, B:53:0x00e4, B:55:0x00fd, B:103:0x01ad, B:58:0x0107, B:97:0x0191, B:61:0x0111, B:88:0x016b, B:64:0x011b, B:67:0x0125, B:120:0x01f2, B:70:0x012f, B:73:0x0139, B:187:0x0316, B:76:0x0143, B:109:0x01c3, B:79:0x014d, B:82:0x0157, B:115:0x01df, B:85:0x0161, B:91:0x017d, B:94:0x0187, B:100:0x01a3, B:106:0x01b9, B:112:0x01d5, B:117:0x01e8, B:123:0x0204, B:137:0x0246, B:151:0x0288, B:154:0x0292, B:157:0x02ae, B:160:0x02b8, B:162:0x02c1, B:180:0x0301, B:165:0x02cb, B:168:0x02d5, B:170:0x02e3, B:173:0x02ec, B:175:0x02f5, B:182:0x030a, B:189:0x031f, B:192:0x0328, B:20:0x0055), top: B:199:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f2 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:5:0x000b, B:8:0x0019, B:11:0x0033, B:17:0x0044, B:25:0x0061, B:26:0x0065, B:28:0x006a, B:31:0x0074, B:33:0x008d, B:36:0x0097, B:39:0x00a3, B:128:0x0212, B:131:0x021a, B:132:0x021e, B:134:0x0224, B:42:0x00ad, B:45:0x00b7, B:47:0x00d0, B:142:0x0254, B:145:0x025c, B:146:0x0260, B:148:0x0266, B:50:0x00da, B:53:0x00e4, B:55:0x00fd, B:103:0x01ad, B:58:0x0107, B:97:0x0191, B:61:0x0111, B:88:0x016b, B:64:0x011b, B:67:0x0125, B:120:0x01f2, B:70:0x012f, B:73:0x0139, B:187:0x0316, B:76:0x0143, B:109:0x01c3, B:79:0x014d, B:82:0x0157, B:115:0x01df, B:85:0x0161, B:91:0x017d, B:94:0x0187, B:100:0x01a3, B:106:0x01b9, B:112:0x01d5, B:117:0x01e8, B:123:0x0204, B:137:0x0246, B:151:0x0288, B:154:0x0292, B:157:0x02ae, B:160:0x02b8, B:162:0x02c1, B:180:0x0301, B:165:0x02cb, B:168:0x02d5, B:170:0x02e3, B:173:0x02ec, B:175:0x02f5, B:182:0x030a, B:189:0x031f, B:192:0x0328, B:20:0x0055), top: B:199:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061 A[Catch: all -> 0x003f, PHI: r4
      0x0061: PHI (r4v3 java.lang.Object) = (r4v2 java.lang.Object), (r4v6 java.lang.Object) binds: [B:23:0x005d, B:18:0x0051] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x003f, blocks: (B:5:0x000b, B:8:0x0019, B:11:0x0033, B:17:0x0044, B:25:0x0061, B:26:0x0065, B:28:0x006a, B:31:0x0074, B:33:0x008d, B:36:0x0097, B:39:0x00a3, B:128:0x0212, B:131:0x021a, B:132:0x021e, B:134:0x0224, B:42:0x00ad, B:45:0x00b7, B:47:0x00d0, B:142:0x0254, B:145:0x025c, B:146:0x0260, B:148:0x0266, B:50:0x00da, B:53:0x00e4, B:55:0x00fd, B:103:0x01ad, B:58:0x0107, B:97:0x0191, B:61:0x0111, B:88:0x016b, B:64:0x011b, B:67:0x0125, B:120:0x01f2, B:70:0x012f, B:73:0x0139, B:187:0x0316, B:76:0x0143, B:109:0x01c3, B:79:0x014d, B:82:0x0157, B:115:0x01df, B:85:0x0161, B:91:0x017d, B:94:0x0187, B:100:0x01a3, B:106:0x01b9, B:112:0x01d5, B:117:0x01e8, B:123:0x0204, B:137:0x0246, B:151:0x0288, B:154:0x0292, B:157:0x02ae, B:160:0x02b8, B:162:0x02c1, B:180:0x0301, B:165:0x02cb, B:168:0x02d5, B:170:0x02e3, B:173:0x02ec, B:175:0x02f5, B:182:0x030a, B:189:0x031f, B:192:0x0328, B:20:0x0055), top: B:199:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016b A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:5:0x000b, B:8:0x0019, B:11:0x0033, B:17:0x0044, B:25:0x0061, B:26:0x0065, B:28:0x006a, B:31:0x0074, B:33:0x008d, B:36:0x0097, B:39:0x00a3, B:128:0x0212, B:131:0x021a, B:132:0x021e, B:134:0x0224, B:42:0x00ad, B:45:0x00b7, B:47:0x00d0, B:142:0x0254, B:145:0x025c, B:146:0x0260, B:148:0x0266, B:50:0x00da, B:53:0x00e4, B:55:0x00fd, B:103:0x01ad, B:58:0x0107, B:97:0x0191, B:61:0x0111, B:88:0x016b, B:64:0x011b, B:67:0x0125, B:120:0x01f2, B:70:0x012f, B:73:0x0139, B:187:0x0316, B:76:0x0143, B:109:0x01c3, B:79:0x014d, B:82:0x0157, B:115:0x01df, B:85:0x0161, B:91:0x017d, B:94:0x0187, B:100:0x01a3, B:106:0x01b9, B:112:0x01d5, B:117:0x01e8, B:123:0x0204, B:137:0x0246, B:151:0x0288, B:154:0x0292, B:157:0x02ae, B:160:0x02b8, B:162:0x02c1, B:180:0x0301, B:165:0x02cb, B:168:0x02d5, B:170:0x02e3, B:173:0x02ec, B:175:0x02f5, B:182:0x030a, B:189:0x031f, B:192:0x0328, B:20:0x0055), top: B:199:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0191 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:5:0x000b, B:8:0x0019, B:11:0x0033, B:17:0x0044, B:25:0x0061, B:26:0x0065, B:28:0x006a, B:31:0x0074, B:33:0x008d, B:36:0x0097, B:39:0x00a3, B:128:0x0212, B:131:0x021a, B:132:0x021e, B:134:0x0224, B:42:0x00ad, B:45:0x00b7, B:47:0x00d0, B:142:0x0254, B:145:0x025c, B:146:0x0260, B:148:0x0266, B:50:0x00da, B:53:0x00e4, B:55:0x00fd, B:103:0x01ad, B:58:0x0107, B:97:0x0191, B:61:0x0111, B:88:0x016b, B:64:0x011b, B:67:0x0125, B:120:0x01f2, B:70:0x012f, B:73:0x0139, B:187:0x0316, B:76:0x0143, B:109:0x01c3, B:79:0x014d, B:82:0x0157, B:115:0x01df, B:85:0x0161, B:91:0x017d, B:94:0x0187, B:100:0x01a3, B:106:0x01b9, B:112:0x01d5, B:117:0x01e8, B:123:0x0204, B:137:0x0246, B:151:0x0288, B:154:0x0292, B:157:0x02ae, B:160:0x02b8, B:162:0x02c1, B:180:0x0301, B:165:0x02cb, B:168:0x02d5, B:170:0x02e3, B:173:0x02ec, B:175:0x02f5, B:182:0x030a, B:189:0x031f, B:192:0x0328, B:20:0x0055), top: B:199:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean stringComparison(String variable, JSONObject values, Bundle data2) {
        if (!CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            try {
                variable.getClass();
                values.getClass();
                String key = getKey(values);
                if (key != null) {
                    String string = values.get(key).toString();
                    ArrayList<String> stringArrayList = getStringArrayList(values.optJSONArray(key));
                    if (Intrinsics.areEqual(key, "exists")) {
                        if (data2 != null && data2.containsKey(variable) == Boolean.parseBoolean(string)) {
                            return true;
                        }
                    } else if (data2 != null) {
                        String lowerCase = variable.toLowerCase(Locale.ROOT);
                        lowerCase.getClass();
                        Object obj = data2.get(lowerCase);
                        if (obj == null) {
                            obj = data2 != null ? data2.get(variable) : null;
                            if (obj != null) {
                                switch (key.hashCode()) {
                                    case -1729128927:
                                        if (key.equals("i_not_contains")) {
                                            String string2 = obj.toString();
                                            Locale locale = Locale.ROOT;
                                            String lowerCase2 = string2.toLowerCase(locale);
                                            lowerCase2.getClass();
                                            String lowerCase3 = string.toLowerCase(locale);
                                            lowerCase3.getClass();
                                            if (!StringsKt.contains$default(lowerCase2, lowerCase3)) {
                                                return true;
                                            }
                                        }
                                        break;
                                    case -1179774633:
                                        if (key.equals("is_any")) {
                                            if (stringArrayList != null) {
                                                return stringArrayList.contains(obj.toString());
                                            }
                                        }
                                        break;
                                    case -1039699439:
                                        if (key.equals("not_in")) {
                                            if (stringArrayList != null) {
                                                return stringArrayList.contains(obj.toString());
                                            }
                                        }
                                        break;
                                    case -969266188:
                                        if (key.equals("starts_with")) {
                                            return StringsKt.startsWith$default(obj.toString(), string);
                                        }
                                        break;
                                        break;
                                    case -966353971:
                                        if (key.equals("regex_match")) {
                                            return new Regex(string).matches(obj.toString());
                                        }
                                        break;
                                        break;
                                    case -665609109:
                                        if (!key.equals("is_not_any")) {
                                            break;
                                        }
                                        break;
                                    case -567445985:
                                        if (key.equals("contains")) {
                                            return StringsKt.contains$default(obj.toString(), string);
                                        }
                                        break;
                                        break;
                                    case -327990090:
                                        if (key.equals("i_str_neq")) {
                                            String string3 = obj.toString();
                                            Locale locale2 = Locale.ROOT;
                                            String lowerCase4 = string3.toLowerCase(locale2);
                                            lowerCase4.getClass();
                                            String lowerCase5 = string.toLowerCase(locale2);
                                            lowerCase5.getClass();
                                            if (!Intrinsics.areEqual(lowerCase4, lowerCase5)) {
                                                return true;
                                            }
                                        }
                                        break;
                                    case -159812115:
                                        if (key.equals("i_is_any")) {
                                            if (stringArrayList != null && !stringArrayList.isEmpty()) {
                                                for (String str : stringArrayList) {
                                                    Locale locale3 = Locale.ROOT;
                                                    String lowerCase6 = str.toLowerCase(locale3);
                                                    lowerCase6.getClass();
                                                    String lowerCase7 = obj.toString().toLowerCase(locale3);
                                                    lowerCase7.getClass();
                                                    if (Intrinsics.areEqual(lowerCase6, lowerCase7)) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case -92753547:
                                        if (key.equals("i_str_not_in")) {
                                            if (stringArrayList != null) {
                                                if (stringArrayList.isEmpty()) {
                                                    return true;
                                                }
                                                for (String str2 : stringArrayList) {
                                                    Locale locale4 = Locale.ROOT;
                                                    String lowerCase8 = str2.toLowerCase(locale4);
                                                    lowerCase8.getClass();
                                                    String lowerCase9 = obj.toString().toLowerCase(locale4);
                                                    lowerCase9.getClass();
                                                    if (Intrinsics.areEqual(lowerCase8, lowerCase9)) {
                                                        break;
                                                    }
                                                }
                                                return true;
                                            }
                                        }
                                        break;
                                    case 60:
                                        if (key.equals("<")) {
                                            if (Double.parseDouble(obj.toString()) < Double.parseDouble(string)) {
                                                return true;
                                            }
                                        }
                                        break;
                                    case 61:
                                        if (!key.equals("=")) {
                                            break;
                                        }
                                        return Intrinsics.areEqual(obj.toString(), string);
                                    case 62:
                                        if (key.equals(">")) {
                                            if (Double.parseDouble(obj.toString()) > Double.parseDouble(string)) {
                                                return true;
                                            }
                                        }
                                        break;
                                    case 1084:
                                        if (key.equals("!=")) {
                                            if (!Intrinsics.areEqual(obj.toString(), string)) {
                                                return true;
                                            }
                                        }
                                        break;
                                    case 1921:
                                        if (key.equals("<=")) {
                                            if (Double.parseDouble(obj.toString()) <= Double.parseDouble(string)) {
                                                return true;
                                            }
                                        }
                                        break;
                                    case 1952:
                                        if (!key.equals("==")) {
                                            break;
                                        }
                                        return Intrinsics.areEqual(obj.toString(), string);
                                    case 1983:
                                        if (key.equals(">=")) {
                                            if (Double.parseDouble(obj.toString()) >= Double.parseDouble(string)) {
                                                return true;
                                            }
                                        }
                                        break;
                                    case 3244:
                                        if (!key.equals("eq")) {
                                            break;
                                        }
                                        return Intrinsics.areEqual(obj.toString(), string);
                                    case 3294:
                                        if (!key.equals(UserDataStore.GENDER)) {
                                            break;
                                        }
                                        break;
                                    case 3309:
                                        if (!key.equals("gt")) {
                                            break;
                                        }
                                        break;
                                    case 3365:
                                        if (!key.equals("in")) {
                                            break;
                                        }
                                        break;
                                    case 3449:
                                        if (!key.equals("le")) {
                                            break;
                                        }
                                        break;
                                    case 3464:
                                        if (!key.equals("lt")) {
                                            break;
                                        }
                                        break;
                                    case 3511:
                                        if (!key.equals("ne")) {
                                            break;
                                        }
                                        break;
                                    case 102680:
                                        if (!key.equals("gte")) {
                                            break;
                                        }
                                        break;
                                    case 107485:
                                        if (!key.equals("lte")) {
                                            break;
                                        }
                                        break;
                                    case 108954:
                                        if (!key.equals("neq")) {
                                            break;
                                        }
                                        break;
                                    case 127966736:
                                        if (key.equals("i_str_eq")) {
                                            String string4 = obj.toString();
                                            Locale locale5 = Locale.ROOT;
                                            String lowerCase10 = string4.toLowerCase(locale5);
                                            lowerCase10.getClass();
                                            String lowerCase11 = string.toLowerCase(locale5);
                                            lowerCase11.getClass();
                                            return Intrinsics.areEqual(lowerCase10, lowerCase11);
                                        }
                                        break;
                                        break;
                                    case 127966857:
                                        if (!key.equals("i_str_in")) {
                                            break;
                                        }
                                        break;
                                    case 363990325:
                                        if (key.equals("i_contains")) {
                                            String string5 = obj.toString();
                                            Locale locale6 = Locale.ROOT;
                                            String lowerCase12 = string5.toLowerCase(locale6);
                                            lowerCase12.getClass();
                                            String lowerCase13 = string.toLowerCase(locale6);
                                            lowerCase13.getClass();
                                            return StringsKt.contains$default(lowerCase12, lowerCase13);
                                        }
                                        break;
                                        break;
                                    case 1091487233:
                                        if (!key.equals("i_is_not_any")) {
                                            break;
                                        }
                                        break;
                                    case 1918401035:
                                        if (key.equals("not_contains") && !StringsKt.contains$default(obj.toString(), string)) {
                                            return true;
                                        }
                                        break;
                                    case 1961112862:
                                        if (key.equals("i_starts_with")) {
                                            String string6 = obj.toString();
                                            Locale locale7 = Locale.ROOT;
                                            String lowerCase14 = string6.toLowerCase(locale7);
                                            lowerCase14.getClass();
                                            String lowerCase15 = string.toLowerCase(locale7);
                                            lowerCase15.getClass();
                                            return StringsKt.startsWith$default(lowerCase14, lowerCase15);
                                        }
                                        break;
                                        break;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
                return false;
            }
        }
        return false;
    }
}
