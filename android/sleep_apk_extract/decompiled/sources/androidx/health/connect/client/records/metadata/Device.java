package androidx.health.connect.client.records.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0012\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0010R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\u0010¨\u0006\u0019"}, d2 = {"Landroidx/health/connect/client/records/metadata/Device;", "", "", "type", "", "manufacturer", DeviceRequestsHelper.DEVICE_INFO_MODEL, "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "I", "getType", "getType$annotations", "()V", "Ljava/lang/String;", "getManufacturer", "getModel", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Device {
    private final String manufacturer;
    private final String model;
    private final int type;

    public Device(int i, String str, String str2) {
        this.type = i;
        this.manufacturer = str;
        this.model = str2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(Device.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        Device device = (Device) other;
        return this.type == device.type && Intrinsics.areEqual(this.manufacturer, device.manufacturer) && Intrinsics.areEqual(this.model, device.model);
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getModel() {
        return this.model;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.manufacturer;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.model;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Device(type=");
        sb.append(this.type);
        sb.append(", manufacturer=");
        sb.append(this.manufacturer);
        sb.append(", model=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.model, ')');
    }
}
