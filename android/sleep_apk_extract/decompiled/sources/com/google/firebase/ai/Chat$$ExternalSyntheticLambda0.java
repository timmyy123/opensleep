package com.google.firebase.ai;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.firebase.ai.type.Content;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Chat$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ Chat$$ExternalSyntheticLambda0(String str, int i) {
        this.$r8$classId = i;
        this.f$0 = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        String str = this.f$0;
        switch (i) {
            case 0:
                return Chat.sendMessage$lambda$2(str, (Content.Builder) obj);
            case 1:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.execSQL$lambda$7(str, (SupportSQLiteDatabase) obj);
            case 2:
                return Boolean.valueOf(DependencyDao_Impl.hasDependents$lambda$4("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", str, (SQLiteConnection) obj));
            case 3:
                return DependencyDao_Impl.getDependentWorkIds$lambda$3("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", str, (SQLiteConnection) obj);
            case 4:
                return Boolean.valueOf(DependencyDao_Impl.hasCompletedAllPrerequisites$lambda$1("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", str, (SQLiteConnection) obj));
            case 5:
                return PreferenceDao_Impl.getLongValue$lambda$1("SELECT long_value FROM Preference where `key`=?", str, (SQLiteConnection) obj);
            case 6:
                return SystemIdInfoDao_Impl.removeSystemIdInfo$lambda$4("DELETE FROM SystemIdInfo where work_spec_id=?", str, (SQLiteConnection) obj);
            case 7:
                return WorkNameDao_Impl.getNamesForWorkSpecId$lambda$2("SELECT name FROM workname WHERE work_spec_id=?", str, (SQLiteConnection) obj);
            case 8:
                return WorkProgressDao_Impl.delete$lambda$2("DELETE from WorkProgress where work_spec_id=?", str, (SQLiteConnection) obj);
            case 9:
                return WorkSpecDao_Impl.getWorkSpec$lambda$3("SELECT * FROM workspec WHERE id=?", str, (SQLiteConnection) obj);
            case 10:
                return WorkSpecDao_Impl.getState$lambda$7("SELECT state FROM workspec WHERE id=?", str, (SQLiteConnection) obj);
            case 11:
                return WorkSpecDao_Impl.getUnfinishedWorkWithName$lambda$20("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", str, (SQLiteConnection) obj);
            case 12:
                return Integer.valueOf(WorkSpecDao_Impl.setCancelledState$lambda$39("UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?", str, (SQLiteConnection) obj));
            case 13:
                return WorkSpecDao_Impl.getUnfinishedWorkWithTag$lambda$19("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", str, (SQLiteConnection) obj);
            case 14:
                return Integer.valueOf(WorkSpecDao_Impl.resetWorkSpecRunAttemptCount$lambda$44("UPDATE workspec SET run_attempt_count=0 WHERE id=?", str, (SQLiteConnection) obj));
            case 15:
                return WorkSpecDao_Impl.incrementPeriodCount$lambda$40("UPDATE workspec SET period_count=period_count+1 WHERE id=?", str, (SQLiteConnection) obj);
            case 16:
                return WorkSpecDao_Impl.getInputsFromPrerequisites$lambda$18("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", str, (SQLiteConnection) obj);
            case 17:
                return Integer.valueOf(WorkSpecDao_Impl.incrementWorkSpecRunAttemptCount$lambda$43("UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?", str, (SQLiteConnection) obj));
            case 18:
                return WorkSpecDao_Impl.delete$lambda$37("DELETE FROM workspec WHERE id=?", str, (SQLiteConnection) obj);
            case 19:
                return WorkSpecDao_Impl.getWorkSpecIdAndStatesForName$lambda$4("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", str, (SQLiteConnection) obj);
            case 20:
                return WorkTagDao_Impl.getTagsForWorkSpecId$lambda$2("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", str, (SQLiteConnection) obj);
            default:
                return GenerativeModel.generateContent$lambda$0(str, (Content.Builder) obj);
        }
    }
}
