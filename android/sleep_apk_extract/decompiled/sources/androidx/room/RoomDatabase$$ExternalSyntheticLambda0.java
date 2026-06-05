package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RoomDatabase$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ RoomDatabase f$0;

    public /* synthetic */ RoomDatabase$$ExternalSyntheticLambda0(RoomDatabase roomDatabase, int i) {
        this.$r8$classId = i;
        this.f$0 = roomDatabase;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        RoomDatabase roomDatabase = this.f$0;
        switch (i) {
            case 0:
                return RoomDatabase.endTransaction$lambda$9(roomDatabase, (SupportSQLiteDatabase) obj);
            case 1:
                return RoomDatabase.beginTransaction$lambda$8(roomDatabase, (SupportSQLiteDatabase) obj);
            default:
                return RoomDatabase.createConnectionManager$lambda$1(roomDatabase, (DatabaseConfiguration) obj);
        }
    }
}
