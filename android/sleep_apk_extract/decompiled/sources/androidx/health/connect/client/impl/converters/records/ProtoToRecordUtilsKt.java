package androidx.health.connect.client.impl.converters.records;

import androidx.health.connect.client.records.ExerciseLap;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseSegment;
import androidx.health.connect.client.records.SkinTemperatureRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.records.metadata.Device;
import androidx.health.connect.client.units.Length;
import androidx.health.connect.client.units.LengthKt;
import androidx.health.connect.client.units.TemperatureDelta;
import androidx.health.platform.client.proto.DataProto;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a7\u0010\u0011\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a%\u0010\u0005\u001a\u00020\u0003*\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0014\u001a%\u0010\b\u001a\u00020\u0007*\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\u0015\u001a\u0013\u0010\u0018\u001a\u00020\u0017*\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b*\u00020\u001aH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0019\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001b*\u00020\u001aH\u0000¢\u0006\u0004\b \u0010\u001e\u001a\u0019\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001b*\u00020\u001aH\u0000¢\u0006\u0004\b\"\u0010\u001e\u001a\u0019\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u001b*\u00020\u001aH\u0000¢\u0006\u0004\b$\u0010\u001e\u001a\u0019\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u001b*\u00020\u001aH\u0000¢\u0006\u0004\b&\u0010\u001e\"\u0015\u0010+\u001a\u00020(*\u00020'8F¢\u0006\u0006\u001a\u0004\b)\u0010*\"\u0015\u0010-\u001a\u00020(*\u00020'8F¢\u0006\u0006\u001a\u0004\b,\u0010*\"\u0015\u0010/\u001a\u00020(*\u00020'8F¢\u0006\u0006\u001a\u0004\b.\u0010*\"\u0017\u00103\u001a\u0004\u0018\u000100*\u00020'8F¢\u0006\u0006\u001a\u0004\b1\u00102\"\u0017\u00105\u001a\u0004\u0018\u000100*\u00020'8F¢\u0006\u0006\u001a\u0004\b4\u00102\"\u0017\u00107\u001a\u0004\u0018\u000100*\u00020'8F¢\u0006\u0006\u001a\u0004\b6\u00102\"\u0015\u0010;\u001a\u000208*\u00020'8F¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Landroidx/health/platform/client/proto/DataProto$DataPointOrBuilder;", "", SDKConstants.PARAM_KEY, "", "defaultVal", "getLong", "(Landroidx/health/platform/client/proto/DataProto$DataPointOrBuilder;Ljava/lang/String;J)J", "", "getDouble", "(Landroidx/health/platform/client/proto/DataProto$DataPointOrBuilder;Ljava/lang/String;D)D", "getString", "(Landroidx/health/platform/client/proto/DataProto$DataPointOrBuilder;Ljava/lang/String;)Ljava/lang/String;", "getEnum", "", "", "stringToIntMap", "default", "mapEnum", "(Landroidx/health/platform/client/proto/DataProto$DataPointOrBuilder;Ljava/lang/String;Ljava/util/Map;I)I", "Landroidx/health/platform/client/proto/DataProto$SeriesValueOrBuilder;", "(Landroidx/health/platform/client/proto/DataProto$SeriesValueOrBuilder;Ljava/lang/String;J)J", "(Landroidx/health/platform/client/proto/DataProto$SeriesValueOrBuilder;Ljava/lang/String;D)D", "Landroidx/health/platform/client/proto/DataProto$Device;", "Landroidx/health/connect/client/records/metadata/Device;", "toDevice", "(Landroidx/health/platform/client/proto/DataProto$Device;)Landroidx/health/connect/client/records/metadata/Device;", "Landroidx/health/platform/client/proto/DataProto$DataPoint$SubTypeDataList;", "", "Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "toDeltasList", "(Landroidx/health/platform/client/proto/DataProto$DataPoint$SubTypeDataList;)Ljava/util/List;", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "toStageList", "Landroidx/health/connect/client/records/ExerciseSegment;", "toSegmentList", "Landroidx/health/connect/client/records/ExerciseLap;", "toLapList", "Landroidx/health/connect/client/records/ExerciseRoute$Location;", "toLocationList", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "j$/time/Instant", "getStartTime", "(Landroidx/health/platform/client/proto/DataProto$DataPoint;)Lj$/time/Instant;", "startTime", "getEndTime", SDKConstants.PARAM_END_TIME, "getTime", "time", "j$/time/ZoneOffset", "getStartZoneOffset", "(Landroidx/health/platform/client/proto/DataProto$DataPoint;)Lj$/time/ZoneOffset;", "startZoneOffset", "getEndZoneOffset", "endZoneOffset", "getZoneOffset", "zoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "(Landroidx/health/platform/client/proto/DataProto$DataPoint;)Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ProtoToRecordUtilsKt {
    public static final double getDouble(DataProto.DataPointOrBuilder dataPointOrBuilder, String str, double d) {
        dataPointOrBuilder.getClass();
        str.getClass();
        DataProto.Value value = dataPointOrBuilder.getValuesMap().get(str);
        return value != null ? value.getDoubleVal() : d;
    }

    public static /* synthetic */ double getDouble$default(DataProto.DataPointOrBuilder dataPointOrBuilder, String str, double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = 0.0d;
        }
        return getDouble(dataPointOrBuilder, str, d);
    }

    public static final Instant getEndTime(DataProto.DataPoint dataPoint) {
        dataPoint.getClass();
        Instant instantOfEpochMilli = Instant.ofEpochMilli(dataPoint.getEndTimeMillis());
        instantOfEpochMilli.getClass();
        return instantOfEpochMilli;
    }

    public static final ZoneOffset getEndZoneOffset(DataProto.DataPoint dataPoint) {
        dataPoint.getClass();
        if (dataPoint.hasEndZoneOffsetSeconds()) {
            return ZoneOffset.ofTotalSeconds(dataPoint.getEndZoneOffsetSeconds());
        }
        return null;
    }

    public static final String getEnum(DataProto.DataPointOrBuilder dataPointOrBuilder, String str) {
        dataPointOrBuilder.getClass();
        str.getClass();
        DataProto.Value value = dataPointOrBuilder.getValuesMap().get(str);
        if (value != null) {
            return value.getEnumVal();
        }
        return null;
    }

    public static final long getLong(DataProto.DataPointOrBuilder dataPointOrBuilder, String str, long j) {
        dataPointOrBuilder.getClass();
        str.getClass();
        DataProto.Value value = dataPointOrBuilder.getValuesMap().get(str);
        return value != null ? value.getLongVal() : j;
    }

    public static /* synthetic */ long getLong$default(DataProto.DataPointOrBuilder dataPointOrBuilder, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return getLong(dataPointOrBuilder, str, j);
    }

    public static final androidx.health.connect.client.records.metadata.Metadata getMetadata(DataProto.DataPoint dataPoint) {
        dataPoint.getClass();
        String uid = dataPoint.hasUid() ? dataPoint.getUid() : "";
        uid.getClass();
        String applicationId = dataPoint.getDataOrigin().getApplicationId();
        applicationId.getClass();
        DataOrigin dataOrigin = new DataOrigin(applicationId);
        Instant instantOfEpochMilli = Instant.ofEpochMilli(dataPoint.getUpdateTimeMillis());
        instantOfEpochMilli.getClass();
        Device device = null;
        String clientId = dataPoint.hasClientId() ? dataPoint.getClientId() : null;
        long clientVersion = dataPoint.getClientVersion();
        if (dataPoint.hasDevice()) {
            DataProto.Device device2 = dataPoint.getDevice();
            device2.getClass();
            device = toDevice(device2);
        }
        return new androidx.health.connect.client.records.metadata.Metadata(dataPoint.getRecordingMethod(), uid, dataOrigin, instantOfEpochMilli, clientId, clientVersion, device);
    }

    public static final Instant getStartTime(DataProto.DataPoint dataPoint) {
        dataPoint.getClass();
        Instant instantOfEpochMilli = Instant.ofEpochMilli(dataPoint.getStartTimeMillis());
        instantOfEpochMilli.getClass();
        return instantOfEpochMilli;
    }

    public static final ZoneOffset getStartZoneOffset(DataProto.DataPoint dataPoint) {
        dataPoint.getClass();
        if (dataPoint.hasStartZoneOffsetSeconds()) {
            return ZoneOffset.ofTotalSeconds(dataPoint.getStartZoneOffsetSeconds());
        }
        return null;
    }

    public static final String getString(DataProto.DataPointOrBuilder dataPointOrBuilder, String str) {
        dataPointOrBuilder.getClass();
        str.getClass();
        DataProto.Value value = dataPointOrBuilder.getValuesMap().get(str);
        if (value != null) {
            return value.getStringVal();
        }
        return null;
    }

    public static final Instant getTime(DataProto.DataPoint dataPoint) {
        dataPoint.getClass();
        Instant instantOfEpochMilli = Instant.ofEpochMilli(dataPoint.getInstantTimeMillis());
        instantOfEpochMilli.getClass();
        return instantOfEpochMilli;
    }

    public static final ZoneOffset getZoneOffset(DataProto.DataPoint dataPoint) {
        dataPoint.getClass();
        if (dataPoint.hasZoneOffsetSeconds()) {
            return ZoneOffset.ofTotalSeconds(dataPoint.getZoneOffsetSeconds());
        }
        return null;
    }

    public static final int mapEnum(DataProto.DataPointOrBuilder dataPointOrBuilder, String str, Map<String, Integer> map, int i) {
        dataPointOrBuilder.getClass();
        str.getClass();
        map.getClass();
        String str2 = getEnum(dataPointOrBuilder, str);
        return str2 == null ? i : map.getOrDefault(str2, Integer.valueOf(i)).intValue();
    }

    public static final List<SkinTemperatureRecord.Delta> toDeltasList(DataProto.DataPoint.SubTypeDataList subTypeDataList) {
        subTypeDataList.getClass();
        List<DataProto.SubTypeDataValue> valuesList = subTypeDataList.getValuesList();
        valuesList.getClass();
        List<DataProto.SubTypeDataValue> list = valuesList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DataProto.SubTypeDataValue subTypeDataValue : list) {
            Instant instantOfEpochMilli = Instant.ofEpochMilli(subTypeDataValue.getStartTimeMillis());
            instantOfEpochMilli.getClass();
            TemperatureDelta.Companion companion = TemperatureDelta.INSTANCE;
            DataProto.Value value = subTypeDataValue.getValuesMap().get("temperatureDelta");
            arrayList.add(new SkinTemperatureRecord.Delta(instantOfEpochMilli, companion.celsius(value != null ? value.getDoubleVal() : 0.0d)));
        }
        return arrayList;
    }

    public static final Device toDevice(DataProto.Device device) {
        device.getClass();
        String manufacturer = device.hasManufacturer() ? device.getManufacturer() : null;
        String model = device.hasModel() ? device.getModel() : null;
        Map<String, Integer> device_type_string_to_int_map = DeviceTypeConvertersKt.getDEVICE_TYPE_STRING_TO_INT_MAP();
        String type = device.getType();
        type.getClass();
        return new Device(device_type_string_to_int_map.getOrDefault(type, 0).intValue(), manufacturer, model);
    }

    public static final List<ExerciseLap> toLapList(DataProto.DataPoint.SubTypeDataList subTypeDataList) {
        subTypeDataList.getClass();
        List<DataProto.SubTypeDataValue> valuesList = subTypeDataList.getValuesList();
        valuesList.getClass();
        List<DataProto.SubTypeDataValue> list = valuesList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DataProto.SubTypeDataValue subTypeDataValue : list) {
            Instant instantOfEpochMilli = Instant.ofEpochMilli(subTypeDataValue.getStartTimeMillis());
            instantOfEpochMilli.getClass();
            Instant instantOfEpochMilli2 = Instant.ofEpochMilli(subTypeDataValue.getEndTimeMillis());
            instantOfEpochMilli2.getClass();
            DataProto.Value value = subTypeDataValue.getValuesMap().get("length");
            arrayList.add(new ExerciseLap(instantOfEpochMilli, instantOfEpochMilli2, value != null ? LengthKt.getMeters(value.getDoubleVal()) : null));
        }
        return arrayList;
    }

    public static final List<ExerciseRoute.Location> toLocationList(DataProto.DataPoint.SubTypeDataList subTypeDataList) {
        subTypeDataList.getClass();
        List<DataProto.SubTypeDataValue> valuesList = subTypeDataList.getValuesList();
        valuesList.getClass();
        List<DataProto.SubTypeDataValue> list = valuesList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DataProto.SubTypeDataValue subTypeDataValue : list) {
            Instant instantOfEpochMilli = Instant.ofEpochMilli(subTypeDataValue.getStartTimeMillis());
            instantOfEpochMilli.getClass();
            DataProto.Value value = subTypeDataValue.getValuesMap().get("latitude");
            double doubleVal = value != null ? value.getDoubleVal() : 0.0d;
            DataProto.Value value2 = subTypeDataValue.getValuesMap().get("longitude");
            double doubleVal2 = value2 != null ? value2.getDoubleVal() : 0.0d;
            DataProto.Value value3 = subTypeDataValue.getValuesMap().get("altitude");
            Length meters = null;
            Length meters2 = value3 != null ? LengthKt.getMeters(value3.getDoubleVal()) : null;
            DataProto.Value value4 = subTypeDataValue.getValuesMap().get("horizontal_accuracy");
            Length meters3 = value4 != null ? LengthKt.getMeters(value4.getDoubleVal()) : null;
            DataProto.Value value5 = subTypeDataValue.getValuesMap().get("vertical_accuracy");
            if (value5 != null) {
                meters = LengthKt.getMeters(value5.getDoubleVal());
            }
            arrayList.add(new ExerciseRoute.Location(instantOfEpochMilli, doubleVal, doubleVal2, meters3, meters, meters2));
        }
        return arrayList;
    }

    public static final List<ExerciseSegment> toSegmentList(DataProto.DataPoint.SubTypeDataList subTypeDataList) {
        subTypeDataList.getClass();
        List<DataProto.SubTypeDataValue> valuesList = subTypeDataList.getValuesList();
        valuesList.getClass();
        List<DataProto.SubTypeDataValue> list = valuesList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DataProto.SubTypeDataValue subTypeDataValue : list) {
            Instant instantOfEpochMilli = Instant.ofEpochMilli(subTypeDataValue.getStartTimeMillis());
            instantOfEpochMilli.getClass();
            Instant instantOfEpochMilli2 = Instant.ofEpochMilli(subTypeDataValue.getEndTimeMillis());
            instantOfEpochMilli2.getClass();
            DataProto.Value value = subTypeDataValue.getValuesMap().get("type");
            int longVal = 0;
            int iIntValue = (value != null ? Long.valueOf(value.getLongVal()) : 0).intValue();
            DataProto.Value value2 = subTypeDataValue.getValuesMap().get("reps");
            if (value2 != null) {
                longVal = (int) value2.getLongVal();
            }
            arrayList.add(new ExerciseSegment(instantOfEpochMilli, instantOfEpochMilli2, iIntValue, longVal));
        }
        return arrayList;
    }

    public static final List<SleepSessionRecord.Stage> toStageList(DataProto.DataPoint.SubTypeDataList subTypeDataList) {
        subTypeDataList.getClass();
        List<DataProto.SubTypeDataValue> valuesList = subTypeDataList.getValuesList();
        valuesList.getClass();
        List<DataProto.SubTypeDataValue> list = valuesList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DataProto.SubTypeDataValue subTypeDataValue : list) {
            Instant instantOfEpochMilli = Instant.ofEpochMilli(subTypeDataValue.getStartTimeMillis());
            instantOfEpochMilli.getClass();
            Instant instantOfEpochMilli2 = Instant.ofEpochMilli(subTypeDataValue.getEndTimeMillis());
            instantOfEpochMilli2.getClass();
            Map<String, Integer> map = SleepSessionRecord.STAGE_TYPE_STRING_TO_INT_MAP;
            DataProto.Value value = subTypeDataValue.getValuesMap().get("stage");
            Integer num = map.get(value != null ? value.getEnumVal() : null);
            arrayList.add(new SleepSessionRecord.Stage(instantOfEpochMilli, instantOfEpochMilli2, num != null ? num.intValue() : 0));
        }
        return arrayList;
    }

    public static /* synthetic */ double getDouble$default(DataProto.SeriesValueOrBuilder seriesValueOrBuilder, String str, double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = 0.0d;
        }
        return getDouble(seriesValueOrBuilder, str, d);
    }

    public static /* synthetic */ long getLong$default(DataProto.SeriesValueOrBuilder seriesValueOrBuilder, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return getLong(seriesValueOrBuilder, str, j);
    }

    public static final double getDouble(DataProto.SeriesValueOrBuilder seriesValueOrBuilder, String str, double d) {
        seriesValueOrBuilder.getClass();
        str.getClass();
        DataProto.Value value = seriesValueOrBuilder.getValuesMap().get(str);
        return value != null ? value.getDoubleVal() : d;
    }

    public static final long getLong(DataProto.SeriesValueOrBuilder seriesValueOrBuilder, String str, long j) {
        seriesValueOrBuilder.getClass();
        str.getClass();
        DataProto.Value value = seriesValueOrBuilder.getValuesMap().get(str);
        return value != null ? value.getLongVal() : j;
    }
}
