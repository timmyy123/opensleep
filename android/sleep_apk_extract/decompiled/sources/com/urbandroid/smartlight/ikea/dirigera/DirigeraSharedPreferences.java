package com.urbandroid.smartlight.ikea.dirigera;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes5.dex */
public class DirigeraSharedPreferences {
    private static final String HUE_SHARED_PREFERENCES_STORE = "DirigireSharedPrefs";
    private static final String IP = "Ip";
    private static final String TOKEN = "Token";
    private static DirigeraSharedPreferences instance;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSharedPreferencesEditor;

    private DirigeraSharedPreferences(Context context) {
        this.mSharedPreferences = null;
        this.mSharedPreferencesEditor = null;
        SharedPreferences sharedPreferences = context.getSharedPreferences(HUE_SHARED_PREFERENCES_STORE, 0);
        this.mSharedPreferences = sharedPreferences;
        this.mSharedPreferencesEditor = sharedPreferences.edit();
    }

    public static DirigeraSharedPreferences getInstance(Context context) {
        if (instance == null) {
            instance = new DirigeraSharedPreferences(context);
        }
        return instance;
    }

    public String getIp() {
        return this.mSharedPreferences.getString(IP, null);
    }

    public String getToken() {
        return this.mSharedPreferences.getString(TOKEN, "");
    }

    public void reset() {
        setToken(null);
    }

    public boolean setIp(String str) {
        this.mSharedPreferencesEditor.putString(IP, str);
        return this.mSharedPreferencesEditor.commit();
    }

    public boolean setToken(String str) {
        this.mSharedPreferencesEditor.putString(TOKEN, str);
        return this.mSharedPreferencesEditor.commit();
    }
}
