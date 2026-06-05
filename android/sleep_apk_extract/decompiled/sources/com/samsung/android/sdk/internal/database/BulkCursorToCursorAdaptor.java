package com.samsung.android.sdk.internal.database;

import android.database.AbstractWindowedCursor;
import android.database.CursorWindow;
import android.database.StaleDataException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    private IBulkCursor a;
    private String[] b;
    private boolean c;
    private int d;

    private void a() {
        if (this.a == null) {
            throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        IBulkCursor iBulkCursor = this.a;
        if (iBulkCursor != null) {
            try {
                iBulkCursor.close();
            } catch (RemoteException unused) {
                Log.w("BulkCursor", "Remote process exception when closing");
            } finally {
                this.a = null;
            }
        }
    }

    public final void closeWindow() {
        CursorWindow cursorWindow = ((AbstractWindowedCursor) this).mWindow;
        if (cursorWindow != null) {
            cursorWindow.close();
            ((AbstractWindowedCursor) this).mWindow = null;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final void deactivate() {
        super.deactivate();
        IBulkCursor iBulkCursor = this.a;
        if (iBulkCursor != null) {
            try {
                iBulkCursor.deactivate();
            } catch (RemoteException unused) {
                Log.w("BulkCursor", "Remote process exception when deactivating");
            }
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final int getColumnIndex(String str) {
        int i = 0;
        for (String str2 : this.b) {
            if (str2.equalsIgnoreCase(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final String[] getColumnNames() {
        a();
        return this.b;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final int getCount() {
        a();
        return this.d;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final Bundle getExtras() {
        a();
        try {
            return this.a.getExtras();
        } catch (RemoteException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public final void initialize(BulkCursorDescriptor bulkCursorDescriptor) {
        this.a = bulkCursorDescriptor.cursor;
        this.b = bulkCursorDescriptor.columnNames;
        this.c = bulkCursorDescriptor.wantsAllOnMoveCalls;
        this.d = bulkCursorDescriptor.count;
        CursorWindow cursorWindow = bulkCursorDescriptor.window;
        if (cursorWindow != null) {
            setWindow(cursorWindow);
        }
    }

    @Override // android.database.AbstractCursor, android.database.CrossProcessCursor
    public final boolean onMove(int i, int i2) {
        a();
        try {
            CursorWindow cursorWindow = ((AbstractWindowedCursor) this).mWindow;
            if (cursorWindow == null || i2 < cursorWindow.getStartPosition() || i2 >= ((AbstractWindowedCursor) this).mWindow.getStartPosition() + ((AbstractWindowedCursor) this).mWindow.getNumRows()) {
                setWindow(this.a.getWindow(i2));
            } else if (this.c) {
                this.a.onMove(i2);
            }
            return ((AbstractWindowedCursor) this).mWindow != null;
        } catch (RemoteException unused) {
            Log.e("BulkCursor", "Unable to get window because the remote process is dead");
            return false;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final boolean requery() {
        a();
        try {
            int iRequery = this.a.requery();
            this.d = iRequery;
            if (iRequery == -1) {
                deactivate();
                return false;
            }
            ((AbstractWindowedCursor) this).mPos = -1;
            closeWindow();
            super.requery();
            return true;
        } catch (Exception e) {
            Log.e("BulkCursor", "Unable to requery because the remote process exception " + e.getMessage());
            deactivate();
            return false;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final Bundle respond(Bundle bundle) {
        a();
        try {
            return this.a.respond(bundle);
        } catch (RemoteException e) {
            Log.w("BulkCursor", "respond() threw RemoteException, returning an empty bundle.", e);
            return Bundle.EMPTY;
        }
    }
}
