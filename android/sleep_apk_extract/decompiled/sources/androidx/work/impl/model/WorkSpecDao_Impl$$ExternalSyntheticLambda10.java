package androidx.work.impl.model;

import android.content.Context;
import androidx.sqlite.SQLiteConnection;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class WorkSpecDao_Impl$$ExternalSyntheticLambda10 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ long f$1;

    public /* synthetic */ WorkSpecDao_Impl$$ExternalSyntheticLambda10(long j, int i) {
        this.$r8$classId = i;
        this.f$1 = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        long j = this.f$1;
        switch (i) {
            case 0:
                return WorkSpecDao_Impl.getRecentlyCompletedWork$lambda$35("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", j, (SQLiteConnection) obj);
            default:
                return Long.valueOf(ExpectedTrackingRange.Companion.calculate$lambda$5(j, (Context) obj));
        }
    }
}
