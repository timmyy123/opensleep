package com.polar.androidcommunications.api.ble.model.gatt.client;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/HealthThermometer;", "", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class HealthThermometer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UUID HTS_SERVICE;
    private static final UUID TEMPERATURE_MEASUREMENT;
    private static final UUID TEMPERATURE_TYPE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/HealthThermometer$Companion;", "", "<init>", "()V", "Ljava/util/UUID;", "HTS_SERVICE", "Ljava/util/UUID;", "getHTS_SERVICE", "()Ljava/util/UUID;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UUID getHTS_SERVICE() {
            return HealthThermometer.HTS_SERVICE;
        }

        private Companion() {
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("00001809-0000-1000-8000-00805f9b34fb");
        uuidFromString.getClass();
        HTS_SERVICE = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("00002A1C-0000-1000-8000-00805f9b34fb");
        uuidFromString2.getClass();
        TEMPERATURE_MEASUREMENT = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("00002A1D-0000-1000-8000-00805f9b34fb");
        uuidFromString3.getClass();
        TEMPERATURE_TYPE = uuidFromString3;
    }
}
