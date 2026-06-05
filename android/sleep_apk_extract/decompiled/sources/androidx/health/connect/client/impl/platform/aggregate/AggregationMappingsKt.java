package androidx.health.connect.client.impl.platform.aggregate;

import android.health.connect.datatypes.AggregationType;
import android.os.ext.SdkExtensions;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.ActiveCaloriesBurnedRecord;
import androidx.health.connect.client.records.BasalMetabolicRateRecord;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.DistanceRecord;
import androidx.health.connect.client.records.ElevationGainedRecord;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import androidx.health.connect.client.records.FloorsClimbedRecord;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.HeightRecord;
import androidx.health.connect.client.records.HydrationRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.PowerRecord;
import androidx.health.connect.client.records.RestingHeartRateRecord;
import androidx.health.connect.client.records.SkinTemperatureRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.records.StepsRecord;
import androidx.health.connect.client.records.TotalCaloriesBurnedRecord;
import androidx.health.connect.client.records.WeightRecord;
import androidx.health.connect.client.records.WheelchairPushesRecord;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.Length;
import androidx.health.connect.client.units.Mass;
import androidx.health.connect.client.units.Power;
import androidx.health.connect.client.units.Pressure;
import androidx.health.connect.client.units.TemperatureDelta;
import androidx.health.connect.client.units.Velocity;
import androidx.health.connect.client.units.Volume;
import j$.time.Duration;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"?\u0010\u0007\u001a-\u0012)\u0012'\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0017\u0012\u0015\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00030\u00030\u0004¢\u0006\u0002\b\u00060\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"2\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"2\u0010\u0010\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"2\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"2\u0010\u0018\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00040\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"2\u0010\u001a\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"2\u0010\u001e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00040\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"/\u0010 \u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00040\t8\u0006¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"2\u0010$\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00040\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"6\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060'j\u0002`(0\u00040\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"0\u0010,\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\t8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\r\"6\u00101\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060/j\u0002`00\u00040\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b2\u0010\r\"2\u00105\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00040\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r¨\u00067"}, d2 = {"", "Lkotlin/Pair;", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "", "Landroid/health/connect/datatypes/AggregationType;", "kotlin.jvm.PlatformType", "Lkotlin/jvm/internal/EnhancedNullability;", "DOUBLE_AGGREGATION_METRIC_TYPE_SDK_EXT_10_PAIRS", "[Lkotlin/Pair;", "", "DOUBLE_AGGREGATION_METRIC_TYPE_MAP", "Ljava/util/Map;", "getDOUBLE_AGGREGATION_METRIC_TYPE_MAP", "()Ljava/util/Map;", "j$/time/Duration", "", "DURATION_AGGREGATION_METRIC_TYPE_MAP", "getDURATION_AGGREGATION_METRIC_TYPE_MAP", "Landroidx/health/connect/client/units/Energy;", "Landroid/health/connect/datatypes/units/Energy;", "ENERGY_AGGREGATION_METRIC_TYPE_MAP", "getENERGY_AGGREGATION_METRIC_TYPE_MAP", "Landroidx/health/connect/client/units/Length;", "Landroid/health/connect/datatypes/units/Length;", "LENGTH_AGGREGATION_METRIC_TYPE_MAP", "getLENGTH_AGGREGATION_METRIC_TYPE_MAP", "LONG_AGGREGATION_METRIC_TYPE_MAP", "getLONG_AGGREGATION_METRIC_TYPE_MAP", "Landroidx/health/connect/client/units/Mass;", "Landroid/health/connect/datatypes/units/Mass;", "GRAMS_AGGREGATION_METRIC_TYPE_MAP", "getGRAMS_AGGREGATION_METRIC_TYPE_MAP", "KILOGRAMS_AGGREGATION_METRIC_TYPE_MAP", "getKILOGRAMS_AGGREGATION_METRIC_TYPE_MAP", "Landroidx/health/connect/client/units/Power;", "Landroid/health/connect/datatypes/units/Power;", "POWER_AGGREGATION_METRIC_TYPE_MAP", "getPOWER_AGGREGATION_METRIC_TYPE_MAP", "Landroidx/health/connect/client/units/Pressure;", "Landroid/health/connect/datatypes/units/Pressure;", "Landroidx/health/connect/client/impl/platform/records/PlatformPressure;", "PRESSURE_AGGREGATION_METRIC_TYPE_MAP", "getPRESSURE_AGGREGATION_METRIC_TYPE_MAP", "Landroidx/health/connect/client/units/TemperatureDelta;", "TEMPERATURE_DELTA_METRIC_TYPE_MAP", "getTEMPERATURE_DELTA_METRIC_TYPE_MAP", "Landroidx/health/connect/client/units/Velocity;", "Landroid/health/connect/datatypes/units/Velocity;", "Landroidx/health/connect/client/impl/platform/records/PlatformVelocity;", "VELOCITY_AGGREGATION_METRIC_TYPE_MAP", "getVELOCITY_AGGREGATION_METRIC_TYPE_MAP", "Landroidx/health/connect/client/units/Volume;", "Landroid/health/connect/datatypes/units/Volume;", "VOLUME_AGGREGATION_METRIC_TYPE_MAP", "getVOLUME_AGGREGATION_METRIC_TYPE_MAP", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class AggregationMappingsKt {
    private static final Map<AggregateMetric<Double>, AggregationType<Double>> DOUBLE_AGGREGATION_METRIC_TYPE_MAP;
    private static final Pair<AggregateMetric<Double>, AggregationType<Double>>[] DOUBLE_AGGREGATION_METRIC_TYPE_SDK_EXT_10_PAIRS;
    private static final Map<AggregateMetric<Duration>, AggregationType<Long>> DURATION_AGGREGATION_METRIC_TYPE_MAP;
    private static final Map<AggregateMetric<Energy>, AggregationType<android.health.connect.datatypes.units.Energy>> ENERGY_AGGREGATION_METRIC_TYPE_MAP;
    private static final Map<AggregateMetric<Mass>, AggregationType<android.health.connect.datatypes.units.Mass>> GRAMS_AGGREGATION_METRIC_TYPE_MAP;
    private static final Map<AggregateMetric<Mass>, AggregationType<android.health.connect.datatypes.units.Mass>> KILOGRAMS_AGGREGATION_METRIC_TYPE_MAP;
    private static final Map<AggregateMetric<Length>, AggregationType<android.health.connect.datatypes.units.Length>> LENGTH_AGGREGATION_METRIC_TYPE_MAP;
    private static final Map<AggregateMetric<Long>, AggregationType<Long>> LONG_AGGREGATION_METRIC_TYPE_MAP;
    private static final Map<AggregateMetric<Power>, AggregationType<android.health.connect.datatypes.units.Power>> POWER_AGGREGATION_METRIC_TYPE_MAP;
    private static final Map<AggregateMetric<Pressure>, AggregationType<android.health.connect.datatypes.units.Pressure>> PRESSURE_AGGREGATION_METRIC_TYPE_MAP;
    private static final Map<AggregateMetric<TemperatureDelta>, AggregationType<?>> TEMPERATURE_DELTA_METRIC_TYPE_MAP;
    private static final Map<AggregateMetric<Velocity>, AggregationType<android.health.connect.datatypes.units.Velocity>> VELOCITY_AGGREGATION_METRIC_TYPE_MAP;
    private static final Map<AggregateMetric<Volume>, AggregationType<android.health.connect.datatypes.units.Volume>> VOLUME_AGGREGATION_METRIC_TYPE_MAP;

    static {
        Pair<AggregateMetric<Double>, AggregationType<Double>>[] pairArr = SdkExtensions.getExtensionVersion(34) >= 10 ? new Pair[]{TuplesKt.to(CyclingPedalingCadenceRecord.RPM_AVG, android.health.connect.datatypes.CyclingPedalingCadenceRecord.RPM_AVG), TuplesKt.to(CyclingPedalingCadenceRecord.RPM_MAX, android.health.connect.datatypes.CyclingPedalingCadenceRecord.RPM_MAX), TuplesKt.to(CyclingPedalingCadenceRecord.RPM_MIN, android.health.connect.datatypes.CyclingPedalingCadenceRecord.RPM_MIN), TuplesKt.to(StepsCadenceRecord.RATE_AVG, android.health.connect.datatypes.StepsCadenceRecord.STEPS_CADENCE_RATE_AVG), TuplesKt.to(StepsCadenceRecord.RATE_MAX, android.health.connect.datatypes.StepsCadenceRecord.STEPS_CADENCE_RATE_MAX), TuplesKt.to(StepsCadenceRecord.RATE_MIN, android.health.connect.datatypes.StepsCadenceRecord.STEPS_CADENCE_RATE_MIN)} : new Pair[0];
        DOUBLE_AGGREGATION_METRIC_TYPE_SDK_EXT_10_PAIRS = pairArr;
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(TuplesKt.to(FloorsClimbedRecord.FLOORS_CLIMBED_TOTAL, android.health.connect.datatypes.FloorsClimbedRecord.FLOORS_CLIMBED_TOTAL));
        spreadBuilder.addSpread(pairArr);
        DOUBLE_AGGREGATION_METRIC_TYPE_MAP = MapsKt.mapOf((Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
        DURATION_AGGREGATION_METRIC_TYPE_MAP = MapsKt.mapOf(TuplesKt.to(ExerciseSessionRecord.EXERCISE_DURATION_TOTAL, android.health.connect.datatypes.ExerciseSessionRecord.EXERCISE_DURATION_TOTAL), TuplesKt.to(SleepSessionRecord.SLEEP_DURATION_TOTAL, android.health.connect.datatypes.SleepSessionRecord.SLEEP_DURATION_TOTAL));
        ENERGY_AGGREGATION_METRIC_TYPE_MAP = MapsKt.mapOf(TuplesKt.to(ActiveCaloriesBurnedRecord.ACTIVE_CALORIES_TOTAL, android.health.connect.datatypes.ActiveCaloriesBurnedRecord.ACTIVE_CALORIES_TOTAL), TuplesKt.to(BasalMetabolicRateRecord.BASAL_CALORIES_TOTAL, android.health.connect.datatypes.BasalMetabolicRateRecord.BASAL_CALORIES_TOTAL), TuplesKt.to(NutritionRecord.ENERGY_TOTAL, android.health.connect.datatypes.NutritionRecord.ENERGY_TOTAL), TuplesKt.to(NutritionRecord.ENERGY_FROM_FAT_TOTAL, android.health.connect.datatypes.NutritionRecord.ENERGY_FROM_FAT_TOTAL), TuplesKt.to(TotalCaloriesBurnedRecord.ENERGY_TOTAL, android.health.connect.datatypes.TotalCaloriesBurnedRecord.ENERGY_TOTAL));
        LENGTH_AGGREGATION_METRIC_TYPE_MAP = MapsKt.mapOf(TuplesKt.to(DistanceRecord.DISTANCE_TOTAL, android.health.connect.datatypes.DistanceRecord.DISTANCE_TOTAL), TuplesKt.to(ElevationGainedRecord.ELEVATION_GAINED_TOTAL, android.health.connect.datatypes.ElevationGainedRecord.ELEVATION_GAINED_TOTAL), TuplesKt.to(HeightRecord.HEIGHT_AVG, android.health.connect.datatypes.HeightRecord.HEIGHT_AVG), TuplesKt.to(HeightRecord.HEIGHT_MIN, android.health.connect.datatypes.HeightRecord.HEIGHT_MIN), TuplesKt.to(HeightRecord.HEIGHT_MAX, android.health.connect.datatypes.HeightRecord.HEIGHT_MAX));
        LONG_AGGREGATION_METRIC_TYPE_MAP = MapsKt.mapOf(TuplesKt.to(HeartRateRecord.BPM_AVG, android.health.connect.datatypes.HeartRateRecord.BPM_AVG), TuplesKt.to(HeartRateRecord.BPM_MIN, android.health.connect.datatypes.HeartRateRecord.BPM_MIN), TuplesKt.to(HeartRateRecord.BPM_MAX, android.health.connect.datatypes.HeartRateRecord.BPM_MAX), TuplesKt.to(HeartRateRecord.MEASUREMENTS_COUNT, android.health.connect.datatypes.HeartRateRecord.HEART_MEASUREMENTS_COUNT), TuplesKt.to(RestingHeartRateRecord.BPM_AVG, android.health.connect.datatypes.RestingHeartRateRecord.BPM_AVG), TuplesKt.to(RestingHeartRateRecord.BPM_MIN, android.health.connect.datatypes.RestingHeartRateRecord.BPM_MIN), TuplesKt.to(RestingHeartRateRecord.BPM_MAX, android.health.connect.datatypes.RestingHeartRateRecord.BPM_MAX), TuplesKt.to(StepsRecord.COUNT_TOTAL, android.health.connect.datatypes.StepsRecord.STEPS_COUNT_TOTAL), TuplesKt.to(WheelchairPushesRecord.COUNT_TOTAL, android.health.connect.datatypes.WheelchairPushesRecord.WHEEL_CHAIR_PUSHES_COUNT_TOTAL));
        SpreadBuilder spreadBuilder2 = new SpreadBuilder(40);
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.BIOTIN_TOTAL, android.health.connect.datatypes.NutritionRecord.BIOTIN_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.CAFFEINE_TOTAL, android.health.connect.datatypes.NutritionRecord.CAFFEINE_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.CALCIUM_TOTAL, android.health.connect.datatypes.NutritionRecord.CALCIUM_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.CHLORIDE_TOTAL, android.health.connect.datatypes.NutritionRecord.CHLORIDE_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.CHOLESTEROL_TOTAL, android.health.connect.datatypes.NutritionRecord.CHOLESTEROL_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.CHROMIUM_TOTAL, android.health.connect.datatypes.NutritionRecord.CHROMIUM_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.COPPER_TOTAL, android.health.connect.datatypes.NutritionRecord.COPPER_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.DIETARY_FIBER_TOTAL, android.health.connect.datatypes.NutritionRecord.DIETARY_FIBER_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.FOLATE_TOTAL, android.health.connect.datatypes.NutritionRecord.FOLATE_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.FOLIC_ACID_TOTAL, android.health.connect.datatypes.NutritionRecord.FOLIC_ACID_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.IODINE_TOTAL, android.health.connect.datatypes.NutritionRecord.IODINE_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.IRON_TOTAL, android.health.connect.datatypes.NutritionRecord.IRON_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.MAGNESIUM_TOTAL, android.health.connect.datatypes.NutritionRecord.MAGNESIUM_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.MANGANESE_TOTAL, android.health.connect.datatypes.NutritionRecord.MANGANESE_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.MOLYBDENUM_TOTAL, android.health.connect.datatypes.NutritionRecord.MOLYBDENUM_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.MONOUNSATURATED_FAT_TOTAL, android.health.connect.datatypes.NutritionRecord.MONOUNSATURATED_FAT_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.NIACIN_TOTAL, android.health.connect.datatypes.NutritionRecord.NIACIN_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.PANTOTHENIC_ACID_TOTAL, android.health.connect.datatypes.NutritionRecord.PANTOTHENIC_ACID_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.PHOSPHORUS_TOTAL, android.health.connect.datatypes.NutritionRecord.PHOSPHORUS_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.POLYUNSATURATED_FAT_TOTAL, android.health.connect.datatypes.NutritionRecord.POLYUNSATURATED_FAT_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.POTASSIUM_TOTAL, android.health.connect.datatypes.NutritionRecord.POTASSIUM_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.PROTEIN_TOTAL, android.health.connect.datatypes.NutritionRecord.PROTEIN_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.RIBOFLAVIN_TOTAL, android.health.connect.datatypes.NutritionRecord.RIBOFLAVIN_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.SATURATED_FAT_TOTAL, android.health.connect.datatypes.NutritionRecord.SATURATED_FAT_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.SELENIUM_TOTAL, android.health.connect.datatypes.NutritionRecord.SELENIUM_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.SODIUM_TOTAL, android.health.connect.datatypes.NutritionRecord.SODIUM_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.SUGAR_TOTAL, android.health.connect.datatypes.NutritionRecord.SUGAR_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.THIAMIN_TOTAL, android.health.connect.datatypes.NutritionRecord.THIAMIN_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.TOTAL_CARBOHYDRATE_TOTAL, android.health.connect.datatypes.NutritionRecord.TOTAL_CARBOHYDRATE_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.TOTAL_FAT_TOTAL, android.health.connect.datatypes.NutritionRecord.TOTAL_FAT_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.UNSATURATED_FAT_TOTAL, android.health.connect.datatypes.NutritionRecord.UNSATURATED_FAT_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.VITAMIN_A_TOTAL, android.health.connect.datatypes.NutritionRecord.VITAMIN_A_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.VITAMIN_B12_TOTAL, android.health.connect.datatypes.NutritionRecord.VITAMIN_B12_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.VITAMIN_B6_TOTAL, android.health.connect.datatypes.NutritionRecord.VITAMIN_B6_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.VITAMIN_C_TOTAL, android.health.connect.datatypes.NutritionRecord.VITAMIN_C_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.VITAMIN_D_TOTAL, android.health.connect.datatypes.NutritionRecord.VITAMIN_D_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.VITAMIN_E_TOTAL, android.health.connect.datatypes.NutritionRecord.VITAMIN_E_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.VITAMIN_K_TOTAL, android.health.connect.datatypes.NutritionRecord.VITAMIN_K_TOTAL));
        spreadBuilder2.add(TuplesKt.to(NutritionRecord.ZINC_TOTAL, android.health.connect.datatypes.NutritionRecord.ZINC_TOTAL));
        spreadBuilder2.addSpread(SdkExtensions.getExtensionVersion(34) >= 10 ? new Pair[]{TuplesKt.to(NutritionRecord.TRANS_FAT_TOTAL, android.health.connect.datatypes.NutritionRecord.TRANS_FAT_TOTAL)} : new Pair[0]);
        GRAMS_AGGREGATION_METRIC_TYPE_MAP = MapsKt.mapOf((Pair[]) spreadBuilder2.toArray(new Pair[spreadBuilder2.size()]));
        KILOGRAMS_AGGREGATION_METRIC_TYPE_MAP = MapsKt.mapOf(TuplesKt.to(WeightRecord.WEIGHT_AVG, android.health.connect.datatypes.WeightRecord.WEIGHT_AVG), TuplesKt.to(WeightRecord.WEIGHT_MIN, android.health.connect.datatypes.WeightRecord.WEIGHT_MIN), TuplesKt.to(WeightRecord.WEIGHT_MAX, android.health.connect.datatypes.WeightRecord.WEIGHT_MAX));
        POWER_AGGREGATION_METRIC_TYPE_MAP = MapsKt.mapOf(TuplesKt.to(PowerRecord.POWER_AVG, android.health.connect.datatypes.PowerRecord.POWER_AVG), TuplesKt.to(PowerRecord.POWER_MAX, android.health.connect.datatypes.PowerRecord.POWER_MAX), TuplesKt.to(PowerRecord.POWER_MIN, android.health.connect.datatypes.PowerRecord.POWER_MIN));
        PRESSURE_AGGREGATION_METRIC_TYPE_MAP = MapsKt.toMap(SdkExtensions.getExtensionVersion(34) >= 10 ? new Pair[]{TuplesKt.to(BloodPressureRecord.DIASTOLIC_AVG, android.health.connect.datatypes.BloodPressureRecord.DIASTOLIC_AVG), TuplesKt.to(BloodPressureRecord.DIASTOLIC_MAX, android.health.connect.datatypes.BloodPressureRecord.DIASTOLIC_MAX), TuplesKt.to(BloodPressureRecord.DIASTOLIC_MIN, android.health.connect.datatypes.BloodPressureRecord.DIASTOLIC_MIN), TuplesKt.to(BloodPressureRecord.SYSTOLIC_AVG, android.health.connect.datatypes.BloodPressureRecord.SYSTOLIC_AVG), TuplesKt.to(BloodPressureRecord.SYSTOLIC_MAX, android.health.connect.datatypes.BloodPressureRecord.SYSTOLIC_MAX), TuplesKt.to(BloodPressureRecord.SYSTOLIC_MIN, android.health.connect.datatypes.BloodPressureRecord.SYSTOLIC_MIN)} : new Pair[0]);
        TEMPERATURE_DELTA_METRIC_TYPE_MAP = MapsKt.toMap(SdkExtensions.getExtensionVersion(34) >= 13 ? new Pair[]{TuplesKt.to(SkinTemperatureRecord.TEMPERATURE_DELTA_AVG, android.health.connect.datatypes.SkinTemperatureRecord.SKIN_TEMPERATURE_DELTA_AVG), TuplesKt.to(SkinTemperatureRecord.TEMPERATURE_DELTA_MAX, android.health.connect.datatypes.SkinTemperatureRecord.SKIN_TEMPERATURE_DELTA_MAX), TuplesKt.to(SkinTemperatureRecord.TEMPERATURE_DELTA_MIN, android.health.connect.datatypes.SkinTemperatureRecord.SKIN_TEMPERATURE_DELTA_MIN)} : new Pair[0]);
        VELOCITY_AGGREGATION_METRIC_TYPE_MAP = MapsKt.toMap(SdkExtensions.getExtensionVersion(34) >= 10 ? new Pair[]{TuplesKt.to(SpeedRecord.SPEED_AVG, android.health.connect.datatypes.SpeedRecord.SPEED_AVG), TuplesKt.to(SpeedRecord.SPEED_MAX, android.health.connect.datatypes.SpeedRecord.SPEED_MAX), TuplesKt.to(SpeedRecord.SPEED_MIN, android.health.connect.datatypes.SpeedRecord.SPEED_MIN)} : new Pair[0]);
        VOLUME_AGGREGATION_METRIC_TYPE_MAP = MapsKt.mapOf(TuplesKt.to(HydrationRecord.VOLUME_TOTAL, android.health.connect.datatypes.HydrationRecord.VOLUME_TOTAL));
    }

    public static final Map<AggregateMetric<Double>, AggregationType<Double>> getDOUBLE_AGGREGATION_METRIC_TYPE_MAP() {
        return DOUBLE_AGGREGATION_METRIC_TYPE_MAP;
    }

    public static final Map<AggregateMetric<Duration>, AggregationType<Long>> getDURATION_AGGREGATION_METRIC_TYPE_MAP() {
        return DURATION_AGGREGATION_METRIC_TYPE_MAP;
    }

    public static final Map<AggregateMetric<Energy>, AggregationType<android.health.connect.datatypes.units.Energy>> getENERGY_AGGREGATION_METRIC_TYPE_MAP() {
        return ENERGY_AGGREGATION_METRIC_TYPE_MAP;
    }

    public static final Map<AggregateMetric<Mass>, AggregationType<android.health.connect.datatypes.units.Mass>> getGRAMS_AGGREGATION_METRIC_TYPE_MAP() {
        return GRAMS_AGGREGATION_METRIC_TYPE_MAP;
    }

    public static final Map<AggregateMetric<Mass>, AggregationType<android.health.connect.datatypes.units.Mass>> getKILOGRAMS_AGGREGATION_METRIC_TYPE_MAP() {
        return KILOGRAMS_AGGREGATION_METRIC_TYPE_MAP;
    }

    public static final Map<AggregateMetric<Length>, AggregationType<android.health.connect.datatypes.units.Length>> getLENGTH_AGGREGATION_METRIC_TYPE_MAP() {
        return LENGTH_AGGREGATION_METRIC_TYPE_MAP;
    }

    public static final Map<AggregateMetric<Long>, AggregationType<Long>> getLONG_AGGREGATION_METRIC_TYPE_MAP() {
        return LONG_AGGREGATION_METRIC_TYPE_MAP;
    }

    public static final Map<AggregateMetric<Power>, AggregationType<android.health.connect.datatypes.units.Power>> getPOWER_AGGREGATION_METRIC_TYPE_MAP() {
        return POWER_AGGREGATION_METRIC_TYPE_MAP;
    }

    public static final Map<AggregateMetric<Pressure>, AggregationType<android.health.connect.datatypes.units.Pressure>> getPRESSURE_AGGREGATION_METRIC_TYPE_MAP() {
        return PRESSURE_AGGREGATION_METRIC_TYPE_MAP;
    }

    public static final Map<AggregateMetric<TemperatureDelta>, AggregationType<?>> getTEMPERATURE_DELTA_METRIC_TYPE_MAP() {
        return TEMPERATURE_DELTA_METRIC_TYPE_MAP;
    }

    public static final Map<AggregateMetric<Velocity>, AggregationType<android.health.connect.datatypes.units.Velocity>> getVELOCITY_AGGREGATION_METRIC_TYPE_MAP() {
        return VELOCITY_AGGREGATION_METRIC_TYPE_MAP;
    }

    public static final Map<AggregateMetric<Volume>, AggregationType<android.health.connect.datatypes.units.Volume>> getVOLUME_AGGREGATION_METRIC_TYPE_MAP() {
        return VOLUME_AGGREGATION_METRIC_TYPE_MAP;
    }
}
