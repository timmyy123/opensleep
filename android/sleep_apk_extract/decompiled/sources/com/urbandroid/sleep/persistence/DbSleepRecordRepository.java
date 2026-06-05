package com.urbandroid.sleep.persistence;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DbEncodingUtils;
import com.urbandroid.common.util.FloatUtil;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.ShiftedEventsFix;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordDataFilter;
import com.urbandroid.sleep.domain.SleepRecords;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.domain.undo.AddUndoOperation;
import com.urbandroid.sleep.domain.undo.DeleteUndoOperation;
import com.urbandroid.sleep.domain.undo.EditDataUndoOperation;
import com.urbandroid.sleep.domain.undo.EditRatingUndoOperation;
import com.urbandroid.sleep.domain.undo.UndoBuffer;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.gui.NoiseFilter;
import com.urbandroid.sleep.location.LocationService;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class DbSleepRecordRepository implements ISleepRecordRepository {
    public static final Object DB_LOCK = new Object();
    private final Context context;
    private SQLiteDatabase db;
    private final OpenHelper openHelper;
    private UndoBuffer undoBuffer = new UndoBuffer();
    private int pendingOperations = 0;
    private long doNotCloseBeforeTimestamp = 0;

    public static class GeoResult {
        private final int geoCount;
        private final List<String> geos;
        private final int homeFreq;
        private final int recordCount;

        public GeoResult(int i, int i2, List<String> list, int i3) {
            this.recordCount = i;
            this.geoCount = i2;
            this.geos = list;
            this.homeFreq = i3;
        }

        public List<String> getGeos() {
            return this.geos;
        }

        public int getHomeFreq() {
            return this.homeFreq;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("GeoResult{recordCount=");
            sb.append(this.recordCount);
            sb.append(", geoCount=");
            sb.append(this.geoCount);
            sb.append(", geos=");
            sb.append(this.geos);
            sb.append(", homeFreq=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.homeFreq, '}');
        }
    }

    public DbSleepRecordRepository(Context context) {
        this.context = context;
        this.openHelper = new OpenHelper(this, context, 0);
    }

    private List<Float> TODO_getFilteredHistory(float[] fArr) {
        return SleepRecordDataFilter.getPresentationFilter(100).filter(fArr);
    }

    public static Noise cursorToNoise(Cursor cursor, boolean z) {
        Long lValueOf = Long.valueOf(cursor.getLong(0));
        Long lValueOf2 = Long.valueOf(cursor.getLong(1));
        Date date = new Date(cursor.getLong(2));
        Date date2 = new Date(cursor.getLong(3));
        boolean z2 = cursor.getLong(4) > 0;
        boolean z3 = cursor.getLong(4) > 1;
        long j = cursor.getLong(4);
        String string = cursor.getString(5);
        String string2 = cursor.getString(6);
        String string3 = cursor.getString(8);
        if (string3 == null) {
            string3 = TimeZone.getDefault().getID();
        }
        Noise noise = new Noise(date, date2, string2, string3, lValueOf2);
        noise.setId(lValueOf);
        noise.setComment(string);
        noise.setStarred(z2);
        noise.setSync(z3);
        noise.setSyncId(j);
        if (z) {
            float[] fArrDecodeFloatArrayFromByteArray = new float[0];
            try {
                fArrDecodeFloatArrayFromByteArray = DbEncodingUtils.decodeFloatArrayFromByteArray(cursor.getBlob(7));
            } catch (SQLException e) {
                Logger.logSevere("Cannot read noise data blob", e);
            }
            if (fArrDecodeFloatArrayFromByteArray != null) {
                noise.setData(fArrDecodeFloatArrayFromByteArray);
            }
        }
        return noise;
    }

    public static SleepRecord cursorToRecord(Cursor cursor, boolean z, boolean z2, boolean z3) {
        SleepRecord sleepRecord;
        Date date;
        Date date2;
        Date date3;
        int i;
        float f;
        String string;
        String string2;
        float f2;
        int i2;
        int i3;
        int i4;
        float f3;
        boolean z4;
        float[] fArrDecodeFloatArrayFromByteArray;
        float[] fArrDecodeFloatArrayFromByteArray2;
        byte[] blob;
        try {
            date = new Date(cursor.getLong(cursor.getColumnIndex("startTime")));
            date2 = new Date(cursor.getLong(cursor.getColumnIndex("toTime")));
            date3 = new Date(cursor.getLong(cursor.getColumnIndex("latestToTime")));
            i = cursor.getInt(cursor.getColumnIndex("framerate"));
            f = cursor.getFloat(cursor.getColumnIndex("rating"));
            string = cursor.getString(cursor.getColumnIndex("comment"));
            string2 = cursor.getString(cursor.getColumnIndex("timezone"));
            if (string2 == null) {
                string2 = TimeZone.getDefault().getID();
            }
            f2 = cursor.getFloat(cursor.getColumnIndex("quality"));
            i2 = cursor.getInt(cursor.getColumnIndex("lenAdjust"));
            i3 = cursor.getInt(cursor.getColumnIndex("cycles"));
            i4 = cursor.getInt(cursor.getColumnIndex("snore"));
            f3 = cursor.getFloat(cursor.getColumnIndex("noiseLevel"));
            sleepRecord = null;
            z4 = cursor.getInt(cursor.getColumnIndex("finished")) == 1;
        } catch (Exception e) {
            e = e;
            sleepRecord = null;
        }
        try {
            String string3 = cursor.getString(cursor.getColumnIndex("geo"));
            SleepRecord sleepRecord2 = new SleepRecord(string2, date, date3, i);
            if (z3) {
                try {
                    fArrDecodeFloatArrayFromByteArray = DbEncodingUtils.decodeFloatArrayFromByteArray(cursor.getBlob(cursor.getColumnIndex("recordFullData")));
                } catch (SQLException e2) {
                    Logger.logSevere("Cannot read record full data blob", e2);
                    fArrDecodeFloatArrayFromByteArray = null;
                }
            } else {
                fArrDecodeFloatArrayFromByteArray = null;
            }
            if (fArrDecodeFloatArrayFromByteArray == null && z) {
                try {
                    fArrDecodeFloatArrayFromByteArray = DbEncodingUtils.decodeFloatArrayFromByteArray(cursor.getBlob(cursor.getColumnIndex("recordData")));
                } catch (SQLException e3) {
                    Logger.logSevere("Cannot read record data blob", e3);
                }
            }
            if (fArrDecodeFloatArrayFromByteArray != null) {
                sleepRecord2.addRecord(fArrDecodeFloatArrayFromByteArray);
            }
            if (z2) {
                try {
                    fArrDecodeFloatArrayFromByteArray2 = DbEncodingUtils.decodeFloatArrayFromByteArray(cursor.getBlob(cursor.getColumnIndex("recordNoiseData")));
                } catch (SQLException e4) {
                    Logger.logSevere("Cannot read record noise data blob", e4);
                    fArrDecodeFloatArrayFromByteArray2 = null;
                }
                if (fArrDecodeFloatArrayFromByteArray2 != null) {
                    sleepRecord2.addNoiseRecord(fArrDecodeFloatArrayFromByteArray2);
                }
            }
            sleepRecord2.setTo(date2);
            sleepRecord2.rateAndComment(string, f);
            sleepRecord2.setQuality(f2);
            sleepRecord2.setSnore(i4);
            sleepRecord2.setNoiseLevel(f3);
            sleepRecord2.setCycles(i3);
            sleepRecord2.setLenAdjust(i2);
            try {
                blob = cursor.getBlob(cursor.getColumnIndex("events"));
            } catch (SQLException e5) {
                Logger.logSevere("Cannot read record event labels blob", e5);
                blob = null;
            }
            if (blob == null || blob.length <= 0) {
                try {
                    sleepRecord2.setRawTimestampedEventLabels(cursor.getBlob(cursor.getColumnIndex("eventLabels")), false);
                } catch (SQLException e6) {
                    Logger.logSevere("Cannot read record old even labels blob", e6);
                }
            } else {
                sleepRecord2.setRawTimestampedEventLabels(blob, true);
            }
            SleepRecords.updateHideSleepAnalysis(sleepRecord2);
            sleepRecord2.setFinished(z4);
            sleepRecord2.setGeo(string3);
            Tag.addImplicitTags(sleepRecord2);
            ShiftedEventsFix.INSTANCE.fixShiftedEvents(sleepRecord2);
            return sleepRecord2;
        } catch (Exception e7) {
            e = e7;
            Logger.logSevere("Corrupted sleep record ", e);
            return sleepRecord;
        }
    }

    private void filterLastRecord(SleepRecord sleepRecord) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("recordData", DbEncodingUtils.encodeFloatArrayIntoByteArray(FloatUtil.wrappedFloatArrayToPrimitive((Float[]) sleepRecord.getFilteredHistory().toArray(new Float[0]))));
        this.db.update("records", contentValues, "startTime = ?", new String[]{Long.toString(sleepRecord.getFrom().getTime())});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void migrateEventLabels(SQLiteDatabase sQLiteDatabase) {
    }

    private synchronized boolean performDelete(SleepRecord sleepRecord) {
        boolean z;
        synchronized (DB_LOCK) {
            try {
                this.db = this.openHelper.getWritableDatabase();
                Logger.logDebug("Deleting sleep record " + sleepRecord);
                z = this.db.delete("records", "startTime = ?", new String[]{Long.toString(sleepRecord.getFrom().getTime())}) > 0;
            } finally {
                safeCloseDb();
            }
        }
        return z;
    }

    private synchronized int performDeleteOld(Date date) {
        int iDelete;
        synchronized (DB_LOCK) {
            try {
                SQLiteDatabase writableDatabase = this.openHelper.getWritableDatabase();
                this.db = writableDatabase;
                iDelete = writableDatabase.delete("records", "startTime < ?", new String[]{Long.toString(date.getTime())});
                if (iDelete > 0) {
                    this.undoBuffer.reset();
                }
                Logger.logDebug("Deleted older than count: " + iDelete);
                safeCloseDb();
            } catch (Throwable th) {
                safeCloseDb();
                throw th;
            }
        }
        return iDelete;
    }

    private synchronized void performPersistNewRecord(SleepRecord sleepRecord, SleepRecord sleepRecord2) {
        synchronized (DB_LOCK) {
            try {
                this.db = this.openHelper.getWritableDatabase();
                Logger.logDebug("Persisting sleep record to DB. Record start time: " + sleepRecord.getFrom());
                if (sleepRecord2 != null) {
                    filterLastRecord(sleepRecord2);
                }
                sleepRecord.computeAll();
                sleepRecord.computeNoiseLevel();
                ContentValues contentValues = new ContentValues();
                contentValues.put("startTime", Long.valueOf(sleepRecord.getFrom().getTime()));
                contentValues.put("latestToTime", Long.valueOf(sleepRecord.getLastestTo().getTime()));
                if (sleepRecord.getTo() != null) {
                    contentValues.put("toTime", Long.valueOf(sleepRecord.getTo().getTime()));
                }
                contentValues.put("framerate", Integer.valueOf(sleepRecord.getVersion()));
                contentValues.put("recordData", DbEncodingUtils.encodeFloatArrayIntoByteArray(FloatUtil.wrappedFloatArrayToPrimitive((Float[]) sleepRecord.getFilteredHistory().toArray(new Float[0]))));
                contentValues.put("timezone", sleepRecord.getTimezone());
                contentValues.put("comment", sleepRecord.getComment());
                contentValues.put("rating", Float.valueOf(sleepRecord.getRating()));
                contentValues.put("quality", Float.valueOf(sleepRecord.getQuality()));
                contentValues.put("snore", Integer.valueOf(sleepRecord.getSnore()));
                contentValues.put("noiseLevel", Float.valueOf(sleepRecord.getNoiseLevel()));
                contentValues.put("cycles", Integer.valueOf(sleepRecord.getCycles()));
                contentValues.put("lenAdjust", Integer.valueOf(sleepRecord.getLenAdjust()));
                contentValues.put("events", sleepRecord.getEvents().serializeToBytes());
                contentValues.put("finished", Integer.valueOf(sleepRecord.isFinished() ? 1 : 0));
                contentValues.put("recordNoiseData", DbEncodingUtils.encodeFloatArrayIntoByteArray(FloatUtil.wrappedFloatArrayToPrimitive((Float[]) sleepRecord.getFilteredNoiseHistory().toArray(new Float[0]))));
                contentValues.put("geo", sleepRecord.getGeo());
                this.db.insert("records", null, contentValues);
                safeCloseDb();
            } catch (Throwable th) {
                safeCloseDb();
                throw th;
            }
        }
    }

    private synchronized boolean preformRecordDataUpdate(SleepRecord sleepRecord, SleepRecord sleepRecord2) {
        boolean z;
        synchronized (DB_LOCK) {
            try {
                if (sleepRecord2.isFinished()) {
                    sleepRecord2.computeAll();
                    sleepRecord2.computeNoiseLevel();
                }
                this.db = this.openHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("recordData", DbEncodingUtils.encodeFloatArrayIntoByteArray(FloatUtil.wrappedFloatArrayToPrimitive((Float[]) sleepRecord2.getFilteredHistory().toArray(new Float[0]))));
                contentValues.put("startTime", Long.valueOf(sleepRecord2.getFrom().getTime()));
                contentValues.put("toTime", Long.valueOf(sleepRecord2.getTo().getTime()));
                contentValues.put("finished", Integer.valueOf(sleepRecord2.isFinished() ? 1 : 0));
                contentValues.put("lenAdjust", Integer.valueOf(sleepRecord2.getLenAdjust()));
                contentValues.put("quality", Float.valueOf(sleepRecord2.getQuality()));
                contentValues.put("snore", Integer.valueOf(sleepRecord2.getSnore()));
                contentValues.put("cycles", Integer.valueOf(sleepRecord2.getCycles()));
                contentValues.put("noiseLevel", Float.valueOf(sleepRecord2.getNoiseLevel()));
                contentValues.put("events", sleepRecord2.getEvents().serializeToBytes());
                contentValues.put("recordNoiseData", DbEncodingUtils.encodeFloatArrayIntoByteArray(FloatUtil.wrappedFloatArrayToPrimitive((Float[]) sleepRecord2.getFilteredNoiseHistory().toArray(new Float[0]))));
                contentValues.put("geo", sleepRecord2.getGeo());
                z = this.db.update("records", contentValues, "startTime = ?", new String[]{Long.toString(sleepRecord.getFrom().getTime())}) > 0;
                safeCloseDb();
            } catch (Throwable th) {
                safeCloseDb();
                throw th;
            }
        }
        return z;
    }

    private synchronized boolean preformRecordRatingUpdate(SleepRecord sleepRecord) {
        boolean z;
        synchronized (DB_LOCK) {
            try {
                this.db = this.openHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("comment", sleepRecord.getComment());
                contentValues.put("rating", Float.valueOf(sleepRecord.getRating()));
                z = this.db.update("records", contentValues, "startTime = ?", new String[]{Long.toString(sleepRecord.getFrom().getTime())}) > 0;
            } finally {
                safeCloseDb();
            }
        }
        return z;
    }

    private void processContentValuesOnUpdate(ContentValues contentValues) {
        byte[] asByteArray = contentValues.getAsByteArray("recordFullData");
        if (asByteArray != null) {
            contentValues.put("recordData", DbEncodingUtils.encodeFloatArrayIntoByteArray(FloatUtil.wrappedFloatArrayToPrimitive((Float[]) TODO_getFilteredHistory(DbEncodingUtils.decodeFloatArrayFromByteArray(asByteArray)).toArray(new Float[0]))));
        }
    }

    private synchronized void safeCloseDb() {
        if (this.pendingOperations > 0) {
            return;
        }
        long j = this.doNotCloseBeforeTimestamp;
        if (j == 0 || j <= System.currentTimeMillis()) {
            this.db.close();
        }
    }

    public boolean addNewSleepRecord(SleepRecord sleepRecord, UndoOperationGroup undoOperationGroup) {
        Logger.logInfo("Persisting new sleep record. Start time: " + sleepRecord.getFrom() + " To time: " + sleepRecord.getTo());
        if (undoOperationGroup == null) {
            this.undoBuffer.reset();
        } else {
            undoOperationGroup.addOperation(new AddUndoOperation(sleepRecord));
        }
        SleepRecord sleepRecordLoad = load(sleepRecord.getFrom().getTime());
        if (sleepRecordLoad == null) {
            performPersistNewRecord(sleepRecord, null);
            return true;
        }
        preformRecordDataUpdate(sleepRecordLoad, sleepRecord);
        preformRecordRatingUpdate(sleepRecord);
        return false;
    }

    public synchronized void addNoise(Noise noise) {
        synchronized (DB_LOCK) {
            try {
                this.db = this.openHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("record_id", noise.getRecordId());
                contentValues.put("startTime", Long.valueOf(noise.getFrom().getTime()));
                contentValues.put("toStime", Long.valueOf(noise.getTo().getTime()));
                contentValues.put("timezone", noise.getTimezone());
                contentValues.put("comment", noise.getComment());
                contentValues.put(ShareConstants.MEDIA_URI, noise.getUri());
                long syncId = 0;
                if (noise.getSyncId() > 0) {
                    syncId = noise.getSyncId();
                } else if (noise.isSync()) {
                    syncId = 2;
                } else if (noise.isStarred()) {
                    syncId = 1;
                }
                contentValues.put("starred", Long.valueOf(syncId));
                contentValues.put("recordData", DbEncodingUtils.encodeFloatArrayIntoByteArray(FloatUtil.wrappedFloatArrayToPrimitive(noise.getData())));
                this.db.insert("noise", null, contentValues);
                safeCloseDb();
            } catch (Throwable th) {
                safeCloseDb();
                throw th;
            }
        }
    }

    public synchronized void addUndoOperation(UndoOperationGroup undoOperationGroup) {
        this.undoBuffer.addUndoableOperation(undoOperationGroup);
    }

    public synchronized void decPendingOperations() {
        SQLiteDatabase sQLiteDatabase;
        int i = this.pendingOperations - 1;
        this.pendingOperations = i;
        if (i == 0 && (sQLiteDatabase = this.db) != null && sQLiteDatabase.isOpen()) {
            safeCloseDb();
        }
    }

    public synchronized int deleteByCondition(String str, String[] strArr) {
        int iDelete;
        synchronized (DB_LOCK) {
            try {
                this.db = this.openHelper.getWritableDatabase();
                this.undoBuffer.reset();
                Logger.logDebug("Deleting sleep record " + str + " " + strArr);
                iDelete = this.db.delete("records", str, strArr);
            } finally {
                safeCloseDb();
            }
        }
        return iDelete;
    }

    public synchronized void deleteNoise(Noise noise) {
        synchronized (DB_LOCK) {
            try {
                SQLiteDatabase writableDatabase = this.openHelper.getWritableDatabase();
                this.db = writableDatabase;
                writableDatabase.delete("noise", "_id = ?", new String[]{"" + noise.getId()});
            } finally {
                safeCloseDb();
            }
        }
    }

    public int deleteOld(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -i);
        return performDeleteOld(calendar.getTime());
    }

    @Override // com.urbandroid.sleep.persistence.ISleepRecordRepository
    public boolean deleteRecord(SleepRecord sleepRecord, UndoOperationGroup undoOperationGroup) {
        if (undoOperationGroup == null) {
            this.undoBuffer.reset();
        } else {
            undoOperationGroup.addOperation(new DeleteUndoOperation(sleepRecord));
        }
        return performDelete(sleepRecord);
    }

    public synchronized Cursor executeRead(IPersistentReadOperation iPersistentReadOperation) {
        if (iPersistentReadOperation == null) {
            return null;
        }
        this.db = this.openHelper.getReadableDatabase();
        this.doNotCloseBeforeTimestamp = System.currentTimeMillis() + 60000;
        return iPersistentReadOperation.execute(this.db);
    }

    public synchronized UndoOperationGroup getCurrentUndoOperation() {
        return this.undoBuffer.getCurrentUndoOperation();
    }

    public synchronized GeoResult getFrequentGeos(long j) {
        int sleepRecordsCount;
        LinkedList linkedList;
        int i;
        int i2;
        try {
            long jCurrentTimeMillis = j == -1 ? System.currentTimeMillis() - 29808000000L : j - 604800000;
            sleepRecordsCount = getSleepRecordsCount();
            linkedList = new LinkedList();
            LinkedList<GeoFreq> linkedList2 = new LinkedList();
            Cursor cursorQuery = null;
            try {
                SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
                this.db = readableDatabase;
                cursorQuery = readableDatabase.query("records", new String[]{"geo", "count(geo)"}, "startTime > ?", new String[]{Long.toString(jCurrentTimeMillis)}, "geo", null, "count(geo) DESC", String.valueOf(16));
                i = 0;
                i2 = 0;
                for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    int i3 = cursorQuery.getInt(1);
                    if (string != null) {
                        i2++;
                        GeoFreq geoFreq = new GeoFreq(this, i3, string, i);
                        Iterator it = linkedList2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                linkedList2.add(geoFreq);
                                break;
                            }
                            GeoFreq geoFreq2 = (GeoFreq) it.next();
                            if (LocationService.sameOrAdjacent(geoFreq2.geo, geoFreq.geo)) {
                                geoFreq2.freq += geoFreq.freq;
                                break;
                            }
                        }
                    }
                }
                Collections.sort(linkedList2, new Comparator<GeoFreq>() { // from class: com.urbandroid.sleep.persistence.DbSleepRecordRepository.1
                    @Override // java.util.Comparator
                    public int compare(GeoFreq geoFreq3, GeoFreq geoFreq4) {
                        int i4 = geoFreq3.freq;
                        int i5 = geoFreq4.freq;
                        if (i4 < i5) {
                            return 1;
                        }
                        if (i4 == i5) {
                            return geoFreq3.geo.compareTo(geoFreq4.geo);
                        }
                        return -1;
                    }
                });
                for (GeoFreq geoFreq3 : linkedList2) {
                    Logger.logInfo("Geo freq " + geoFreq3);
                    linkedList.add(geoFreq3.geo);
                    int i4 = geoFreq3.freq;
                    if (i4 > i) {
                        i = i4;
                    }
                }
                cursorQuery.close();
                if (this.db != null) {
                    safeCloseDb();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (this.db != null) {
                    safeCloseDb();
                }
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return new GeoResult(sleepRecordsCount, i2, linkedList, i);
    }

    public synchronized List<String> getLastComments(int i) {
        LinkedList linkedList;
        linkedList = new LinkedList();
        Cursor cursorQuery = null;
        try {
            SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
            this.db = readableDatabase;
            cursorQuery = readableDatabase.query("records", new String[]{"comment"}, null, null, null, null, "startTime DESC", String.valueOf(i));
            for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                if (cursorQuery.getString(0) != null) {
                    linkedList.add(cursorQuery.getString(0));
                }
            }
            cursorQuery.close();
            if (this.db != null) {
                safeCloseDb();
            }
        } finally {
        }
        return linkedList;
    }

    public SleepRecord getLastSleepRecord() {
        List<SleepRecord> listLoadRecords = loadRecords(0, 1, false);
        if (listLoadRecords.size() > 0) {
            return listLoadRecords.iterator().next();
        }
        return null;
    }

    public synchronized SleepRecord getNextRecord(long j, boolean z) {
        Throwable th;
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
            this.db = readableDatabase;
            Cursor cursorQuery = readableDatabase.query("records", null, "startTime > ?", new String[]{Long.toString(j)}, null, null, "startTime ASC", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    if (this.db != null) {
                        safeCloseDb();
                    }
                    return null;
                }
                SleepRecord sleepRecordCursorToRecord = cursorToRecord(cursorQuery, true, true, z);
                cursorQuery.close();
                if (this.db != null) {
                    safeCloseDb();
                }
                return sleepRecordCursorToRecord;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                if (this.db == null) {
                    throw th;
                }
                safeCloseDb();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public synchronized Noise getNoise(Long l) {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
            this.db = readableDatabase;
            cursorQuery = readableDatabase.query("noise", null, "_id = ?", new String[]{l.toString()}, null, null, null, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                safeCloseDb();
                return null;
            }
            Noise noiseCursorToNoise = cursorToNoise(cursorQuery, true);
            cursorQuery.close();
            safeCloseDb();
            return noiseCursorToNoise;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            safeCloseDb();
            throw th;
        }
    }

    public synchronized List<Noise> getNoises(int i, NoiseFilter noiseFilter, boolean z) {
        Cursor cursor;
        boolean z2;
        long j;
        boolean z3;
        Cursor cursorQuery;
        List<Noise> noises;
        try {
            try {
                this.db = this.openHelper.getReadableDatabase();
                SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
                sQLiteQueryBuilder.setTables("noise");
                if (noiseFilter == null || noiseFilter.getFrom() <= 0) {
                    z2 = false;
                } else {
                    sQLiteQueryBuilder.appendWhere("startTime >= " + noiseFilter.getFrom());
                    z2 = true;
                }
                if (noiseFilter == null || noiseFilter.getTo() <= 0) {
                    j = 0;
                    z3 = z2;
                } else {
                    if (z2) {
                        sQLiteQueryBuilder.appendWhere(" AND ");
                    }
                    StringBuilder sb = new StringBuilder("toStime <= ");
                    j = 0;
                    sb.append(noiseFilter.getTo() + 2000);
                    sQLiteQueryBuilder.appendWhere(sb.toString());
                    z3 = true;
                }
                if (noiseFilter != null && noiseFilter.isStarred()) {
                    if (z3) {
                        sQLiteQueryBuilder.appendWhere(" AND ");
                    }
                    sQLiteQueryBuilder.appendWhere("starred > 0");
                }
                if (noiseFilter == null || noiseFilter.getFilterString() == null || noiseFilter.getFilterString().trim().length() <= 0) {
                    SQLiteDatabase sQLiteDatabase = this.db;
                    StringBuilder sb2 = new StringBuilder("startTime");
                    sb2.append((noiseFilter == null || noiseFilter.getFrom() < j) ? " DESC" : " ASC");
                    cursorQuery = sQLiteQueryBuilder.query(sQLiteDatabase, null, null, null, null, null, sb2.toString(), "" + i);
                } else {
                    SQLiteDatabase sQLiteDatabase2 = this.db;
                    String[] strArr = {"%" + noiseFilter.getFilterString() + "%"};
                    cursorQuery = sQLiteQueryBuilder.query(sQLiteDatabase2, null, "comment like ?", strArr, null, null, "startTime".concat(noiseFilter.getFrom() >= j ? " ASC" : " DESC"), "" + i);
                }
                cursor = cursorQuery;
                try {
                    noises = getNoises(cursor, z);
                    if (cursor != null) {
                        cursor.close();
                    }
                    safeCloseDb();
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    safeCloseDb();
                    throw th;
                }
            } finally {
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return noises;
    }

    public synchronized List<Noise> getNoisesForDeletion(Date date, Date date2) {
        List<Noise> noises;
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
                this.db = readableDatabase;
                cursorQuery = date == null ? readableDatabase.query("noise", null, "starred = ? and startTime < ?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, Long.toString(date2.getTime())}, null, null, "startTime ASC", "10000") : readableDatabase.query("noise", null, "starred = ? and startTime < ? and startTime > ?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, Long.toString(date2.getTime()), Long.toString(date.getTime())}, null, null, "startTime ASC", "10000");
                noises = getNoises(cursorQuery, false);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return noises;
    }

    public synchronized List<Noise> getNoisesForRecord(long j, long j2, String str) {
        String str2;
        List<Noise> noises;
        Cursor cursorQuery = null;
        try {
            try {
                this.db = this.openHelper.getReadableDatabase();
                if (str == null || str.trim().length() <= 0) {
                    str2 = null;
                } else {
                    str2 = "%" + str + "%";
                }
                SQLiteDatabase sQLiteDatabase = this.db;
                cursorQuery = str2 != null ? sQLiteDatabase.query("noise", null, "startTime >= ? and toStime <= ? and comment like ?", new String[]{String.valueOf(j), String.valueOf(j2), str2}, null, null, "startTime ASC") : sQLiteDatabase.query("noise", null, "startTime >= ? and toStime <= ?", new String[]{String.valueOf(j), String.valueOf(j2)}, null, null, "startTime ASC");
                noises = getNoises(cursorQuery, false);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return noises;
    }

    public synchronized List<Noise> getNoisesToSync(int i) {
        List<Noise> noises;
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
                this.db = readableDatabase;
                cursorQuery = readableDatabase.query("noise", null, "starred = ?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_YES}, null, null, "startTime DESC", "" + Math.min(Math.max(i, 1), 100));
                noises = getNoises(cursorQuery, false);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return noises;
    }

    public synchronized List<Noise> getNoisesWithComment(int i, long j, long j2) {
        List<Noise> noises;
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
                this.db = readableDatabase;
                cursorQuery = readableDatabase.query("noise", null, "startTime >= ? AND toStime <= ? AND comment IS NOT NULL", new String[]{"" + j, "" + j2}, null, null, "startTime ASC", "" + i);
                noises = getNoises(cursorQuery, true);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return noises;
    }

    public synchronized List<SleepRecord> getPrevNextSleepRecords(SleepRecord sleepRecord) throws Throwable {
        try {
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(sleepRecord.getTo());
                calendar.add(5, -2);
                calendar.set(10, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                long timeInMillis = calendar.getTimeInMillis();
                calendar.add(5, 4);
                return getSleepRecords(timeInMillis, calendar.getTimeInMillis(), false);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public synchronized SleepRecord getPrevRecord(long j, boolean z) {
        Throwable th;
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
            this.db = readableDatabase;
            Cursor cursorQuery = readableDatabase.query("records", null, "startTime < ?", new String[]{Long.toString(j)}, null, null, "startTime DESC", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    if (this.db != null) {
                        safeCloseDb();
                    }
                    return null;
                }
                SleepRecord sleepRecordCursorToRecord = cursorToRecord(cursorQuery, true, true, z);
                cursorQuery.close();
                if (this.db != null) {
                    safeCloseDb();
                }
                return sleepRecordCursorToRecord;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                if (this.db == null) {
                    throw th;
                }
                safeCloseDb();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public synchronized Set<Long> getSleepRecordIds() {
        HashSet hashSet;
        hashSet = new HashSet();
        Cursor cursorQuery = null;
        try {
            SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
            this.db = readableDatabase;
            cursorQuery = readableDatabase.query("records", new String[]{"startTime"}, null, null, null, null, null);
            for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                hashSet.add(Long.valueOf(cursorQuery.getLong(0)));
            }
            cursorQuery.close();
            if (this.db != null) {
                safeCloseDb();
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (this.db != null) {
                safeCloseDb();
            }
            throw th;
        }
        return hashSet;
    }

    @Override // com.urbandroid.sleep.persistence.ISleepRecordRepository
    public synchronized List<SleepRecord> getSleepRecords(long j, long j2, boolean z) {
        LinkedList linkedList;
        Throwable th;
        linkedList = new LinkedList();
        Cursor cursor = null;
        SleepRecord sleepRecord = null;
        try {
            SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
            this.db = readableDatabase;
            Cursor cursorQuery = readableDatabase.query("records", null, "toTime >= ? and toTime <= ?", new String[]{String.valueOf(j), String.valueOf(j2)}, null, null, "startTime DESC");
            try {
                for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                    SleepRecord sleepRecordCursorToRecord = cursorToRecord(cursorQuery, z, z, false);
                    if (sleepRecordCursorToRecord == null || (sleepRecord != null && sleepRecord.getFrom().getTime() == sleepRecordCursorToRecord.getFrom().getTime())) {
                        Logger.logWarning("Ignoring duplicate or null record on load!");
                    } else {
                        linkedList.add(sleepRecordCursorToRecord);
                        sleepRecord = sleepRecordCursorToRecord;
                    }
                }
                cursorQuery.close();
                if (this.db != null) {
                    safeCloseDb();
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                if (this.db == null) {
                    throw th;
                }
                safeCloseDb();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return linkedList;
    }

    /* JADX WARN: Finally extract failed */
    public int getSleepRecordsCount(long j) {
        int iQueryNumEntries;
        synchronized (this) {
            try {
                try {
                    SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
                    this.db = readableDatabase;
                    iQueryNumEntries = (int) DatabaseUtils.queryNumEntries(readableDatabase, "records", "startTime >= ?", new String[]{String.valueOf(j)});
                    if (this.db != null) {
                        safeCloseDb();
                    }
                } catch (Throwable th) {
                    if (this.db != null) {
                        safeCloseDb();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iQueryNumEntries;
    }

    public synchronized void incPendingOperations() {
        this.pendingOperations++;
    }

    public void initialize() {
    }

    @Override // com.urbandroid.sleep.persistence.ISleepRecordRepository
    public synchronized SleepRecord load(long j) {
        return loadHelper(j, false);
    }

    @Override // com.urbandroid.sleep.persistence.ISleepRecordRepository
    public synchronized SleepRecord loadFullRecord(long j) {
        return loadHelper(j, true);
    }

    public synchronized SleepRecord loadHelper(long j, boolean z) {
        Throwable th;
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
            this.db = readableDatabase;
            Cursor cursorQuery = readableDatabase.query("records", null, "startTime = ?", new String[]{Long.toString(j)}, null, null, "startTime DESC");
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    if (this.db != null) {
                        safeCloseDb();
                    }
                    return null;
                }
                SleepRecord sleepRecordCursorToRecord = cursorToRecord(cursorQuery, true, true, z);
                cursorQuery.close();
                if (this.db != null) {
                    safeCloseDb();
                }
                return sleepRecordCursorToRecord;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                if (this.db == null) {
                    throw th;
                }
                safeCloseDb();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public synchronized List<SleepRecord> loadRecords(int i, int i2, boolean z) {
        LinkedList linkedList;
        Throwable th;
        String strValueOf;
        linkedList = new LinkedList();
        Cursor cursor = null;
        SleepRecord sleepRecord = null;
        try {
            this.db = this.openHelper.getReadableDatabase();
            if (i2 > -1) {
                strValueOf = i > -1 ? i + ", " + i2 : String.valueOf(i2);
            } else {
                strValueOf = null;
            }
            Cursor cursorQuery = this.db.query("records", null, null, null, null, null, "startTime DESC", strValueOf);
            try {
                for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                    SleepRecord sleepRecordCursorToRecord = cursorToRecord(cursorQuery, true, true, z);
                    if (sleepRecordCursorToRecord == null || (sleepRecord != null && sleepRecord.getFrom().getTime() == sleepRecordCursorToRecord.getFrom().getTime())) {
                        Logger.logWarning("Ignoring duplicate or null record on load! with from=" + sleepRecordCursorToRecord.getFrom().getTime());
                    } else {
                        linkedList.add(sleepRecordCursorToRecord);
                        sleepRecord = sleepRecordCursorToRecord;
                    }
                }
                cursorQuery.close();
                if (this.db != null) {
                    safeCloseDb();
                }
            } catch (Throwable th2) {
                cursor = cursorQuery;
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                if (this.db == null) {
                    throw th;
                }
                safeCloseDb();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return linkedList;
    }

    public SleepRecord performUndo() {
        return this.undoBuffer.performUndo();
    }

    public synchronized long persistNewRecordFromContentValues(ContentValues contentValues) {
        long jInsert;
        synchronized (DB_LOCK) {
            try {
                this.db = this.openHelper.getWritableDatabase();
                processContentValuesOnUpdate(contentValues);
                this.undoBuffer.reset();
                jInsert = this.db.insert("records", null, contentValues);
            } finally {
                safeCloseDb();
            }
        }
        return jInsert;
    }

    public boolean recordDataUpdated(SleepRecord sleepRecord, SleepRecord sleepRecord2, UndoOperationGroup undoOperationGroup) {
        if (undoOperationGroup == null) {
            this.undoBuffer.reset();
        } else {
            undoOperationGroup.addOperation(new EditDataUndoOperation(sleepRecord, sleepRecord2));
        }
        Logger.logDebug("Updating record data");
        return preformRecordDataUpdate(sleepRecord, sleepRecord2);
    }

    public boolean recordRatingUpdated(SleepRecord sleepRecord, SleepRecord sleepRecord2, UndoOperationGroup undoOperationGroup) {
        if (undoOperationGroup == null) {
            this.undoBuffer.reset();
        } else {
            undoOperationGroup.addOperation(new EditRatingUndoOperation(sleepRecord, sleepRecord2));
        }
        return preformRecordRatingUpdate(sleepRecord2);
    }

    public void renameTags(String str, String str2) {
        String strRemoveTag;
        this.db = this.openHelper.getWritableDatabase();
        Logger.logInfo("Renaming tags " + str + " -> " + str2);
        Cursor cursorQuery = this.db.query("records", new String[]{"rowid", "comment"}, null, null, null, null, "startTime DESC");
        boolean zMoveToFirst = cursorQuery.moveToFirst();
        int iUpdate = 0;
        while (zMoveToFirst) {
            long j = cursorQuery.getLong(0);
            byte[] blob = cursorQuery.getBlob(1);
            if (blob != null) {
                String str3 = new String(blob, StandardCharsets.UTF_8);
                if (Tag.hasTag(str3, str)) {
                    if (str2 == null || str2.length() == 0) {
                        strRemoveTag = Tag.removeTag(str3, "#" + str);
                    } else {
                        strRemoveTag = Tag.replaceTag(str3, str, str2);
                    }
                    if (!strRemoveTag.equals(str3)) {
                        Logger.logInfo("Renaming tags in comment " + str3 + " -> " + strRemoveTag);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("comment", strRemoveTag);
                        iUpdate += this.db.update("records", contentValues, "rowid = ?", new String[]{Long.toString(j)});
                    }
                }
                zMoveToFirst = cursorQuery.moveToNext();
            }
        }
        Logger.logInfo("Renamed tags in " + iUpdate + " records.");
    }

    public synchronized void updateNoise(Noise noise) {
        synchronized (DB_LOCK) {
            try {
                this.db = this.openHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                if (noise.isStarred()) {
                    noise.isSync();
                }
                contentValues.put("startTime", Long.valueOf(noise.getFrom().getTime()));
                contentValues.put("toStime", Long.valueOf(noise.getTo().getTime()));
                if (noise.isStarred()) {
                    long syncId = 0;
                    if (noise.getSyncId() > 0) {
                        syncId = noise.getSyncId();
                    } else if (noise.isSync()) {
                        syncId = 2;
                    } else if (noise.isStarred()) {
                        syncId = 1;
                    }
                    contentValues.put("starred", Long.valueOf(syncId));
                } else {
                    contentValues.put("starred", (Integer) 0);
                }
                contentValues.put(ShareConstants.MEDIA_URI, noise.getUri());
                contentValues.put("comment", noise.getComment());
                Logger.logInfo("UPDATE noise ");
                this.db.update("noise", contentValues, "_id = ?", new String[]{"" + noise.getId()});
                safeCloseDb();
            } catch (Throwable th) {
                safeCloseDb();
                throw th;
            }
        }
    }

    public synchronized int updateRecordFromContentValues(ContentValues contentValues, String str, String[] strArr) {
        int iUpdate;
        synchronized (DB_LOCK) {
            try {
                this.db = this.openHelper.getWritableDatabase();
                processContentValuesOnUpdate(contentValues);
                this.undoBuffer.reset();
                iUpdate = this.db.update("records", contentValues, str, strArr);
            } finally {
                safeCloseDb();
            }
        }
        return iUpdate;
    }

    public boolean updateSnore(SleepRecord sleepRecord) {
        boolean z;
        synchronized (DB_LOCK) {
            try {
                try {
                    this.db = this.openHelper.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("snore", Integer.valueOf(sleepRecord.getSnore()));
                    z = this.db.update("records", contentValues, "startTime = ?", new String[]{Long.toString(sleepRecord.getFrom().getTime())}) > 0;
                } finally {
                    safeCloseDb();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public class GeoFreq {
        public int freq;
        public String geo;

        private GeoFreq(int i, String str) {
            this.freq = i;
            this.geo = str;
        }

        public String toString() {
            return this.freq + " frq " + this.geo;
        }

        public /* synthetic */ GeoFreq(DbSleepRecordRepository dbSleepRecordRepository, int i, String str, int i2) {
            this(i, str);
        }
    }

    public final class OpenHelper extends SQLiteOpenHelper {
        private OpenHelper(Context context) {
            super(context, "sleep-track.db", (SQLiteDatabase.CursorFactory) null, 19);
        }

        private void safeAlterColumn(SQLiteDatabase sQLiteDatabase, String str) {
            try {
                sQLiteDatabase.execSQL(str);
            } catch (SQLiteException e) {
                if (e.getMessage() == null || !e.getMessage().contains("")) {
                    throw e;
                }
                Logger.logWarning("Duplicate error ignored.", e);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getReadableDatabase() {
            return super.getReadableDatabase();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            return super.getWritableDatabase();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table records (_id integer primary key, startTime integer, latestToTime integer, toTime integer, framerate integer, rating real, comment text, recordData blob, timezone text, lenAdjust integer, quality real, eventLabels blob, events blob, recordFullData blob, recordNoiseData blob, cycles integer, snore integer, noiseLevel real, finished integer, geo text);");
            sQLiteDatabase.execSQL("create index startTime_idx on records(startTime);");
            sQLiteDatabase.execSQL("create table noise (_id integer primary key, record_id integer, startTime integer, toStime integer, starred integer, comment text, uri text, recordData blob, timezone text);");
            sQLiteDatabase.execSQL("create index nstartTime_idx on noise(startTime);");
            sQLiteDatabase.execSQL("create index nrecord_id_idx on noise(_id);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i == 1) {
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN timezone TEXT");
            }
            if (i < 3) {
                sQLiteDatabase.execSQL("create table noise (_id integer primary key, record_id integer, startTime integer, toStime integer, starred integer, comment text, uri text, recordData blob, timezone text);");
                sQLiteDatabase.execSQL("create index nstartTime_idx on noise(startTime);");
                sQLiteDatabase.execSQL("create index nrecord_id_idx on noise(_id);");
            }
            if (i < 4) {
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN lenAdjust integer");
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN quality real");
            }
            if (i < 5) {
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN eventLabels blob");
            }
            if (i < 6) {
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN recordFullData blob");
            }
            if (i < 7) {
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN recordNoiseData blob");
            }
            if (i < 9) {
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN snore integer");
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN cycles integer");
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN noiseLevel real");
            }
            if (i < 16) {
                sQLiteDatabase.execSQL("UPDATE records SET snore = -1");
                sQLiteDatabase.execSQL("UPDATE records SET cycles = -1");
                sQLiteDatabase.execSQL("UPDATE records SET noiseLevel = -1");
            }
            if (i < 17) {
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN finished integer");
                sQLiteDatabase.execSQL("UPDATE records SET finished = 1");
            }
            if (i < 18) {
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN events blob");
                DbSleepRecordRepository.this.migrateEventLabels(sQLiteDatabase);
            }
            if (i < 19) {
                safeAlterColumn(sQLiteDatabase, "ALTER TABLE records ADD COLUMN geo TEXT");
            }
        }

        public /* synthetic */ OpenHelper(DbSleepRecordRepository dbSleepRecordRepository, Context context, int i) {
            this(context);
        }
    }

    public SleepRecord getLastSleepRecord(int i) {
        List<SleepRecord> listLoadRecords = loadRecords(i, 1, false);
        if (listLoadRecords.size() > 0) {
            return listLoadRecords.iterator().next();
        }
        return null;
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.urbandroid.sleep.persistence.ISleepRecordRepository
    public int getSleepRecordsCount() {
        int iQueryNumEntries;
        synchronized (this) {
            try {
                try {
                    SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
                    this.db = readableDatabase;
                    iQueryNumEntries = (int) DatabaseUtils.queryNumEntries(readableDatabase, "records");
                    if (this.db != null) {
                        safeCloseDb();
                    }
                } catch (Throwable th) {
                    if (this.db != null) {
                        safeCloseDb();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iQueryNumEntries;
    }

    @Override // com.urbandroid.sleep.persistence.ISleepRecordRepository
    public boolean addNewSleepRecord(SleepRecord sleepRecord) {
        return addNewSleepRecord(sleepRecord, null);
    }

    public synchronized List<Noise> getNoisesToSync() {
        return getNoisesToSync(50);
    }

    public List<SleepRecord> getSleepRecords(int i, int i2, boolean z) {
        return loadRecords(i, i2, z);
    }

    public synchronized Collection<Noise> getNoisesForRecord(SleepRecord sleepRecord, String str) {
        DbSleepRecordRepository dbSleepRecordRepository;
        Throwable th;
        long jCurrentTimeMillis;
        Date lastestTo;
        try {
            try {
                try {
                    if (sleepRecord.getTo() != null) {
                        lastestTo = sleepRecord.getTo();
                    } else if (sleepRecord.getLastestTo() != null) {
                        lastestTo = sleepRecord.getLastestTo();
                    } else {
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                    jCurrentTimeMillis = lastestTo.getTime();
                } catch (Throwable th2) {
                    th = th2;
                    dbSleepRecordRepository = this;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            dbSleepRecordRepository = this;
            th = th;
            throw th;
        }
        return getNoisesForRecord(sleepRecord.getFrom().getTime(), jCurrentTimeMillis, str);
    }

    public synchronized List<Noise> getNoises(int i) {
        return getNoises(i, System.currentTimeMillis());
    }

    public synchronized List<Noise> getNoises(int i, long j) {
        List<Noise> noises;
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
                this.db = readableDatabase;
                cursorQuery = readableDatabase.query("noise", null, "startTime <= ?", new String[]{"" + j}, null, null, "startTime DESC", "" + i);
                noises = getNoises(cursorQuery, true);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return noises;
    }

    public synchronized List<Noise> getNoises(int i, long j, long j2) {
        List<Noise> noises;
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase readableDatabase = this.openHelper.getReadableDatabase();
                this.db = readableDatabase;
                cursorQuery = readableDatabase.query("noise", null, "startTime >= ? AND toStime <= ?", new String[]{"" + j, "" + j2}, null, null, "startTime ASC", "" + i);
                noises = getNoises(cursorQuery, true);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                safeCloseDb();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return noises;
    }

    public synchronized List<Noise> getNoises(int i, NoiseFilter noiseFilter) {
        return getNoises(i, noiseFilter, false);
    }

    private List<Noise> getNoises(Cursor cursor, boolean z) {
        ArrayList arrayList = new ArrayList();
        boolean zMoveToFirst = cursor.moveToFirst();
        while (zMoveToFirst) {
            arrayList.add(cursorToNoise(cursor, z));
            zMoveToFirst = cursor.moveToNext();
        }
        return arrayList;
    }
}
