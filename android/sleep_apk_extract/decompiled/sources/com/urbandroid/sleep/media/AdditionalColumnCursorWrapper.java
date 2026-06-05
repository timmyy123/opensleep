package com.urbandroid.sleep.media;

import android.database.Cursor;
import android.database.CursorWrapper;

/* JADX INFO: loaded from: classes.dex */
class AdditionalColumnCursorWrapper extends CursorWrapper {
    private String columnName;
    private String value;

    public AdditionalColumnCursorWrapper(Cursor cursor, String str, String str2) {
        super(cursor);
        this.columnName = str;
        this.value = str2;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnCount() {
        return getWrappedCursor().getColumnCount() + 1;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnIndex(String str) {
        return (str == null || !str.equals(str)) ? getWrappedCursor().getColumnIndex(str) : getWrappedCursor().getColumnCount();
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        return (str == null || !str.equals(str)) ? getWrappedCursor().getColumnIndexOrThrow(str) : getWrappedCursor().getColumnCount();
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String getColumnName(int i) {
        return i == getWrappedCursor().getColumnCount() ? this.columnName : getWrappedCursor().getColumnName(i);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String[] getColumnNames() {
        String[] columnNames = getWrappedCursor().getColumnNames();
        String[] strArr = new String[columnNames.length + 1];
        System.arraycopy(columnNames, 0, strArr, 0, columnNames.length);
        strArr[columnNames.length] = this.columnName;
        return strArr;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String getString(int i) {
        return i == getWrappedCursor().getColumnCount() ? this.value : getWrappedCursor().getString(i);
    }
}
