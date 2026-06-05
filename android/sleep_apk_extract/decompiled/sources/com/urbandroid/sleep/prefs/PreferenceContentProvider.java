package com.urbandroid.sleep.prefs;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.CustomCrashInfoProvider;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class PreferenceContentProvider extends ContentProvider {
    public static final Uri CONTENT_URI = Uri.parse("content://com.urbandroid.sleep.preference/preferences");
    private static final UriMatcher uriMatcher;
    private Handler handler;

    static {
        UriMatcher uriMatcher2 = new UriMatcher(-1);
        uriMatcher = uriMatcher2;
        uriMatcher2.addURI("com.urbandroid.sleep.preference", "preferences", 1);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Delete is not supported");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/com.urbandroid.sleep.preference";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Insert is not supported");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.handler = new Handler();
        try {
            Class.forName("android.os.AsyncTask");
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        GlobalInitializator.initializeIfRequired(getContext(), this.handler);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (uriMatcher.match(uri) != 1) {
            Gson$$ExternalSyntheticBUOutline0.m("Unknown URI ", uri);
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"VALUE", "NAME", "TYPE"});
        List listAsList = Arrays.asList(CustomCrashInfoProvider.SECURED_PREFS);
        for (Map.Entry<String, ?> entry : defaultSharedPreferences.getAll().entrySet()) {
            if (str == null || str.equals(entry.getKey())) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!listAsList.contains(key)) {
                    matrixCursor.newRow().add(value).add(key).add(value == null ? null : value.getClass().getName());
                }
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        GlobalInitializator.initializeIfRequired(getContext(), this.handler);
        int i = 0;
        if (uriMatcher.match(uri) != 1) {
            Gson$$ExternalSyntheticBUOutline0.m("Unknown URI ", uri);
            return 0;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!"key_last_setting_modification".equals(key)) {
                Object obj = defaultSharedPreferences.getAll().get(key);
                if ("health_user_profile_popup_form_allowed".equals(key) || !defaultSharedPreferences.contains(key)) {
                    if (value instanceof Boolean) {
                        editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Float) {
                        editorEdit.putFloat(key, ((Float) value).floatValue());
                    } else if (value instanceof Integer) {
                        editorEdit.putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        editorEdit.putLong(key, ((Long) value).longValue());
                    } else if (value instanceof String) {
                        editorEdit.putString(key, (String) value);
                    }
                    Logger.logInfo(String.format("Preference %s updated from %s to %s", key, obj, value));
                    i++;
                }
            }
        }
        if (i > 0) {
            editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        }
        editorEdit.apply();
        return i;
    }
}
