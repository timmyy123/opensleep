package com.urbandroid.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.urbandroid.sleep.R;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiprocessPreferences extends ContentProvider {
    public static Uri BASE_URI;
    public static String PREFFERENCE_AUTHORITY;
    private static UriMatcher matcher;

    /* JADX INFO: renamed from: -$$Nest$smgetLongValue, reason: not valid java name */
    public static /* bridge */ /* synthetic */ long m2175$$Nest$smgetLongValue(long j, Cursor cursor) {
        return getLongValue(cursor, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanValue(Cursor cursor, boolean z) {
        if (cursor == null) {
            return z;
        }
        if (cursor.moveToFirst()) {
            z = false;
            if (cursor.getInt(0) > 0) {
                z = true;
            }
        }
        cursor.close();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri getContentUri(Context context, String str, String str2) {
        if (BASE_URI == null) {
            init(context);
        }
        return BASE_URI.buildUpon().appendPath(str).appendPath(str2).build();
    }

    public static MultiprocessSharedPreferences getDefaultSharedPreferences(Context context) {
        return new MultiprocessSharedPreferences(context, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float getFloatValue(Cursor cursor, float f) {
        if (cursor == null) {
            return f;
        }
        if (cursor.moveToFirst()) {
            f = cursor.getFloat(0);
        }
        cursor.close();
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getIntValue(Cursor cursor, int i) {
        if (cursor == null) {
            return i;
        }
        if (cursor.moveToFirst()) {
            i = cursor.getInt(0);
        }
        cursor.close();
        return i;
    }

    private static long getLongValue(Cursor cursor, long j) {
        if (cursor == null) {
            return j;
        }
        if (cursor.moveToFirst()) {
            j = cursor.getLong(0);
        }
        cursor.close();
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getStringValue(Cursor cursor, String str) {
        if (cursor == null) {
            return str;
        }
        if (cursor.moveToFirst()) {
            str = cursor.getString(0);
        }
        cursor.close();
        return str;
    }

    private static void init(Context context) {
        PREFFERENCE_AUTHORITY = context.getString(R.string.multiprocess_preferences_authority);
        UriMatcher uriMatcher = new UriMatcher(-1);
        matcher = uriMatcher;
        uriMatcher.addURI(PREFFERENCE_AUTHORITY, "*/*", NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        BASE_URI = Uri.parse("content://" + PREFFERENCE_AUTHORITY);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (matcher.match(uri) == 65536) {
            PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext()).edit().clear().commit();
            return 0;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Unsupported uri ", uri);
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("vnd.android.cursor.item/vnd."), PREFFERENCE_AUTHORITY, ".item");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (matcher.match(uri) != 65536) {
            Gson$$ExternalSyntheticBUOutline0.m("Unsupported uri ", uri);
            return null;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext()).edit();
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (value == null) {
                editorEdit.remove(key);
            } else if (value instanceof String) {
                editorEdit.putString(key, (String) value);
            } else if (value instanceof Boolean) {
                editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Long) {
                editorEdit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Integer) {
                editorEdit.putInt(key, ((Integer) value).intValue());
            } else {
                if (!(value instanceof Float)) {
                    Gson$$ExternalSyntheticBUOutline0.m("Unsupported type ", uri);
                    return null;
                }
                editorEdit.putFloat(key, ((Float) value).floatValue());
            }
        }
        editorEdit.apply();
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (matcher != null) {
            return true;
        }
        init(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object objValueOf;
        if (matcher.match(uri) != 65536) {
            Gson$$ExternalSyntheticBUOutline0.m("Unsupported uri ", uri);
            return null;
        }
        String str3 = uri.getPathSegments().get(0);
        String str4 = uri.getPathSegments().get(1);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{str3});
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
        if (!defaultSharedPreferences.contains(str3)) {
            return matrixCursor;
        }
        MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
        if ("string".equals(str4)) {
            objValueOf = defaultSharedPreferences.getString(str3, null);
        } else if ("boolean".equals(str4)) {
            objValueOf = Integer.valueOf(defaultSharedPreferences.getBoolean(str3, false) ? 1 : 0);
        } else if ("long".equals(str4)) {
            objValueOf = Long.valueOf(defaultSharedPreferences.getLong(str3, 0L));
        } else if ("integer".equals(str4)) {
            objValueOf = Integer.valueOf(defaultSharedPreferences.getInt(str3, 0));
        } else {
            if (!"float".equals(str4)) {
                Gson$$ExternalSyntheticBUOutline0.m("Unsupported type ", uri);
                return null;
            }
            objValueOf = Float.valueOf(defaultSharedPreferences.getFloat(str3, 0.0f));
        }
        rowBuilderNewRow.add(objValueOf);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    public static class MultiprocessSharedPreferences implements SharedPreferences {
        private Context context;

        private MultiprocessSharedPreferences(Context context) {
            this.context = context;
        }

        @Override // android.content.SharedPreferences
        public boolean contains(String str) {
            return true;
        }

        @Override // android.content.SharedPreferences
        public MultiprocessEditor edit() {
            return new MultiprocessEditor(this.context, 0);
        }

        @Override // android.content.SharedPreferences
        public Map<String, ?> getAll() {
            throw new IllegalArgumentException("Not implemented");
        }

        @Override // android.content.SharedPreferences
        public boolean getBoolean(String str, boolean z) {
            return MultiprocessPreferences.getBooleanValue(this.context.getContentResolver().query(MultiprocessPreferences.getContentUri(this.context, str, "boolean"), null, null, null, null), z);
        }

        @Override // android.content.SharedPreferences
        public float getFloat(String str, float f) {
            return MultiprocessPreferences.getFloatValue(this.context.getContentResolver().query(MultiprocessPreferences.getContentUri(this.context, str, "float"), null, null, null, null), f);
        }

        @Override // android.content.SharedPreferences
        public int getInt(String str, int i) {
            return MultiprocessPreferences.getIntValue(this.context.getContentResolver().query(MultiprocessPreferences.getContentUri(this.context, str, "integer"), null, null, null, null), i);
        }

        @Override // android.content.SharedPreferences
        public long getLong(String str, long j) {
            return MultiprocessPreferences.m2175$$Nest$smgetLongValue(j, this.context.getContentResolver().query(MultiprocessPreferences.getContentUri(this.context, str, "long"), null, null, null, null));
        }

        @Override // android.content.SharedPreferences
        public String getString(String str, String str2) {
            return MultiprocessPreferences.getStringValue(this.context.getContentResolver().query(MultiprocessPreferences.getContentUri(this.context, str, "string"), null, null, null, null), str2);
        }

        @Override // android.content.SharedPreferences
        public Set<String> getStringSet(String str, Set<String> set) {
            throw new IllegalArgumentException("Not implemented");
        }

        @Override // android.content.SharedPreferences
        public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            throw new IllegalArgumentException("Not implemented");
        }

        @Override // android.content.SharedPreferences
        public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            throw new IllegalArgumentException("Not implemented");
        }

        public /* synthetic */ MultiprocessSharedPreferences(Context context, int i) {
            this(context);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class MultiprocessEditor implements SharedPreferences.Editor {
        Context context;
        private ContentValues values;

        private MultiprocessEditor(Context context) {
            this.values = new ContentValues();
            this.context = context;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.context.getContentResolver().insert(MultiprocessPreferences.getContentUri(this.context, SDKConstants.PARAM_KEY, "type"), this.values);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.context.getContentResolver().delete(MultiprocessPreferences.getContentUri(this.context, SDKConstants.PARAM_KEY, "type"), null, null);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public MultiprocessEditor putBoolean(String str, boolean z) {
            this.values.put(str, Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public MultiprocessEditor putFloat(String str, float f) {
            this.values.put(str, Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public MultiprocessEditor putInt(String str, int i) {
            this.values.put(str, Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public MultiprocessEditor putLong(String str, long j) {
            this.values.put(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public MultiprocessEditor putString(String str, String str2) {
            this.values.put(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            throw new IllegalArgumentException("Not implemented");
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.values.putNull(str);
            return this;
        }

        public /* synthetic */ MultiprocessEditor(Context context, int i) {
            this(context);
        }
    }
}
