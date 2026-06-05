package com.urbandroid.sleep.hr.generic;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/hr/generic/BLEHRConstants;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class BLEHRConstants {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UUID GENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID;
    private static final UUID GENERIC_HR_SERVICE_ID;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/hr/generic/BLEHRConstants$Companion;", "", "<init>", "()V", "GENERIC_HR_SERVICE_ID", "Ljava/util/UUID;", "getGENERIC_HR_SERVICE_ID", "()Ljava/util/UUID;", "GENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID", "getGENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UUID getGENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID() {
            return BLEHRConstants.GENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID;
        }

        public final UUID getGENERIC_HR_SERVICE_ID() {
            return BLEHRConstants.GENERIC_HR_SERVICE_ID;
        }

        private Companion() {
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("0000180d-0000-1000-8000-00805f9b34fb");
        uuidFromString.getClass();
        GENERIC_HR_SERVICE_ID = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("00002a37-0000-1000-8000-00805f9b34fb");
        uuidFromString2.getClass();
        GENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID = uuidFromString2;
    }
}
