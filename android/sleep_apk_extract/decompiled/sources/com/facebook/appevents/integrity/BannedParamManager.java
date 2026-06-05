package com.facebook.appevents.integrity;

import android.os.Bundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashSet;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007J\b\u0010\r\u001a\u00020\u000bH\u0002J\"\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/integrity/BannedParamManager;", "", "()V", "BANNED_PARAMS_KEY", "", "bannedParamsConfig", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "enabled", "", "disable", "", "enable", "loadConfigs", "loadSet", "paramValues", "Lorg/json/JSONArray;", "processFilterBannedParams", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "Landroid/os/Bundle;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BannedParamManager {
    private static final String BANNED_PARAMS_KEY = "_bannedParams";
    public static final BannedParamManager INSTANCE = new BannedParamManager();
    private static HashSet<String> bannedParamsConfig = new HashSet<>();
    private static boolean enabled;

    private BannedParamManager() {
    }

    public static final void disable() {
        if (CrashShieldHandler.isObjectCrashing(BannedParamManager.class)) {
            return;
        }
        try {
            enabled = false;
            bannedParamsConfig = new HashSet<>();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BannedParamManager.class);
        }
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(BannedParamManager.class)) {
            return;
        }
        try {
            if (enabled) {
                return;
            }
            INSTANCE.loadConfigs();
            enabled = !bannedParamsConfig.isEmpty();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BannedParamManager.class);
        }
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
            bannedParamsConfig = loadSet(fetchedAppSettingsQueryAppSettings.getBannedParams());
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

    public static final void processFilterBannedParams(Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(BannedParamManager.class)) {
            return;
        }
        try {
            if (enabled && parameters != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : bannedParamsConfig) {
                    if (parameters.containsKey(str)) {
                        parameters.remove(str);
                        jSONArray.put(str);
                    }
                }
                if (jSONArray.length() > 0) {
                    parameters.putString(BANNED_PARAMS_KEY, jSONArray.toString());
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BannedParamManager.class);
        }
    }
}
