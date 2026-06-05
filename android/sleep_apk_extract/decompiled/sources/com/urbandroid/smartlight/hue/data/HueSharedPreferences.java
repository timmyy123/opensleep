package com.urbandroid.smartlight.hue.data;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes5.dex */
public class HueSharedPreferences {
    private static final String HUE_SHARED_PREFERENCES_STORE = "HueSharedPrefs";
    private static final String LAST_CONNECTED_IP = "LastConnectedIP";
    private static final String LAST_CONNECTED_USERNAME = "LastConnectedUsername";
    private static final String LAST_SELECTED_LIGHT = "LastSelectedLight";
    private static HueSharedPreferences instance;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSharedPreferencesEditor;

    private HueSharedPreferences(Context context) {
        this.mSharedPreferences = null;
        this.mSharedPreferencesEditor = null;
        SharedPreferences sharedPreferences = context.getSharedPreferences(HUE_SHARED_PREFERENCES_STORE, 0);
        this.mSharedPreferences = sharedPreferences;
        this.mSharedPreferencesEditor = sharedPreferences.edit();
    }

    public static HueSharedPreferences getInstance(Context context) {
        if (instance == null) {
            instance = new HueSharedPreferences(context);
        }
        return instance;
    }

    public void create() {
    }

    public String getLastConnectedIPAddress() {
        return this.mSharedPreferences.getString(LAST_CONNECTED_IP, "");
    }

    public String getLastSelectedLight() {
        return this.mSharedPreferences.getString(LAST_SELECTED_LIGHT, null);
    }

    public String getUsername() {
        return this.mSharedPreferences.getString(LAST_CONNECTED_USERNAME, "");
    }

    public void reset() {
        setUsername(null);
        setLastConnectedIPAddress(null);
        setLastSelectedLight(null);
    }

    public boolean setLastConnectedIPAddress(String str) {
        this.mSharedPreferencesEditor.putString(LAST_CONNECTED_IP, str);
        return this.mSharedPreferencesEditor.commit();
    }

    public boolean setLastSelectedLight(String str) {
        this.mSharedPreferencesEditor.putString(LAST_SELECTED_LIGHT, str);
        return this.mSharedPreferencesEditor.commit();
    }

    public boolean setUsername(String str) {
        this.mSharedPreferencesEditor.putString(LAST_CONNECTED_USERNAME, str);
        return this.mSharedPreferencesEditor.commit();
    }
}
