package androidx.health.connect.client.records.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import j$.time.Instant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\u0018\u0000 ,2\u00020\u0001:\u0001,BQ\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b%\u0010\u0018R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Landroidx/health/connect/client/records/metadata/Metadata;", "", "", "recordingMethod", "", "id", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "dataOrigin", "j$/time/Instant", "lastModifiedTime", "clientRecordId", "", "clientRecordVersion", "Landroidx/health/connect/client/records/metadata/Device;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "<init>", "(ILjava/lang/String;Landroidx/health/connect/client/records/metadata/DataOrigin;Lj$/time/Instant;Ljava/lang/String;JLandroidx/health/connect/client/records/metadata/Device;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "I", "getRecordingMethod", "getRecordingMethod$annotations", "()V", "Ljava/lang/String;", "getId", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "getDataOrigin", "()Landroidx/health/connect/client/records/metadata/DataOrigin;", "Lj$/time/Instant;", "getLastModifiedTime", "()Lj$/time/Instant;", "getClientRecordId", "J", "getClientRecordVersion", "()J", "Landroidx/health/connect/client/records/metadata/Device;", "getDevice", "()Landroidx/health/connect/client/records/metadata/Device;", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Metadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String clientRecordId;
    private final long clientRecordVersion;
    private final DataOrigin dataOrigin;
    private final Device device;
    private final String id;
    private final Instant lastModifiedTime;
    private final int recordingMethod;

    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0007\u0010\rR\u0014\u0010\u000e\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Landroidx/health/connect/client/records/metadata/Metadata$Companion;", "", "<init>", "()V", "Landroidx/health/connect/client/records/metadata/Device;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Landroidx/health/connect/client/records/metadata/Metadata;", "activelyRecorded", "(Landroidx/health/connect/client/records/metadata/Device;)Landroidx/health/connect/client/records/metadata/Metadata;", "", "clientRecordId", "", "clientRecordVersion", "(Landroidx/health/connect/client/records/metadata/Device;Ljava/lang/String;J)Landroidx/health/connect/client/records/metadata/Metadata;", "EMPTY_ID", "Ljava/lang/String;", "", "RECORDING_METHOD_UNKNOWN", "I", "RECORDING_METHOD_ACTIVELY_RECORDED", "RECORDING_METHOD_AUTOMATICALLY_RECORDED", "RECORDING_METHOD_MANUAL_ENTRY", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Metadata activelyRecorded$default(Companion companion, Device device, String str, long j, int i, Object obj) {
            if ((i & 4) != 0) {
                j = 0;
            }
            return companion.activelyRecorded(device, str, j);
        }

        public final Metadata activelyRecorded(Device device, String clientRecordId, long clientRecordVersion) {
            device.getClass();
            clientRecordId.getClass();
            return new Metadata(1, null, null, null, clientRecordId, clientRecordVersion, device, 14, null);
        }

        private Companion() {
        }

        public final Metadata activelyRecorded(Device device) {
            device.getClass();
            return new Metadata(1, null, null, null, null, 0L, device, 62, null);
        }
    }

    public /* synthetic */ Metadata(int i, String str, DataOrigin dataOrigin, Instant instant, String str2, long j, Device device, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? new DataOrigin("") : dataOrigin, (i2 & 8) != 0 ? Instant.EPOCH : instant, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? 0L : j, (i2 & 64) != 0 ? null : device);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Metadata)) {
            return false;
        }
        Metadata metadata = (Metadata) other;
        return Intrinsics.areEqual(this.id, metadata.id) && Intrinsics.areEqual(this.dataOrigin, metadata.dataOrigin) && Intrinsics.areEqual(this.lastModifiedTime, metadata.lastModifiedTime) && Intrinsics.areEqual(this.clientRecordId, metadata.clientRecordId) && this.clientRecordVersion == metadata.clientRecordVersion && Intrinsics.areEqual(this.device, metadata.device) && this.recordingMethod == metadata.recordingMethod;
    }

    public final String getClientRecordId() {
        return this.clientRecordId;
    }

    public final long getClientRecordVersion() {
        return this.clientRecordVersion;
    }

    public final DataOrigin getDataOrigin() {
        return this.dataOrigin;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final String getId() {
        return this.id;
    }

    public final Instant getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final int getRecordingMethod() {
        return this.recordingMethod;
    }

    public int hashCode() {
        int iHashCode = (this.lastModifiedTime.hashCode() + ((this.dataOrigin.hashCode() + (this.id.hashCode() * 31)) * 31)) * 31;
        String str = this.clientRecordId;
        int iHashCode2 = (Long.hashCode(this.clientRecordVersion) + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31;
        Device device = this.device;
        return Integer.hashCode(this.recordingMethod) + ((iHashCode2 + (device != null ? device.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(id='");
        sb.append(this.id);
        sb.append("', dataOrigin=");
        sb.append(this.dataOrigin);
        sb.append(", lastModifiedTime=");
        sb.append(this.lastModifiedTime);
        sb.append(", clientRecordId=");
        sb.append(this.clientRecordId);
        sb.append(", clientRecordVersion=");
        sb.append(this.clientRecordVersion);
        sb.append(", device=");
        sb.append(this.device);
        sb.append(", recordingMethod=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.recordingMethod, ')');
    }

    public Metadata(int i, String str, DataOrigin dataOrigin, Instant instant, String str2, long j, Device device) {
        str.getClass();
        dataOrigin.getClass();
        instant.getClass();
        this.recordingMethod = i;
        this.id = str;
        this.dataOrigin = dataOrigin;
        this.lastModifiedTime = instant;
        this.clientRecordId = str2;
        this.clientRecordVersion = j;
        this.device = device;
    }
}
