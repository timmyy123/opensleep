package androidx.health.connect.client.impl.platform.records;

import android.health.connect.datatypes.ActiveCaloriesBurnedRecord;
import android.health.connect.datatypes.BasalBodyTemperatureRecord;
import android.health.connect.datatypes.BasalMetabolicRateRecord;
import android.health.connect.datatypes.BloodGlucoseRecord;
import android.health.connect.datatypes.BloodPressureRecord;
import android.health.connect.datatypes.BodyFatRecord;
import android.health.connect.datatypes.BodyTemperatureRecord;
import android.health.connect.datatypes.BodyWaterMassRecord;
import android.health.connect.datatypes.BoneMassRecord;
import android.health.connect.datatypes.CervicalMucusRecord;
import android.health.connect.datatypes.CyclingPedalingCadenceRecord;
import android.health.connect.datatypes.DistanceRecord;
import android.health.connect.datatypes.ElevationGainedRecord;
import android.health.connect.datatypes.ExerciseCompletionGoal;
import android.health.connect.datatypes.ExerciseLap;
import android.health.connect.datatypes.ExercisePerformanceGoal;
import android.health.connect.datatypes.ExerciseRoute;
import android.health.connect.datatypes.ExerciseSegment;
import android.health.connect.datatypes.ExerciseSessionRecord;
import android.health.connect.datatypes.FloorsClimbedRecord;
import android.health.connect.datatypes.HeartRateRecord;
import android.health.connect.datatypes.HeartRateVariabilityRmssdRecord;
import android.health.connect.datatypes.HeightRecord;
import android.health.connect.datatypes.HydrationRecord;
import android.health.connect.datatypes.IntermenstrualBleedingRecord;
import android.health.connect.datatypes.LeanBodyMassRecord;
import android.health.connect.datatypes.MenstruationFlowRecord;
import android.health.connect.datatypes.MenstruationPeriodRecord;
import android.health.connect.datatypes.MindfulnessSessionRecord;
import android.health.connect.datatypes.NutritionRecord;
import android.health.connect.datatypes.OvulationTestRecord;
import android.health.connect.datatypes.OxygenSaturationRecord;
import android.health.connect.datatypes.PlannedExerciseBlock;
import android.health.connect.datatypes.PlannedExerciseSessionRecord;
import android.health.connect.datatypes.PlannedExerciseStep;
import android.health.connect.datatypes.PowerRecord;
import android.health.connect.datatypes.Record;
import android.health.connect.datatypes.RespiratoryRateRecord;
import android.health.connect.datatypes.RestingHeartRateRecord;
import android.health.connect.datatypes.SexualActivityRecord;
import android.health.connect.datatypes.SkinTemperatureRecord;
import android.health.connect.datatypes.SleepSessionRecord;
import android.health.connect.datatypes.SpeedRecord;
import android.health.connect.datatypes.StepsCadenceRecord;
import android.health.connect.datatypes.StepsRecord;
import android.health.connect.datatypes.TotalCaloriesBurnedRecord;
import android.health.connect.datatypes.Vo2MaxRecord;
import android.health.connect.datatypes.WeightRecord;
import android.health.connect.datatypes.WheelchairPushesRecord;
import android.health.connect.datatypes.units.BloodGlucose;
import android.health.connect.datatypes.units.Energy;
import android.health.connect.datatypes.units.Length;
import android.health.connect.datatypes.units.Percentage;
import android.health.connect.datatypes.units.Power;
import android.health.connect.datatypes.units.Pressure;
import android.health.connect.datatypes.units.Temperature;
import android.health.connect.datatypes.units.TemperatureDelta;
import android.health.connect.datatypes.units.Velocity;
import android.health.connect.datatypes.units.Volume;
import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.ExerciseCompletionGoal;
import androidx.health.connect.client.records.ExercisePerformanceTarget;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseRouteResult;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.PlannedExerciseStep;
import androidx.health.connect.client.records.PowerRecord;
import androidx.health.connect.client.records.RespiratoryRateRecord;
import androidx.health.connect.client.records.RestingHeartRateRecord;
import androidx.health.connect.client.records.SexualActivityRecord;
import androidx.health.connect.client.records.SkinTemperatureRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.records.StepsRecord;
import androidx.health.connect.client.records.TotalCaloriesBurnedRecord;
import androidx.health.connect.client.records.UtilsKt;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.records.WeightRecord;
import androidx.health.connect.client.records.WheelchairPushesRecord;
import androidx.health.connect.client.units.Mass;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import j$.time.Duration;
import j$.time.TimeConversions;
import j$.time.ZoneOffset;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.math.MathKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¤\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u00060\u0003j\u0002`\u00040\u0002*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\u0007\u001a\u0010\u0012\n\b\u0001\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u0002*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000H\u0003¢\u0006\u0004\b\u0007\u0010\u0006\u001a)\u0010\b\u001a\u0010\u0012\n\b\u0001\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u0002*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000H\u0003¢\u0006\u0004\b\b\u0010\u0006\u001a\u0017\u0010\t\u001a\u00060\u0003j\u0002`\u0004*\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004*\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\n\u001a\u001b\u0010\f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004*\u00020\u0001H\u0002¢\u0006\u0004\b\f\u0010\n\u001a\u0015\u0010\r\u001a\u00020\u0001*\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00060\u0003j\u0002`\u0004H\u0003¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00060\u0003j\u0002`\u0004H\u0003¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0017\u0010\u0014\u001a\u00020\u0013*\u00060\u0011j\u0002`\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0017\u0010\u0019\u001a\u00020\u0018*\u00060\u0016j\u0002`\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0017\u0010\u001e\u001a\u00020\u001d*\u00060\u001bj\u0002`\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010#\u001a\u00020\"*\u00060 j\u0002`!H\u0002¢\u0006\u0004\b#\u0010$\u001a\u0017\u0010(\u001a\u00020'*\u00060%j\u0002`&H\u0002¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010-\u001a\u00020,*\u00060*j\u0002`+H\u0002¢\u0006\u0004\b-\u0010.\u001a\u0017\u00102\u001a\u000201*\u00060/j\u0002`0H\u0002¢\u0006\u0004\b2\u00103\u001a\u0017\u00107\u001a\u000206*\u000604j\u0002`5H\u0002¢\u0006\u0004\b7\u00108\u001a\u0017\u0010<\u001a\u00020;*\u000609j\u0002`:H\u0002¢\u0006\u0004\b<\u0010=\u001a\u0017\u0010A\u001a\u00020@*\u00060>j\u0002`?H\u0002¢\u0006\u0004\bA\u0010B\u001a\u0017\u0010F\u001a\u00020E*\u00060Cj\u0002`DH\u0002¢\u0006\u0004\bF\u0010G\u001a\u0017\u0010K\u001a\u00020J*\u00060Hj\u0002`IH\u0002¢\u0006\u0004\bK\u0010L\u001a\u0017\u0010P\u001a\u00020O*\u00060Mj\u0002`NH\u0002¢\u0006\u0004\bP\u0010Q\u001a\u0017\u0010U\u001a\u00020T*\u00060Rj\u0002`SH\u0003¢\u0006\u0004\bU\u0010V\u001a\u0017\u0010Z\u001a\u00020Y*\u00060Wj\u0002`XH\u0002¢\u0006\u0004\bZ\u0010[\u001a\u0017\u0010_\u001a\u00020^*\u00060\\j\u0002`]H\u0002¢\u0006\u0004\b_\u0010`\u001a\u0017\u0010d\u001a\u00020c*\u00060aj\u0002`bH\u0002¢\u0006\u0004\bd\u0010e\u001a\u0017\u0010i\u001a\u00020h*\u00060fj\u0002`gH\u0002¢\u0006\u0004\bi\u0010j\u001a\u0017\u0010n\u001a\u00020m*\u00060kj\u0002`lH\u0002¢\u0006\u0004\bn\u0010o\u001a\u0017\u0010s\u001a\u00020r*\u00060pj\u0002`qH\u0002¢\u0006\u0004\bs\u0010t\u001a\u0017\u0010x\u001a\u00020w*\u00060uj\u0002`vH\u0002¢\u0006\u0004\bx\u0010y\u001a\u0017\u0010}\u001a\u00020|*\u00060zj\u0002`{H\u0002¢\u0006\u0004\b}\u0010~\u001a\u001c\u0010\u0082\u0001\u001a\u00030\u0081\u0001*\u00070\u007fj\u0003`\u0080\u0001H\u0003¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u001d\u0010\u0087\u0001\u001a\u00030\u0086\u0001*\b0\u0084\u0001j\u0003`\u0085\u0001H\u0002¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u001d\u0010\u008c\u0001\u001a\u00030\u008b\u0001*\b0\u0089\u0001j\u0003`\u008a\u0001H\u0002¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u001d\u0010\u0091\u0001\u001a\u00030\u0090\u0001*\b0\u008e\u0001j\u0003`\u008f\u0001H\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u001d\u0010\u0096\u0001\u001a\u00030\u0095\u0001*\b0\u0093\u0001j\u0003`\u0094\u0001H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u001d\u0010\u009b\u0001\u001a\u00030\u009a\u0001*\b0\u0098\u0001j\u0003`\u0099\u0001H\u0002¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u001d\u0010 \u0001\u001a\u00030\u009f\u0001*\b0\u009d\u0001j\u0003`\u009e\u0001H\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001\u001a\u001d\u0010¥\u0001\u001a\u00030¤\u0001*\b0¢\u0001j\u0003`£\u0001H\u0002¢\u0006\u0006\b¥\u0001\u0010¦\u0001\u001a\u001d\u0010ª\u0001\u001a\u00030©\u0001*\b0§\u0001j\u0003`¨\u0001H\u0002¢\u0006\u0006\bª\u0001\u0010«\u0001\u001a\u001d\u0010¯\u0001\u001a\u00030®\u0001*\b0¬\u0001j\u0003`\u00ad\u0001H\u0002¢\u0006\u0006\b¯\u0001\u0010°\u0001\u001a\u001d\u0010´\u0001\u001a\u00030³\u0001*\b0±\u0001j\u0003`²\u0001H\u0003¢\u0006\u0006\b´\u0001\u0010µ\u0001\u001a\u001d\u0010¹\u0001\u001a\u00030¸\u0001*\b0¶\u0001j\u0003`·\u0001H\u0002¢\u0006\u0006\b¹\u0001\u0010º\u0001\u001a\u001d\u0010¾\u0001\u001a\u00030½\u0001*\b0»\u0001j\u0003`¼\u0001H\u0002¢\u0006\u0006\b¾\u0001\u0010¿\u0001\u001a\u001d\u0010Ã\u0001\u001a\u00030Â\u0001*\b0À\u0001j\u0003`Á\u0001H\u0002¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u001d\u0010È\u0001\u001a\u00030Ç\u0001*\b0Å\u0001j\u0003`Æ\u0001H\u0002¢\u0006\u0006\bÈ\u0001\u0010É\u0001\u001a\u001d\u0010Í\u0001\u001a\u00030Ì\u0001*\b0Ê\u0001j\u0003`Ë\u0001H\u0002¢\u0006\u0006\bÍ\u0001\u0010Î\u0001\u001a\u001d\u0010Ò\u0001\u001a\u00030Ñ\u0001*\b0Ï\u0001j\u0003`Ð\u0001H\u0002¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u001d\u0010×\u0001\u001a\u00030Ö\u0001*\b0Ô\u0001j\u0003`Õ\u0001H\u0002¢\u0006\u0006\b×\u0001\u0010Ø\u0001\u001a\u0016\u0010Ù\u0001\u001a\u00020\u0011*\u00020\u0013H\u0002¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0016\u0010Û\u0001\u001a\u00020\u0016*\u00020\u0018H\u0002¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0016\u0010Ý\u0001\u001a\u00020\u001b*\u00020\u001dH\u0002¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001\u001a\u0016\u0010ß\u0001\u001a\u00020 *\u00020\"H\u0002¢\u0006\u0006\bß\u0001\u0010à\u0001\u001a\u0016\u0010á\u0001\u001a\u00020%*\u00020'H\u0002¢\u0006\u0006\bá\u0001\u0010â\u0001\u001a\u0016\u0010ã\u0001\u001a\u00020**\u00020,H\u0002¢\u0006\u0006\bã\u0001\u0010ä\u0001\u001a\u0016\u0010å\u0001\u001a\u00020/*\u000201H\u0002¢\u0006\u0006\bå\u0001\u0010æ\u0001\u001a\u0016\u0010ç\u0001\u001a\u000204*\u000206H\u0002¢\u0006\u0006\bç\u0001\u0010è\u0001\u001a\u0016\u0010é\u0001\u001a\u000209*\u00020;H\u0002¢\u0006\u0006\bé\u0001\u0010ê\u0001\u001a\u0016\u0010ë\u0001\u001a\u00020>*\u00020@H\u0002¢\u0006\u0006\bë\u0001\u0010ì\u0001\u001a\u0016\u0010í\u0001\u001a\u00020C*\u00020EH\u0002¢\u0006\u0006\bí\u0001\u0010î\u0001\u001a\u001d\u0010ò\u0001\u001a\b0ð\u0001j\u0003`ñ\u0001*\u00030ï\u0001H\u0002¢\u0006\u0006\bò\u0001\u0010ó\u0001\u001a\u0016\u0010ô\u0001\u001a\u00020H*\u00020JH\u0002¢\u0006\u0006\bô\u0001\u0010õ\u0001\u001a\u0016\u0010ö\u0001\u001a\u00020M*\u00020OH\u0002¢\u0006\u0006\bö\u0001\u0010÷\u0001\u001a\u0016\u0010ø\u0001\u001a\u00020R*\u00020TH\u0003¢\u0006\u0006\bø\u0001\u0010ù\u0001\u001a\u0018\u0010ü\u0001\u001a\u00030û\u0001*\u00030ú\u0001H\u0002¢\u0006\u0006\bü\u0001\u0010ý\u0001\u001a\u001d\u0010\u0081\u0002\u001a\b0ÿ\u0001j\u0003`\u0080\u0002*\u00030þ\u0001H\u0002¢\u0006\u0006\b\u0081\u0002\u0010\u0082\u0002\u001a\u0018\u0010\u0085\u0002\u001a\u00030\u0084\u0002*\u00030\u0083\u0002H\u0002¢\u0006\u0006\b\u0085\u0002\u0010\u0086\u0002\u001a\u0016\u0010\u0087\u0002\u001a\u00020W*\u00020YH\u0002¢\u0006\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0016\u0010\u0089\u0002\u001a\u00020\\*\u00020^H\u0002¢\u0006\u0006\b\u0089\u0002\u0010\u008a\u0002\u001a\u001d\u0010\u008e\u0002\u001a\b0\u008c\u0002j\u0003`\u008d\u0002*\u00030\u008b\u0002H\u0002¢\u0006\u0006\b\u008e\u0002\u0010\u008f\u0002\u001a\u0016\u0010\u0090\u0002\u001a\u00020a*\u00020cH\u0002¢\u0006\u0006\b\u0090\u0002\u0010\u0091\u0002\u001a\u0016\u0010\u0092\u0002\u001a\u00020f*\u00020hH\u0002¢\u0006\u0006\b\u0092\u0002\u0010\u0093\u0002\u001a\u0016\u0010\u0094\u0002\u001a\u00020k*\u00020mH\u0002¢\u0006\u0006\b\u0094\u0002\u0010\u0095\u0002\u001a\u0016\u0010\u0096\u0002\u001a\u00020p*\u00020rH\u0002¢\u0006\u0006\b\u0096\u0002\u0010\u0097\u0002\u001a\u0016\u0010\u0098\u0002\u001a\u00020u*\u00020wH\u0002¢\u0006\u0006\b\u0098\u0002\u0010\u0099\u0002\u001a\u0016\u0010\u009a\u0002\u001a\u00020z*\u00020|H\u0002¢\u0006\u0006\b\u009a\u0002\u0010\u009b\u0002\u001a\u0018\u0010\u009c\u0002\u001a\u00030\u0084\u0001*\u00030\u0086\u0001H\u0002¢\u0006\u0006\b\u009c\u0002\u0010\u009d\u0002\u001a\u0017\u0010\u009e\u0002\u001a\u00020\u007f*\u00030\u0081\u0001H\u0003¢\u0006\u0006\b\u009e\u0002\u0010\u009f\u0002\u001a\u0018\u0010 \u0002\u001a\u00030\u0089\u0001*\u00030\u008b\u0001H\u0002¢\u0006\u0006\b \u0002\u0010¡\u0002\u001a\u0018\u0010¢\u0002\u001a\u00030\u008e\u0001*\u00030\u0090\u0001H\u0002¢\u0006\u0006\b¢\u0002\u0010£\u0002\u001a\u0018\u0010¤\u0002\u001a\u00030\u0093\u0001*\u00030\u0095\u0001H\u0002¢\u0006\u0006\b¤\u0002\u0010¥\u0002\u001a\u0018\u0010¨\u0002\u001a\u00030§\u0002*\u00030¦\u0002H\u0003¢\u0006\u0006\b¨\u0002\u0010©\u0002\u001a\u0018\u0010¬\u0002\u001a\u00030«\u0002*\u00030ª\u0002H\u0003¢\u0006\u0006\b¬\u0002\u0010\u00ad\u0002\u001a\u0018\u0010°\u0002\u001a\u00030¯\u0002*\u00030®\u0002H\u0003¢\u0006\u0006\b°\u0002\u0010±\u0002\u001a\u0018\u0010´\u0002\u001a\u00030³\u0002*\u00030²\u0002H\u0001¢\u0006\u0006\b´\u0002\u0010µ\u0002\u001a\u0018\u0010¸\u0002\u001a\u00030·\u0002*\u00030¶\u0002H\u0001¢\u0006\u0006\b¸\u0002\u0010¹\u0002\u001a\u001d\u0010»\u0002\u001a\u00030¦\u0002*\b0§\u0002j\u0003`º\u0002H\u0001¢\u0006\u0006\b»\u0002\u0010¼\u0002\u001a\u001d\u0010¾\u0002\u001a\u00030ª\u0002*\b0«\u0002j\u0003`½\u0002H\u0003¢\u0006\u0006\b¾\u0002\u0010¿\u0002\u001a\u001d\u0010Á\u0002\u001a\u00030®\u0002*\b0¯\u0002j\u0003`À\u0002H\u0003¢\u0006\u0006\bÁ\u0002\u0010Â\u0002\u001a\u001d\u0010Ä\u0002\u001a\u00030²\u0002*\b0³\u0002j\u0003`Ã\u0002H\u0001¢\u0006\u0006\bÄ\u0002\u0010Å\u0002\u001a\u001d\u0010Ç\u0002\u001a\u00030¶\u0002*\b0·\u0002j\u0003`Æ\u0002H\u0001¢\u0006\u0006\bÇ\u0002\u0010È\u0002\u001a\u0018\u0010É\u0002\u001a\u00030\u0098\u0001*\u00030\u009a\u0001H\u0002¢\u0006\u0006\bÉ\u0002\u0010Ê\u0002\u001a\u001d\u0010Î\u0002\u001a\b0Ì\u0002j\u0003`Í\u0002*\u00030Ë\u0002H\u0002¢\u0006\u0006\bÎ\u0002\u0010Ï\u0002\u001a\u0018\u0010Ð\u0002\u001a\u00030\u009d\u0001*\u00030\u009f\u0001H\u0002¢\u0006\u0006\bÐ\u0002\u0010Ñ\u0002\u001a\u0018\u0010Ò\u0002\u001a\u00030¢\u0001*\u00030¤\u0001H\u0002¢\u0006\u0006\bÒ\u0002\u0010Ó\u0002\u001a\u0018\u0010Ô\u0002\u001a\u00030§\u0001*\u00030©\u0001H\u0002¢\u0006\u0006\bÔ\u0002\u0010Õ\u0002\u001a\u0018\u0010Ö\u0002\u001a\u00030±\u0001*\u00030³\u0001H\u0003¢\u0006\u0006\bÖ\u0002\u0010×\u0002\u001a\u001d\u0010Û\u0002\u001a\b0Ù\u0002j\u0003`Ú\u0002*\u00030Ø\u0002H\u0003¢\u0006\u0006\bÛ\u0002\u0010Ü\u0002\u001a\u0018\u0010Ý\u0002\u001a\u00030¬\u0001*\u00030®\u0001H\u0002¢\u0006\u0006\bÝ\u0002\u0010Þ\u0002\u001a\u001d\u0010â\u0002\u001a\b0à\u0002j\u0003`á\u0002*\u00030ß\u0002H\u0002¢\u0006\u0006\bâ\u0002\u0010ã\u0002\u001a\u0018\u0010ä\u0002\u001a\u00030¶\u0001*\u00030¸\u0001H\u0002¢\u0006\u0006\bä\u0002\u0010å\u0002\u001a\u001d\u0010é\u0002\u001a\b0ç\u0002j\u0003`è\u0002*\u00030æ\u0002H\u0002¢\u0006\u0006\bé\u0002\u0010ê\u0002\u001a\u0018\u0010ë\u0002\u001a\u00030À\u0001*\u00030Â\u0001H\u0002¢\u0006\u0006\bë\u0002\u0010ì\u0002\u001a\u0018\u0010í\u0002\u001a\u00030»\u0001*\u00030½\u0001H\u0002¢\u0006\u0006\bí\u0002\u0010î\u0002\u001a\u001d\u0010ò\u0002\u001a\b0ð\u0002j\u0003`ñ\u0002*\u00030ï\u0002H\u0002¢\u0006\u0006\bò\u0002\u0010ó\u0002\u001a\u0018\u0010ô\u0002\u001a\u00030Å\u0001*\u00030Ç\u0001H\u0002¢\u0006\u0006\bô\u0002\u0010õ\u0002\u001a\u0018\u0010ö\u0002\u001a\u00030Ê\u0001*\u00030Ì\u0001H\u0002¢\u0006\u0006\bö\u0002\u0010÷\u0002\u001a\u0018\u0010ø\u0002\u001a\u00030Ï\u0001*\u00030Ñ\u0001H\u0002¢\u0006\u0006\bø\u0002\u0010ù\u0002\u001a\u0018\u0010ú\u0002\u001a\u00030Ô\u0001*\u00030Ö\u0001H\u0002¢\u0006\u0006\bú\u0002\u0010û\u0002\u001a\u001d\u0010ü\u0002\u001a\u00030ï\u0001*\b0ð\u0001j\u0003`ñ\u0001H\u0002¢\u0006\u0006\bü\u0002\u0010ý\u0002\u001a\u001d\u0010þ\u0002\u001a\u00030\u008b\u0002*\b0\u008c\u0002j\u0003`\u008d\u0002H\u0002¢\u0006\u0006\bþ\u0002\u0010ÿ\u0002\u001a\u001d\u0010\u0080\u0003\u001a\u00030Ë\u0002*\b0Ì\u0002j\u0003`Í\u0002H\u0002¢\u0006\u0006\b\u0080\u0003\u0010\u0081\u0003\u001a\u001d\u0010\u0082\u0003\u001a\u00030Ø\u0002*\b0Ù\u0002j\u0003`Ú\u0002H\u0003¢\u0006\u0006\b\u0082\u0003\u0010\u0083\u0003\u001a\u001d\u0010\u0084\u0003\u001a\u00030æ\u0002*\b0ç\u0002j\u0003`è\u0002H\u0002¢\u0006\u0006\b\u0084\u0003\u0010\u0085\u0003\u001a\u001d\u0010\u0086\u0003\u001a\u00030ï\u0002*\b0ð\u0002j\u0003`ñ\u0002H\u0002¢\u0006\u0006\b\u0086\u0003\u0010\u0087\u0003\u001a\u001d\u0010\u0088\u0003\u001a\u00030ß\u0002*\b0à\u0002j\u0003`á\u0002H\u0002¢\u0006\u0006\b\u0088\u0003\u0010\u0089\u0003\u001a\u001d\u0010\u008a\u0003\u001a\u00030þ\u0001*\b0ÿ\u0001j\u0003`\u0080\u0002H\u0000¢\u0006\u0006\b\u008a\u0003\u0010\u008b\u0003\u001a\u001d\u0010\u008d\u0003\u001a\u00030ú\u0001*\b0û\u0001j\u0003`\u008c\u0003H\u0000¢\u0006\u0006\b\u008d\u0003\u0010\u008e\u0003\u001a\u001d\u0010\u0090\u0003\u001a\u00030\u0083\u0002*\b0\u0084\u0002j\u0003`\u008f\u0003H\u0000¢\u0006\u0006\b\u0090\u0003\u0010\u0091\u0003¨\u0006\u0092\u0003"}, d2 = {"Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "Ljava/lang/Class;", "Landroid/health/connect/datatypes/Record;", "Landroidx/health/connect/client/impl/platform/records/PlatformRecord;", "toPlatformRecordClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "toPlatformRecordClassExt13", "toPlatformRecordClassExt15", "toPlatformRecord", "(Landroidx/health/connect/client/records/Record;)Landroid/health/connect/datatypes/Record;", "toPlatformRecordExt13", "toPlatformRecordExt15", "toSdkRecord", "(Landroid/health/connect/datatypes/Record;)Landroidx/health/connect/client/records/Record;", "toSdkRecordExt13", "toSdkRecordExt15", "Landroid/health/connect/datatypes/ActiveCaloriesBurnedRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformActiveCaloriesBurnedRecord;", "Landroidx/health/connect/client/records/ActiveCaloriesBurnedRecord;", "toSdkActiveCaloriesBurnedRecord", "(Landroid/health/connect/datatypes/ActiveCaloriesBurnedRecord;)Landroidx/health/connect/client/records/ActiveCaloriesBurnedRecord;", "Landroid/health/connect/datatypes/BasalBodyTemperatureRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformBasalBodyTemperatureRecord;", "Landroidx/health/connect/client/records/BasalBodyTemperatureRecord;", "toSdkBasalBodyTemperatureRecord", "(Landroid/health/connect/datatypes/BasalBodyTemperatureRecord;)Landroidx/health/connect/client/records/BasalBodyTemperatureRecord;", "Landroid/health/connect/datatypes/BasalMetabolicRateRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformBasalMetabolicRateRecord;", "Landroidx/health/connect/client/records/BasalMetabolicRateRecord;", "toSdkBasalMetabolicRateRecord", "(Landroid/health/connect/datatypes/BasalMetabolicRateRecord;)Landroidx/health/connect/client/records/BasalMetabolicRateRecord;", "Landroid/health/connect/datatypes/BloodGlucoseRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformBloodGlucoseRecord;", "Landroidx/health/connect/client/records/BloodGlucoseRecord;", "toSdkBloodGlucoseRecord", "(Landroid/health/connect/datatypes/BloodGlucoseRecord;)Landroidx/health/connect/client/records/BloodGlucoseRecord;", "Landroid/health/connect/datatypes/BloodPressureRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformBloodPressureRecord;", "Landroidx/health/connect/client/records/BloodPressureRecord;", "toSdkBloodPressureRecord", "(Landroid/health/connect/datatypes/BloodPressureRecord;)Landroidx/health/connect/client/records/BloodPressureRecord;", "Landroid/health/connect/datatypes/BodyFatRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformBodyFatRecord;", "Landroidx/health/connect/client/records/BodyFatRecord;", "toSdkBodyFatRecord", "(Landroid/health/connect/datatypes/BodyFatRecord;)Landroidx/health/connect/client/records/BodyFatRecord;", "Landroid/health/connect/datatypes/BodyTemperatureRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformBodyTemperatureRecord;", "Landroidx/health/connect/client/records/BodyTemperatureRecord;", "toSdkBodyTemperatureRecord", "(Landroid/health/connect/datatypes/BodyTemperatureRecord;)Landroidx/health/connect/client/records/BodyTemperatureRecord;", "Landroid/health/connect/datatypes/BodyWaterMassRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformBodyWaterMassRecord;", "Landroidx/health/connect/client/records/BodyWaterMassRecord;", "toSdkBodyWaterMassRecord", "(Landroid/health/connect/datatypes/BodyWaterMassRecord;)Landroidx/health/connect/client/records/BodyWaterMassRecord;", "Landroid/health/connect/datatypes/BoneMassRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformBoneMassRecord;", "Landroidx/health/connect/client/records/BoneMassRecord;", "toSdkBoneMassRecord", "(Landroid/health/connect/datatypes/BoneMassRecord;)Landroidx/health/connect/client/records/BoneMassRecord;", "Landroid/health/connect/datatypes/CervicalMucusRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformCervicalMucusRecord;", "Landroidx/health/connect/client/records/CervicalMucusRecord;", "toSdkCervicalMucusRecord", "(Landroid/health/connect/datatypes/CervicalMucusRecord;)Landroidx/health/connect/client/records/CervicalMucusRecord;", "Landroid/health/connect/datatypes/CyclingPedalingCadenceRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformCyclingPedalingCadenceRecord;", "Landroidx/health/connect/client/records/CyclingPedalingCadenceRecord;", "toSdkCyclingPedalingCadenceRecord", "(Landroid/health/connect/datatypes/CyclingPedalingCadenceRecord;)Landroidx/health/connect/client/records/CyclingPedalingCadenceRecord;", "Landroid/health/connect/datatypes/DistanceRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformDistanceRecord;", "Landroidx/health/connect/client/records/DistanceRecord;", "toSdkDistanceRecord", "(Landroid/health/connect/datatypes/DistanceRecord;)Landroidx/health/connect/client/records/DistanceRecord;", "Landroid/health/connect/datatypes/ElevationGainedRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformElevationGainedRecord;", "Landroidx/health/connect/client/records/ElevationGainedRecord;", "toSdkElevationGainedRecord", "(Landroid/health/connect/datatypes/ElevationGainedRecord;)Landroidx/health/connect/client/records/ElevationGainedRecord;", "Landroid/health/connect/datatypes/ExerciseSessionRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseSessionRecord;", "Landroidx/health/connect/client/records/ExerciseSessionRecord;", "toSdkExerciseSessionRecord", "(Landroid/health/connect/datatypes/ExerciseSessionRecord;)Landroidx/health/connect/client/records/ExerciseSessionRecord;", "Landroid/health/connect/datatypes/FloorsClimbedRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformFloorsClimbedRecord;", "Landroidx/health/connect/client/records/FloorsClimbedRecord;", "toSdkFloorsClimbedRecord", "(Landroid/health/connect/datatypes/FloorsClimbedRecord;)Landroidx/health/connect/client/records/FloorsClimbedRecord;", "Landroid/health/connect/datatypes/HeartRateRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformHeartRateRecord;", "Landroidx/health/connect/client/records/HeartRateRecord;", "toSdkHeartRateRecord", "(Landroid/health/connect/datatypes/HeartRateRecord;)Landroidx/health/connect/client/records/HeartRateRecord;", "Landroid/health/connect/datatypes/HeartRateVariabilityRmssdRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformHeartRateVariabilityRmssdRecord;", "Landroidx/health/connect/client/records/HeartRateVariabilityRmssdRecord;", "toSdkHeartRateVariabilityRmssdRecord", "(Landroid/health/connect/datatypes/HeartRateVariabilityRmssdRecord;)Landroidx/health/connect/client/records/HeartRateVariabilityRmssdRecord;", "Landroid/health/connect/datatypes/HeightRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformHeightRecord;", "Landroidx/health/connect/client/records/HeightRecord;", "toSdkHeightRecord", "(Landroid/health/connect/datatypes/HeightRecord;)Landroidx/health/connect/client/records/HeightRecord;", "Landroid/health/connect/datatypes/HydrationRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformHydrationRecord;", "Landroidx/health/connect/client/records/HydrationRecord;", "toSdkHydrationRecord", "(Landroid/health/connect/datatypes/HydrationRecord;)Landroidx/health/connect/client/records/HydrationRecord;", "Landroid/health/connect/datatypes/IntermenstrualBleedingRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformIntermenstrualBleedingRecord;", "Landroidx/health/connect/client/records/IntermenstrualBleedingRecord;", "toSdkIntermenstrualBleedingRecord", "(Landroid/health/connect/datatypes/IntermenstrualBleedingRecord;)Landroidx/health/connect/client/records/IntermenstrualBleedingRecord;", "Landroid/health/connect/datatypes/LeanBodyMassRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformLeanBodyMassRecord;", "Landroidx/health/connect/client/records/LeanBodyMassRecord;", "toSdkLeanBodyMassRecord", "(Landroid/health/connect/datatypes/LeanBodyMassRecord;)Landroidx/health/connect/client/records/LeanBodyMassRecord;", "Landroid/health/connect/datatypes/MenstruationFlowRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformMenstruationFlowRecord;", "Landroidx/health/connect/client/records/MenstruationFlowRecord;", "toSdkMenstruationFlowRecord", "(Landroid/health/connect/datatypes/MenstruationFlowRecord;)Landroidx/health/connect/client/records/MenstruationFlowRecord;", "Landroid/health/connect/datatypes/MindfulnessSessionRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformMindfulnessSessionRecord;", "Landroidx/health/connect/client/records/MindfulnessSessionRecord;", "toSdkMindfulnessSessionRecord", "(Landroid/health/connect/datatypes/MindfulnessSessionRecord;)Landroidx/health/connect/client/records/MindfulnessSessionRecord;", "Landroid/health/connect/datatypes/MenstruationPeriodRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformMenstruationPeriodRecord;", "Landroidx/health/connect/client/records/MenstruationPeriodRecord;", "toSdkMenstruationPeriodRecord", "(Landroid/health/connect/datatypes/MenstruationPeriodRecord;)Landroidx/health/connect/client/records/MenstruationPeriodRecord;", "Landroid/health/connect/datatypes/NutritionRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformNutritionRecord;", "Landroidx/health/connect/client/records/NutritionRecord;", "toSdkNutritionRecord", "(Landroid/health/connect/datatypes/NutritionRecord;)Landroidx/health/connect/client/records/NutritionRecord;", "Landroid/health/connect/datatypes/OvulationTestRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformOvulationTestRecord;", "Landroidx/health/connect/client/records/OvulationTestRecord;", "toSdkOvulationTestRecord", "(Landroid/health/connect/datatypes/OvulationTestRecord;)Landroidx/health/connect/client/records/OvulationTestRecord;", "Landroid/health/connect/datatypes/OxygenSaturationRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformOxygenSaturationRecord;", "Landroidx/health/connect/client/records/OxygenSaturationRecord;", "toSdkOxygenSaturationRecord", "(Landroid/health/connect/datatypes/OxygenSaturationRecord;)Landroidx/health/connect/client/records/OxygenSaturationRecord;", "Landroid/health/connect/datatypes/PowerRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformPowerRecord;", "Landroidx/health/connect/client/records/PowerRecord;", "toSdkPowerRecord", "(Landroid/health/connect/datatypes/PowerRecord;)Landroidx/health/connect/client/records/PowerRecord;", "Landroid/health/connect/datatypes/RespiratoryRateRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformRespiratoryRateRecord;", "Landroidx/health/connect/client/records/RespiratoryRateRecord;", "toSdkRespiratoryRateRecord", "(Landroid/health/connect/datatypes/RespiratoryRateRecord;)Landroidx/health/connect/client/records/RespiratoryRateRecord;", "Landroid/health/connect/datatypes/RestingHeartRateRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformRestingHeartRateRecord;", "Landroidx/health/connect/client/records/RestingHeartRateRecord;", "toSdkRestingHeartRateRecord", "(Landroid/health/connect/datatypes/RestingHeartRateRecord;)Landroidx/health/connect/client/records/RestingHeartRateRecord;", "Landroid/health/connect/datatypes/SexualActivityRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformSexualActivityRecord;", "Landroidx/health/connect/client/records/SexualActivityRecord;", "toSdkSexualActivityRecord", "(Landroid/health/connect/datatypes/SexualActivityRecord;)Landroidx/health/connect/client/records/SexualActivityRecord;", "Landroid/health/connect/datatypes/SleepSessionRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformSleepSessionRecord;", "Landroidx/health/connect/client/records/SleepSessionRecord;", "toSdkSleepSessionRecord", "(Landroid/health/connect/datatypes/SleepSessionRecord;)Landroidx/health/connect/client/records/SleepSessionRecord;", "Landroid/health/connect/datatypes/SkinTemperatureRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformSkinTemperatureRecord;", "Landroidx/health/connect/client/records/SkinTemperatureRecord;", "toSdkSkinTemperatureRecord", "(Landroid/health/connect/datatypes/SkinTemperatureRecord;)Landroidx/health/connect/client/records/SkinTemperatureRecord;", "Landroid/health/connect/datatypes/SpeedRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformSpeedRecord;", "Landroidx/health/connect/client/records/SpeedRecord;", "toSdkSpeedRecord", "(Landroid/health/connect/datatypes/SpeedRecord;)Landroidx/health/connect/client/records/SpeedRecord;", "Landroid/health/connect/datatypes/StepsCadenceRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformStepsCadenceRecord;", "Landroidx/health/connect/client/records/StepsCadenceRecord;", "toSdkStepsCadenceRecord", "(Landroid/health/connect/datatypes/StepsCadenceRecord;)Landroidx/health/connect/client/records/StepsCadenceRecord;", "Landroid/health/connect/datatypes/StepsRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformStepsRecord;", "Landroidx/health/connect/client/records/StepsRecord;", "toSdkStepsRecord", "(Landroid/health/connect/datatypes/StepsRecord;)Landroidx/health/connect/client/records/StepsRecord;", "Landroid/health/connect/datatypes/TotalCaloriesBurnedRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformTotalCaloriesBurnedRecord;", "Landroidx/health/connect/client/records/TotalCaloriesBurnedRecord;", "toSdkTotalCaloriesBurnedRecord", "(Landroid/health/connect/datatypes/TotalCaloriesBurnedRecord;)Landroidx/health/connect/client/records/TotalCaloriesBurnedRecord;", "Landroid/health/connect/datatypes/Vo2MaxRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformVo2MaxRecord;", "Landroidx/health/connect/client/records/Vo2MaxRecord;", "toSdkVo2MaxRecord", "(Landroid/health/connect/datatypes/Vo2MaxRecord;)Landroidx/health/connect/client/records/Vo2MaxRecord;", "Landroid/health/connect/datatypes/WeightRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformWeightRecord;", "Landroidx/health/connect/client/records/WeightRecord;", "toSdkWeightRecord", "(Landroid/health/connect/datatypes/WeightRecord;)Landroidx/health/connect/client/records/WeightRecord;", "Landroid/health/connect/datatypes/WheelchairPushesRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformWheelchairPushesRecord;", "Landroidx/health/connect/client/records/WheelchairPushesRecord;", "toWheelchairPushesRecord", "(Landroid/health/connect/datatypes/WheelchairPushesRecord;)Landroidx/health/connect/client/records/WheelchairPushesRecord;", "toPlatformActiveCaloriesBurnedRecord", "(Landroidx/health/connect/client/records/ActiveCaloriesBurnedRecord;)Landroid/health/connect/datatypes/ActiveCaloriesBurnedRecord;", "toPlatformBasalBodyTemperatureRecord", "(Landroidx/health/connect/client/records/BasalBodyTemperatureRecord;)Landroid/health/connect/datatypes/BasalBodyTemperatureRecord;", "toPlatformBasalMetabolicRateRecord", "(Landroidx/health/connect/client/records/BasalMetabolicRateRecord;)Landroid/health/connect/datatypes/BasalMetabolicRateRecord;", "toPlatformBloodGlucoseRecord", "(Landroidx/health/connect/client/records/BloodGlucoseRecord;)Landroid/health/connect/datatypes/BloodGlucoseRecord;", "toPlatformBloodPressureRecord", "(Landroidx/health/connect/client/records/BloodPressureRecord;)Landroid/health/connect/datatypes/BloodPressureRecord;", "toPlatformBodyFatRecord", "(Landroidx/health/connect/client/records/BodyFatRecord;)Landroid/health/connect/datatypes/BodyFatRecord;", "toPlatformBodyTemperatureRecord", "(Landroidx/health/connect/client/records/BodyTemperatureRecord;)Landroid/health/connect/datatypes/BodyTemperatureRecord;", "toPlatformBodyWaterMassRecord", "(Landroidx/health/connect/client/records/BodyWaterMassRecord;)Landroid/health/connect/datatypes/BodyWaterMassRecord;", "toPlatformBoneMassRecord", "(Landroidx/health/connect/client/records/BoneMassRecord;)Landroid/health/connect/datatypes/BoneMassRecord;", "toPlatformCervicalMucusRecord", "(Landroidx/health/connect/client/records/CervicalMucusRecord;)Landroid/health/connect/datatypes/CervicalMucusRecord;", "toPlatformCyclingPedalingCadenceRecord", "(Landroidx/health/connect/client/records/CyclingPedalingCadenceRecord;)Landroid/health/connect/datatypes/CyclingPedalingCadenceRecord;", "Landroidx/health/connect/client/records/CyclingPedalingCadenceRecord$Sample;", "Landroid/health/connect/datatypes/CyclingPedalingCadenceRecord$CyclingPedalingCadenceRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformCyclingPedalingCadenceSample;", "toPlatformCyclingPedalingCadenceSample", "(Landroidx/health/connect/client/records/CyclingPedalingCadenceRecord$Sample;)Landroid/health/connect/datatypes/CyclingPedalingCadenceRecord$CyclingPedalingCadenceRecordSample;", "toPlatformDistanceRecord", "(Landroidx/health/connect/client/records/DistanceRecord;)Landroid/health/connect/datatypes/DistanceRecord;", "toPlatformElevationGainedRecord", "(Landroidx/health/connect/client/records/ElevationGainedRecord;)Landroid/health/connect/datatypes/ElevationGainedRecord;", "toPlatformExerciseSessionRecord", "(Landroidx/health/connect/client/records/ExerciseSessionRecord;)Landroid/health/connect/datatypes/ExerciseSessionRecord;", "Landroidx/health/connect/client/records/ExerciseLap;", "Landroid/health/connect/datatypes/ExerciseLap;", "toPlatformExerciseLap", "(Landroidx/health/connect/client/records/ExerciseLap;)Landroid/health/connect/datatypes/ExerciseLap;", "Landroidx/health/connect/client/records/ExerciseRoute;", "Landroid/health/connect/datatypes/ExerciseRoute;", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseRoute;", "toPlatformExerciseRoute", "(Landroidx/health/connect/client/records/ExerciseRoute;)Landroid/health/connect/datatypes/ExerciseRoute;", "Landroidx/health/connect/client/records/ExerciseSegment;", "Landroid/health/connect/datatypes/ExerciseSegment;", "toPlatformExerciseSegment", "(Landroidx/health/connect/client/records/ExerciseSegment;)Landroid/health/connect/datatypes/ExerciseSegment;", "toPlatformFloorsClimbedRecord", "(Landroidx/health/connect/client/records/FloorsClimbedRecord;)Landroid/health/connect/datatypes/FloorsClimbedRecord;", "toPlatformHeartRateRecord", "(Landroidx/health/connect/client/records/HeartRateRecord;)Landroid/health/connect/datatypes/HeartRateRecord;", "Landroidx/health/connect/client/records/HeartRateRecord$Sample;", "Landroid/health/connect/datatypes/HeartRateRecord$HeartRateSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformHeartRateSample;", "toPlatformHeartRateSample", "(Landroidx/health/connect/client/records/HeartRateRecord$Sample;)Landroid/health/connect/datatypes/HeartRateRecord$HeartRateSample;", "toPlatformHeartRateVariabilityRmssdRecord", "(Landroidx/health/connect/client/records/HeartRateVariabilityRmssdRecord;)Landroid/health/connect/datatypes/HeartRateVariabilityRmssdRecord;", "toPlatformHeightRecord", "(Landroidx/health/connect/client/records/HeightRecord;)Landroid/health/connect/datatypes/HeightRecord;", "toPlatformHydrationRecord", "(Landroidx/health/connect/client/records/HydrationRecord;)Landroid/health/connect/datatypes/HydrationRecord;", "toPlatformIntermenstrualBleedingRecord", "(Landroidx/health/connect/client/records/IntermenstrualBleedingRecord;)Landroid/health/connect/datatypes/IntermenstrualBleedingRecord;", "toPlatformLeanBodyMassRecord", "(Landroidx/health/connect/client/records/LeanBodyMassRecord;)Landroid/health/connect/datatypes/LeanBodyMassRecord;", "toPlatformMenstruationFlowRecord", "(Landroidx/health/connect/client/records/MenstruationFlowRecord;)Landroid/health/connect/datatypes/MenstruationFlowRecord;", "toPlatformMenstruationPeriodRecord", "(Landroidx/health/connect/client/records/MenstruationPeriodRecord;)Landroid/health/connect/datatypes/MenstruationPeriodRecord;", "toPlatformMindfulnessSessionRecord", "(Landroidx/health/connect/client/records/MindfulnessSessionRecord;)Landroid/health/connect/datatypes/MindfulnessSessionRecord;", "toPlatformNutritionRecord", "(Landroidx/health/connect/client/records/NutritionRecord;)Landroid/health/connect/datatypes/NutritionRecord;", "toPlatformOvulationTestRecord", "(Landroidx/health/connect/client/records/OvulationTestRecord;)Landroid/health/connect/datatypes/OvulationTestRecord;", "toPlatformOxygenSaturationRecord", "(Landroidx/health/connect/client/records/OxygenSaturationRecord;)Landroid/health/connect/datatypes/OxygenSaturationRecord;", "Landroidx/health/connect/client/records/PlannedExerciseSessionRecord;", "Landroid/health/connect/datatypes/PlannedExerciseSessionRecord;", "toPlatformPlannedExerciseSessionRecord", "(Landroidx/health/connect/client/records/PlannedExerciseSessionRecord;)Landroid/health/connect/datatypes/PlannedExerciseSessionRecord;", "Landroidx/health/connect/client/records/PlannedExerciseBlock;", "Landroid/health/connect/datatypes/PlannedExerciseBlock;", "toPlatformPlannedExerciseBlock", "(Landroidx/health/connect/client/records/PlannedExerciseBlock;)Landroid/health/connect/datatypes/PlannedExerciseBlock;", "Landroidx/health/connect/client/records/PlannedExerciseStep;", "Landroid/health/connect/datatypes/PlannedExerciseStep;", "toPlatformPlannedExerciseStep", "(Landroidx/health/connect/client/records/PlannedExerciseStep;)Landroid/health/connect/datatypes/PlannedExerciseStep;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "Landroid/health/connect/datatypes/ExerciseCompletionGoal;", "toPlatformExerciseCompletionGoal", "(Landroidx/health/connect/client/records/ExerciseCompletionGoal;)Landroid/health/connect/datatypes/ExerciseCompletionGoal;", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "Landroid/health/connect/datatypes/ExercisePerformanceGoal;", "toPlatformExercisePerformanceTarget", "(Landroidx/health/connect/client/records/ExercisePerformanceTarget;)Landroid/health/connect/datatypes/ExercisePerformanceGoal;", "Landroidx/health/connect/client/impl/platform/records/PlatformPlannedExerciseSessionRecord;", "toSdkPlannedExerciseSessionRecord", "(Landroid/health/connect/datatypes/PlannedExerciseSessionRecord;)Landroidx/health/connect/client/records/PlannedExerciseSessionRecord;", "Landroidx/health/connect/client/impl/platform/records/PlatformPlannedExerciseBlock;", "toSdkPlannedExerciseBlock", "(Landroid/health/connect/datatypes/PlannedExerciseBlock;)Landroidx/health/connect/client/records/PlannedExerciseBlock;", "Landroidx/health/connect/client/impl/platform/records/PlatformPlannedExerciseStep;", "toSdkPlannedExerciseStep", "(Landroid/health/connect/datatypes/PlannedExerciseStep;)Landroidx/health/connect/client/records/PlannedExerciseStep;", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseCompletionGoal;", "toSdkExerciseCompletionGoal", "(Landroid/health/connect/datatypes/ExerciseCompletionGoal;)Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "Landroidx/health/connect/client/impl/platform/records/PlatformExercisePerformanceTarget;", "toSdkExercisePerformanceTarget", "(Landroid/health/connect/datatypes/ExercisePerformanceGoal;)Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "toPlatformPowerRecord", "(Landroidx/health/connect/client/records/PowerRecord;)Landroid/health/connect/datatypes/PowerRecord;", "Landroidx/health/connect/client/records/PowerRecord$Sample;", "Landroid/health/connect/datatypes/PowerRecord$PowerRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformPowerRecordSample;", "toPlatformPowerRecordSample", "(Landroidx/health/connect/client/records/PowerRecord$Sample;)Landroid/health/connect/datatypes/PowerRecord$PowerRecordSample;", "toPlatformRespiratoryRateRecord", "(Landroidx/health/connect/client/records/RespiratoryRateRecord;)Landroid/health/connect/datatypes/RespiratoryRateRecord;", "toPlatformRestingHeartRateRecord", "(Landroidx/health/connect/client/records/RestingHeartRateRecord;)Landroid/health/connect/datatypes/RestingHeartRateRecord;", "toPlatformSexualActivityRecord", "(Landroidx/health/connect/client/records/SexualActivityRecord;)Landroid/health/connect/datatypes/SexualActivityRecord;", "toPlatformSkinTemperatureRecord", "(Landroidx/health/connect/client/records/SkinTemperatureRecord;)Landroid/health/connect/datatypes/SkinTemperatureRecord;", "Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "Landroid/health/connect/datatypes/SkinTemperatureRecord$Delta;", "Landroidx/health/connect/client/impl/platform/records/PlatformSkinTemperatureDelta;", "toPlatformSkinTemperatureRecordDelta", "(Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;)Landroid/health/connect/datatypes/SkinTemperatureRecord$Delta;", "toPlatformSleepSessionRecord", "(Landroidx/health/connect/client/records/SleepSessionRecord;)Landroid/health/connect/datatypes/SleepSessionRecord;", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "Landroid/health/connect/datatypes/SleepSessionRecord$Stage;", "Landroidx/health/connect/client/impl/platform/records/PlatformSleepSessionStage;", "toPlatformSleepSessionStage", "(Landroidx/health/connect/client/records/SleepSessionRecord$Stage;)Landroid/health/connect/datatypes/SleepSessionRecord$Stage;", "toPlatformSpeedRecord", "(Landroidx/health/connect/client/records/SpeedRecord;)Landroid/health/connect/datatypes/SpeedRecord;", "Landroidx/health/connect/client/records/SpeedRecord$Sample;", "Landroid/health/connect/datatypes/SpeedRecord$SpeedRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformSpeedSample;", "toPlatformSpeedRecordSample", "(Landroidx/health/connect/client/records/SpeedRecord$Sample;)Landroid/health/connect/datatypes/SpeedRecord$SpeedRecordSample;", "toPlatformStepsRecord", "(Landroidx/health/connect/client/records/StepsRecord;)Landroid/health/connect/datatypes/StepsRecord;", "toPlatformStepsCadenceRecord", "(Landroidx/health/connect/client/records/StepsCadenceRecord;)Landroid/health/connect/datatypes/StepsCadenceRecord;", "Landroidx/health/connect/client/records/StepsCadenceRecord$Sample;", "Landroid/health/connect/datatypes/StepsCadenceRecord$StepsCadenceRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformStepsCadenceSample;", "toPlatformStepsCadenceSample", "(Landroidx/health/connect/client/records/StepsCadenceRecord$Sample;)Landroid/health/connect/datatypes/StepsCadenceRecord$StepsCadenceRecordSample;", "toPlatformTotalCaloriesBurnedRecord", "(Landroidx/health/connect/client/records/TotalCaloriesBurnedRecord;)Landroid/health/connect/datatypes/TotalCaloriesBurnedRecord;", "toPlatformVo2MaxRecord", "(Landroidx/health/connect/client/records/Vo2MaxRecord;)Landroid/health/connect/datatypes/Vo2MaxRecord;", "toPlatformWeightRecord", "(Landroidx/health/connect/client/records/WeightRecord;)Landroid/health/connect/datatypes/WeightRecord;", "toPlatformWheelchairPushesRecord", "(Landroidx/health/connect/client/records/WheelchairPushesRecord;)Landroid/health/connect/datatypes/WheelchairPushesRecord;", "toSdkCyclingPedalingCadenceSample", "(Landroid/health/connect/datatypes/CyclingPedalingCadenceRecord$CyclingPedalingCadenceRecordSample;)Landroidx/health/connect/client/records/CyclingPedalingCadenceRecord$Sample;", "toSdkHeartRateSample", "(Landroid/health/connect/datatypes/HeartRateRecord$HeartRateSample;)Landroidx/health/connect/client/records/HeartRateRecord$Sample;", "toSdkPowerRecordSample", "(Landroid/health/connect/datatypes/PowerRecord$PowerRecordSample;)Landroidx/health/connect/client/records/PowerRecord$Sample;", "toSdkSkinTemperatureDelta", "(Landroid/health/connect/datatypes/SkinTemperatureRecord$Delta;)Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "toSdkSpeedSample", "(Landroid/health/connect/datatypes/SpeedRecord$SpeedRecordSample;)Landroidx/health/connect/client/records/SpeedRecord$Sample;", "toSdkStepsCadenceSample", "(Landroid/health/connect/datatypes/StepsCadenceRecord$StepsCadenceRecordSample;)Landroidx/health/connect/client/records/StepsCadenceRecord$Sample;", "toSdkSleepSessionStage", "(Landroid/health/connect/datatypes/SleepSessionRecord$Stage;)Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "toSdkExerciseRoute", "(Landroid/health/connect/datatypes/ExerciseRoute;)Landroidx/health/connect/client/records/ExerciseRoute;", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseLap;", "toSdkExerciseLap", "(Landroid/health/connect/datatypes/ExerciseLap;)Landroidx/health/connect/client/records/ExerciseLap;", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseSegment;", "toSdkExerciseSegment", "(Landroid/health/connect/datatypes/ExerciseSegment;)Landroidx/health/connect/client/records/ExerciseSegment;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class RecordConvertersKt {
    private static final ActiveCaloriesBurnedRecord toPlatformActiveCaloriesBurnedRecord(androidx.health.connect.client.records.ActiveCaloriesBurnedRecord activeCaloriesBurnedRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(activeCaloriesBurnedRecord.getMetadata()), activeCaloriesBurnedRecord.getStartTime(), activeCaloriesBurnedRecord.getEndTime(), UnitConvertersKt.toPlatformEnergy(activeCaloriesBurnedRecord.getEnergy()));
        ActiveCaloriesBurnedRecord.Builder builder = new ActiveCaloriesBurnedRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], (Energy) objArrM[3]);
        ZoneOffset startZoneOffset = activeCaloriesBurnedRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = activeCaloriesBurnedRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        ActiveCaloriesBurnedRecord activeCaloriesBurnedRecordBuild = builder.build();
        activeCaloriesBurnedRecordBuild.getClass();
        return activeCaloriesBurnedRecordBuild;
    }

    private static final BasalBodyTemperatureRecord toPlatformBasalBodyTemperatureRecord(androidx.health.connect.client.records.BasalBodyTemperatureRecord basalBodyTemperatureRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(basalBodyTemperatureRecord.getMetadata()), basalBodyTemperatureRecord.getTime(), IntDefMappingsKt.toPlatformBodyTemperatureMeasurementLocation(basalBodyTemperatureRecord.getMeasurementLocation()), UnitConvertersKt.toPlatformTemperature(basalBodyTemperatureRecord.getTemperature()));
        BasalBodyTemperatureRecord.Builder builder = new BasalBodyTemperatureRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], ((Integer) objArrM[2]).intValue(), (Temperature) objArrM[3]);
        ZoneOffset zoneOffset = basalBodyTemperatureRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        BasalBodyTemperatureRecord basalBodyTemperatureRecordBuild = builder.build();
        basalBodyTemperatureRecordBuild.getClass();
        return basalBodyTemperatureRecordBuild;
    }

    private static final BasalMetabolicRateRecord toPlatformBasalMetabolicRateRecord(androidx.health.connect.client.records.BasalMetabolicRateRecord basalMetabolicRateRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(basalMetabolicRateRecord.getMetadata());
        j$.time.Instant time = basalMetabolicRateRecord.getTime();
        BasalMetabolicRateRecord.Builder builder = new BasalMetabolicRateRecord.Builder(platformMetadata, TimeConversions.convert(time), UnitConvertersKt.toPlatformPower(basalMetabolicRateRecord.getBasalMetabolicRate()));
        ZoneOffset zoneOffset = basalMetabolicRateRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        BasalMetabolicRateRecord basalMetabolicRateRecordBuild = builder.build();
        basalMetabolicRateRecordBuild.getClass();
        return basalMetabolicRateRecordBuild;
    }

    private static final BloodGlucoseRecord toPlatformBloodGlucoseRecord(androidx.health.connect.client.records.BloodGlucoseRecord bloodGlucoseRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(bloodGlucoseRecord.getMetadata()), bloodGlucoseRecord.getTime(), IntDefMappingsKt.toPlatformBloodGlucoseSpecimenSource(bloodGlucoseRecord.getSpecimenSource()), UnitConvertersKt.toPlatformBloodGlucose(bloodGlucoseRecord.getLevel()), IntDefMappingsKt.toPlatformBloodGlucoseRelationToMeal(bloodGlucoseRecord.getRelationToMeal()), IntDefMappingsKt.toPlatformMealType(bloodGlucoseRecord.getMealType()));
        BloodGlucoseRecord.Builder builder = new BloodGlucoseRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], ((Integer) objArrM[2]).intValue(), (BloodGlucose) objArrM[3], ((Integer) objArrM[4]).intValue(), ((Integer) objArrM[5]).intValue());
        ZoneOffset zoneOffset = bloodGlucoseRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        BloodGlucoseRecord bloodGlucoseRecordBuild = builder.build();
        bloodGlucoseRecordBuild.getClass();
        return bloodGlucoseRecordBuild;
    }

    private static final BloodPressureRecord toPlatformBloodPressureRecord(androidx.health.connect.client.records.BloodPressureRecord bloodPressureRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(bloodPressureRecord.getMetadata()), bloodPressureRecord.getTime(), IntDefMappingsKt.toPlatformBloodPressureMeasurementLocation(bloodPressureRecord.getMeasurementLocation()), UnitConvertersKt.toPlatformPressure(bloodPressureRecord.getSystolic()), UnitConvertersKt.toPlatformPressure(bloodPressureRecord.getDiastolic()), IntDefMappingsKt.toPlatformBloodPressureBodyPosition(bloodPressureRecord.getBodyPosition()));
        BloodPressureRecord.Builder builder = new BloodPressureRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], ((Integer) objArrM[2]).intValue(), (Pressure) objArrM[3], (Pressure) objArrM[4], ((Integer) objArrM[5]).intValue());
        ZoneOffset zoneOffset = bloodPressureRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        BloodPressureRecord bloodPressureRecordBuild = builder.build();
        bloodPressureRecordBuild.getClass();
        return bloodPressureRecordBuild;
    }

    private static final BodyFatRecord toPlatformBodyFatRecord(androidx.health.connect.client.records.BodyFatRecord bodyFatRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(bodyFatRecord.getMetadata());
        j$.time.Instant time = bodyFatRecord.getTime();
        BodyFatRecord.Builder builder = new BodyFatRecord.Builder(platformMetadata, TimeConversions.convert(time), UnitConvertersKt.toPlatformPercentage(bodyFatRecord.getPercentage()));
        ZoneOffset zoneOffset = bodyFatRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        BodyFatRecord bodyFatRecordBuild = builder.build();
        bodyFatRecordBuild.getClass();
        return bodyFatRecordBuild;
    }

    private static final BodyTemperatureRecord toPlatformBodyTemperatureRecord(androidx.health.connect.client.records.BodyTemperatureRecord bodyTemperatureRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(bodyTemperatureRecord.getMetadata()), bodyTemperatureRecord.getTime(), IntDefMappingsKt.toPlatformBodyTemperatureMeasurementLocation(bodyTemperatureRecord.getMeasurementLocation()), UnitConvertersKt.toPlatformTemperature(bodyTemperatureRecord.getTemperature()));
        BodyTemperatureRecord.Builder builder = new BodyTemperatureRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], ((Integer) objArrM[2]).intValue(), (Temperature) objArrM[3]);
        ZoneOffset zoneOffset = bodyTemperatureRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        BodyTemperatureRecord bodyTemperatureRecordBuild = builder.build();
        bodyTemperatureRecordBuild.getClass();
        return bodyTemperatureRecordBuild;
    }

    private static final BodyWaterMassRecord toPlatformBodyWaterMassRecord(androidx.health.connect.client.records.BodyWaterMassRecord bodyWaterMassRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(bodyWaterMassRecord.getMetadata());
        j$.time.Instant time = bodyWaterMassRecord.getTime();
        BodyWaterMassRecord.Builder builder = new BodyWaterMassRecord.Builder(platformMetadata, TimeConversions.convert(time), UnitConvertersKt.toPlatformMass(bodyWaterMassRecord.getMass()));
        ZoneOffset zoneOffset = bodyWaterMassRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        BodyWaterMassRecord bodyWaterMassRecordBuild = builder.build();
        bodyWaterMassRecordBuild.getClass();
        return bodyWaterMassRecordBuild;
    }

    private static final BoneMassRecord toPlatformBoneMassRecord(androidx.health.connect.client.records.BoneMassRecord boneMassRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(boneMassRecord.getMetadata());
        j$.time.Instant time = boneMassRecord.getTime();
        BoneMassRecord.Builder builder = new BoneMassRecord.Builder(platformMetadata, TimeConversions.convert(time), UnitConvertersKt.toPlatformMass(boneMassRecord.getMass()));
        ZoneOffset zoneOffset = boneMassRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        BoneMassRecord boneMassRecordBuild = builder.build();
        boneMassRecordBuild.getClass();
        return boneMassRecordBuild;
    }

    private static final CervicalMucusRecord toPlatformCervicalMucusRecord(androidx.health.connect.client.records.CervicalMucusRecord cervicalMucusRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(cervicalMucusRecord.getMetadata()), cervicalMucusRecord.getTime(), IntDefMappingsKt.toPlatformCervicalMucusSensation(cervicalMucusRecord.getSensation()), IntDefMappingsKt.toPlatformCervicalMucusAppearance(cervicalMucusRecord.getAppearance()));
        CervicalMucusRecord.Builder builder = new CervicalMucusRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], ((Integer) objArrM[2]).intValue(), ((Integer) objArrM[3]).intValue());
        ZoneOffset zoneOffset = cervicalMucusRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        CervicalMucusRecord cervicalMucusRecordBuild = builder.build();
        cervicalMucusRecordBuild.getClass();
        return cervicalMucusRecordBuild;
    }

    private static final CyclingPedalingCadenceRecord toPlatformCyclingPedalingCadenceRecord(androidx.health.connect.client.records.CyclingPedalingCadenceRecord cyclingPedalingCadenceRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(cyclingPedalingCadenceRecord.getMetadata());
        j$.time.Instant startTime = cyclingPedalingCadenceRecord.getStartTime();
        j$.time.Instant endTime = cyclingPedalingCadenceRecord.getEndTime();
        List<CyclingPedalingCadenceRecord.Sample> samples = cyclingPedalingCadenceRecord.getSamples();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
        Iterator<T> it = samples.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformCyclingPedalingCadenceSample((CyclingPedalingCadenceRecord.Sample) it.next()));
        }
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(platformMetadata, startTime, endTime, arrayList);
        CyclingPedalingCadenceRecord.Builder builder = new CyclingPedalingCadenceRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], (List) objArrM[3]);
        ZoneOffset startZoneOffset = cyclingPedalingCadenceRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = cyclingPedalingCadenceRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        android.health.connect.datatypes.CyclingPedalingCadenceRecord cyclingPedalingCadenceRecordBuild = builder.build();
        cyclingPedalingCadenceRecordBuild.getClass();
        return cyclingPedalingCadenceRecordBuild;
    }

    private static final CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample toPlatformCyclingPedalingCadenceSample(CyclingPedalingCadenceRecord.Sample sample) {
        RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m$2();
        return RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m(sample.getTime(), sample.getRevolutionsPerMinute());
    }

    private static final DistanceRecord toPlatformDistanceRecord(androidx.health.connect.client.records.DistanceRecord distanceRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(distanceRecord.getMetadata()), distanceRecord.getStartTime(), distanceRecord.getEndTime(), UnitConvertersKt.toPlatformLength(distanceRecord.getDistance()));
        DistanceRecord.Builder builder = new DistanceRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], (Length) objArrM[3]);
        ZoneOffset startZoneOffset = distanceRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = distanceRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        DistanceRecord distanceRecordBuild = builder.build();
        distanceRecordBuild.getClass();
        return distanceRecordBuild;
    }

    private static final ElevationGainedRecord toPlatformElevationGainedRecord(androidx.health.connect.client.records.ElevationGainedRecord elevationGainedRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(elevationGainedRecord.getMetadata()), elevationGainedRecord.getStartTime(), elevationGainedRecord.getEndTime(), UnitConvertersKt.toPlatformLength(elevationGainedRecord.getElevation()));
        ElevationGainedRecord.Builder builder = new ElevationGainedRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], (Length) objArrM[3]);
        ZoneOffset startZoneOffset = elevationGainedRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = elevationGainedRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        ElevationGainedRecord elevationGainedRecordBuild = builder.build();
        elevationGainedRecordBuild.getClass();
        return elevationGainedRecordBuild;
    }

    public static final ExerciseCompletionGoal toPlatformExerciseCompletionGoal(androidx.health.connect.client.records.ExerciseCompletionGoal exerciseCompletionGoal) {
        exerciseCompletionGoal.getClass();
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.DistanceGoal) {
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m((Object) new ExerciseCompletionGoal.DistanceGoal(UnitConvertersKt.toPlatformLength(((ExerciseCompletionGoal.DistanceGoal) exerciseCompletionGoal).getDistance())));
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.DistanceAndDurationGoal) {
            ExerciseCompletionGoal.DistanceAndDurationGoal distanceAndDurationGoal = (ExerciseCompletionGoal.DistanceAndDurationGoal) exerciseCompletionGoal;
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m((Object) new ExerciseCompletionGoal.DistanceWithVariableRestGoal(UnitConvertersKt.toPlatformLength(distanceAndDurationGoal.getDistance()), TimeConversions.convert(distanceAndDurationGoal.getDuration())));
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.StepsGoal) {
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m((Object) new ExerciseCompletionGoal.StepsGoal(((ExerciseCompletionGoal.StepsGoal) exerciseCompletionGoal).getSteps()));
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.DurationGoal) {
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m((Object) new ExerciseCompletionGoal.DurationGoal(TimeConversions.convert(((ExerciseCompletionGoal.DurationGoal) exerciseCompletionGoal).getDuration())));
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.RepetitionsGoal) {
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m((Object) new ExerciseCompletionGoal.RepetitionsGoal(((ExerciseCompletionGoal.RepetitionsGoal) exerciseCompletionGoal).getRepetitions()));
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.TotalCaloriesBurnedGoal) {
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m((Object) new ExerciseCompletionGoal.TotalCaloriesBurnedGoal(UnitConvertersKt.toPlatformEnergy(((ExerciseCompletionGoal.TotalCaloriesBurnedGoal) exerciseCompletionGoal).getTotalCalories())));
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.ActiveCaloriesBurnedGoal) {
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m((Object) new ExerciseCompletionGoal.ActiveCaloriesBurnedGoal(UnitConvertersKt.toPlatformEnergy(((ExerciseCompletionGoal.ActiveCaloriesBurnedGoal) exerciseCompletionGoal).getActiveCalories())));
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.UnknownGoal) {
            ExerciseCompletionGoal.UnknownGoal unknownGoal = ExerciseCompletionGoal.UnknownGoal.INSTANCE;
            unknownGoal.getClass();
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m((Object) unknownGoal);
        }
        if (!(exerciseCompletionGoal instanceof ExerciseCompletionGoal.ManualCompletion)) {
            Gson$$ExternalSyntheticBUOutline0.m("Unsupported exercise completion goal ", exerciseCompletionGoal);
            return null;
        }
        ExerciseCompletionGoal.UnspecifiedGoal unspecifiedGoal = ExerciseCompletionGoal.UnspecifiedGoal.INSTANCE;
        unspecifiedGoal.getClass();
        return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m((Object) unspecifiedGoal);
    }

    private static final ExerciseLap toPlatformExerciseLap(androidx.health.connect.client.records.ExerciseLap exerciseLap) {
        ExerciseLap.Builder builder = new ExerciseLap.Builder(TimeConversions.convert(exerciseLap.getStartTime()), TimeConversions.convert(exerciseLap.getEndTime()));
        androidx.health.connect.client.units.Length length = exerciseLap.getLength();
        if (length != null) {
            builder.setLength(UnitConvertersKt.toPlatformLength(length));
        }
        ExerciseLap exerciseLapBuild = builder.build();
        exerciseLapBuild.getClass();
        return exerciseLapBuild;
    }

    public static final ExercisePerformanceGoal toPlatformExercisePerformanceTarget(ExercisePerformanceTarget exercisePerformanceTarget) {
        exercisePerformanceTarget.getClass();
        if (exercisePerformanceTarget instanceof ExercisePerformanceTarget.PowerTarget) {
            ExercisePerformanceTarget.PowerTarget powerTarget = (ExercisePerformanceTarget.PowerTarget) exercisePerformanceTarget;
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m151m((Object) new ExercisePerformanceGoal.PowerGoal(UnitConvertersKt.toPlatformPower(powerTarget.getMinPower()), UnitConvertersKt.toPlatformPower(powerTarget.getMaxPower())));
        }
        if (exercisePerformanceTarget instanceof ExercisePerformanceTarget.SpeedTarget) {
            ExercisePerformanceTarget.SpeedTarget speedTarget = (ExercisePerformanceTarget.SpeedTarget) exercisePerformanceTarget;
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m151m((Object) new ExercisePerformanceGoal.SpeedGoal(UnitConvertersKt.toPlatformVelocity(speedTarget.getMinSpeed()), UnitConvertersKt.toPlatformVelocity(speedTarget.getMaxSpeed())));
        }
        if (exercisePerformanceTarget instanceof ExercisePerformanceTarget.CadenceTarget) {
            ExercisePerformanceTarget.CadenceTarget cadenceTarget = (ExercisePerformanceTarget.CadenceTarget) exercisePerformanceTarget;
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m151m((Object) new ExercisePerformanceGoal.CadenceGoal(cadenceTarget.getMinCadence(), cadenceTarget.getMaxCadence()));
        }
        if (exercisePerformanceTarget instanceof ExercisePerformanceTarget.HeartRateTarget) {
            ExercisePerformanceTarget.HeartRateTarget heartRateTarget = (ExercisePerformanceTarget.HeartRateTarget) exercisePerformanceTarget;
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m151m((Object) new ExercisePerformanceGoal.HeartRateGoal(MathKt.roundToInt(heartRateTarget.getMinHeartRate()), MathKt.roundToInt(heartRateTarget.getMaxHeartRate())));
        }
        if (exercisePerformanceTarget instanceof ExercisePerformanceTarget.WeightTarget) {
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m151m((Object) new ExercisePerformanceGoal.WeightGoal(UnitConvertersKt.toPlatformMass(((ExercisePerformanceTarget.WeightTarget) exercisePerformanceTarget).getMass())));
        }
        if (exercisePerformanceTarget instanceof ExercisePerformanceTarget.RateOfPerceivedExertionTarget) {
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m151m((Object) new ExercisePerformanceGoal.RateOfPerceivedExertionGoal(((ExercisePerformanceTarget.RateOfPerceivedExertionTarget) exercisePerformanceTarget).getRpe()));
        }
        if (exercisePerformanceTarget instanceof ExercisePerformanceTarget.AmrapTarget) {
            ExercisePerformanceGoal.AmrapGoal amrapGoal = ExercisePerformanceGoal.AmrapGoal.INSTANCE;
            amrapGoal.getClass();
            return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m151m((Object) amrapGoal);
        }
        if (!(exercisePerformanceTarget instanceof ExercisePerformanceTarget.UnknownTarget)) {
            Gson$$ExternalSyntheticBUOutline0.m("Unsupported exercise performance target ", exercisePerformanceTarget);
            return null;
        }
        ExercisePerformanceGoal.UnknownGoal unknownGoal = ExercisePerformanceGoal.UnknownGoal.INSTANCE;
        unknownGoal.getClass();
        return RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m151m((Object) unknownGoal);
    }

    private static final ExerciseRoute toPlatformExerciseRoute(androidx.health.connect.client.records.ExerciseRoute exerciseRoute) {
        List<ExerciseRoute.Location> route = exerciseRoute.getRoute();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(route, 10));
        for (ExerciseRoute.Location location : route) {
            Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(location.getTime(), location.getLatitude(), location.getLongitude());
            ExerciseRoute.Location.Builder builder = new ExerciseRoute.Location.Builder((Instant) objArrM[0], ((Double) objArrM[1]).doubleValue(), ((Double) objArrM[2]).doubleValue());
            androidx.health.connect.client.units.Length horizontalAccuracy = location.getHorizontalAccuracy();
            if (horizontalAccuracy != null) {
                builder.setHorizontalAccuracy(UnitConvertersKt.toPlatformLength(horizontalAccuracy));
            }
            androidx.health.connect.client.units.Length verticalAccuracy = location.getVerticalAccuracy();
            if (verticalAccuracy != null) {
                builder.setVerticalAccuracy(UnitConvertersKt.toPlatformLength(verticalAccuracy));
            }
            androidx.health.connect.client.units.Length altitude = location.getAltitude();
            if (altitude != null) {
                builder.setAltitude(UnitConvertersKt.toPlatformLength(altitude));
            }
            arrayList.add(builder.build());
        }
        return new android.health.connect.datatypes.ExerciseRoute(arrayList);
    }

    private static final ExerciseSegment toPlatformExerciseSegment(androidx.health.connect.client.records.ExerciseSegment exerciseSegment) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(exerciseSegment.getStartTime(), exerciseSegment.getEndTime(), IntDefMappingsKt.toPlatformExerciseSegmentType(exerciseSegment.getSegmentType()));
        ExerciseSegment exerciseSegmentBuild = new ExerciseSegment.Builder((Instant) objArrM[0], (Instant) objArrM[1], ((Integer) objArrM[2]).intValue()).setRepetitionsCount(exerciseSegment.getRepetitions()).build();
        exerciseSegmentBuild.getClass();
        return exerciseSegmentBuild;
    }

    private static final ExerciseSessionRecord toPlatformExerciseSessionRecord(androidx.health.connect.client.records.ExerciseSessionRecord exerciseSessionRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(exerciseSessionRecord.getMetadata()), exerciseSessionRecord.getStartTime(), exerciseSessionRecord.getEndTime(), IntDefMappingsKt.toPlatformExerciseSessionType(exerciseSessionRecord.getExerciseType()));
        ExerciseSessionRecord.Builder builder = new ExerciseSessionRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], ((Integer) objArrM[3]).intValue());
        ZoneOffset startZoneOffset = exerciseSessionRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = exerciseSessionRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        String notes = exerciseSessionRecord.getNotes();
        if (notes != null) {
            builder.setNotes(notes);
        }
        String title = exerciseSessionRecord.getTitle();
        if (title != null) {
            builder.setTitle(title);
        }
        List<androidx.health.connect.client.records.ExerciseLap> laps = exerciseSessionRecord.getLaps();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(laps, 10));
        Iterator<T> it = laps.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformExerciseLap((androidx.health.connect.client.records.ExerciseLap) it.next()));
        }
        builder.setLaps(arrayList);
        List<androidx.health.connect.client.records.ExerciseSegment> segments = exerciseSessionRecord.getSegments();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(segments, 10));
        Iterator<T> it2 = segments.iterator();
        while (it2.hasNext()) {
            arrayList2.add(toPlatformExerciseSegment((androidx.health.connect.client.records.ExerciseSegment) it2.next()));
        }
        builder.setSegments(arrayList2);
        if (exerciseSessionRecord.getExerciseRouteResult() instanceof ExerciseRouteResult.Data) {
            builder.setRoute(toPlatformExerciseRoute(((ExerciseRouteResult.Data) exerciseSessionRecord.getExerciseRouteResult()).getExerciseRoute()));
        }
        String plannedExerciseSessionId = exerciseSessionRecord.getPlannedExerciseSessionId();
        if (plannedExerciseSessionId != null) {
            builder.setPlannedExerciseSessionId(plannedExerciseSessionId);
        }
        ExerciseSessionRecord exerciseSessionRecordBuild = builder.build();
        exerciseSessionRecordBuild.getClass();
        return exerciseSessionRecordBuild;
    }

    private static final FloorsClimbedRecord toPlatformFloorsClimbedRecord(androidx.health.connect.client.records.FloorsClimbedRecord floorsClimbedRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(floorsClimbedRecord.getMetadata()), floorsClimbedRecord.getStartTime(), floorsClimbedRecord.getEndTime(), floorsClimbedRecord.getFloors());
        FloorsClimbedRecord.Builder builder = new FloorsClimbedRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], ((Double) objArrM[3]).doubleValue());
        ZoneOffset startZoneOffset = floorsClimbedRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = floorsClimbedRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        FloorsClimbedRecord floorsClimbedRecordBuild = builder.build();
        floorsClimbedRecordBuild.getClass();
        return floorsClimbedRecordBuild;
    }

    private static final HeartRateRecord toPlatformHeartRateRecord(androidx.health.connect.client.records.HeartRateRecord heartRateRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(heartRateRecord.getMetadata());
        j$.time.Instant startTime = heartRateRecord.getStartTime();
        j$.time.Instant endTime = heartRateRecord.getEndTime();
        List<HeartRateRecord.Sample> samples = heartRateRecord.getSamples();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
        Iterator<T> it = samples.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformHeartRateSample((HeartRateRecord.Sample) it.next()));
        }
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(platformMetadata, startTime, endTime, arrayList);
        HeartRateRecord.Builder builder = new HeartRateRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], (List) objArrM[3]);
        ZoneOffset startZoneOffset = heartRateRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = heartRateRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        android.health.connect.datatypes.HeartRateRecord heartRateRecordBuild = builder.build();
        heartRateRecordBuild.getClass();
        return heartRateRecordBuild;
    }

    private static final HeartRateRecord.HeartRateSample toPlatformHeartRateSample(HeartRateRecord.Sample sample) {
        RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m$3();
        return RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m(sample.getTime(), sample.getBeatsPerMinute());
    }

    private static final HeartRateVariabilityRmssdRecord toPlatformHeartRateVariabilityRmssdRecord(androidx.health.connect.client.records.HeartRateVariabilityRmssdRecord heartRateVariabilityRmssdRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(heartRateVariabilityRmssdRecord.getMetadata());
        j$.time.Instant time = heartRateVariabilityRmssdRecord.getTime();
        HeartRateVariabilityRmssdRecord.Builder builder = new HeartRateVariabilityRmssdRecord.Builder(platformMetadata, TimeConversions.convert(time), heartRateVariabilityRmssdRecord.getHeartRateVariabilityMillis());
        ZoneOffset zoneOffset = heartRateVariabilityRmssdRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        HeartRateVariabilityRmssdRecord heartRateVariabilityRmssdRecordBuild = builder.build();
        heartRateVariabilityRmssdRecordBuild.getClass();
        return heartRateVariabilityRmssdRecordBuild;
    }

    private static final HeightRecord toPlatformHeightRecord(androidx.health.connect.client.records.HeightRecord heightRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(heightRecord.getMetadata());
        j$.time.Instant time = heightRecord.getTime();
        HeightRecord.Builder builder = new HeightRecord.Builder(platformMetadata, TimeConversions.convert(time), UnitConvertersKt.toPlatformLength(heightRecord.getHeight()));
        ZoneOffset zoneOffset = heightRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        HeightRecord heightRecordBuild = builder.build();
        heightRecordBuild.getClass();
        return heightRecordBuild;
    }

    private static final HydrationRecord toPlatformHydrationRecord(androidx.health.connect.client.records.HydrationRecord hydrationRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(hydrationRecord.getMetadata()), hydrationRecord.getStartTime(), hydrationRecord.getEndTime(), UnitConvertersKt.toPlatformVolume(hydrationRecord.getVolume()));
        HydrationRecord.Builder builder = new HydrationRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], (Volume) objArrM[3]);
        ZoneOffset startZoneOffset = hydrationRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = hydrationRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        HydrationRecord hydrationRecordBuild = builder.build();
        hydrationRecordBuild.getClass();
        return hydrationRecordBuild;
    }

    private static final IntermenstrualBleedingRecord toPlatformIntermenstrualBleedingRecord(androidx.health.connect.client.records.IntermenstrualBleedingRecord intermenstrualBleedingRecord) {
        IntermenstrualBleedingRecord.Builder builder = new IntermenstrualBleedingRecord.Builder(MetadataConvertersKt.toPlatformMetadata(intermenstrualBleedingRecord.getMetadata()), TimeConversions.convert(intermenstrualBleedingRecord.getTime()));
        ZoneOffset zoneOffset = intermenstrualBleedingRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        IntermenstrualBleedingRecord intermenstrualBleedingRecordBuild = builder.build();
        intermenstrualBleedingRecordBuild.getClass();
        return intermenstrualBleedingRecordBuild;
    }

    private static final LeanBodyMassRecord toPlatformLeanBodyMassRecord(androidx.health.connect.client.records.LeanBodyMassRecord leanBodyMassRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(leanBodyMassRecord.getMetadata());
        j$.time.Instant time = leanBodyMassRecord.getTime();
        LeanBodyMassRecord.Builder builder = new LeanBodyMassRecord.Builder(platformMetadata, TimeConversions.convert(time), UnitConvertersKt.toPlatformMass(leanBodyMassRecord.getMass()));
        ZoneOffset zoneOffset = leanBodyMassRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        LeanBodyMassRecord leanBodyMassRecordBuild = builder.build();
        leanBodyMassRecordBuild.getClass();
        return leanBodyMassRecordBuild;
    }

    private static final MenstruationFlowRecord toPlatformMenstruationFlowRecord(androidx.health.connect.client.records.MenstruationFlowRecord menstruationFlowRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(menstruationFlowRecord.getMetadata());
        j$.time.Instant time = menstruationFlowRecord.getTime();
        MenstruationFlowRecord.Builder builder = new MenstruationFlowRecord.Builder(platformMetadata, TimeConversions.convert(time), IntDefMappingsKt.toPlatformMenstruationFlow(menstruationFlowRecord.getFlow()));
        ZoneOffset zoneOffset = menstruationFlowRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        MenstruationFlowRecord menstruationFlowRecordBuild = builder.build();
        menstruationFlowRecordBuild.getClass();
        return menstruationFlowRecordBuild;
    }

    private static final MenstruationPeriodRecord toPlatformMenstruationPeriodRecord(androidx.health.connect.client.records.MenstruationPeriodRecord menstruationPeriodRecord) {
        MenstruationPeriodRecord.Builder builder = new MenstruationPeriodRecord.Builder(MetadataConvertersKt.toPlatformMetadata(menstruationPeriodRecord.getMetadata()), TimeConversions.convert(menstruationPeriodRecord.getStartTime()), TimeConversions.convert(menstruationPeriodRecord.getEndTime()));
        ZoneOffset startZoneOffset = menstruationPeriodRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = menstruationPeriodRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        MenstruationPeriodRecord menstruationPeriodRecordBuild = builder.build();
        menstruationPeriodRecordBuild.getClass();
        return menstruationPeriodRecordBuild;
    }

    private static final MindfulnessSessionRecord toPlatformMindfulnessSessionRecord(androidx.health.connect.client.records.MindfulnessSessionRecord mindfulnessSessionRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(mindfulnessSessionRecord.getMetadata()), mindfulnessSessionRecord.getStartTime(), mindfulnessSessionRecord.getEndTime(), IntDefMappingsKt.toPlatformMindfulnessSessionType(mindfulnessSessionRecord.getMindfulnessSessionType()));
        MindfulnessSessionRecord.Builder builder = new MindfulnessSessionRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], ((Integer) objArrM[3]).intValue());
        ZoneOffset startZoneOffset = mindfulnessSessionRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = mindfulnessSessionRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        String title = mindfulnessSessionRecord.getTitle();
        if (title != null) {
            builder.setTitle(title);
        }
        String notes = mindfulnessSessionRecord.getNotes();
        if (notes != null) {
            builder.setNotes(notes);
        }
        MindfulnessSessionRecord mindfulnessSessionRecordBuild = builder.build();
        mindfulnessSessionRecordBuild.getClass();
        return mindfulnessSessionRecordBuild;
    }

    private static final NutritionRecord toPlatformNutritionRecord(androidx.health.connect.client.records.NutritionRecord nutritionRecord) {
        NutritionRecord.Builder mealType = new NutritionRecord.Builder(MetadataConvertersKt.toPlatformMetadata(nutritionRecord.getMetadata()), TimeConversions.convert(nutritionRecord.getStartTime()), TimeConversions.convert(nutritionRecord.getEndTime())).setMealType(IntDefMappingsKt.toPlatformMealType(nutritionRecord.getMealType()));
        ZoneOffset startZoneOffset = nutritionRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            mealType.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = nutritionRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            mealType.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        Mass biotin = nutritionRecord.getBiotin();
        if (biotin != null) {
            mealType.setBiotin(UnitConvertersKt.toPlatformMass(biotin));
        }
        Mass caffeine = nutritionRecord.getCaffeine();
        if (caffeine != null) {
            mealType.setCaffeine(UnitConvertersKt.toPlatformMass(caffeine));
        }
        Mass calcium = nutritionRecord.getCalcium();
        if (calcium != null) {
            mealType.setCalcium(UnitConvertersKt.toPlatformMass(calcium));
        }
        Mass chloride = nutritionRecord.getChloride();
        if (chloride != null) {
            mealType.setChloride(UnitConvertersKt.toPlatformMass(chloride));
        }
        Mass cholesterol = nutritionRecord.getCholesterol();
        if (cholesterol != null) {
            mealType.setCholesterol(UnitConvertersKt.toPlatformMass(cholesterol));
        }
        Mass chromium = nutritionRecord.getChromium();
        if (chromium != null) {
            mealType.setChromium(UnitConvertersKt.toPlatformMass(chromium));
        }
        Mass copper = nutritionRecord.getCopper();
        if (copper != null) {
            mealType.setCopper(UnitConvertersKt.toPlatformMass(copper));
        }
        Mass dietaryFiber = nutritionRecord.getDietaryFiber();
        if (dietaryFiber != null) {
            mealType.setDietaryFiber(UnitConvertersKt.toPlatformMass(dietaryFiber));
        }
        androidx.health.connect.client.units.Energy energy = nutritionRecord.getEnergy();
        if (energy != null) {
            mealType.setEnergy(UnitConvertersKt.toPlatformEnergy(energy));
        }
        androidx.health.connect.client.units.Energy energyFromFat = nutritionRecord.getEnergyFromFat();
        if (energyFromFat != null) {
            mealType.setEnergyFromFat(UnitConvertersKt.toPlatformEnergy(energyFromFat));
        }
        Mass folate = nutritionRecord.getFolate();
        if (folate != null) {
            mealType.setFolate(UnitConvertersKt.toPlatformMass(folate));
        }
        Mass folicAcid = nutritionRecord.getFolicAcid();
        if (folicAcid != null) {
            mealType.setFolicAcid(UnitConvertersKt.toPlatformMass(folicAcid));
        }
        Mass iodine = nutritionRecord.getIodine();
        if (iodine != null) {
            mealType.setIodine(UnitConvertersKt.toPlatformMass(iodine));
        }
        Mass iron = nutritionRecord.getIron();
        if (iron != null) {
            mealType.setIron(UnitConvertersKt.toPlatformMass(iron));
        }
        Mass magnesium = nutritionRecord.getMagnesium();
        if (magnesium != null) {
            mealType.setMagnesium(UnitConvertersKt.toPlatformMass(magnesium));
        }
        Mass manganese = nutritionRecord.getManganese();
        if (manganese != null) {
            mealType.setManganese(UnitConvertersKt.toPlatformMass(manganese));
        }
        Mass molybdenum = nutritionRecord.getMolybdenum();
        if (molybdenum != null) {
            mealType.setMolybdenum(UnitConvertersKt.toPlatformMass(molybdenum));
        }
        Mass monounsaturatedFat = nutritionRecord.getMonounsaturatedFat();
        if (monounsaturatedFat != null) {
            mealType.setMonounsaturatedFat(UnitConvertersKt.toPlatformMass(monounsaturatedFat));
        }
        String name = nutritionRecord.getName();
        if (name != null) {
            mealType.setMealName(name);
        }
        Mass niacin = nutritionRecord.getNiacin();
        if (niacin != null) {
            mealType.setNiacin(UnitConvertersKt.toPlatformMass(niacin));
        }
        Mass pantothenicAcid = nutritionRecord.getPantothenicAcid();
        if (pantothenicAcid != null) {
            mealType.setPantothenicAcid(UnitConvertersKt.toPlatformMass(pantothenicAcid));
        }
        Mass phosphorus = nutritionRecord.getPhosphorus();
        if (phosphorus != null) {
            mealType.setPhosphorus(UnitConvertersKt.toPlatformMass(phosphorus));
        }
        Mass polyunsaturatedFat = nutritionRecord.getPolyunsaturatedFat();
        if (polyunsaturatedFat != null) {
            mealType.setPolyunsaturatedFat(UnitConvertersKt.toPlatformMass(polyunsaturatedFat));
        }
        Mass potassium = nutritionRecord.getPotassium();
        if (potassium != null) {
            mealType.setPotassium(UnitConvertersKt.toPlatformMass(potassium));
        }
        Mass protein = nutritionRecord.getProtein();
        if (protein != null) {
            mealType.setProtein(UnitConvertersKt.toPlatformMass(protein));
        }
        Mass riboflavin = nutritionRecord.getRiboflavin();
        if (riboflavin != null) {
            mealType.setRiboflavin(UnitConvertersKt.toPlatformMass(riboflavin));
        }
        Mass saturatedFat = nutritionRecord.getSaturatedFat();
        if (saturatedFat != null) {
            mealType.setSaturatedFat(UnitConvertersKt.toPlatformMass(saturatedFat));
        }
        Mass selenium = nutritionRecord.getSelenium();
        if (selenium != null) {
            mealType.setSelenium(UnitConvertersKt.toPlatformMass(selenium));
        }
        Mass sodium = nutritionRecord.getSodium();
        if (sodium != null) {
            mealType.setSodium(UnitConvertersKt.toPlatformMass(sodium));
        }
        Mass sugar = nutritionRecord.getSugar();
        if (sugar != null) {
            mealType.setSugar(UnitConvertersKt.toPlatformMass(sugar));
        }
        Mass thiamin = nutritionRecord.getThiamin();
        if (thiamin != null) {
            mealType.setThiamin(UnitConvertersKt.toPlatformMass(thiamin));
        }
        Mass totalCarbohydrate = nutritionRecord.getTotalCarbohydrate();
        if (totalCarbohydrate != null) {
            mealType.setTotalCarbohydrate(UnitConvertersKt.toPlatformMass(totalCarbohydrate));
        }
        Mass totalFat = nutritionRecord.getTotalFat();
        if (totalFat != null) {
            mealType.setTotalFat(UnitConvertersKt.toPlatformMass(totalFat));
        }
        Mass transFat = nutritionRecord.getTransFat();
        if (transFat != null) {
            mealType.setTransFat(UnitConvertersKt.toPlatformMass(transFat));
        }
        Mass unsaturatedFat = nutritionRecord.getUnsaturatedFat();
        if (unsaturatedFat != null) {
            mealType.setUnsaturatedFat(UnitConvertersKt.toPlatformMass(unsaturatedFat));
        }
        Mass vitaminA = nutritionRecord.getVitaminA();
        if (vitaminA != null) {
            mealType.setVitaminA(UnitConvertersKt.toPlatformMass(vitaminA));
        }
        Mass vitaminB6 = nutritionRecord.getVitaminB6();
        if (vitaminB6 != null) {
            mealType.setVitaminB6(UnitConvertersKt.toPlatformMass(vitaminB6));
        }
        Mass vitaminB12 = nutritionRecord.getVitaminB12();
        if (vitaminB12 != null) {
            mealType.setVitaminB12(UnitConvertersKt.toPlatformMass(vitaminB12));
        }
        Mass vitaminC = nutritionRecord.getVitaminC();
        if (vitaminC != null) {
            mealType.setVitaminC(UnitConvertersKt.toPlatformMass(vitaminC));
        }
        Mass vitaminD = nutritionRecord.getVitaminD();
        if (vitaminD != null) {
            mealType.setVitaminD(UnitConvertersKt.toPlatformMass(vitaminD));
        }
        Mass vitaminE = nutritionRecord.getVitaminE();
        if (vitaminE != null) {
            mealType.setVitaminE(UnitConvertersKt.toPlatformMass(vitaminE));
        }
        Mass vitaminK = nutritionRecord.getVitaminK();
        if (vitaminK != null) {
            mealType.setVitaminK(UnitConvertersKt.toPlatformMass(vitaminK));
        }
        Mass zinc = nutritionRecord.getZinc();
        if (zinc != null) {
            mealType.setZinc(UnitConvertersKt.toPlatformMass(zinc));
        }
        NutritionRecord nutritionRecordBuild = mealType.build();
        nutritionRecordBuild.getClass();
        return nutritionRecordBuild;
    }

    private static final OvulationTestRecord toPlatformOvulationTestRecord(androidx.health.connect.client.records.OvulationTestRecord ovulationTestRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(ovulationTestRecord.getMetadata());
        j$.time.Instant time = ovulationTestRecord.getTime();
        OvulationTestRecord.Builder builder = new OvulationTestRecord.Builder(platformMetadata, TimeConversions.convert(time), IntDefMappingsKt.toPlatformOvulationTestResult(ovulationTestRecord.getResult()));
        ZoneOffset zoneOffset = ovulationTestRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        OvulationTestRecord ovulationTestRecordBuild = builder.build();
        ovulationTestRecordBuild.getClass();
        return ovulationTestRecordBuild;
    }

    private static final OxygenSaturationRecord toPlatformOxygenSaturationRecord(androidx.health.connect.client.records.OxygenSaturationRecord oxygenSaturationRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(oxygenSaturationRecord.getMetadata());
        j$.time.Instant time = oxygenSaturationRecord.getTime();
        OxygenSaturationRecord.Builder builder = new OxygenSaturationRecord.Builder(platformMetadata, TimeConversions.convert(time), UnitConvertersKt.toPlatformPercentage(oxygenSaturationRecord.getPercentage()));
        ZoneOffset zoneOffset = oxygenSaturationRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        OxygenSaturationRecord oxygenSaturationRecordBuild = builder.build();
        oxygenSaturationRecordBuild.getClass();
        return oxygenSaturationRecordBuild;
    }

    private static final PlannedExerciseBlock toPlatformPlannedExerciseBlock(androidx.health.connect.client.records.PlannedExerciseBlock plannedExerciseBlock) {
        PlannedExerciseBlock.Builder builder = new PlannedExerciseBlock.Builder(plannedExerciseBlock.getRepetitions());
        builder.setDescription(plannedExerciseBlock.getDescription());
        List<PlannedExerciseStep> steps = plannedExerciseBlock.getSteps();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(steps, 10));
        Iterator<T> it = steps.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformPlannedExerciseStep((PlannedExerciseStep) it.next()));
        }
        builder.setSteps(arrayList);
        PlannedExerciseBlock plannedExerciseBlockBuild = builder.build();
        plannedExerciseBlockBuild.getClass();
        return plannedExerciseBlockBuild;
    }

    private static final PlannedExerciseSessionRecord toPlatformPlannedExerciseSessionRecord(androidx.health.connect.client.records.PlannedExerciseSessionRecord plannedExerciseSessionRecord) {
        PlannedExerciseSessionRecord.Builder builder;
        if (plannedExerciseSessionRecord.getHasExplicitTime()) {
            builder = new PlannedExerciseSessionRecord.Builder(MetadataConvertersKt.toPlatformMetadata(plannedExerciseSessionRecord.getMetadata()), IntDefMappingsKt.toPlatformExerciseSessionType(plannedExerciseSessionRecord.getExerciseType()), TimeConversions.convert(plannedExerciseSessionRecord.getStartTime()), TimeConversions.convert(plannedExerciseSessionRecord.getEndTime()));
        } else {
            builder = new PlannedExerciseSessionRecord.Builder(MetadataConvertersKt.toPlatformMetadata(plannedExerciseSessionRecord.getMetadata()), IntDefMappingsKt.toPlatformExerciseSessionType(plannedExerciseSessionRecord.getExerciseType()), TimeConversions.convert(plannedExerciseSessionRecord.getStartTime().atZone(plannedExerciseSessionRecord.getStartZoneOffset()).toLocalDate()), TimeConversions.convert(Duration.between(plannedExerciseSessionRecord.getStartTime(), plannedExerciseSessionRecord.getEndTime())));
        }
        ZoneOffset startZoneOffset = plannedExerciseSessionRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = plannedExerciseSessionRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        String title = plannedExerciseSessionRecord.getTitle();
        if (title != null) {
            builder.setTitle(title);
        }
        String notes = plannedExerciseSessionRecord.getNotes();
        if (notes != null) {
            builder.setNotes(notes);
        }
        List<androidx.health.connect.client.records.PlannedExerciseBlock> blocks = plannedExerciseSessionRecord.getBlocks();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(blocks, 10));
        Iterator<T> it = blocks.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformPlannedExerciseBlock((androidx.health.connect.client.records.PlannedExerciseBlock) it.next()));
        }
        builder.setBlocks(arrayList);
        PlannedExerciseSessionRecord plannedExerciseSessionRecordBuild = builder.build();
        plannedExerciseSessionRecordBuild.getClass();
        return plannedExerciseSessionRecordBuild;
    }

    private static final android.health.connect.datatypes.PlannedExerciseStep toPlatformPlannedExerciseStep(PlannedExerciseStep plannedExerciseStep) {
        PlannedExerciseStep.Builder builder = new PlannedExerciseStep.Builder(IntDefMappingsKt.toPlatformExerciseSegmentType(plannedExerciseStep.getExerciseType()), IntDefMappingsKt.toPlatformExerciseCategory(plannedExerciseStep.getExercisePhase()), toPlatformExerciseCompletionGoal(plannedExerciseStep.getCompletionGoal()));
        builder.setDescription(plannedExerciseStep.getDescription());
        List<ExercisePerformanceTarget> performanceTargets = plannedExerciseStep.getPerformanceTargets();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(performanceTargets, 10));
        Iterator<T> it = performanceTargets.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformExercisePerformanceTarget((ExercisePerformanceTarget) it.next()));
        }
        builder.setPerformanceGoals(arrayList);
        android.health.connect.datatypes.PlannedExerciseStep plannedExerciseStepBuild = builder.build();
        plannedExerciseStepBuild.getClass();
        return plannedExerciseStepBuild;
    }

    private static final PowerRecord toPlatformPowerRecord(androidx.health.connect.client.records.PowerRecord powerRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(powerRecord.getMetadata());
        j$.time.Instant startTime = powerRecord.getStartTime();
        j$.time.Instant endTime = powerRecord.getEndTime();
        List<PowerRecord.Sample> samples = powerRecord.getSamples();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
        Iterator<T> it = samples.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformPowerRecordSample((PowerRecord.Sample) it.next()));
        }
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(platformMetadata, startTime, endTime, arrayList);
        PowerRecord.Builder builder = new PowerRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], (List) objArrM[3]);
        ZoneOffset startZoneOffset = powerRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = powerRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        android.health.connect.datatypes.PowerRecord powerRecordBuild = builder.build();
        powerRecordBuild.getClass();
        return powerRecordBuild;
    }

    private static final PowerRecord.PowerRecordSample toPlatformPowerRecordSample(PowerRecord.Sample sample) {
        RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m$4();
        return RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m(UnitConvertersKt.toPlatformPower(sample.getPower()), sample.getTime());
    }

    public static final Record toPlatformRecord(androidx.health.connect.client.records.Record record) {
        record.getClass();
        Record platformRecordExt15 = toPlatformRecordExt15(record);
        if (platformRecordExt15 != null) {
            Fragment$$ExternalSyntheticBUOutline0.m64m((Object) platformRecordExt15);
            return platformRecordExt15;
        }
        Record platformRecordExt13 = toPlatformRecordExt13(record);
        if (platformRecordExt13 != null) {
            Fragment$$ExternalSyntheticBUOutline0.m64m((Object) platformRecordExt13);
            return platformRecordExt13;
        }
        if (record instanceof androidx.health.connect.client.records.ActiveCaloriesBurnedRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformActiveCaloriesBurnedRecord((androidx.health.connect.client.records.ActiveCaloriesBurnedRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.BasalBodyTemperatureRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformBasalBodyTemperatureRecord((androidx.health.connect.client.records.BasalBodyTemperatureRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.BasalMetabolicRateRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformBasalMetabolicRateRecord((androidx.health.connect.client.records.BasalMetabolicRateRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.BloodGlucoseRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformBloodGlucoseRecord((androidx.health.connect.client.records.BloodGlucoseRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.BloodPressureRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformBloodPressureRecord((androidx.health.connect.client.records.BloodPressureRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.BodyFatRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformBodyFatRecord((androidx.health.connect.client.records.BodyFatRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.BodyTemperatureRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformBodyTemperatureRecord((androidx.health.connect.client.records.BodyTemperatureRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.BodyWaterMassRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformBodyWaterMassRecord((androidx.health.connect.client.records.BodyWaterMassRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.BoneMassRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformBoneMassRecord((androidx.health.connect.client.records.BoneMassRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.CervicalMucusRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformCervicalMucusRecord((androidx.health.connect.client.records.CervicalMucusRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.CyclingPedalingCadenceRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformCyclingPedalingCadenceRecord((androidx.health.connect.client.records.CyclingPedalingCadenceRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.DistanceRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformDistanceRecord((androidx.health.connect.client.records.DistanceRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.ElevationGainedRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformElevationGainedRecord((androidx.health.connect.client.records.ElevationGainedRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.ExerciseSessionRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformExerciseSessionRecord((androidx.health.connect.client.records.ExerciseSessionRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.FloorsClimbedRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformFloorsClimbedRecord((androidx.health.connect.client.records.FloorsClimbedRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.HeartRateRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformHeartRateRecord((androidx.health.connect.client.records.HeartRateRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.HeartRateVariabilityRmssdRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformHeartRateVariabilityRmssdRecord((androidx.health.connect.client.records.HeartRateVariabilityRmssdRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.HeightRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformHeightRecord((androidx.health.connect.client.records.HeightRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.HydrationRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformHydrationRecord((androidx.health.connect.client.records.HydrationRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.IntermenstrualBleedingRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformIntermenstrualBleedingRecord((androidx.health.connect.client.records.IntermenstrualBleedingRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.LeanBodyMassRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformLeanBodyMassRecord((androidx.health.connect.client.records.LeanBodyMassRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.MenstruationFlowRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformMenstruationFlowRecord((androidx.health.connect.client.records.MenstruationFlowRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.MenstruationPeriodRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformMenstruationPeriodRecord((androidx.health.connect.client.records.MenstruationPeriodRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.NutritionRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformNutritionRecord((androidx.health.connect.client.records.NutritionRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.OvulationTestRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformOvulationTestRecord((androidx.health.connect.client.records.OvulationTestRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.OxygenSaturationRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformOxygenSaturationRecord((androidx.health.connect.client.records.OxygenSaturationRecord) record));
        }
        if (record instanceof androidx.health.connect.client.records.PowerRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformPowerRecord((androidx.health.connect.client.records.PowerRecord) record));
        }
        if (record instanceof RespiratoryRateRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformRespiratoryRateRecord((RespiratoryRateRecord) record));
        }
        if (record instanceof RestingHeartRateRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformRestingHeartRateRecord((RestingHeartRateRecord) record));
        }
        if (record instanceof SexualActivityRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformSexualActivityRecord((SexualActivityRecord) record));
        }
        if (record instanceof SleepSessionRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformSleepSessionRecord((SleepSessionRecord) record));
        }
        if (record instanceof SpeedRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformSpeedRecord((SpeedRecord) record));
        }
        if (record instanceof StepsCadenceRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformStepsCadenceRecord((StepsCadenceRecord) record));
        }
        if (record instanceof StepsRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformStepsRecord((StepsRecord) record));
        }
        if (record instanceof TotalCaloriesBurnedRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformTotalCaloriesBurnedRecord((TotalCaloriesBurnedRecord) record));
        }
        if (record instanceof Vo2MaxRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformVo2MaxRecord((Vo2MaxRecord) record));
        }
        if (record instanceof WeightRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformWeightRecord((WeightRecord) record));
        }
        if (record instanceof WheelchairPushesRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformWheelchairPushesRecord((WheelchairPushesRecord) record));
        }
        Gson$$ExternalSyntheticBUOutline0.m("Unsupported record ", record);
        return null;
    }

    public static final Class<? extends Record> toPlatformRecordClass(KClass<? extends androidx.health.connect.client.records.Record> kClass) {
        kClass.getClass();
        Class<? extends Record> platformRecordClassExt15 = toPlatformRecordClassExt15(kClass);
        if (platformRecordClassExt15 != null || (platformRecordClassExt15 = toPlatformRecordClassExt13(kClass)) != null) {
            return platformRecordClassExt15;
        }
        Class<? extends Record> cls = RecordMappingsKt.getSDK_TO_PLATFORM_RECORD_CLASS().get(kClass);
        if (cls != null) {
            return cls;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Unsupported record type ", kClass);
        return null;
    }

    private static final Class<? extends Record> toPlatformRecordClassExt13(KClass<? extends androidx.health.connect.client.records.Record> kClass) {
        if (UtilsKt.isAtLeastSdkExtension13()) {
            return RecordMappingsKt.getSDK_TO_PLATFORM_RECORD_CLASS_EXT_13().get(kClass);
        }
        return null;
    }

    private static final Class<? extends Record> toPlatformRecordClassExt15(KClass<? extends androidx.health.connect.client.records.Record> kClass) {
        if (UtilsKt.isAtLeastSdkExtension15()) {
            return RecordMappingsKt.getSDK_TO_PLATFORM_RECORD_CLASS_EXT_15().get(kClass);
        }
        return null;
    }

    private static final Record toPlatformRecordExt13(androidx.health.connect.client.records.Record record) {
        PlannedExerciseSessionRecord platformSkinTemperatureRecord;
        if (!UtilsKt.isAtLeastSdkExtension13()) {
            Fragment$$ExternalSyntheticBUOutline0.m64m((Object) null);
            return null;
        }
        if (record instanceof androidx.health.connect.client.records.PlannedExerciseSessionRecord) {
            platformSkinTemperatureRecord = toPlatformPlannedExerciseSessionRecord((androidx.health.connect.client.records.PlannedExerciseSessionRecord) record);
        } else {
            if (!(record instanceof SkinTemperatureRecord)) {
                Fragment$$ExternalSyntheticBUOutline0.m64m((Object) null);
                return null;
            }
            platformSkinTemperatureRecord = toPlatformSkinTemperatureRecord((SkinTemperatureRecord) record);
        }
        return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) platformSkinTemperatureRecord);
    }

    private static final Record toPlatformRecordExt15(androidx.health.connect.client.records.Record record) {
        if (!UtilsKt.isAtLeastSdkExtension15()) {
            Fragment$$ExternalSyntheticBUOutline0.m64m((Object) null);
            return null;
        }
        if (record instanceof androidx.health.connect.client.records.MindfulnessSessionRecord) {
            return Fragment$$ExternalSyntheticBUOutline0.m64m((Object) toPlatformMindfulnessSessionRecord((androidx.health.connect.client.records.MindfulnessSessionRecord) record));
        }
        Fragment$$ExternalSyntheticBUOutline0.m64m((Object) null);
        return null;
    }

    private static final android.health.connect.datatypes.RespiratoryRateRecord toPlatformRespiratoryRateRecord(RespiratoryRateRecord respiratoryRateRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(respiratoryRateRecord.getMetadata());
        j$.time.Instant time = respiratoryRateRecord.getTime();
        RespiratoryRateRecord.Builder builder = new RespiratoryRateRecord.Builder(platformMetadata, TimeConversions.convert(time), respiratoryRateRecord.getRate());
        ZoneOffset zoneOffset = respiratoryRateRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        android.health.connect.datatypes.RespiratoryRateRecord respiratoryRateRecordBuild = builder.build();
        respiratoryRateRecordBuild.getClass();
        return respiratoryRateRecordBuild;
    }

    private static final android.health.connect.datatypes.RestingHeartRateRecord toPlatformRestingHeartRateRecord(RestingHeartRateRecord restingHeartRateRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(restingHeartRateRecord.getMetadata());
        j$.time.Instant time = restingHeartRateRecord.getTime();
        RestingHeartRateRecord.Builder builder = new RestingHeartRateRecord.Builder(platformMetadata, TimeConversions.convert(time), restingHeartRateRecord.getBeatsPerMinute());
        ZoneOffset zoneOffset = restingHeartRateRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        android.health.connect.datatypes.RestingHeartRateRecord restingHeartRateRecordBuild = builder.build();
        restingHeartRateRecordBuild.getClass();
        return restingHeartRateRecordBuild;
    }

    private static final android.health.connect.datatypes.SexualActivityRecord toPlatformSexualActivityRecord(SexualActivityRecord sexualActivityRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(sexualActivityRecord.getMetadata());
        j$.time.Instant time = sexualActivityRecord.getTime();
        SexualActivityRecord.Builder builder = new SexualActivityRecord.Builder(platformMetadata, TimeConversions.convert(time), IntDefMappingsKt.toPlatformSexualActivityProtectionUsed(sexualActivityRecord.getProtectionUsed()));
        ZoneOffset zoneOffset = sexualActivityRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        android.health.connect.datatypes.SexualActivityRecord sexualActivityRecordBuild = builder.build();
        sexualActivityRecordBuild.getClass();
        return sexualActivityRecordBuild;
    }

    private static final android.health.connect.datatypes.SkinTemperatureRecord toPlatformSkinTemperatureRecord(SkinTemperatureRecord skinTemperatureRecord) {
        SkinTemperatureRecord.Builder builder = new SkinTemperatureRecord.Builder(MetadataConvertersKt.toPlatformMetadata(skinTemperatureRecord.getMetadata()), TimeConversions.convert(skinTemperatureRecord.getStartTime()), TimeConversions.convert(skinTemperatureRecord.getEndTime()));
        ZoneOffset startZoneOffset = skinTemperatureRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = skinTemperatureRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        androidx.health.connect.client.units.Temperature baseline = skinTemperatureRecord.getBaseline();
        if (baseline != null) {
            builder.setBaseline(UnitConvertersKt.toPlatformTemperature(baseline));
        }
        builder.setMeasurementLocation(IntDefMappingsKt.toPlatformSkinTemperatureMeasurementLocation(skinTemperatureRecord.getMeasurementLocation()));
        List<SkinTemperatureRecord.Delta> deltas = skinTemperatureRecord.getDeltas();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(deltas, 10));
        Iterator<T> it = deltas.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformSkinTemperatureRecordDelta((SkinTemperatureRecord.Delta) it.next()));
        }
        builder.setDeltas(arrayList);
        android.health.connect.datatypes.SkinTemperatureRecord skinTemperatureRecordBuild = builder.build();
        skinTemperatureRecordBuild.getClass();
        return skinTemperatureRecordBuild;
    }

    private static final SkinTemperatureRecord.Delta toPlatformSkinTemperatureRecordDelta(SkinTemperatureRecord.Delta delta) {
        RecordConvertersKt$$ExternalSyntheticApiModelOutline222.m();
        return RecordConvertersKt$$ExternalSyntheticApiModelOutline222.m(UnitConvertersKt.toPlatformTemperatureDelta(delta.getDelta()), delta.getTime());
    }

    private static final android.health.connect.datatypes.SleepSessionRecord toPlatformSleepSessionRecord(SleepSessionRecord sleepSessionRecord) {
        SleepSessionRecord.Builder builder = new SleepSessionRecord.Builder(MetadataConvertersKt.toPlatformMetadata(sleepSessionRecord.getMetadata()), TimeConversions.convert(sleepSessionRecord.getStartTime()), TimeConversions.convert(sleepSessionRecord.getEndTime()));
        ZoneOffset startZoneOffset = sleepSessionRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = sleepSessionRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        String notes = sleepSessionRecord.getNotes();
        if (notes != null) {
            builder.setNotes(notes);
        }
        String title = sleepSessionRecord.getTitle();
        if (title != null) {
            builder.setTitle(title);
        }
        List<SleepSessionRecord.Stage> stages = sleepSessionRecord.getStages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(stages, 10));
        Iterator<T> it = stages.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformSleepSessionStage((SleepSessionRecord.Stage) it.next()));
        }
        builder.setStages(arrayList);
        android.health.connect.datatypes.SleepSessionRecord sleepSessionRecordBuild = builder.build();
        sleepSessionRecordBuild.getClass();
        return sleepSessionRecordBuild;
    }

    private static final SleepSessionRecord.Stage toPlatformSleepSessionStage(SleepSessionRecord.Stage stage) {
        RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m$5();
        return RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m(stage.getStartTime(), stage.getEndTime(), IntDefMappingsKt.toPlatformSleepStageType(stage.getStage()));
    }

    private static final android.health.connect.datatypes.SpeedRecord toPlatformSpeedRecord(SpeedRecord speedRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(speedRecord.getMetadata());
        j$.time.Instant startTime = speedRecord.getStartTime();
        j$.time.Instant endTime = speedRecord.getEndTime();
        List<SpeedRecord.Sample> samples = speedRecord.getSamples();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
        Iterator<T> it = samples.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformSpeedRecordSample((SpeedRecord.Sample) it.next()));
        }
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(platformMetadata, startTime, endTime, arrayList);
        SpeedRecord.Builder builder = new SpeedRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], (List) objArrM[3]);
        ZoneOffset startZoneOffset = speedRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = speedRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        android.health.connect.datatypes.SpeedRecord speedRecordBuild = builder.build();
        speedRecordBuild.getClass();
        return speedRecordBuild;
    }

    private static final SpeedRecord.SpeedRecordSample toPlatformSpeedRecordSample(SpeedRecord.Sample sample) {
        RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m();
        return RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m(UnitConvertersKt.toPlatformVelocity(sample.getSpeed()), sample.getTime());
    }

    private static final android.health.connect.datatypes.StepsCadenceRecord toPlatformStepsCadenceRecord(StepsCadenceRecord stepsCadenceRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(stepsCadenceRecord.getMetadata());
        j$.time.Instant startTime = stepsCadenceRecord.getStartTime();
        j$.time.Instant endTime = stepsCadenceRecord.getEndTime();
        List<StepsCadenceRecord.Sample> samples = stepsCadenceRecord.getSamples();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
        Iterator<T> it = samples.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformStepsCadenceSample((StepsCadenceRecord.Sample) it.next()));
        }
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(platformMetadata, startTime, endTime, arrayList);
        StepsCadenceRecord.Builder builder = new StepsCadenceRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], (List) objArrM[3]);
        ZoneOffset startZoneOffset = stepsCadenceRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = stepsCadenceRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        android.health.connect.datatypes.StepsCadenceRecord stepsCadenceRecordBuild = builder.build();
        stepsCadenceRecordBuild.getClass();
        return stepsCadenceRecordBuild;
    }

    private static final StepsCadenceRecord.StepsCadenceRecordSample toPlatformStepsCadenceSample(StepsCadenceRecord.Sample sample) {
        RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m$1();
        return RecordConvertersKt$$ExternalSyntheticApiModelOutline212.m150m(sample.getTime(), sample.getRate());
    }

    private static final android.health.connect.datatypes.StepsRecord toPlatformStepsRecord(StepsRecord stepsRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(stepsRecord.getMetadata()), stepsRecord.getStartTime(), stepsRecord.getEndTime(), stepsRecord.getCount());
        StepsRecord.Builder builder = new StepsRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], ((Long) objArrM[3]).longValue());
        ZoneOffset startZoneOffset = stepsRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = stepsRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        android.health.connect.datatypes.StepsRecord stepsRecordBuild = builder.build();
        stepsRecordBuild.getClass();
        return stepsRecordBuild;
    }

    private static final android.health.connect.datatypes.TotalCaloriesBurnedRecord toPlatformTotalCaloriesBurnedRecord(TotalCaloriesBurnedRecord totalCaloriesBurnedRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(totalCaloriesBurnedRecord.getMetadata()), totalCaloriesBurnedRecord.getStartTime(), totalCaloriesBurnedRecord.getEndTime(), UnitConvertersKt.toPlatformEnergy(totalCaloriesBurnedRecord.getEnergy()));
        TotalCaloriesBurnedRecord.Builder builder = new TotalCaloriesBurnedRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], (Energy) objArrM[3]);
        ZoneOffset startZoneOffset = totalCaloriesBurnedRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = totalCaloriesBurnedRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        android.health.connect.datatypes.TotalCaloriesBurnedRecord totalCaloriesBurnedRecordBuild = builder.build();
        totalCaloriesBurnedRecordBuild.getClass();
        return totalCaloriesBurnedRecordBuild;
    }

    private static final android.health.connect.datatypes.Vo2MaxRecord toPlatformVo2MaxRecord(Vo2MaxRecord vo2MaxRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(vo2MaxRecord.getMetadata()), vo2MaxRecord.getTime(), IntDefMappingsKt.toPlatformVo2MaxMeasurementMethod(vo2MaxRecord.getMeasurementMethod()), vo2MaxRecord.getVo2MillilitersPerMinuteKilogram());
        Vo2MaxRecord.Builder builder = new Vo2MaxRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], ((Integer) objArrM[2]).intValue(), ((Double) objArrM[3]).doubleValue());
        ZoneOffset zoneOffset = vo2MaxRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        android.health.connect.datatypes.Vo2MaxRecord vo2MaxRecordBuild = builder.build();
        vo2MaxRecordBuild.getClass();
        return vo2MaxRecordBuild;
    }

    private static final android.health.connect.datatypes.WeightRecord toPlatformWeightRecord(WeightRecord weightRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(weightRecord.getMetadata());
        j$.time.Instant time = weightRecord.getTime();
        WeightRecord.Builder builder = new WeightRecord.Builder(platformMetadata, TimeConversions.convert(time), UnitConvertersKt.toPlatformMass(weightRecord.getWeight()));
        ZoneOffset zoneOffset = weightRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(TimeConversions.convert(zoneOffset));
        }
        android.health.connect.datatypes.WeightRecord weightRecordBuild = builder.build();
        weightRecordBuild.getClass();
        return weightRecordBuild;
    }

    private static final android.health.connect.datatypes.WheelchairPushesRecord toPlatformWheelchairPushesRecord(WheelchairPushesRecord wheelchairPushesRecord) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(MetadataConvertersKt.toPlatformMetadata(wheelchairPushesRecord.getMetadata()), wheelchairPushesRecord.getStartTime(), wheelchairPushesRecord.getEndTime(), wheelchairPushesRecord.getCount());
        WheelchairPushesRecord.Builder builder = new WheelchairPushesRecord.Builder((android.health.connect.datatypes.Metadata) objArrM[0], (Instant) objArrM[1], (Instant) objArrM[2], ((Long) objArrM[3]).longValue());
        ZoneOffset startZoneOffset = wheelchairPushesRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(TimeConversions.convert(startZoneOffset));
        }
        ZoneOffset endZoneOffset = wheelchairPushesRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(TimeConversions.convert(endZoneOffset));
        }
        android.health.connect.datatypes.WheelchairPushesRecord wheelchairPushesRecordBuild = builder.build();
        wheelchairPushesRecordBuild.getClass();
        return wheelchairPushesRecordBuild;
    }

    private static final androidx.health.connect.client.records.ActiveCaloriesBurnedRecord toSdkActiveCaloriesBurnedRecord(ActiveCaloriesBurnedRecord activeCaloriesBurnedRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(activeCaloriesBurnedRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(activeCaloriesBurnedRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(activeCaloriesBurnedRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(activeCaloriesBurnedRecord.getEndZoneOffset());
        Energy energy = activeCaloriesBurnedRecord.getEnergy();
        energy.getClass();
        androidx.health.connect.client.units.Energy sdkEnergy = UnitConvertersKt.toSdkEnergy(energy);
        android.health.connect.datatypes.Metadata metadata = activeCaloriesBurnedRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.ActiveCaloriesBurnedRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, sdkEnergy, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.BasalBodyTemperatureRecord toSdkBasalBodyTemperatureRecord(BasalBodyTemperatureRecord basalBodyTemperatureRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(basalBodyTemperatureRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(basalBodyTemperatureRecord.getZoneOffset());
        Temperature temperature = basalBodyTemperatureRecord.getTemperature();
        temperature.getClass();
        androidx.health.connect.client.units.Temperature sdkTemperature = UnitConvertersKt.toSdkTemperature(temperature);
        int measurementLocation = basalBodyTemperatureRecord.getMeasurementLocation();
        android.health.connect.datatypes.Metadata metadata = basalBodyTemperatureRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.BasalBodyTemperatureRecord(instantConvert, zoneOffsetConvert, MetadataConvertersKt.toSdkMetadata(metadata), sdkTemperature, measurementLocation);
    }

    private static final androidx.health.connect.client.records.BasalMetabolicRateRecord toSdkBasalMetabolicRateRecord(BasalMetabolicRateRecord basalMetabolicRateRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(basalMetabolicRateRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(basalMetabolicRateRecord.getZoneOffset());
        Power basalMetabolicRate = basalMetabolicRateRecord.getBasalMetabolicRate();
        basalMetabolicRate.getClass();
        androidx.health.connect.client.units.Power sdkPower = UnitConvertersKt.toSdkPower(basalMetabolicRate);
        android.health.connect.datatypes.Metadata metadata = basalMetabolicRateRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.BasalMetabolicRateRecord(instantConvert, zoneOffsetConvert, sdkPower, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.BloodGlucoseRecord toSdkBloodGlucoseRecord(BloodGlucoseRecord bloodGlucoseRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(bloodGlucoseRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(bloodGlucoseRecord.getZoneOffset());
        BloodGlucose level = bloodGlucoseRecord.getLevel();
        level.getClass();
        androidx.health.connect.client.units.BloodGlucose sdkBloodGlucose = UnitConvertersKt.toSdkBloodGlucose(level);
        int sdkBloodGlucoseSpecimenSource = IntDefMappingsKt.toSdkBloodGlucoseSpecimenSource(bloodGlucoseRecord.getSpecimenSource());
        int sdkMealType = IntDefMappingsKt.toSdkMealType(bloodGlucoseRecord.getMealType());
        int sdkRelationToMeal = IntDefMappingsKt.toSdkRelationToMeal(bloodGlucoseRecord.getRelationToMeal());
        android.health.connect.datatypes.Metadata metadata = bloodGlucoseRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.BloodGlucoseRecord(instantConvert, zoneOffsetConvert, MetadataConvertersKt.toSdkMetadata(metadata), sdkBloodGlucose, sdkBloodGlucoseSpecimenSource, sdkMealType, sdkRelationToMeal);
    }

    private static final androidx.health.connect.client.records.BloodPressureRecord toSdkBloodPressureRecord(BloodPressureRecord bloodPressureRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(bloodPressureRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(bloodPressureRecord.getZoneOffset());
        Pressure systolic = bloodPressureRecord.getSystolic();
        systolic.getClass();
        androidx.health.connect.client.units.Pressure sdkPressure = UnitConvertersKt.toSdkPressure(systolic);
        Pressure diastolic = bloodPressureRecord.getDiastolic();
        diastolic.getClass();
        androidx.health.connect.client.units.Pressure sdkPressure2 = UnitConvertersKt.toSdkPressure(diastolic);
        int sdkBloodPressureBodyPosition = IntDefMappingsKt.toSdkBloodPressureBodyPosition(bloodPressureRecord.getBodyPosition());
        int sdkBloodPressureMeasurementLocation = IntDefMappingsKt.toSdkBloodPressureMeasurementLocation(bloodPressureRecord.getMeasurementLocation());
        android.health.connect.datatypes.Metadata metadata = bloodPressureRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.BloodPressureRecord(instantConvert, zoneOffsetConvert, MetadataConvertersKt.toSdkMetadata(metadata), sdkPressure, sdkPressure2, sdkBloodPressureBodyPosition, sdkBloodPressureMeasurementLocation);
    }

    private static final androidx.health.connect.client.records.BodyFatRecord toSdkBodyFatRecord(BodyFatRecord bodyFatRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(bodyFatRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(bodyFatRecord.getZoneOffset());
        Percentage percentage = bodyFatRecord.getPercentage();
        percentage.getClass();
        androidx.health.connect.client.units.Percentage sdkPercentage = UnitConvertersKt.toSdkPercentage(percentage);
        android.health.connect.datatypes.Metadata metadata = bodyFatRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.BodyFatRecord(instantConvert, zoneOffsetConvert, sdkPercentage, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.BodyTemperatureRecord toSdkBodyTemperatureRecord(BodyTemperatureRecord bodyTemperatureRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(bodyTemperatureRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(bodyTemperatureRecord.getZoneOffset());
        Temperature temperature = bodyTemperatureRecord.getTemperature();
        temperature.getClass();
        androidx.health.connect.client.units.Temperature sdkTemperature = UnitConvertersKt.toSdkTemperature(temperature);
        int sdkBodyTemperatureMeasurementLocation = IntDefMappingsKt.toSdkBodyTemperatureMeasurementLocation(bodyTemperatureRecord.getMeasurementLocation());
        android.health.connect.datatypes.Metadata metadata = bodyTemperatureRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.BodyTemperatureRecord(instantConvert, zoneOffsetConvert, MetadataConvertersKt.toSdkMetadata(metadata), sdkTemperature, sdkBodyTemperatureMeasurementLocation);
    }

    private static final androidx.health.connect.client.records.BodyWaterMassRecord toSdkBodyWaterMassRecord(BodyWaterMassRecord bodyWaterMassRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(bodyWaterMassRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(bodyWaterMassRecord.getZoneOffset());
        android.health.connect.datatypes.units.Mass bodyWaterMass = bodyWaterMassRecord.getBodyWaterMass();
        bodyWaterMass.getClass();
        Mass sdkMass = UnitConvertersKt.toSdkMass(bodyWaterMass);
        android.health.connect.datatypes.Metadata metadata = bodyWaterMassRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.BodyWaterMassRecord(instantConvert, zoneOffsetConvert, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.BoneMassRecord toSdkBoneMassRecord(BoneMassRecord boneMassRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(boneMassRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(boneMassRecord.getZoneOffset());
        android.health.connect.datatypes.units.Mass mass = boneMassRecord.getMass();
        mass.getClass();
        Mass sdkMass = UnitConvertersKt.toSdkMass(mass);
        android.health.connect.datatypes.Metadata metadata = boneMassRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.BoneMassRecord(instantConvert, zoneOffsetConvert, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.CervicalMucusRecord toSdkCervicalMucusRecord(CervicalMucusRecord cervicalMucusRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(cervicalMucusRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(cervicalMucusRecord.getZoneOffset());
        int sdkCervicalMucusAppearance = IntDefMappingsKt.toSdkCervicalMucusAppearance(cervicalMucusRecord.getAppearance());
        int sdkCervicalMucusSensation = IntDefMappingsKt.toSdkCervicalMucusSensation(cervicalMucusRecord.getSensation());
        android.health.connect.datatypes.Metadata metadata = cervicalMucusRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.CervicalMucusRecord(instantConvert, zoneOffsetConvert, MetadataConvertersKt.toSdkMetadata(metadata), sdkCervicalMucusAppearance, sdkCervicalMucusSensation);
    }

    private static final androidx.health.connect.client.records.CyclingPedalingCadenceRecord toSdkCyclingPedalingCadenceRecord(android.health.connect.datatypes.CyclingPedalingCadenceRecord cyclingPedalingCadenceRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(cyclingPedalingCadenceRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(cyclingPedalingCadenceRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(cyclingPedalingCadenceRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(cyclingPedalingCadenceRecord.getEndZoneOffset());
        List<CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample> samples = cyclingPedalingCadenceRecord.getSamples();
        samples.getClass();
        List<CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample> list = samples;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample cyclingPedalingCadenceRecordSample : list) {
            cyclingPedalingCadenceRecordSample.getClass();
            arrayList.add(toSdkCyclingPedalingCadenceSample(cyclingPedalingCadenceRecordSample));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkCyclingPedalingCadenceRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((CyclingPedalingCadenceRecord.Sample) t).getTime(), ((CyclingPedalingCadenceRecord.Sample) t2).getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = cyclingPedalingCadenceRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.CyclingPedalingCadenceRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, listSortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final CyclingPedalingCadenceRecord.Sample toSdkCyclingPedalingCadenceSample(CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample cyclingPedalingCadenceRecordSample) {
        j$.time.Instant instantConvert = TimeConversions.convert(cyclingPedalingCadenceRecordSample.getTime());
        instantConvert.getClass();
        return new CyclingPedalingCadenceRecord.Sample(instantConvert, cyclingPedalingCadenceRecordSample.getRevolutionsPerMinute());
    }

    private static final androidx.health.connect.client.records.DistanceRecord toSdkDistanceRecord(DistanceRecord distanceRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(distanceRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(distanceRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(distanceRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(distanceRecord.getEndZoneOffset());
        Length distance = distanceRecord.getDistance();
        distance.getClass();
        androidx.health.connect.client.units.Length sdkLength = UnitConvertersKt.toSdkLength(distance);
        android.health.connect.datatypes.Metadata metadata = distanceRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.DistanceRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, sdkLength, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.ElevationGainedRecord toSdkElevationGainedRecord(ElevationGainedRecord elevationGainedRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(elevationGainedRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(elevationGainedRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(elevationGainedRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(elevationGainedRecord.getEndZoneOffset());
        Length elevation = elevationGainedRecord.getElevation();
        elevation.getClass();
        androidx.health.connect.client.units.Length sdkLength = UnitConvertersKt.toSdkLength(elevation);
        android.health.connect.datatypes.Metadata metadata = elevationGainedRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.ElevationGainedRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, sdkLength, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    public static final androidx.health.connect.client.records.ExerciseCompletionGoal toSdkExerciseCompletionGoal(android.health.connect.datatypes.ExerciseCompletionGoal exerciseCompletionGoal) {
        exerciseCompletionGoal.getClass();
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.DistanceGoal) {
            Length distance = ((ExerciseCompletionGoal.DistanceGoal) exerciseCompletionGoal).getDistance();
            distance.getClass();
            return new ExerciseCompletionGoal.DistanceGoal(UnitConvertersKt.toSdkLength(distance));
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.DistanceWithVariableRestGoal) {
            ExerciseCompletionGoal.DistanceWithVariableRestGoal distanceWithVariableRestGoal = (ExerciseCompletionGoal.DistanceWithVariableRestGoal) exerciseCompletionGoal;
            Length distance2 = distanceWithVariableRestGoal.getDistance();
            distance2.getClass();
            androidx.health.connect.client.units.Length sdkLength = UnitConvertersKt.toSdkLength(distance2);
            Duration durationConvert = TimeConversions.convert(distanceWithVariableRestGoal.getDuration());
            durationConvert.getClass();
            return new ExerciseCompletionGoal.DistanceAndDurationGoal(sdkLength, durationConvert);
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.StepsGoal) {
            return new ExerciseCompletionGoal.StepsGoal(((ExerciseCompletionGoal.StepsGoal) exerciseCompletionGoal).getSteps());
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.DurationGoal) {
            Duration durationConvert2 = TimeConversions.convert(((ExerciseCompletionGoal.DurationGoal) exerciseCompletionGoal).getDuration());
            durationConvert2.getClass();
            return new ExerciseCompletionGoal.DurationGoal(durationConvert2);
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.RepetitionsGoal) {
            return new ExerciseCompletionGoal.RepetitionsGoal(((ExerciseCompletionGoal.RepetitionsGoal) exerciseCompletionGoal).getRepetitions());
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.TotalCaloriesBurnedGoal) {
            Energy totalCalories = ((ExerciseCompletionGoal.TotalCaloriesBurnedGoal) exerciseCompletionGoal).getTotalCalories();
            totalCalories.getClass();
            return new ExerciseCompletionGoal.TotalCaloriesBurnedGoal(UnitConvertersKt.toSdkEnergy(totalCalories));
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.ActiveCaloriesBurnedGoal) {
            Energy activeCalories = ((ExerciseCompletionGoal.ActiveCaloriesBurnedGoal) exerciseCompletionGoal).getActiveCalories();
            activeCalories.getClass();
            return new ExerciseCompletionGoal.ActiveCaloriesBurnedGoal(UnitConvertersKt.toSdkEnergy(activeCalories));
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.UnknownGoal) {
            return ExerciseCompletionGoal.UnknownGoal.INSTANCE;
        }
        if (exerciseCompletionGoal instanceof ExerciseCompletionGoal.UnspecifiedGoal) {
            return ExerciseCompletionGoal.ManualCompletion.INSTANCE;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Unsupported exercise completion goal ", exerciseCompletionGoal);
        return null;
    }

    public static final androidx.health.connect.client.records.ExerciseLap toSdkExerciseLap(ExerciseLap exerciseLap) {
        exerciseLap.getClass();
        j$.time.Instant instantConvert = TimeConversions.convert(exerciseLap.getStartTime());
        instantConvert.getClass();
        j$.time.Instant instantConvert2 = TimeConversions.convert(exerciseLap.getEndTime());
        instantConvert2.getClass();
        Length length = exerciseLap.getLength();
        return new androidx.health.connect.client.records.ExerciseLap(instantConvert, instantConvert2, length != null ? UnitConvertersKt.toSdkLength(length) : null);
    }

    public static final ExercisePerformanceTarget toSdkExercisePerformanceTarget(ExercisePerformanceGoal exercisePerformanceGoal) {
        exercisePerformanceGoal.getClass();
        if (exercisePerformanceGoal instanceof ExercisePerformanceGoal.PowerGoal) {
            ExercisePerformanceGoal.PowerGoal powerGoal = (ExercisePerformanceGoal.PowerGoal) exercisePerformanceGoal;
            Power minPower = powerGoal.getMinPower();
            minPower.getClass();
            androidx.health.connect.client.units.Power sdkPower = UnitConvertersKt.toSdkPower(minPower);
            Power maxPower = powerGoal.getMaxPower();
            maxPower.getClass();
            return new ExercisePerformanceTarget.PowerTarget(sdkPower, UnitConvertersKt.toSdkPower(maxPower));
        }
        if (exercisePerformanceGoal instanceof ExercisePerformanceGoal.SpeedGoal) {
            ExercisePerformanceGoal.SpeedGoal speedGoal = (ExercisePerformanceGoal.SpeedGoal) exercisePerformanceGoal;
            Velocity minSpeed = speedGoal.getMinSpeed();
            minSpeed.getClass();
            androidx.health.connect.client.units.Velocity sdkVelocity = UnitConvertersKt.toSdkVelocity(minSpeed);
            Velocity maxSpeed = speedGoal.getMaxSpeed();
            maxSpeed.getClass();
            return new ExercisePerformanceTarget.SpeedTarget(sdkVelocity, UnitConvertersKt.toSdkVelocity(maxSpeed));
        }
        if (exercisePerformanceGoal instanceof ExercisePerformanceGoal.CadenceGoal) {
            ExercisePerformanceGoal.CadenceGoal cadenceGoal = (ExercisePerformanceGoal.CadenceGoal) exercisePerformanceGoal;
            return new ExercisePerformanceTarget.CadenceTarget(cadenceGoal.getMinRpm(), cadenceGoal.getMaxRpm());
        }
        if (exercisePerformanceGoal instanceof ExercisePerformanceGoal.HeartRateGoal) {
            ExercisePerformanceGoal.HeartRateGoal heartRateGoal = (ExercisePerformanceGoal.HeartRateGoal) exercisePerformanceGoal;
            return new ExercisePerformanceTarget.HeartRateTarget(heartRateGoal.getMinBpm(), heartRateGoal.getMaxBpm());
        }
        if (exercisePerformanceGoal instanceof ExercisePerformanceGoal.WeightGoal) {
            android.health.connect.datatypes.units.Mass mass = ((ExercisePerformanceGoal.WeightGoal) exercisePerformanceGoal).getMass();
            mass.getClass();
            return new ExercisePerformanceTarget.WeightTarget(UnitConvertersKt.toSdkMass(mass));
        }
        if (exercisePerformanceGoal instanceof ExercisePerformanceGoal.RateOfPerceivedExertionGoal) {
            return new ExercisePerformanceTarget.RateOfPerceivedExertionTarget(((ExercisePerformanceGoal.RateOfPerceivedExertionGoal) exercisePerformanceGoal).getRpe());
        }
        if (exercisePerformanceGoal instanceof ExercisePerformanceGoal.AmrapGoal) {
            return ExercisePerformanceTarget.AmrapTarget.INSTANCE;
        }
        if (exercisePerformanceGoal instanceof ExercisePerformanceGoal.UnknownGoal) {
            return ExercisePerformanceTarget.UnknownTarget.INSTANCE;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Unsupported exercise performance target ", exercisePerformanceGoal);
        return null;
    }

    public static final androidx.health.connect.client.records.ExerciseRoute toSdkExerciseRoute(android.health.connect.datatypes.ExerciseRoute exerciseRoute) {
        exerciseRoute.getClass();
        List<ExerciseRoute.Location> routeLocations = exerciseRoute.getRouteLocations();
        routeLocations.getClass();
        List<ExerciseRoute.Location> list = routeLocations;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ExerciseRoute.Location location : list) {
            j$.time.Instant instantConvert = TimeConversions.convert(location.getTime());
            instantConvert.getClass();
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            Length horizontalAccuracy = location.getHorizontalAccuracy();
            androidx.health.connect.client.units.Length sdkLength = null;
            androidx.health.connect.client.units.Length sdkLength2 = horizontalAccuracy != null ? UnitConvertersKt.toSdkLength(horizontalAccuracy) : null;
            Length verticalAccuracy = location.getVerticalAccuracy();
            androidx.health.connect.client.units.Length sdkLength3 = verticalAccuracy != null ? UnitConvertersKt.toSdkLength(verticalAccuracy) : null;
            Length altitude = location.getAltitude();
            if (altitude != null) {
                sdkLength = UnitConvertersKt.toSdkLength(altitude);
            }
            arrayList.add(new ExerciseRoute.Location(instantConvert, latitude, longitude, sdkLength2, sdkLength3, sdkLength));
        }
        return new androidx.health.connect.client.records.ExerciseRoute(arrayList);
    }

    public static final androidx.health.connect.client.records.ExerciseSegment toSdkExerciseSegment(ExerciseSegment exerciseSegment) {
        exerciseSegment.getClass();
        j$.time.Instant instantConvert = TimeConversions.convert(exerciseSegment.getStartTime());
        instantConvert.getClass();
        j$.time.Instant instantConvert2 = TimeConversions.convert(exerciseSegment.getEndTime());
        instantConvert2.getClass();
        return new androidx.health.connect.client.records.ExerciseSegment(instantConvert, instantConvert2, IntDefMappingsKt.toSdkExerciseSegmentType(exerciseSegment.getSegmentType()), exerciseSegment.getRepetitionsCount());
    }

    private static final androidx.health.connect.client.records.ExerciseSessionRecord toSdkExerciseSessionRecord(ExerciseSessionRecord exerciseSessionRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(exerciseSessionRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(exerciseSessionRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(exerciseSessionRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(exerciseSessionRecord.getEndZoneOffset());
        int sdkExerciseSessionType = IntDefMappingsKt.toSdkExerciseSessionType(exerciseSessionRecord.getExerciseType());
        CharSequence title = exerciseSessionRecord.getTitle();
        String string = title != null ? title.toString() : null;
        CharSequence notes = exerciseSessionRecord.getNotes();
        String string2 = notes != null ? notes.toString() : null;
        List<ExerciseLap> laps = exerciseSessionRecord.getLaps();
        laps.getClass();
        List<ExerciseLap> list = laps;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ExerciseLap exerciseLap : list) {
            exerciseLap.getClass();
            arrayList.add(toSdkExerciseLap(exerciseLap));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkExerciseSessionRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((androidx.health.connect.client.records.ExerciseLap) t).getStartTime(), ((androidx.health.connect.client.records.ExerciseLap) t2).getStartTime());
            }
        });
        List<ExerciseSegment> segments = exerciseSessionRecord.getSegments();
        segments.getClass();
        List<ExerciseSegment> list2 = segments;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ExerciseSegment exerciseSegment : list2) {
            exerciseSegment.getClass();
            arrayList2.add(toSdkExerciseSegment(exerciseSegment));
        }
        List listSortedWith2 = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkExerciseSessionRecord$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((androidx.health.connect.client.records.ExerciseSegment) t).getStartTime(), ((androidx.health.connect.client.records.ExerciseSegment) t2).getStartTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = exerciseSessionRecord.getMetadata();
        metadata.getClass();
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        android.health.connect.datatypes.ExerciseRoute route = exerciseSessionRecord.getRoute();
        return new androidx.health.connect.client.records.ExerciseSessionRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, sdkMetadata, sdkExerciseSessionType, string, string2, listSortedWith2, listSortedWith, route != null ? new ExerciseRouteResult.Data(toSdkExerciseRoute(route)) : exerciseSessionRecord.hasRoute() ? new ExerciseRouteResult.ConsentRequired() : new ExerciseRouteResult.NoData(), UtilsKt.isAtLeastSdkExtension13() ? exerciseSessionRecord.getPlannedExerciseSessionId() : null);
    }

    private static final androidx.health.connect.client.records.FloorsClimbedRecord toSdkFloorsClimbedRecord(FloorsClimbedRecord floorsClimbedRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(floorsClimbedRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(floorsClimbedRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(floorsClimbedRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(floorsClimbedRecord.getEndZoneOffset());
        double floors = floorsClimbedRecord.getFloors();
        android.health.connect.datatypes.Metadata metadata = floorsClimbedRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.FloorsClimbedRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, floors, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.HeartRateRecord toSdkHeartRateRecord(android.health.connect.datatypes.HeartRateRecord heartRateRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(heartRateRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(heartRateRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(heartRateRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(heartRateRecord.getEndZoneOffset());
        List<HeartRateRecord.HeartRateSample> samples = heartRateRecord.getSamples();
        samples.getClass();
        List<HeartRateRecord.HeartRateSample> list = samples;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (HeartRateRecord.HeartRateSample heartRateSample : list) {
            heartRateSample.getClass();
            arrayList.add(toSdkHeartRateSample(heartRateSample));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkHeartRateRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((HeartRateRecord.Sample) t).getTime(), ((HeartRateRecord.Sample) t2).getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = heartRateRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.HeartRateRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, listSortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final HeartRateRecord.Sample toSdkHeartRateSample(HeartRateRecord.HeartRateSample heartRateSample) {
        j$.time.Instant instantConvert = TimeConversions.convert(heartRateSample.getTime());
        instantConvert.getClass();
        return new HeartRateRecord.Sample(instantConvert, heartRateSample.getBeatsPerMinute());
    }

    private static final androidx.health.connect.client.records.HeartRateVariabilityRmssdRecord toSdkHeartRateVariabilityRmssdRecord(HeartRateVariabilityRmssdRecord heartRateVariabilityRmssdRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(heartRateVariabilityRmssdRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(heartRateVariabilityRmssdRecord.getZoneOffset());
        double heartRateVariabilityMillis = heartRateVariabilityRmssdRecord.getHeartRateVariabilityMillis();
        android.health.connect.datatypes.Metadata metadata = heartRateVariabilityRmssdRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.HeartRateVariabilityRmssdRecord(instantConvert, zoneOffsetConvert, heartRateVariabilityMillis, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.HeightRecord toSdkHeightRecord(HeightRecord heightRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(heightRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(heightRecord.getZoneOffset());
        Length height = heightRecord.getHeight();
        height.getClass();
        androidx.health.connect.client.units.Length sdkLength = UnitConvertersKt.toSdkLength(height);
        android.health.connect.datatypes.Metadata metadata = heightRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.HeightRecord(instantConvert, zoneOffsetConvert, sdkLength, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.HydrationRecord toSdkHydrationRecord(HydrationRecord hydrationRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(hydrationRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(hydrationRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(hydrationRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(hydrationRecord.getEndZoneOffset());
        Volume volume = hydrationRecord.getVolume();
        volume.getClass();
        androidx.health.connect.client.units.Volume sdkVolume = UnitConvertersKt.toSdkVolume(volume);
        android.health.connect.datatypes.Metadata metadata = hydrationRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.HydrationRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, sdkVolume, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.IntermenstrualBleedingRecord toSdkIntermenstrualBleedingRecord(IntermenstrualBleedingRecord intermenstrualBleedingRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(intermenstrualBleedingRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(intermenstrualBleedingRecord.getZoneOffset());
        android.health.connect.datatypes.Metadata metadata = intermenstrualBleedingRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.IntermenstrualBleedingRecord(instantConvert, zoneOffsetConvert, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.LeanBodyMassRecord toSdkLeanBodyMassRecord(LeanBodyMassRecord leanBodyMassRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(leanBodyMassRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(leanBodyMassRecord.getZoneOffset());
        android.health.connect.datatypes.units.Mass mass = leanBodyMassRecord.getMass();
        mass.getClass();
        Mass sdkMass = UnitConvertersKt.toSdkMass(mass);
        android.health.connect.datatypes.Metadata metadata = leanBodyMassRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.LeanBodyMassRecord(instantConvert, zoneOffsetConvert, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.MenstruationFlowRecord toSdkMenstruationFlowRecord(MenstruationFlowRecord menstruationFlowRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(menstruationFlowRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(menstruationFlowRecord.getZoneOffset());
        int sdkMenstruationFlow = IntDefMappingsKt.toSdkMenstruationFlow(menstruationFlowRecord.getFlow());
        android.health.connect.datatypes.Metadata metadata = menstruationFlowRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.MenstruationFlowRecord(instantConvert, zoneOffsetConvert, MetadataConvertersKt.toSdkMetadata(metadata), sdkMenstruationFlow);
    }

    private static final androidx.health.connect.client.records.MenstruationPeriodRecord toSdkMenstruationPeriodRecord(MenstruationPeriodRecord menstruationPeriodRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(menstruationPeriodRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(menstruationPeriodRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(menstruationPeriodRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(menstruationPeriodRecord.getEndZoneOffset());
        android.health.connect.datatypes.Metadata metadata = menstruationPeriodRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.MenstruationPeriodRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.MindfulnessSessionRecord toSdkMindfulnessSessionRecord(MindfulnessSessionRecord mindfulnessSessionRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(mindfulnessSessionRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(mindfulnessSessionRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(mindfulnessSessionRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(mindfulnessSessionRecord.getEndZoneOffset());
        android.health.connect.datatypes.Metadata metadata = mindfulnessSessionRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.MindfulnessSessionRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, MetadataConvertersKt.toSdkMetadata(metadata), IntDefMappingsKt.toSdkMindfulnessSessionType(mindfulnessSessionRecord.getMindfulnessSessionType()), String.valueOf(mindfulnessSessionRecord.getTitle()), String.valueOf(mindfulnessSessionRecord.getNotes()));
    }

    private static final androidx.health.connect.client.records.NutritionRecord toSdkNutritionRecord(NutritionRecord nutritionRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(nutritionRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(nutritionRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(nutritionRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(nutritionRecord.getEndZoneOffset());
        String mealName = nutritionRecord.getMealName();
        int sdkMealType = IntDefMappingsKt.toSdkMealType(nutritionRecord.getMealType());
        android.health.connect.datatypes.Metadata metadata = nutritionRecord.getMetadata();
        metadata.getClass();
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        android.health.connect.datatypes.units.Mass biotin = nutritionRecord.getBiotin();
        Mass nonDefaultSdkMass = biotin != null ? UnitConvertersKt.toNonDefaultSdkMass(biotin) : null;
        android.health.connect.datatypes.units.Mass caffeine = nutritionRecord.getCaffeine();
        Mass nonDefaultSdkMass2 = caffeine != null ? UnitConvertersKt.toNonDefaultSdkMass(caffeine) : null;
        android.health.connect.datatypes.units.Mass calcium = nutritionRecord.getCalcium();
        Mass nonDefaultSdkMass3 = calcium != null ? UnitConvertersKt.toNonDefaultSdkMass(calcium) : null;
        Energy energy = nutritionRecord.getEnergy();
        androidx.health.connect.client.units.Energy nonDefaultSdkEnergy = energy != null ? UnitConvertersKt.toNonDefaultSdkEnergy(energy) : null;
        Energy energyFromFat = nutritionRecord.getEnergyFromFat();
        androidx.health.connect.client.units.Energy nonDefaultSdkEnergy2 = energyFromFat != null ? UnitConvertersKt.toNonDefaultSdkEnergy(energyFromFat) : null;
        android.health.connect.datatypes.units.Mass chloride = nutritionRecord.getChloride();
        Mass nonDefaultSdkMass4 = chloride != null ? UnitConvertersKt.toNonDefaultSdkMass(chloride) : null;
        android.health.connect.datatypes.units.Mass cholesterol = nutritionRecord.getCholesterol();
        Mass nonDefaultSdkMass5 = cholesterol != null ? UnitConvertersKt.toNonDefaultSdkMass(cholesterol) : null;
        android.health.connect.datatypes.units.Mass chromium = nutritionRecord.getChromium();
        Mass nonDefaultSdkMass6 = chromium != null ? UnitConvertersKt.toNonDefaultSdkMass(chromium) : null;
        android.health.connect.datatypes.units.Mass copper = nutritionRecord.getCopper();
        Mass nonDefaultSdkMass7 = copper != null ? UnitConvertersKt.toNonDefaultSdkMass(copper) : null;
        android.health.connect.datatypes.units.Mass dietaryFiber = nutritionRecord.getDietaryFiber();
        Mass nonDefaultSdkMass8 = dietaryFiber != null ? UnitConvertersKt.toNonDefaultSdkMass(dietaryFiber) : null;
        android.health.connect.datatypes.units.Mass folate = nutritionRecord.getFolate();
        Mass nonDefaultSdkMass9 = folate != null ? UnitConvertersKt.toNonDefaultSdkMass(folate) : null;
        android.health.connect.datatypes.units.Mass folicAcid = nutritionRecord.getFolicAcid();
        Mass nonDefaultSdkMass10 = folicAcid != null ? UnitConvertersKt.toNonDefaultSdkMass(folicAcid) : null;
        android.health.connect.datatypes.units.Mass iodine = nutritionRecord.getIodine();
        Mass nonDefaultSdkMass11 = iodine != null ? UnitConvertersKt.toNonDefaultSdkMass(iodine) : null;
        android.health.connect.datatypes.units.Mass iron = nutritionRecord.getIron();
        Mass nonDefaultSdkMass12 = iron != null ? UnitConvertersKt.toNonDefaultSdkMass(iron) : null;
        android.health.connect.datatypes.units.Mass magnesium = nutritionRecord.getMagnesium();
        Mass nonDefaultSdkMass13 = magnesium != null ? UnitConvertersKt.toNonDefaultSdkMass(magnesium) : null;
        android.health.connect.datatypes.units.Mass manganese = nutritionRecord.getManganese();
        Mass nonDefaultSdkMass14 = manganese != null ? UnitConvertersKt.toNonDefaultSdkMass(manganese) : null;
        android.health.connect.datatypes.units.Mass molybdenum = nutritionRecord.getMolybdenum();
        Mass nonDefaultSdkMass15 = molybdenum != null ? UnitConvertersKt.toNonDefaultSdkMass(molybdenum) : null;
        android.health.connect.datatypes.units.Mass monounsaturatedFat = nutritionRecord.getMonounsaturatedFat();
        Mass nonDefaultSdkMass16 = monounsaturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(monounsaturatedFat) : null;
        android.health.connect.datatypes.units.Mass niacin = nutritionRecord.getNiacin();
        Mass nonDefaultSdkMass17 = niacin != null ? UnitConvertersKt.toNonDefaultSdkMass(niacin) : null;
        android.health.connect.datatypes.units.Mass pantothenicAcid = nutritionRecord.getPantothenicAcid();
        Mass nonDefaultSdkMass18 = pantothenicAcid != null ? UnitConvertersKt.toNonDefaultSdkMass(pantothenicAcid) : null;
        android.health.connect.datatypes.units.Mass phosphorus = nutritionRecord.getPhosphorus();
        Mass nonDefaultSdkMass19 = phosphorus != null ? UnitConvertersKt.toNonDefaultSdkMass(phosphorus) : null;
        android.health.connect.datatypes.units.Mass polyunsaturatedFat = nutritionRecord.getPolyunsaturatedFat();
        Mass nonDefaultSdkMass20 = polyunsaturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(polyunsaturatedFat) : null;
        android.health.connect.datatypes.units.Mass potassium = nutritionRecord.getPotassium();
        Mass nonDefaultSdkMass21 = potassium != null ? UnitConvertersKt.toNonDefaultSdkMass(potassium) : null;
        android.health.connect.datatypes.units.Mass protein = nutritionRecord.getProtein();
        Mass nonDefaultSdkMass22 = protein != null ? UnitConvertersKt.toNonDefaultSdkMass(protein) : null;
        android.health.connect.datatypes.units.Mass riboflavin = nutritionRecord.getRiboflavin();
        Mass nonDefaultSdkMass23 = riboflavin != null ? UnitConvertersKt.toNonDefaultSdkMass(riboflavin) : null;
        android.health.connect.datatypes.units.Mass saturatedFat = nutritionRecord.getSaturatedFat();
        Mass nonDefaultSdkMass24 = saturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(saturatedFat) : null;
        android.health.connect.datatypes.units.Mass selenium = nutritionRecord.getSelenium();
        Mass nonDefaultSdkMass25 = selenium != null ? UnitConvertersKt.toNonDefaultSdkMass(selenium) : null;
        android.health.connect.datatypes.units.Mass sodium = nutritionRecord.getSodium();
        Mass nonDefaultSdkMass26 = sodium != null ? UnitConvertersKt.toNonDefaultSdkMass(sodium) : null;
        android.health.connect.datatypes.units.Mass sugar = nutritionRecord.getSugar();
        Mass nonDefaultSdkMass27 = sugar != null ? UnitConvertersKt.toNonDefaultSdkMass(sugar) : null;
        android.health.connect.datatypes.units.Mass thiamin = nutritionRecord.getThiamin();
        Mass nonDefaultSdkMass28 = thiamin != null ? UnitConvertersKt.toNonDefaultSdkMass(thiamin) : null;
        android.health.connect.datatypes.units.Mass totalCarbohydrate = nutritionRecord.getTotalCarbohydrate();
        Mass nonDefaultSdkMass29 = totalCarbohydrate != null ? UnitConvertersKt.toNonDefaultSdkMass(totalCarbohydrate) : null;
        android.health.connect.datatypes.units.Mass totalFat = nutritionRecord.getTotalFat();
        Mass nonDefaultSdkMass30 = totalFat != null ? UnitConvertersKt.toNonDefaultSdkMass(totalFat) : null;
        android.health.connect.datatypes.units.Mass transFat = nutritionRecord.getTransFat();
        Mass nonDefaultSdkMass31 = transFat != null ? UnitConvertersKt.toNonDefaultSdkMass(transFat) : null;
        android.health.connect.datatypes.units.Mass unsaturatedFat = nutritionRecord.getUnsaturatedFat();
        Mass nonDefaultSdkMass32 = unsaturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(unsaturatedFat) : null;
        android.health.connect.datatypes.units.Mass vitaminA = nutritionRecord.getVitaminA();
        Mass nonDefaultSdkMass33 = vitaminA != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminA) : null;
        android.health.connect.datatypes.units.Mass vitaminB12 = nutritionRecord.getVitaminB12();
        Mass nonDefaultSdkMass34 = vitaminB12 != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminB12) : null;
        android.health.connect.datatypes.units.Mass vitaminB6 = nutritionRecord.getVitaminB6();
        Mass nonDefaultSdkMass35 = vitaminB6 != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminB6) : null;
        android.health.connect.datatypes.units.Mass vitaminC = nutritionRecord.getVitaminC();
        Mass nonDefaultSdkMass36 = vitaminC != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminC) : null;
        android.health.connect.datatypes.units.Mass vitaminD = nutritionRecord.getVitaminD();
        Mass nonDefaultSdkMass37 = vitaminD != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminD) : null;
        android.health.connect.datatypes.units.Mass vitaminE = nutritionRecord.getVitaminE();
        Mass nonDefaultSdkMass38 = vitaminE != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminE) : null;
        android.health.connect.datatypes.units.Mass vitaminK = nutritionRecord.getVitaminK();
        Mass nonDefaultSdkMass39 = vitaminK != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminK) : null;
        android.health.connect.datatypes.units.Mass zinc = nutritionRecord.getZinc();
        return new androidx.health.connect.client.records.NutritionRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, sdkMetadata, nonDefaultSdkMass, nonDefaultSdkMass2, nonDefaultSdkMass3, nonDefaultSdkEnergy, nonDefaultSdkEnergy2, nonDefaultSdkMass4, nonDefaultSdkMass5, nonDefaultSdkMass6, nonDefaultSdkMass7, nonDefaultSdkMass8, nonDefaultSdkMass9, nonDefaultSdkMass10, nonDefaultSdkMass11, nonDefaultSdkMass12, nonDefaultSdkMass13, nonDefaultSdkMass14, nonDefaultSdkMass15, nonDefaultSdkMass16, nonDefaultSdkMass17, nonDefaultSdkMass18, nonDefaultSdkMass19, nonDefaultSdkMass20, nonDefaultSdkMass21, nonDefaultSdkMass22, nonDefaultSdkMass23, nonDefaultSdkMass24, nonDefaultSdkMass25, nonDefaultSdkMass26, nonDefaultSdkMass27, nonDefaultSdkMass28, nonDefaultSdkMass29, nonDefaultSdkMass30, nonDefaultSdkMass31, nonDefaultSdkMass32, nonDefaultSdkMass33, nonDefaultSdkMass34, nonDefaultSdkMass35, nonDefaultSdkMass36, nonDefaultSdkMass37, nonDefaultSdkMass38, nonDefaultSdkMass39, zinc != null ? UnitConvertersKt.toNonDefaultSdkMass(zinc) : null, mealName, sdkMealType);
    }

    private static final androidx.health.connect.client.records.OvulationTestRecord toSdkOvulationTestRecord(OvulationTestRecord ovulationTestRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(ovulationTestRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(ovulationTestRecord.getZoneOffset());
        int sdkOvulationTestResult = IntDefMappingsKt.toSdkOvulationTestResult(ovulationTestRecord.getResult());
        android.health.connect.datatypes.Metadata metadata = ovulationTestRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.OvulationTestRecord(instantConvert, zoneOffsetConvert, sdkOvulationTestResult, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.OxygenSaturationRecord toSdkOxygenSaturationRecord(OxygenSaturationRecord oxygenSaturationRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(oxygenSaturationRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(oxygenSaturationRecord.getZoneOffset());
        Percentage percentage = oxygenSaturationRecord.getPercentage();
        percentage.getClass();
        androidx.health.connect.client.units.Percentage sdkPercentage = UnitConvertersKt.toSdkPercentage(percentage);
        android.health.connect.datatypes.Metadata metadata = oxygenSaturationRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.OxygenSaturationRecord(instantConvert, zoneOffsetConvert, sdkPercentage, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.PlannedExerciseBlock toSdkPlannedExerciseBlock(PlannedExerciseBlock plannedExerciseBlock) {
        int repetitions = plannedExerciseBlock.getRepetitions();
        CharSequence description = plannedExerciseBlock.getDescription();
        String string = description != null ? description.toString() : null;
        List steps = plannedExerciseBlock.getSteps();
        steps.getClass();
        List<android.health.connect.datatypes.PlannedExerciseStep> list = steps;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (android.health.connect.datatypes.PlannedExerciseStep plannedExerciseStep : list) {
            plannedExerciseStep.getClass();
            arrayList.add(toSdkPlannedExerciseStep(plannedExerciseStep));
        }
        return new androidx.health.connect.client.records.PlannedExerciseBlock(repetitions, arrayList, string);
    }

    public static final androidx.health.connect.client.records.PlannedExerciseSessionRecord toSdkPlannedExerciseSessionRecord(PlannedExerciseSessionRecord plannedExerciseSessionRecord) {
        plannedExerciseSessionRecord.getClass();
        j$.time.Instant instantConvert = TimeConversions.convert(plannedExerciseSessionRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(plannedExerciseSessionRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(plannedExerciseSessionRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(plannedExerciseSessionRecord.getEndZoneOffset());
        android.health.connect.datatypes.Metadata metadata = plannedExerciseSessionRecord.getMetadata();
        metadata.getClass();
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        boolean zHasExplicitTime = plannedExerciseSessionRecord.hasExplicitTime();
        int sdkExerciseSessionType = IntDefMappingsKt.toSdkExerciseSessionType(plannedExerciseSessionRecord.getExerciseType());
        String completedExerciseSessionId = plannedExerciseSessionRecord.getCompletedExerciseSessionId();
        List blocks = plannedExerciseSessionRecord.getBlocks();
        blocks.getClass();
        List<PlannedExerciseBlock> list = blocks;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (PlannedExerciseBlock plannedExerciseBlock : list) {
            plannedExerciseBlock.getClass();
            arrayList.add(toSdkPlannedExerciseBlock(plannedExerciseBlock));
        }
        CharSequence title = plannedExerciseSessionRecord.getTitle();
        String string = title != null ? title.toString() : null;
        CharSequence notes = plannedExerciseSessionRecord.getNotes();
        return new androidx.health.connect.client.records.PlannedExerciseSessionRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, sdkMetadata, zHasExplicitTime, sdkExerciseSessionType, completedExerciseSessionId, arrayList, string, notes != null ? notes.toString() : null);
    }

    private static final androidx.health.connect.client.records.PlannedExerciseStep toSdkPlannedExerciseStep(android.health.connect.datatypes.PlannedExerciseStep plannedExerciseStep) {
        CharSequence description = plannedExerciseStep.getDescription();
        String string = description != null ? description.toString() : null;
        int sdkExerciseSegmentType = IntDefMappingsKt.toSdkExerciseSegmentType(plannedExerciseStep.getExerciseType());
        int sdkExerciseCategory = IntDefMappingsKt.toSdkExerciseCategory(plannedExerciseStep.getExerciseCategory());
        android.health.connect.datatypes.ExerciseCompletionGoal completionGoal = plannedExerciseStep.getCompletionGoal();
        completionGoal.getClass();
        androidx.health.connect.client.records.ExerciseCompletionGoal sdkExerciseCompletionGoal = toSdkExerciseCompletionGoal(completionGoal);
        List performanceGoals = plannedExerciseStep.getPerformanceGoals();
        performanceGoals.getClass();
        List list = performanceGoals;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ExercisePerformanceGoal exercisePerformanceGoalM151m = RecordConvertersKt$$ExternalSyntheticApiModelOutline228.m151m(it.next());
            exercisePerformanceGoalM151m.getClass();
            arrayList.add(toSdkExercisePerformanceTarget(exercisePerformanceGoalM151m));
        }
        return new androidx.health.connect.client.records.PlannedExerciseStep(sdkExerciseSegmentType, sdkExerciseCategory, sdkExerciseCompletionGoal, arrayList, string);
    }

    private static final androidx.health.connect.client.records.PowerRecord toSdkPowerRecord(android.health.connect.datatypes.PowerRecord powerRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(powerRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(powerRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(powerRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(powerRecord.getEndZoneOffset());
        List<PowerRecord.PowerRecordSample> samples = powerRecord.getSamples();
        samples.getClass();
        List<PowerRecord.PowerRecordSample> list = samples;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (PowerRecord.PowerRecordSample powerRecordSample : list) {
            powerRecordSample.getClass();
            arrayList.add(toSdkPowerRecordSample(powerRecordSample));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkPowerRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((PowerRecord.Sample) t).getTime(), ((PowerRecord.Sample) t2).getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = powerRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.PowerRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, listSortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final PowerRecord.Sample toSdkPowerRecordSample(PowerRecord.PowerRecordSample powerRecordSample) {
        j$.time.Instant instantConvert = TimeConversions.convert(powerRecordSample.getTime());
        instantConvert.getClass();
        Power power = powerRecordSample.getPower();
        power.getClass();
        return new PowerRecord.Sample(instantConvert, UnitConvertersKt.toSdkPower(power));
    }

    public static final androidx.health.connect.client.records.Record toSdkRecord(Record record) {
        record.getClass();
        androidx.health.connect.client.records.Record sdkRecordExt15 = toSdkRecordExt15(record);
        if (sdkRecordExt15 != null || (sdkRecordExt15 = toSdkRecordExt13(record)) != null) {
            return sdkRecordExt15;
        }
        if (record instanceof ActiveCaloriesBurnedRecord) {
            return toSdkActiveCaloriesBurnedRecord((ActiveCaloriesBurnedRecord) record);
        }
        if (record instanceof BasalBodyTemperatureRecord) {
            return toSdkBasalBodyTemperatureRecord((BasalBodyTemperatureRecord) record);
        }
        if (record instanceof BasalMetabolicRateRecord) {
            return toSdkBasalMetabolicRateRecord((BasalMetabolicRateRecord) record);
        }
        if (record instanceof BloodGlucoseRecord) {
            return toSdkBloodGlucoseRecord((BloodGlucoseRecord) record);
        }
        if (record instanceof BloodPressureRecord) {
            return toSdkBloodPressureRecord((BloodPressureRecord) record);
        }
        if (record instanceof BodyFatRecord) {
            return toSdkBodyFatRecord((BodyFatRecord) record);
        }
        if (record instanceof BodyTemperatureRecord) {
            return toSdkBodyTemperatureRecord((BodyTemperatureRecord) record);
        }
        if (record instanceof BodyWaterMassRecord) {
            return toSdkBodyWaterMassRecord((BodyWaterMassRecord) record);
        }
        if (record instanceof BoneMassRecord) {
            return toSdkBoneMassRecord((BoneMassRecord) record);
        }
        if (record instanceof CervicalMucusRecord) {
            return toSdkCervicalMucusRecord((CervicalMucusRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.CyclingPedalingCadenceRecord) {
            return toSdkCyclingPedalingCadenceRecord((android.health.connect.datatypes.CyclingPedalingCadenceRecord) record);
        }
        if (record instanceof DistanceRecord) {
            return toSdkDistanceRecord((DistanceRecord) record);
        }
        if (record instanceof ElevationGainedRecord) {
            return toSdkElevationGainedRecord((ElevationGainedRecord) record);
        }
        if (record instanceof ExerciseSessionRecord) {
            return toSdkExerciseSessionRecord((ExerciseSessionRecord) record);
        }
        if (record instanceof FloorsClimbedRecord) {
            return toSdkFloorsClimbedRecord((FloorsClimbedRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.HeartRateRecord) {
            return toSdkHeartRateRecord((android.health.connect.datatypes.HeartRateRecord) record);
        }
        if (record instanceof HeartRateVariabilityRmssdRecord) {
            return toSdkHeartRateVariabilityRmssdRecord((HeartRateVariabilityRmssdRecord) record);
        }
        if (record instanceof HeightRecord) {
            return toSdkHeightRecord((HeightRecord) record);
        }
        if (record instanceof HydrationRecord) {
            return toSdkHydrationRecord((HydrationRecord) record);
        }
        if (record instanceof IntermenstrualBleedingRecord) {
            return toSdkIntermenstrualBleedingRecord((IntermenstrualBleedingRecord) record);
        }
        if (record instanceof LeanBodyMassRecord) {
            return toSdkLeanBodyMassRecord((LeanBodyMassRecord) record);
        }
        if (record instanceof MenstruationFlowRecord) {
            return toSdkMenstruationFlowRecord((MenstruationFlowRecord) record);
        }
        if (record instanceof MenstruationPeriodRecord) {
            return toSdkMenstruationPeriodRecord((MenstruationPeriodRecord) record);
        }
        if (record instanceof NutritionRecord) {
            return toSdkNutritionRecord((NutritionRecord) record);
        }
        if (record instanceof OvulationTestRecord) {
            return toSdkOvulationTestRecord((OvulationTestRecord) record);
        }
        if (record instanceof OxygenSaturationRecord) {
            return toSdkOxygenSaturationRecord((OxygenSaturationRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.PowerRecord) {
            return toSdkPowerRecord((android.health.connect.datatypes.PowerRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.RespiratoryRateRecord) {
            return toSdkRespiratoryRateRecord((android.health.connect.datatypes.RespiratoryRateRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.RestingHeartRateRecord) {
            return toSdkRestingHeartRateRecord((android.health.connect.datatypes.RestingHeartRateRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.SexualActivityRecord) {
            return toSdkSexualActivityRecord((android.health.connect.datatypes.SexualActivityRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.SleepSessionRecord) {
            return toSdkSleepSessionRecord((android.health.connect.datatypes.SleepSessionRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.SpeedRecord) {
            return toSdkSpeedRecord((android.health.connect.datatypes.SpeedRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.StepsCadenceRecord) {
            return toSdkStepsCadenceRecord((android.health.connect.datatypes.StepsCadenceRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.StepsRecord) {
            return toSdkStepsRecord((android.health.connect.datatypes.StepsRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.TotalCaloriesBurnedRecord) {
            return toSdkTotalCaloriesBurnedRecord((android.health.connect.datatypes.TotalCaloriesBurnedRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.Vo2MaxRecord) {
            return toSdkVo2MaxRecord((android.health.connect.datatypes.Vo2MaxRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.WeightRecord) {
            return toSdkWeightRecord((android.health.connect.datatypes.WeightRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.WheelchairPushesRecord) {
            return toWheelchairPushesRecord((android.health.connect.datatypes.WheelchairPushesRecord) record);
        }
        Gson$$ExternalSyntheticBUOutline0.m("Unsupported record ", record);
        return null;
    }

    private static final androidx.health.connect.client.records.Record toSdkRecordExt13(Record record) {
        if (!UtilsKt.isAtLeastSdkExtension13()) {
            return null;
        }
        if (record instanceof PlannedExerciseSessionRecord) {
            return toSdkPlannedExerciseSessionRecord((PlannedExerciseSessionRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.SkinTemperatureRecord) {
            return toSdkSkinTemperatureRecord((android.health.connect.datatypes.SkinTemperatureRecord) record);
        }
        return null;
    }

    private static final androidx.health.connect.client.records.Record toSdkRecordExt15(Record record) {
        if (UtilsKt.isAtLeastSdkExtension15() && (record instanceof MindfulnessSessionRecord)) {
            return toSdkMindfulnessSessionRecord((MindfulnessSessionRecord) record);
        }
        return null;
    }

    private static final androidx.health.connect.client.records.RespiratoryRateRecord toSdkRespiratoryRateRecord(android.health.connect.datatypes.RespiratoryRateRecord respiratoryRateRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(respiratoryRateRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(respiratoryRateRecord.getZoneOffset());
        double rate = respiratoryRateRecord.getRate();
        android.health.connect.datatypes.Metadata metadata = respiratoryRateRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.RespiratoryRateRecord(instantConvert, zoneOffsetConvert, rate, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.RestingHeartRateRecord toSdkRestingHeartRateRecord(android.health.connect.datatypes.RestingHeartRateRecord restingHeartRateRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(restingHeartRateRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(restingHeartRateRecord.getZoneOffset());
        long beatsPerMinute = restingHeartRateRecord.getBeatsPerMinute();
        android.health.connect.datatypes.Metadata metadata = restingHeartRateRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.RestingHeartRateRecord(instantConvert, zoneOffsetConvert, beatsPerMinute, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.SexualActivityRecord toSdkSexualActivityRecord(android.health.connect.datatypes.SexualActivityRecord sexualActivityRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(sexualActivityRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(sexualActivityRecord.getZoneOffset());
        int sdkProtectionUsed = IntDefMappingsKt.toSdkProtectionUsed(sexualActivityRecord.getProtectionUsed());
        android.health.connect.datatypes.Metadata metadata = sexualActivityRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.SexualActivityRecord(instantConvert, zoneOffsetConvert, MetadataConvertersKt.toSdkMetadata(metadata), sdkProtectionUsed);
    }

    private static final SkinTemperatureRecord.Delta toSdkSkinTemperatureDelta(SkinTemperatureRecord.Delta delta) {
        j$.time.Instant instantConvert = TimeConversions.convert(delta.getTime());
        instantConvert.getClass();
        TemperatureDelta delta2 = delta.getDelta();
        delta2.getClass();
        return new SkinTemperatureRecord.Delta(instantConvert, UnitConvertersKt.toSdkTemperatureDelta(delta2));
    }

    private static final androidx.health.connect.client.records.SkinTemperatureRecord toSdkSkinTemperatureRecord(android.health.connect.datatypes.SkinTemperatureRecord skinTemperatureRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(skinTemperatureRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(skinTemperatureRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(skinTemperatureRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(skinTemperatureRecord.getEndZoneOffset());
        android.health.connect.datatypes.Metadata metadata = skinTemperatureRecord.getMetadata();
        metadata.getClass();
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        int sdkSkinTemperatureMeasurementLocation = IntDefMappingsKt.toSdkSkinTemperatureMeasurementLocation(skinTemperatureRecord.getMeasurementLocation());
        List deltas = skinTemperatureRecord.getDeltas();
        deltas.getClass();
        List<SkinTemperatureRecord.Delta> list = deltas;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SkinTemperatureRecord.Delta delta : list) {
            delta.getClass();
            arrayList.add(toSdkSkinTemperatureDelta(delta));
        }
        Temperature baseline = skinTemperatureRecord.getBaseline();
        return new androidx.health.connect.client.records.SkinTemperatureRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, sdkMetadata, arrayList, baseline != null ? UnitConvertersKt.toSdkTemperature(baseline) : null, sdkSkinTemperatureMeasurementLocation);
    }

    private static final androidx.health.connect.client.records.SleepSessionRecord toSdkSleepSessionRecord(android.health.connect.datatypes.SleepSessionRecord sleepSessionRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(sleepSessionRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(sleepSessionRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(sleepSessionRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(sleepSessionRecord.getEndZoneOffset());
        android.health.connect.datatypes.Metadata metadata = sleepSessionRecord.getMetadata();
        metadata.getClass();
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        CharSequence title = sleepSessionRecord.getTitle();
        String string = title != null ? title.toString() : null;
        CharSequence notes = sleepSessionRecord.getNotes();
        String string2 = notes != null ? notes.toString() : null;
        List<SleepSessionRecord.Stage> stages = sleepSessionRecord.getStages();
        stages.getClass();
        List<SleepSessionRecord.Stage> list = stages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SleepSessionRecord.Stage stage : list) {
            stage.getClass();
            arrayList.add(toSdkSleepSessionStage(stage));
        }
        return new androidx.health.connect.client.records.SleepSessionRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, sdkMetadata, string, string2, CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkSleepSessionRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((SleepSessionRecord.Stage) t).getStartTime(), ((SleepSessionRecord.Stage) t2).getStartTime());
            }
        }));
    }

    private static final SleepSessionRecord.Stage toSdkSleepSessionStage(SleepSessionRecord.Stage stage) {
        j$.time.Instant instantConvert = TimeConversions.convert(stage.getStartTime());
        instantConvert.getClass();
        j$.time.Instant instantConvert2 = TimeConversions.convert(stage.getEndTime());
        instantConvert2.getClass();
        return new SleepSessionRecord.Stage(instantConvert, instantConvert2, IntDefMappingsKt.toSdkSleepStageType(stage.getType()));
    }

    private static final androidx.health.connect.client.records.SpeedRecord toSdkSpeedRecord(android.health.connect.datatypes.SpeedRecord speedRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(speedRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(speedRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(speedRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(speedRecord.getEndZoneOffset());
        List<SpeedRecord.SpeedRecordSample> samples = speedRecord.getSamples();
        samples.getClass();
        List<SpeedRecord.SpeedRecordSample> list = samples;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SpeedRecord.SpeedRecordSample speedRecordSample : list) {
            speedRecordSample.getClass();
            arrayList.add(toSdkSpeedSample(speedRecordSample));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkSpeedRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((SpeedRecord.Sample) t).getTime(), ((SpeedRecord.Sample) t2).getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = speedRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.SpeedRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, listSortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final SpeedRecord.Sample toSdkSpeedSample(SpeedRecord.SpeedRecordSample speedRecordSample) {
        j$.time.Instant instantConvert = TimeConversions.convert(speedRecordSample.getTime());
        instantConvert.getClass();
        Velocity speed = speedRecordSample.getSpeed();
        speed.getClass();
        return new SpeedRecord.Sample(instantConvert, UnitConvertersKt.toSdkVelocity(speed));
    }

    private static final androidx.health.connect.client.records.StepsCadenceRecord toSdkStepsCadenceRecord(android.health.connect.datatypes.StepsCadenceRecord stepsCadenceRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(stepsCadenceRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(stepsCadenceRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(stepsCadenceRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(stepsCadenceRecord.getEndZoneOffset());
        List<StepsCadenceRecord.StepsCadenceRecordSample> samples = stepsCadenceRecord.getSamples();
        samples.getClass();
        List<StepsCadenceRecord.StepsCadenceRecordSample> list = samples;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (StepsCadenceRecord.StepsCadenceRecordSample stepsCadenceRecordSample : list) {
            stepsCadenceRecordSample.getClass();
            arrayList.add(toSdkStepsCadenceSample(stepsCadenceRecordSample));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkStepsCadenceRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((StepsCadenceRecord.Sample) t).getTime(), ((StepsCadenceRecord.Sample) t2).getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = stepsCadenceRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.StepsCadenceRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, listSortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final StepsCadenceRecord.Sample toSdkStepsCadenceSample(StepsCadenceRecord.StepsCadenceRecordSample stepsCadenceRecordSample) {
        j$.time.Instant instantConvert = TimeConversions.convert(stepsCadenceRecordSample.getTime());
        instantConvert.getClass();
        return new StepsCadenceRecord.Sample(instantConvert, stepsCadenceRecordSample.getRate());
    }

    private static final androidx.health.connect.client.records.StepsRecord toSdkStepsRecord(android.health.connect.datatypes.StepsRecord stepsRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(stepsRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(stepsRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(stepsRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(stepsRecord.getEndZoneOffset());
        long count = stepsRecord.getCount();
        android.health.connect.datatypes.Metadata metadata = stepsRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.StepsRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, count, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.TotalCaloriesBurnedRecord toSdkTotalCaloriesBurnedRecord(android.health.connect.datatypes.TotalCaloriesBurnedRecord totalCaloriesBurnedRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(totalCaloriesBurnedRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(totalCaloriesBurnedRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(totalCaloriesBurnedRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(totalCaloriesBurnedRecord.getEndZoneOffset());
        Energy energy = totalCaloriesBurnedRecord.getEnergy();
        energy.getClass();
        androidx.health.connect.client.units.Energy sdkEnergy = UnitConvertersKt.toSdkEnergy(energy);
        android.health.connect.datatypes.Metadata metadata = totalCaloriesBurnedRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.TotalCaloriesBurnedRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, sdkEnergy, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.Vo2MaxRecord toSdkVo2MaxRecord(android.health.connect.datatypes.Vo2MaxRecord vo2MaxRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(vo2MaxRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(vo2MaxRecord.getZoneOffset());
        double vo2MillilitersPerMinuteKilogram = vo2MaxRecord.getVo2MillilitersPerMinuteKilogram();
        int sdkVo2MaxMeasurementMethod = IntDefMappingsKt.toSdkVo2MaxMeasurementMethod(vo2MaxRecord.getMeasurementMethod());
        android.health.connect.datatypes.Metadata metadata = vo2MaxRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.Vo2MaxRecord(instantConvert, zoneOffsetConvert, MetadataConvertersKt.toSdkMetadata(metadata), vo2MillilitersPerMinuteKilogram, sdkVo2MaxMeasurementMethod);
    }

    private static final androidx.health.connect.client.records.WeightRecord toSdkWeightRecord(android.health.connect.datatypes.WeightRecord weightRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(weightRecord.getTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(weightRecord.getZoneOffset());
        android.health.connect.datatypes.units.Mass weight = weightRecord.getWeight();
        weight.getClass();
        Mass sdkMass = UnitConvertersKt.toSdkMass(weight);
        android.health.connect.datatypes.Metadata metadata = weightRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.WeightRecord(instantConvert, zoneOffsetConvert, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final androidx.health.connect.client.records.WheelchairPushesRecord toWheelchairPushesRecord(android.health.connect.datatypes.WheelchairPushesRecord wheelchairPushesRecord) {
        j$.time.Instant instantConvert = TimeConversions.convert(wheelchairPushesRecord.getStartTime());
        instantConvert.getClass();
        ZoneOffset zoneOffsetConvert = TimeConversions.convert(wheelchairPushesRecord.getStartZoneOffset());
        j$.time.Instant instantConvert2 = TimeConversions.convert(wheelchairPushesRecord.getEndTime());
        instantConvert2.getClass();
        ZoneOffset zoneOffsetConvert2 = TimeConversions.convert(wheelchairPushesRecord.getEndZoneOffset());
        long count = wheelchairPushesRecord.getCount();
        android.health.connect.datatypes.Metadata metadata = wheelchairPushesRecord.getMetadata();
        metadata.getClass();
        return new androidx.health.connect.client.records.WheelchairPushesRecord(instantConvert, zoneOffsetConvert, instantConvert2, zoneOffsetConvert2, count, MetadataConvertersKt.toSdkMetadata(metadata));
    }
}
