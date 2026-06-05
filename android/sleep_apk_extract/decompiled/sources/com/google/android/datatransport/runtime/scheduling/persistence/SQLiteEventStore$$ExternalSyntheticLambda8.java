package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda8 implements SQLiteEventStore.Function {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SQLiteEventStore f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda8(SQLiteEventStore sQLiteEventStore, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = sQLiteEventStore;
        this.f$1 = obj;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$1;
        SQLiteEventStore sQLiteEventStore = this.f$0;
        switch (i) {
            case 0:
                return sQLiteEventStore.lambda$loadBatch$8((TransportContext) obj2, (SQLiteDatabase) obj);
            case 1:
                return sQLiteEventStore.lambda$hasPendingEventsFor$6((TransportContext) obj2, (SQLiteDatabase) obj);
            default:
                return sQLiteEventStore.lambda$recordFailure$4((String) obj2, "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", (SQLiteDatabase) obj);
        }
    }
}
