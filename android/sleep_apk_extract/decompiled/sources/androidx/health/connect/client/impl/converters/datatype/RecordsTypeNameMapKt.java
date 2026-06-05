package androidx.health.connect.client.impl.converters.datatype;

import androidx.health.connect.client.records.ActiveCaloriesBurnedRecord;
import androidx.health.connect.client.records.BasalBodyTemperatureRecord;
import androidx.health.connect.client.records.BasalMetabolicRateRecord;
import androidx.health.connect.client.records.BloodGlucoseRecord;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.BodyFatRecord;
import androidx.health.connect.client.records.BodyTemperatureRecord;
import androidx.health.connect.client.records.BodyWaterMassRecord;
import androidx.health.connect.client.records.BoneMassRecord;
import androidx.health.connect.client.records.CervicalMucusRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.DistanceRecord;
import androidx.health.connect.client.records.ElevationGainedRecord;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import androidx.health.connect.client.records.FloorsClimbedRecord;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.HeartRateVariabilityRmssdRecord;
import androidx.health.connect.client.records.HeightRecord;
import androidx.health.connect.client.records.HydrationRecord;
import androidx.health.connect.client.records.IntermenstrualBleedingRecord;
import androidx.health.connect.client.records.LeanBodyMassRecord;
import androidx.health.connect.client.records.MenstruationFlowRecord;
import androidx.health.connect.client.records.MenstruationPeriodRecord;
import androidx.health.connect.client.records.MindfulnessSessionRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.OvulationTestRecord;
import androidx.health.connect.client.records.OxygenSaturationRecord;
import androidx.health.connect.client.records.PowerRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.RespiratoryRateRecord;
import androidx.health.connect.client.records.RestingHeartRateRecord;
import androidx.health.connect.client.records.SexualActivityRecord;
import androidx.health.connect.client.records.SkinTemperatureRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.records.StepsRecord;
import androidx.health.connect.client.records.TotalCaloriesBurnedRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.records.WeightRecord;
import androidx.health.connect.client.records.WheelchairPushesRecord;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"1\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u00008\u0006¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"+\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"", "", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "RECORDS_TYPE_NAME_MAP", "Ljava/util/Map;", "getRECORDS_TYPE_NAME_MAP", "()Ljava/util/Map;", "getRECORDS_TYPE_NAME_MAP$annotations", "()V", "RECORDS_CLASS_NAME_MAP", "getRECORDS_CLASS_NAME_MAP", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class RecordsTypeNameMapKt {
    private static final Map<KClass<? extends Record>, String> RECORDS_CLASS_NAME_MAP;
    private static final Map<String, KClass<? extends Record>> RECORDS_TYPE_NAME_MAP;

    static {
        Map<String, KClass<? extends Record>> mapMapOf = MapsKt.mapOf(TuplesKt.to("ActiveCaloriesBurned", Reflection.getOrCreateKotlinClass(ActiveCaloriesBurnedRecord.class)), TuplesKt.to("ActivitySession", Reflection.getOrCreateKotlinClass(ExerciseSessionRecord.class)), TuplesKt.to("BasalBodyTemperature", Reflection.getOrCreateKotlinClass(BasalBodyTemperatureRecord.class)), TuplesKt.to("BasalMetabolicRate", Reflection.getOrCreateKotlinClass(BasalMetabolicRateRecord.class)), TuplesKt.to("BloodGlucose", Reflection.getOrCreateKotlinClass(BloodGlucoseRecord.class)), TuplesKt.to("BloodPressure", Reflection.getOrCreateKotlinClass(BloodPressureRecord.class)), TuplesKt.to("BodyFat", Reflection.getOrCreateKotlinClass(BodyFatRecord.class)), TuplesKt.to("BodyTemperature", Reflection.getOrCreateKotlinClass(BodyTemperatureRecord.class)), TuplesKt.to("BodyWaterMass", Reflection.getOrCreateKotlinClass(BodyWaterMassRecord.class)), TuplesKt.to("BoneMass", Reflection.getOrCreateKotlinClass(BoneMassRecord.class)), TuplesKt.to("CervicalMucus", Reflection.getOrCreateKotlinClass(CervicalMucusRecord.class)), TuplesKt.to("CyclingPedalingCadenceSeries", Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class)), TuplesKt.to("Distance", Reflection.getOrCreateKotlinClass(DistanceRecord.class)), TuplesKt.to("ElevationGained", Reflection.getOrCreateKotlinClass(ElevationGainedRecord.class)), TuplesKt.to("FloorsClimbed", Reflection.getOrCreateKotlinClass(FloorsClimbedRecord.class)), TuplesKt.to("HeartRateSeries", Reflection.getOrCreateKotlinClass(HeartRateRecord.class)), TuplesKt.to("HeartRateVariabilityRmssd", Reflection.getOrCreateKotlinClass(HeartRateVariabilityRmssdRecord.class)), TuplesKt.to("Height", Reflection.getOrCreateKotlinClass(HeightRecord.class)), TuplesKt.to("Hydration", Reflection.getOrCreateKotlinClass(HydrationRecord.class)), TuplesKt.to("LeanBodyMass", Reflection.getOrCreateKotlinClass(LeanBodyMassRecord.class)), TuplesKt.to("Menstruation", Reflection.getOrCreateKotlinClass(MenstruationFlowRecord.class)), TuplesKt.to("MenstruationPeriod", Reflection.getOrCreateKotlinClass(MenstruationPeriodRecord.class)), TuplesKt.to("MindfulnessSession", Reflection.getOrCreateKotlinClass(MindfulnessSessionRecord.class)), TuplesKt.to("Nutrition", Reflection.getOrCreateKotlinClass(NutritionRecord.class)), TuplesKt.to("OvulationTest", Reflection.getOrCreateKotlinClass(OvulationTestRecord.class)), TuplesKt.to("OxygenSaturation", Reflection.getOrCreateKotlinClass(OxygenSaturationRecord.class)), TuplesKt.to("PowerSeries", Reflection.getOrCreateKotlinClass(PowerRecord.class)), TuplesKt.to("RespiratoryRate", Reflection.getOrCreateKotlinClass(RespiratoryRateRecord.class)), TuplesKt.to("RestingHeartRate", Reflection.getOrCreateKotlinClass(RestingHeartRateRecord.class)), TuplesKt.to("SexualActivity", Reflection.getOrCreateKotlinClass(SexualActivityRecord.class)), TuplesKt.to("SkinTemperature", Reflection.getOrCreateKotlinClass(SkinTemperatureRecord.class)), TuplesKt.to("SleepSession", Reflection.getOrCreateKotlinClass(SleepSessionRecord.class)), TuplesKt.to("SpeedSeries", Reflection.getOrCreateKotlinClass(SpeedRecord.class)), TuplesKt.to("IntermenstrualBleeding", Reflection.getOrCreateKotlinClass(IntermenstrualBleedingRecord.class)), TuplesKt.to("Steps", Reflection.getOrCreateKotlinClass(StepsRecord.class)), TuplesKt.to("StepsCadenceSeries", Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class)), TuplesKt.to("TotalCaloriesBurned", Reflection.getOrCreateKotlinClass(TotalCaloriesBurnedRecord.class)), TuplesKt.to("Vo2Max", Reflection.getOrCreateKotlinClass(Vo2MaxRecord.class)), TuplesKt.to("WheelchairPushes", Reflection.getOrCreateKotlinClass(WheelchairPushesRecord.class)), TuplesKt.to("Weight", Reflection.getOrCreateKotlinClass(WeightRecord.class)));
        RECORDS_TYPE_NAME_MAP = mapMapOf;
        Set<Map.Entry<String, KClass<? extends Record>>> setEntrySet = mapMapOf.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pair = TuplesKt.to(entry.getValue(), entry.getKey());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        RECORDS_CLASS_NAME_MAP = linkedHashMap;
    }

    public static final Map<KClass<? extends Record>, String> getRECORDS_CLASS_NAME_MAP() {
        return RECORDS_CLASS_NAME_MAP;
    }
}
