package com.urbandroid.sleep.alarmclock;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import java.util.HashMap;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmProvider extends ContentProvider {
    private static HashMap<String, String> projectionMap;
    private static final UriMatcher sURLMatcher;
    private SQLiteOpenHelper mOpenHelper;

    public static class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, "alarms.db", (SQLiteDatabase.CursorFactory) null, 9);
        }

        private void upgradeDbFrom5to7(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Logger.logDebug("Upgrading alarms from version 5 to version 7. Records will be preserved.");
            sQLiteDatabase.execSQL("ALTER TABLE alarms ADD COLUMN suspendtime INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE alarms ADD COLUMN ndswakeupwindow INTEGER");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE alarms (_id INTEGER PRIMARY KEY,hour INTEGER, minutes INTEGER, daysofweek INTEGER, alarmtime INTEGER, enabled INTEGER, vibrate INTEGER, message TEXT, alert TEXT, suspendtime INTEGER, ndswakeupwindow INTEGER, captcha INTEGER, generic_extension BLOB);");
            sQLiteDatabase.execSQL("INSERT INTO alarms (hour, minutes, daysofweek, alarmtime, enabled, vibrate, message, alert, suspendtime, ndswakeupwindow, captcha) VALUES (8, 30, 31, 0, 0, 1, '', 'android.resource://com.urbandroid.sleep/raw/default', 0, 30, 0);");
            sQLiteDatabase.execSQL("INSERT INTO alarms (hour, minutes, daysofweek, alarmtime, enabled, vibrate, message, alert, suspendtime, ndswakeupwindow, captcha) VALUES (9, 00, 96, 0, 0, 1, '', 'android.resource://com.urbandroid.sleep/raw/default', 0, 30, 0);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i < 7) {
                upgradeDbFrom5to7(sQLiteDatabase, i, i2);
            }
            if (i < 8) {
                sQLiteDatabase.execSQL("ALTER TABLE alarms ADD COLUMN captcha INTEGER");
            }
            if (i < 9) {
                sQLiteDatabase.execSQL("ALTER TABLE alarms ADD COLUMN generic_extension BLOB");
            }
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        sURLMatcher = uriMatcher;
        uriMatcher.addURI("com.urbandroid.sleep.alarmclock", "alarm", 1);
        uriMatcher.addURI("com.urbandroid.sleep.alarmclock", "alarm/#", 2);
        projectionMap = new HashMap<>();
        for (String str : AlarmColumns.ALARM_QUERY_COLUMNS) {
            projectionMap.put(str, str);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int iDelete;
        String str2;
        synchronized (DbSleepRecordRepository.DB_LOCK) {
            try {
                SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
                int iMatch = sURLMatcher.match(uri);
                if (iMatch == 1) {
                    iDelete = writableDatabase.delete("alarms", str, strArr);
                } else {
                    if (iMatch != 2) {
                        throw new IllegalArgumentException("Cannot delete from URL: " + uri);
                    }
                    String str3 = uri.getPathSegments().get(1);
                    Long.parseLong(str3);
                    if (TextUtils.isEmpty(str)) {
                        str2 = "_id=" + str3;
                    } else {
                        str2 = "_id=" + str3 + " AND (" + str + ")";
                    }
                    iDelete = writableDatabase.delete("alarms", str2, strArr);
                }
                getContext().getContentResolver().notifyChange(uri, null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return iDelete;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int iMatch = sURLMatcher.match(uri);
        if (iMatch == 1) {
            return "vnd.android.cursor.dir/alarms";
        }
        if (iMatch == 2) {
            return "vnd.android.cursor.item/alarms";
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Unknown URL");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriWithAppendedId;
        synchronized (DbSleepRecordRepository.DB_LOCK) {
            try {
                if (sURLMatcher.match(uri) != 1) {
                    throw new IllegalArgumentException("Cannot insert into URL: " + uri);
                }
                long jInsert = this.mOpenHelper.getWritableDatabase().insert("alarms", "message", new ContentValues(contentValues));
                if (jInsert < 0) {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                Logger.logDebug("Added alarm rowId = " + jInsert);
                uriWithAppendedId = ContentUris.withAppendedId(Alarm.Columns.CONTENT_URI, jInsert);
                getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return uriWithAppendedId;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setProjectionMap(projectionMap);
        sQLiteQueryBuilder.setStrict(true);
        int iMatch = sURLMatcher.match(uri);
        if (iMatch == 1) {
            sQLiteQueryBuilder.setTables("alarms");
        } else {
            if (iMatch != 2) {
                Gson$$ExternalSyntheticBUOutline0.m("Unknown URL ", uri);
                return null;
            }
            sQLiteQueryBuilder.setTables("alarms");
            sQLiteQueryBuilder.appendWhere("_id=");
            sQLiteQueryBuilder.appendWhere(uri.getPathSegments().get(1));
        }
        Cursor cursorQuery = sQLiteQueryBuilder.query(this.mOpenHelper.getReadableDatabase(), strArr, str, strArr2, null, null, str2);
        if (cursorQuery == null) {
            Logger.logDebug("Alarms.query: failed");
            return cursorQuery;
        }
        cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iUpdate;
        synchronized (DbSleepRecordRepository.DB_LOCK) {
            try {
                int iMatch = sURLMatcher.match(uri);
                SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
                if (iMatch != 2) {
                    throw new UnsupportedOperationException("Cannot update URL: " + uri);
                }
                long j = Long.parseLong(uri.getPathSegments().get(1));
                iUpdate = writableDatabase.update("alarms", contentValues, "_id=" + j, null);
                Logger.logDebug("*** notifyChange() rowId: " + j + " url " + uri);
                getContext().getContentResolver().notifyChange(uri, null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return iUpdate;
    }
}
