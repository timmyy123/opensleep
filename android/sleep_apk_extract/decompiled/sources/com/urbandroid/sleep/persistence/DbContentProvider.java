package com.urbandroid.sleep.persistence;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Handler;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class DbContentProvider extends ContentProvider {
    public static final Uri CONTENT_URI = Uri.parse("content://com.urbandroid.sleep.history");
    private static HashMap<String, String> historyProjectionMap;
    private static final UriMatcher uriMatcher;
    private Handler handler;
    private boolean initialized = false;
    private DbSleepRecordRepository repository;

    static {
        UriMatcher uriMatcher2 = new UriMatcher(-1);
        uriMatcher = uriMatcher2;
        uriMatcher2.addURI("com.urbandroid.sleep.history", "records", 1);
        HashMap<String, String> map = new HashMap<>();
        historyProjectionMap = map;
        map.put("_id", "_id");
        historyProjectionMap.put("comment", "comment");
        historyProjectionMap.put("framerate", "framerate");
        historyProjectionMap.put("latestToTime", "latestToTime");
        historyProjectionMap.put("recordData", "recordData");
        historyProjectionMap.put("recordFullData", "recordFullData");
        historyProjectionMap.put("rating", "rating");
        historyProjectionMap.put("startTime", "startTime");
        historyProjectionMap.put("toTime", "toTime");
        historyProjectionMap.put("timezone", "timezone");
        historyProjectionMap.put("lenAdjust", "lenAdjust");
        historyProjectionMap.put("quality", "quality");
        historyProjectionMap.put("recordNoiseData", "recordNoiseData");
        historyProjectionMap.put("cycles", "cycles");
        historyProjectionMap.put("snore", "snore");
        historyProjectionMap.put("noiseLevel", "noiseLevel");
        historyProjectionMap.put("eventLabels", "eventLabels");
        historyProjectionMap.put("events", "events");
        historyProjectionMap.put("geo", "geo");
    }

    private synchronized void lazyInitialize() {
        if (!this.initialized) {
            this.initialized = true;
            GlobalInitializator.initializeIfRequired(getContext(), this.handler);
            this.repository = SharedApplicationContext.getInstance().getSleepRecordRepository();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        lazyInitialize();
        int iDeleteByCondition = this.repository.deleteByCondition(str, strArr);
        getContext().getContentResolver().notifyChange(uri, null);
        return iDeleteByCondition;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/com.urbandroid.sleep.history";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        lazyInitialize();
        Uri uriWithAppendedId = ContentUris.withAppendedId(CONTENT_URI, this.repository.persistNewRecordFromContentValues(contentValues));
        getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
        return uriWithAppendedId;
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
    public Cursor query(final Uri uri, final String[] strArr, final String str, final String[] strArr2, final String str2) {
        lazyInitialize();
        final SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setStrict(true);
        if (uriMatcher.match(uri) != 1) {
            Gson$$ExternalSyntheticBUOutline0.m("Unknown URI ", uri);
            return null;
        }
        sQLiteQueryBuilder.setTables("records");
        sQLiteQueryBuilder.setProjectionMap(historyProjectionMap);
        return this.repository.executeRead(new IPersistentReadOperation() { // from class: com.urbandroid.sleep.persistence.DbContentProvider.1
            @Override // com.urbandroid.sleep.persistence.IPersistentReadOperation
            public Cursor execute(SQLiteDatabase sQLiteDatabase) {
                Cursor cursorQuery = sQLiteQueryBuilder.query(sQLiteDatabase, strArr, str, strArr2, null, null, str2);
                cursorQuery.setNotificationUri(DbContentProvider.this.getContext().getContentResolver(), uri);
                return cursorQuery;
            }
        });
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        lazyInitialize();
        int iUpdateRecordFromContentValues = this.repository.updateRecordFromContentValues(contentValues, str, strArr);
        getContext().getContentResolver().notifyChange(uri, null);
        return iUpdateRecordFromContentValues;
    }
}
