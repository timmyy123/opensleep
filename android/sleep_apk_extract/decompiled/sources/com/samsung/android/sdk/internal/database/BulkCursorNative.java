package com.samsung.android.sdk.internal.database;

import android.os.Binder;
import android.os.IBinder;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BulkCursorNative extends Binder implements IBulkCursor {
    public static IBulkCursor asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IBulkCursor iBulkCursor = (IBulkCursor) iBinder.queryLocalInterface("android.content.IBulkCursor");
        return iBulkCursor != null ? iBulkCursor : new a(iBinder);
    }
}
