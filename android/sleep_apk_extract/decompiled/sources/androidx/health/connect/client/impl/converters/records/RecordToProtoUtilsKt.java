package androidx.health.connect.client.impl.converters.records;

import androidx.health.connect.client.records.ExerciseLap;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseSegment;
import androidx.health.connect.client.records.InstantaneousRecord;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.SkinTemperatureRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.metadata.Device;
import androidx.health.connect.client.units.Length;
import androidx.health.platform.client.proto.DataProto;
import j$.time.Instant;
import j$.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0005*\u00020\bH\u0000\u001a\u0014\u0010\t\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a\f\u0010\f\u001a\u00020\u000f*\u00020\u0010H\u0000\u001a\f\u0010\f\u001a\u00020\u000f*\u00020\u0011H\u0000\u001a\f\u0010\f\u001a\u00020\u000f*\u00020\u0012H\u0000\u001a\f\u0010\f\u001a\u00020\u000f*\u00020\u0013H\u0000\u001a\f\u0010\f\u001a\u00020\u000f*\u00020\u0014H\u0000¨\u0006\u0015"}, d2 = {"protoDataType", "Landroidx/health/platform/client/proto/DataProto$DataType;", "dataTypeName", "", "instantaneousProto", "Landroidx/health/platform/client/proto/DataProto$DataPoint$Builder;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "intervalProto", "Landroidx/health/connect/client/records/IntervalRecord;", "setMetadata", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "toProto", "Landroidx/health/platform/client/proto/DataProto$Device;", "Landroidx/health/connect/client/records/metadata/Device;", "Landroidx/health/platform/client/proto/DataProto$SubTypeDataValue;", "Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "Landroidx/health/connect/client/records/ExerciseSegment;", "Landroidx/health/connect/client/records/ExerciseLap;", "Landroidx/health/connect/client/records/ExerciseRoute$Location;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class RecordToProtoUtilsKt {
    public static final DataProto.DataPoint.Builder instantaneousProto(InstantaneousRecord instantaneousRecord) {
        instantaneousRecord.getClass();
        DataProto.DataPoint.Builder builderNewBuilder = DataProto.DataPoint.newBuilder();
        builderNewBuilder.getClass();
        DataProto.DataPoint.Builder instantTimeMillis = setMetadata(builderNewBuilder, instantaneousRecord.getMetadata()).setInstantTimeMillis(instantaneousRecord.getTime().toEpochMilli());
        ZoneOffset zoneOffset = instantaneousRecord.getZoneOffset();
        if (zoneOffset != null) {
            instantTimeMillis.setZoneOffsetSeconds(zoneOffset.getTotalSeconds());
        }
        instantTimeMillis.getClass();
        return instantTimeMillis;
    }

    public static final DataProto.DataPoint.Builder intervalProto(IntervalRecord intervalRecord) {
        intervalRecord.getClass();
        DataProto.DataPoint.Builder builderNewBuilder = DataProto.DataPoint.newBuilder();
        builderNewBuilder.getClass();
        DataProto.DataPoint.Builder endTimeMillis = setMetadata(builderNewBuilder, intervalRecord.getMetadata()).setStartTimeMillis(intervalRecord.getStartTime().toEpochMilli()).setEndTimeMillis(intervalRecord.getEndTime().toEpochMilli());
        ZoneOffset startZoneOffset = intervalRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            endTimeMillis.setStartZoneOffsetSeconds(startZoneOffset.getTotalSeconds());
        }
        ZoneOffset endZoneOffset = intervalRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            endTimeMillis.setEndZoneOffsetSeconds(endZoneOffset.getTotalSeconds());
        }
        endTimeMillis.getClass();
        return endTimeMillis;
    }

    public static final DataProto.DataType protoDataType(String str) {
        str.getClass();
        DataProto.DataType dataTypeBuild = DataProto.DataType.newBuilder().setName(str).build();
        dataTypeBuild.getClass();
        return dataTypeBuild;
    }

    private static final DataProto.DataPoint.Builder setMetadata(DataProto.DataPoint.Builder builder, androidx.health.connect.client.records.metadata.Metadata metadata) {
        if (!Intrinsics.areEqual(metadata.getId(), "")) {
            builder.setUid(metadata.getId());
        }
        if (metadata.getDataOrigin().getPackageName().length() > 0) {
            builder.setDataOrigin(DataProto.DataOrigin.newBuilder().setApplicationId(metadata.getDataOrigin().getPackageName()).build());
        }
        if (metadata.getLastModifiedTime().isAfter(Instant.EPOCH)) {
            builder.setUpdateTimeMillis(metadata.getLastModifiedTime().toEpochMilli());
        }
        String clientRecordId = metadata.getClientRecordId();
        if (clientRecordId != null) {
            builder.setClientId(clientRecordId);
        }
        if (metadata.getClientRecordVersion() > 0) {
            builder.setClientVersion(metadata.getClientRecordVersion());
        }
        Device device = metadata.getDevice();
        if (device != null) {
            builder.setDevice(toProto(device));
        }
        if (metadata.getRecordingMethod() > 0) {
            builder.setRecordingMethod(metadata.getRecordingMethod());
        }
        return builder;
    }

    public static final DataProto.SubTypeDataValue toProto(ExerciseRoute.Location location) {
        location.getClass();
        DataProto.SubTypeDataValue.Builder builderPutValues = DataProto.SubTypeDataValue.newBuilder().setStartTimeMillis(location.getTime().toEpochMilli()).setEndTimeMillis(location.getTime().toEpochMilli()).putValues("latitude", ValueExtKt.doubleVal(location.getLatitude())).putValues("longitude", ValueExtKt.doubleVal(location.getLongitude()));
        Length horizontalAccuracy = location.getHorizontalAccuracy();
        if (horizontalAccuracy != null) {
            builderPutValues.putValues("horizontal_accuracy", ValueExtKt.doubleVal(horizontalAccuracy.getMeters()));
        }
        Length verticalAccuracy = location.getVerticalAccuracy();
        if (verticalAccuracy != null) {
            builderPutValues.putValues("vertical_accuracy", ValueExtKt.doubleVal(verticalAccuracy.getMeters()));
        }
        Length altitude = location.getAltitude();
        if (altitude != null) {
            builderPutValues.putValues("altitude", ValueExtKt.doubleVal(altitude.getMeters()));
        }
        DataProto.SubTypeDataValue subTypeDataValueBuild = builderPutValues.build();
        subTypeDataValueBuild.getClass();
        return subTypeDataValueBuild;
    }

    public static final DataProto.SubTypeDataValue toProto(SkinTemperatureRecord.Delta delta) {
        delta.getClass();
        DataProto.SubTypeDataValue subTypeDataValueBuild = DataProto.SubTypeDataValue.newBuilder().setStartTimeMillis(delta.getTime().toEpochMilli()).setEndTimeMillis(delta.getTime().toEpochMilli()).putValues("temperatureDelta", ValueExtKt.doubleVal(delta.getDelta().getCelsius())).build();
        subTypeDataValueBuild.getClass();
        return subTypeDataValueBuild;
    }

    public static final DataProto.SubTypeDataValue toProto(SleepSessionRecord.Stage stage) {
        stage.getClass();
        DataProto.SubTypeDataValue.Builder endTimeMillis = DataProto.SubTypeDataValue.newBuilder().setStartTimeMillis(stage.getStartTime().toEpochMilli()).setEndTimeMillis(stage.getEndTime().toEpochMilli());
        DataProto.Value valueEnumValFromInt = ValueExtKt.enumValFromInt(stage.getStage(), SleepSessionRecord.STAGE_TYPE_INT_TO_STRING_MAP);
        if (valueEnumValFromInt != null) {
            endTimeMillis.putValues("stage", valueEnumValFromInt);
        }
        DataProto.SubTypeDataValue subTypeDataValueBuild = endTimeMillis.build();
        subTypeDataValueBuild.getClass();
        return subTypeDataValueBuild;
    }

    public static final DataProto.SubTypeDataValue toProto(ExerciseSegment exerciseSegment) {
        exerciseSegment.getClass();
        DataProto.SubTypeDataValue subTypeDataValueBuild = DataProto.SubTypeDataValue.newBuilder().setStartTimeMillis(exerciseSegment.getStartTime().toEpochMilli()).setEndTimeMillis(exerciseSegment.getEndTime().toEpochMilli()).putValues("type", ValueExtKt.longVal(exerciseSegment.getSegmentType())).putValues("reps", ValueExtKt.longVal(exerciseSegment.getRepetitions())).build();
        subTypeDataValueBuild.getClass();
        return subTypeDataValueBuild;
    }

    public static final DataProto.SubTypeDataValue toProto(ExerciseLap exerciseLap) {
        exerciseLap.getClass();
        DataProto.SubTypeDataValue.Builder endTimeMillis = DataProto.SubTypeDataValue.newBuilder().setStartTimeMillis(exerciseLap.getStartTime().toEpochMilli()).setEndTimeMillis(exerciseLap.getEndTime().toEpochMilli());
        Length length = exerciseLap.getLength();
        if (length != null) {
            endTimeMillis.putValues("length", ValueExtKt.doubleVal(length.getMeters()));
        }
        DataProto.SubTypeDataValue subTypeDataValueBuild = endTimeMillis.build();
        subTypeDataValueBuild.getClass();
        return subTypeDataValueBuild;
    }

    public static final DataProto.Device toProto(Device device) {
        device.getClass();
        DataProto.Device.Builder builderNewBuilder = DataProto.Device.newBuilder();
        String manufacturer = device.getManufacturer();
        if (manufacturer != null) {
            builderNewBuilder.setManufacturer(manufacturer);
        }
        String model = device.getModel();
        if (model != null) {
            builderNewBuilder.setModel(model);
        }
        builderNewBuilder.setType(DeviceTypeConvertersKt.getDEVICE_TYPE_INT_TO_STRING_MAP().getOrDefault(Integer.valueOf(device.getType()), "UNKNOWN"));
        DataProto.Device deviceBuild = builderNewBuilder.build();
        deviceBuild.getClass();
        return deviceBuild;
    }
}
