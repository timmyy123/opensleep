package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda15 implements SQLiteEventStore.Function {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SQLiteEventStore f$0;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda15(SQLiteEventStore sQLiteEventStore, Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = sQLiteEventStore;
        this.f$2 = obj;
        this.f$3 = obj2;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$3;
        Object obj3 = this.f$2;
        SQLiteEventStore sQLiteEventStore = this.f$0;
        switch (i) {
            case 0:
                return sQLiteEventStore.lambda$loadClientMetrics$20("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", (HashMap) obj3, (ClientMetrics.Builder) obj2, (SQLiteDatabase) obj);
            case 1:
                return sQLiteEventStore.lambda$loadEvents$14((ArrayList) obj3, (TransportContext) obj2, (Cursor) obj);
            case 2:
                return sQLiteEventStore.lambda$persist$1((EventInternal) obj3, (TransportContext) obj2, (SQLiteDatabase) obj);
            default:
                return sQLiteEventStore.lambda$loadClientMetrics$19((Map) obj3, (ClientMetrics.Builder) obj2, (Cursor) obj);
        }
    }
}
