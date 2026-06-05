package com.urbandroid.sleep.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
public interface IPersistentReadOperation {
    Cursor execute(SQLiteDatabase sQLiteDatabase);
}
