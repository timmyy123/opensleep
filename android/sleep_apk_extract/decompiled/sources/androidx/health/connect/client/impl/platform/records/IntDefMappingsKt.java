package androidx.health.connect.client.impl.platform.records;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010$\n\u0002\bc\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0002\u001a\u0013\u0010\u0005\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0002\u001a\u0013\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0002\u001a\u0013\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\u0002\u001a\u0013\u0010\b\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\u0002\u001a\u0013\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\u0002\u001a\u0013\u0010\n\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u0002\u001a\u0013\u0010\u000b\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\u0002\u001a\u0013\u0010\f\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\u0002\u001a\u0013\u0010\r\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u0002\u001a\u0013\u0010\u000e\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u0002\u001a\u0013\u0010\u000f\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0002\u001a\u0013\u0010\u0010\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0010\u0010\u0002\u001a\u0013\u0010\u0011\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0011\u0010\u0002\u001a\u0013\u0010\u0012\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0012\u0010\u0002\u001a\u0013\u0010\u0013\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0013\u0010\u0002\u001a\u0013\u0010\u0014\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0014\u0010\u0002\u001a\u0013\u0010\u0015\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0015\u0010\u0002\u001a\u0013\u0010\u0016\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0016\u0010\u0002\u001a\u0013\u0010\u0017\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0017\u0010\u0002\u001a\u0013\u0010\u0018\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0018\u0010\u0002\u001a\u0013\u0010\u0019\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0019\u0010\u0002\u001a\u0013\u0010\u001a\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u001a\u0010\u0002\u001a\u0013\u0010\u001b\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u001b\u0010\u0002\u001a\u0013\u0010\u001c\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u001c\u0010\u0002\u001a\u0013\u0010\u001d\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u001d\u0010\u0002\u001a\u0013\u0010\u001e\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u001e\u0010\u0002\u001a\u0013\u0010\u001f\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u001f\u0010\u0002\u001a\u0013\u0010 \u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b \u0010\u0002\u001a\u0013\u0010!\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b!\u0010\u0002\u001a\u0013\u0010\"\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\"\u0010\u0002\u001a\u0013\u0010#\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b#\u0010\u0002\u001a\u0013\u0010$\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b$\u0010\u0002\u001a\u0013\u0010%\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b%\u0010\u0002\u001a\u0013\u0010&\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b&\u0010\u0002\u001a\u0013\u0010'\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b'\u0010\u0002\u001a+\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(*\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(H\u0002¢\u0006\u0004\b)\u0010*\u001a\u0013\u0010+\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b+\u0010\u0002\"&\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"&\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b0\u0010-\u001a\u0004\b1\u0010/\"&\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"&\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u0010/\"&\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b6\u0010-\u001a\u0004\b7\u0010/\"&\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b8\u0010-\u001a\u0004\b9\u0010/\"&\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010-\u001a\u0004\b;\u0010/\"&\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b<\u0010-\u001a\u0004\b=\u0010/\"&\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010-\u001a\u0004\b?\u0010/\"&\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b@\u0010-\u001a\u0004\bA\u0010/\"&\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bB\u0010-\u001a\u0004\bC\u0010/\"&\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010-\u001a\u0004\bE\u0010/\"&\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010-\u001a\u0004\bG\u0010/\"&\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bH\u0010-\u001a\u0004\bI\u0010/\"&\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bJ\u0010-\u001a\u0004\bK\u0010/\"&\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bL\u0010-\u001a\u0004\bM\u0010/\"&\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bN\u0010-\u001a\u0004\bO\u0010/\"&\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bP\u0010-\u001a\u0004\bQ\u0010/\"&\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bR\u0010-\u001a\u0004\bS\u0010/\"&\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bT\u0010-\u001a\u0004\bU\u0010/\"&\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bV\u0010-\u001a\u0004\bW\u0010/\"&\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bX\u0010-\u001a\u0004\bY\u0010/\"&\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bZ\u0010-\u001a\u0004\b[\u0010/\"&\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\\\u0010-\u001a\u0004\b]\u0010/\"&\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b^\u0010-\u001a\u0004\b_\u0010/\"&\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b`\u0010-\u001a\u0004\ba\u0010/\"&\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bb\u0010-\u001a\u0004\bc\u0010/\"&\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bd\u0010-\u001a\u0004\be\u0010/\"&\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bf\u0010-\u001a\u0004\bg\u0010/\"&\u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bh\u0010-\u001a\u0004\bi\u0010/\"&\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bj\u0010-\u001a\u0004\bk\u0010/\"&\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bl\u0010-\u001a\u0004\bm\u0010/\"&\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bn\u0010-\u001a\u0004\bo\u0010/\"&\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bp\u0010-\u001a\u0004\bq\u0010/\",\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\br\u0010-\u0012\u0004\bt\u0010u\u001a\u0004\bs\u0010/\",\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\bv\u0010-\u0012\u0004\bx\u0010u\u001a\u0004\bw\u0010/\"&\u0010y\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\by\u0010-\u001a\u0004\bz\u0010/\",\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b{\u0010-\u0012\u0004\b}\u0010u\u001a\u0004\b|\u0010/\"&\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b~\u0010-\u001a\u0004\b\u007f\u0010/\"0\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010-\u0012\u0005\b\u0082\u0001\u0010u\u001a\u0005\b\u0081\u0001\u0010/\")\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010-\u001a\u0005\b\u0084\u0001\u0010/\")\u0010\u0085\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010-\u001a\u0005\b\u0086\u0001\u0010/\")\u0010\u0087\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010-\u001a\u0005\b\u0088\u0001\u0010/\")\u0010\u0089\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(8\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010-\u001a\u0005\b\u008a\u0001\u0010/¨\u0006\u008b\u0001"}, d2 = {"", "toPlatformMindfulnessSessionType", "(I)I", "toPlatformExerciseCategory", "toPlatformCervicalMucusAppearance", "toPlatformBloodPressureBodyPosition", "toPlatformExerciseSessionType", "toPlatformExerciseSegmentType", "toPlatformMealType", "toPlatformVo2MaxMeasurementMethod", "toPlatformMenstruationFlow", "toPlatformBodyTemperatureMeasurementLocation", "toPlatformBloodPressureMeasurementLocation", "toPlatformOvulationTestResult", "toPlatformCervicalMucusSensation", "toPlatformSexualActivityProtectionUsed", "toPlatformSkinTemperatureMeasurementLocation", "toPlatformBloodGlucoseSpecimenSource", "toPlatformBloodGlucoseRelationToMeal", "toPlatformSleepStageType", "toPlatformRecordingMethod", "toSdkBloodPressureBodyPosition", "toSdkBloodPressureMeasurementLocation", "toSdkExerciseSessionType", "toSdkExerciseSegmentType", "toSdkExerciseCategory", "toSdkVo2MaxMeasurementMethod", "toSdkMenstruationFlow", "toSdkMindfulnessSessionType", "toSdkProtectionUsed", "toSdkCervicalMucusSensation", "toSdkBloodGlucoseSpecimenSource", "toSdkMealType", "toSdkOvulationTestResult", "toSdkRelationToMeal", "toSdkBodyTemperatureMeasurementLocation", "toSdkCervicalMucusAppearance", "toSdkSleepStageType", "toSdkSkinTemperatureMeasurementLocation", "toSdkRecordingMethod", "", "reversed", "(Ljava/util/Map;)Ljava/util/Map;", "toSdkDevice", "SDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE", "Ljava/util/Map;", "getSDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE", "()Ljava/util/Map;", "PLATFORM_TO_SDK_CERVICAL_MUCUS_APPEARANCE", "getPLATFORM_TO_SDK_CERVICAL_MUCUS_APPEARANCE", "SDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION", "getSDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION", "PLATFORM_TO_SDK_BLOOD_PRESSURE_BODY_POSITION", "getPLATFORM_TO_SDK_BLOOD_PRESSURE_BODY_POSITION", "SDK_TO_PLATFORM_EXERCISE_SESSION_TYPE", "getSDK_TO_PLATFORM_EXERCISE_SESSION_TYPE", "PLATFORM_TO_SDK_EXERCISE_SESSION_TYPE", "getPLATFORM_TO_SDK_EXERCISE_SESSION_TYPE", "SDK_TO_PLATFORM_MEAL_TYPE", "getSDK_TO_PLATFORM_MEAL_TYPE", "PLATFORM_TO_SDK_MEAL_TYPE", "getPLATFORM_TO_SDK_MEAL_TYPE", "SDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD", "getSDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD", "PLATFORM_TO_SDK_VO2_MAX_MEASUREMENT_METHOD", "getPLATFORM_TO_SDK_VO2_MAX_MEASUREMENT_METHOD", "SDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE", "getSDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE", "PLATFORM_TO_SDK_MENSTRUATION_FLOW_TYPE", "getPLATFORM_TO_SDK_MENSTRUATION_FLOW_TYPE", "SDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION", "getSDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION", "PLATFORM_TO_SDK_BODY_TEMPERATURE_MEASUREMENT_LOCATION", "getPLATFORM_TO_SDK_BODY_TEMPERATURE_MEASUREMENT_LOCATION", "SDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION", "getSDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION", "PLATFORM_TO_SDK_BLOOD_PRESSURE_MEASUREMENT_LOCATION", "getPLATFORM_TO_SDK_BLOOD_PRESSURE_MEASUREMENT_LOCATION", "SDK_TO_PLATFORM_OVULATION_TEST_RESULT", "getSDK_TO_PLATFORM_OVULATION_TEST_RESULT", "PLATFORM_TO_SDK_OVULATION_TEST_RESULT", "getPLATFORM_TO_SDK_OVULATION_TEST_RESULT", "SDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION", "getSDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION", "PLATFORM_TO_SDK_CERVICAL_MUCUS_SENSATION", "getPLATFORM_TO_SDK_CERVICAL_MUCUS_SENSATION", "SDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED", "getSDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED", "PLATFORM_TO_SDK_SEXUAL_ACTIVITY_PROTECTION_USED", "getPLATFORM_TO_SDK_SEXUAL_ACTIVITY_PROTECTION_USED", "SDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION", "getSDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION", "PLATFORM_TO_SDK_SKIN_TEMPERATURE_MEASUREMENT_LOCATION", "getPLATFORM_TO_SDK_SKIN_TEMPERATURE_MEASUREMENT_LOCATION", "SDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE", "getSDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE", "PLATFORM_TO_SDK_GLUCOSE_SPECIMEN_SOURCE", "getPLATFORM_TO_SDK_GLUCOSE_SPECIMEN_SOURCE", "SDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL", "getSDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL", "PLATFORM_TO_SDK_BLOOD_GLUCOSE_RELATION_TO_MEAL", "getPLATFORM_TO_SDK_BLOOD_GLUCOSE_RELATION_TO_MEAL", "SDK_TO_PLATFORM_EXERCISE_CATEGORY", "getSDK_TO_PLATFORM_EXERCISE_CATEGORY", "PLATFORM_TO_SDK_EXERCISE_CATEGORY", "getPLATFORM_TO_SDK_EXERCISE_CATEGORY", "SDK_TO_PLATFORM_SLEEP_STAGE_TYPE", "getSDK_TO_PLATFORM_SLEEP_STAGE_TYPE", "PLATFORM_TO_SDK_SLEEP_STAGE_TYPE", "getPLATFORM_TO_SDK_SLEEP_STAGE_TYPE", "SDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE", "getSDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE", "PLATFORM_TO_SDK_EXERCISE_SEGMENT_TYPE", "getPLATFORM_TO_SDK_EXERCISE_SEGMENT_TYPE", "SDK_TO_PLATFORM_MINDFULNESS_SESSION_TYPE", "getSDK_TO_PLATFORM_MINDFULNESS_SESSION_TYPE", "getSDK_TO_PLATFORM_MINDFULNESS_SESSION_TYPE$annotations", "()V", "PLATFORM_TO_SDK_MINDFULNESS_SESSION_TYPE", "getPLATFORM_TO_SDK_MINDFULNESS_SESSION_TYPE", "getPLATFORM_TO_SDK_MINDFULNESS_SESSION_TYPE$annotations", "SDK_TO_PLATFORM_RECORDING_METHOD", "getSDK_TO_PLATFORM_RECORDING_METHOD", "SDK_TO_PLATFORM_FHIR_RESOURCE_TYPE", "getSDK_TO_PLATFORM_FHIR_RESOURCE_TYPE", "getSDK_TO_PLATFORM_FHIR_RESOURCE_TYPE$annotations", "PLATFORM_TO_SDK_FHIR_RESOURCE_TYPE", "getPLATFORM_TO_SDK_FHIR_RESOURCE_TYPE", "SDK_TO_PLATFORM_MEDICAL_RESOURCE_TYPE", "getSDK_TO_PLATFORM_MEDICAL_RESOURCE_TYPE", "getSDK_TO_PLATFORM_MEDICAL_RESOURCE_TYPE$annotations", "SDK_TO_PLATFORM_DEVICE_TYPE", "getSDK_TO_PLATFORM_DEVICE_TYPE", "PLATFORM_TO_SDK_DEVICE_TYPE", "getPLATFORM_TO_SDK_DEVICE_TYPE", "PLATFORM_TO_SDK_MEDICAL_RESOURCE_TYPE", "getPLATFORM_TO_SDK_MEDICAL_RESOURCE_TYPE", "PLATFORM_TO_SDK_RECORDING_METHOD", "getPLATFORM_TO_SDK_RECORDING_METHOD", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class IntDefMappingsKt {
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_BLOOD_GLUCOSE_RELATION_TO_MEAL;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_BLOOD_PRESSURE_BODY_POSITION;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_BLOOD_PRESSURE_MEASUREMENT_LOCATION;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_BODY_TEMPERATURE_MEASUREMENT_LOCATION;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_CERVICAL_MUCUS_APPEARANCE;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_CERVICAL_MUCUS_SENSATION;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_DEVICE_TYPE;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_EXERCISE_CATEGORY;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_EXERCISE_SEGMENT_TYPE;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_EXERCISE_SESSION_TYPE;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_FHIR_RESOURCE_TYPE;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_GLUCOSE_SPECIMEN_SOURCE;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_MEAL_TYPE;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_MEDICAL_RESOURCE_TYPE;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_MENSTRUATION_FLOW_TYPE;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_MINDFULNESS_SESSION_TYPE;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_OVULATION_TEST_RESULT;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_RECORDING_METHOD;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_SEXUAL_ACTIVITY_PROTECTION_USED;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_SKIN_TEMPERATURE_MEASUREMENT_LOCATION;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_SLEEP_STAGE_TYPE;
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_VO2_MAX_MEASUREMENT_METHOD;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_DEVICE_TYPE;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_EXERCISE_CATEGORY;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_EXERCISE_SESSION_TYPE;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_FHIR_RESOURCE_TYPE;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_MEAL_TYPE;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_MEDICAL_RESOURCE_TYPE;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_MINDFULNESS_SESSION_TYPE;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_OVULATION_TEST_RESULT;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_RECORDING_METHOD;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_SLEEP_STAGE_TYPE;
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD;

    static {
        Map<Integer, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to(5, 5), TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4), TuplesKt.to(6, 6));
        SDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE = mapMapOf;
        PLATFORM_TO_SDK_CERVICAL_MUCUS_APPEARANCE = reversed(mapMapOf);
        Map<Integer, Integer> mapMapOf2 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4));
        SDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION = mapMapOf2;
        PLATFORM_TO_SDK_BLOOD_PRESSURE_BODY_POSITION = reversed(mapMapOf2);
        Map<Integer, Integer> mapMapOf3 = MapsKt.mapOf(TuplesKt.to(0, 58), TuplesKt.to(2, 1), TuplesKt.to(4, 2), TuplesKt.to(5, 3), TuplesKt.to(8, 4), TuplesKt.to(9, 5), TuplesKt.to(10, 6), TuplesKt.to(11, 7), TuplesKt.to(13, 8), TuplesKt.to(14, 9), TuplesKt.to(16, 10), TuplesKt.to(25, 60), TuplesKt.to(26, 11), TuplesKt.to(27, 12), TuplesKt.to(28, 13), TuplesKt.to(29, 14), TuplesKt.to(31, 15), TuplesKt.to(32, 16), TuplesKt.to(33, 17), TuplesKt.to(34, 18), TuplesKt.to(35, 19), TuplesKt.to(36, 20), TuplesKt.to(37, 21), TuplesKt.to(38, 22), TuplesKt.to(39, 23), TuplesKt.to(44, 24), TuplesKt.to(46, 25), TuplesKt.to(47, 26), TuplesKt.to(48, 27), TuplesKt.to(50, 28), TuplesKt.to(51, 29), TuplesKt.to(52, 30), TuplesKt.to(53, 31), TuplesKt.to(54, 61), TuplesKt.to(55, 32), TuplesKt.to(56, 33), TuplesKt.to(57, 34), TuplesKt.to(58, 35), TuplesKt.to(59, 36), TuplesKt.to(60, 37), TuplesKt.to(61, 38), TuplesKt.to(62, 39), TuplesKt.to(63, 40), TuplesKt.to(64, 41), TuplesKt.to(65, 42), TuplesKt.to(66, 43), TuplesKt.to(68, 44), TuplesKt.to(69, 59), TuplesKt.to(70, 45), TuplesKt.to(71, 46), TuplesKt.to(72, 47), TuplesKt.to(73, 48), TuplesKt.to(74, 49), TuplesKt.to(75, 50), TuplesKt.to(76, 51), TuplesKt.to(78, 52), TuplesKt.to(79, 53), TuplesKt.to(80, 54), TuplesKt.to(81, 55), TuplesKt.to(82, 56), TuplesKt.to(83, 57));
        SDK_TO_PLATFORM_EXERCISE_SESSION_TYPE = mapMapOf3;
        PLATFORM_TO_SDK_EXERCISE_SESSION_TYPE = reversed(mapMapOf3);
        Map<Integer, Integer> mapMapOf4 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4));
        SDK_TO_PLATFORM_MEAL_TYPE = mapMapOf4;
        PLATFORM_TO_SDK_MEAL_TYPE = reversed(mapMapOf4);
        Map<Integer, Integer> mapMapOf5 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4), TuplesKt.to(5, 5));
        SDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD = mapMapOf5;
        PLATFORM_TO_SDK_VO2_MAX_MEASUREMENT_METHOD = reversed(mapMapOf5);
        Map<Integer, Integer> mapMapOf6 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3));
        SDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE = mapMapOf6;
        PLATFORM_TO_SDK_MENSTRUATION_FLOW_TYPE = reversed(mapMapOf6);
        Map<Integer, Integer> mapMapOf7 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4), TuplesKt.to(5, 5), TuplesKt.to(6, 6), TuplesKt.to(7, 7), TuplesKt.to(8, 8), TuplesKt.to(9, 9), TuplesKt.to(10, 10));
        SDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION = mapMapOf7;
        PLATFORM_TO_SDK_BODY_TEMPERATURE_MEASUREMENT_LOCATION = reversed(mapMapOf7);
        Map<Integer, Integer> mapMapOf8 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4));
        SDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION = mapMapOf8;
        PLATFORM_TO_SDK_BLOOD_PRESSURE_MEASUREMENT_LOCATION = reversed(mapMapOf8);
        Map<Integer, Integer> mapMapOf9 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(0, 0));
        SDK_TO_PLATFORM_OVULATION_TEST_RESULT = mapMapOf9;
        PLATFORM_TO_SDK_OVULATION_TEST_RESULT = reversed(mapMapOf9);
        Map<Integer, Integer> mapMapOf10 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3));
        SDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION = mapMapOf10;
        PLATFORM_TO_SDK_CERVICAL_MUCUS_SENSATION = reversed(mapMapOf10);
        Map<Integer, Integer> mapMapOf11 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2));
        SDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED = mapMapOf11;
        PLATFORM_TO_SDK_SEXUAL_ACTIVITY_PROTECTION_USED = reversed(mapMapOf11);
        Map<Integer, Integer> mapMapOf12 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3));
        SDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION = mapMapOf12;
        PLATFORM_TO_SDK_SKIN_TEMPERATURE_MEASUREMENT_LOCATION = reversed(mapMapOf12);
        Map<Integer, Integer> mapMapOf13 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4), TuplesKt.to(5, 5), TuplesKt.to(6, 6));
        SDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE = mapMapOf13;
        PLATFORM_TO_SDK_GLUCOSE_SPECIMEN_SOURCE = reversed(mapMapOf13);
        Map<Integer, Integer> mapMapOf14 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4));
        SDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL = mapMapOf14;
        PLATFORM_TO_SDK_BLOOD_GLUCOSE_RELATION_TO_MEAL = reversed(mapMapOf14);
        Map<Integer, Integer> mapMapOf15 = MapsKt.mapOf(TuplesKt.to(0, 0), TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4), TuplesKt.to(5, 5));
        SDK_TO_PLATFORM_EXERCISE_CATEGORY = mapMapOf15;
        PLATFORM_TO_SDK_EXERCISE_CATEGORY = reversed(mapMapOf15);
        Map<Integer, Integer> mapMapOf16 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4), TuplesKt.to(5, 5), TuplesKt.to(6, 6), TuplesKt.to(7, 7));
        SDK_TO_PLATFORM_SLEEP_STAGE_TYPE = mapMapOf16;
        PLATFORM_TO_SDK_SLEEP_STAGE_TYPE = reversed(mapMapOf16);
        Map<Integer, Integer> mapMapOf17 = MapsKt.mapOf(TuplesKt.to(1, 26), TuplesKt.to(2, 27), TuplesKt.to(3, 28), TuplesKt.to(4, 1), TuplesKt.to(5, 29), TuplesKt.to(6, 2), TuplesKt.to(7, 3), TuplesKt.to(8, 4), TuplesKt.to(9, 30), TuplesKt.to(10, 31), TuplesKt.to(11, 32), TuplesKt.to(12, 33), TuplesKt.to(13, 5), TuplesKt.to(14, 6), TuplesKt.to(15, 7), TuplesKt.to(16, 8), TuplesKt.to(17, 34), TuplesKt.to(18, 9), TuplesKt.to(19, 10), TuplesKt.to(20, 11), TuplesKt.to(21, 12), TuplesKt.to(22, 13), TuplesKt.to(23, 35), TuplesKt.to(24, 62), TuplesKt.to(25, 36), TuplesKt.to(26, 37), TuplesKt.to(27, 38), TuplesKt.to(28, 39), TuplesKt.to(29, 40), TuplesKt.to(30, 41), TuplesKt.to(31, 42), TuplesKt.to(32, 43), TuplesKt.to(33, 44), TuplesKt.to(34, 45), TuplesKt.to(35, 46), TuplesKt.to(36, 47), TuplesKt.to(37, 48), TuplesKt.to(38, 64), TuplesKt.to(39, 67), TuplesKt.to(40, 14), TuplesKt.to(41, 49), TuplesKt.to(42, 50), TuplesKt.to(43, 51), TuplesKt.to(44, 66), TuplesKt.to(45, 15), TuplesKt.to(46, 16), TuplesKt.to(47, 17), TuplesKt.to(48, 52), TuplesKt.to(49, 53), TuplesKt.to(50, 54), TuplesKt.to(51, 55), TuplesKt.to(52, 18), TuplesKt.to(53, 19), TuplesKt.to(54, 20), TuplesKt.to(55, 57), TuplesKt.to(56, 58), TuplesKt.to(57, 59), TuplesKt.to(58, 56), TuplesKt.to(59, 60), TuplesKt.to(60, 21), TuplesKt.to(61, 61), TuplesKt.to(62, 22), TuplesKt.to(63, 23), TuplesKt.to(64, 24), TuplesKt.to(65, 63), TuplesKt.to(66, 25), TuplesKt.to(67, 65));
        SDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE = mapMapOf17;
        PLATFORM_TO_SDK_EXERCISE_SEGMENT_TYPE = reversed(mapMapOf17);
        Map<Integer, Integer> mapMapOf18 = MapsKt.mapOf(TuplesKt.to(2, 3), TuplesKt.to(1, 1), TuplesKt.to(4, 5), TuplesKt.to(3, 4), TuplesKt.to(5, 6));
        SDK_TO_PLATFORM_MINDFULNESS_SESSION_TYPE = mapMapOf18;
        PLATFORM_TO_SDK_MINDFULNESS_SESSION_TYPE = reversed(mapMapOf18);
        Map<Integer, Integer> mapMapOf19 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3));
        SDK_TO_PLATFORM_RECORDING_METHOD = mapMapOf19;
        Map<Integer, Integer> mapMapOf20 = MapsKt.mapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4), TuplesKt.to(5, 5), TuplesKt.to(6, 6), TuplesKt.to(7, 7), TuplesKt.to(8, 8), TuplesKt.to(9, 9), TuplesKt.to(10, 10), TuplesKt.to(11, 11), TuplesKt.to(12, 12), TuplesKt.to(13, 13), TuplesKt.to(14, 14));
        SDK_TO_PLATFORM_FHIR_RESOURCE_TYPE = mapMapOf20;
        PLATFORM_TO_SDK_FHIR_RESOURCE_TYPE = reversed(mapMapOf20);
        Map<Integer, Integer> mapMapOf21 = MapsKt.mapOf(TuplesKt.to(2, 2), TuplesKt.to(7, 7), TuplesKt.to(6, 6), TuplesKt.to(9, 9), TuplesKt.to(10, 10), TuplesKt.to(11, 11), TuplesKt.to(3, 3), TuplesKt.to(8, 8), TuplesKt.to(4, 4), TuplesKt.to(1, 1), TuplesKt.to(12, 12), TuplesKt.to(5, 5));
        SDK_TO_PLATFORM_MEDICAL_RESOURCE_TYPE = mapMapOf21;
        Map<Integer, Integer> mapMapOf22 = MapsKt.mapOf(TuplesKt.to(0, 0), TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4), TuplesKt.to(5, 5), TuplesKt.to(6, 6), TuplesKt.to(7, 7), TuplesKt.to(8, 8));
        SDK_TO_PLATFORM_DEVICE_TYPE = mapMapOf22;
        PLATFORM_TO_SDK_DEVICE_TYPE = reversed(mapMapOf22);
        PLATFORM_TO_SDK_MEDICAL_RESOURCE_TYPE = reversed(mapMapOf21);
        PLATFORM_TO_SDK_RECORDING_METHOD = reversed(mapMapOf19);
    }

    private static final Map<Integer, Integer> reversed(Map<Integer, Integer> map) {
        Set<Map.Entry<Integer, Integer>> setEntrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pair = TuplesKt.to(Integer.valueOf(((Number) entry.getValue()).intValue()), Integer.valueOf(((Number) entry.getKey()).intValue()));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    public static final int toPlatformBloodGlucoseRelationToMeal(int i) {
        Integer num = SDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformBloodGlucoseSpecimenSource(int i) {
        Integer num = SDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformBloodPressureBodyPosition(int i) {
        Integer num = SDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformBloodPressureMeasurementLocation(int i) {
        Integer num = SDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformBodyTemperatureMeasurementLocation(int i) {
        Integer num = SDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformCervicalMucusAppearance(int i) {
        Integer num = SDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformCervicalMucusSensation(int i) {
        Integer num = SDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformExerciseCategory(int i) {
        Integer num = SDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformExerciseSegmentType(int i) {
        Integer num = SDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformExerciseSessionType(int i) {
        Integer num = SDK_TO_PLATFORM_EXERCISE_SESSION_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformMealType(int i) {
        Integer num = SDK_TO_PLATFORM_MEAL_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformMenstruationFlow(int i) {
        Integer num = SDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformMindfulnessSessionType(int i) {
        Integer num = SDK_TO_PLATFORM_MINDFULNESS_SESSION_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformOvulationTestResult(int i) {
        Integer num = SDK_TO_PLATFORM_OVULATION_TEST_RESULT.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformRecordingMethod(int i) {
        Integer num = SDK_TO_PLATFORM_RECORDING_METHOD.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformSexualActivityProtectionUsed(int i) {
        Integer num = SDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformSkinTemperatureMeasurementLocation(int i) {
        Integer num = SDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformSleepStageType(int i) {
        Integer num = SDK_TO_PLATFORM_SLEEP_STAGE_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformVo2MaxMeasurementMethod(int i) {
        Integer num = SDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkBloodGlucoseSpecimenSource(int i) {
        Integer num = PLATFORM_TO_SDK_GLUCOSE_SPECIMEN_SOURCE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkBloodPressureBodyPosition(int i) {
        Integer num = PLATFORM_TO_SDK_BLOOD_PRESSURE_BODY_POSITION.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkBloodPressureMeasurementLocation(int i) {
        Integer num = PLATFORM_TO_SDK_BLOOD_PRESSURE_MEASUREMENT_LOCATION.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkBodyTemperatureMeasurementLocation(int i) {
        Integer num = PLATFORM_TO_SDK_BODY_TEMPERATURE_MEASUREMENT_LOCATION.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkCervicalMucusAppearance(int i) {
        Integer num = PLATFORM_TO_SDK_CERVICAL_MUCUS_APPEARANCE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkCervicalMucusSensation(int i) {
        Integer num = PLATFORM_TO_SDK_CERVICAL_MUCUS_SENSATION.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkDevice(int i) {
        Integer num = PLATFORM_TO_SDK_DEVICE_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkExerciseCategory(int i) {
        Integer num = PLATFORM_TO_SDK_EXERCISE_CATEGORY.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkExerciseSegmentType(int i) {
        Integer num = PLATFORM_TO_SDK_EXERCISE_SEGMENT_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkExerciseSessionType(int i) {
        Integer num = PLATFORM_TO_SDK_EXERCISE_SESSION_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkMealType(int i) {
        Integer num = PLATFORM_TO_SDK_MEAL_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkMenstruationFlow(int i) {
        Integer num = PLATFORM_TO_SDK_MENSTRUATION_FLOW_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkMindfulnessSessionType(int i) {
        Integer num = PLATFORM_TO_SDK_MINDFULNESS_SESSION_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkOvulationTestResult(int i) {
        Integer num = PLATFORM_TO_SDK_OVULATION_TEST_RESULT.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkProtectionUsed(int i) {
        Integer num = PLATFORM_TO_SDK_SEXUAL_ACTIVITY_PROTECTION_USED.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkRecordingMethod(int i) {
        Integer num = PLATFORM_TO_SDK_RECORDING_METHOD.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkRelationToMeal(int i) {
        Integer num = PLATFORM_TO_SDK_BLOOD_GLUCOSE_RELATION_TO_MEAL.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkSkinTemperatureMeasurementLocation(int i) {
        Integer num = PLATFORM_TO_SDK_SKIN_TEMPERATURE_MEASUREMENT_LOCATION.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkSleepStageType(int i) {
        Integer num = PLATFORM_TO_SDK_SLEEP_STAGE_TYPE.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkVo2MaxMeasurementMethod(int i) {
        Integer num = PLATFORM_TO_SDK_VO2_MAX_MEASUREMENT_METHOD.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
