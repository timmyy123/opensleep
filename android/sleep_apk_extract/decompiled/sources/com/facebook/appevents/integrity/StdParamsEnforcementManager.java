package com.facebook.appevents.integrity;

import android.os.Bundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014H\u0002J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00072\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014H\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\"\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00070\bj\b\u0012\u0004\u0012\u00020\u0007`\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\bj\b\u0012\u0004\u0012\u00020\u0007`\t0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\bj\b\u0012\u0004\u0012\u00020\u0007`\t0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/appevents/integrity/StdParamsEnforcementManager;", "", "()V", "enabled", "", "enumRestrictionsConfig", "", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "regexRestrictionsConfig", "configureSchemaRestrictions", "", "schema", "Lorg/json/JSONArray;", "disable", "enable", "isAnyEnumMatched", SDKConstants.PARAM_VALUE, "enumValues", "", "isAnyRegexMatched", "expressions", "loadConfigs", "loadSet", "paramValues", "processFilterParamSchemaBlocking", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "Landroid/os/Bundle;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StdParamsEnforcementManager {
    private static boolean enabled;
    public static final StdParamsEnforcementManager INSTANCE = new StdParamsEnforcementManager();
    private static Map<String, HashSet<String>> regexRestrictionsConfig = new HashMap();
    private static Map<String, HashSet<String>> enumRestrictionsConfig = new HashMap();

    private StdParamsEnforcementManager() {
    }

    private final void configureSchemaRestrictions(JSONArray schema) {
        if (CrashShieldHandler.isObjectCrashing(this) || schema == null) {
            return;
        }
        try {
            if (enabled) {
                return;
            }
            int length = schema.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = schema.getJSONObject(i);
                String string = jSONObject.getString(SDKConstants.PARAM_KEY);
                if (string != null && string.length() != 0) {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray(SDKConstants.PARAM_VALUE);
                        int length2 = jSONArray.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            boolean z = jSONArray.getJSONObject(i2).getBoolean("require_exact_match");
                            HashSet<String> hashSetLoadSet = loadSet(jSONArray.getJSONObject(i2).getJSONArray("potential_matches"));
                            if (z) {
                                Map<String, HashSet<String>> map = enumRestrictionsConfig;
                                string.getClass();
                                HashSet<String> hashSet = enumRestrictionsConfig.get(string);
                                if (hashSet != null) {
                                    hashSet.addAll(hashSetLoadSet);
                                    hashSetLoadSet = hashSet;
                                }
                                map.put(string, hashSetLoadSet);
                            } else {
                                Map<String, HashSet<String>> map2 = regexRestrictionsConfig;
                                string.getClass();
                                HashSet<String> hashSet2 = regexRestrictionsConfig.get(string);
                                if (hashSet2 != null) {
                                    hashSet2.addAll(hashSetLoadSet);
                                    hashSetLoadSet = hashSet2;
                                }
                                map2.put(string, hashSetLoadSet);
                            }
                        }
                    } catch (Exception unused) {
                        enumRestrictionsConfig.remove(string);
                        regexRestrictionsConfig.remove(string);
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void disable() {
        if (CrashShieldHandler.isObjectCrashing(StdParamsEnforcementManager.class)) {
            return;
        }
        try {
            enabled = false;
            regexRestrictionsConfig = new HashMap();
            enumRestrictionsConfig = new HashMap();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, StdParamsEnforcementManager.class);
        }
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(StdParamsEnforcementManager.class)) {
            return;
        }
        try {
            if (enabled) {
                return;
            }
            INSTANCE.loadConfigs();
            enabled = (regexRestrictionsConfig.isEmpty() && enumRestrictionsConfig.isEmpty()) ? false : true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, StdParamsEnforcementManager.class);
        }
    }

    private final boolean isAnyEnumMatched(String value, Set<String> enumValues) {
        if (!CrashShieldHandler.isObjectCrashing(this) && enumValues != null) {
            try {
                if (enumValues.isEmpty()) {
                    return false;
                }
                for (String str : enumValues) {
                    Locale locale = Locale.ROOT;
                    String lowerCase = str.toLowerCase(locale);
                    lowerCase.getClass();
                    String lowerCase2 = value.toLowerCase(locale);
                    lowerCase2.getClass();
                    if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
        return false;
    }

    private final boolean isAnyRegexMatched(String value, Set<String> expressions) {
        if (!CrashShieldHandler.isObjectCrashing(this) && expressions != null) {
            try {
                if (expressions.isEmpty()) {
                    return false;
                }
                Iterator<T> it = expressions.iterator();
                while (it.hasNext()) {
                    if (new Regex((String) it.next()).matches(value)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
        return false;
    }

    private final void loadConfigs() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            configureSchemaRestrictions(fetchedAppSettingsQueryAppSettings.getSchemaRestrictions());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final HashSet<String> loadSet(JSONArray paramValues) {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                HashSet<String> hashSetConvertJSONArrayToHashSet = Utility.convertJSONArrayToHashSet(paramValues);
                return hashSetConvertJSONArrayToHashSet == null ? new HashSet<>() : hashSetConvertJSONArrayToHashSet;
            } catch (Exception unused) {
                return new HashSet<>();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final void processFilterParamSchemaBlocking(Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(StdParamsEnforcementManager.class)) {
            return;
        }
        try {
            if (enabled && parameters != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : parameters.keySet()) {
                    String strValueOf = String.valueOf(parameters.get(str));
                    boolean z = regexRestrictionsConfig.get(str) != null;
                    boolean z2 = enumRestrictionsConfig.get(str) != null;
                    if (z || z2) {
                        StdParamsEnforcementManager stdParamsEnforcementManager = INSTANCE;
                        boolean zIsAnyRegexMatched = stdParamsEnforcementManager.isAnyRegexMatched(strValueOf, regexRestrictionsConfig.get(str));
                        boolean zIsAnyEnumMatched = stdParamsEnforcementManager.isAnyEnumMatched(strValueOf, enumRestrictionsConfig.get(str));
                        if (!zIsAnyRegexMatched && !zIsAnyEnumMatched) {
                            str.getClass();
                            arrayList.add(str);
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    parameters.remove((String) it.next());
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, StdParamsEnforcementManager.class);
        }
    }
}
