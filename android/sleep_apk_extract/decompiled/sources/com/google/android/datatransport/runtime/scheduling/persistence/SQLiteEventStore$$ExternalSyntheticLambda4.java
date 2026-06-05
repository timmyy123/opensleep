package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda4 implements SQLiteEventStore.Function {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda4(TransportContext transportContext, long j) {
        this.f$1 = j;
        this.f$0 = transportContext;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        long j = this.f$1;
        switch (i) {
            case 0:
                return ((SQLiteEventStore) obj2).lambda$cleanUp$12(j, (SQLiteDatabase) obj);
            default:
                return SQLiteEventStore.lambda$recordNextCallTime$7(j, (TransportContext) obj2, (SQLiteDatabase) obj);
        }
    }

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda4(SQLiteEventStore sQLiteEventStore, long j) {
        this.f$0 = sQLiteEventStore;
        this.f$1 = j;
    }
}
