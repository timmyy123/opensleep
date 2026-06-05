package androidx.health.connect.client.impl.converters.records;

import androidx.health.connect.client.records.ActiveCaloriesBurnedRecord;
import androidx.health.connect.client.records.BasalBodyTemperatureRecord;
import androidx.health.connect.client.records.BasalMetabolicRateRecord;
import androidx.health.connect.client.records.BloodGlucoseRecord;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.BodyFatRecord;
import androidx.health.connect.client.records.BodyTemperatureMeasurementLocation;
import androidx.health.connect.client.records.BodyTemperatureRecord;
import androidx.health.connect.client.records.BodyWaterMassRecord;
import androidx.health.connect.client.records.BoneMassRecord;
import androidx.health.connect.client.records.CervicalMucusRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.DistanceRecord;
import androidx.health.connect.client.records.ElevationGainedRecord;
import androidx.health.connect.client.records.ExerciseLap;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseRouteResult;
import androidx.health.connect.client.records.ExerciseSegment;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import androidx.health.connect.client.records.FloorsClimbedRecord;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.HeartRateVariabilityRmssdRecord;
import androidx.health.connect.client.records.HeightRecord;
import androidx.health.connect.client.records.HydrationRecord;
import androidx.health.connect.client.records.IntermenstrualBleedingRecord;
import androidx.health.connect.client.records.LeanBodyMassRecord;
import androidx.health.connect.client.records.MealType;
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
import androidx.health.connect.client.units.BloodGlucose;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.EnergyKt;
import androidx.health.connect.client.units.LengthKt;
import androidx.health.connect.client.units.Mass;
import androidx.health.connect.client.units.MassKt;
import androidx.health.connect.client.units.PercentageKt;
import androidx.health.connect.client.units.PowerKt;
import androidx.health.connect.client.units.PressureKt;
import androidx.health.connect.client.units.Temperature;
import androidx.health.connect.client.units.TemperatureKt;
import androidx.health.connect.client.units.VelocityKt;
import androidx.health.connect.client.units.VolumeKt;
import androidx.health.platform.client.proto.DataProto;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/health/platform/client/proto/DataProto$DataPoint;", "proto", "Landroidx/health/connect/client/records/Record;", "toRecord", "(Landroidx/health/platform/client/proto/DataProto$DataPoint;)Landroidx/health/connect/client/records/Record;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ProtoToRecordConvertersKt {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Record toRecord(DataProto.DataPoint dataPoint) {
        List<SkinTemperatureRecord.Delta> listEmptyList;
        List<ExerciseSegment> listEmptyList2;
        List<ExerciseLap> listEmptyList3;
        ExerciseRouteResult noData;
        List<SleepSessionRecord.Stage> listEmptyList4;
        dataPoint.getClass();
        String name = dataPoint.getDataType().getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -2137162425:
                    if (name.equals("Height")) {
                        return new HeightRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), LengthKt.getMeters(ProtoToRecordUtilsKt.getDouble$default(dataPoint, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case -1931142571:
                    if (name.equals("BasalMetabolicRate")) {
                        return new BasalMetabolicRateRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), PowerKt.getKilocaloriesPerDay(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "bmr", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case -1878699588:
                    if (name.equals("MenstruationPeriod")) {
                        return new MenstruationPeriodRecord(ProtoToRecordUtilsKt.getStartTime(dataPoint), ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint), ProtoToRecordUtilsKt.getEndTime(dataPoint), ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case -1739492291:
                    if (name.equals("HeartRateSeries")) {
                        Instant startTime = ProtoToRecordUtilsKt.getStartTime(dataPoint);
                        ZoneOffset startZoneOffset = ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint);
                        Instant endTime = ProtoToRecordUtilsKt.getEndTime(dataPoint);
                        ZoneOffset endZoneOffset = ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint);
                        List<DataProto.SeriesValue> seriesValuesList = dataPoint.getSeriesValuesList();
                        seriesValuesList.getClass();
                        List<DataProto.SeriesValue> list = seriesValuesList;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        for (DataProto.SeriesValue seriesValue : list) {
                            Instant instantOfEpochMilli = Instant.ofEpochMilli(seriesValue.getInstantTimeMillis());
                            instantOfEpochMilli.getClass();
                            arrayList.add(new HeartRateRecord.Sample(instantOfEpochMilli, ProtoToRecordUtilsKt.getLong$default(seriesValue, "bpm", 0L, 2, (Object) null)));
                        }
                        return new HeartRateRecord(startTime, startZoneOffset, endTime, endZoneOffset, arrayList, ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case -1728782805:
                    if (name.equals("Vo2Max")) {
                        return new Vo2MaxRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint), ProtoToRecordUtilsKt.getDouble$default(dataPoint, "vo2", 0.0d, 2, (Object) null), ProtoToRecordUtilsKt.mapEnum(dataPoint, "measurementMethod", Vo2MaxRecord.MEASUREMENT_METHOD_STRING_TO_INT_MAP, 0));
                    }
                    break;
                case -1707725160:
                    if (name.equals("Weight")) {
                        return new WeightRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), MassKt.getKilograms(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "weight", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case -1547814841:
                    if (name.equals("HeartRateVariabilityRmssd")) {
                        double double$default = 1.0d;
                        if (ProtoToRecordUtilsKt.getDouble$default(dataPoint, "heartRateVariability", 0.0d, 2, (Object) null) >= 1.0d) {
                            double$default = 200.0d;
                            if (ProtoToRecordUtilsKt.getDouble$default(dataPoint, "heartRateVariability", 0.0d, 2, (Object) null) <= 200.0d) {
                                double$default = ProtoToRecordUtilsKt.getDouble$default(dataPoint, "heartRateVariability", 0.0d, 2, (Object) null);
                            }
                        }
                        return new HeartRateVariabilityRmssdRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), double$default, ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case -1249467044:
                    if (name.equals("LeanBodyMass")) {
                        return new LeanBodyMassRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), MassKt.getKilograms(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "mass", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case -1170329975:
                    if (name.equals("SexualActivity")) {
                        return new SexualActivityRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint), ProtoToRecordUtilsKt.mapEnum(dataPoint, "protectionUsed", SexualActivityRecord.PROTECTION_USED_STRING_TO_INT_MAP, 0));
                    }
                    break;
                case -1089246824:
                    if (name.equals("TotalCaloriesBurned")) {
                        return new TotalCaloriesBurnedRecord(ProtoToRecordUtilsKt.getStartTime(dataPoint), ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint), ProtoToRecordUtilsKt.getEndTime(dataPoint), ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint), EnergyKt.getKilocalories(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "energy", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case -633416129:
                    if (name.equals("BloodPressure")) {
                        return new BloodPressureRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint), PressureKt.getMillimetersOfMercury(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "systolic", 0.0d, 2, (Object) null)), PressureKt.getMillimetersOfMercury(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "diastolic", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.mapEnum(dataPoint, "bodyPosition", BloodPressureRecord.BODY_POSITION_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.mapEnum(dataPoint, "measurementLocation", BloodPressureRecord.MEASUREMENT_LOCATION_STRING_TO_INT_MAP, 0));
                    }
                    break;
                case -562822786:
                    if (name.equals("SpeedSeries")) {
                        Instant startTime2 = ProtoToRecordUtilsKt.getStartTime(dataPoint);
                        ZoneOffset startZoneOffset2 = ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint);
                        Instant endTime2 = ProtoToRecordUtilsKt.getEndTime(dataPoint);
                        ZoneOffset endZoneOffset2 = ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint);
                        List<DataProto.SeriesValue> seriesValuesList2 = dataPoint.getSeriesValuesList();
                        seriesValuesList2.getClass();
                        List<DataProto.SeriesValue> list2 = seriesValuesList2;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        for (DataProto.SeriesValue seriesValue2 : list2) {
                            Instant instantOfEpochMilli2 = Instant.ofEpochMilli(seriesValue2.getInstantTimeMillis());
                            instantOfEpochMilli2.getClass();
                            arrayList2.add(new SpeedRecord.Sample(instantOfEpochMilli2, VelocityKt.getMetersPerSecond(ProtoToRecordUtilsKt.getDouble$default(seriesValue2, "speed", 0.0d, 2, (Object) null))));
                        }
                        return new SpeedRecord(startTime2, startZoneOffset2, endTime2, endZoneOffset2, arrayList2, ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case -561665783:
                    if (name.equals("BodyWaterMass")) {
                        return new BodyWaterMassRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), MassKt.getKilograms(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "mass", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case -539421262:
                    if (name.equals("OxygenSaturation")) {
                        return new OxygenSaturationRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), PercentageKt.getPercent(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "percentage", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case -187790444:
                    if (name.equals("MindfulnessSession")) {
                        return new MindfulnessSessionRecord(ProtoToRecordUtilsKt.getStartTime(dataPoint), ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint), ProtoToRecordUtilsKt.getEndTime(dataPoint), ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint), ProtoToRecordUtilsKt.mapEnum(dataPoint, "sessionType", MindfulnessSessionRecord.MINDFULNESS_SESSION_TYPE_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getString(dataPoint, "title"), ProtoToRecordUtilsKt.getString(dataPoint, "notes"));
                    }
                    break;
                case -136898551:
                    if (name.equals("OvulationTest")) {
                        return new OvulationTestRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.mapEnum(dataPoint, "result", OvulationTestRecord.RESULT_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 8847540:
                    if (name.equals("BloodGlucose")) {
                        return new BloodGlucoseRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint), BloodGlucose.INSTANCE.millimolesPerLiter(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "level", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.mapEnum(dataPoint, "specimenSource", BloodGlucoseRecord.SPECIMEN_SOURCE_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.mapEnum(dataPoint, "mealType", MealType.MEAL_TYPE_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.mapEnum(dataPoint, "relationToMeal", BloodGlucoseRecord.RELATION_TO_MEAL_STRING_TO_INT_MAP, 0));
                    }
                    break;
                case 80208647:
                    if (name.equals("Steps")) {
                        return new StepsRecord(ProtoToRecordUtilsKt.getStartTime(dataPoint), ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint), ProtoToRecordUtilsKt.getEndTime(dataPoint), ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint), ProtoToRecordUtilsKt.getLong$default(dataPoint, "count", 0L, 2, (Object) null), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 128630298:
                    if (name.equals("ActiveCaloriesBurned")) {
                        return new ActiveCaloriesBurnedRecord(ProtoToRecordUtilsKt.getStartTime(dataPoint), ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint), ProtoToRecordUtilsKt.getEndTime(dataPoint), ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint), EnergyKt.getKilocalories(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "energy", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 187665747:
                    if (name.equals("BasalBodyTemperature")) {
                        return new BasalBodyTemperatureRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint), TemperatureKt.getCelsius(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "temperature", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.mapEnum(dataPoint, "measurementLocation", BodyTemperatureMeasurementLocation.MEASUREMENT_LOCATION_STRING_TO_INT_MAP, 0));
                    }
                    break;
                case 246984731:
                    if (name.equals("Menstruation")) {
                        return new MenstruationFlowRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint), ProtoToRecordUtilsKt.mapEnum(dataPoint, "flow", MenstruationFlowRecord.FLOW_TYPE_STRING_TO_INT_MAP, 0));
                    }
                    break;
                case 353103893:
                    if (name.equals("Distance")) {
                        return new DistanceRecord(ProtoToRecordUtilsKt.getStartTime(dataPoint), ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint), ProtoToRecordUtilsKt.getEndTime(dataPoint), ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint), LengthKt.getMeters(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "distance", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 557067342:
                    if (name.equals("CervicalMucus")) {
                        return new CervicalMucusRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint), ProtoToRecordUtilsKt.mapEnum(dataPoint, "texture", CervicalMucusRecord.APPEARANCE_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.mapEnum(dataPoint, "amount", CervicalMucusRecord.SENSATION_STRING_TO_INT_MAP, 0));
                    }
                    break;
                case 578805655:
                    if (name.equals("SkinTemperature")) {
                        DataProto.Value value = dataPoint.getValuesMap().get("baseline");
                        Temperature celsius = value != null ? TemperatureKt.getCelsius(value.getDoubleVal()) : null;
                        int iMapEnum = ProtoToRecordUtilsKt.mapEnum(dataPoint, "measurementLocation", SkinTemperatureRecord.MEASUREMENT_LOCATION_STRING_TO_INT_MAP, 0);
                        Instant startTime3 = ProtoToRecordUtilsKt.getStartTime(dataPoint);
                        ZoneOffset startZoneOffset3 = ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint);
                        Instant endTime3 = ProtoToRecordUtilsKt.getEndTime(dataPoint);
                        ZoneOffset endZoneOffset3 = ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint);
                        DataProto.DataPoint.SubTypeDataList subTypeDataList = dataPoint.getSubTypeDataListsMap().get("deltas");
                        if (subTypeDataList == null || (listEmptyList = ProtoToRecordUtilsKt.toDeltasList(subTypeDataList)) == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        return new SkinTemperatureRecord(startTime3, startZoneOffset3, endTime3, endZoneOffset3, ProtoToRecordUtilsKt.getMetadata(dataPoint), listEmptyList, celsius, iMapEnum);
                    }
                    break;
                case 761063032:
                    if (name.equals("RestingHeartRate")) {
                        return new RestingHeartRateRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.getLong$default(dataPoint, "bpm", 0L, 2, (Object) null), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 955204109:
                    if (name.equals("FloorsClimbed")) {
                        return new FloorsClimbedRecord(ProtoToRecordUtilsKt.getStartTime(dataPoint), ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint), ProtoToRecordUtilsKt.getEndTime(dataPoint), ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint), ProtoToRecordUtilsKt.getDouble$default(dataPoint, "floors", 0.0d, 2, (Object) null), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 989918314:
                    if (name.equals("RespiratoryRate")) {
                        return new RespiratoryRateRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.getDouble$default(dataPoint, "rate", 0.0d, 2, (Object) null), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 1051870422:
                    if (name.equals("Hydration")) {
                        return new HydrationRecord(ProtoToRecordUtilsKt.getStartTime(dataPoint), ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint), ProtoToRecordUtilsKt.getEndTime(dataPoint), ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint), VolumeKt.getLiters(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "volume", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 1108584865:
                    if (name.equals("StepsCadenceSeries")) {
                        Instant startTime4 = ProtoToRecordUtilsKt.getStartTime(dataPoint);
                        ZoneOffset startZoneOffset4 = ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint);
                        Instant endTime4 = ProtoToRecordUtilsKt.getEndTime(dataPoint);
                        ZoneOffset endZoneOffset4 = ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint);
                        List<DataProto.SeriesValue> seriesValuesList3 = dataPoint.getSeriesValuesList();
                        seriesValuesList3.getClass();
                        List<DataProto.SeriesValue> list3 = seriesValuesList3;
                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                        for (DataProto.SeriesValue seriesValue3 : list3) {
                            Instant instantOfEpochMilli3 = Instant.ofEpochMilli(seriesValue3.getInstantTimeMillis());
                            instantOfEpochMilli3.getClass();
                            arrayList3.add(new StepsCadenceRecord.Sample(instantOfEpochMilli3, ProtoToRecordUtilsKt.getDouble$default(seriesValue3, "rate", 0.0d, 2, (Object) null)));
                        }
                        return new StepsCadenceRecord(startTime4, startZoneOffset4, endTime4, endZoneOffset4, arrayList3, ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 1193457969:
                    if (name.equals("IntermenstrualBleeding")) {
                        return new IntermenstrualBleedingRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 1468615931:
                    if (name.equals("ElevationGained")) {
                        return new ElevationGainedRecord(ProtoToRecordUtilsKt.getStartTime(dataPoint), ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint), ProtoToRecordUtilsKt.getEndTime(dataPoint), ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint), LengthKt.getMeters(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "elevation", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 1478142546:
                    if (name.equals("WheelchairPushes")) {
                        return new WheelchairPushesRecord(ProtoToRecordUtilsKt.getStartTime(dataPoint), ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint), ProtoToRecordUtilsKt.getEndTime(dataPoint), ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint), ProtoToRecordUtilsKt.getLong$default(dataPoint, "count", 0L, 2, (Object) null), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 1498531293:
                    if (name.equals("CyclingPedalingCadenceSeries")) {
                        Instant startTime5 = ProtoToRecordUtilsKt.getStartTime(dataPoint);
                        ZoneOffset startZoneOffset5 = ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint);
                        Instant endTime5 = ProtoToRecordUtilsKt.getEndTime(dataPoint);
                        ZoneOffset endZoneOffset5 = ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint);
                        List<DataProto.SeriesValue> seriesValuesList4 = dataPoint.getSeriesValuesList();
                        seriesValuesList4.getClass();
                        List<DataProto.SeriesValue> list4 = seriesValuesList4;
                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                        for (DataProto.SeriesValue seriesValue4 : list4) {
                            Instant instantOfEpochMilli4 = Instant.ofEpochMilli(seriesValue4.getInstantTimeMillis());
                            instantOfEpochMilli4.getClass();
                            arrayList4.add(new CyclingPedalingCadenceRecord.Sample(instantOfEpochMilli4, ProtoToRecordUtilsKt.getDouble$default(seriesValue4, "rpm", 0.0d, 2, (Object) null)));
                        }
                        return new CyclingPedalingCadenceRecord(startTime5, startZoneOffset5, endTime5, endZoneOffset5, arrayList4, ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 1513758823:
                    if (name.equals("ActivitySession")) {
                        int iMapEnum2 = ProtoToRecordUtilsKt.mapEnum(dataPoint, "activityType", ExerciseSessionRecord.EXERCISE_TYPE_STRING_TO_INT_MAP, 0);
                        String string = ProtoToRecordUtilsKt.getString(dataPoint, "title");
                        String string2 = ProtoToRecordUtilsKt.getString(dataPoint, "notes");
                        Instant startTime6 = ProtoToRecordUtilsKt.getStartTime(dataPoint);
                        ZoneOffset startZoneOffset6 = ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint);
                        Instant endTime6 = ProtoToRecordUtilsKt.getEndTime(dataPoint);
                        ZoneOffset endZoneOffset6 = ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint);
                        androidx.health.connect.client.records.metadata.Metadata metadata = ProtoToRecordUtilsKt.getMetadata(dataPoint);
                        DataProto.DataPoint.SubTypeDataList subTypeDataList2 = dataPoint.getSubTypeDataListsMap().get("segments");
                        if (subTypeDataList2 == null || (listEmptyList2 = ProtoToRecordUtilsKt.toSegmentList(subTypeDataList2)) == null) {
                            listEmptyList2 = CollectionsKt.emptyList();
                        }
                        List<ExerciseSegment> list5 = listEmptyList2;
                        DataProto.DataPoint.SubTypeDataList subTypeDataList3 = dataPoint.getSubTypeDataListsMap().get("laps");
                        if (subTypeDataList3 == null || (listEmptyList3 = ProtoToRecordUtilsKt.toLapList(subTypeDataList3)) == null) {
                            listEmptyList3 = CollectionsKt.emptyList();
                        }
                        List<ExerciseLap> list6 = listEmptyList3;
                        DataProto.DataPoint.SubTypeDataList subTypeDataList4 = dataPoint.getSubTypeDataListsMap().get("route");
                        if (subTypeDataList4 != null) {
                            noData = new ExerciseRouteResult.Data(new ExerciseRoute(ProtoToRecordUtilsKt.toLocationList(subTypeDataList4)));
                        } else {
                            DataProto.Value value2 = dataPoint.getValuesMap().get("hasRoute");
                            noData = (value2 == null || !value2.getBooleanVal()) ? new ExerciseRouteResult.NoData() : new ExerciseRouteResult.ConsentRequired();
                        }
                        return new ExerciseSessionRecord(startTime6, startZoneOffset6, endTime6, endZoneOffset6, metadata, iMapEnum2, string, string2, list5, list6, noData, null, 2048, null);
                    }
                    break;
                case 1584919122:
                    if (name.equals("BodyTemperature")) {
                        return new BodyTemperatureRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint), TemperatureKt.getCelsius(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "temperature", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.mapEnum(dataPoint, "measurementLocation", BodyTemperatureMeasurementLocation.MEASUREMENT_LOCATION_STRING_TO_INT_MAP, 0));
                    }
                    break;
                case 1719563767:
                    if (name.equals("BodyFat")) {
                        return new BodyFatRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), PercentageKt.getPercent(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "percentage", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 1738316664:
                    if (name.equals("Nutrition")) {
                        DataProto.Value value3 = dataPoint.getValuesMap().get("biotin");
                        Mass grams = value3 != null ? MassKt.getGrams(value3.getDoubleVal()) : null;
                        DataProto.Value value4 = dataPoint.getValuesMap().get("caffeine");
                        Mass grams2 = value4 != null ? MassKt.getGrams(value4.getDoubleVal()) : null;
                        DataProto.Value value5 = dataPoint.getValuesMap().get("calcium");
                        Mass grams3 = value5 != null ? MassKt.getGrams(value5.getDoubleVal()) : null;
                        DataProto.Value value6 = dataPoint.getValuesMap().get("calories");
                        Energy kilocalories = value6 != null ? EnergyKt.getKilocalories(value6.getDoubleVal()) : null;
                        DataProto.Value value7 = dataPoint.getValuesMap().get("caloriesFromFat");
                        Energy kilocalories2 = value7 != null ? EnergyKt.getKilocalories(value7.getDoubleVal()) : null;
                        DataProto.Value value8 = dataPoint.getValuesMap().get("chloride");
                        Mass grams4 = value8 != null ? MassKt.getGrams(value8.getDoubleVal()) : null;
                        DataProto.Value value9 = dataPoint.getValuesMap().get("cholesterol");
                        Mass grams5 = value9 != null ? MassKt.getGrams(value9.getDoubleVal()) : null;
                        DataProto.Value value10 = dataPoint.getValuesMap().get("chromium");
                        Mass grams6 = value10 != null ? MassKt.getGrams(value10.getDoubleVal()) : null;
                        DataProto.Value value11 = dataPoint.getValuesMap().get("copper");
                        Mass grams7 = value11 != null ? MassKt.getGrams(value11.getDoubleVal()) : null;
                        DataProto.Value value12 = dataPoint.getValuesMap().get("dietaryFiber");
                        Mass grams8 = value12 != null ? MassKt.getGrams(value12.getDoubleVal()) : null;
                        DataProto.Value value13 = dataPoint.getValuesMap().get("folate");
                        Mass grams9 = value13 != null ? MassKt.getGrams(value13.getDoubleVal()) : null;
                        DataProto.Value value14 = dataPoint.getValuesMap().get("folicAcid");
                        Mass grams10 = value14 != null ? MassKt.getGrams(value14.getDoubleVal()) : null;
                        DataProto.Value value15 = dataPoint.getValuesMap().get("iodine");
                        Mass grams11 = value15 != null ? MassKt.getGrams(value15.getDoubleVal()) : null;
                        DataProto.Value value16 = dataPoint.getValuesMap().get("iron");
                        Mass grams12 = value16 != null ? MassKt.getGrams(value16.getDoubleVal()) : null;
                        DataProto.Value value17 = dataPoint.getValuesMap().get("magnesium");
                        Mass grams13 = value17 != null ? MassKt.getGrams(value17.getDoubleVal()) : null;
                        DataProto.Value value18 = dataPoint.getValuesMap().get("manganese");
                        Mass grams14 = value18 != null ? MassKt.getGrams(value18.getDoubleVal()) : null;
                        DataProto.Value value19 = dataPoint.getValuesMap().get("molybdenum");
                        Mass grams15 = value19 != null ? MassKt.getGrams(value19.getDoubleVal()) : null;
                        DataProto.Value value20 = dataPoint.getValuesMap().get("monounsaturatedFat");
                        Mass grams16 = value20 != null ? MassKt.getGrams(value20.getDoubleVal()) : null;
                        DataProto.Value value21 = dataPoint.getValuesMap().get("niacin");
                        Mass grams17 = value21 != null ? MassKt.getGrams(value21.getDoubleVal()) : null;
                        DataProto.Value value22 = dataPoint.getValuesMap().get("pantothenicAcid");
                        Mass grams18 = value22 != null ? MassKt.getGrams(value22.getDoubleVal()) : null;
                        DataProto.Value value23 = dataPoint.getValuesMap().get("phosphorus");
                        Mass grams19 = value23 != null ? MassKt.getGrams(value23.getDoubleVal()) : null;
                        DataProto.Value value24 = dataPoint.getValuesMap().get("polyunsaturatedFat");
                        Mass grams20 = value24 != null ? MassKt.getGrams(value24.getDoubleVal()) : null;
                        DataProto.Value value25 = dataPoint.getValuesMap().get("potassium");
                        Mass grams21 = value25 != null ? MassKt.getGrams(value25.getDoubleVal()) : null;
                        DataProto.Value value26 = dataPoint.getValuesMap().get("protein");
                        Mass grams22 = value26 != null ? MassKt.getGrams(value26.getDoubleVal()) : null;
                        DataProto.Value value27 = dataPoint.getValuesMap().get("riboflavin");
                        Mass grams23 = value27 != null ? MassKt.getGrams(value27.getDoubleVal()) : null;
                        DataProto.Value value28 = dataPoint.getValuesMap().get("saturatedFat");
                        Mass grams24 = value28 != null ? MassKt.getGrams(value28.getDoubleVal()) : null;
                        DataProto.Value value29 = dataPoint.getValuesMap().get("selenium");
                        Mass grams25 = value29 != null ? MassKt.getGrams(value29.getDoubleVal()) : null;
                        DataProto.Value value30 = dataPoint.getValuesMap().get("sodium");
                        Mass grams26 = value30 != null ? MassKt.getGrams(value30.getDoubleVal()) : null;
                        DataProto.Value value31 = dataPoint.getValuesMap().get("sugar");
                        Mass grams27 = value31 != null ? MassKt.getGrams(value31.getDoubleVal()) : null;
                        DataProto.Value value32 = dataPoint.getValuesMap().get("thiamin");
                        Mass grams28 = value32 != null ? MassKt.getGrams(value32.getDoubleVal()) : null;
                        DataProto.Value value33 = dataPoint.getValuesMap().get("totalCarbohydrate");
                        Mass grams29 = value33 != null ? MassKt.getGrams(value33.getDoubleVal()) : null;
                        DataProto.Value value34 = dataPoint.getValuesMap().get("totalFat");
                        Mass grams30 = value34 != null ? MassKt.getGrams(value34.getDoubleVal()) : null;
                        DataProto.Value value35 = dataPoint.getValuesMap().get("transFat");
                        Mass grams31 = value35 != null ? MassKt.getGrams(value35.getDoubleVal()) : null;
                        DataProto.Value value36 = dataPoint.getValuesMap().get("unsaturatedFat");
                        Mass grams32 = value36 != null ? MassKt.getGrams(value36.getDoubleVal()) : null;
                        DataProto.Value value37 = dataPoint.getValuesMap().get("vitaminA");
                        Mass grams33 = value37 != null ? MassKt.getGrams(value37.getDoubleVal()) : null;
                        DataProto.Value value38 = dataPoint.getValuesMap().get("vitaminB12");
                        Mass grams34 = value38 != null ? MassKt.getGrams(value38.getDoubleVal()) : null;
                        DataProto.Value value39 = dataPoint.getValuesMap().get("vitaminB6");
                        Mass grams35 = value39 != null ? MassKt.getGrams(value39.getDoubleVal()) : null;
                        DataProto.Value value40 = dataPoint.getValuesMap().get("vitaminC");
                        Mass grams36 = value40 != null ? MassKt.getGrams(value40.getDoubleVal()) : null;
                        DataProto.Value value41 = dataPoint.getValuesMap().get("vitaminD");
                        Mass grams37 = value41 != null ? MassKt.getGrams(value41.getDoubleVal()) : null;
                        DataProto.Value value42 = dataPoint.getValuesMap().get("vitaminE");
                        Mass grams38 = value42 != null ? MassKt.getGrams(value42.getDoubleVal()) : null;
                        DataProto.Value value43 = dataPoint.getValuesMap().get("vitaminK");
                        Mass grams39 = value43 != null ? MassKt.getGrams(value43.getDoubleVal()) : null;
                        DataProto.Value value44 = dataPoint.getValuesMap().get("zinc");
                        return new NutritionRecord(ProtoToRecordUtilsKt.getStartTime(dataPoint), ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint), ProtoToRecordUtilsKt.getEndTime(dataPoint), ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint), ProtoToRecordUtilsKt.getMetadata(dataPoint), grams, grams2, grams3, kilocalories, kilocalories2, grams4, grams5, grams6, grams7, grams8, grams9, grams10, grams11, grams12, grams13, grams14, grams15, grams16, grams17, grams18, grams19, grams20, grams21, grams22, grams23, grams24, grams25, grams26, grams27, grams28, grams29, grams30, grams31, grams32, grams33, grams34, grams35, grams36, grams37, grams38, grams39, value44 != null ? MassKt.getGrams(value44.getDoubleVal()) : null, ProtoToRecordUtilsKt.getString(dataPoint, "name"), ProtoToRecordUtilsKt.mapEnum(dataPoint, "mealType", MealType.MEAL_TYPE_STRING_TO_INT_MAP, 0));
                    }
                    break;
                case 2034898936:
                    if (name.equals("BoneMass")) {
                        return new BoneMassRecord(ProtoToRecordUtilsKt.getTime(dataPoint), ProtoToRecordUtilsKt.getZoneOffset(dataPoint), MassKt.getKilograms(ProtoToRecordUtilsKt.getDouble$default(dataPoint, "mass", 0.0d, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
                case 2065313759:
                    if (name.equals("SleepSession")) {
                        String string3 = ProtoToRecordUtilsKt.getString(dataPoint, "title");
                        String string4 = ProtoToRecordUtilsKt.getString(dataPoint, "notes");
                        Instant startTime7 = ProtoToRecordUtilsKt.getStartTime(dataPoint);
                        ZoneOffset startZoneOffset7 = ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint);
                        Instant endTime7 = ProtoToRecordUtilsKt.getEndTime(dataPoint);
                        ZoneOffset endZoneOffset7 = ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint);
                        DataProto.DataPoint.SubTypeDataList subTypeDataList5 = dataPoint.getSubTypeDataListsMap().get("stages");
                        if (subTypeDataList5 == null || (listEmptyList4 = ProtoToRecordUtilsKt.toStageList(subTypeDataList5)) == null) {
                            listEmptyList4 = CollectionsKt.emptyList();
                        }
                        return new SleepSessionRecord(startTime7, startZoneOffset7, endTime7, endZoneOffset7, ProtoToRecordUtilsKt.getMetadata(dataPoint), string3, string4, listEmptyList4);
                    }
                    break;
                case 2095285180:
                    if (name.equals("PowerSeries")) {
                        Instant startTime8 = ProtoToRecordUtilsKt.getStartTime(dataPoint);
                        ZoneOffset startZoneOffset8 = ProtoToRecordUtilsKt.getStartZoneOffset(dataPoint);
                        Instant endTime8 = ProtoToRecordUtilsKt.getEndTime(dataPoint);
                        ZoneOffset endZoneOffset8 = ProtoToRecordUtilsKt.getEndZoneOffset(dataPoint);
                        List<DataProto.SeriesValue> seriesValuesList5 = dataPoint.getSeriesValuesList();
                        seriesValuesList5.getClass();
                        List<DataProto.SeriesValue> list7 = seriesValuesList5;
                        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                        for (DataProto.SeriesValue seriesValue5 : list7) {
                            Instant instantOfEpochMilli5 = Instant.ofEpochMilli(seriesValue5.getInstantTimeMillis());
                            instantOfEpochMilli5.getClass();
                            arrayList5.add(new PowerRecord.Sample(instantOfEpochMilli5, PowerKt.getWatts(ProtoToRecordUtilsKt.getDouble$default(seriesValue5, "power", 0.0d, 2, (Object) null))));
                        }
                        return new PowerRecord(startTime8, startZoneOffset8, endTime8, endZoneOffset8, arrayList5, ProtoToRecordUtilsKt.getMetadata(dataPoint));
                    }
                    break;
            }
        }
        throw new RuntimeException("Unknown data type " + dataPoint.getDataType().getName());
    }
}
