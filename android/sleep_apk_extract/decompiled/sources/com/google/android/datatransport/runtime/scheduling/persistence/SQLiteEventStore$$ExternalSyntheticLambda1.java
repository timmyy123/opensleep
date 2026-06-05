package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda1 implements SQLiteEventStore.Function {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return SQLiteEventStore.lambda$ensureBeginTransaction$25((Throwable) obj);
            case 1:
                return SQLiteEventStore.lambda$loadActiveContexts$9((Cursor) obj);
            case 2:
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            case 3:
                return SQLiteEventStore.lambda$recordLogEventDropped$17((Cursor) obj);
            case 4:
                return SQLiteEventStore.lambda$getTransportContextId$2((Cursor) obj);
            case 5:
                return SQLiteEventStore.lambda$readPayload$15((Cursor) obj);
            case 6:
                return SQLiteEventStore.lambda$getDb$0((Throwable) obj);
            case 7:
                return SQLiteEventStore.lambda$loadActiveContexts$10((SQLiteDatabase) obj);
            default:
                return SQLiteEventStore.lambda$getNextCallTime$5((Cursor) obj);
        }
    }
}
