package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WorkSpecDao_Impl$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ WorkSpecDao_Impl$$ExternalSyntheticLambda3(int i, String str) {
        this.$r8$classId = 0;
        this.f$1 = i;
        this.f$2 = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return WorkSpecDao_Impl.setStopReason$lambda$51("UPDATE workspec SET stop_reason=? WHERE id=?", this.f$1, this.f$2, (SQLiteConnection) obj);
            case 1:
                return SystemIdInfoDao_Impl.getSystemIdInfo$lambda$1("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", this.f$2, this.f$1, (SQLiteConnection) obj);
            default:
                return WorkSpecDao_Impl.resetWorkSpecNextScheduleTimeOverride$lambda$46("UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)", this.f$2, this.f$1, (SQLiteConnection) obj);
        }
    }

    public /* synthetic */ WorkSpecDao_Impl$$ExternalSyntheticLambda3(String str, int i, int i2) {
        this.$r8$classId = i2;
        this.f$2 = str;
        this.f$1 = i;
    }
}
