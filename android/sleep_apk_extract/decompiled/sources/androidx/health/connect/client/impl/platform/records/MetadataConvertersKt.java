package androidx.health.connect.client.impl.platform.records;

import android.health.connect.datatypes.DataOrigin;
import android.health.connect.datatypes.Device;
import android.health.connect.datatypes.Metadata;
import j$.time.Instant;
import j$.time.TimeConversions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00060\u0006j\u0002`\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\t*\u00060\nj\u0002`\u000bH\u0000\u001a\u0010\u0010\f\u001a\u00060\u0002j\u0002`\u0003*\u00020\u0001H\u0000\u001a\u0010\u0010\r\u001a\u00060\nj\u0002`\u000b*\u00020\tH\u0000\u001a\u0010\u0010\u000e\u001a\u00060\u0006j\u0002`\u0007*\u00020\u0005H\u0000¨\u0006\u000f"}, d2 = {"toSdkMetadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "Landroid/health/connect/datatypes/Metadata;", "Landroidx/health/connect/client/impl/platform/records/PlatformMetadata;", "toSdkDevice", "Landroidx/health/connect/client/records/metadata/Device;", "Landroid/health/connect/datatypes/Device;", "Landroidx/health/connect/client/impl/platform/records/PlatformDevice;", "toSdkDataOrigin", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "Landroid/health/connect/datatypes/DataOrigin;", "Landroidx/health/connect/client/impl/platform/records/PlatformDataOrigin;", "toPlatformMetadata", "toPlatformDataOrigin", "toPlatformDevice", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class MetadataConvertersKt {
    public static final DataOrigin toPlatformDataOrigin(androidx.health.connect.client.records.metadata.DataOrigin dataOrigin) {
        dataOrigin.getClass();
        DataOrigin.Builder builder = new DataOrigin.Builder();
        builder.setPackageName(dataOrigin.getPackageName());
        DataOrigin dataOriginBuild = builder.build();
        dataOriginBuild.getClass();
        return dataOriginBuild;
    }

    public static final Device toPlatformDevice(androidx.health.connect.client.records.metadata.Device device) {
        device.getClass();
        Device.Builder builder = new Device.Builder();
        builder.setType(device.getType());
        String manufacturer = device.getManufacturer();
        if (manufacturer != null) {
            builder.setManufacturer(manufacturer);
        }
        String model = device.getModel();
        if (model != null) {
            builder.setModel(model);
        }
        Device deviceBuild = builder.build();
        deviceBuild.getClass();
        return deviceBuild;
    }

    public static final android.health.connect.datatypes.Metadata toPlatformMetadata(androidx.health.connect.client.records.metadata.Metadata metadata) {
        Device platformDevice;
        metadata.getClass();
        Metadata.Builder builder = new Metadata.Builder();
        androidx.health.connect.client.records.metadata.Device device = metadata.getDevice();
        if (device != null && (platformDevice = toPlatformDevice(device)) != null) {
            builder.setDevice(platformDevice);
        }
        builder.setLastModifiedTime(TimeConversions.convert(metadata.getLastModifiedTime()));
        builder.setId(metadata.getId());
        builder.setDataOrigin(toPlatformDataOrigin(metadata.getDataOrigin()));
        builder.setClientRecordId(metadata.getClientRecordId());
        builder.setClientRecordVersion(metadata.getClientRecordVersion());
        builder.setRecordingMethod(IntDefMappingsKt.toPlatformRecordingMethod(metadata.getRecordingMethod()));
        android.health.connect.datatypes.Metadata metadataBuild = builder.build();
        metadataBuild.getClass();
        return metadataBuild;
    }

    public static final androidx.health.connect.client.records.metadata.DataOrigin toSdkDataOrigin(DataOrigin dataOrigin) {
        dataOrigin.getClass();
        String packageName = dataOrigin.getPackageName();
        packageName.getClass();
        return new androidx.health.connect.client.records.metadata.DataOrigin(packageName);
    }

    public static final androidx.health.connect.client.records.metadata.Device toSdkDevice(Device device) {
        device.getClass();
        if (Intrinsics.areEqual(device, new Device.Builder().build())) {
            return null;
        }
        return new androidx.health.connect.client.records.metadata.Device(IntDefMappingsKt.toSdkDevice(device.getType()), device.getManufacturer(), device.getModel());
    }

    public static final androidx.health.connect.client.records.metadata.Metadata toSdkMetadata(android.health.connect.datatypes.Metadata metadata) {
        metadata.getClass();
        String id = metadata.getId();
        id.getClass();
        DataOrigin dataOrigin = metadata.getDataOrigin();
        dataOrigin.getClass();
        androidx.health.connect.client.records.metadata.DataOrigin sdkDataOrigin = toSdkDataOrigin(dataOrigin);
        Instant instantConvert = TimeConversions.convert(metadata.getLastModifiedTime());
        instantConvert.getClass();
        String clientRecordId = metadata.getClientRecordId();
        long clientRecordVersion = metadata.getClientRecordVersion();
        int sdkRecordingMethod = IntDefMappingsKt.toSdkRecordingMethod(metadata.getRecordingMethod());
        Device device = metadata.getDevice();
        device.getClass();
        return new androidx.health.connect.client.records.metadata.Metadata(sdkRecordingMethod, id, sdkDataOrigin, instantConvert, clientRecordId, clientRecordVersion, toSdkDevice(device));
    }
}
