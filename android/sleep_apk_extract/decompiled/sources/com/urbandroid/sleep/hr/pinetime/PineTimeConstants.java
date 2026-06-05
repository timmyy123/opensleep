package com.urbandroid.sleep.hr.pinetime;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/hr/pinetime/PineTimeConstants;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PineTimeConstants {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UUID PINE_TIME_ACCEL_CHARACTERISTIC_ID;
    private static final UUID PINE_TIME_ACCEL_SERVICE_ID;
    private static final UUID PINE_TIME_ALERT_CHARACTERISTIC_ID;
    private static final UUID PINE_TIME_ALERT_SERVICE_ID;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/hr/pinetime/PineTimeConstants$Companion;", "", "<init>", "()V", "PINE_TIME_DEVICE_NAME", "", "PINE_TIME_ACCEL_SERVICE_ID", "Ljava/util/UUID;", "getPINE_TIME_ACCEL_SERVICE_ID", "()Ljava/util/UUID;", "PINE_TIME_ACCEL_CHARACTERISTIC_ID", "getPINE_TIME_ACCEL_CHARACTERISTIC_ID", "PINE_TIME_ALERT_SERVICE_ID", "getPINE_TIME_ALERT_SERVICE_ID", "PINE_TIME_ALERT_CHARACTERISTIC_ID", "getPINE_TIME_ALERT_CHARACTERISTIC_ID", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UUID getPINE_TIME_ACCEL_CHARACTERISTIC_ID() {
            return PineTimeConstants.PINE_TIME_ACCEL_CHARACTERISTIC_ID;
        }

        public final UUID getPINE_TIME_ACCEL_SERVICE_ID() {
            return PineTimeConstants.PINE_TIME_ACCEL_SERVICE_ID;
        }

        public final UUID getPINE_TIME_ALERT_CHARACTERISTIC_ID() {
            return PineTimeConstants.PINE_TIME_ALERT_CHARACTERISTIC_ID;
        }

        public final UUID getPINE_TIME_ALERT_SERVICE_ID() {
            return PineTimeConstants.PINE_TIME_ALERT_SERVICE_ID;
        }

        private Companion() {
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("00030000-78fc-48fe-8e23-433b3a1942d0");
        uuidFromString.getClass();
        PINE_TIME_ACCEL_SERVICE_ID = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("00030002-78fc-48fe-8e23-433b3a1942d0");
        uuidFromString2.getClass();
        PINE_TIME_ACCEL_CHARACTERISTIC_ID = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("00001802-0000-1000-8000-00805f9b34fb");
        uuidFromString3.getClass();
        PINE_TIME_ALERT_SERVICE_ID = uuidFromString3;
        UUID uuidFromString4 = UUID.fromString("00002a06-0000-1000-8000-00805f9b34fb");
        uuidFromString4.getClass();
        PINE_TIME_ALERT_CHARACTERISTIC_ID = uuidFromString4;
    }
}
