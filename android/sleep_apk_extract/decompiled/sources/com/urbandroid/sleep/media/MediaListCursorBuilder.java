package com.urbandroid.sleep.media;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b%\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 H2\u00020\u0001:\u0001HB5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ5\u0010\u0012\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0012\u0010\u0013JG\u0010\u001d\u001a\u00020\u001c*\u00060\u0014R\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020\u000e*\u00020\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020\u001c*\u00060\u0014R\u00020\u00152\u0006\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010%J#\u0010(\u001a\u00020\b*\u00020\u000e2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0001H\u0002¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u0004\u0018\u00010\u0001*\u00020\u000e2\u0006\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u000e¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u000e¢\u0006\u0004\b.\u0010/J-\u00103\u001a\u00020\u001c2\u000e\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001f2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b¢\u0006\u0004\b3\u00104J%\u00103\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b¢\u0006\u0004\b3\u00105J%\u00108\u001a\u00020\u0015*\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\b2\b\b\u0002\u00107\u001a\u00020\b¢\u0006\u0004\b8\u00109J\u001d\u0010:\u001a\u0004\u0018\u00010\u000e*\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b:\u0010;R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010<R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010=R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010AR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010B\u001a\u0004\bC\u0010DR\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010FR\u0016\u0010G\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010>¨\u0006I"}, d2 = {"Lcom/urbandroid/sleep/media/MediaListCursorBuilder;", "", "Landroid/content/res/Resources;", "resources", "Lcom/urbandroid/sleep/media/Song;", "selectedSong", "", "multiple", "", "expandedMask", "", "query", "<init>", "(Landroid/content/res/Resources;Lcom/urbandroid/sleep/media/Song;ZILjava/lang/String;)V", "Landroid/database/Cursor;", "maxShownItems", "expanded", "flag", "toCollapsible", "(Landroid/database/Cursor;Landroid/content/res/Resources;IZI)Landroid/database/Cursor;", "Landroid/database/MatrixCursor$RowBuilder;", "Landroid/database/MatrixCursor;", "", "columnNames", "id", "title", "artist", "data", "", "addValues", "(Landroid/database/MatrixCursor$RowBuilder;[Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "selectedRows", "topSelected", "(Landroid/database/Cursor;Ljava/util/List;)Landroid/database/Cursor;", "cursor", "fillFrom", "(Landroid/database/MatrixCursor$RowBuilder;Landroid/database/Cursor;)V", "column", SDKConstants.PARAM_VALUE, "findRow", "(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/Object;)I", "getAny", "(Landroid/database/Cursor;I)Ljava/lang/Object;", "toCursor", "()Landroid/database/Cursor;", "add", "(Landroid/database/Cursor;)V", "cursors", "maxCollapsedRows", "expandedFlag", "addCollapsible", "(Ljava/util/List;II)V", "(Landroid/database/Cursor;II)V", "max", "capacity", "copy", "(Landroid/database/Cursor;II)Landroid/database/MatrixCursor;", "filter", "(Landroid/database/Cursor;Ljava/lang/String;)Landroid/database/Cursor;", "Landroid/content/res/Resources;", "Lcom/urbandroid/sleep/media/Song;", "Z", "getMultiple", "()Z", "I", "Ljava/lang/String;", "getQuery", "()Ljava/lang/String;", "", "Ljava/util/List;", "selectedSongRowFound", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MediaListCursorBuilder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Cursor> cursors;
    private final int expandedMask;
    private final boolean multiple;
    private final String query;
    private final Resources resources;
    private final Song selectedSong;
    private boolean selectedSongRowFound;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/media/MediaListCursorBuilder$Companion;", "", "<init>", "()V", "GOOGLE_MUSIC_EXPAND_FLAG", "", "INTERNAL_ALARMS_EXPAND_FLAG", "EXTERNAL_ALARMS_EXPAND_FLAG", "SPOTIFY_ALARMS_EXPAND_FLAG", "ONLINE_RADIO_EXPAND_FLAG", "YOUR_TAG_EXPAND_FLAG", "YOUR_NOT_TAG_EXPAND_FLAG", "INTERNAL_ALARMS_SLEEPYHEAD_EXPAND_FLAG", "allExpandedFlag", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int allExpandedFlag() {
            return -1;
        }

        private Companion() {
        }
    }

    public MediaListCursorBuilder(Resources resources, Song song, boolean z, int i, String str) {
        resources.getClass();
        this.resources = resources;
        this.selectedSong = song;
        this.multiple = z;
        this.expandedMask = i;
        this.query = str;
        this.cursors = new ArrayList();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void addValues(MatrixCursor.RowBuilder rowBuilder, String[] strArr, int i, String str, String str2, String str3) {
        for (String str4 : strArr) {
            try {
            } catch (Exception e) {
                Logger.logWarning("MatrixCursor addValues failure", e);
            }
            switch (str4.hashCode()) {
                case -1409097913:
                    if (str4.equals("artist")) {
                        rowBuilder.add(str2);
                    } else {
                        continue;
                    }
                    break;
                case 94650:
                    if (str4.equals("_id")) {
                        rowBuilder.add(Integer.valueOf(i));
                    } else {
                        continue;
                    }
                    break;
                case 90810505:
                    if (str4.equals("_data")) {
                        rowBuilder.add(str3);
                    } else {
                        continue;
                    }
                    break;
                case 110371416:
                    if (str4.equals("title")) {
                        rowBuilder.add(str);
                    } else {
                        continue;
                    }
                    break;
                default:
                    continue;
                    break;
            }
            Logger.logWarning("MatrixCursor addValues failure", e);
        }
    }

    public static /* synthetic */ void addValues$default(MediaListCursorBuilder mediaListCursorBuilder, MatrixCursor.RowBuilder rowBuilder, String[] strArr, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str2 = "";
        }
        mediaListCursorBuilder.addValues(rowBuilder, strArr, i, str, str2, str3);
    }

    public static final int allExpandedFlag() {
        return INSTANCE.allExpandedFlag();
    }

    public static /* synthetic */ MatrixCursor copy$default(MediaListCursorBuilder mediaListCursorBuilder, Cursor cursor, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = cursor.getCount();
        }
        if ((i3 & 2) != 0) {
            i2 = cursor.getCount();
        }
        return mediaListCursorBuilder.copy(cursor, i, i2);
    }

    private final void fillFrom(MatrixCursor.RowBuilder rowBuilder, Cursor cursor) {
        Iterator<Integer> it = RangesKt.until(0, cursor.getColumnCount()).iterator();
        while (it.hasNext()) {
            rowBuilder.add(getAny(cursor, ((IntIterator) it).nextInt()));
        }
    }

    private final int findRow(Cursor cursor, String str, Object obj) {
        int columnIndex;
        if (cursor.moveToFirst() && 1 <= (columnIndex = cursor.getColumnIndex(str)) && columnIndex < cursor.getColumnCount()) {
            int i = 0;
            while (!Intrinsics.areEqual(getAny(cursor, columnIndex), obj)) {
                i++;
                if (!cursor.moveToNext()) {
                }
            }
            return i;
        }
        return -1;
    }

    private final Object getAny(Cursor cursor, int i) {
        int type = cursor.getType(i);
        return type != 1 ? type != 2 ? type != 4 ? cursor.getString(i) : cursor.getBlob(i) : Float.valueOf(cursor.getFloat(i)) : Integer.valueOf(cursor.getInt(i));
    }

    private final Cursor toCollapsible(Cursor cursor, Resources resources, int i, boolean z, int i2) {
        if (cursor.getCount() <= i || (!z && i != 0 && (cursor.getCount() <= i || cursor.getCount() - i == 1))) {
            return cursor;
        }
        int count = cursor.getCount() - i;
        if (!z) {
            MatrixCursor matrixCursorCopy = copy(cursor, i, i + 1);
            String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(resources.getString(R.string.show), " ", resources.getString(R.string.xmore, String.valueOf(count)));
            MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursorCopy.newRow();
            rowBuilderNewRow.getClass();
            String[] columnNames = cursor.getColumnNames();
            columnNames.getClass();
            addValues$default(this, rowBuilderNewRow, columnNames, -3, strM$1, null, String.valueOf(i2), 8, null);
            return matrixCursorCopy;
        }
        MatrixCursor matrixCursorCopy$default = copy$default(this, cursor, 0, cursor.getCount() + 1, 1, null);
        MatrixCursor.RowBuilder rowBuilderNewRow2 = matrixCursorCopy$default.newRow();
        rowBuilderNewRow2.getClass();
        String[] columnNames2 = matrixCursorCopy$default.getColumnNames();
        columnNames2.getClass();
        String string = resources.getString(R.string.hide);
        string.getClass();
        addValues$default(this, rowBuilderNewRow2, columnNames2, -2, string, null, i2 + "|" + count, 8, null);
        return matrixCursorCopy$default;
    }

    private final Cursor topSelected(Cursor cursor, List<Integer> list) {
        if (!cursor.moveToFirst() || list.get(0).intValue() == -1) {
            return cursor;
        }
        MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), 1);
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(matrixCursor.newRow());
        }
        int i2 = 0;
        do {
            MatrixCursor.RowBuilder rowBuilderNewRow = list.contains(Integer.valueOf(i2)) ? (MatrixCursor.RowBuilder) arrayList.remove(0) : matrixCursor.newRow();
            rowBuilderNewRow.getClass();
            fillFrom(rowBuilderNewRow, cursor);
            i2++;
        } while (cursor.moveToNext());
        return matrixCursor;
    }

    public final void add(Cursor cursor) {
        cursor.getClass();
        Cursor cursorFilter = filter(cursor, this.query);
        if (cursorFilter != null) {
            this.cursors.add(cursorFilter);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.ArrayList] */
    public final void addCollapsible(Cursor cursor, int maxCollapsedRows, int expandedFlag) {
        List<Integer> listListOf;
        ?? ListOf;
        int i;
        MediaListCursorBuilder mediaListCursorBuilder;
        int i2;
        Resources resources;
        cursor.getClass();
        Song song = this.selectedSong;
        String str = song != null ? song.uri : null;
        boolean z = this.multiple;
        if (!z && str != null && !this.selectedSongRowFound) {
            try {
                String strDecode = URLDecoder.decode(str);
                strDecode.getClass();
                listListOf = CollectionsKt.listOf(Integer.valueOf(findRow(cursor, "_data", StringsKt.replace$default(strDecode, "file://", ""))));
            } catch (Exception unused) {
                String strDecode2 = URLDecoder.decode(URLEncoder.encode(str));
                strDecode2.getClass();
                listListOf = CollectionsKt.listOf(Integer.valueOf(findRow(cursor, "_data", StringsKt.replace$default(strDecode2, "file://", ""))));
            }
        } else if (!z || str == null) {
            listListOf = CollectionsKt.listOf(-1);
        } else {
            String strDecode3 = URLDecoder.decode(str);
            strDecode3.getClass();
            if (StringsKt.startsWith$default(strDecode3, "multiple:/multiple?")) {
                List listSplit$default = StringsKt.split$default(StringsKt.replace$default(StringsKt.replace$default(strDecode3.substring(19), "s=", ""), "&", ","), new String[]{","}, 0, 6);
                ListOf = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                Iterator it = listSplit$default.iterator();
                while (it.hasNext()) {
                    ListOf.add(StringsKt.replace$default((String) it.next(), "file://", ""));
                }
            } else {
                ListOf = CollectionsKt.listOf(str);
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = ListOf.iterator();
            while (it2.hasNext()) {
                int iFindRow = findRow(cursor, "_data", (String) it2.next());
                if (iFindRow != -1) {
                    arrayList.add(Integer.valueOf(iFindRow));
                }
            }
            listListOf = arrayList.isEmpty() ? CollectionsKt.listOf(-1) : arrayList;
        }
        if (listListOf.get(0).intValue() != -1) {
            this.selectedSongRowFound = true;
        }
        boolean z2 = (this.expandedMask & expandedFlag) != 0;
        Cursor cursor2 = topSelected(cursor, listListOf);
        Resources resources2 = this.resources;
        if (maxCollapsedRows != 0 || listListOf.get(0).intValue() == -1) {
            i = maxCollapsedRows;
            mediaListCursorBuilder = this;
            i2 = expandedFlag;
            resources = resources2;
        } else {
            i = 1;
            mediaListCursorBuilder = this;
            resources = resources2;
            i2 = expandedFlag;
        }
        add(mediaListCursorBuilder.toCollapsible(cursor2, resources, i, z2, i2));
    }

    public final MatrixCursor copy(Cursor cursor, int i, int i2) {
        cursor.getClass();
        MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), i2);
        if (cursor.moveToFirst()) {
            for (int i3 = 0; i3 < i; i3++) {
                MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
                rowBuilderNewRow.getClass();
                fillFrom(rowBuilderNewRow, cursor);
                if (!cursor.moveToNext()) {
                    break;
                }
            }
        }
        return matrixCursor;
    }

    public final Cursor filter(Cursor cursor, String str) {
        cursor.getClass();
        if (str == null) {
            return cursor;
        }
        if (!cursor.moveToFirst()) {
            return null;
        }
        int columnIndex = cursor.getColumnIndex("title");
        int columnIndex2 = cursor.getColumnIndex("artist");
        if ((columnIndex < 0 || columnIndex >= cursor.getColumnCount()) && (columnIndex2 < 0 || columnIndex2 >= cursor.getColumnCount())) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames());
        do {
            if (!StringsKt.startsWith$default(String.valueOf(getAny(cursor, cursor.getColumnIndex("_data"))), "SEPARATOR") && ((columnIndex != -1 && StringsKt__StringsKt.contains((CharSequence) String.valueOf(getAny(cursor, columnIndex)), (CharSequence) str, true)) || (columnIndex2 != -1 && StringsKt__StringsKt.contains((CharSequence) String.valueOf(getAny(cursor, columnIndex2)), (CharSequence) str, true)))) {
                IntRange intRangeUntil = RangesKt.until(0, cursor.getColumnCount());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
                Iterator<Integer> it = intRangeUntil.iterator();
                while (it.hasNext()) {
                    arrayList.add(getAny(cursor, ((IntIterator) it).nextInt()));
                }
                matrixCursor.addRow(arrayList);
            }
        } while (cursor.moveToNext());
        if (matrixCursor.getCount() == 0) {
            return null;
        }
        return matrixCursor;
    }

    public final Cursor toCursor() {
        return this.cursors.isEmpty() ? new MatrixCursor(MediaListAdapter.COLUMNS, 1) : new MergeCursor((Cursor[]) this.cursors.toArray(new Cursor[0])) { // from class: com.urbandroid.sleep.media.MediaListCursorBuilder.toCursor.1
            @Override // android.database.MergeCursor, android.database.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Iterator it = MediaListCursorBuilder.this.cursors.iterator();
                while (it.hasNext()) {
                    try {
                        ((Cursor) it.next()).close();
                    } catch (Exception e) {
                        Logger.logSevere(null, e);
                    }
                }
                try {
                    super.close();
                } catch (Exception e2) {
                    Logger.logSevere(null, e2);
                }
            }
        };
    }

    public final void addCollapsible(List<? extends Cursor> cursors, int maxCollapsedRows, int expandedFlag) {
        cursors.getClass();
        if (cursors.isEmpty()) {
            addCollapsible(new MatrixCursor(new String[0], 0), 0, expandedFlag);
        } else {
            addCollapsible(new MergeCursor((Cursor[]) CollectionsKt.filterNotNull(cursors).toArray(new Cursor[0])), maxCollapsedRows, expandedFlag);
        }
    }
}
