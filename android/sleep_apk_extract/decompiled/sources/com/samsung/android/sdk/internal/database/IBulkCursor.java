package com.samsung.android.sdk.internal.database;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.IInterface;

/* JADX INFO: loaded from: classes4.dex */
public interface IBulkCursor extends IInterface {
    void close();

    void deactivate();

    Bundle getExtras();

    CursorWindow getWindow(int i);

    void onMove(int i);

    int requery();

    Bundle respond(Bundle bundle);
}
