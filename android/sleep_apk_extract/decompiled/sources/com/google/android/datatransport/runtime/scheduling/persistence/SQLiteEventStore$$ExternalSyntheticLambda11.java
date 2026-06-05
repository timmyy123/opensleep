package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda11 implements SQLiteEventStore.Function {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SQLiteEventStore f$0;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda11(SQLiteEventStore sQLiteEventStore, int i) {
        this.$r8$classId = i;
        this.f$0 = sQLiteEventStore;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        int i = this.$r8$classId;
        SQLiteEventStore sQLiteEventStore = this.f$0;
        switch (i) {
            case 0:
                return sQLiteEventStore.lambda$resetClientMetrics$23((SQLiteDatabase) obj);
            case 1:
                return sQLiteEventStore.lambda$cleanUp$11((Cursor) obj);
            default:
                return sQLiteEventStore.lambda$recordFailure$3((Cursor) obj);
        }
    }
}
