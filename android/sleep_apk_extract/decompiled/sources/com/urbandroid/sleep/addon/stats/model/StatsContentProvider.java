package com.urbandroid.sleep.addon.stats.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.urbandroid.sleep.addon.stats.model.collector.Average;
import com.urbandroid.sleep.addon.stats.model.collector.SemanticCollector;
import com.urbandroid.sleep.addon.stats.model.filter.DefaultTagAverageFilter;
import com.urbandroid.sleep.addon.stats.model.filter.ITagAverageFilter;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes4.dex */
public class StatsContentProvider extends ContentProvider {
    private static final UriMatcher uriMatcher;
    public static final Uri CONTENT_URI = Uri.parse("content://com.urbandroid.sleep.stats/stats");
    public static final String[] COLUMNS = {"measure", "tag", "sum", "count", "days", "lengthSum", "complementFlag"};

    static {
        UriMatcher uriMatcher2 = new UriMatcher(-1);
        uriMatcher = uriMatcher2;
        uriMatcher2.addURI("com.urbandroid.sleep.stats", "stats", 1);
    }

    private Cursor createCursor(Measure measure, SemanticCollector semanticCollector, ITagAverageFilter iTagAverageFilter) {
        TreeMap<String, Average> tagMap = semanticCollector.getTagCollector().getTagMap();
        MatrixCursor matrixCursorCreateTagCursor = createTagCursor(measure, tagMap, iTagAverageFilter, false);
        MatrixCursor matrixCursorCreateTagCursor2 = createTagCursor(measure, semanticCollector.getTagCollector().getComplementTagMap(), iTagAverageFilter, true);
        MatrixCursor matrixCursor = new MatrixCursor(COLUMNS);
        Average average = tagMap.get(" AVERAGE");
        if (average.getDays() > 0) {
            matrixCursor.addRow(new Object[]{measure.name(), "ALL_1", Double.valueOf(average.getSum()), Integer.valueOf(average.getCount()), Integer.valueOf(average.getDays()), Double.valueOf(average.getLengthSum()), Boolean.FALSE});
        }
        return new MergeCursor(new Cursor[]{matrixCursorCreateTagCursor, matrixCursorCreateTagCursor2, matrixCursor});
    }

    private MatrixCursor createTagCursor(Measure measure, TreeMap<String, Average> treeMap, ITagAverageFilter iTagAverageFilter, boolean z) {
        MatrixCursor matrixCursor = new MatrixCursor(COLUMNS);
        for (Map.Entry<String, Average> entry : treeMap.entrySet()) {
            if (iTagAverageFilter.accept(entry.getKey(), entry.getValue())) {
                matrixCursor.addRow(new Object[]{measure.name(), FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), entry.getKey(), "_1"), Double.valueOf(entry.getValue().getSum()), Integer.valueOf(entry.getValue().getCount()), Integer.valueOf(entry.getValue().getDays()), Double.valueOf(entry.getValue().getLengthSum()), Boolean.valueOf(z)});
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/com.urbandroid.sleep.stats";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (uriMatcher.match(uri) != 1) {
            Gson$$ExternalSyntheticBUOutline0.m("Unknown URI ", uri);
            return null;
        }
        GlobalInitializator.initializeIfRequired(getContext());
        int iMin = 3650;
        if (str != null) {
            try {
                iMin = Math.min(Integer.parseInt(str), 3650);
                if (iMin < 0) {
                    iMin = -iMin;
                }
            } catch (NumberFormatException unused) {
            }
        }
        StatRepo statRepo = new StatRepo();
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -iMin);
        statRepo.initialize(getContext(), calendar.getTime());
        statRepo.calculate(getContext(), calendar.getTime(), statRepo.getToDate());
        DefaultTagAverageFilter defaultTagAverageFilter = new DefaultTagAverageFilter(SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecordsCount());
        return new MergeCursor(new Cursor[]{createCursor(Measure.LENGTH, statRepo.getLengthCollector(), defaultTagAverageFilter), createCursor(Measure.QUALITY, statRepo.getQualityCollector(), defaultTagAverageFilter), createCursor(Measure.RATING, statRepo.getRatingCollector(), defaultTagAverageFilter), createCursor(Measure.SNORING, statRepo.getSnoringCollector(), defaultTagAverageFilter), createCursor(Measure.CYCLES, statRepo.getCyclesCollector(), defaultTagAverageFilter), createCursor(Measure.AWAKE, statRepo.getEfficiencyCollector(), defaultTagAverageFilter), createCursor(Measure.IRREGULARITY, statRepo.getEfficiencyCollector(), defaultTagAverageFilter)});
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
