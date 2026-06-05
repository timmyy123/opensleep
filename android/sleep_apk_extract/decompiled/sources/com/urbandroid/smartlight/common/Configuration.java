package com.urbandroid.smartlight.common;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.model.Light;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010\u001a\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/smartlight/common/Configuration;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/Context;Landroid/content/SharedPreferences;)V", "getContext", "()Landroid/content/Context;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "tag", "", "getTag", "()Ljava/lang/String;", "getSelectedLightsInternal", "", "Lcom/urbandroid/smartlight/common/model/Light;", "prefs", "getSelectedLightsFallback", "getPrefs", "getSelectedLights", "save", "", "lights", "clearLights", "addLight", "light", "removeLight", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Configuration implements FeatureLogger {
    private final Context context;
    private final SharedPreferences sharedPreferences;
    private final String tag;

    public Configuration(Context context, SharedPreferences sharedPreferences) {
        context.getClass();
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        this.tag = Common_smartlightKt.TAG;
    }

    private final SharedPreferences getPrefs() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = this.context.getSharedPreferences(Common_smartlightKt.SHARED_PREFERENCES_STORE, 0);
        sharedPreferences2.getClass();
        return sharedPreferences2;
    }

    private final Set<Light> getSelectedLightsFallback() {
        List listSplit$default;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        defaultSharedPreferences.getClass();
        String string = defaultSharedPreferences.getString(ConfigurationKt.KEY_FALLBACK, null);
        if (string == null || (listSplit$default = StringsKt.split$default(string, new String[]{ConfigurationKt.DELIMITER}, 0, 6)) == null) {
            return null;
        }
        List list = listSplit$default;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Light((String) it.next(), null, null, 6, null));
        }
        return CollectionsKt.toSet(arrayList);
    }

    private final Set<Light> getSelectedLightsInternal(SharedPreferences prefs) {
        String string = prefs.getString(ConfigurationKt.KEY_LIGHT, null);
        if (string == null) {
            return null;
        }
        return (Set) new Gson().fromJson(string, new TypeToken<Set<? extends Light>>() { // from class: com.urbandroid.smartlight.common.Configuration$getSelectedLightsInternal$1$listType$1
        }.getType());
    }

    public final synchronized void addLight(Light light) {
        light.getClass();
        save(SetsKt.plus(getSelectedLights(), light));
    }

    public final synchronized void clearLights() {
        Logger.logInfo(Logger.defaultTag, getTag() + ": CLEAR Light", null);
        getPrefs().edit().remove(ConfigurationKt.KEY_LIGHT).apply();
        getPrefs().edit().remove("lights").apply();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        defaultSharedPreferences.getClass();
        defaultSharedPreferences.edit().remove(ConfigurationKt.KEY_FALLBACK).apply();
    }

    public final Context getContext() {
        return this.context;
    }

    public final Set<Light> getSelectedLights() {
        Set<Light> selectedLightsInternal = getSelectedLightsInternal(getPrefs());
        if (selectedLightsInternal == null || selectedLightsInternal.isEmpty()) {
            String str = "LOAD Fallback " + getSelectedLightsFallback() + ' ';
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + ((Object) str), null);
            selectedLightsInternal = getSelectedLightsFallback();
            if (selectedLightsInternal == null) {
                selectedLightsInternal = SetsKt.emptySet();
            }
        }
        String str2 = "LOADED " + selectedLightsInternal + ' ' + getPrefs().getString(ConfigurationKt.KEY_LIGHT, null);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + ((Object) str2), null);
        return selectedLightsInternal;
    }

    public final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final synchronized void removeLight(Light light) {
        light.getClass();
        save(SetsKt.minus(getSelectedLights(), light));
    }

    public final void save(Set<Light> lights) {
        lights.getClass();
        String json = new Gson().toJson(lights);
        String strM = FileInsert$$ExternalSyntheticOutline0.m("SAVE Light\n", json);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + ((Object) strM), null);
        getPrefs().edit().putString(ConfigurationKt.KEY_LIGHT, json).apply();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Configuration(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        context.getClass();
    }

    public /* synthetic */ Configuration(Context context, SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : sharedPreferences);
    }
}
