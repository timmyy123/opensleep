package androidx.work;

import androidx.appfunctions.AppFunctionSearchSpec;
import androidx.appfunctions.compiler.core.AppFunctionPropertyDeclaration;
import androidx.appfunctions.compiler.processors.AppFunctionSerializableFactoryCodeBuilderHelper;
import androidx.compose.runtime.snapshots.GlobalSnapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.room.TransactorKt;
import androidx.room.TriggerBasedInvalidationTracker;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao_Impl;
import com.google.firebase.ai.common.APIController;
import com.google.firebase.ai.common.APIControllerKt;
import com.google.firebase.ai.type.Candidate;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.GenerateContentResponse;
import com.google.firebase.ai.type.GenerateObjectResponse;
import com.google.firebase.ai.type.TextPart;
import com.squareup.kotlinpoet.CodeWriter;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.Import;
import com.squareup.kotlinpoet.UtilKt;
import com.urbandroid.sleep.activityrecognition.ActivityIntervals;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeDetectedActivityCalculator;
import com.urbandroid.sleep.addon.stats.chart.ScoreRadarPieView;
import com.urbandroid.sleep.addon.stats.chart.SleepScoreChartBuilder;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.json.JsonBuilder;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Data$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Data$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return Data.toString$lambda$7$lambda$6((Map.Entry) obj);
            case 1:
                return AppFunctionSearchSpec.getOrQueryExpression$lambda$0((String) obj);
            case 2:
                return AppFunctionSerializableFactoryCodeBuilderHelper.appendGetterResultConstructorCallStatement$lambda$0((AppFunctionPropertyDeclaration) obj);
            case 3:
                return GlobalSnapshot._init_$lambda$2(obj);
            case 4:
                return SnapshotKt.emptyLambda$lambda$1((SnapshotIdSet) obj);
            case 5:
                return Boolean.valueOf(TransactorKt.execSQL$lambda$0((SQLiteStatement) obj));
            case 6:
                return TriggerBasedInvalidationTracker.checkInvalidatedTables$lambda$14((SQLiteStatement) obj);
            case 7:
                return WorkConstraintsTracker.areAllConstraintsMet$lambda$5((ConstraintController) obj);
            case 8:
                return SystemIdInfoDao_Impl.getWorkSpecIds$lambda$2("SELECT DISTINCT work_spec_id FROM SystemIdInfo", (SQLiteConnection) obj);
            case 9:
                return WorkProgressDao_Impl.deleteAll$lambda$3("DELETE FROM WorkProgress", (SQLiteConnection) obj);
            case 10:
                return WorkSpecDao_Impl.getScheduledWork$lambda$31("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", (SQLiteConnection) obj);
            case 11:
                return WorkSpecDao_Impl.getRunningWork$lambda$33("SELECT * FROM workspec WHERE state=1", (SQLiteConnection) obj);
            case 12:
                return WorkSpecDao_Impl.getEligibleWorkForSchedulingWithContentUris$lambda$27("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time", (SQLiteConnection) obj);
            case 13:
                return Integer.valueOf(WorkSpecDao_Impl.countNonFinishedContentUriTriggerWorkers$lambda$36("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)", (SQLiteConnection) obj));
            case 14:
                return Boolean.valueOf(WorkSpecDao_Impl.hasUnfinishedWorkFlow$lambda$22("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", (SQLiteConnection) obj));
            case 15:
                return Integer.valueOf(WorkSpecDao_Impl.resetScheduledState$lambda$48("UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)", (SQLiteConnection) obj));
            case 16:
                return APIController.client$lambda$4$lambda$3((ContentNegotiationConfig) obj);
            case 17:
                return APIControllerKt.JSON$lambda$0((JsonBuilder) obj);
            case 18:
                return Candidate.Internal.toPublic$lambda$1((Content.Builder) obj);
            case 19:
                return GenerateContentResponse.thoughtSummary_delegate$lambda$4$lambda$3((TextPart) obj);
            case 20:
                return GenerateContentResponse.text_delegate$lambda$1$lambda$0((TextPart) obj);
            case 21:
                return GenerateObjectResponse.getObject$lambda$1((TextPart) obj);
            case 22:
                return CodeWriter.importableTypes$lambda$0((String) obj);
            case 23:
                return CodeWriter.importableMembers$lambda$1((String) obj);
            case 24:
                return Boolean.valueOf(FileSpec.emit$lambda$7((String) obj));
            case 25:
                return FileSpec.emit$lambda$10((Import) obj);
            case 26:
                return UtilKt.escapeSegmentsIfNecessary$lambda$15((String) obj);
            case 27:
                return Boolean.valueOf(SleepTimeDetectedActivityCalculator.estimate$lambda$0((ActivityIntervals.Interval) obj));
            case 28:
                return Boolean.valueOf(SleepTimeDetectedActivityCalculator.estimate$lambda$2((ActivityIntervals.Interval) obj));
            default:
                return SleepScoreChartBuilder.createView$lambda$0((ScoreRadarPieView.DataRecord) obj);
        }
    }
}
